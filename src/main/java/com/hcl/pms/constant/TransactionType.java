package com.hcl.pms.constant;

import lombok.Getter;

public enum TransactionType {
    BUY("BUY"), SELL("SELL");

    @Getter
    private String value;

    private TransactionType(String value){
        this.value = value;
    }
}
