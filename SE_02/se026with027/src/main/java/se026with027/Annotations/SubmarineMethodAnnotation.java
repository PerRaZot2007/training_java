package se026with027.Annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.CLASS)
@Target(value=ElementType.METHOD)
@Documented
public @interface SubmarineMethodAnnotation {
	String name();
}
