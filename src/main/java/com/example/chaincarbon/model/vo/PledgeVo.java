package com.example.chaincarbon.model.vo;

import lombok.Data;

@Data
public class PledgeVo {
    private String accountName;
    private Integer accountType;
    private String actionPassword;
    private Long ID;
    private String chain;
    private String companyNeedFund;
    private String companyOfferFund;
    private Integer pledgeNum;
    private Float pledgeFund;
    private Float pledgeRate;
    private String pledgeDDL;
    private String date;
    private String usage;
}
