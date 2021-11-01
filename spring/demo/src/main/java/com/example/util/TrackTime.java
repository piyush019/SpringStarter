package com.example.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // it means that it can only used on method
@Retention(RetentionPolicy.RUNTIME)  // it means that we have this information at runtime
public @interface TrackTime {
}
