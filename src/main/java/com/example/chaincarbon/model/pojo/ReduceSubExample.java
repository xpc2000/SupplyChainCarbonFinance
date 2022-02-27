package com.example.chaincarbon.model.pojo;

import java.util.ArrayList;
import java.util.List;

public class ReduceSubExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReduceSubExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andLoginIsNull() {
            addCriterion("login is null");
            return (Criteria) this;
        }

        public Criteria andLoginIsNotNull() {
            addCriterion("login is not null");
            return (Criteria) this;
        }

        public Criteria andLoginEqualTo(String value) {
            addCriterion("login =", value, "login");
            return (Criteria) this;
        }

        public Criteria andLoginNotEqualTo(String value) {
            addCriterion("login <>", value, "login");
            return (Criteria) this;
        }

        public Criteria andLoginGreaterThan(String value) {
            addCriterion("login >", value, "login");
            return (Criteria) this;
        }

        public Criteria andLoginGreaterThanOrEqualTo(String value) {
            addCriterion("login >=", value, "login");
            return (Criteria) this;
        }

        public Criteria andLoginLessThan(String value) {
            addCriterion("login <", value, "login");
            return (Criteria) this;
        }

        public Criteria andLoginLessThanOrEqualTo(String value) {
            addCriterion("login <=", value, "login");
            return (Criteria) this;
        }

        public Criteria andLoginLike(String value) {
            addCriterion("login like", value, "login");
            return (Criteria) this;
        }

        public Criteria andLoginNotLike(String value) {
            addCriterion("login not like", value, "login");
            return (Criteria) this;
        }

        public Criteria andLoginIn(List<String> values) {
            addCriterion("login in", values, "login");
            return (Criteria) this;
        }

        public Criteria andLoginNotIn(List<String> values) {
            addCriterion("login not in", values, "login");
            return (Criteria) this;
        }

        public Criteria andLoginBetween(String value1, String value2) {
            addCriterion("login between", value1, value2, "login");
            return (Criteria) this;
        }

        public Criteria andLoginNotBetween(String value1, String value2) {
            addCriterion("login not between", value1, value2, "login");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketTranferIsNull() {
            addCriterion("carbon_ticket_tranfer is null");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketTranferIsNotNull() {
            addCriterion("carbon_ticket_tranfer is not null");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketTranferEqualTo(String value) {
            addCriterion("carbon_ticket_tranfer =", value, "carbonTicketTranfer");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketTranferNotEqualTo(String value) {
            addCriterion("carbon_ticket_tranfer <>", value, "carbonTicketTranfer");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketTranferGreaterThan(String value) {
            addCriterion("carbon_ticket_tranfer >", value, "carbonTicketTranfer");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketTranferGreaterThanOrEqualTo(String value) {
            addCriterion("carbon_ticket_tranfer >=", value, "carbonTicketTranfer");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketTranferLessThan(String value) {
            addCriterion("carbon_ticket_tranfer <", value, "carbonTicketTranfer");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketTranferLessThanOrEqualTo(String value) {
            addCriterion("carbon_ticket_tranfer <=", value, "carbonTicketTranfer");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketTranferLike(String value) {
            addCriterion("carbon_ticket_tranfer like", value, "carbonTicketTranfer");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketTranferNotLike(String value) {
            addCriterion("carbon_ticket_tranfer not like", value, "carbonTicketTranfer");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketTranferIn(List<String> values) {
            addCriterion("carbon_ticket_tranfer in", values, "carbonTicketTranfer");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketTranferNotIn(List<String> values) {
            addCriterion("carbon_ticket_tranfer not in", values, "carbonTicketTranfer");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketTranferBetween(String value1, String value2) {
            addCriterion("carbon_ticket_tranfer between", value1, value2, "carbonTicketTranfer");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketTranferNotBetween(String value1, String value2) {
            addCriterion("carbon_ticket_tranfer not between", value1, value2, "carbonTicketTranfer");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketSignIsNull() {
            addCriterion("carbon_ticket_sign is null");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketSignIsNotNull() {
            addCriterion("carbon_ticket_sign is not null");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketSignEqualTo(String value) {
            addCriterion("carbon_ticket_sign =", value, "carbonTicketSign");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketSignNotEqualTo(String value) {
            addCriterion("carbon_ticket_sign <>", value, "carbonTicketSign");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketSignGreaterThan(String value) {
            addCriterion("carbon_ticket_sign >", value, "carbonTicketSign");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketSignGreaterThanOrEqualTo(String value) {
            addCriterion("carbon_ticket_sign >=", value, "carbonTicketSign");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketSignLessThan(String value) {
            addCriterion("carbon_ticket_sign <", value, "carbonTicketSign");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketSignLessThanOrEqualTo(String value) {
            addCriterion("carbon_ticket_sign <=", value, "carbonTicketSign");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketSignLike(String value) {
            addCriterion("carbon_ticket_sign like", value, "carbonTicketSign");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketSignNotLike(String value) {
            addCriterion("carbon_ticket_sign not like", value, "carbonTicketSign");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketSignIn(List<String> values) {
            addCriterion("carbon_ticket_sign in", values, "carbonTicketSign");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketSignNotIn(List<String> values) {
            addCriterion("carbon_ticket_sign not in", values, "carbonTicketSign");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketSignBetween(String value1, String value2) {
            addCriterion("carbon_ticket_sign between", value1, value2, "carbonTicketSign");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketSignNotBetween(String value1, String value2) {
            addCriterion("carbon_ticket_sign not between", value1, value2, "carbonTicketSign");
            return (Criteria) this;
        }

        public Criteria andFinancingApplicationIsNull() {
            addCriterion("financing_application is null");
            return (Criteria) this;
        }

        public Criteria andFinancingApplicationIsNotNull() {
            addCriterion("financing_application is not null");
            return (Criteria) this;
        }

        public Criteria andFinancingApplicationEqualTo(String value) {
            addCriterion("financing_application =", value, "financingApplication");
            return (Criteria) this;
        }

        public Criteria andFinancingApplicationNotEqualTo(String value) {
            addCriterion("financing_application <>", value, "financingApplication");
            return (Criteria) this;
        }

        public Criteria andFinancingApplicationGreaterThan(String value) {
            addCriterion("financing_application >", value, "financingApplication");
            return (Criteria) this;
        }

        public Criteria andFinancingApplicationGreaterThanOrEqualTo(String value) {
            addCriterion("financing_application >=", value, "financingApplication");
            return (Criteria) this;
        }

        public Criteria andFinancingApplicationLessThan(String value) {
            addCriterion("financing_application <", value, "financingApplication");
            return (Criteria) this;
        }

        public Criteria andFinancingApplicationLessThanOrEqualTo(String value) {
            addCriterion("financing_application <=", value, "financingApplication");
            return (Criteria) this;
        }

        public Criteria andFinancingApplicationLike(String value) {
            addCriterion("financing_application like", value, "financingApplication");
            return (Criteria) this;
        }

        public Criteria andFinancingApplicationNotLike(String value) {
            addCriterion("financing_application not like", value, "financingApplication");
            return (Criteria) this;
        }

        public Criteria andFinancingApplicationIn(List<String> values) {
            addCriterion("financing_application in", values, "financingApplication");
            return (Criteria) this;
        }

        public Criteria andFinancingApplicationNotIn(List<String> values) {
            addCriterion("financing_application not in", values, "financingApplication");
            return (Criteria) this;
        }

        public Criteria andFinancingApplicationBetween(String value1, String value2) {
            addCriterion("financing_application between", value1, value2, "financingApplication");
            return (Criteria) this;
        }

        public Criteria andFinancingApplicationNotBetween(String value1, String value2) {
            addCriterion("financing_application not between", value1, value2, "financingApplication");
            return (Criteria) this;
        }

        public Criteria andFinancingContractIsNull() {
            addCriterion("financing_contract is null");
            return (Criteria) this;
        }

        public Criteria andFinancingContractIsNotNull() {
            addCriterion("financing_contract is not null");
            return (Criteria) this;
        }

        public Criteria andFinancingContractEqualTo(String value) {
            addCriterion("financing_contract =", value, "financingContract");
            return (Criteria) this;
        }

        public Criteria andFinancingContractNotEqualTo(String value) {
            addCriterion("financing_contract <>", value, "financingContract");
            return (Criteria) this;
        }

        public Criteria andFinancingContractGreaterThan(String value) {
            addCriterion("financing_contract >", value, "financingContract");
            return (Criteria) this;
        }

        public Criteria andFinancingContractGreaterThanOrEqualTo(String value) {
            addCriterion("financing_contract >=", value, "financingContract");
            return (Criteria) this;
        }

        public Criteria andFinancingContractLessThan(String value) {
            addCriterion("financing_contract <", value, "financingContract");
            return (Criteria) this;
        }

        public Criteria andFinancingContractLessThanOrEqualTo(String value) {
            addCriterion("financing_contract <=", value, "financingContract");
            return (Criteria) this;
        }

        public Criteria andFinancingContractLike(String value) {
            addCriterion("financing_contract like", value, "financingContract");
            return (Criteria) this;
        }

        public Criteria andFinancingContractNotLike(String value) {
            addCriterion("financing_contract not like", value, "financingContract");
            return (Criteria) this;
        }

        public Criteria andFinancingContractIn(List<String> values) {
            addCriterion("financing_contract in", values, "financingContract");
            return (Criteria) this;
        }

        public Criteria andFinancingContractNotIn(List<String> values) {
            addCriterion("financing_contract not in", values, "financingContract");
            return (Criteria) this;
        }

        public Criteria andFinancingContractBetween(String value1, String value2) {
            addCriterion("financing_contract between", value1, value2, "financingContract");
            return (Criteria) this;
        }

        public Criteria andFinancingContractNotBetween(String value1, String value2) {
            addCriterion("financing_contract not between", value1, value2, "financingContract");
            return (Criteria) this;
        }

        public Criteria andReduceChainIsNull() {
            addCriterion("reduce_chain is null");
            return (Criteria) this;
        }

        public Criteria andReduceChainIsNotNull() {
            addCriterion("reduce_chain is not null");
            return (Criteria) this;
        }

        public Criteria andReduceChainEqualTo(String value) {
            addCriterion("reduce_chain =", value, "reduceChain");
            return (Criteria) this;
        }

        public Criteria andReduceChainNotEqualTo(String value) {
            addCriterion("reduce_chain <>", value, "reduceChain");
            return (Criteria) this;
        }

        public Criteria andReduceChainGreaterThan(String value) {
            addCriterion("reduce_chain >", value, "reduceChain");
            return (Criteria) this;
        }

        public Criteria andReduceChainGreaterThanOrEqualTo(String value) {
            addCriterion("reduce_chain >=", value, "reduceChain");
            return (Criteria) this;
        }

        public Criteria andReduceChainLessThan(String value) {
            addCriterion("reduce_chain <", value, "reduceChain");
            return (Criteria) this;
        }

        public Criteria andReduceChainLessThanOrEqualTo(String value) {
            addCriterion("reduce_chain <=", value, "reduceChain");
            return (Criteria) this;
        }

        public Criteria andReduceChainLike(String value) {
            addCriterion("reduce_chain like", value, "reduceChain");
            return (Criteria) this;
        }

        public Criteria andReduceChainNotLike(String value) {
            addCriterion("reduce_chain not like", value, "reduceChain");
            return (Criteria) this;
        }

        public Criteria andReduceChainIn(List<String> values) {
            addCriterion("reduce_chain in", values, "reduceChain");
            return (Criteria) this;
        }

        public Criteria andReduceChainNotIn(List<String> values) {
            addCriterion("reduce_chain not in", values, "reduceChain");
            return (Criteria) this;
        }

        public Criteria andReduceChainBetween(String value1, String value2) {
            addCriterion("reduce_chain between", value1, value2, "reduceChain");
            return (Criteria) this;
        }

        public Criteria andReduceChainNotBetween(String value1, String value2) {
            addCriterion("reduce_chain not between", value1, value2, "reduceChain");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketBalanceIsNull() {
            addCriterion("carbon_ticket_balance is null");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketBalanceIsNotNull() {
            addCriterion("carbon_ticket_balance is not null");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketBalanceEqualTo(Integer value) {
            addCriterion("carbon_ticket_balance =", value, "carbonTicketBalance");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketBalanceNotEqualTo(Integer value) {
            addCriterion("carbon_ticket_balance <>", value, "carbonTicketBalance");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketBalanceGreaterThan(Integer value) {
            addCriterion("carbon_ticket_balance >", value, "carbonTicketBalance");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketBalanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("carbon_ticket_balance >=", value, "carbonTicketBalance");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketBalanceLessThan(Integer value) {
            addCriterion("carbon_ticket_balance <", value, "carbonTicketBalance");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketBalanceLessThanOrEqualTo(Integer value) {
            addCriterion("carbon_ticket_balance <=", value, "carbonTicketBalance");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketBalanceIn(List<Integer> values) {
            addCriterion("carbon_ticket_balance in", values, "carbonTicketBalance");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketBalanceNotIn(List<Integer> values) {
            addCriterion("carbon_ticket_balance not in", values, "carbonTicketBalance");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketBalanceBetween(Integer value1, Integer value2) {
            addCriterion("carbon_ticket_balance between", value1, value2, "carbonTicketBalance");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketBalanceNotBetween(Integer value1, Integer value2) {
            addCriterion("carbon_ticket_balance not between", value1, value2, "carbonTicketBalance");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyIsNull() {
            addCriterion("blockchain_wallet_key is null");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyIsNotNull() {
            addCriterion("blockchain_wallet_key is not null");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyEqualTo(String value) {
            addCriterion("blockchain_wallet_key =", value, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyNotEqualTo(String value) {
            addCriterion("blockchain_wallet_key <>", value, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyGreaterThan(String value) {
            addCriterion("blockchain_wallet_key >", value, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyGreaterThanOrEqualTo(String value) {
            addCriterion("blockchain_wallet_key >=", value, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyLessThan(String value) {
            addCriterion("blockchain_wallet_key <", value, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyLessThanOrEqualTo(String value) {
            addCriterion("blockchain_wallet_key <=", value, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyLike(String value) {
            addCriterion("blockchain_wallet_key like", value, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyNotLike(String value) {
            addCriterion("blockchain_wallet_key not like", value, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyIn(List<String> values) {
            addCriterion("blockchain_wallet_key in", values, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyNotIn(List<String> values) {
            addCriterion("blockchain_wallet_key not in", values, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyBetween(String value1, String value2) {
            addCriterion("blockchain_wallet_key between", value1, value2, "blockchainWalletKey");
            return (Criteria) this;
        }

        public Criteria andBlockchainWalletKeyNotBetween(String value1, String value2) {
            addCriterion("blockchain_wallet_key not between", value1, value2, "blockchainWalletKey");
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