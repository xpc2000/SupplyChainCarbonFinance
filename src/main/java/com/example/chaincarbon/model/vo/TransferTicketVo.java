package com.example.chaincarbon.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class TransferTicketVo {
    /**
     * @Author:周文峰
     * @Date:2022/3/1
     */
    private Integer id;
    private Integer type;//操作类型
    private String sender;//操作者、发送方
    private Integer amount;
    private Date time;//操作时间
}