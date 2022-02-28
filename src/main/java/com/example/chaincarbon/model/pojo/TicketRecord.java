package com.example.chaincarbon.model.pojo;

import java.util.Date;

public class TicketRecord {
    private Integer id;

    private Integer amountCarbonTicket;

    private String initiatorSupplyChain;

    private String receiverSupplyChain;

    private String initiatorName;

    private String receiverName;

    private Integer operation;

    private Integer status;

    private String fundUse;

    private Date operationData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmountCarbonTicket() {
        return amountCarbonTicket;
    }

    public void setAmountCarbonTicket(Integer amountCarbonTicket) {
        this.amountCarbonTicket = amountCarbonTicket;
    }

    public String getInitiatorSupplyChain() {
        return initiatorSupplyChain;
    }

    public void setInitiatorSupplyChain(String initiatorSupplyChain) {
        this.initiatorSupplyChain = initiatorSupplyChain == null ? null : initiatorSupplyChain.trim();
    }

    public String getReceiverSupplyChain() {
        return receiverSupplyChain;
    }

    public void setReceiverSupplyChain(String receiverSupplyChain) {
        this.receiverSupplyChain = receiverSupplyChain == null ? null : receiverSupplyChain.trim();
    }

    public String getInitiatorName() {
        return initiatorName;
    }

    public void setInitiatorName(String initiatorName) {
        this.initiatorName = initiatorName == null ? null : initiatorName.trim();
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFundUse() {
        return fundUse;
    }

    public void setFundUse(String fundUse) {
        this.fundUse = fundUse == null ? null : fundUse.trim();
    }

    public Date getOperationData() {
        return operationData;
    }

    public void setOperationData(Date operationData) {
        this.operationData = operationData;
    }
}