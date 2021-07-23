package com.example.util.annotation;

import java.lang.annotation.*;

/**
 * @author Yongqiang.li
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface LogAnnotation {
    String desc();
}
