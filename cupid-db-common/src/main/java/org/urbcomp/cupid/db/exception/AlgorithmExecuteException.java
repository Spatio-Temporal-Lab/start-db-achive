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
package org.urbcomp.cupid.db.exception;

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
