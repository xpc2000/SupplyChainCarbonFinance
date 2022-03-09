package com.example.chaincarbon.model.pojo;

import java.util.ArrayList;
import java.util.List;

public class FinanceInstitutionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinanceInstitutionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("Company_Name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("Company_Name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("Company_Name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("Company_Name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("Company_Name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("Company_Name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("Company_Name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("Company_Name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("Company_Name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("Company_Name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("Company_Name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("Company_Name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("Company_Name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("Company_Name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("Email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("Email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("Email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("Email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("Email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("Email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("Email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("Email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("Email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("Email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("Email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("Email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("Email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("Email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordIsNull() {
            addCriterion("Login_password is null");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordIsNotNull() {
            addCriterion("Login_password is not null");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordEqualTo(String value) {
            addCriterion("Login_password =", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotEqualTo(String value) {
            addCriterion("Login_password <>", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordGreaterThan(String value) {
            addCriterion("Login_password >", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("Login_password >=", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLessThan(String value) {
            addCriterion("Login_password <", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLessThanOrEqualTo(String value) {
            addCriterion("Login_password <=", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLike(String value) {
            addCriterion("Login_password like", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotLike(String value) {
            addCriterion("Login_password not like", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordIn(List<String> values) {
            addCriterion("Login_password in", values, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotIn(List<String> values) {
            addCriterion("Login_password not in", values, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordBetween(String value1, String value2) {
            addCriterion("Login_password between", value1, value2, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotBetween(String value1, String value2) {
            addCriterion("Login_password not between", value1, value2, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andClassificationIsNull() {
            addCriterion("Classification is null");
            return (Criteria) this;
        }

        public Criteria andClassificationIsNotNull() {
            addCriterion("Classification is not null");
            return (Criteria) this;
        }

        public Criteria andClassificationEqualTo(String value) {
            addCriterion("Classification =", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotEqualTo(String value) {
            addCriterion("Classification <>", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationGreaterThan(String value) {
            addCriterion("Classification >", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationGreaterThanOrEqualTo(String value) {
            addCriterion("Classification >=", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLessThan(String value) {
            addCriterion("Classification <", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLessThanOrEqualTo(String value) {
            addCriterion("Classification <=", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLike(String value) {
            addCriterion("Classification like", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotLike(String value) {
            addCriterion("Classification not like", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationIn(List<String> values) {
            addCriterion("Classification in", values, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotIn(List<String> values) {
            addCriterion("Classification not in", values, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationBetween(String value1, String value2) {
            addCriterion("Classification between", value1, value2, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotBetween(String value1, String value2) {
            addCriterion("Classification not between", value1, value2, "classification");
            return (Criteria) this;
        }

        public Criteria andPledgeApprovalIsNull() {
            addCriterion("Pledge_approval is null");
            return (Criteria) this;
        }

        public Criteria andPledgeApprovalIsNotNull() {
            addCriterion("Pledge_approval is not null");
            return (Criteria) this;
        }

        public Criteria andPledgeApprovalEqualTo(String value) {
            addCriterion("Pledge_approval =", value, "pledgeApproval");
            return (Criteria) this;
        }

        public Criteria andPledgeApprovalNotEqualTo(String value) {
            addCriterion("Pledge_approval <>", value, "pledgeApproval");
            return (Criteria) this;
        }

        public Criteria andPledgeApprovalGreaterThan(String value) {
            addCriterion("Pledge_approval >", value, "pledgeApproval");
            return (Criteria) this;
        }

        public Criteria andPledgeApprovalGreaterThanOrEqualTo(String value) {
            addCriterion("Pledge_approval >=", value, "pledgeApproval");
            return (Criteria) this;
        }

        public Criteria andPledgeApprovalLessThan(String value) {
            addCriterion("Pledge_approval <", value, "pledgeApproval");
            return (Criteria) this;
        }

        public Criteria andPledgeApprovalLessThanOrEqualTo(String value) {
            addCriterion("Pledge_approval <=", value, "pledgeApproval");
            return (Criteria) this;
        }

        public Criteria andPledgeApprovalLike(String value) {
            addCriterion("Pledge_approval like", value, "pledgeApproval");
            return (Criteria) this;
        }

        public Criteria andPledgeApprovalNotLike(String value) {
            addCriterion("Pledge_approval not like", value, "pledgeApproval");
            return (Criteria) this;
        }

        public Criteria andPledgeApprovalIn(List<String> values) {
            addCriterion("Pledge_approval in", values, "pledgeApproval");
            return (Criteria) this;
        }

        public Criteria andPledgeApprovalNotIn(List<String> values) {
            addCriterion("Pledge_approval not in", values, "pledgeApproval");
            return (Criteria) this;
        }

        public Criteria andPledgeApprovalBetween(String value1, String value2) {
            addCriterion("Pledge_approval between", value1, value2, "pledgeApproval");
            return (Criteria) this;
        }

        public Criteria andPledgeApprovalNotBetween(String value1, String value2) {
            addCriterion("Pledge_approval not between", value1, value2, "pledgeApproval");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningIsNull() {
            addCriterion("Pledge_signing is null");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningIsNotNull() {
            addCriterion("Pledge_signing is not null");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningEqualTo(String value) {
            addCriterion("Pledge_signing =", value, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningNotEqualTo(String value) {
            addCriterion("Pledge_signing <>", value, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningGreaterThan(String value) {
            addCriterion("Pledge_signing >", value, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningGreaterThanOrEqualTo(String value) {
            addCriterion("Pledge_signing >=", value, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningLessThan(String value) {
            addCriterion("Pledge_signing <", value, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningLessThanOrEqualTo(String value) {
            addCriterion("Pledge_signing <=", value, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningLike(String value) {
            addCriterion("Pledge_signing like", value, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningNotLike(String value) {
            addCriterion("Pledge_signing not like", value, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningIn(List<String> values) {
            addCriterion("Pledge_signing in", values, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningNotIn(List<String> values) {
            addCriterion("Pledge_signing not in", values, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningBetween(String value1, String value2) {
            addCriterion("Pledge_signing between", value1, value2, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningNotBetween(String value1, String value2) {
            addCriterion("Pledge_signing not between", value1, value2, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andFactoringComplianceReviewIsNull() {
            addCriterion("Factoring_compliance_review is null");
            return (Criteria) this;
        }

        public Criteria andFactoringComplianceReviewIsNotNull() {
            addCriterion("Factoring_compliance_review is not null");
            return (Criteria) this;
        }

        public Criteria andFactoringComplianceReviewEqualTo(String value) {
            addCriterion("Factoring_compliance_review =", value, "factoringComplianceReview");
            return (Criteria) this;
        }

        public Criteria andFactoringComplianceReviewNotEqualTo(String value) {
            addCriterion("Factoring_compliance_review <>", value, "factoringComplianceReview");
            return (Criteria) this;
        }

        public Criteria andFactoringComplianceReviewGreaterThan(String value) {
            addCriterion("Factoring_compliance_review >", value, "factoringComplianceReview");
            return (Criteria) this;
        }

        public Criteria andFactoringComplianceReviewGreaterThanOrEqualTo(String value) {
            addCriterion("Factoring_compliance_review >=", value, "factoringComplianceReview");
            return (Criteria) this;
        }

        public Criteria andFactoringComplianceReviewLessThan(String value) {
            addCriterion("Factoring_compliance_review <", value, "factoringComplianceReview");
            return (Criteria) this;
        }

        public Criteria andFactoringComplianceReviewLessThanOrEqualTo(String value) {
            addCriterion("Factoring_compliance_review <=", value, "factoringComplianceReview");
            return (Criteria) this;
        }

        public Criteria andFactoringComplianceReviewLike(String value) {
            addCriterion("Factoring_compliance_review like", value, "factoringComplianceReview");
            return (Criteria) this;
        }

        public Criteria andFactoringComplianceReviewNotLike(String value) {
            addCriterion("Factoring_compliance_review not like", value, "factoringComplianceReview");
            return (Criteria) this;
        }

        public Criteria andFactoringComplianceReviewIn(List<String> values) {
            addCriterion("Factoring_compliance_review in", values, "factoringComplianceReview");
            return (Criteria) this;
        }

        public Criteria andFactoringComplianceReviewNotIn(List<String> values) {
            addCriterion("Factoring_compliance_review not in", values, "factoringComplianceReview");
            return (Criteria) this;
        }

        public Criteria andFactoringComplianceReviewBetween(String value1, String value2) {
            addCriterion("Factoring_compliance_review between", value1, value2, "factoringComplianceReview");
            return (Criteria) this;
        }

        public Criteria andFactoringComplianceReviewNotBetween(String value1, String value2) {
            addCriterion("Factoring_compliance_review not between", value1, value2, "factoringComplianceReview");
            return (Criteria) this;
        }

        public Criteria andFactoringPurchaseSigningIsNull() {
            addCriterion("Factoring_purchase_signing is null");
            return (Criteria) this;
        }

        public Criteria andFactoringPurchaseSigningIsNotNull() {
            addCriterion("Factoring_purchase_signing is not null");
            return (Criteria) this;
        }

        public Criteria andFactoringPurchaseSigningEqualTo(String value) {
            addCriterion("Factoring_purchase_signing =", value, "factoringPurchaseSigning");
            return (Criteria) this;
        }

        public Criteria andFactoringPurchaseSigningNotEqualTo(String value) {
            addCriterion("Factoring_purchase_signing <>", value, "factoringPurchaseSigning");
            return (Criteria) this;
        }

        public Criteria andFactoringPurchaseSigningGreaterThan(String value) {
            addCriterion("Factoring_purchase_signing >", value, "factoringPurchaseSigning");
            return (Criteria) this;
        }

        public Criteria andFactoringPurchaseSigningGreaterThanOrEqualTo(String value) {
            addCriterion("Factoring_purchase_signing >=", value, "factoringPurchaseSigning");
            return (Criteria) this;
        }

        public Criteria andFactoringPurchaseSigningLessThan(String value) {
            addCriterion("Factoring_purchase_signing <", value, "factoringPurchaseSigning");
            return (Criteria) this;
        }

        public Criteria andFactoringPurchaseSigningLessThanOrEqualTo(String value) {
            addCriterion("Factoring_purchase_signing <=", value, "factoringPurchaseSigning");
            return (Criteria) this;
        }

        public Criteria andFactoringPurchaseSigningLike(String value) {
            addCriterion("Factoring_purchase_signing like", value, "factoringPurchaseSigning");
            return (Criteria) this;
        }

        public Criteria andFactoringPurchaseSigningNotLike(String value) {
            addCriterion("Factoring_purchase_signing not like", value, "factoringPurchaseSigning");
            return (Criteria) this;
        }

        public Criteria andFactoringPurchaseSigningIn(List<String> values) {
            addCriterion("Factoring_purchase_signing in", values, "factoringPurchaseSigning");
            return (Criteria) this;
        }

        public Criteria andFactoringPurchaseSigningNotIn(List<String> values) {
            addCriterion("Factoring_purchase_signing not in", values, "factoringPurchaseSigning");
            return (Criteria) this;
        }

        public Criteria andFactoringPurchaseSigningBetween(String value1, String value2) {
            addCriterion("Factoring_purchase_signing between", value1, value2, "factoringPurchaseSigning");
            return (Criteria) this;
        }

        public Criteria andFactoringPurchaseSigningNotBetween(String value1, String value2) {
            addCriterion("Factoring_purchase_signing not between", value1, value2, "factoringPurchaseSigning");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketNumberIsNull() {
            addCriterion("Carbon_ticket_number is null");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketNumberIsNotNull() {
            addCriterion("Carbon_ticket_number is not null");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketNumberEqualTo(Integer value) {
            addCriterion("Carbon_ticket_number =", value, "carbonTicketNumber");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketNumberNotEqualTo(Integer value) {
            addCriterion("Carbon_ticket_number <>", value, "carbonTicketNumber");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketNumberGreaterThan(Integer value) {
            addCriterion("Carbon_ticket_number >", value, "carbonTicketNumber");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("Carbon_ticket_number >=", value, "carbonTicketNumber");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketNumberLessThan(Integer value) {
            addCriterion("Carbon_ticket_number <", value, "carbonTicketNumber");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketNumberLessThanOrEqualTo(Integer value) {
            addCriterion("Carbon_ticket_number <=", value, "carbonTicketNumber");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketNumberIn(List<Integer> values) {
            addCriterion("Carbon_ticket_number in", values, "carbonTicketNumber");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketNumberNotIn(List<Integer> values) {
            addCriterion("Carbon_ticket_number not in", values, "carbonTicketNumber");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketNumberBetween(Integer value1, Integer value2) {
            addCriterion("Carbon_ticket_number between", value1, value2, "carbonTicketNumber");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("Carbon_ticket_number not between", value1, value2, "carbonTicketNumber");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyIsNull() {
            addCriterion("Blockchain_wallet_key is null");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyIsNotNull() {
            addCriterion("Blockchain_wallet_key is not null");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyEqualTo(String value) {
            addCriterion("Blockchain_wallet_key =", value, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyNotEqualTo(String value) {
            addCriterion("Blockchain_wallet_key <>", value, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyGreaterThan(String value) {
            addCriterion("Blockchain_wallet_key >", value, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyGreaterThanOrEqualTo(String value) {
            addCriterion("Blockchain_wallet_key >=", value, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyLessThan(String value) {
            addCriterion("Blockchain_wallet_key <", value, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyLessThanOrEqualTo(String value) {
            addCriterion("Blockchain_wallet_key <=", value, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyLike(String value) {
            addCriterion("Blockchain_wallet_key like", value, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyNotLike(String value) {
            addCriterion("Blockchain_wallet_key not like", value, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyIn(List<String> values) {
            addCriterion("Blockchain_wallet_key in", values, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyNotIn(List<String> values) {
            addCriterion("Blockchain_wallet_key not in", values, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyBetween(String value1, String value2) {
            addCriterion("Blockchain_wallet_key between", value1, value2, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyNotBetween(String value1, String value2) {
            addCriterion("Blockchain_wallet_key not between", value1, value2, "blockchainWalletKey");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}