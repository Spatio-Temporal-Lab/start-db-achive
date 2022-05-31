package org.urbcomp.start.db.sqlnode;

import org.apache.calcite.sql.*;
import org.apache.calcite.sql.parser.SqlParserPos;

import java.util.List;

/**
 * insert into parse result
 *
 * @author zaiyuan
 * @date 2022-05-31 22:00:00
 */
public class SqlInsert extends SqlBasicCall {

    private SqlIdentifier targetTable;

    private List<String> columnNameList;

    private List<List<String>> rowList;

    private String select;

    public SqlInsert(SqlOperator operator, SqlParserPos pos) {
        super(operator, new SqlNode[0], pos);
    }

    public SqlInsert(SqlParserPos pos, SqlIdentifier targetTable, List<String> columnNameList, List<List<String>> rowList, String select) {
        this(new SqlSpecialOperator("INSERT", SqlKind.INSERT), pos);
        this.targetTable = targetTable;
        this.columnNameList = columnNameList;
        this.rowList = rowList;
        this.select = select;
    }

    public SqlIdentifier getTargetTable() {
        return targetTable;
    }

    public void setTargetTable(SqlIdentifier targetTable) {
        this.targetTable = targetTable;
    }

    public List<String> getColumnNameList() {
        return columnNameList;
    }

    public void setColumnNameList(List<String> columnNameList) {
        this.columnNameList = columnNameList;
    }

    public List<List<String>> getRowList() {
        return rowList;
    }

    public void setRowList(List<List<String>> rowList) {
        this.rowList = rowList;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    @Override
    public String toString() {
        return "SqlInsert{" +
                "targetTable=" + targetTable +
                ", columnNameList=" + columnNameList +
                ", rowList=" + rowList +
                ", select=" + select +
                '}';
    }
}