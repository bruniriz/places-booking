package br.com.travel.placesbooking.usecase.impl;

import br.com.travel.placesbooking.domain.PlaceDomain;
import br.com.travel.placesbooking.repository.gateway.PlaceGateway;
import br.com.travel.placesbooking.usecase.ListAllPlacesUseCase;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListAllPlacesUseCaseImpl implements ListAllPlacesUseCase {

    private final PlaceGateway placeGateway;

    @Override
    public Page<PlaceDomain> execute(Integer page, Integer size) {
        return placeGateway.listAll(page, size);
    }
}
