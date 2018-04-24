package com.ilabservice.intelab.common.annotation;


import com.ilabservice.intelab.model.enums.FillAutoValueType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 这个注解是是为了插入或者更新时判断字段是否自动填充
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FillAuto {
    /**
     * UUID或者DATE或者其他
     * 当值为UUID时，则在数据库插入时将该值赋值为UUID32位
     * 当值为DATE时，则在数据库插入时将该值赋值为当前时间yyyy-MM-dd HH:mm:ss
     * @return
     */
    FillAutoValueType value() default FillAutoValueType.UUID;

    /**
     * 操作数据库类型，有两种
     * 1 INSERT 当为INSERT的时候，只在INSERT情况下填充
     * 2 UPDATE 当为UPDATE的时候，在INSERT,UPDATE情况都填充
     * @return
     */
    String type() default "INSERT";
}
