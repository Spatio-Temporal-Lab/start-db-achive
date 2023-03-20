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
import org.urbcomp.cupid.db.metadata.entity.Table;
import org.urbcomp.cupid.db.metadata.mapper.TableMapper;
import org.urbcomp.cupid.db.util.UserDbTable;

import java.util.List;

/**
 * This class is the implementation class of IAccessor.The basic functions of metadata interaction
 * of tables are realized.
 *
 * @author Wang Bohong
 * @date 2022-05-21
 */
public class TableAccessor implements IAccessor<Table, TableMapper> {

    @Override
    public TableMapper getMapper() {
        return MetadataAccessUtil.getSqlSession().getMapper(TableMapper.class);
    }

    @Override
    public boolean isNotValid(Table entity) {
        return getMapper().selectByFidAndName(entity.getDbId(), entity.getName()) != null;
    }

    public List<UserDbTable> getAllUserDbTable() {
        return getMapper().getAllUserDbTable();
    }
}
