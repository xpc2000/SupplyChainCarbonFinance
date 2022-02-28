package com.example.chaincarbon.model.pojo;

import java.util.Date;

public class FactorRecord {
    private Integer id;

    private String company;

    private String factoringCompany;

    private Integer amountCarbonTicket;

    private Integer financingAmount;

    private Date financingTerm;

    private Date operationTime;

    private Float serviceRate;

    private Float interestRate;

    private Integer status;

    private String fundUse;

    private String bank;

    private String account;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getFactoringCompany() {
        return factoringCompany;
    }

    public void setFactoringCompany(String factoringCompany) {
        this.factoringCompany = factoringCompany == null ? null : factoringCompany.trim();
    }

    public Integer getAmountCarbonTicket() {
        return amountCarbonTicket;
    }

    public void setAmountCarbonTicket(Integer amountCarbonTicket) {
        this.amountCarbonTicket = amountCarbonTicket;
    }

    public Integer getFinancingAmount() {
        return financingAmount;
    }

    public void setFinancingAmount(Integer financingAmount) {
        this.financingAmount = financingAmount;
    }

    public Date getFinancingTerm() {
        return financingTerm;
    }

    public void setFinancingTerm(Date financingTerm) {
        this.financingTerm = financingTerm;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public Float getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(Float serviceRate) {
        this.serviceRate = serviceRate;
    }

    public Float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Float interestRate) {
        this.interestRate = interestRate;
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

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }
}