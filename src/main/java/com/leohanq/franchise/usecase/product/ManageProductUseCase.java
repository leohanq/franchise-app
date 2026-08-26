package com.leohanq.franchise.usecase.product;

import com.leohanq.franchise.domain.dto.ProductDto;

public interface ManageProductUseCase {

    void createProduct(ProductDto productDto);

    void modifyStockProduct(ProductDto productDto);

    void deleteProduct(Long id);
}