package com.hcl.pms.model;

import lombok.Data;

@Data
public class CustomGlobalError {

    private String message;
    private String errorReason;

    public CustomGlobalError() {
    }

    public CustomGlobalError(String message, String errorReason) {
        this.message = message;
        this.errorReason = errorReason;
    }

}
