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

/**
 * used when your cache has no default value loader mechanism like caffeine cache
 * eg, hashmap
 *
 * @author jimo
 **/
public class MetadataAccessorCombinator implements IMetadataAccessor {

    private final IMetadataAccessor real;
    private final IMetadataCacheCaller cache;

    public MetadataAccessorCombinator(IMetadataAccessor real, IMetadataCacheCaller cache) {
        this.real = real;
        this.cache = cache;
    }

    @Override
    public long insertField(Field field) {
        return real.insertField(field);
    }

    @Override
    public List<Field> getFields(String userName, String dbName, String tableName) {
        return real.getFields(userName, dbName, tableName);
    }

    @Override
    public Table getTable(String userName, String dbName, String tableName) {
        Table table = cache.getTable(userName, dbName, tableName);
        if (table == null) {
            table = real.getTable(userName, dbName, tableName);
            if (table != null) {
                cache.setTableCache(userName, dbName, tableName, table);
            }
        }
        return table;
    }

    @Override
    public Table getTable(long dbId, String tableName) {
        Table table = cache.getTable(dbId, tableName);
        if (table == null) {
            table = real.getTable(dbId, tableName);
            if (table != null) {
                cache.setTableCache(dbId, tableName, table);
            }
        }
        return table;
    }

    @Override
    public boolean tableVerify(String userName, String dbName, String tableName) {
        return getTable(userName, dbName, tableName) != null;
    }

    @Override
    public long insertTable(Table table) {
        return real.insertTable(table);
    }

    @Override
    public long dropTable(String userName, String dbName, String tableName) {
        cache.dropTable(userName, dbName, tableName);
        return real.dropTable(userName, dbName, tableName);
    }

    @Override
    public List<Table> getTables(String userName, String dbName) {
        return real.getTables(userName, dbName);
    }

    @Override
    public Database getDatabase(String userName, String dbName) {
        Database database = cache.getDatabase(userName, dbName);
        if (database == null) {
            database = real.getDatabase(userName, dbName);
            if (database != null) {
                cache.setDatabaseCache(userName, dbName, database);
            }
        }
        return database;
    }

    @Override
    public long insertDatabase(Database database) {
        return real.insertDatabase(database);
    }

    @Override
    public long dropDatabase(String userName, String dbName) {
        cache.dropDatabase(userName, dbName);
        return real.dropDatabase(userName, dbName);
    }

    @Override
    public List<Database> getDatabases(String userName) {
        return real.getDatabases(userName);
    }

    @Override
    public User getUser(String userName) {
        User user = cache.getUser(userName);
        if (user == null) {
            user = real.getUser(userName);
            if (user != null) {
                cache.insertUser(user);
            }
        }
        return user;
    }

    @Override
    public long insertUser(User user) {
        return real.insertUser(user);
    }

    @Override
    public long dropUser(String userName) {
        cache.dropUser(userName);
        return real.dropUser(userName);
    }
}
