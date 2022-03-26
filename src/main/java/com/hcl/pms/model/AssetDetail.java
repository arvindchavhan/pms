package com.hcl.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="asset_details")
public class AssetDetail extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long assetId;

    @Column(name="security_name")
    private String securityName;

}
