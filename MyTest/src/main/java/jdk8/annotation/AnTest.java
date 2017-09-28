package jdk8.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
@interface Basic {
 String name();
}
@Retention(RetentionPolicy.RUNTIME)
@interface Basics {
 Basic[] value();
}