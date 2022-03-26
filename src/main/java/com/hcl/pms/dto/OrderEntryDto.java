package com.hcl.pms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderEntryDto {
    
    private String fundName;

    private String transactionType;

    private Integer quantity;

    private Double orderValue;
}
