package com.wc1.poc.userpayments.domain;

import java.math.BigDecimal;

public class UserPayment {
    private int paymentId;
    private int userId;
    private BigDecimal amount;

    public UserPayment(int paymentId, int userId, BigDecimal amount) {
        this.paymentId = paymentId;
        this.userId = userId;
        this.amount = amount;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
