package com.leohanq.franchise.entrypoint.rest;

import com.leohanq.franchise.dataprovider.persistence.ProductMaxStockProjection;
import com.leohanq.franchise.domain.mapper.FranchiseMapper;
import com.leohanq.franchise.entrypoint.rest.request.FranchiseRequest;
import com.leohanq.franchise.usecase.franchise.CreateFranchiseUseCase;
import com.leohanq.franchise.usecase.franchise.ShowMaxStockUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/franchise")
@RequiredArgsConstructor
public class FranchiseController {

    private final CreateFranchiseUseCase createFranchiseUseCase;
    private final ShowMaxStockUseCase showMaxStockUseCase;
    private final FranchiseMapper franchiseMapper;

    @GetMapping("/{id}/max-stock-products")
    public ResponseEntity<List<ProductMaxStockProjection>> getMaxStockProducts(@PathVariable Long id) {
        return ResponseEntity.ok(showMaxStockUseCase.getMaxStockProducts(id));
    }

    @PostMapping
    public ResponseEntity<Void> createFranchise(@RequestBody FranchiseRequest franchiseRequest) {
        createFranchiseUseCase.execute(franchiseMapper.requestToDto(franchiseRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
