/**
 * @author sonia
 * @description: 名称相同的异常
 * @date 2021/2/17 14:47
 */
package com.apple.blog.exception;

public class SameNameException extends RuntimeException{
    public SameNameException() {
    }

    public SameNameException(String message) {
        super(message);
    }

    public SameNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
