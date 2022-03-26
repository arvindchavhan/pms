package com.hcl.pms.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSummaryRequest {

    private String mode;
    private String type;
    private String key;
}
