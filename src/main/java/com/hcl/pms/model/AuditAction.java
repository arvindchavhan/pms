package com.hcl.pms.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity(name = "")
public class AuditAction extends BaseEntity{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "audit_id", nullable = false)
    private Integer auditId;

    @Column(name = "old_data")
    private String oldData;

    @Column(name = "new_data")
    private String newData;

}
