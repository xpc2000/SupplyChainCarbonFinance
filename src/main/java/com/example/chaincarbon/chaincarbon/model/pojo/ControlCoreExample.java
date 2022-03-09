package com.example.chaincarbon.model.pojo;

import java.util.ArrayList;
import java.util.List;

public class ControlCoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ControlCoreExample() {
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

        public Criteria andChainRelationshipIsNull() {
            addCriterion("Chain_relationship is null");
            return (Criteria) this;
        }

        public Criteria andChainRelationshipIsNotNull() {
            addCriterion("Chain_relationship is not null");
            return (Criteria) this;
        }

        public Criteria andChainRelationshipEqualTo(String value) {
            addCriterion("Chain_relationship =", value, "chainRelationship");
            return (Criteria) this;
        }

        public Criteria andChainRelationshipNotEqualTo(String value) {
            addCriterion("Chain_relationship <>", value, "chainRelationship");
            return (Criteria) this;
        }

        public Criteria andChainRelationshipGreaterThan(String value) {
            addCriterion("Chain_relationship >", value, "chainRelationship");
            return (Criteria) this;
        }

        public Criteria andChainRelationshipGreaterThanOrEqualTo(String value) {
            addCriterion("Chain_relationship >=", value, "chainRelationship");
            return (Criteria) this;
        }

        public Criteria andChainRelationshipLessThan(String value) {
            addCriterion("Chain_relationship <", value, "chainRelationship");
            return (Criteria) this;
        }

        public Criteria andChainRelationshipLessThanOrEqualTo(String value) {
            addCriterion("Chain_relationship <=", value, "chainRelationship");
            return (Criteria) this;
        }

        public Criteria andChainRelationshipLike(String value) {
            addCriterion("Chain_relationship like", value, "chainRelationship");
            return (Criteria) this;
        }

        public Criteria andChainRelationshipNotLike(String value) {
            addCriterion("Chain_relationship not like", value, "chainRelationship");
            return (Criteria) this;
        }

        public Criteria andChainRelationshipIn(List<String> values) {
            addCriterion("Chain_relationship in", values, "chainRelationship");
            return (Criteria) this;
        }

        public Criteria andChainRelationshipNotIn(List<String> values) {
            addCriterion("Chain_relationship not in", values, "chainRelationship");
            return (Criteria) this;
        }

        public Criteria andChainRelationshipBetween(String value1, String value2) {
            addCriterion("Chain_relationship between", value1, value2, "chainRelationship");
            return (Criteria) this;
        }

        public Criteria andChainRelationshipNotBetween(String value1, String value2) {
            addCriterion("Chain_relationship not between", value1, value2, "chainRelationship");
            return (Criteria) this;
        }

        public Criteria andEmissionReductionPlanIsNull() {
            addCriterion("emission_reduction_plan is null");
            return (Criteria) this;
        }

        public Criteria andEmissionReductionPlanIsNotNull() {
            addCriterion("emission_reduction_plan is not null");
            return (Criteria) this;
        }

        public Criteria andEmissionReductionPlanEqualTo(String value) {
            addCriterion("emission_reduction_plan =", value, "emissionReductionPlan");
            return (Criteria) this;
        }

        public Criteria andEmissionReductionPlanNotEqualTo(String value) {
            addCriterion("emission_reduction_plan <>", value, "emissionReductionPlan");
            return (Criteria) this;
        }

        public Criteria andEmissionReductionPlanGreaterThan(String value) {
            addCriterion("emission_reduction_plan >", value, "emissionReductionPlan");
            return (Criteria) this;
        }

        public Criteria andEmissionReductionPlanGreaterThanOrEqualTo(String value) {
            addCriterion("emission_reduction_plan >=", value, "emissionReductionPlan");
            return (Criteria) this;
        }

        public Criteria andEmissionReductionPlanLessThan(String value) {
            addCriterion("emission_reduction_plan <", value, "emissionReductionPlan");
            return (Criteria) this;
        }

        public Criteria andEmissionReductionPlanLessThanOrEqualTo(String value) {
            addCriterion("emission_reduction_plan <=", value, "emissionReductionPlan");
            return (Criteria) this;
        }

        public Criteria andEmissionReductionPlanLike(String value) {
            addCriterion("emission_reduction_plan like", value, "emissionReductionPlan");
            return (Criteria) this;
        }

        public Criteria andEmissionReductionPlanNotLike(String value) {
            addCriterion("emission_reduction_plan not like", value, "emissionReductionPlan");
            return (Criteria) this;
        }

        public Criteria andEmissionReductionPlanIn(List<String> values) {
            addCriterion("emission_reduction_plan in", values, "emissionReductionPlan");
            return (Criteria) this;
        }

        public Criteria andEmissionReductionPlanNotIn(List<String> values) {
            addCriterion("emission_reduction_plan not in", values, "emissionReductionPlan");
            return (Criteria) this;
        }

        public Criteria andEmissionReductionPlanBetween(String value1, String value2) {
            addCriterion("emission_reduction_plan between", value1, value2, "emissionReductionPlan");
            return (Criteria) this;
        }

        public Criteria andEmissionReductionPlanNotBetween(String value1, String value2) {
            addCriterion("emission_reduction_plan not between", value1, value2, "emissionReductionPlan");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketCreationIsNull() {
            addCriterion("carbon_ticket_creation is null");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketCreationIsNotNull() {
            addCriterion("carbon_ticket_creation is not null");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketCreationEqualTo(String value) {
            addCriterion("carbon_ticket_creation =", value, "carbonTicketCreation");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketCreationNotEqualTo(String value) {
            addCriterion("carbon_ticket_creation <>", value, "carbonTicketCreation");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketCreationGreaterThan(String value) {
            addCriterion("carbon_ticket_creation >", value, "carbonTicketCreation");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketCreationGreaterThanOrEqualTo(String value) {
            addCriterion("carbon_ticket_creation >=", value, "carbonTicketCreation");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketCreationLessThan(String value) {
            addCriterion("carbon_ticket_creation <", value, "carbonTicketCreation");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketCreationLessThanOrEqualTo(String value) {
            addCriterion("carbon_ticket_creation <=", value, "carbonTicketCreation");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketCreationLike(String value) {
            addCriterion("carbon_ticket_creation like", value, "carbonTicketCreation");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketCreationNotLike(String value) {
            addCriterion("carbon_ticket_creation not like", value, "carbonTicketCreation");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketCreationIn(List<String> values) {
            addCriterion("carbon_ticket_creation in", values, "carbonTicketCreation");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketCreationNotIn(List<String> values) {
            addCriterion("carbon_ticket_creation not in", values, "carbonTicketCreation");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketCreationBetween(String value1, String value2) {
            addCriterion("carbon_ticket_creation between", value1, value2, "carbonTicketCreation");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketCreationNotBetween(String value1, String value2) {
            addCriterion("carbon_ticket_creation not between", value1, value2, "carbonTicketCreation");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketDestructionIsNull() {
            addCriterion("carbon_ticket_destruction is null");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketDestructionIsNotNull() {
            addCriterion("carbon_ticket_destruction is not null");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketDestructionEqualTo(String value) {
            addCriterion("carbon_ticket_destruction =", value, "carbonTicketDestruction");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketDestructionNotEqualTo(String value) {
            addCriterion("carbon_ticket_destruction <>", value, "carbonTicketDestruction");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketDestructionGreaterThan(String value) {
            addCriterion("carbon_ticket_destruction >", value, "carbonTicketDestruction");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketDestructionGreaterThanOrEqualTo(String value) {
            addCriterion("carbon_ticket_destruction >=", value, "carbonTicketDestruction");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketDestructionLessThan(String value) {
            addCriterion("carbon_ticket_destruction <", value, "carbonTicketDestruction");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketDestructionLessThanOrEqualTo(String value) {
            addCriterion("carbon_ticket_destruction <=", value, "carbonTicketDestruction");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketDestructionLike(String value) {
            addCriterion("carbon_ticket_destruction like", value, "carbonTicketDestruction");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketDestructionNotLike(String value) {
            addCriterion("carbon_ticket_destruction not like", value, "carbonTicketDestruction");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketDestructionIn(List<String> values) {
            addCriterion("carbon_ticket_destruction in", values, "carbonTicketDestruction");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketDestructionNotIn(List<String> values) {
            addCriterion("carbon_ticket_destruction not in", values, "carbonTicketDestruction");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketDestructionBetween(String value1, String value2) {
            addCriterion("carbon_ticket_destruction between", value1, value2, "carbonTicketDestruction");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketDestructionNotBetween(String value1, String value2) {
            addCriterion("carbon_ticket_destruction not between", value1, value2, "carbonTicketDestruction");
            return (Criteria) this;
        }

        public Criteria andPledgeApplicationIsNull() {
            addCriterion("pledge_application is null");
            return (Criteria) this;
        }

        public Criteria andPledgeApplicationIsNotNull() {
            addCriterion("pledge_application is not null");
            return (Criteria) this;
        }

        public Criteria andPledgeApplicationEqualTo(String value) {
            addCriterion("pledge_application =", value, "pledgeApplication");
            return (Criteria) this;
        }

        public Criteria andPledgeApplicationNotEqualTo(String value) {
            addCriterion("pledge_application <>", value, "pledgeApplication");
            return (Criteria) this;
        }

        public Criteria andPledgeApplicationGreaterThan(String value) {
            addCriterion("pledge_application >", value, "pledgeApplication");
            return (Criteria) this;
        }

        public Criteria andPledgeApplicationGreaterThanOrEqualTo(String value) {
            addCriterion("pledge_application >=", value, "pledgeApplication");
            return (Criteria) this;
        }

        public Criteria andPledgeApplicationLessThan(String value) {
            addCriterion("pledge_application <", value, "pledgeApplication");
            return (Criteria) this;
        }

        public Criteria andPledgeApplicationLessThanOrEqualTo(String value) {
            addCriterion("pledge_application <=", value, "pledgeApplication");
            return (Criteria) this;
        }

        public Criteria andPledgeApplicationLike(String value) {
            addCriterion("pledge_application like", value, "pledgeApplication");
            return (Criteria) this;
        }

        public Criteria andPledgeApplicationNotLike(String value) {
            addCriterion("pledge_application not like", value, "pledgeApplication");
            return (Criteria) this;
        }

        public Criteria andPledgeApplicationIn(List<String> values) {
            addCriterion("pledge_application in", values, "pledgeApplication");
            return (Criteria) this;
        }

        public Criteria andPledgeApplicationNotIn(List<String> values) {
            addCriterion("pledge_application not in", values, "pledgeApplication");
            return (Criteria) this;
        }

        public Criteria andPledgeApplicationBetween(String value1, String value2) {
            addCriterion("pledge_application between", value1, value2, "pledgeApplication");
            return (Criteria) this;
        }

        public Criteria andPledgeApplicationNotBetween(String value1, String value2) {
            addCriterion("pledge_application not between", value1, value2, "pledgeApplication");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningIsNull() {
            addCriterion("pledge_signing is null");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningIsNotNull() {
            addCriterion("pledge_signing is not null");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningEqualTo(String value) {
            addCriterion("pledge_signing =", value, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningNotEqualTo(String value) {
            addCriterion("pledge_signing <>", value, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningGreaterThan(String value) {
            addCriterion("pledge_signing >", value, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningGreaterThanOrEqualTo(String value) {
            addCriterion("pledge_signing >=", value, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningLessThan(String value) {
            addCriterion("pledge_signing <", value, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningLessThanOrEqualTo(String value) {
            addCriterion("pledge_signing <=", value, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningLike(String value) {
            addCriterion("pledge_signing like", value, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningNotLike(String value) {
            addCriterion("pledge_signing not like", value, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningIn(List<String> values) {
            addCriterion("pledge_signing in", values, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningNotIn(List<String> values) {
            addCriterion("pledge_signing not in", values, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningBetween(String value1, String value2) {
            addCriterion("pledge_signing between", value1, value2, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andPledgeSigningNotBetween(String value1, String value2) {
            addCriterion("pledge_signing not between", value1, value2, "pledgeSigning");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketIssueIsNull() {
            addCriterion("carbon_ticket_issue is null");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketIssueIsNotNull() {
            addCriterion("carbon_ticket_issue is not null");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketIssueEqualTo(String value) {
            addCriterion("carbon_ticket_issue =", value, "carbonTicketIssue");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketIssueNotEqualTo(String value) {
            addCriterion("carbon_ticket_issue <>", value, "carbonTicketIssue");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketIssueGreaterThan(String value) {
            addCriterion("carbon_ticket_issue >", value, "carbonTicketIssue");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketIssueGreaterThanOrEqualTo(String value) {
            addCriterion("carbon_ticket_issue >=", value, "carbonTicketIssue");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketIssueLessThan(String value) {
            addCriterion("carbon_ticket_issue <", value, "carbonTicketIssue");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketIssueLessThanOrEqualTo(String value) {
            addCriterion("carbon_ticket_issue <=", value, "carbonTicketIssue");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketIssueLike(String value) {
            addCriterion("carbon_ticket_issue like", value, "carbonTicketIssue");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketIssueNotLike(String value) {
            addCriterion("carbon_ticket_issue not like", value, "carbonTicketIssue");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketIssueIn(List<String> values) {
            addCriterion("carbon_ticket_issue in", values, "carbonTicketIssue");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketIssueNotIn(List<String> values) {
            addCriterion("carbon_ticket_issue not in", values, "carbonTicketIssue");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketIssueBetween(String value1, String value2) {
            addCriterion("carbon_ticket_issue between", value1, value2, "carbonTicketIssue");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketIssueNotBetween(String value1, String value2) {
            addCriterion("carbon_ticket_issue not between", value1, value2, "carbonTicketIssue");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketRepurchaseIsNull() {
            addCriterion("carbon_ticket_repurchase is null");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketRepurchaseIsNotNull() {
            addCriterion("carbon_ticket_repurchase is not null");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketRepurchaseEqualTo(String value) {
            addCriterion("carbon_ticket_repurchase =", value, "carbonTicketRepurchase");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketRepurchaseNotEqualTo(String value) {
            addCriterion("carbon_ticket_repurchase <>", value, "carbonTicketRepurchase");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketRepurchaseGreaterThan(String value) {
            addCriterion("carbon_ticket_repurchase >", value, "carbonTicketRepurchase");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketRepurchaseGreaterThanOrEqualTo(String value) {
            addCriterion("carbon_ticket_repurchase >=", value, "carbonTicketRepurchase");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketRepurchaseLessThan(String value) {
            addCriterion("carbon_ticket_repurchase <", value, "carbonTicketRepurchase");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketRepurchaseLessThanOrEqualTo(String value) {
            addCriterion("carbon_ticket_repurchase <=", value, "carbonTicketRepurchase");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketRepurchaseLike(String value) {
            addCriterion("carbon_ticket_repurchase like", value, "carbonTicketRepurchase");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketRepurchaseNotLike(String value) {
            addCriterion("carbon_ticket_repurchase not like", value, "carbonTicketRepurchase");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketRepurchaseIn(List<String> values) {
            addCriterion("carbon_ticket_repurchase in", values, "carbonTicketRepurchase");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketRepurchaseNotIn(List<String> values) {
            addCriterion("carbon_ticket_repurchase not in", values, "carbonTicketRepurchase");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketRepurchaseBetween(String value1, String value2) {
            addCriterion("carbon_ticket_repurchase between", value1, value2, "carbonTicketRepurchase");
            return (Criteria) this;
        }

        public Criteria andCarbonTicketRepurchaseNotBetween(String value1, String value2) {
            addCriterion("carbon_ticket_repurchase not between", value1, value2, "carbonTicketRepurchase");
            return (Criteria) this;
        }

        public Criteria andNumberCarbonEmissionIsNull() {
            addCriterion("number_carbon_emission is null");
            return (Criteria) this;
        }

        public Criteria andNumberCarbonEmissionIsNotNull() {
            addCriterion("number_carbon_emission is not null");
            return (Criteria) this;
        }

        public Criteria andNumberCarbonEmissionEqualTo(Integer value) {
            addCriterion("number_carbon_emission =", value, "numberCarbonEmission");
            return (Criteria) this;
        }

        public Criteria andNumberCarbonEmissionNotEqualTo(Integer value) {
            addCriterion("number_carbon_emission <>", value, "numberCarbonEmission");
            return (Criteria) this;
        }

        public Criteria andNumberCarbonEmissionGreaterThan(Integer value) {
            addCriterion("number_carbon_emission >", value, "numberCarbonEmission");
            return (Criteria) this;
        }

        public Criteria andNumberCarbonEmissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("number_carbon_emission >=", value, "numberCarbonEmission");
            return (Criteria) this;
        }

        public Criteria andNumberCarbonEmissionLessThan(Integer value) {
            addCriterion("number_carbon_emission <", value, "numberCarbonEmission");
            return (Criteria) this;
        }

        public Criteria andNumberCarbonEmissionLessThanOrEqualTo(Integer value) {
            addCriterion("number_carbon_emission <=", value, "numberCarbonEmission");
            return (Criteria) this;
        }

        public Criteria andNumberCarbonEmissionIn(List<Integer> values) {
            addCriterion("number_carbon_emission in", values, "numberCarbonEmission");
            return (Criteria) this;
        }

        public Criteria andNumberCarbonEmissionNotIn(List<Integer> values) {
            addCriterion("number_carbon_emission not in", values, "numberCarbonEmission");
            return (Criteria) this;
        }

        public Criteria andNumberCarbonEmissionBetween(Integer value1, Integer value2) {
            addCriterion("number_carbon_emission between", value1, value2, "numberCarbonEmission");
            return (Criteria) this;
        }

        public Criteria andNumberCarbonEmissionNotBetween(Integer value1, Integer value2) {
            addCriterion("number_carbon_emission not between", value1, value2, "numberCarbonEmission");
            return (Criteria) this;
        }

        public Criteria andCarbontTicketIsNull() {
            addCriterion("carbont_ticket is null");
            return (Criteria) this;
        }

        public Criteria andCarbontTicketIsNotNull() {
            addCriterion("carbont_ticket is not null");
            return (Criteria) this;
        }

        public Criteria andCarbontTicketEqualTo(Integer value) {
            addCriterion("carbont_ticket =", value, "carbontTicket");
            return (Criteria) this;
        }

        public Criteria andCarbontTicketNotEqualTo(Integer value) {
            addCriterion("carbont_ticket <>", value, "carbontTicket");
            return (Criteria) this;
        }

        public Criteria andCarbontTicketGreaterThan(Integer value) {
            addCriterion("carbont_ticket >", value, "carbontTicket");
            return (Criteria) this;
        }

        public Criteria andCarbontTicketGreaterThanOrEqualTo(Integer value) {
            addCriterion("carbont_ticket >=", value, "carbontTicket");
            return (Criteria) this;
        }

        public Criteria andCarbontTicketLessThan(Integer value) {
            addCriterion("carbont_ticket <", value, "carbontTicket");
            return (Criteria) this;
        }

        public Criteria andCarbontTicketLessThanOrEqualTo(Integer value) {
            addCriterion("carbont_ticket <=", value, "carbontTicket");
            return (Criteria) this;
        }

        public Criteria andCarbontTicketIn(List<Integer> values) {
            addCriterion("carbont_ticket in", values, "carbontTicket");
            return (Criteria) this;
        }

        public Criteria andCarbontTicketNotIn(List<Integer> values) {
            addCriterion("carbont_ticket not in", values, "carbontTicket");
            return (Criteria) this;
        }

        public Criteria andCarbontTicketBetween(Integer value1, Integer value2) {
            addCriterion("carbont_ticket between", value1, value2, "carbontTicket");
            return (Criteria) this;
        }

        public Criteria andCarbontTicketNotBetween(Integer value1, Integer value2) {
            addCriterion("carbont_ticket not between", value1, value2, "carbontTicket");
            return (Criteria) this;
        }

        public Criteria andUnissuedCarbonTicketIsNull() {
            addCriterion("unissued_carbon_ticket is null");
            return (Criteria) this;
        }

        public Criteria andUnissuedCarbonTicketIsNotNull() {
            addCriterion("unissued_carbon_ticket is not null");
            return (Criteria) this;
        }

        public Criteria andUnissuedCarbonTicketEqualTo(Integer value) {
            addCriterion("unissued_carbon_ticket =", value, "unissuedCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andUnissuedCarbonTicketNotEqualTo(Integer value) {
            addCriterion("unissued_carbon_ticket <>", value, "unissuedCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andUnissuedCarbonTicketGreaterThan(Integer value) {
            addCriterion("unissued_carbon_ticket >", value, "unissuedCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andUnissuedCarbonTicketGreaterThanOrEqualTo(Integer value) {
            addCriterion("unissued_carbon_ticket >=", value, "unissuedCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andUnissuedCarbonTicketLessThan(Integer value) {
            addCriterion("unissued_carbon_ticket <", value, "unissuedCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andUnissuedCarbonTicketLessThanOrEqualTo(Integer value) {
            addCriterion("unissued_carbon_ticket <=", value, "unissuedCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andUnissuedCarbonTicketIn(List<Integer> values) {
            addCriterion("unissued_carbon_ticket in", values, "unissuedCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andUnissuedCarbonTicketNotIn(List<Integer> values) {
            addCriterion("unissued_carbon_ticket not in", values, "unissuedCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andUnissuedCarbonTicketBetween(Integer value1, Integer value2) {
            addCriterion("unissued_carbon_ticket between", value1, value2, "unissuedCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andUnissuedCarbonTicketNotBetween(Integer value1, Integer value2) {
            addCriterion("unissued_carbon_ticket not between", value1, value2, "unissuedCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andRepurchasedCarbonTicketIsNull() {
            addCriterion("repurchased_carbon_ticket is null");
            return (Criteria) this;
        }

        public Criteria andRepurchasedCarbonTicketIsNotNull() {
            addCriterion("repurchased_carbon_ticket is not null");
            return (Criteria) this;
        }

        public Criteria andRepurchasedCarbonTicketEqualTo(Integer value) {
            addCriterion("repurchased_carbon_ticket =", value, "repurchasedCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andRepurchasedCarbonTicketNotEqualTo(Integer value) {
            addCriterion("repurchased_carbon_ticket <>", value, "repurchasedCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andRepurchasedCarbonTicketGreaterThan(Integer value) {
            addCriterion("repurchased_carbon_ticket >", value, "repurchasedCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andRepurchasedCarbonTicketGreaterThanOrEqualTo(Integer value) {
            addCriterion("repurchased_carbon_ticket >=", value, "repurchasedCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andRepurchasedCarbonTicketLessThan(Integer value) {
            addCriterion("repurchased_carbon_ticket <", value, "repurchasedCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andRepurchasedCarbonTicketLessThanOrEqualTo(Integer value) {
            addCriterion("repurchased_carbon_ticket <=", value, "repurchasedCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andRepurchasedCarbonTicketIn(List<Integer> values) {
            addCriterion("repurchased_carbon_ticket in", values, "repurchasedCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andRepurchasedCarbonTicketNotIn(List<Integer> values) {
            addCriterion("repurchased_carbon_ticket not in", values, "repurchasedCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andRepurchasedCarbonTicketBetween(Integer value1, Integer value2) {
            addCriterion("repurchased_carbon_ticket between", value1, value2, "repurchasedCarbonTicket");
            return (Criteria) this;
        }

        public Criteria andRepurchasedCarbonTicketNotBetween(Integer value1, Integer value2) {
            addCriterion("repurchased_carbon_ticket not between", value1, value2, "repurchasedCarbonTicket");
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