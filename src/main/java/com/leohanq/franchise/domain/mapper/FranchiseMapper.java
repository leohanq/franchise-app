package com.leohanq.franchise.domain.mapper;

import com.leohanq.franchise.domain.dto.FranchiseDto;
import com.leohanq.franchise.domain.entity.FranchiseEntity;
import com.leohanq.franchise.entrypoint.rest.request.FranchiseRequest;
import org.springframework.stereotype.Component;

@Component
public class FranchiseMapper {

    public FranchiseDto requestToDto(FranchiseRequest request) {
        FranchiseDto dto = new FranchiseDto();
        dto.setName(request.getName());
        dto.setTaxId(request.getTaxId());
        return dto;
    }

    public FranchiseEntity dtoToEntity(FranchiseDto dto) {
        FranchiseEntity entity = new FranchiseEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setTaxId(dto.getTaxId());
        return entity;
    }

    public FranchiseDto entityToDto(FranchiseEntity entity) {
        FranchiseDto dto = new FranchiseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setTaxId(entity.getTaxId());
        return dto;
    }
}
