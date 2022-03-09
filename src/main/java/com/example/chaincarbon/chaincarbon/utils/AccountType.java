package com.example.chaincarbon.utils;

public enum AccountType {
    Finance(0,"金融企业"),
    ControlCore(1,"控排链核心企业"),
    ControlSub(2,"控排链链属企业"),
    ReduceCore(3,"减排链核心企业"),
    ReduceSub(4,"减排链链属企业");
    private Integer code;
    private String message;

    AccountType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode(){return code;}
}
