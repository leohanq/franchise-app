package com.leohanq.franchise.usecase.service;

import com.leohanq.franchise.dataprovider.LocationDataProvider;
import com.leohanq.franchise.domain.dto.LocationDto;
import com.leohanq.franchise.domain.entity.LocationEntity;
import com.leohanq.franchise.domain.mapper.LocationMapper;
import com.leohanq.franchise.usecase.location.CreateLocationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService implements CreateLocationUseCase {

    private final LocationDataProvider locationDataProvider;
    private final LocationMapper locationMapper;

    @Override
    public void execute(LocationDto locationDto) {
        LocationEntity locationEntity = locationMapper.dtoToEntity(locationDto);
        locationDataProvider.saveLocation(locationEntity);
    }
}
