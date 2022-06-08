/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 2 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.start.db.model.roadsegment;

public enum RoadSegmentDirection {
    // 未定义
    UNDEFINED(-1),
    // dual way, i.e., bi-directional
    DUAL(1),
    // forward way
    FORWARD(2),
    // backward way
    BACKWARD(3);

    private final int value;

    RoadSegmentDirection(int value) {
        this.value = value;
    }

    public static RoadSegmentDirection valueOf(int value) {
        for (RoadSegmentDirection type : values()) {
            if (type.value() == value) {
                return type;
            }
        }
        return null;
    }

    public int value() {
        return this.value;
    }
}
