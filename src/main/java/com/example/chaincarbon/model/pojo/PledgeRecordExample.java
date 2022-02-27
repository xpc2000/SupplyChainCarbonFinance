package com.example.chaincarbon.model.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PledgeRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PledgeRecordExample() {
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

        public Criteria andQuotaQuantityIsNull() {
            addCriterion("quota_quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuotaQuantityIsNotNull() {
            addCriterion("quota_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuotaQuantityEqualTo(Integer value) {
            addCriterion("quota_quantity =", value, "quotaQuantity");
            return (Criteria) this;
        }

        public Criteria andQuotaQuantityNotEqualTo(Integer value) {
            addCriterion("quota_quantity <>", value, "quotaQuantity");
            return (Criteria) this;
        }

        public Criteria andQuotaQuantityGreaterThan(Integer value) {
            addCriterion("quota_quantity >", value, "quotaQuantity");
            return (Criteria) this;
        }

        public Criteria andQuotaQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quota_quantity >=", value, "quotaQuantity");
            return (Criteria) this;
        }

        public Criteria andQuotaQuantityLessThan(Integer value) {
            addCriterion("quota_quantity <", value, "quotaQuantity");
            return (Criteria) this;
        }

        public Criteria andQuotaQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quota_quantity <=", value, "quotaQuantity");
            return (Criteria) this;
        }

        public Criteria andQuotaQuantityIn(List<Integer> values) {
            addCriterion("quota_quantity in", values, "quotaQuantity");
            return (Criteria) this;
        }

        public Criteria andQuotaQuantityNotIn(List<Integer> values) {
            addCriterion("quota_quantity not in", values, "quotaQuantity");
            return (Criteria) this;
        }

        public Criteria andQuotaQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quota_quantity between", value1, value2, "quotaQuantity");
            return (Criteria) this;
        }

        public Criteria andQuotaQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quota_quantity not between", value1, value2, "quotaQuantity");
            return (Criteria) this;
        }

        public Criteria andQuotaOwnerIsNull() {
            addCriterion("quota_owner is null");
            return (Criteria) this;
        }

        public Criteria andQuotaOwnerIsNotNull() {
            addCriterion("quota_owner is not null");
            return (Criteria) this;
        }

        public Criteria andQuotaOwnerEqualTo(String value) {
            addCriterion("quota_owner =", value, "quotaOwner");
            return (Criteria) this;
        }

        public Criteria andQuotaOwnerNotEqualTo(String value) {
            addCriterion("quota_owner <>", value, "quotaOwner");
            return (Criteria) this;
        }

        public Criteria andQuotaOwnerGreaterThan(String value) {
            addCriterion("quota_owner >", value, "quotaOwner");
            return (Criteria) this;
        }

        public Criteria andQuotaOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("quota_owner >=", value, "quotaOwner");
            return (Criteria) this;
        }

        public Criteria andQuotaOwnerLessThan(String value) {
            addCriterion("quota_owner <", value, "quotaOwner");
            return (Criteria) this;
        }

        public Criteria andQuotaOwnerLessThanOrEqualTo(String value) {
            addCriterion("quota_owner <=", value, "quotaOwner");
            return (Criteria) this;
        }

        public Criteria andQuotaOwnerLike(String value) {
            addCriterion("quota_owner like", value, "quotaOwner");
            return (Criteria) this;
        }

        public Criteria andQuotaOwnerNotLike(String value) {
            addCriterion("quota_owner not like", value, "quotaOwner");
            return (Criteria) this;
        }

        public Criteria andQuotaOwnerIn(List<String> values) {
            addCriterion("quota_owner in", values, "quotaOwner");
            return (Criteria) this;
        }

        public Criteria andQuotaOwnerNotIn(List<String> values) {
            addCriterion("quota_owner not in", values, "quotaOwner");
            return (Criteria) this;
        }

        public Criteria andQuotaOwnerBetween(String value1, String value2) {
            addCriterion("quota_owner between", value1, value2, "quotaOwner");
            return (Criteria) this;
        }

        public Criteria andQuotaOwnerNotBetween(String value1, String value2) {
            addCriterion("quota_owner not between", value1, value2, "quotaOwner");
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

        public Criteria andPledgeRateIsNull() {
            addCriterion("pledge_rate is null");
            return (Criteria) this;
        }

        public Criteria andPledgeRateIsNotNull() {
            addCriterion("pledge_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPledgeRateEqualTo(Float value) {
            addCriterion("pledge_rate =", value, "pledgeRate");
            return (Criteria) this;
        }

        public Criteria andPledgeRateNotEqualTo(Float value) {
            addCriterion("pledge_rate <>", value, "pledgeRate");
            return (Criteria) this;
        }

        public Criteria andPledgeRateGreaterThan(Float value) {
            addCriterion("pledge_rate >", value, "pledgeRate");
            return (Criteria) this;
        }

        public Criteria andPledgeRateGreaterThanOrEqualTo(Float value) {
            addCriterion("pledge_rate >=", value, "pledgeRate");
            return (Criteria) this;
        }

        public Criteria andPledgeRateLessThan(Float value) {
            addCriterion("pledge_rate <", value, "pledgeRate");
            return (Criteria) this;
        }

        public Criteria andPledgeRateLessThanOrEqualTo(Float value) {
            addCriterion("pledge_rate <=", value, "pledgeRate");
            return (Criteria) this;
        }

        public Criteria andPledgeRateIn(List<Float> values) {
            addCriterion("pledge_rate in", values, "pledgeRate");
            return (Criteria) this;
        }

        public Criteria andPledgeRateNotIn(List<Float> values) {
            addCriterion("pledge_rate not in", values, "pledgeRate");
            return (Criteria) this;
        }

        public Criteria andPledgeRateBetween(Float value1, Float value2) {
            addCriterion("pledge_rate between", value1, value2, "pledgeRate");
            return (Criteria) this;
        }

        public Criteria andPledgeRateNotBetween(Float value1, Float value2) {
            addCriterion("pledge_rate not between", value1, value2, "pledgeRate");
            return (Criteria) this;
        }

        public Criteria andPledgeAmountIsNull() {
            addCriterion("pledge_amount is null");
            return (Criteria) this;
        }

        public Criteria andPledgeAmountIsNotNull() {
            addCriterion("pledge_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPledgeAmountEqualTo(Integer value) {
            addCriterion("pledge_amount =", value, "pledgeAmount");
            return (Criteria) this;
        }

        public Criteria andPledgeAmountNotEqualTo(Integer value) {
            addCriterion("pledge_amount <>", value, "pledgeAmount");
            return (Criteria) this;
        }

        public Criteria andPledgeAmountGreaterThan(Integer value) {
            addCriterion("pledge_amount >", value, "pledgeAmount");
            return (Criteria) this;
        }

        public Criteria andPledgeAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("pledge_amount >=", value, "pledgeAmount");
            return (Criteria) this;
        }

        public Criteria andPledgeAmountLessThan(Integer value) {
            addCriterion("pledge_amount <", value, "pledgeAmount");
            return (Criteria) this;
        }

        public Criteria andPledgeAmountLessThanOrEqualTo(Integer value) {
            addCriterion("pledge_amount <=", value, "pledgeAmount");
            return (Criteria) this;
        }

        public Criteria andPledgeAmountIn(List<Integer> values) {
            addCriterion("pledge_amount in", values, "pledgeAmount");
            return (Criteria) this;
        }

        public Criteria andPledgeAmountNotIn(List<Integer> values) {
            addCriterion("pledge_amount not in", values, "pledgeAmount");
            return (Criteria) this;
        }

        public Criteria andPledgeAmountBetween(Integer value1, Integer value2) {
            addCriterion("pledge_amount between", value1, value2, "pledgeAmount");
            return (Criteria) this;
        }

        public Criteria andPledgeAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("pledge_amount not between", value1, value2, "pledgeAmount");
            return (Criteria) this;
        }

        public Criteria andLoanTermIsNull() {
            addCriterion("loan_term is null");
            return (Criteria) this;
        }

        public Criteria andLoanTermIsNotNull() {
            addCriterion("loan_term is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTermEqualTo(Date value) {
            addCriterion("loan_term =", value, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermNotEqualTo(Date value) {
            addCriterion("loan_term <>", value, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermGreaterThan(Date value) {
            addCriterion("loan_term >", value, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermGreaterThanOrEqualTo(Date value) {
            addCriterion("loan_term >=", value, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermLessThan(Date value) {
            addCriterion("loan_term <", value, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermLessThanOrEqualTo(Date value) {
            addCriterion("loan_term <=", value, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermIn(List<Date> values) {
            addCriterion("loan_term in", values, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermNotIn(List<Date> values) {
            addCriterion("loan_term not in", values, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermBetween(Date value1, Date value2) {
            addCriterion("loan_term between", value1, value2, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermNotBetween(Date value1, Date value2) {
            addCriterion("loan_term not between", value1, value2, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateIsNull() {
            addCriterion("loan_interest_rate is null");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateIsNotNull() {
            addCriterion("loan_interest_rate is not null");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateEqualTo(Float value) {
            addCriterion("loan_interest_rate =", value, "loanInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateNotEqualTo(Float value) {
            addCriterion("loan_interest_rate <>", value, "loanInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateGreaterThan(Float value) {
            addCriterion("loan_interest_rate >", value, "loanInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateGreaterThanOrEqualTo(Float value) {
            addCriterion("loan_interest_rate >=", value, "loanInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateLessThan(Float value) {
            addCriterion("loan_interest_rate <", value, "loanInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateLessThanOrEqualTo(Float value) {
            addCriterion("loan_interest_rate <=", value, "loanInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateIn(List<Float> values) {
            addCriterion("loan_interest_rate in", values, "loanInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateNotIn(List<Float> values) {
            addCriterion("loan_interest_rate not in", values, "loanInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateBetween(Float value1, Float value2) {
            addCriterion("loan_interest_rate between", value1, value2, "loanInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateNotBetween(Float value1, Float value2) {
            addCriterion("loan_interest_rate not between", value1, value2, "loanInterestRate");
            return (Criteria) this;
        }

        public Criteria andOperationDataIsNull() {
            addCriterion("operation_data is null");
            return (Criteria) this;
        }

        public Criteria andOperationDataIsNotNull() {
            addCriterion("operation_data is not null");
            return (Criteria) this;
        }

        public Criteria andOperationDataEqualTo(Date value) {
            addCriterion("operation_data =", value, "operationData");
            return (Criteria) this;
        }

        public Criteria andOperationDataNotEqualTo(Date value) {
            addCriterion("operation_data <>", value, "operationData");
            return (Criteria) this;
        }

        public Criteria andOperationDataGreaterThan(Date value) {
            addCriterion("operation_data >", value, "operationData");
            return (Criteria) this;
        }

        public Criteria andOperationDataGreaterThanOrEqualTo(Date value) {
            addCriterion("operation_data >=", value, "operationData");
            return (Criteria) this;
        }

        public Criteria andOperationDataLessThan(Date value) {
            addCriterion("operation_data <", value, "operationData");
            return (Criteria) this;
        }

        public Criteria andOperationDataLessThanOrEqualTo(Date value) {
            addCriterion("operation_data <=", value, "operationData");
            return (Criteria) this;
        }

        public Criteria andOperationDataIn(List<Date> values) {
            addCriterion("operation_data in", values, "operationData");
            return (Criteria) this;
        }

        public Criteria andOperationDataNotIn(List<Date> values) {
            addCriterion("operation_data not in", values, "operationData");
            return (Criteria) this;
        }

        public Criteria andOperationDataBetween(Date value1, Date value2) {
            addCriterion("operation_data between", value1, value2, "operationData");
            return (Criteria) this;
        }

        public Criteria andOperationDataNotBetween(Date value1, Date value2) {
            addCriterion("operation_data not between", value1, value2, "operationData");
            return (Criteria) this;
        }

        public Criteria andControlChainIsNull() {
            addCriterion("control_chain is null");
            return (Criteria) this;
        }

        public Criteria andControlChainIsNotNull() {
            addCriterion("control_chain is not null");
            return (Criteria) this;
        }

        public Criteria andControlChainEqualTo(String value) {
            addCriterion("control_chain =", value, "controlChain");
            return (Criteria) this;
        }

        public Criteria andControlChainNotEqualTo(String value) {
            addCriterion("control_chain <>", value, "controlChain");
            return (Criteria) this;
        }

        public Criteria andControlChainGreaterThan(String value) {
            addCriterion("control_chain >", value, "controlChain");
            return (Criteria) this;
        }

        public Criteria andControlChainGreaterThanOrEqualTo(String value) {
            addCriterion("control_chain >=", value, "controlChain");
            return (Criteria) this;
        }

        public Criteria andControlChainLessThan(String value) {
            addCriterion("control_chain <", value, "controlChain");
            return (Criteria) this;
        }

        public Criteria andControlChainLessThanOrEqualTo(String value) {
            addCriterion("control_chain <=", value, "controlChain");
            return (Criteria) this;
        }

        public Criteria andControlChainLike(String value) {
            addCriterion("control_chain like", value, "controlChain");
            return (Criteria) this;
        }

        public Criteria andControlChainNotLike(String value) {
            addCriterion("control_chain not like", value, "controlChain");
            return (Criteria) this;
        }

        public Criteria andControlChainIn(List<String> values) {
            addCriterion("control_chain in", values, "controlChain");
            return (Criteria) this;
        }

        public Criteria andControlChainNotIn(List<String> values) {
            addCriterion("control_chain not in", values, "controlChain");
            return (Criteria) this;
        }

        public Criteria andControlChainBetween(String value1, String value2) {
            addCriterion("control_chain between", value1, value2, "controlChain");
            return (Criteria) this;
        }

        public Criteria andControlChainNotBetween(String value1, String value2) {
            addCriterion("control_chain not between", value1, value2, "controlChain");
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

        public Criteria andConditionIsNull() {
            addCriterion("condition is null");
            return (Criteria) this;
        }

        public Criteria andConditionIsNotNull() {
            addCriterion("condition is not null");
            return (Criteria) this;
        }

        public Criteria andConditionEqualTo(Integer value) {
            addCriterion("condition =", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotEqualTo(Integer value) {
            addCriterion("condition <>", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionGreaterThan(Integer value) {
            addCriterion("condition >", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionGreaterThanOrEqualTo(Integer value) {
            addCriterion("condition >=", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionLessThan(Integer value) {
            addCriterion("condition <", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionLessThanOrEqualTo(Integer value) {
            addCriterion("condition <=", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionIn(List<Integer> values) {
            addCriterion("condition in", values, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotIn(List<Integer> values) {
            addCriterion("condition not in", values, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionBetween(Integer value1, Integer value2) {
            addCriterion("condition between", value1, value2, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotBetween(Integer value1, Integer value2) {
            addCriterion("condition not between", value1, value2, "condition");
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