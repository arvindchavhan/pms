package com.hcl.pms.repository;

import com.hcl.pms.model.AuditAction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditActionRepository extends JpaRepository<AuditAction, Integer> {
}