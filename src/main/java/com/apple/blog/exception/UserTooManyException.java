/**
 * @author sonia
 * @description: 登陆时根据账号名和密码查询出的用户不唯一
 * @date 2021/2/16 11:07
 */
package com.apple.blog.exception;

public class UserTooManyException extends RuntimeException{
    public UserTooManyException() {
    }

    public UserTooManyException(String message) {
        super(message);
    }

    public UserTooManyException(String message, Throwable cause) {
        super(message, cause);
    }
}
