package com.example.chaincarbon.model.pojo;

import java.util.Date;

public class PledgeRecord {
    private Integer id;

    private Integer quotaQuantity;

    private String quotaOwner;

    private String company;

    private Float pledgeRate;

    private Integer pledgeAmount;

    private Date loanTerm;

    private Float loanInterestRate;

    private Date operationData;

    private String controlChain;

    private String fundUse;

    private Integer condition;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuotaQuantity() {
        return quotaQuantity;
    }

    public void setQuotaQuantity(Integer quotaQuantity) {
        this.quotaQuantity = quotaQuantity;
    }

    public String getQuotaOwner() {
        return quotaOwner;
    }

    public void setQuotaOwner(String quotaOwner) {
        this.quotaOwner = quotaOwner == null ? null : quotaOwner.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public Float getPledgeRate() {
        return pledgeRate;
    }

    public void setPledgeRate(Float pledgeRate) {
        this.pledgeRate = pledgeRate;
    }

    public Integer getPledgeAmount() {
        return pledgeAmount;
    }

    public void setPledgeAmount(Integer pledgeAmount) {
        this.pledgeAmount = pledgeAmount;
    }

    public Date getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(Date loanTerm) {
        this.loanTerm = loanTerm;
    }

    public Float getLoanInterestRate() {
        return loanInterestRate;
    }

    public void setLoanInterestRate(Float loanInterestRate) {
        this.loanInterestRate = loanInterestRate;
    }

    public Date getOperationData() {
        return operationData;
    }

    public void setOperationData(Date operationData) {
        this.operationData = operationData;
    }

    public String getControlChain() {
        return controlChain;
    }

    public void setControlChain(String controlChain) {
        this.controlChain = controlChain == null ? null : controlChain.trim();
    }

    public String getFundUse() {
        return fundUse;
    }

    public void setFundUse(String fundUse) {
        this.fundUse = fundUse == null ? null : fundUse.trim();
    }

    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }
}