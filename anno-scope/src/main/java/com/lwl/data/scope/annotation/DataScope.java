package com.lwl.data.scope.annotation;


import com.lwl.data.scope.handler.DefaultDataScopeHandler;

import java.lang.annotation.*;

/**
 * @description： 数据权限过滤注解
 * @author     ：lwl
 * @date       ：2021/7/6 10:06
 * @version:     1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope {

    /**
     *  表名
     */
    String tableName() default "";

    /**
     *  处理逻辑
     */
    Class handlerClass() default DefaultDataScopeHandler.class ;

    /**
     *  描述
     */
    String desc() default "";


    /**
     *  多表联合操作时表名集合
     */
    String[] tables() default {};

}
