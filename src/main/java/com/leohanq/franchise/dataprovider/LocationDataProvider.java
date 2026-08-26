package com.leohanq.franchise.dataprovider;

import com.leohanq.franchise.dataprovider.persistence.LocationRepository;
import com.leohanq.franchise.domain.entity.LocationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationDataProvider {

    private final LocationRepository locationRepository;

    public void saveLocation(final LocationEntity locationEntity) {
        locationRepository.save(locationEntity);
    }
}
