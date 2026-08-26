package com.leohanq.franchise.dataprovider.persistence;

import com.leohanq.franchise.domain.entity.FranchiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseRepository extends JpaRepository<FranchiseEntity, Long> {

}
