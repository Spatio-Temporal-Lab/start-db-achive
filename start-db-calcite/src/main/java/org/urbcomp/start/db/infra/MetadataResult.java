package org.urbcomp.start.db.infra;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.apache.calcite.avatica.AvaticaParameter;
import org.apache.calcite.avatica.ColumnMetaData;
import org.apache.calcite.avatica.Meta;
import org.apache.calcite.jdbc.CalcitePrepare;
import org.apache.calcite.jdbc.CalciteSchema;
import org.apache.calcite.rel.RelCollation;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.runtime.Bindable;

import java.util.List;
import java.util.Map;

/**
 * @author jimo
 **/
public class MetadataResult<T> extends CalcitePrepare.CalciteSignature<T> {


    private MetadataResult(String sql, List<AvaticaParameter> parameterList, Map<String, Object> internalParameters, RelDataType rowType, List<ColumnMetaData> columns, Meta.CursorFactory cursorFactory, CalciteSchema rootSchema, List<RelCollation> collationList, long maxRowCount, Bindable<T> bindable, Meta.StatementType statementType) {
        super(sql, parameterList, internalParameters, rowType, columns, cursorFactory, rootSchema, collationList, maxRowCount, bindable, statementType);
    }

    public MetadataResult() {
        this("",
                ImmutableList.of(),
                ImmutableMap.of(),
                null,
                ImmutableList.of(),
                Meta.CursorFactory.OBJECT,
                null,
                ImmutableList.of(),
                -1,
                null,
                Meta.StatementType.OTHER_DDL);
    }


}
