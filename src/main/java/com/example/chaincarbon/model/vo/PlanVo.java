package com.example.chaincarbon.model.vo;

import lombok.Data;

@Data
public class PlanVo {
    //注：时间格式应为"yyyy-MM-dd HH:mm:ss"
    private String accountName;
    private Integer accountType;
    private String actionPassword;
    private String chain;
    private String company;
    private Integer ticketNum;
    private Integer ReductionNum;
    private String year;
}
