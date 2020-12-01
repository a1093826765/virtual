package com.nov.virtual.sql.model;

import java.util.ArrayList;
import java.util.List;

public class OrderStatusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderStatusExample() {
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

        public Criteria andOrderstatusidIsNull() {
            addCriterion("orderStatusId is null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusidIsNotNull() {
            addCriterion("orderStatusId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusidEqualTo(Integer value) {
            addCriterion("orderStatusId =", value, "orderstatusid");
            return (Criteria) this;
        }

        public Criteria andOrderstatusidNotEqualTo(Integer value) {
            addCriterion("orderStatusId <>", value, "orderstatusid");
            return (Criteria) this;
        }

        public Criteria andOrderstatusidGreaterThan(Integer value) {
            addCriterion("orderStatusId >", value, "orderstatusid");
            return (Criteria) this;
        }

        public Criteria andOrderstatusidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderStatusId >=", value, "orderstatusid");
            return (Criteria) this;
        }

        public Criteria andOrderstatusidLessThan(Integer value) {
            addCriterion("orderStatusId <", value, "orderstatusid");
            return (Criteria) this;
        }

        public Criteria andOrderstatusidLessThanOrEqualTo(Integer value) {
            addCriterion("orderStatusId <=", value, "orderstatusid");
            return (Criteria) this;
        }

        public Criteria andOrderstatusidIn(List<Integer> values) {
            addCriterion("orderStatusId in", values, "orderstatusid");
            return (Criteria) this;
        }

        public Criteria andOrderstatusidNotIn(List<Integer> values) {
            addCriterion("orderStatusId not in", values, "orderstatusid");
            return (Criteria) this;
        }

        public Criteria andOrderstatusidBetween(Integer value1, Integer value2) {
            addCriterion("orderStatusId between", value1, value2, "orderstatusid");
            return (Criteria) this;
        }

        public Criteria andOrderstatusidNotBetween(Integer value1, Integer value2) {
            addCriterion("orderStatusId not between", value1, value2, "orderstatusid");
            return (Criteria) this;
        }

        public Criteria andOrderstatusnameIsNull() {
            addCriterion("orderStatusName is null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusnameIsNotNull() {
            addCriterion("orderStatusName is not null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusnameEqualTo(String value) {
            addCriterion("orderStatusName =", value, "orderstatusname");
            return (Criteria) this;
        }

        public Criteria andOrderstatusnameNotEqualTo(String value) {
            addCriterion("orderStatusName <>", value, "orderstatusname");
            return (Criteria) this;
        }

        public Criteria andOrderstatusnameGreaterThan(String value) {
            addCriterion("orderStatusName >", value, "orderstatusname");
            return (Criteria) this;
        }

        public Criteria andOrderstatusnameGreaterThanOrEqualTo(String value) {
            addCriterion("orderStatusName >=", value, "orderstatusname");
            return (Criteria) this;
        }

        public Criteria andOrderstatusnameLessThan(String value) {
            addCriterion("orderStatusName <", value, "orderstatusname");
            return (Criteria) this;
        }

        public Criteria andOrderstatusnameLessThanOrEqualTo(String value) {
            addCriterion("orderStatusName <=", value, "orderstatusname");
            return (Criteria) this;
        }

        public Criteria andOrderstatusnameLike(String value) {
            addCriterion("orderStatusName like", value, "orderstatusname");
            return (Criteria) this;
        }

        public Criteria andOrderstatusnameNotLike(String value) {
            addCriterion("orderStatusName not like", value, "orderstatusname");
            return (Criteria) this;
        }

        public Criteria andOrderstatusnameIn(List<String> values) {
            addCriterion("orderStatusName in", values, "orderstatusname");
            return (Criteria) this;
        }

        public Criteria andOrderstatusnameNotIn(List<String> values) {
            addCriterion("orderStatusName not in", values, "orderstatusname");
            return (Criteria) this;
        }

        public Criteria andOrderstatusnameBetween(String value1, String value2) {
            addCriterion("orderStatusName between", value1, value2, "orderstatusname");
            return (Criteria) this;
        }

        public Criteria andOrderstatusnameNotBetween(String value1, String value2) {
            addCriterion("orderStatusName not between", value1, value2, "orderstatusname");
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