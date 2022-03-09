package com.example.chaincarbon.model.pojo;

public class ReduceSub {
    private String name;

    private String email;

    private String login;

    private String carbonTicketTranfer;

    private String carbonTicketSign;

    private String financingApplication;

    private String financingContract;

    private String reduceChain;

    private Integer carbonTicketBalance;

    private String blockchainWalletKey;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login == null ? null : login.trim();
    }

    public String getCarbonTicketTranfer() {
        return carbonTicketTranfer;
    }

    public void setCarbonTicketTranfer(String carbonTicketTranfer) {
        this.carbonTicketTranfer = carbonTicketTranfer == null ? null : carbonTicketTranfer.trim();
    }

    public String getCarbonTicketSign() {
        return carbonTicketSign;
    }

    public void setCarbonTicketSign(String carbonTicketSign) {
        this.carbonTicketSign = carbonTicketSign == null ? null : carbonTicketSign.trim();
    }

    public String getFinancingApplication() {
        return financingApplication;
    }

    public void setFinancingApplication(String financingApplication) {
        this.financingApplication = financingApplication == null ? null : financingApplication.trim();
    }

    public String getFinancingContract() {
        return financingContract;
    }

    public void setFinancingContract(String financingContract) {
        this.financingContract = financingContract == null ? null : financingContract.trim();
    }

    public String getReduceChain() {
        return reduceChain;
    }

    public void setReduceChain(String reduceChain) {
        this.reduceChain = reduceChain == null ? null : reduceChain.trim();
    }

    public Integer getCarbonTicketBalance() {
        return carbonTicketBalance;
    }

    public void setCarbonTicketBalance(Integer carbonTicketBalance) {
        this.carbonTicketBalance = carbonTicketBalance;
    }

    public String getBlockchainWalletKey() {
        return blockchainWalletKey;
    }

    public void setBlockchainWalletKey(String blockchainWalletKey) {
        this.blockchainWalletKey = blockchainWalletKey == null ? null : blockchainWalletKey.trim();
    }
}