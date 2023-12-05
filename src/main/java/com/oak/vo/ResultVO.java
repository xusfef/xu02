package com.oak.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO<T> {

    public static final int SUCCESS_CODE = 200;

    public static final String SUCCESS_MESSAGE = "操作成功";

    public static final int FAILE_CODE = 500;

    public static final String FAILE_MESSAGE = "系统异常";

    public int code;

    public String message;

    public T data;

    public static <T> ResultVO success(String message, T data) {
        return new ResultVO<>(SUCCESS_CODE, message, data);
    }

    public static <T> ResultVO success(T data) {
        return success(SUCCESS_MESSAGE, data);
    }

    public static <T> ResultVO success() {
        return success(null);
    }

    public static <T> ResultVO failed (int code, String message) {
        return new ResultVO<>(code, message, null);
    }

    public static <T> ResultVO failed (String message) {
        return failed(FAILE_CODE, message);
    }

    public static <T> ResultVO failed () {
        return failed(FAILE_MESSAGE);
    }
}