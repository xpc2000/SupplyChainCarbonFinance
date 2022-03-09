package com.example.chaincarbon.model.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketRecordExample() {
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

        public Criteria andInitiatorSupplyChainIsNull() {
            addCriterion("initiator_supply_chain is null");
            return (Criteria) this;
        }

        public Criteria andInitiatorSupplyChainIsNotNull() {
            addCriterion("initiator_supply_chain is not null");
            return (Criteria) this;
        }

        public Criteria andInitiatorSupplyChainEqualTo(String value) {
            addCriterion("initiator_supply_chain =", value, "initiatorSupplyChain");
            return (Criteria) this;
        }

        public Criteria andInitiatorSupplyChainNotEqualTo(String value) {
            addCriterion("initiator_supply_chain <>", value, "initiatorSupplyChain");
            return (Criteria) this;
        }

        public Criteria andInitiatorSupplyChainGreaterThan(String value) {
            addCriterion("initiator_supply_chain >", value, "initiatorSupplyChain");
            return (Criteria) this;
        }

        public Criteria andInitiatorSupplyChainGreaterThanOrEqualTo(String value) {
            addCriterion("initiator_supply_chain >=", value, "initiatorSupplyChain");
            return (Criteria) this;
        }

        public Criteria andInitiatorSupplyChainLessThan(String value) {
            addCriterion("initiator_supply_chain <", value, "initiatorSupplyChain");
            return (Criteria) this;
        }

        public Criteria andInitiatorSupplyChainLessThanOrEqualTo(String value) {
            addCriterion("initiator_supply_chain <=", value, "initiatorSupplyChain");
            return (Criteria) this;
        }

        public Criteria andInitiatorSupplyChainLike(String value) {
            addCriterion("initiator_supply_chain like", value, "initiatorSupplyChain");
            return (Criteria) this;
        }

        public Criteria andInitiatorSupplyChainNotLike(String value) {
            addCriterion("initiator_supply_chain not like", value, "initiatorSupplyChain");
            return (Criteria) this;
        }

        public Criteria andInitiatorSupplyChainIn(List<String> values) {
            addCriterion("initiator_supply_chain in", values, "initiatorSupplyChain");
            return (Criteria) this;
        }

        public Criteria andInitiatorSupplyChainNotIn(List<String> values) {
            addCriterion("initiator_supply_chain not in", values, "initiatorSupplyChain");
            return (Criteria) this;
        }

        public Criteria andInitiatorSupplyChainBetween(String value1, String value2) {
            addCriterion("initiator_supply_chain between", value1, value2, "initiatorSupplyChain");
            return (Criteria) this;
        }

        public Criteria andInitiatorSupplyChainNotBetween(String value1, String value2) {
            addCriterion("initiator_supply_chain not between", value1, value2, "initiatorSupplyChain");
            return (Criteria) this;
        }

        public Criteria andReceiverSupplyChainIsNull() {
            addCriterion("receiver_supply_chain is null");
            return (Criteria) this;
        }

        public Criteria andReceiverSupplyChainIsNotNull() {
            addCriterion("receiver_supply_chain is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverSupplyChainEqualTo(String value) {
            addCriterion("receiver_supply_chain =", value, "receiverSupplyChain");
            return (Criteria) this;
        }

        public Criteria andReceiverSupplyChainNotEqualTo(String value) {
            addCriterion("receiver_supply_chain <>", value, "receiverSupplyChain");
            return (Criteria) this;
        }

        public Criteria andReceiverSupplyChainGreaterThan(String value) {
            addCriterion("receiver_supply_chain >", value, "receiverSupplyChain");
            return (Criteria) this;
        }

        public Criteria andReceiverSupplyChainGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_supply_chain >=", value, "receiverSupplyChain");
            return (Criteria) this;
        }

        public Criteria andReceiverSupplyChainLessThan(String value) {
            addCriterion("receiver_supply_chain <", value, "receiverSupplyChain");
            return (Criteria) this;
        }

        public Criteria andReceiverSupplyChainLessThanOrEqualTo(String value) {
            addCriterion("receiver_supply_chain <=", value, "receiverSupplyChain");
            return (Criteria) this;
        }

        public Criteria andReceiverSupplyChainLike(String value) {
            addCriterion("receiver_supply_chain like", value, "receiverSupplyChain");
            return (Criteria) this;
        }

        public Criteria andReceiverSupplyChainNotLike(String value) {
            addCriterion("receiver_supply_chain not like", value, "receiverSupplyChain");
            return (Criteria) this;
        }

        public Criteria andReceiverSupplyChainIn(List<String> values) {
            addCriterion("receiver_supply_chain in", values, "receiverSupplyChain");
            return (Criteria) this;
        }

        public Criteria andReceiverSupplyChainNotIn(List<String> values) {
            addCriterion("receiver_supply_chain not in", values, "receiverSupplyChain");
            return (Criteria) this;
        }

        public Criteria andReceiverSupplyChainBetween(String value1, String value2) {
            addCriterion("receiver_supply_chain between", value1, value2, "receiverSupplyChain");
            return (Criteria) this;
        }

        public Criteria andReceiverSupplyChainNotBetween(String value1, String value2) {
            addCriterion("receiver_supply_chain not between", value1, value2, "receiverSupplyChain");
            return (Criteria) this;
        }

        public Criteria andInitiatorNameIsNull() {
            addCriterion("initiator_name is null");
            return (Criteria) this;
        }

        public Criteria andInitiatorNameIsNotNull() {
            addCriterion("initiator_name is not null");
            return (Criteria) this;
        }

        public Criteria andInitiatorNameEqualTo(String value) {
            addCriterion("initiator_name =", value, "initiatorName");
            return (Criteria) this;
        }

        public Criteria andInitiatorNameNotEqualTo(String value) {
            addCriterion("initiator_name <>", value, "initiatorName");
            return (Criteria) this;
        }

        public Criteria andInitiatorNameGreaterThan(String value) {
            addCriterion("initiator_name >", value, "initiatorName");
            return (Criteria) this;
        }

        public Criteria andInitiatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("initiator_name >=", value, "initiatorName");
            return (Criteria) this;
        }

        public Criteria andInitiatorNameLessThan(String value) {
            addCriterion("initiator_name <", value, "initiatorName");
            return (Criteria) this;
        }

        public Criteria andInitiatorNameLessThanOrEqualTo(String value) {
            addCriterion("initiator_name <=", value, "initiatorName");
            return (Criteria) this;
        }

        public Criteria andInitiatorNameLike(String value) {
            addCriterion("initiator_name like", value, "initiatorName");
            return (Criteria) this;
        }

        public Criteria andInitiatorNameNotLike(String value) {
            addCriterion("initiator_name not like", value, "initiatorName");
            return (Criteria) this;
        }

        public Criteria andInitiatorNameIn(List<String> values) {
            addCriterion("initiator_name in", values, "initiatorName");
            return (Criteria) this;
        }

        public Criteria andInitiatorNameNotIn(List<String> values) {
            addCriterion("initiator_name not in", values, "initiatorName");
            return (Criteria) this;
        }

        public Criteria andInitiatorNameBetween(String value1, String value2) {
            addCriterion("initiator_name between", value1, value2, "initiatorName");
            return (Criteria) this;
        }

        public Criteria andInitiatorNameNotBetween(String value1, String value2) {
            addCriterion("initiator_name not between", value1, value2, "initiatorName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNull() {
            addCriterion("receiver_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNotNull() {
            addCriterion("receiver_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameEqualTo(String value) {
            addCriterion("receiver_name =", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotEqualTo(String value) {
            addCriterion("receiver_name <>", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThan(String value) {
            addCriterion("receiver_name >", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_name >=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThan(String value) {
            addCriterion("receiver_name <", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThanOrEqualTo(String value) {
            addCriterion("receiver_name <=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLike(String value) {
            addCriterion("receiver_name like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotLike(String value) {
            addCriterion("receiver_name not like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIn(List<String> values) {
            addCriterion("receiver_name in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotIn(List<String> values) {
            addCriterion("receiver_name not in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameBetween(String value1, String value2) {
            addCriterion("receiver_name between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotBetween(String value1, String value2) {
            addCriterion("receiver_name not between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andOperationIsNull() {
            addCriterion("operation is null");
            return (Criteria) this;
        }

        public Criteria andOperationIsNotNull() {
            addCriterion("operation is not null");
            return (Criteria) this;
        }

        public Criteria andOperationEqualTo(Integer value) {
            addCriterion("operation =", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotEqualTo(Integer value) {
            addCriterion("operation <>", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationGreaterThan(Integer value) {
            addCriterion("operation >", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationGreaterThanOrEqualTo(Integer value) {
            addCriterion("operation >=", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLessThan(Integer value) {
            addCriterion("operation <", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLessThanOrEqualTo(Integer value) {
            addCriterion("operation <=", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationIn(List<Integer> values) {
            addCriterion("operation in", values, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotIn(List<Integer> values) {
            addCriterion("operation not in", values, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationBetween(Integer value1, Integer value2) {
            addCriterion("operation between", value1, value2, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotBetween(Integer value1, Integer value2) {
            addCriterion("operation not between", value1, value2, "operation");
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