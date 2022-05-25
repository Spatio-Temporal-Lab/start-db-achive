package org.urbancomp.start.db.function;

import java.lang.annotation.*;

/**
 * Start DB Function注解
 *
 * @author zaiyuan
 * @date 2022-05-25 19:10
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StartDBFunction {

    /**
     * 函数名称
     */
    String value();
}
