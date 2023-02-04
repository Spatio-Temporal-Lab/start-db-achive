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
