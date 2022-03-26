package com.hcl.pms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {
    
    @Column(name="created_by")
    private String createdBy;

    @Column(name="updated_by")
    private String updateBy;

    @Column(name="created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name="updated_date")
    @Temporal(TemporalType.DATE)
    private Date updatedDate;
}
