package com.dorm.dorm.respose;

import lombok.Data;

@Data
public class ApiResponse {
    private boolean success;
    private String message;
    private Object data;

    public ApiResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static ApiResponse success(String msg) {
        return new ApiResponse(true, msg, null);
    }

    public static ApiResponse error(String msg) {
        return new ApiResponse(false, msg, null);
    }

    public static ApiResponse success(String msg, Object data) {
        return new ApiResponse(true, msg, data);
    }

}

