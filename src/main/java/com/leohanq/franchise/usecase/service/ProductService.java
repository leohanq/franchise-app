package com.leohanq.franchise.usecase.service;

import com.leohanq.franchise.dataprovider.ProductDataProvider;
import com.leohanq.franchise.domain.dto.ProductDto;
import com.leohanq.franchise.usecase.product.ManageProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductService implements ManageProductUseCase {

    private final ProductDataProvider  productDataProvider;

    @Override
    public void createProduct(ProductDto productDto) {
        productDataProvider.saveProduct(productDto);
    }

    @Override
    public void modifyStockProduct(ProductDto productDto) {
        ProductDto productCurrent = productDataProvider.getProduct(productDto.getId());
        int newStock = productCurrent.getStock() - productDto.getStock();
        if (newStock < 0) {
            throw new IllegalArgumentException("Insufficient stock");
        }
        productCurrent.setStock(newStock);
        productDataProvider.modifyStockProduct(productCurrent);
    }

    @Override
    public void deleteProduct(Long id) {
        productDataProvider.deleteProduct(id);
    }
}
