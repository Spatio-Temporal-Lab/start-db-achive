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
package org.urbcomp.cupid.db.metadata;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.urbcomp.cupid.db.metadata.entity.Database;
import org.urbcomp.cupid.db.metadata.entity.Field;
import org.urbcomp.cupid.db.metadata.entity.Table;
import org.urbcomp.cupid.db.metadata.entity.User;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author jimo
 **/
public class MetadataAccessorFromCaffeineCache implements IMetadataCacheCaller {

    private final IMetadataAccessor real;
    private final LoadingCache<String, User> USER_CACHE = Caffeine.newBuilder()
        .expireAfterAccess(1, TimeUnit.HOURS)
        .maximumSize(256)
        .build(new CacheLoader<String, User>() {
            @CheckForNull
            @Override
            public User load(@Nonnull String username) throws Exception {
                return real.getUser(username);
            }
        });

    private final LoadingCache<String, Database> DB_CACHE = Caffeine.newBuilder()
        .initialCapacity(16)
        .maximumSize(256)
        .expireAfterAccess(10, TimeUnit.MINUTES)
        .build(new CacheLoader<String, Database>() {
            @CheckForNull
            @Override
            public Database load(@Nonnull String key) throws Exception {
                final String[] items = key.split(SPLITTER);
                return real.getDatabase(items[0], items[1]);
            }
        });

    private final LoadingCache<String, Table> TABLE_CACHE = Caffeine.newBuilder()
        .initialCapacity(16)
        .maximumSize(256)
        .expireAfterAccess(10, TimeUnit.MINUTES)
        .build(new CacheLoader<String, Table>() {
            @CheckForNull
            @Override
            public Table load(@Nonnull String key) throws Exception {
                final String[] items = key.split(SPLITTER);
                if (items.length >= 3) {
                    return real.getTable(items[0], items[1], items[2]);
                }
                return real.getTable(Long.parseLong(items[0]), items[1]);
            }
        });

    public MetadataAccessorFromCaffeineCache(IMetadataAccessor real) {
        this.real = real;
    }

    private final static String SPLITTER = "#";

    private String buildCacheKey(String... items) {
        return String.join(SPLITTER, items);
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
        return TABLE_CACHE.get(buildCacheKey(userName, dbName, tableName));
    }

    @Override
    public Table getTable(long dbId, String tableName) {
        return TABLE_CACHE.get(buildCacheKey(dbId + "", tableName));
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
        TABLE_CACHE.invalidate(buildCacheKey(userName, dbName, tableName));
        return real.dropTable(userName, dbName, tableName);
    }

    @Override
    public List<Table> getTables(String userName, String dbName) {
        return real.getTables(userName, dbName);
    }

    @Override
    public Database getDatabase(String userName, String dbName) {
        return DB_CACHE.get(buildCacheKey(userName, dbName));
    }

    @Override
    public long insertDatabase(Database database) {
        return real.insertDatabase(database);
    }

    @Override
    public long dropDatabase(String userName, String dbName) {
        DB_CACHE.invalidate(buildCacheKey(userName, dbName));
        return real.dropDatabase(userName, dbName);
    }

    @Override
    public List<Database> getDatabases(String userName) {
        return real.getDatabases(userName);
    }

    @Override
    public User getUser(String userName) {
        return USER_CACHE.get(userName);
    }

    @Override
    public long insertUser(User user) {
        return real.insertUser(user);
    }

    @Override
    public long dropUser(String userName) {
        USER_CACHE.invalidate(userName);
        return real.dropUser(userName);
    }

    @Override
    public boolean setTableCache(String userName, String dbName, String tableName, Table table) {
        TABLE_CACHE.put(buildCacheKey(userName, dbName, tableName), table);
        return true;
    }

    @Override
    public boolean setTableCache(long dbId, String tableName, Table table) {
        TABLE_CACHE.put(buildCacheKey(dbId + "", tableName), table);
        return true;
    }

    @Override
    public boolean setDatabaseCache(String userName, String dbName, Database database) {
        DB_CACHE.put(buildCacheKey(userName, dbName), database);
        return true;
    }

    @Override
    public boolean delDatabaseCache(String userName, String dbName) {
        DB_CACHE.invalidate(buildCacheKey(userName, dbName));
        return true;
    }
}
