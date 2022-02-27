package com.example.chaincarbon.model.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlanExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andAmountReduceIsNull() {
            addCriterion("amount_reduce is null");
            return (Criteria) this;
        }

        public Criteria andAmountReduceIsNotNull() {
            addCriterion("amount_reduce is not null");
            return (Criteria) this;
        }

        public Criteria andAmountReduceEqualTo(Integer value) {
            addCriterion("amount_reduce =", value, "amountReduce");
            return (Criteria) this;
        }

        public Criteria andAmountReduceNotEqualTo(Integer value) {
            addCriterion("amount_reduce <>", value, "amountReduce");
            return (Criteria) this;
        }

        public Criteria andAmountReduceGreaterThan(Integer value) {
            addCriterion("amount_reduce >", value, "amountReduce");
            return (Criteria) this;
        }

        public Criteria andAmountReduceGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount_reduce >=", value, "amountReduce");
            return (Criteria) this;
        }

        public Criteria andAmountReduceLessThan(Integer value) {
            addCriterion("amount_reduce <", value, "amountReduce");
            return (Criteria) this;
        }

        public Criteria andAmountReduceLessThanOrEqualTo(Integer value) {
            addCriterion("amount_reduce <=", value, "amountReduce");
            return (Criteria) this;
        }

        public Criteria andAmountReduceIn(List<Integer> values) {
            addCriterion("amount_reduce in", values, "amountReduce");
            return (Criteria) this;
        }

        public Criteria andAmountReduceNotIn(List<Integer> values) {
            addCriterion("amount_reduce not in", values, "amountReduce");
            return (Criteria) this;
        }

        public Criteria andAmountReduceBetween(Integer value1, Integer value2) {
            addCriterion("amount_reduce between", value1, value2, "amountReduce");
            return (Criteria) this;
        }

        public Criteria andAmountReduceNotBetween(Integer value1, Integer value2) {
            addCriterion("amount_reduce not between", value1, value2, "amountReduce");
            return (Criteria) this;
        }

        public Criteria andDeclarationCarbonTicketIsNull() {
            addCriterion("declaration_carbon_ticket is null");
            return (Criteria) this;
        }

        public Criteria andDeclarationCarbonTicketIsNotNull() {
            addCriterion("declaration_carbon_ticket is not null");
            return (Criteria) this;
        }

        public Criteria andDeclarationCarbonTicketEqualTo(Integer value) {
            addCriterion("declaration_carbon_ticket =", value, "declarationCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andDeclarationCarbonTicketNotEqualTo(Integer value) {
            addCriterion("declaration_carbon_ticket <>", value, "declarationCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andDeclarationCarbonTicketGreaterThan(Integer value) {
            addCriterion("declaration_carbon_ticket >", value, "declarationCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andDeclarationCarbonTicketGreaterThanOrEqualTo(Integer value) {
            addCriterion("declaration_carbon_ticket >=", value, "declarationCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andDeclarationCarbonTicketLessThan(Integer value) {
            addCriterion("declaration_carbon_ticket <", value, "declarationCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andDeclarationCarbonTicketLessThanOrEqualTo(Integer value) {
            addCriterion("declaration_carbon_ticket <=", value, "declarationCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andDeclarationCarbonTicketIn(List<Integer> values) {
            addCriterion("declaration_carbon_ticket in", values, "declarationCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andDeclarationCarbonTicketNotIn(List<Integer> values) {
            addCriterion("declaration_carbon_ticket not in", values, "declarationCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andDeclarationCarbonTicketBetween(Integer value1, Integer value2) {
            addCriterion("declaration_carbon_ticket between", value1, value2, "declarationCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andDeclarationCarbonTicketNotBetween(Integer value1, Integer value2) {
            addCriterion("declaration_carbon_ticket not between", value1, value2, "declarationCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Date value) {
            addCriterionForJDBCDate("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Date value) {
            addCriterionForJDBCDate("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Date value) {
            addCriterionForJDBCDate("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Date value) {
            addCriterionForJDBCDate("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Date> values) {
            addCriterionForJDBCDate("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Date> values) {
            addCriterionForJDBCDate("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("year not between", value1, value2, "year");
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