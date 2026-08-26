package com.leohanq.franchise.usecase.service;

import com.leohanq.franchise.dataprovider.FranchiseDataProvider;
import com.leohanq.franchise.dataprovider.ProductDataProvider;
import com.leohanq.franchise.dataprovider.persistence.ProductMaxStockProjection;
import com.leohanq.franchise.domain.dto.FranchiseDto;
import com.leohanq.franchise.domain.entity.FranchiseEntity;
import com.leohanq.franchise.domain.mapper.FranchiseMapper;
import com.leohanq.franchise.usecase.franchise.CreateFranchiseUseCase;
import com.leohanq.franchise.usecase.franchise.ShowMaxStockUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FranchiseService implements CreateFranchiseUseCase, ShowMaxStockUseCase {

    private final FranchiseDataProvider franchiseDataProvider;
    private final ProductDataProvider productDataProvider;
    private final FranchiseMapper franchiseMapper;

    @Override
    public void execute(FranchiseDto franchiseDto) {
        FranchiseEntity franchiseEntity = franchiseMapper.dtoToEntity(franchiseDto);
        franchiseDataProvider.saveFranchise(franchiseEntity);
    }

    @Override
    public List<ProductMaxStockProjection> getMaxStockProducts(Long id) {
        return productDataProvider.getMaxStockProducts(id);
    }
}
