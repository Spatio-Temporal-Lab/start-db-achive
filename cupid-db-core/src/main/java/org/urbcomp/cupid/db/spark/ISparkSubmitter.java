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
package org.urbcomp.cupid.db.spark;

import org.urbcomp.cupid.db.spark.livy.LivySubmitter;
import org.urbcomp.cupid.db.util.SparkSqlParam;

import java.util.concurrent.TimeoutException;

/**
 * @author jimo
 **/
public interface ISparkSubmitter {

    static ISparkSubmitter getInstance() {
        return new LivySubmitter();
    }

    /**
     * 提交到spark
     *
     * @return sqlId
     */
    SubmitResult submit(SparkSqlParam param);

    /**
     * 同步等待执行完成
     */
    void waitToFinish(SubmitResult res) throws TimeoutException;
}
