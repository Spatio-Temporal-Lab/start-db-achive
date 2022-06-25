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

package org.urbcomp.start.db.metadata;

import org.urbcomp.start.db.metadata.accessor.DatabaseAccessor;
import org.urbcomp.start.db.metadata.accessor.FieldAccessor;
import org.urbcomp.start.db.metadata.accessor.TableAccessor;
import org.urbcomp.start.db.metadata.accessor.UserAccessor;
import org.urbcomp.start.db.metadata.entity.Database;
import org.urbcomp.start.db.metadata.entity.Field;
import org.urbcomp.start.db.metadata.entity.Table;
import org.urbcomp.start.db.metadata.entity.User;

import java.util.List;

/**
 * utils of metadata verify
 * @author Wang Bohong
 * @date 2022-06-22
 */
public class MetadataVerifyUtil {

    /**
     * check if table exists
     * @param userName user name
     * @param dbName    db name
     * @param tableName table name
     * @return isValid
     */
    public static boolean tableVerify(String userName, String dbName, String tableName) {
        return getTable(userName, dbName, tableName) != null;
    }

    /**
     * get field list of the table
     * @param userName user name
     * @param dbName db name
     * @param tableName table name
     * @return field list
     */
    public static List<Field> getFields(String userName, String dbName, String tableName) {
        Table table = getTable(userName, dbName, tableName);
        if (table == null) return null;
        FieldAccessor fieldAccessor = AccessorFactory.getFieldAccessor();
        List<Field> fields = fieldAccessor.selectAllByFid(table.getId(), true);
        fields.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
        return fields;
    }

    /**
     * get table from metadata
     */
    public static Table getTable(String userName, String dbName, String tableName) {
        UserAccessor userAccessor = AccessorFactory.getUserAccessor();
        DatabaseAccessor databaseAccessor = AccessorFactory.getDatabaseAccessor();
        TableAccessor tableAccessor = AccessorFactory.getTableAccessor();
        User user = userAccessor.selectByFidAndName(0L, userName, true);
        if (user == null) return null;
        Database database = databaseAccessor.selectByFidAndName(user.getId(), dbName, true);
        if (database == null) return null;
        return tableAccessor.selectByFidAndName(database.getId(), tableName, true);
    }
}
