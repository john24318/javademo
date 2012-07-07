package com.oreilly.tiger.ch06;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Marker annotation to indicate that a method or class is still in progress.
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface InProgress {
}