package com.example.chaincarbon.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class FactorForCompanyVo {
    private Integer id;
    private String institution;
    private Date time;
    private Integer status;
    private Integer amount;
}
