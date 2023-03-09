package org.urbcomp.cupid.db.spark;

import lombok.Builder;
import lombok.Data;

/**
 * @author jimo
 **/
@Data
@Builder
public class SubmitResult {
    private String sqlId;
    private int execId;
}
