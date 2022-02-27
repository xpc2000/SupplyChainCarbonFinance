package com.example.chaincarbon.model.pojo;

public class ReduceChain {
    private Integer id;

    private String name;

    private String company;

    private Integer memberAdd;

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public Integer getMemberAdd() {
        return memberAdd;
    }

    public void setMemberAdd(Integer memberAdd) {
        this.memberAdd = memberAdd;
    }
}