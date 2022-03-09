package com.example.chaincarbon.model.pojo;

import java.util.Date;

public class ControlChain {
    private Integer id;

    private String name;

    private String chainCompany;

    private Integer creationCarbonTicket;

    private Integer memberAdd;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getChainCompany() {
        return chainCompany;
    }

    public void setChainCompany(String chainCompany) {
        this.chainCompany = chainCompany == null ? null : chainCompany.trim();
    }

    public Integer getCreationCarbonTicket() {
        return creationCarbonTicket;
    }

    public void setCreationCarbonTicket(Integer creationCarbonTicket) {
        this.creationCarbonTicket = creationCarbonTicket;
    }

    public Integer getMemberAdd() {
        return memberAdd;
    }

    public void setMemberAdd(Integer memberAdd) {
        this.memberAdd = memberAdd;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}