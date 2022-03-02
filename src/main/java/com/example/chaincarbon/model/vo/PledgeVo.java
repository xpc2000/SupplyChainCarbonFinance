package com.example.chaincarbon.model.vo;

import lombok.Data;

@Data
public class PledgeVo {
    //注：时间格式应为"yyyy-MM-dd HH:mm:ss"
    private String accountName;
    private Integer accountType;
    private String actionPassword;
    private Integer ID;
    private String chain;
    private String companyNeedFund;
    private String companyOfferFund;
    private Integer pledgeNum;
    private Integer pledgeFund;
    private Float pledgeRate;
    private Float interestRate;
    private String pledgeDDL;
    private String date;
    private String usage;
}
