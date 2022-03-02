package com.example.chaincarbon.utils;

public enum ResponseCode {
    OK(0, "成功"),
    LoginFailure(601, "登录失败，用户名或密码错误"),
    InsufficientPermissions(602,"操作密码错误"),
    DataBaseError(603,"数据库操作失败");
    @Override
    public String toString() {
        return "ResponseCode{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    private int code;
    private String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
