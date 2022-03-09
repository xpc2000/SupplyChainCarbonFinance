package com.example.chaincarbon.model.vo;

import lombok.Data;

@Data
public class FactorVo {
    //注：日期格式应为"yyyy-MM-dd HH:mm:ss"
    private String accountName;
    private Integer accountType;
    private String actionPassword;
    private String companyNeedFund;
    private String companyOfferFund;
    private Integer num;
    private String bankAccount;
    private String date;
    private String bank;
    private Integer ID;
    private Integer fund;
    private Float interestRate;
    private Float serviceRate;
    private String factorDDL;
    private String usage;
}
