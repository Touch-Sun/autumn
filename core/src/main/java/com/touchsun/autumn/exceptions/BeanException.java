package com.touchsun.autumn.exceptions;

/**
 * Bean 异常
 *
 * @author lee
 * @since 2022/12/19 15:17
 */
public class BeanException extends RuntimeException {

    public BeanException(String message) {
        super(message);
    }

    public BeanException(String message, Throwable cause) {
        super(message, cause);
    }
}
