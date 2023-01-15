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

package org.urbcomp.start.db.exception;

public class AlgorithmExecuteException extends Exception {
    /**
     * 产生异常的语句
     */
    private final String exceptionSrc;

    /**
     * 构造函数
     *
     * @param exceptionSrc 产生异常的语句
     */
    public AlgorithmExecuteException(String exceptionSrc) {
        this.exceptionSrc = exceptionSrc;
    }

    @Override
    public String toString() {
        return String.format("Algorithm execution failed: %s", this.exceptionSrc);
    }

    @Override
    public String getMessage() {
        return this.toString();
    }
}
