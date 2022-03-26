package com.hcl.pms.custom;

import lombok.Data;

@Data
public class OrderEntryException extends RuntimeException{

    private final String message;
    private final String errorReason;

    public OrderEntryException(String message, String errorReason){
        this.message = message;
        this.errorReason = errorReason;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
