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

/**
 * 辅助class，反向追溯时保存每一步状态信息
 */
public class ExtendedState {
    /**
     * candidate point
     */
    private final CandidatePoint state;
    /**
     * 反向指针，指向之前的extendedState
     */
    private final ExtendedState backPointer;
    /**
     * 原始轨迹点
     */
    private final GPSPoint observation;

    /**
     * 构造函数
     *
     * @param state                candidate point
     * @param backPointer          向后的指针
     * @param observation          原始point
     */
    public ExtendedState(CandidatePoint state, ExtendedState backPointer, GPSPoint observation) {
        this.state = state;
        this.backPointer = backPointer;
        this.observation = observation;
    }

    public CandidatePoint getState() {
        return state;
    }

    public ExtendedState getBackPointer() {
        return backPointer;
    }

    public GPSPoint getObservation() {
        return observation;
    }
}
