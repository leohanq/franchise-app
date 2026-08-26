package com.leohanq.franchise.dataprovider;

import com.leohanq.franchise.dataprovider.persistence.ProductMaxStockProjection;
import com.leohanq.franchise.dataprovider.persistence.ProductRepository;
import com.leohanq.franchise.domain.dto.ProductDto;
import com.leohanq.franchise.domain.entity.ProductEntity;
import com.leohanq.franchise.domain.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.leohanq.franchise.domain.exception.NotFoundException;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductDataProvider {

    private final ProductRepository  productRepository;
    private final ProductMapper  productMapper;

    public ProductDto getProduct(Long id) {
        return productRepository.findById(id)
                .map(productMapper::entityToDto)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
    }

    public List<ProductMaxStockProjection> getMaxStockProducts(Long franchiseId) {
        return productRepository.findTopStockProductsByFranchise(franchiseId);
    }

    public void saveProduct(ProductDto productDto) {
        productRepository.save(productMapper.dtoToEntity(productDto));
    }

    public void modifyStockProduct(ProductDto productDto) {
        ProductEntity entity = productRepository.findById(productDto.getId())
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + productDto.getId()));
        entity.setStock(productDto.getStock());
        productRepository.save(entity);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
