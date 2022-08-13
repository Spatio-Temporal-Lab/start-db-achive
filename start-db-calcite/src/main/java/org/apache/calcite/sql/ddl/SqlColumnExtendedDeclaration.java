package org.apache.calcite.sql.ddl;

import org.apache.calcite.schema.ColumnStrategy;
import org.apache.calcite.sql.SqlDataTypeSpec;
import org.apache.calcite.sql.SqlIdentifier;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParserPos;
import org.urbcomp.start.db.index.SpatialIndexType;

public class SqlColumnExtendedDeclaration extends SqlColumnDeclaration {
    private final SpatialIndexType indexType;

    public SqlColumnExtendedDeclaration(
        SqlParserPos pos,
        SqlIdentifier name,
        SqlDataTypeSpec dataType,
        SqlNode expression,
        ColumnStrategy strategy,
        SpatialIndexType indexType
    ) {
        super(pos, name, dataType, expression, strategy);
        this.indexType = indexType;
    }

    public SpatialIndexType getIndexType() {
        return indexType;
    }
}
