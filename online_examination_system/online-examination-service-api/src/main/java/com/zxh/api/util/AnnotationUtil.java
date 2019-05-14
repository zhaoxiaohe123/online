package com.zxh.api.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationUtil {

	@SuppressWarnings({ "unchecked" })
	public static <T> T getAnnotation(Method classz, Class<T> annotation) {
		Annotation[] cas = classz.getAnnotations();
		Annotation[] var6 = cas;
		int var5 = cas.length;

		for (int var4 = 0; var4 < var5; ++var4) {
			Annotation ca = var6[var4];
			if (ca.annotationType().equals(annotation)) {
				return (T) ca;
			}
		}

		return null;
	}
}
