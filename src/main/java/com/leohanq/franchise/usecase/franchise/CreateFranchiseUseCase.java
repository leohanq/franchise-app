package com.leohanq.franchise.usecase.franchise;

import com.leohanq.franchise.domain.dto.FranchiseDto;

public interface CreateFranchiseUseCase {

    void execute(FranchiseDto franchiseDto);
}