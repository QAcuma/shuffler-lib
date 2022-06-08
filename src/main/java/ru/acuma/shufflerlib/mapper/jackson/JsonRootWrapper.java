package ru.acuma.shufflerlib.mapper.jackson;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface JsonRootWrapper {

    /**
     * element root name for a single object
     */
    String single();

    /**
     * element root name for collections
     */
    String list();
}
