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
package org.urbcomp.cupid.db.metadata.accessor;

import org.urbcomp.cupid.db.metadata.MetadataAccessUtil;
import org.urbcomp.cupid.db.metadata.entity.Database;
import org.urbcomp.cupid.db.metadata.mapper.DatabaseMapper;

/**
 * This class is the implementation class of IAccessor.The basic functions of metadata interaction
 * of databases are realized.
 *
 * @author WangBohong
 * @date 2022-05-21
 */
public class DatabaseAccessor implements IAccessor<Database, DatabaseMapper> {

    @Override
    public DatabaseMapper getMapper() {
        return MetadataAccessUtil.getSqlSession().getMapper(DatabaseMapper.class);
    }

    public boolean isNotValid(Database db) {
        // make sure dbName does not exist.
        return getMapper().selectByFidAndName(db.getUserId(), db.getName()) != null;
    }
}
