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

package org.urbcomp.start.db.util;

import com.alibaba.fastjson.JSONArray;

import java.util.List;

public class TrajStringToList {
    /**
     * 将sql查询得到的轨迹段字符串转换成列表形式以适配fromGeoJSON函数
     * @param traj 轨迹字符串
     * @return List<String> 轨迹段字符串列表
     */
    public static List<String> stringToList(String traj) {
        return JSONArray.parseArray(traj, String.class);
    }
}
