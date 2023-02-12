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
