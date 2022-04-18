package com.guanxy.concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * description
 * 课程里用来标记【推荐】的类或者写法
 *
 * @author Peter Guan
 * @date 2022/4/18
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Recommend {

  String value() default "";

}
