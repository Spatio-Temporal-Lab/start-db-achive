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

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.urbcomp.cupid.db.model.data.DataExportType;

import static org.junit.Assert.*;

public class SparkSqlParamTest {

    @Test
    public void testSerializeSparkParam() throws JsonProcessingException {
        final SparkSqlParam param = new SparkSqlParam();
        final String userName = "jimo";
        final DataExportType exportType = DataExportType.PRINT;
        final String db = "db";
        final String hbaseZookeepers = "localhost:2181";
        final String sql = "select 1+1";

        param.setUserName(userName);
        param.setDbName(db);
        param.setAsync(true);
        param.setHbaseZookeepers(hbaseZookeepers);
        param.setLocal(true);
        param.setSql(sql);
        param.setExportType(exportType);

        final String s = JacksonUtil.MAPPER.writeValueAsString(param);
        assertEquals(
            "{\"userName\":\"jimo\",\"dbName\":\"db\",\"sql\":\"select 1+1\",\"exportType\":\"PRINT\",\"hbaseZookeepers\":\"localhost:2181\",\"async\":true,\"local\":true}",
            s
        );

        final String encodeStr = Base64Util.encode(s);
        final String decodeStr = Base64Util.decode(encodeStr);
        assertEquals(s, decodeStr);

        final SparkSqlParam param2 = JacksonUtil.MAPPER.readValue(s, SparkSqlParam.class);
        assertEquals(userName, param2.getUserName());
        assertEquals(db, param2.getDbName());
        assertEquals(exportType, param2.getExportType());
        assertEquals(hbaseZookeepers, param2.getHbaseZookeepers());
        assertEquals(sql, param2.getSql());
        assertTrue(param2.isAsync());
        assertTrue(param2.isLocal());
    }
}
