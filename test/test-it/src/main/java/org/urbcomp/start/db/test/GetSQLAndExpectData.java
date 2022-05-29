package org.urbcomp.start.db.test;

public class GetSQLAndExpectData {

    public static String getSqlWithParam(String sqlText, String parameters) {
        //todo 将参数与sql进行拼接


        return "Concatenated-SQL";
    }

    public static String getExpectData(String expectData) {
        //todo 将返回的预期结果或者预期异常信息返回
        if (expectData.startsWith("error")){

        }else{

        }
        return "Concatenated-SQL";


    }
}
