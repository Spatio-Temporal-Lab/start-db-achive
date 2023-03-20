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
