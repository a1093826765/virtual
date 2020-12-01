package com.nov.virtual.sql.model;

import java.util.ArrayList;
import java.util.List;

public class HoldCurrencyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HoldCurrencyExample() {
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

        public Criteria andHoldcurrencyidIsNull() {
            addCriterion("holdCurrencyId is null");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyidIsNotNull() {
            addCriterion("holdCurrencyId is not null");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyidEqualTo(Long value) {
            addCriterion("holdCurrencyId =", value, "holdcurrencyid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyidNotEqualTo(Long value) {
            addCriterion("holdCurrencyId <>", value, "holdcurrencyid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyidGreaterThan(Long value) {
            addCriterion("holdCurrencyId >", value, "holdcurrencyid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyidGreaterThanOrEqualTo(Long value) {
            addCriterion("holdCurrencyId >=", value, "holdcurrencyid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyidLessThan(Long value) {
            addCriterion("holdCurrencyId <", value, "holdcurrencyid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyidLessThanOrEqualTo(Long value) {
            addCriterion("holdCurrencyId <=", value, "holdcurrencyid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyidIn(List<Long> values) {
            addCriterion("holdCurrencyId in", values, "holdcurrencyid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyidNotIn(List<Long> values) {
            addCriterion("holdCurrencyId not in", values, "holdcurrencyid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyidBetween(Long value1, Long value2) {
            addCriterion("holdCurrencyId between", value1, value2, "holdcurrencyid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyidNotBetween(Long value1, Long value2) {
            addCriterion("holdCurrencyId not between", value1, value2, "holdcurrencyid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyCurrencyidIsNull() {
            addCriterion("holdCurrency_CurrencyId is null");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyCurrencyidIsNotNull() {
            addCriterion("holdCurrency_CurrencyId is not null");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyCurrencyidEqualTo(Integer value) {
            addCriterion("holdCurrency_CurrencyId =", value, "holdcurrencyCurrencyid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyCurrencyidNotEqualTo(Integer value) {
            addCriterion("holdCurrency_CurrencyId <>", value, "holdcurrencyCurrencyid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyCurrencyidGreaterThan(Integer value) {
            addCriterion("holdCurrency_CurrencyId >", value, "holdcurrencyCurrencyid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyCurrencyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("holdCurrency_CurrencyId >=", value, "holdcurrencyCurrencyid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyCurrencyidLessThan(Integer value) {
            addCriterion("holdCurrency_CurrencyId <", value, "holdcurrencyCurrencyid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyCurrencyidLessThanOrEqualTo(Integer value) {
            addCriterion("holdCurrency_CurrencyId <=", value, "holdcurrencyCurrencyid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyCurrencyidIn(List<Integer> values) {
            addCriterion("holdCurrency_CurrencyId in", values, "holdcurrencyCurrencyid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyCurrencyidNotIn(List<Integer> values) {
            addCriterion("holdCurrency_CurrencyId not in", values, "holdcurrencyCurrencyid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyCurrencyidBetween(Integer value1, Integer value2) {
            addCriterion("holdCurrency_CurrencyId between", value1, value2, "holdcurrencyCurrencyid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyCurrencyidNotBetween(Integer value1, Integer value2) {
            addCriterion("holdCurrency_CurrencyId not between", value1, value2, "holdcurrencyCurrencyid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencynumIsNull() {
            addCriterion("holdCurrencyNum is null");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencynumIsNotNull() {
            addCriterion("holdCurrencyNum is not null");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencynumEqualTo(String value) {
            addCriterion("holdCurrencyNum =", value, "holdcurrencynum");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencynumNotEqualTo(String value) {
            addCriterion("holdCurrencyNum <>", value, "holdcurrencynum");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencynumGreaterThan(String value) {
            addCriterion("holdCurrencyNum >", value, "holdcurrencynum");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencynumGreaterThanOrEqualTo(String value) {
            addCriterion("holdCurrencyNum >=", value, "holdcurrencynum");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencynumLessThan(String value) {
            addCriterion("holdCurrencyNum <", value, "holdcurrencynum");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencynumLessThanOrEqualTo(String value) {
            addCriterion("holdCurrencyNum <=", value, "holdcurrencynum");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencynumLike(String value) {
            addCriterion("holdCurrencyNum like", value, "holdcurrencynum");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencynumNotLike(String value) {
            addCriterion("holdCurrencyNum not like", value, "holdcurrencynum");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencynumIn(List<String> values) {
            addCriterion("holdCurrencyNum in", values, "holdcurrencynum");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencynumNotIn(List<String> values) {
            addCriterion("holdCurrencyNum not in", values, "holdcurrencynum");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencynumBetween(String value1, String value2) {
            addCriterion("holdCurrencyNum between", value1, value2, "holdcurrencynum");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencynumNotBetween(String value1, String value2) {
            addCriterion("holdCurrencyNum not between", value1, value2, "holdcurrencynum");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyUseridIsNull() {
            addCriterion("holdCurrency_UserId is null");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyUseridIsNotNull() {
            addCriterion("holdCurrency_UserId is not null");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyUseridEqualTo(Long value) {
            addCriterion("holdCurrency_UserId =", value, "holdcurrencyUserid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyUseridNotEqualTo(Long value) {
            addCriterion("holdCurrency_UserId <>", value, "holdcurrencyUserid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyUseridGreaterThan(Long value) {
            addCriterion("holdCurrency_UserId >", value, "holdcurrencyUserid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("holdCurrency_UserId >=", value, "holdcurrencyUserid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyUseridLessThan(Long value) {
            addCriterion("holdCurrency_UserId <", value, "holdcurrencyUserid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyUseridLessThanOrEqualTo(Long value) {
            addCriterion("holdCurrency_UserId <=", value, "holdcurrencyUserid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyUseridIn(List<Long> values) {
            addCriterion("holdCurrency_UserId in", values, "holdcurrencyUserid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyUseridNotIn(List<Long> values) {
            addCriterion("holdCurrency_UserId not in", values, "holdcurrencyUserid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyUseridBetween(Long value1, Long value2) {
            addCriterion("holdCurrency_UserId between", value1, value2, "holdcurrencyUserid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencyUseridNotBetween(Long value1, Long value2) {
            addCriterion("holdCurrency_UserId not between", value1, value2, "holdcurrencyUserid");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencymoneyIsNull() {
            addCriterion("holdCurrencyMoney is null");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencymoneyIsNotNull() {
            addCriterion("holdCurrencyMoney is not null");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencymoneyEqualTo(String value) {
            addCriterion("holdCurrencyMoney =", value, "holdcurrencymoney");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencymoneyNotEqualTo(String value) {
            addCriterion("holdCurrencyMoney <>", value, "holdcurrencymoney");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencymoneyGreaterThan(String value) {
            addCriterion("holdCurrencyMoney >", value, "holdcurrencymoney");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencymoneyGreaterThanOrEqualTo(String value) {
            addCriterion("holdCurrencyMoney >=", value, "holdcurrencymoney");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencymoneyLessThan(String value) {
            addCriterion("holdCurrencyMoney <", value, "holdcurrencymoney");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencymoneyLessThanOrEqualTo(String value) {
            addCriterion("holdCurrencyMoney <=", value, "holdcurrencymoney");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencymoneyLike(String value) {
            addCriterion("holdCurrencyMoney like", value, "holdcurrencymoney");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencymoneyNotLike(String value) {
            addCriterion("holdCurrencyMoney not like", value, "holdcurrencymoney");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencymoneyIn(List<String> values) {
            addCriterion("holdCurrencyMoney in", values, "holdcurrencymoney");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencymoneyNotIn(List<String> values) {
            addCriterion("holdCurrencyMoney not in", values, "holdcurrencymoney");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencymoneyBetween(String value1, String value2) {
            addCriterion("holdCurrencyMoney between", value1, value2, "holdcurrencymoney");
            return (Criteria) this;
        }

        public Criteria andHoldcurrencymoneyNotBetween(String value1, String value2) {
            addCriterion("holdCurrencyMoney not between", value1, value2, "holdcurrencymoney");
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