package com.leohanq.franchise.entrypoint.rest;

import com.leohanq.franchise.domain.mapper.LocationMapper;
import com.leohanq.franchise.entrypoint.rest.request.LocationRequest;
import com.leohanq.franchise.usecase.location.CreateLocationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {

    private final CreateLocationUseCase createLocationUseCase;
    private final LocationMapper locationMapper;

    @PostMapping
    public ResponseEntity<Void> createLocation(@RequestBody LocationRequest locationRequest) {
        createLocationUseCase.execute(locationMapper.requestToDto(locationRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
