package com.hcl.pms.repository;

import com.hcl.pms.model.AuditAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditActionRepository extends JpaRepository<AuditAction, Integer> {
}