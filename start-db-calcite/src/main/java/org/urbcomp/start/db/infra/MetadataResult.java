package org.urbcomp.start.db.infra;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.apache.calcite.avatica.AvaticaParameter;
import org.apache.calcite.avatica.ColumnMetaData;
import org.apache.calcite.avatica.Meta;
import org.apache.calcite.avatica.SqlType;
import org.apache.calcite.jdbc.CalcitePrepare;
import org.apache.calcite.jdbc.CalciteSchema;
import org.apache.calcite.rel.RelCollation;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.runtime.Bindable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * result for DDL & DML
 *
 * @author jimo
 **/
public class MetadataResult<T> extends CalcitePrepare.CalciteSignature<T> {

    private MetadataResult(String sql, List<AvaticaParameter> parameterList, Map<String, Object> internalParameters, RelDataType rowType, List<ColumnMetaData> columns, Meta.CursorFactory cursorFactory, CalciteSchema rootSchema, List<RelCollation> collationList, long maxRowCount, Bindable<T> bindable, Meta.StatementType statementType) {
        super(sql, parameterList, internalParameters, rowType, columns, cursorFactory, rootSchema, collationList, maxRowCount, bindable, statementType);
    }

    /**
     * DDL
     */
    public MetadataResult(List<ColumnMetaData> metaData) {
        this("",
                ImmutableList.of(),
                ImmutableMap.of(),
                null,
                metaData,
                Meta.CursorFactory.OBJECT,
                null,
                ImmutableList.of(),
                -1,
                null,
                Meta.StatementType.OTHER_DDL);
    }

    public static <T> MetadataResult<T> buildDDLResult(int affectRows) {
        List<ColumnMetaData> metaData = new ArrayList<>(1);
        metaData.add(ColumnMetaData.dummy(new ColumnMetaData.ScalarType(SqlType.INTEGER.id, "affectRows", ColumnMetaData.Rep.INTEGER), true));
        return new MetadataResult<>(metaData);
    }

    /**
     * with result,eg: show tables
     */
    public static <T> MetadataResult<T> buildResult(String[] columns, List<String[]> values) {
        List<ColumnMetaData> metaData = new ArrayList<>(1);
        for (String column : columns) {
            // TODO
        }
        return new MetadataResult<>(metaData);
    }
}
