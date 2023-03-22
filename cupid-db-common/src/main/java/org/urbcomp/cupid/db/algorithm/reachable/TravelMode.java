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
package org.urbcomp.cupid.db.algorithm.reachable;

public enum TravelMode {
    // 未定义
    UNDEFINED("undefined"),
    // 汽车
    DRIVE("drive"),
    // 自行车
    RIDE("ride"),
    // 步行
    WALK("walk");

    private final String text;

    TravelMode(String text) {
        this.text = text;
    }

    public static TravelMode fromString(String text) {
        for (TravelMode tm : TravelMode.values()) {
            if (tm.text.equalsIgnoreCase(text)) {
                return tm;
            }
        }
        throw new IllegalArgumentException("Travel mode should be drive, walk, or ride");
    }
}
