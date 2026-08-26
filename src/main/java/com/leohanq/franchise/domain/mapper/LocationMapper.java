package com.leohanq.franchise.domain.mapper;

import com.leohanq.franchise.domain.dto.LocationDto;
import com.leohanq.franchise.domain.entity.FranchiseEntity;
import com.leohanq.franchise.domain.entity.LocationEntity;
import com.leohanq.franchise.entrypoint.rest.request.LocationRequest;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public LocationDto requestToDto(LocationRequest request) {
        LocationDto dto = new LocationDto();
        dto.setName(request.getName());
        dto.setAddress(request.getAddress());
        dto.setFranchiseId(request.getFranchiseId());
        return dto;
    }

    public LocationEntity dtoToEntity(LocationDto dto) {
        LocationEntity entity = new LocationEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        FranchiseEntity franchise = new FranchiseEntity();
        franchise.setId(dto.getFranchiseId());
        entity.setFranchise(franchise);
        return entity;
    }

    public LocationDto entityToDto(LocationEntity entity) {
        LocationDto dto = new LocationDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setFranchiseId(entity.getFranchise().getId());
        return dto;
    }
}
