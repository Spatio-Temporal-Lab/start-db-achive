package org.urbcomp.cupid.db.datatype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 抽象的数据类型
 *
 * @author jimo
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataTypeField {

    private String name;
    /**
     * integer, string...
     */
    private String type;
    private boolean nullable;
}
