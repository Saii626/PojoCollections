package app.saikat.UrlManagement.AnnotationProcessing;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface ExportUrl {

    // ENUM identifier
    String name();

    // pathurl begining with '/'
    String url();

    // Request object type
    Class<?> request();

    // Request object type
    Class<?> response();

}