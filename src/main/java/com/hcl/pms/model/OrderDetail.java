package com.hcl.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity(name="order_detail")
public class OrderDetail extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="order_ref_no")
    private Long orderRefNo;

    @Column(name="order_date")
    private String orderDate;

    @Column(name="order_status")
    private String orderStatus;

    @Column(name="payment_status")
    private String paymentStatus;

    private Integer quantity;

    @Column(name="transaction_type")
    private String transactionType;

    @Column(name="order_value")
    private Double orderValue;

    @Column(name="unit_price")
    private Double unitPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="asset_id")
    private AssetDetail assetDetail;

    @Column(name="transaction_id")
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
}
