package com.example.chaincarbon.model.vo;

import lombok.Data;

@Data
public class LoginVo {
    private String userEmail;
    private Integer accountType;
    private String password;
}
