package org.urbcomp.start.db.frame;

import java.lang.annotation.*;

/**
 * This annotation is used to define functions
 *
 * @author zaiyuan
 * @date 2022-03-09 09:11:51
 * @since 0.1.0
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface InnerFunction {
    String functionName();
}
