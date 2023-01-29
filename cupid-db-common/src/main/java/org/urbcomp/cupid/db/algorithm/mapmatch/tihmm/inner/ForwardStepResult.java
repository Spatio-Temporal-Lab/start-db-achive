/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.cupid.db.algorithm.mapmatch.tihmm.inner;

import org.urbcomp.cupid.db.model.point.CandidatePoint;

import java.util.HashMap;
import java.util.Map;

/**
 * 辅助class，保存顺向推演时的状态信息
 */

public class ForwardStepResult {
    /**
     * 更新candidate point 后新的概率
     */
    private final Map<CandidatePoint, Double> newMessage;
    /**
     * 根据新的candidate point 指向新的extended state
     */
    private final Map<CandidatePoint, ExtendedState> newExtendedStates;

    public ForwardStepResult(int numberStates) {
        newMessage = new HashMap<>(numberStates);
        newExtendedStates = new HashMap<>(numberStates);
    }

    public Map<CandidatePoint, Double> getNewMessage() {
        return newMessage;
    }

    public Map<CandidatePoint, ExtendedState> getNewExtendedStates() {
        return newExtendedStates;
    }
}
