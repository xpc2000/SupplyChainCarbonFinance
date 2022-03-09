package com.example.chaincarbon.model.vo;

import lombok.Data;

@Data
public class ApplyPledgeVo {
    private String accountName;
    private Integer accountType;
    private String actionPassword;
    private String chain;
    private String companyNeedFund;
    private String companyOfferFund;
    private Integer pledgeNum;
    private String usage;
}
