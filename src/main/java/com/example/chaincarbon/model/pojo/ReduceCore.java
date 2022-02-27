package com.example.chaincarbon.model.pojo;

public class ReduceCore {
    private String name;

    private String email;

    private String reduceChain;

    private String login;

    private String carbonTicketSign;

    private String carbonTicketTransfer;

    private String financialApplication;

    private String financingContract;

    private String chainAffiliateRelationship;

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

    public String getReduceChain() {
        return reduceChain;
    }

    public void setReduceChain(String reduceChain) {
        this.reduceChain = reduceChain == null ? null : reduceChain.trim();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login == null ? null : login.trim();
    }

    public String getCarbonTicketSign() {
        return carbonTicketSign;
    }

    public void setCarbonTicketSign(String carbonTicketSign) {
        this.carbonTicketSign = carbonTicketSign == null ? null : carbonTicketSign.trim();
    }

    public String getCarbonTicketTransfer() {
        return carbonTicketTransfer;
    }

    public void setCarbonTicketTransfer(String carbonTicketTransfer) {
        this.carbonTicketTransfer = carbonTicketTransfer == null ? null : carbonTicketTransfer.trim();
    }

    public String getFinancialApplication() {
        return financialApplication;
    }

    public void setFinancialApplication(String financialApplication) {
        this.financialApplication = financialApplication == null ? null : financialApplication.trim();
    }

    public String getFinancingContract() {
        return financingContract;
    }

    public void setFinancingContract(String financingContract) {
        this.financingContract = financingContract == null ? null : financingContract.trim();
    }

    public String getChainAffiliateRelationship() {
        return chainAffiliateRelationship;
    }

    public void setChainAffiliateRelationship(String chainAffiliateRelationship) {
        this.chainAffiliateRelationship = chainAffiliateRelationship == null ? null : chainAffiliateRelationship.trim();
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