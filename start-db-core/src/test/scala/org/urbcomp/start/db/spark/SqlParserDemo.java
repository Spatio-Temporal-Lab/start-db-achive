package org.urbcomp.start.db.spark;

import org.junit.Test;
import org.urbcomp.start.db.metadata.MetadataAccessUtil;
import org.urbcomp.start.db.metadata.entity.Table;
import org.urbcomp.start.db.parser.SqlVisitor;

/**
 * @author stan
 * @date 2022/9/30 23:31
 */
public class SqlParserDemo {

//    @Test
//    public void getTableNameFromSql() {
//        String sql = "SELECT A FROM B;";
//        SqlVisitor<String> visitor = new SqlVisitor<>();
//        String tableName = visitor.apply(sql);
//        assert "B".equals(tableName);
//    }

    @Test
    public void getMapFromMetaData(){
        String user = "root";
        String dbName = "meta_data";
        String tableName = "sys_database";

        Table table = MetadataAccessUtil.getTable(user, dbName, tableName);
        System.out.println(table);
    }

}