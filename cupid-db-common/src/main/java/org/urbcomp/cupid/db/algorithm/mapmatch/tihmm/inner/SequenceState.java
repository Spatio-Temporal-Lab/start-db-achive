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
import org.urbcomp.cupid.db.model.point.GPSPoint;

/**
 * 辅助class，保存状态信息
 */
public class SequenceState {
    /**
     * 原始point的candidate
     */
    private final CandidatePoint state;
    /**
     * 原始point
     */
    private final GPSPoint observation;

    /**
     * 构造函数
     * @param state 原始point的candidate
     * @param observation 原始point
     */
    public SequenceState(CandidatePoint state, GPSPoint observation) {
        this.state = state;
        this.observation = observation;
    }

    public CandidatePoint getState() {
        return state;
    }

    public GPSPoint getObservation() {
        return observation;
    }

}
