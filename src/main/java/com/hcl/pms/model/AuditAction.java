package com.hcl.pms.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "audit_action")
public class AuditAction extends BaseEntity {
    @Id
    @Column(name = "audit_id", nullable = false)
    private Integer id;

    @Column(name = "old_data", length = 45)
    private String oldData;

    @Column(name = "new_data", length = 45)
    private String newData;

}