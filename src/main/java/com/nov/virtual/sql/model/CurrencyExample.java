package com.nov.virtual.sql.model;

import java.util.ArrayList;
import java.util.List;

public class CurrencyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CurrencyExample() {
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

        public Criteria andCurrencyidIsNull() {
            addCriterion("currencyId is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyidIsNotNull() {
            addCriterion("currencyId is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyidEqualTo(Integer value) {
            addCriterion("currencyId =", value, "currencyid");
            return (Criteria) this;
        }

        public Criteria andCurrencyidNotEqualTo(Integer value) {
            addCriterion("currencyId <>", value, "currencyid");
            return (Criteria) this;
        }

        public Criteria andCurrencyidGreaterThan(Integer value) {
            addCriterion("currencyId >", value, "currencyid");
            return (Criteria) this;
        }

        public Criteria andCurrencyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("currencyId >=", value, "currencyid");
            return (Criteria) this;
        }

        public Criteria andCurrencyidLessThan(Integer value) {
            addCriterion("currencyId <", value, "currencyid");
            return (Criteria) this;
        }

        public Criteria andCurrencyidLessThanOrEqualTo(Integer value) {
            addCriterion("currencyId <=", value, "currencyid");
            return (Criteria) this;
        }

        public Criteria andCurrencyidIn(List<Integer> values) {
            addCriterion("currencyId in", values, "currencyid");
            return (Criteria) this;
        }

        public Criteria andCurrencyidNotIn(List<Integer> values) {
            addCriterion("currencyId not in", values, "currencyid");
            return (Criteria) this;
        }

        public Criteria andCurrencyidBetween(Integer value1, Integer value2) {
            addCriterion("currencyId between", value1, value2, "currencyid");
            return (Criteria) this;
        }

        public Criteria andCurrencyidNotBetween(Integer value1, Integer value2) {
            addCriterion("currencyId not between", value1, value2, "currencyid");
            return (Criteria) this;
        }

        public Criteria andCurrencynameIsNull() {
            addCriterion("currencyName is null");
            return (Criteria) this;
        }

        public Criteria andCurrencynameIsNotNull() {
            addCriterion("currencyName is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencynameEqualTo(String value) {
            addCriterion("currencyName =", value, "currencyname");
            return (Criteria) this;
        }

        public Criteria andCurrencynameNotEqualTo(String value) {
            addCriterion("currencyName <>", value, "currencyname");
            return (Criteria) this;
        }

        public Criteria andCurrencynameGreaterThan(String value) {
            addCriterion("currencyName >", value, "currencyname");
            return (Criteria) this;
        }

        public Criteria andCurrencynameGreaterThanOrEqualTo(String value) {
            addCriterion("currencyName >=", value, "currencyname");
            return (Criteria) this;
        }

        public Criteria andCurrencynameLessThan(String value) {
            addCriterion("currencyName <", value, "currencyname");
            return (Criteria) this;
        }

        public Criteria andCurrencynameLessThanOrEqualTo(String value) {
            addCriterion("currencyName <=", value, "currencyname");
            return (Criteria) this;
        }

        public Criteria andCurrencynameLike(String value) {
            addCriterion("currencyName like", value, "currencyname");
            return (Criteria) this;
        }

        public Criteria andCurrencynameNotLike(String value) {
            addCriterion("currencyName not like", value, "currencyname");
            return (Criteria) this;
        }

        public Criteria andCurrencynameIn(List<String> values) {
            addCriterion("currencyName in", values, "currencyname");
            return (Criteria) this;
        }

        public Criteria andCurrencynameNotIn(List<String> values) {
            addCriterion("currencyName not in", values, "currencyname");
            return (Criteria) this;
        }

        public Criteria andCurrencynameBetween(String value1, String value2) {
            addCriterion("currencyName between", value1, value2, "currencyname");
            return (Criteria) this;
        }

        public Criteria andCurrencynameNotBetween(String value1, String value2) {
            addCriterion("currencyName not between", value1, value2, "currencyname");
            return (Criteria) this;
        }

        public Criteria andCurrencyCurrencystatusidIsNull() {
            addCriterion("currency_CurrencyStatusId is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyCurrencystatusidIsNotNull() {
            addCriterion("currency_CurrencyStatusId is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyCurrencystatusidEqualTo(Integer value) {
            addCriterion("currency_CurrencyStatusId =", value, "currencyCurrencystatusid");
            return (Criteria) this;
        }

        public Criteria andCurrencyCurrencystatusidNotEqualTo(Integer value) {
            addCriterion("currency_CurrencyStatusId <>", value, "currencyCurrencystatusid");
            return (Criteria) this;
        }

        public Criteria andCurrencyCurrencystatusidGreaterThan(Integer value) {
            addCriterion("currency_CurrencyStatusId >", value, "currencyCurrencystatusid");
            return (Criteria) this;
        }

        public Criteria andCurrencyCurrencystatusidGreaterThanOrEqualTo(Integer value) {
            addCriterion("currency_CurrencyStatusId >=", value, "currencyCurrencystatusid");
            return (Criteria) this;
        }

        public Criteria andCurrencyCurrencystatusidLessThan(Integer value) {
            addCriterion("currency_CurrencyStatusId <", value, "currencyCurrencystatusid");
            return (Criteria) this;
        }

        public Criteria andCurrencyCurrencystatusidLessThanOrEqualTo(Integer value) {
            addCriterion("currency_CurrencyStatusId <=", value, "currencyCurrencystatusid");
            return (Criteria) this;
        }

        public Criteria andCurrencyCurrencystatusidIn(List<Integer> values) {
            addCriterion("currency_CurrencyStatusId in", values, "currencyCurrencystatusid");
            return (Criteria) this;
        }

        public Criteria andCurrencyCurrencystatusidNotIn(List<Integer> values) {
            addCriterion("currency_CurrencyStatusId not in", values, "currencyCurrencystatusid");
            return (Criteria) this;
        }

        public Criteria andCurrencyCurrencystatusidBetween(Integer value1, Integer value2) {
            addCriterion("currency_CurrencyStatusId between", value1, value2, "currencyCurrencystatusid");
            return (Criteria) this;
        }

        public Criteria andCurrencyCurrencystatusidNotBetween(Integer value1, Integer value2) {
            addCriterion("currency_CurrencyStatusId not between", value1, value2, "currencyCurrencystatusid");
            return (Criteria) this;
        }

        public Criteria andCurrencyImgIsNull() {
            addCriterion("currency_Img is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyImgIsNotNull() {
            addCriterion("currency_Img is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyImgEqualTo(String value) {
            addCriterion("currency_Img =", value, "currencyImg");
            return (Criteria) this;
        }

        public Criteria andCurrencyImgNotEqualTo(String value) {
            addCriterion("currency_Img <>", value, "currencyImg");
            return (Criteria) this;
        }

        public Criteria andCurrencyImgGreaterThan(String value) {
            addCriterion("currency_Img >", value, "currencyImg");
            return (Criteria) this;
        }

        public Criteria andCurrencyImgGreaterThanOrEqualTo(String value) {
            addCriterion("currency_Img >=", value, "currencyImg");
            return (Criteria) this;
        }

        public Criteria andCurrencyImgLessThan(String value) {
            addCriterion("currency_Img <", value, "currencyImg");
            return (Criteria) this;
        }

        public Criteria andCurrencyImgLessThanOrEqualTo(String value) {
            addCriterion("currency_Img <=", value, "currencyImg");
            return (Criteria) this;
        }

        public Criteria andCurrencyImgLike(String value) {
            addCriterion("currency_Img like", value, "currencyImg");
            return (Criteria) this;
        }

        public Criteria andCurrencyImgNotLike(String value) {
            addCriterion("currency_Img not like", value, "currencyImg");
            return (Criteria) this;
        }

        public Criteria andCurrencyImgIn(List<String> values) {
            addCriterion("currency_Img in", values, "currencyImg");
            return (Criteria) this;
        }

        public Criteria andCurrencyImgNotIn(List<String> values) {
            addCriterion("currency_Img not in", values, "currencyImg");
            return (Criteria) this;
        }

        public Criteria andCurrencyImgBetween(String value1, String value2) {
            addCriterion("currency_Img between", value1, value2, "currencyImg");
            return (Criteria) this;
        }

        public Criteria andCurrencyImgNotBetween(String value1, String value2) {
            addCriterion("currency_Img not between", value1, value2, "currencyImg");
            return (Criteria) this;
        }

        public Criteria andCurrencyChinenameIsNull() {
            addCriterion("currency_ChineName is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyChinenameIsNotNull() {
            addCriterion("currency_ChineName is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyChinenameEqualTo(String value) {
            addCriterion("currency_ChineName =", value, "currencyChinename");
            return (Criteria) this;
        }

        public Criteria andCurrencyChinenameNotEqualTo(String value) {
            addCriterion("currency_ChineName <>", value, "currencyChinename");
            return (Criteria) this;
        }

        public Criteria andCurrencyChinenameGreaterThan(String value) {
            addCriterion("currency_ChineName >", value, "currencyChinename");
            return (Criteria) this;
        }

        public Criteria andCurrencyChinenameGreaterThanOrEqualTo(String value) {
            addCriterion("currency_ChineName >=", value, "currencyChinename");
            return (Criteria) this;
        }

        public Criteria andCurrencyChinenameLessThan(String value) {
            addCriterion("currency_ChineName <", value, "currencyChinename");
            return (Criteria) this;
        }

        public Criteria andCurrencyChinenameLessThanOrEqualTo(String value) {
            addCriterion("currency_ChineName <=", value, "currencyChinename");
            return (Criteria) this;
        }

        public Criteria andCurrencyChinenameLike(String value) {
            addCriterion("currency_ChineName like", value, "currencyChinename");
            return (Criteria) this;
        }

        public Criteria andCurrencyChinenameNotLike(String value) {
            addCriterion("currency_ChineName not like", value, "currencyChinename");
            return (Criteria) this;
        }

        public Criteria andCurrencyChinenameIn(List<String> values) {
            addCriterion("currency_ChineName in", values, "currencyChinename");
            return (Criteria) this;
        }

        public Criteria andCurrencyChinenameNotIn(List<String> values) {
            addCriterion("currency_ChineName not in", values, "currencyChinename");
            return (Criteria) this;
        }

        public Criteria andCurrencyChinenameBetween(String value1, String value2) {
            addCriterion("currency_ChineName between", value1, value2, "currencyChinename");
            return (Criteria) this;
        }

        public Criteria andCurrencyChinenameNotBetween(String value1, String value2) {
            addCriterion("currency_ChineName not between", value1, value2, "currencyChinename");
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