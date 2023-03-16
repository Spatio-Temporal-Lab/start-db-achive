/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.urbcomp.cupid.db.algorithm.mapmatch.tihmm.inner;

import org.urbcomp.cupid.db.model.point.CandidatePoint;
import org.urbcomp.cupid.db.model.point.GPSPoint;
import scala.Tuple2;

import java.util.*;

/**
 * Tihmm 核心算法class
 */
public class TiViterbi {
    /**
     * 上一个状态下每一个candidate point 对应的extended state
     */
    private Map<CandidatePoint, ExtendedState> lastExtendedStates;
    /**
     * 上一个状态下原始轨迹点对应的所有candidate point
     */
    private List<CandidatePoint> prevCandidates;
    /**
     * 每个candidate point 对应的p
     */
    public Map<CandidatePoint, Double> message;
    /**
     * 是否停止初始化状态概率函数
     */
    public Boolean isBroken = false;

    /**
     * 初始状态概率函数
     *
     * @param observation             原始轨迹点
     * @param candidates              原始轨迹点对应的candidates
     * @param initialLogProbabilities 初始状态概率
     */
    private void initializeStateProbabilities(
        GPSPoint observation,
        List<CandidatePoint> candidates,
        Map<CandidatePoint, Double> initialLogProbabilities
    ) {
        if (message != null) {
            throw new IllegalArgumentException("Initial probabilities have already been set.");
        }
        Map<CandidatePoint, Double> initialMessage = new HashMap<>(initialLogProbabilities.size());
        for (CandidatePoint candidate : candidates) {
            if (!initialLogProbabilities.containsKey(candidate)) {
                throw new IllegalArgumentException("No initial probability for " + candidate);
            }
            double logProbability = initialLogProbabilities.get(candidate);
            initialMessage.put(candidate, logProbability);
        }
        isBroken = hmmBreak(initialMessage);
        if (isBroken) {
            return;
        }
        message = initialMessage;
        lastExtendedStates = new HashMap<>(candidates.size());
        prevCandidates = new ArrayList<>(candidates.size());
        for (CandidatePoint candidate : candidates) {
            lastExtendedStates.put(candidate, new ExtendedState(candidate, null, observation));
            prevCandidates.add(candidate);
        }
    }

    /**
     * 如果初始化的概率有接近武无穷小的，停止初始化
     *
     * @param message 状态概率
     */
    private Boolean hmmBreak(Map<CandidatePoint, Double> message) {
        for (Double logProbability : message.values()) {
            if (!logProbability.equals(Double.NEGATIVE_INFINITY)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 开始viterbi计算，向前extend
     *
     * @param observation                原始轨迹点
     * @param prevCandidates             之前的candidates
     * @param curCandidates              当前的candidates
     * @param message                    状态概率
     * @param emissionLogProbabilities   emission p
     * @param transitionLogProbabilities transition p
     * @return 向前extend后的结果
     */
    private ForwardStepResult forwardStep(
        GPSPoint observation,
        List<CandidatePoint> prevCandidates,
        List<CandidatePoint> curCandidates,
        Map<CandidatePoint, Double> message,
        Map<CandidatePoint, Double> emissionLogProbabilities,
        Map<Tuple2<CandidatePoint, CandidatePoint>, Double> transitionLogProbabilities
    ) {
        final ForwardStepResult result = new ForwardStepResult(curCandidates.size());
        assert prevCandidates.size() != 0;
        for (CandidatePoint curState : curCandidates) {
            double maxLogProbability = Double.NEGATIVE_INFINITY;
            CandidatePoint maxPreState = null;
            for (CandidatePoint preState : prevCandidates) {
                final double logProbability = message.get(preState) + transitionLogProbability(
                    preState,
                    curState,
                    transitionLogProbabilities
                );
                if (logProbability > maxLogProbability) {
                    maxLogProbability = logProbability;
                    maxPreState = preState;
                }
            }
            result.getNewMessage()
                .put(curState, (maxLogProbability + emissionLogProbabilities.get(curState)));
            // Note that max_prev_state == None if there is no transition with non-zero probability.
            // In this case cur_state has zero probability and will not be part of the most likely
            // sequence,
            // so we don't need an ExtendedState.
            if (maxPreState != null) {
                final ExtendedState extendedState = new ExtendedState(
                    curState,
                    lastExtendedStates.get(maxPreState),
                    observation
                );
                result.getNewExtendedStates().put(curState, extendedState);
            }
        }
        return result;
    }

    /**
     * 给定transition 计算对应概率
     *
     * @param preState                   之前的state
     * @param curState                   现在的state
     * @param transitionLogProbabilities 转移概率的map
     * @return 概率p
     */
    private double transitionLogProbability(
        CandidatePoint preState,
        CandidatePoint curState,
        Map<Tuple2<CandidatePoint, CandidatePoint>, Double> transitionLogProbabilities
    ) {
        Tuple2<CandidatePoint, CandidatePoint> transition = new Tuple2<>(preState, curState);
        return transitionLogProbabilities.getOrDefault(transition, Double.NEGATIVE_INFINITY);
    }

    /**
     * 计算当前状态下概率最大对应的state
     *
     * @return candidate point
     */
    private CandidatePoint mostLikelyState() {
        assert message.size() != 0;
        CandidatePoint result = null;
        Double maxLogProbability = Double.NEGATIVE_INFINITY;
        for (Map.Entry<CandidatePoint, Double> entry : message.entrySet()) {
            if (entry.getValue() > maxLogProbability) {
                result = entry.getKey();
                maxLogProbability = entry.getValue();
            }
        }
        assert result != null;
        return result;
    }

    /**
     * 取回概率最大的一系列转移过程
     *
     * @return list，包含每一步转移对应的状态
     */
    private List<SequenceState> retrieveMostLikelySequence() {
        assert message.size() != 0;
        CandidatePoint lastState = mostLikelyState();
        List<SequenceState> result = new ArrayList<>();
        ExtendedState es = lastExtendedStates.get(lastState);
        while (es != null) {
            SequenceState ss = new SequenceState(es.getState(), es.getObservation());
            result.add(ss);
            es = es.getBackPointer();
        }
        Collections.reverse(result);
        return result;
    }

    /**
     * 初始化启动第一步viterbi计算
     *
     * @param observation              原始轨迹点
     * @param candidates               对应的candidates
     * @param emissionLogProbabilities 每一个candidate对应的 emission p
     */
    public void startWithInitialObservation(
        GPSPoint observation,
        List<CandidatePoint> candidates,
        Map<CandidatePoint, Double> emissionLogProbabilities
    ) {
        initializeStateProbabilities(observation, candidates, emissionLogProbabilities);
    }

    /**
     * 向下一步viterbi计算， 更新当前状态的信息
     *
     * @param observation                原始轨迹点
     * @param candidates                 对应的candidates
     * @param emissionLogProbabilities   每一个candidate对应的 emission p
     * @param transitionLogProbabilities 每一个transition对应的 transition p
     */
    public void nextStep(
        GPSPoint observation,
        List<CandidatePoint> candidates,
        Map<CandidatePoint, Double> emissionLogProbabilities,
        Map<Tuple2<CandidatePoint, CandidatePoint>, Double> transitionLogProbabilities
    ) {
        if (message == null) {
            throw new IllegalStateException(
                "start with initial observation() must be called first."
            );
        }
        if (isBroken) {
            throw new IllegalStateException("Method must not be called after an HMM break.");
        }
        ForwardStepResult forwardStepResult = forwardStep(
            observation,
            prevCandidates,
            candidates,
            message,
            emissionLogProbabilities,
            transitionLogProbabilities
        );
        isBroken = hmmBreak(forwardStepResult.getNewMessage());
        if (isBroken) {
            return;
        }
        message = forwardStepResult.getNewMessage();
        lastExtendedStates = forwardStepResult.getNewExtendedStates();
        prevCandidates = new ArrayList<>(candidates);
    }

    /**
     * 辅助函数，下概率最大对应的每一步的extended state 组成的list
     *
     * @return list 包含每一步对应的extended state
     */
    public List<SequenceState> computeMostLikelySequence() {
        if (message == null) {
            return new ArrayList<>();
        } else {
            return retrieveMostLikelySequence();
        }
    }
}
