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
package org.urbcomp.cupid.db.util;

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
