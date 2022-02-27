package com.example.chaincarbon.model.pojo;

public class ControlCore {
    private String name;

    private String email;

    private String login;

    private String controlChain;

    private String chainRelationship;

    private String emissionReductionPlan;

    private String carbonTicketCreation;

    private String carbonTicketDestruction;

    private String pledgeApplication;

    private String pledgeSigning;

    private String carbonTicketIssue;

    private String carbonTicketRepurchase;

    private Integer numberCarbonEmission;

    private Integer carbontTicket;

    private Integer unissuedCarbonTicket;

    private Integer repurchasedCarbonTicket;

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

    public String getControlChain() {
        return controlChain;
    }

    public void setControlChain(String controlChain) {
        this.controlChain = controlChain == null ? null : controlChain.trim();
    }

    public String getChainRelationship() {
        return chainRelationship;
    }

    public void setChainRelationship(String chainRelationship) {
        this.chainRelationship = chainRelationship == null ? null : chainRelationship.trim();
    }

    public String getEmissionReductionPlan() {
        return emissionReductionPlan;
    }

    public void setEmissionReductionPlan(String emissionReductionPlan) {
        this.emissionReductionPlan = emissionReductionPlan == null ? null : emissionReductionPlan.trim();
    }

    public String getCarbonTicketCreation() {
        return carbonTicketCreation;
    }

    public void setCarbonTicketCreation(String carbonTicketCreation) {
        this.carbonTicketCreation = carbonTicketCreation == null ? null : carbonTicketCreation.trim();
    }

    public String getCarbonTicketDestruction() {
        return carbonTicketDestruction;
    }

    public void setCarbonTicketDestruction(String carbonTicketDestruction) {
        this.carbonTicketDestruction = carbonTicketDestruction == null ? null : carbonTicketDestruction.trim();
    }

    public String getPledgeApplication() {
        return pledgeApplication;
    }

    public void setPledgeApplication(String pledgeApplication) {
        this.pledgeApplication = pledgeApplication == null ? null : pledgeApplication.trim();
    }

    public String getPledgeSigning() {
        return pledgeSigning;
    }

    public void setPledgeSigning(String pledgeSigning) {
        this.pledgeSigning = pledgeSigning == null ? null : pledgeSigning.trim();
    }

    public String getCarbonTicketIssue() {
        return carbonTicketIssue;
    }

    public void setCarbonTicketIssue(String carbonTicketIssue) {
        this.carbonTicketIssue = carbonTicketIssue == null ? null : carbonTicketIssue.trim();
    }

    public String getCarbonTicketRepurchase() {
        return carbonTicketRepurchase;
    }

    public void setCarbonTicketRepurchase(String carbonTicketRepurchase) {
        this.carbonTicketRepurchase = carbonTicketRepurchase == null ? null : carbonTicketRepurchase.trim();
    }

    public Integer getNumberCarbonEmission() {
        return numberCarbonEmission;
    }

    public void setNumberCarbonEmission(Integer numberCarbonEmission) {
        this.numberCarbonEmission = numberCarbonEmission;
    }

    public Integer getCarbontTicket() {
        return carbontTicket;
    }

    public void setCarbontTicket(Integer carbontTicket) {
        this.carbontTicket = carbontTicket;
    }

    public Integer getUnissuedCarbonTicket() {
        return unissuedCarbonTicket;
    }

    public void setUnissuedCarbonTicket(Integer unissuedCarbonTicket) {
        this.unissuedCarbonTicket = unissuedCarbonTicket;
    }

    public Integer getRepurchasedCarbonTicket() {
        return repurchasedCarbonTicket;
    }

    public void setRepurchasedCarbonTicket(Integer repurchasedCarbonTicket) {
        this.repurchasedCarbonTicket = repurchasedCarbonTicket;
    }

    public String getBlockchainWalletKey() {
        return blockchainWalletKey;
    }

    public void setBlockchainWalletKey(String blockchainWalletKey) {
        this.blockchainWalletKey = blockchainWalletKey == null ? null : blockchainWalletKey.trim();
    }
}