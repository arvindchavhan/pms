package com.hcl.pms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CreatePaymentDto {

    /** The operation success. */
    @JsonIgnore
    private boolean operationSuccess;

    /** The message. */
    @JsonIgnore
    private String message;

    /** The description. */
    @JsonIgnore
    private String description;

    public boolean isOperationSuccess() {
        return operationSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOperationSuccess(boolean operationSuccess) {
        this.operationSuccess = operationSuccess;
    }
}
