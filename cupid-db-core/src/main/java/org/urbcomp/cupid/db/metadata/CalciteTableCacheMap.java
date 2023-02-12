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

import org.apache.calcite.schema.Table;
import org.urbcomp.cupid.db.geomesa.GeomesaTable;
import org.urbcomp.cupid.db.util.MetadataUtil;
import org.urbcomp.cupid.db.util.UserDbTable;

/**
 * supply dynamic table metadata for calcite
 *
 * @author jimo
 **/
public class CalciteTableCacheMap {

    public static Table getTable(String key) {
        // split key , key must be user.db.table
        final UserDbTable udt = MetadataUtil.splitUserDbTable(key);
        final org.urbcomp.cupid.db.metadata.entity.Table table = MetadataAccessUtil.getTable(
            udt.getUsername(),
            udt.getDbName(),
            udt.getTableName()
        );

        if (table == null) {
            throw new IllegalArgumentException("Table Not Found: " + udt);
        }
        return new GeomesaTable(udt.getUsername(), udt.getDbName(), udt.getTableName());
    }
}
