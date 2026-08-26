package com.leohanq.franchise.dataprovider.persistence;

import com.leohanq.franchise.domain.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

}
