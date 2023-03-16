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
