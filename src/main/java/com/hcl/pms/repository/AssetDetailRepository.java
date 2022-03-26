package com.hcl.pms.repository;

import com.hcl.pms.model.AssetDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetDetailRepository extends JpaRepository<AssetDetail, Long> {

    AssetDetail findBySecurityName(String securityName);
}