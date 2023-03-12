package org.urbcomp.cupid.db.datatype;

/**
 * @author jimo
 **/
public class DataConvertFactory {

    /**
     * 将 val转换为 type类型的数据
     */
    public static Object convert(String val, DataTypeField type) {
        switch (type.getType()) {
            case "integer":
                return Integer.parseInt(val);
            case "string":
            default:
                return val;
        }
    }
}
