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

import org.urbcomp.cupid.db.metadata.accessor.DatabaseAccessor;
import org.urbcomp.cupid.db.metadata.accessor.FieldAccessor;
import org.urbcomp.cupid.db.metadata.accessor.TableAccessor;
import org.urbcomp.cupid.db.metadata.accessor.UserAccessor;
import org.urbcomp.cupid.db.metadata.entity.Database;
import org.urbcomp.cupid.db.metadata.entity.Field;
import org.urbcomp.cupid.db.metadata.entity.Table;
import org.urbcomp.cupid.db.metadata.entity.User;

import java.util.ArrayList;
import java.util.List;

import static org.urbcomp.cupid.db.metadata.MetadataAccessUtil.noRollback;

/**
 * @author jimo
 **/
public class MetadataAccessorFromDb implements IMetadataAccessor {

    @Override
    public long insertField(Field field) {
        return noRollback(v -> AccessorFactory.getFieldAccessor().insert(field));
    }

    @Override
    public List<Field> getFields(String userName, String dbName, String tableName) {
        return noRollback(v -> {
            Table table = getTable(userName, dbName, tableName);
            if (table == null) return null;
            FieldAccessor fieldAccessor = AccessorFactory.getFieldAccessor();
            List<Field> fields = fieldAccessor.selectAllByFid(table.getId());
            fields.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
            return fields;
        });
    }

    @Override
    public Table getTable(String userName, String dbName, String tableName) {
        return noRollback(v -> {
            final Database database = getDatabase(userName, dbName);
            if (database == null) return null;
            return getTable(database.getId(), tableName);
        });
    }

    @Override
    public Table getTable(long dbId, String tableName) {
        return noRollback(v -> {
            TableAccessor tableAccessor = AccessorFactory.getTableAccessor();
            return tableAccessor.selectByFidAndName(dbId, tableName);
        });
    }

    @Override
    public boolean tableVerify(String userName, String dbName, String tableName) {
        return getTable(userName, dbName, tableName) != null;
    }

    @Override
    public long insertTable(Table table) {
        return noRollback(v -> AccessorFactory.getTableAccessor().insert(table));
    }

    @Override
    public long dropTable(String userName, String dbName, String tableName) {
        return noRollback(v -> {
            final Table table = getTable(userName, dbName, tableName);
            if (table == null) {
                return 0L;
            }
            final long tableId = table.getId();
            TableAccessor tableAccessor = AccessorFactory.getTableAccessor();
            final long res = tableAccessor.deleteById(tableId);
            AccessorFactory.getFieldAccessor().deleteByFid(tableId);
            return res;
        });
    }

    @Override
    public List<Table> getTables(String userName, String dbName) {
        return noRollback(v -> {
            final Database database = getDatabase(userName, dbName);
            if (database == null) {
                return new ArrayList<>(1);
            }
            TableAccessor tableAccessor = AccessorFactory.getTableAccessor();
            return tableAccessor.selectAllByFid(database.getId());
        });
    }

    @Override
    public Database getDatabase(String userName, String dbName) {
        return noRollback(v -> {
            UserAccessor userAccessor = AccessorFactory.getUserAccessor();
            DatabaseAccessor databaseAccessor = AccessorFactory.getDatabaseAccessor();
            User user = userAccessor.selectByFidAndName(0L, userName);
            if (user == null) return null;
            return databaseAccessor.selectByFidAndName(user.getId(), dbName);
        });
    }

    @Override
    public long insertDatabase(Database database) {
        return noRollback(v -> AccessorFactory.getDatabaseAccessor().insert(database));
    }

    @Override
    public long dropDatabase(String userName, String dbName) {
        return noRollback(v -> {
            final Database db = getDatabase(userName, dbName);
            if (db == null) {
                return 0L;
            }
            final long dbId = db.getId();
            DatabaseAccessor databaseAccessor = AccessorFactory.getDatabaseAccessor();
            final long res = databaseAccessor.deleteById(dbId);
            TableAccessor tableAccessor = AccessorFactory.getTableAccessor();
            tableAccessor.deleteByFid(dbId);
            return res;
        });
    }

    @Override
    public List<Database> getDatabases(String userName) {
        return noRollback(v -> {
            final User user = getUser(userName);
            if (user == null) {
                return new ArrayList<>(1);
            }
            DatabaseAccessor databaseAccessor = AccessorFactory.getDatabaseAccessor();
            return databaseAccessor.selectAllByFid(user.getId());
        });
    }

    @Override
    public User getUser(String userName) {
        return noRollback(
            v -> AccessorFactory.getUserAccessor().selectByFidAndName(-1 /* not used */, userName)
        );
    }

    @Override
    public long insertUser(User user) {
        return noRollback(v -> AccessorFactory.getUserAccessor().insert(user));
    }

    @Override
    public long dropUser(String userName) {
        return 0;
    }
}
