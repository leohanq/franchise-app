package com.leohanq.franchise.usecase.franchise;

import com.leohanq.franchise.dataprovider.persistence.ProductMaxStockProjection;

import java.util.List;

public interface ShowMaxStockUseCase {

    List<ProductMaxStockProjection> getMaxStockProducts(Long id);
}