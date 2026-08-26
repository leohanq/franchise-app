package com.leohanq.franchise.dataprovider;

import com.leohanq.franchise.dataprovider.persistence.FranchiseRepository;
import com.leohanq.franchise.domain.entity.FranchiseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FranchiseDataProvider {

    private final FranchiseRepository franchiseRepository;

    public void saveFranchise(final FranchiseEntity franchiseEntity) {
        franchiseRepository.save(franchiseEntity);
    }
}
