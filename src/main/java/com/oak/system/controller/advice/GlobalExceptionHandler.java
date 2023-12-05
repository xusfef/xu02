package com.oak.system.controller.advice;

import com.oak.exception.ParamException;
import com.oak.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ParamException.class)
    public Object handle(RuntimeException e) {
        log.error(e.getMessage(), e);
        return ResultVO.failed(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Object handle(Exception e) {
        log.error(e.getMessage(), e);
        return ResultVO.failed(e.getMessage());
    }
}
