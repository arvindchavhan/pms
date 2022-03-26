package com.hcl.pms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hcl.pms.model.AssetDetail;

import javax.persistence.*;

public class CreatePaymentDto {


    private Long orderRefNo;

    private String orderDate;

    private String orderStatus;

    private String paymentStatus;

    private Integer quantity;

    private String transactionType;

    private Double orderValue;

    private Double unitPrice;

    private AssetDetail assetDetail;

    private String transactionId;

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
