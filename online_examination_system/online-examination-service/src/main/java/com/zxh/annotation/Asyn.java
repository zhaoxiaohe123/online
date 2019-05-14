package com.zxh.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Asyn {

	
	String value() default "";
	
	/**
	 * 初始最大线程容量
	 * @return
	 */
	int capacity() default 10;
	
	/**
	 * 超出队列最大限制后的最大线程容量
	 * @return
	 */
	int maxCapacity() default 10;
	
	/**
	 * 初始最大线程容量满后存队列的容量
	 * @return
	 */
	int queueCapacity() default Integer.MAX_VALUE;
}
