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

public enum RoadSegmentLevel {
    // 未定义
    UNDEFINED(-1),
    // 高架桥
    ELEVATED_ROAD(0),
    // 高速路
    HIGH_WAY_ROAD(1),
    // 国道
    NATIONAL_ROAD(2),
    // 省道
    PROVINCIAL_ROAD(3),
    // 乡道
    COUNTRY_ROAD(4),
    // 城市主道路
    MAIN_ROAD(5),
    // 城市一般道路
    URBAN_ROAD(6),
    // 闹市区道路
    DOWNTOWN_ROAD(7),
    // 居民区道路
    RESIDENTIAL_ROAD(8),
    // 人行道
    SIDEWALK_ROAD(9);

    private final int value;

    RoadSegmentLevel(int value) {
        this.value = value;
    }

    public static RoadSegmentLevel valueOf(int value) {
        for (RoadSegmentLevel type : values()) {
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
