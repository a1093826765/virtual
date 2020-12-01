package com.nov.virtual.sql.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOrderidIsNull() {
            addCriterion("orderId is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(Long value) {
            addCriterion("orderId =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(Long value) {
            addCriterion("orderId <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(Long value) {
            addCriterion("orderId >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(Long value) {
            addCriterion("orderId >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(Long value) {
            addCriterion("orderId <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(Long value) {
            addCriterion("orderId <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<Long> values) {
            addCriterion("orderId in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<Long> values) {
            addCriterion("orderId not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(Long value1, Long value2) {
            addCriterion("orderId between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(Long value1, Long value2) {
            addCriterion("orderId not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrdernumberIsNull() {
            addCriterion("orderNumber is null");
            return (Criteria) this;
        }

        public Criteria andOrdernumberIsNotNull() {
            addCriterion("orderNumber is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernumberEqualTo(String value) {
            addCriterion("orderNumber =", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberNotEqualTo(String value) {
            addCriterion("orderNumber <>", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberGreaterThan(String value) {
            addCriterion("orderNumber >", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberGreaterThanOrEqualTo(String value) {
            addCriterion("orderNumber >=", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberLessThan(String value) {
            addCriterion("orderNumber <", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberLessThanOrEqualTo(String value) {
            addCriterion("orderNumber <=", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberLike(String value) {
            addCriterion("orderNumber like", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberNotLike(String value) {
            addCriterion("orderNumber not like", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberIn(List<String> values) {
            addCriterion("orderNumber in", values, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberNotIn(List<String> values) {
            addCriterion("orderNumber not in", values, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberBetween(String value1, String value2) {
            addCriterion("orderNumber between", value1, value2, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberNotBetween(String value1, String value2) {
            addCriterion("orderNumber not between", value1, value2, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrderbuytimeIsNull() {
            addCriterion("orderBuyTime is null");
            return (Criteria) this;
        }

        public Criteria andOrderbuytimeIsNotNull() {
            addCriterion("orderBuyTime is not null");
            return (Criteria) this;
        }

        public Criteria andOrderbuytimeEqualTo(Date value) {
            addCriterion("orderBuyTime =", value, "orderbuytime");
            return (Criteria) this;
        }

        public Criteria andOrderbuytimeNotEqualTo(Date value) {
            addCriterion("orderBuyTime <>", value, "orderbuytime");
            return (Criteria) this;
        }

        public Criteria andOrderbuytimeGreaterThan(Date value) {
            addCriterion("orderBuyTime >", value, "orderbuytime");
            return (Criteria) this;
        }

        public Criteria andOrderbuytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("orderBuyTime >=", value, "orderbuytime");
            return (Criteria) this;
        }

        public Criteria andOrderbuytimeLessThan(Date value) {
            addCriterion("orderBuyTime <", value, "orderbuytime");
            return (Criteria) this;
        }

        public Criteria andOrderbuytimeLessThanOrEqualTo(Date value) {
            addCriterion("orderBuyTime <=", value, "orderbuytime");
            return (Criteria) this;
        }

        public Criteria andOrderbuytimeIn(List<Date> values) {
            addCriterion("orderBuyTime in", values, "orderbuytime");
            return (Criteria) this;
        }

        public Criteria andOrderbuytimeNotIn(List<Date> values) {
            addCriterion("orderBuyTime not in", values, "orderbuytime");
            return (Criteria) this;
        }

        public Criteria andOrderbuytimeBetween(Date value1, Date value2) {
            addCriterion("orderBuyTime between", value1, value2, "orderbuytime");
            return (Criteria) this;
        }

        public Criteria andOrderbuytimeNotBetween(Date value1, Date value2) {
            addCriterion("orderBuyTime not between", value1, value2, "orderbuytime");
            return (Criteria) this;
        }

        public Criteria andOrderselltimeIsNull() {
            addCriterion("orderSellTime is null");
            return (Criteria) this;
        }

        public Criteria andOrderselltimeIsNotNull() {
            addCriterion("orderSellTime is not null");
            return (Criteria) this;
        }

        public Criteria andOrderselltimeEqualTo(Date value) {
            addCriterion("orderSellTime =", value, "orderselltime");
            return (Criteria) this;
        }

        public Criteria andOrderselltimeNotEqualTo(Date value) {
            addCriterion("orderSellTime <>", value, "orderselltime");
            return (Criteria) this;
        }

        public Criteria andOrderselltimeGreaterThan(Date value) {
            addCriterion("orderSellTime >", value, "orderselltime");
            return (Criteria) this;
        }

        public Criteria andOrderselltimeGreaterThanOrEqualTo(Date value) {
            addCriterion("orderSellTime >=", value, "orderselltime");
            return (Criteria) this;
        }

        public Criteria andOrderselltimeLessThan(Date value) {
            addCriterion("orderSellTime <", value, "orderselltime");
            return (Criteria) this;
        }

        public Criteria andOrderselltimeLessThanOrEqualTo(Date value) {
            addCriterion("orderSellTime <=", value, "orderselltime");
            return (Criteria) this;
        }

        public Criteria andOrderselltimeIn(List<Date> values) {
            addCriterion("orderSellTime in", values, "orderselltime");
            return (Criteria) this;
        }

        public Criteria andOrderselltimeNotIn(List<Date> values) {
            addCriterion("orderSellTime not in", values, "orderselltime");
            return (Criteria) this;
        }

        public Criteria andOrderselltimeBetween(Date value1, Date value2) {
            addCriterion("orderSellTime between", value1, value2, "orderselltime");
            return (Criteria) this;
        }

        public Criteria andOrderselltimeNotBetween(Date value1, Date value2) {
            addCriterion("orderSellTime not between", value1, value2, "orderselltime");
            return (Criteria) this;
        }

        public Criteria andOrderpriceIsNull() {
            addCriterion("orderPrice is null");
            return (Criteria) this;
        }

        public Criteria andOrderpriceIsNotNull() {
            addCriterion("orderPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOrderpriceEqualTo(String value) {
            addCriterion("orderPrice =", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceNotEqualTo(String value) {
            addCriterion("orderPrice <>", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceGreaterThan(String value) {
            addCriterion("orderPrice >", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceGreaterThanOrEqualTo(String value) {
            addCriterion("orderPrice >=", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceLessThan(String value) {
            addCriterion("orderPrice <", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceLessThanOrEqualTo(String value) {
            addCriterion("orderPrice <=", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceLike(String value) {
            addCriterion("orderPrice like", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceNotLike(String value) {
            addCriterion("orderPrice not like", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceIn(List<String> values) {
            addCriterion("orderPrice in", values, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceNotIn(List<String> values) {
            addCriterion("orderPrice not in", values, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceBetween(String value1, String value2) {
            addCriterion("orderPrice between", value1, value2, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceNotBetween(String value1, String value2) {
            addCriterion("orderPrice not between", value1, value2, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderTypeidIsNull() {
            addCriterion("order_TypeId is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeidIsNotNull() {
            addCriterion("order_TypeId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeidEqualTo(Integer value) {
            addCriterion("order_TypeId =", value, "orderTypeid");
            return (Criteria) this;
        }

        public Criteria andOrderTypeidNotEqualTo(Integer value) {
            addCriterion("order_TypeId <>", value, "orderTypeid");
            return (Criteria) this;
        }

        public Criteria andOrderTypeidGreaterThan(Integer value) {
            addCriterion("order_TypeId >", value, "orderTypeid");
            return (Criteria) this;
        }

        public Criteria andOrderTypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_TypeId >=", value, "orderTypeid");
            return (Criteria) this;
        }

        public Criteria andOrderTypeidLessThan(Integer value) {
            addCriterion("order_TypeId <", value, "orderTypeid");
            return (Criteria) this;
        }

        public Criteria andOrderTypeidLessThanOrEqualTo(Integer value) {
            addCriterion("order_TypeId <=", value, "orderTypeid");
            return (Criteria) this;
        }

        public Criteria andOrderTypeidIn(List<Integer> values) {
            addCriterion("order_TypeId in", values, "orderTypeid");
            return (Criteria) this;
        }

        public Criteria andOrderTypeidNotIn(List<Integer> values) {
            addCriterion("order_TypeId not in", values, "orderTypeid");
            return (Criteria) this;
        }

        public Criteria andOrderTypeidBetween(Integer value1, Integer value2) {
            addCriterion("order_TypeId between", value1, value2, "orderTypeid");
            return (Criteria) this;
        }

        public Criteria andOrderTypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("order_TypeId not between", value1, value2, "orderTypeid");
            return (Criteria) this;
        }

        public Criteria andOrderStatusidIsNull() {
            addCriterion("order_StatusId is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusidIsNotNull() {
            addCriterion("order_StatusId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusidEqualTo(Integer value) {
            addCriterion("order_StatusId =", value, "orderStatusid");
            return (Criteria) this;
        }

        public Criteria andOrderStatusidNotEqualTo(Integer value) {
            addCriterion("order_StatusId <>", value, "orderStatusid");
            return (Criteria) this;
        }

        public Criteria andOrderStatusidGreaterThan(Integer value) {
            addCriterion("order_StatusId >", value, "orderStatusid");
            return (Criteria) this;
        }

        public Criteria andOrderStatusidGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_StatusId >=", value, "orderStatusid");
            return (Criteria) this;
        }

        public Criteria andOrderStatusidLessThan(Integer value) {
            addCriterion("order_StatusId <", value, "orderStatusid");
            return (Criteria) this;
        }

        public Criteria andOrderStatusidLessThanOrEqualTo(Integer value) {
            addCriterion("order_StatusId <=", value, "orderStatusid");
            return (Criteria) this;
        }

        public Criteria andOrderStatusidIn(List<Integer> values) {
            addCriterion("order_StatusId in", values, "orderStatusid");
            return (Criteria) this;
        }

        public Criteria andOrderStatusidNotIn(List<Integer> values) {
            addCriterion("order_StatusId not in", values, "orderStatusid");
            return (Criteria) this;
        }

        public Criteria andOrderStatusidBetween(Integer value1, Integer value2) {
            addCriterion("order_StatusId between", value1, value2, "orderStatusid");
            return (Criteria) this;
        }

        public Criteria andOrderStatusidNotBetween(Integer value1, Integer value2) {
            addCriterion("order_StatusId not between", value1, value2, "orderStatusid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridIsNull() {
            addCriterion("order_UserId is null");
            return (Criteria) this;
        }

        public Criteria andOrderUseridIsNotNull() {
            addCriterion("order_UserId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUseridEqualTo(Long value) {
            addCriterion("order_UserId =", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridNotEqualTo(Long value) {
            addCriterion("order_UserId <>", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridGreaterThan(Long value) {
            addCriterion("order_UserId >", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("order_UserId >=", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridLessThan(Long value) {
            addCriterion("order_UserId <", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridLessThanOrEqualTo(Long value) {
            addCriterion("order_UserId <=", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridIn(List<Long> values) {
            addCriterion("order_UserId in", values, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridNotIn(List<Long> values) {
            addCriterion("order_UserId not in", values, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridBetween(Long value1, Long value2) {
            addCriterion("order_UserId between", value1, value2, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridNotBetween(Long value1, Long value2) {
            addCriterion("order_UserId not between", value1, value2, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencyidIsNull() {
            addCriterion("order_CurrencyId is null");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencyidIsNotNull() {
            addCriterion("order_CurrencyId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencyidEqualTo(Integer value) {
            addCriterion("order_CurrencyId =", value, "orderCurrencyid");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencyidNotEqualTo(Integer value) {
            addCriterion("order_CurrencyId <>", value, "orderCurrencyid");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencyidGreaterThan(Integer value) {
            addCriterion("order_CurrencyId >", value, "orderCurrencyid");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_CurrencyId >=", value, "orderCurrencyid");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencyidLessThan(Integer value) {
            addCriterion("order_CurrencyId <", value, "orderCurrencyid");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencyidLessThanOrEqualTo(Integer value) {
            addCriterion("order_CurrencyId <=", value, "orderCurrencyid");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencyidIn(List<Integer> values) {
            addCriterion("order_CurrencyId in", values, "orderCurrencyid");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencyidNotIn(List<Integer> values) {
            addCriterion("order_CurrencyId not in", values, "orderCurrencyid");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencyidBetween(Integer value1, Integer value2) {
            addCriterion("order_CurrencyId between", value1, value2, "orderCurrencyid");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencyidNotBetween(Integer value1, Integer value2) {
            addCriterion("order_CurrencyId not between", value1, value2, "orderCurrencyid");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencynumIsNull() {
            addCriterion("order_CurrencyNum is null");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencynumIsNotNull() {
            addCriterion("order_CurrencyNum is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencynumEqualTo(String value) {
            addCriterion("order_CurrencyNum =", value, "orderCurrencynum");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencynumNotEqualTo(String value) {
            addCriterion("order_CurrencyNum <>", value, "orderCurrencynum");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencynumGreaterThan(String value) {
            addCriterion("order_CurrencyNum >", value, "orderCurrencynum");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencynumGreaterThanOrEqualTo(String value) {
            addCriterion("order_CurrencyNum >=", value, "orderCurrencynum");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencynumLessThan(String value) {
            addCriterion("order_CurrencyNum <", value, "orderCurrencynum");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencynumLessThanOrEqualTo(String value) {
            addCriterion("order_CurrencyNum <=", value, "orderCurrencynum");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencynumLike(String value) {
            addCriterion("order_CurrencyNum like", value, "orderCurrencynum");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencynumNotLike(String value) {
            addCriterion("order_CurrencyNum not like", value, "orderCurrencynum");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencynumIn(List<String> values) {
            addCriterion("order_CurrencyNum in", values, "orderCurrencynum");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencynumNotIn(List<String> values) {
            addCriterion("order_CurrencyNum not in", values, "orderCurrencynum");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencynumBetween(String value1, String value2) {
            addCriterion("order_CurrencyNum between", value1, value2, "orderCurrencynum");
            return (Criteria) this;
        }

        public Criteria andOrderCurrencynumNotBetween(String value1, String value2) {
            addCriterion("order_CurrencyNum not between", value1, value2, "orderCurrencynum");
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