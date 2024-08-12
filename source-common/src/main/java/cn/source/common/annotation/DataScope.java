package cn.source.common.annotation;

import java.lang.annotation.*;

/**
 * 数据权限过滤注解
 *
 * @author source
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope
{
    /**
     * 部门表的别名
     */
    String deptAlias() default "";

    /**
     * 部门id字段名
     */
    String deptField() default "dept_id";

    /**
     * 用户表的别名
     */
    String userAlias() default "";

    /**
     * 用户id字段名
     */
    String userField() default "user_id";
}
