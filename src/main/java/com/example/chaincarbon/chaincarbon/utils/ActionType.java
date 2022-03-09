package com.example.chaincarbon.utils;

public enum ActionType {
    CreateTicket(0,"碳信创建"),
    PublishTicket( 1,"碳信发行") ,
    TransferTicket(2,"碳信转让"),
    ReceiveTicket(3,"碳信签收"),
    BuyBackTicket(4,"碳信回购"),
    DestroyTicket(5,"碳信销毁"),
    ApplyPledge(10,"融资企业提出碳配额质押申请"),
    ExaminPledge(11,"金融企业进行质押审批"),
    FinanceSignPledge(12,"金融企业签约质押协议"),
    CompanySignPledge(13,"融资企业签约质押协议"),
    ApplyFactor(20,"融资企业提出碳信融资申请"),
    ExaminFactor(21,"金融企业进行保理合规审查"),
    FinanceSignFactor(22,"金融企业签约保理协议"),
    CompanySignFactor(23,"融资企业签约保理协议"),
    ReductionPlan(30,"减排计划申报");

    private int code;
    private String message;

    ActionType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode(){return code;}
}
