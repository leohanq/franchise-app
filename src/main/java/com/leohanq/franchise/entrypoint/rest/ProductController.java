package com.leohanq.franchise.entrypoint.rest;

import com.leohanq.franchise.domain.mapper.ProductMapper;
import com.leohanq.franchise.entrypoint.rest.request.ProductRequest;
import com.leohanq.franchise.entrypoint.rest.request.StockRequest;
import com.leohanq.franchise.usecase.product.ManageProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ManageProductUseCase manageProductUseCase;
    private final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductRequest productRequest) {
        manageProductUseCase.createProduct(productMapper.requestToDto(productRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/{id}/stock")
    public ResponseEntity<Void> updateProduct(@PathVariable("id") Long productId, @RequestBody StockRequest stockRequest) {
        manageProductUseCase.modifyStockProduct(productMapper.requestStockToDto(stockRequest, productId));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        manageProductUseCase.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}