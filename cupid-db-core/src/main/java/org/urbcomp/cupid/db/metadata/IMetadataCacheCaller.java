package org.urbcomp.cupid.db.metadata;

import org.urbcomp.cupid.db.metadata.entity.Database;
import org.urbcomp.cupid.db.metadata.entity.Table;

/**
 * set cache
 *
 * @author jimo
 **/
public interface IMetadataCacheCaller extends IMetadataAccessor {

    boolean setTableCache(String userName, String dbName, String tableName, Table table);

    boolean setTableCache(long dbId, String tableName, Table table);

    boolean setDatabaseCache(String userName, String dbName, Database database);

    boolean delDatabaseCache(String userName, String dbName);


}
