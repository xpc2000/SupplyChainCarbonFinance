package com.example.chaincarbon.model.pojo;

public class FinanceInstitution {
    private String companyName;

    private String email;

    private String loginPassword;

    private String classification;

    private String pledgeApproval;

    private String pledgeSigning;

    private String factoringComplianceReview;

    private String factoringPurchaseSigning;

    private Integer carbonTicketNumber;

    private String blockchainWalletKey;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification == null ? null : classification.trim();
    }

    public String getPledgeApproval() {
        return pledgeApproval;
    }

    public void setPledgeApproval(String pledgeApproval) {
        this.pledgeApproval = pledgeApproval == null ? null : pledgeApproval.trim();
    }

    public String getPledgeSigning() {
        return pledgeSigning;
    }

    public void setPledgeSigning(String pledgeSigning) {
        this.pledgeSigning = pledgeSigning == null ? null : pledgeSigning.trim();
    }

    public String getFactoringComplianceReview() {
        return factoringComplianceReview;
    }

    public void setFactoringComplianceReview(String factoringComplianceReview) {
        this.factoringComplianceReview = factoringComplianceReview == null ? null : factoringComplianceReview.trim();
    }

    public String getFactoringPurchaseSigning() {
        return factoringPurchaseSigning;
    }

    public void setFactoringPurchaseSigning(String factoringPurchaseSigning) {
        this.factoringPurchaseSigning = factoringPurchaseSigning == null ? null : factoringPurchaseSigning.trim();
    }

    public Integer getCarbonTicketNumber() {
        return carbonTicketNumber;
    }

    public void setCarbonTicketNumber(Integer carbonTicketNumber) {
        this.carbonTicketNumber = carbonTicketNumber;
    }

    public String getBlockchainWalletKey() {
        return blockchainWalletKey;
    }

    public void setBlockchainWalletKey(String blockchainWalletKey) {
        this.blockchainWalletKey = blockchainWalletKey == null ? null : blockchainWalletKey.trim();
    }
}