/**
 * @author sonia
 * @description: 处理整个web的异常
 * @date 2021/2/10 16:54
 */
package com.apple.blog.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

// @ControllerAdvice+@ExceptionHandler 可以被ExceptionHandlerExceptionResolver解析
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})
    public String handlerException(Exception e) throws Exception {
        log.error("########异常捕获进来了。。。{}",e);

        // 如果是有responseStatus的异常，就不走这边的异常处理逻辑
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        return "error";
    }
}
