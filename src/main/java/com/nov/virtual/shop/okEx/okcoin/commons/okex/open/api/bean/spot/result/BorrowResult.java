package com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.bean.spot.result;


public class BorrowResult {

    private boolean result;
    private String borrow_id;

    public String getClient_oid() {
        return client_oid;
    }

    public void setClient_oid(String client_oid) {
        this.client_oid = client_oid;
    }

    private  String client_oid;

    public boolean isResult() {
        return this.result;
    }

    public void setResult(final boolean result) {
        this.result = result;
    }

    public String getBorrow_id() {
        return this.borrow_id;
    }

    public void setBorrow_id(final String borrow_id) {
        this.borrow_id = borrow_id;
    }

}
