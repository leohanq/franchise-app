package com.leohanq.franchise.usecase.location;

import com.leohanq.franchise.domain.dto.LocationDto;

public interface CreateLocationUseCase {

    void execute(LocationDto locationDto);
}
