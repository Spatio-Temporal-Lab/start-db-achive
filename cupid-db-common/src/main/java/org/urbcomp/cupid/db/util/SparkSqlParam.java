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

package org.urbcomp.cupid.db.util;

/**
 * @author jimo
 **/
public class SparkSqlParam extends SqlParam {

    public static final ThreadLocal<SparkSqlParam> CACHE = new ThreadLocal<>();

    private String hbaseZookeepers;
    /**
     * 是否异步执行
     */
    private boolean async;

    public String getHbaseZookeepers() {
        return hbaseZookeepers;
    }

    public void setHbaseZookeepers(String hbaseZookeepers) {
        this.hbaseZookeepers = hbaseZookeepers;
    }

    public boolean isAsync() {
        return async;
    }

    public void setAsync(boolean async) {
        this.async = async;
    }
}
