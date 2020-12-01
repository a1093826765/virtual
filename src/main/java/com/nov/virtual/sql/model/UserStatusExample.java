package com.nov.virtual.sql.model;

import java.util.ArrayList;
import java.util.List;

public class UserStatusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserStatusExample() {
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

        public Criteria andUserstatusidIsNull() {
            addCriterion("userStatusId is null");
            return (Criteria) this;
        }

        public Criteria andUserstatusidIsNotNull() {
            addCriterion("userStatusId is not null");
            return (Criteria) this;
        }

        public Criteria andUserstatusidEqualTo(Integer value) {
            addCriterion("userStatusId =", value, "userstatusid");
            return (Criteria) this;
        }

        public Criteria andUserstatusidNotEqualTo(Integer value) {
            addCriterion("userStatusId <>", value, "userstatusid");
            return (Criteria) this;
        }

        public Criteria andUserstatusidGreaterThan(Integer value) {
            addCriterion("userStatusId >", value, "userstatusid");
            return (Criteria) this;
        }

        public Criteria andUserstatusidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userStatusId >=", value, "userstatusid");
            return (Criteria) this;
        }

        public Criteria andUserstatusidLessThan(Integer value) {
            addCriterion("userStatusId <", value, "userstatusid");
            return (Criteria) this;
        }

        public Criteria andUserstatusidLessThanOrEqualTo(Integer value) {
            addCriterion("userStatusId <=", value, "userstatusid");
            return (Criteria) this;
        }

        public Criteria andUserstatusidIn(List<Integer> values) {
            addCriterion("userStatusId in", values, "userstatusid");
            return (Criteria) this;
        }

        public Criteria andUserstatusidNotIn(List<Integer> values) {
            addCriterion("userStatusId not in", values, "userstatusid");
            return (Criteria) this;
        }

        public Criteria andUserstatusidBetween(Integer value1, Integer value2) {
            addCriterion("userStatusId between", value1, value2, "userstatusid");
            return (Criteria) this;
        }

        public Criteria andUserstatusidNotBetween(Integer value1, Integer value2) {
            addCriterion("userStatusId not between", value1, value2, "userstatusid");
            return (Criteria) this;
        }

        public Criteria andUserstatusnameIsNull() {
            addCriterion("userStatusName is null");
            return (Criteria) this;
        }

        public Criteria andUserstatusnameIsNotNull() {
            addCriterion("userStatusName is not null");
            return (Criteria) this;
        }

        public Criteria andUserstatusnameEqualTo(String value) {
            addCriterion("userStatusName =", value, "userstatusname");
            return (Criteria) this;
        }

        public Criteria andUserstatusnameNotEqualTo(String value) {
            addCriterion("userStatusName <>", value, "userstatusname");
            return (Criteria) this;
        }

        public Criteria andUserstatusnameGreaterThan(String value) {
            addCriterion("userStatusName >", value, "userstatusname");
            return (Criteria) this;
        }

        public Criteria andUserstatusnameGreaterThanOrEqualTo(String value) {
            addCriterion("userStatusName >=", value, "userstatusname");
            return (Criteria) this;
        }

        public Criteria andUserstatusnameLessThan(String value) {
            addCriterion("userStatusName <", value, "userstatusname");
            return (Criteria) this;
        }

        public Criteria andUserstatusnameLessThanOrEqualTo(String value) {
            addCriterion("userStatusName <=", value, "userstatusname");
            return (Criteria) this;
        }

        public Criteria andUserstatusnameLike(String value) {
            addCriterion("userStatusName like", value, "userstatusname");
            return (Criteria) this;
        }

        public Criteria andUserstatusnameNotLike(String value) {
            addCriterion("userStatusName not like", value, "userstatusname");
            return (Criteria) this;
        }

        public Criteria andUserstatusnameIn(List<String> values) {
            addCriterion("userStatusName in", values, "userstatusname");
            return (Criteria) this;
        }

        public Criteria andUserstatusnameNotIn(List<String> values) {
            addCriterion("userStatusName not in", values, "userstatusname");
            return (Criteria) this;
        }

        public Criteria andUserstatusnameBetween(String value1, String value2) {
            addCriterion("userStatusName between", value1, value2, "userstatusname");
            return (Criteria) this;
        }

        public Criteria andUserstatusnameNotBetween(String value1, String value2) {
            addCriterion("userStatusName not between", value1, value2, "userstatusname");
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