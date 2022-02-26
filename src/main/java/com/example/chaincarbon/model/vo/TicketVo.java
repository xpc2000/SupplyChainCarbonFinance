package com.example.chaincarbon.model.vo;

import lombok.Data;

@Data
public class TicketVo {
    private String accountName;
    private Integer accountType;
    private String actionPassword;
    private String date;
    private String senderChain;
    private String sender;
    private String receiverChain;
    private String receiver;
    private Integer num;
    private String application;
}
//注：如果回购sender，那么sender的字段和senderChain就统一写为55555（5个5）
