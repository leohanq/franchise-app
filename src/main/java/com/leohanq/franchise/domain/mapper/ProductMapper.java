package com.leohanq.franchise.domain.mapper;

import com.leohanq.franchise.domain.dto.ProductDto;
import com.leohanq.franchise.domain.entity.LocationEntity;
import com.leohanq.franchise.domain.entity.ProductEntity;
import com.leohanq.franchise.entrypoint.rest.request.ProductRequest;
import com.leohanq.franchise.entrypoint.rest.request.StockRequest;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto requestToDto(ProductRequest productRequest) {
        ProductDto productDto = new ProductDto();
        productDto.setName(productRequest.getName());
        productDto.setStock(productRequest.getStock());
        productDto.setLocationId(productRequest.getLocationId());
        return productDto;
    }

    public ProductDto requestStockToDto(StockRequest stockRequest, Long productId) {
        ProductDto productDto = new ProductDto();
        productDto.setId(productId);
        productDto.setStock(stockRequest.getStock());
        return productDto;
    }

    public ProductEntity dtoToEntity(ProductDto dto) {
        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setStock(dto.getStock());
        LocationEntity location = new LocationEntity();
        location.setId(dto.getLocationId());
        entity.setLocation(location);
        return entity;
    }

    public ProductDto entityToDto(ProductEntity entity) {
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setStock(entity.getStock());
        dto.setLocationId(entity.getLocation().getId());
        return dto;
    }
}
