package com.dorm.dorm.respose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultResponse<T> {
    private T data;
    private String msg;
    private int code;
    private int count;

    public static ResultResponse<?> success(String msg) {
        return new ResultResponse<>(null, msg, 200, 0);
    }

    public static ResultResponse<?> success(String msg, int count) {
        return new ResultResponse<>(null, msg, 200, count);
    }

    public static <T> ResultResponse<T> success(T data, String msg) {
        return new ResultResponse<>(data, msg, 200, 0);
    }

    public static <T> ResultResponse<T> success(T data, String msg, int count) {
        return new ResultResponse<>(data, msg, 200, count);
    }

    public static ResultResponse<?> error(String msg) {
        return new ResultResponse<>(null, msg, 500, 0);
    }
}
