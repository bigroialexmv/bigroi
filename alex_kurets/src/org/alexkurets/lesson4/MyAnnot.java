package org.alexkurets.lesson4;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnot {
String description() default " ";
int version() default 0;
}
