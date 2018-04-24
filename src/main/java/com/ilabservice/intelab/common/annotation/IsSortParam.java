package com.ilabservice.intelab.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 这个字段标记的是排序字段
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IsSortParam {
    /**
     * 排序规则
     * 排序规则支持最多支持三个，且三个默认都为升序
     * false为降序 DESC
     * ture为升序 ASC
     */
    boolean sortRule() default false;
}
