package org.wandaima.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 映射JavaBean到数据库的表
 * @author lmkang25@163.com
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {

	/**
	 * 数据库的表名称
	 * @return 数据库的表名称,如果为空,则返回JavaBean的simpleName
	 */
	String name();
}
