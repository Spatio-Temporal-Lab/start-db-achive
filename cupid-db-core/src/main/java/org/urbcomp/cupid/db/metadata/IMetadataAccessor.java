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

package org.urbcomp.cupid.db.metadata;

import org.urbcomp.cupid.db.metadata.entity.Database;
import org.urbcomp.cupid.db.metadata.entity.Field;
import org.urbcomp.cupid.db.metadata.entity.Table;
import org.urbcomp.cupid.db.metadata.entity.User;

import java.util.List;

public interface IMetadataAccessor {

    long insertField(Field field);

    List<Field> getFields(String userName, String dbName, String tableName);

    Table getTable(String userName, String dbName, String tableName);

    Table getTable(long dbId, String tableName);

    boolean tableVerify(String userName, String dbName, String tableName);

    long insertTable(Table table);

    long dropTable(String userName, String dbName, String tableName);

    List<Table> getTables(String userName, String dbName);

    Database getDatabase(String userName, String dbName);

    long insertDatabase(Database database);

    long dropDatabase(String userName, String dbName);

    List<Database> getDatabases(String userName);

    User getUser(String userName);

    long insertUser(User user);

    long dropUser(String userName);
}
