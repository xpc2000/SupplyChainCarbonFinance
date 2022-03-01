package com.example.chaincarbon.model.vo;

import lombok.Data;

import java.util.Date;
@Data
public class FactorForInstitutionVo {
    private Integer id;
    private String company;
    private Date time;
    private Integer status;
    private Integer amount;
}
