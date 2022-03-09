package com.example.chaincarbon.model.pojo;

import java.util.Date;

public class Plan {
    private Integer id;

    private String controlChain;

    private String company;

    private Integer amountReduce;

    private Integer declarationCarbonTicket;

    private Date year;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getControlChain() {
        return controlChain;
    }

    public void setControlChain(String controlChain) {
        this.controlChain = controlChain == null ? null : controlChain.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public Integer getAmountReduce() {
        return amountReduce;
    }

    public void setAmountReduce(Integer amountReduce) {
        this.amountReduce = amountReduce;
    }

    public Integer getDeclarationCarbonTicket() {
        return declarationCarbonTicket;
    }

    public void setDeclarationCarbonTicket(Integer declarationCarbonTicket) {
        this.declarationCarbonTicket = declarationCarbonTicket;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }
}