package com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.bean.other;

public interface OrderBookItem<T> {
    String getPrice();

    T getSize();
}
