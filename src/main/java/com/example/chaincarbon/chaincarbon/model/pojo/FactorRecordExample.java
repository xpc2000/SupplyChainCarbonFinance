package com.example.chaincarbon.model.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FactorRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FactorRecordExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andFactoringCompanyIsNull() {
            addCriterion("factoring_company is null");
            return (Criteria) this;
        }

        public Criteria andFactoringCompanyIsNotNull() {
            addCriterion("factoring_company is not null");
            return (Criteria) this;
        }

        public Criteria andFactoringCompanyEqualTo(String value) {
            addCriterion("factoring_company =", value, "factoringCompany");
            return (Criteria) this;
        }

        public Criteria andFactoringCompanyNotEqualTo(String value) {
            addCriterion("factoring_company <>", value, "factoringCompany");
            return (Criteria) this;
        }

        public Criteria andFactoringCompanyGreaterThan(String value) {
            addCriterion("factoring_company >", value, "factoringCompany");
            return (Criteria) this;
        }

        public Criteria andFactoringCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("factoring_company >=", value, "factoringCompany");
            return (Criteria) this;
        }

        public Criteria andFactoringCompanyLessThan(String value) {
            addCriterion("factoring_company <", value, "factoringCompany");
            return (Criteria) this;
        }

        public Criteria andFactoringCompanyLessThanOrEqualTo(String value) {
            addCriterion("factoring_company <=", value, "factoringCompany");
            return (Criteria) this;
        }

        public Criteria andFactoringCompanyLike(String value) {
            addCriterion("factoring_company like", value, "factoringCompany");
            return (Criteria) this;
        }

        public Criteria andFactoringCompanyNotLike(String value) {
            addCriterion("factoring_company not like", value, "factoringCompany");
            return (Criteria) this;
        }

        public Criteria andFactoringCompanyIn(List<String> values) {
            addCriterion("factoring_company in", values, "factoringCompany");
            return (Criteria) this;
        }

        public Criteria andFactoringCompanyNotIn(List<String> values) {
            addCriterion("factoring_company not in", values, "factoringCompany");
            return (Criteria) this;
        }

        public Criteria andFactoringCompanyBetween(String value1, String value2) {
            addCriterion("factoring_company between", value1, value2, "factoringCompany");
            return (Criteria) this;
        }

        public Criteria andFactoringCompanyNotBetween(String value1, String value2) {
            addCriterion("factoring_company not between", value1, value2, "factoringCompany");
            return (Criteria) this;
        }

        public Criteria andAmountCarbonTicketIsNull() {
            addCriterion("amount_carbon_ticket is null");
            return (Criteria) this;
        }

        public Criteria andAmountCarbonTicketIsNotNull() {
            addCriterion("amount_carbon_ticket is not null");
            return (Criteria) this;
        }

        public Criteria andAmountCarbonTicketEqualTo(Integer value) {
            addCriterion("amount_carbon_ticket =", value, "amountCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andAmountCarbonTicketNotEqualTo(Integer value) {
            addCriterion("amount_carbon_ticket <>", value, "amountCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andAmountCarbonTicketGreaterThan(Integer value) {
            addCriterion("amount_carbon_ticket >", value, "amountCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andAmountCarbonTicketGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount_carbon_ticket >=", value, "amountCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andAmountCarbonTicketLessThan(Integer value) {
            addCriterion("amount_carbon_ticket <", value, "amountCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andAmountCarbonTicketLessThanOrEqualTo(Integer value) {
            addCriterion("amount_carbon_ticket <=", value, "amountCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andAmountCarbonTicketIn(List<Integer> values) {
            addCriterion("amount_carbon_ticket in", values, "amountCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andAmountCarbonTicketNotIn(List<Integer> values) {
            addCriterion("amount_carbon_ticket not in", values, "amountCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andAmountCarbonTicketBetween(Integer value1, Integer value2) {
            addCriterion("amount_carbon_ticket between", value1, value2, "amountCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andAmountCarbonTicketNotBetween(Integer value1, Integer value2) {
            addCriterion("amount_carbon_ticket not between", value1, value2, "amountCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountIsNull() {
            addCriterion("financing_amount is null");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountIsNotNull() {
            addCriterion("financing_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountEqualTo(Integer value) {
            addCriterion("financing_amount =", value, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountNotEqualTo(Integer value) {
            addCriterion("financing_amount <>", value, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountGreaterThan(Integer value) {
            addCriterion("financing_amount >", value, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("financing_amount >=", value, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountLessThan(Integer value) {
            addCriterion("financing_amount <", value, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountLessThanOrEqualTo(Integer value) {
            addCriterion("financing_amount <=", value, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountIn(List<Integer> values) {
            addCriterion("financing_amount in", values, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountNotIn(List<Integer> values) {
            addCriterion("financing_amount not in", values, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountBetween(Integer value1, Integer value2) {
            addCriterion("financing_amount between", value1, value2, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("financing_amount not between", value1, value2, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingTermIsNull() {
            addCriterion("financing_term is null");
            return (Criteria) this;
        }

        public Criteria andFinancingTermIsNotNull() {
            addCriterion("financing_term is not null");
            return (Criteria) this;
        }

        public Criteria andFinancingTermEqualTo(Date value) {
            addCriterion("financing_term =", value, "financingTerm");
            return (Criteria) this;
        }

        public Criteria andFinancingTermNotEqualTo(Date value) {
            addCriterion("financing_term <>", value, "financingTerm");
            return (Criteria) this;
        }

        public Criteria andFinancingTermGreaterThan(Date value) {
            addCriterion("financing_term >", value, "financingTerm");
            return (Criteria) this;
        }

        public Criteria andFinancingTermGreaterThanOrEqualTo(Date value) {
            addCriterion("financing_term >=", value, "financingTerm");
            return (Criteria) this;
        }

        public Criteria andFinancingTermLessThan(Date value) {
            addCriterion("financing_term <", value, "financingTerm");
            return (Criteria) this;
        }

        public Criteria andFinancingTermLessThanOrEqualTo(Date value) {
            addCriterion("financing_term <=", value, "financingTerm");
            return (Criteria) this;
        }

        public Criteria andFinancingTermIn(List<Date> values) {
            addCriterion("financing_term in", values, "financingTerm");
            return (Criteria) this;
        }

        public Criteria andFinancingTermNotIn(List<Date> values) {
            addCriterion("financing_term not in", values, "financingTerm");
            return (Criteria) this;
        }

        public Criteria andFinancingTermBetween(Date value1, Date value2) {
            addCriterion("financing_term between", value1, value2, "financingTerm");
            return (Criteria) this;
        }

        public Criteria andFinancingTermNotBetween(Date value1, Date value2) {
            addCriterion("financing_term not between", value1, value2, "financingTerm");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIsNull() {
            addCriterion("operation_time is null");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIsNotNull() {
            addCriterion("operation_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperationTimeEqualTo(Date value) {
            addCriterion("operation_time =", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotEqualTo(Date value) {
            addCriterion("operation_time <>", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeGreaterThan(Date value) {
            addCriterion("operation_time >", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operation_time >=", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLessThan(Date value) {
            addCriterion("operation_time <", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLessThanOrEqualTo(Date value) {
            addCriterion("operation_time <=", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIn(List<Date> values) {
            addCriterion("operation_time in", values, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotIn(List<Date> values) {
            addCriterion("operation_time not in", values, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeBetween(Date value1, Date value2) {
            addCriterion("operation_time between", value1, value2, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotBetween(Date value1, Date value2) {
            addCriterion("operation_time not between", value1, value2, "operationTime");
            return (Criteria) this;
        }

        public Criteria andServiceRateIsNull() {
            addCriterion("service_rate is null");
            return (Criteria) this;
        }

        public Criteria andServiceRateIsNotNull() {
            addCriterion("service_rate is not null");
            return (Criteria) this;
        }

        public Criteria andServiceRateEqualTo(Float value) {
            addCriterion("service_rate =", value, "serviceRate");
            return (Criteria) this;
        }

        public Criteria andServiceRateNotEqualTo(Float value) {
            addCriterion("service_rate <>", value, "serviceRate");
            return (Criteria) this;
        }

        public Criteria andServiceRateGreaterThan(Float value) {
            addCriterion("service_rate >", value, "serviceRate");
            return (Criteria) this;
        }

        public Criteria andServiceRateGreaterThanOrEqualTo(Float value) {
            addCriterion("service_rate >=", value, "serviceRate");
            return (Criteria) this;
        }

        public Criteria andServiceRateLessThan(Float value) {
            addCriterion("service_rate <", value, "serviceRate");
            return (Criteria) this;
        }

        public Criteria andServiceRateLessThanOrEqualTo(Float value) {
            addCriterion("service_rate <=", value, "serviceRate");
            return (Criteria) this;
        }

        public Criteria andServiceRateIn(List<Float> values) {
            addCriterion("service_rate in", values, "serviceRate");
            return (Criteria) this;
        }

        public Criteria andServiceRateNotIn(List<Float> values) {
            addCriterion("service_rate not in", values, "serviceRate");
            return (Criteria) this;
        }

        public Criteria andServiceRateBetween(Float value1, Float value2) {
            addCriterion("service_rate between", value1, value2, "serviceRate");
            return (Criteria) this;
        }

        public Criteria andServiceRateNotBetween(Float value1, Float value2) {
            addCriterion("service_rate not between", value1, value2, "serviceRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateIsNull() {
            addCriterion("interest_rate is null");
            return (Criteria) this;
        }

        public Criteria andInterestRateIsNotNull() {
            addCriterion("interest_rate is not null");
            return (Criteria) this;
        }

        public Criteria andInterestRateEqualTo(Float value) {
            addCriterion("interest_rate =", value, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateNotEqualTo(Float value) {
            addCriterion("interest_rate <>", value, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateGreaterThan(Float value) {
            addCriterion("interest_rate >", value, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateGreaterThanOrEqualTo(Float value) {
            addCriterion("interest_rate >=", value, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateLessThan(Float value) {
            addCriterion("interest_rate <", value, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateLessThanOrEqualTo(Float value) {
            addCriterion("interest_rate <=", value, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateIn(List<Float> values) {
            addCriterion("interest_rate in", values, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateNotIn(List<Float> values) {
            addCriterion("interest_rate not in", values, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateBetween(Float value1, Float value2) {
            addCriterion("interest_rate between", value1, value2, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateNotBetween(Float value1, Float value2) {
            addCriterion("interest_rate not between", value1, value2, "interestRate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andFundUseIsNull() {
            addCriterion("fund_use is null");
            return (Criteria) this;
        }

        public Criteria andFundUseIsNotNull() {
            addCriterion("fund_use is not null");
            return (Criteria) this;
        }

        public Criteria andFundUseEqualTo(String value) {
            addCriterion("fund_use =", value, "fundUse");
            return (Criteria) this;
        }

        public Criteria andFundUseNotEqualTo(String value) {
            addCriterion("fund_use <>", value, "fundUse");
            return (Criteria) this;
        }

        public Criteria andFundUseGreaterThan(String value) {
            addCriterion("fund_use >", value, "fundUse");
            return (Criteria) this;
        }

        public Criteria andFundUseGreaterThanOrEqualTo(String value) {
            addCriterion("fund_use >=", value, "fundUse");
            return (Criteria) this;
        }

        public Criteria andFundUseLessThan(String value) {
            addCriterion("fund_use <", value, "fundUse");
            return (Criteria) this;
        }

        public Criteria andFundUseLessThanOrEqualTo(String value) {
            addCriterion("fund_use <=", value, "fundUse");
            return (Criteria) this;
        }

        public Criteria andFundUseLike(String value) {
            addCriterion("fund_use like", value, "fundUse");
            return (Criteria) this;
        }

        public Criteria andFundUseNotLike(String value) {
            addCriterion("fund_use not like", value, "fundUse");
            return (Criteria) this;
        }

        public Criteria andFundUseIn(List<String> values) {
            addCriterion("fund_use in", values, "fundUse");
            return (Criteria) this;
        }

        public Criteria andFundUseNotIn(List<String> values) {
            addCriterion("fund_use not in", values, "fundUse");
            return (Criteria) this;
        }

        public Criteria andFundUseBetween(String value1, String value2) {
            addCriterion("fund_use between", value1, value2, "fundUse");
            return (Criteria) this;
        }

        public Criteria andFundUseNotBetween(String value1, String value2) {
            addCriterion("fund_use not between", value1, value2, "fundUse");
            return (Criteria) this;
        }

        public Criteria andBankIsNull() {
            addCriterion("bank is null");
            return (Criteria) this;
        }

        public Criteria andBankIsNotNull() {
            addCriterion("bank is not null");
            return (Criteria) this;
        }

        public Criteria andBankEqualTo(String value) {
            addCriterion("bank =", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotEqualTo(String value) {
            addCriterion("bank <>", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThan(String value) {
            addCriterion("bank >", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThanOrEqualTo(String value) {
            addCriterion("bank >=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThan(String value) {
            addCriterion("bank <", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThanOrEqualTo(String value) {
            addCriterion("bank <=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLike(String value) {
            addCriterion("bank like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotLike(String value) {
            addCriterion("bank not like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankIn(List<String> values) {
            addCriterion("bank in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotIn(List<String> values) {
            addCriterion("bank not in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankBetween(String value1, String value2) {
            addCriterion("bank between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotBetween(String value1, String value2) {
            addCriterion("bank not between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
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