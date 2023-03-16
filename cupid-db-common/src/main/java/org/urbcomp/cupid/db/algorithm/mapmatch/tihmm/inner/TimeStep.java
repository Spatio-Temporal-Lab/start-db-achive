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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 辅助class，保存状态信息
 */
public class TimeStep {
    /**
     * 原始轨迹点
     */
    private final GPSPoint observation;
    /**
     * 轨迹点对应的candidate point列表
     */
    private final List<CandidatePoint> candidates;
    /**
     * 每一个candidate point对应的emission概率
     */
    private final Map<CandidatePoint, Double> emissionLogProbabilities = new HashMap<>();
    /**
     * <candidatePt,candidatePt>为索引 (transition) Tuple2<fromCandidatePoint, toCandidatePoint>
     */
    private final Map<Tuple2<CandidatePoint, CandidatePoint>, Double> transitionLogProbabilities =
        new HashMap<>();

    /**
     * @param observation point
     * @param candidates  candidate point
     */
    public TimeStep(GPSPoint observation, List<CandidatePoint> candidates) {
        if (observation == null || candidates == null) {
            throw new NullPointerException("Observation and candidates must not be null.");
        }
        this.observation = observation;
        this.candidates = candidates;
    }

    /**
     * 添加 emission 概率
     * @param candidate candidate point
     * @param emissionLogProbability 对应的emission概率
     */
    public void addEmissionLogProbability(CandidatePoint candidate, Double emissionLogProbability) {
        if (emissionLogProbabilities.containsKey(candidate)) {
            throw new IllegalArgumentException("Candidate has already been added.");
        }
        emissionLogProbabilities.put(candidate, emissionLogProbability);
    }

    /**
     * 添加transition概率
     * @param fromPosition 之前的candidate point
     * @param toPosition 当前的candidate point
     * @param transitionLogProbability 给定的transition概率
     */
    public void addTransitionLogProbability(
        CandidatePoint fromPosition,
        CandidatePoint toPosition,
        Double transitionLogProbability
    ) {
        final Tuple2<CandidatePoint, CandidatePoint> transition = new Tuple2<>(
            fromPosition,
            toPosition
        );
        if (transitionLogProbabilities.containsKey(transition)) {
            throw new IllegalArgumentException("Transition has already been added.");
        }
        transitionLogProbabilities.put(transition, transitionLogProbability);
    }

    public GPSPoint getObservation() {
        return observation;
    }

    public List<CandidatePoint> getCandidates() {
        return candidates;
    }

    public Map<CandidatePoint, Double> getEmissionLogProbabilities() {
        return emissionLogProbabilities;
    }

    public Map<Tuple2<CandidatePoint, CandidatePoint>, Double> getTransitionLogProbabilities() {
        return transitionLogProbabilities;
    }
}
