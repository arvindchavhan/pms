package com.hcl.pms.model.request;

import java.math.BigDecimal;

public class CreatePaymentRequest {

    private Long orderRef;
    private Double amount;

    public Long getOrderRef() {
        return orderRef;
    }

    public Double getAmount() {
        return amount;
    }
}
