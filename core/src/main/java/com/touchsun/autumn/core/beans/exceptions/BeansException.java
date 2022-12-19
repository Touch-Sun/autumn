package com.touchsun.autumn.core.beans.exceptions;

/**
 * Bean 异常
 *
 * @author lee
 * @since 2022/12/19 15:17
 */
public class BeansException extends RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
