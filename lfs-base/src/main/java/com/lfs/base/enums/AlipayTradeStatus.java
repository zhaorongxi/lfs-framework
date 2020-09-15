package com.lfs.base.enums;

public enum AlipayTradeStatus {

    WAIT_BUYER_PAY("WAIT_BUYER_PAY"),
    TRADE_CLOSED("TRADE_CLOSED"),
    TRADE_SUCCESS("TRADE_SUCCESS"),
    TRADE_FINISHED("TRADE_FINISHED");

    private String status;

    AlipayTradeStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return this.status;
    }
}
