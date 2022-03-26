package com.hcl.pms.model.exception;

public class PaymentInputException extends RuntimeException {
    private final String errorMessage;
    private final String error;

    public PaymentInputException(String errorMessage, String error) {

        this.errorMessage = errorMessage;
        this.error = error;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getError() {
        return error;
    }
}
