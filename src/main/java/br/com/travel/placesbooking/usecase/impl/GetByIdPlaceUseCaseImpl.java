package br.com.travel.placesbooking.usecase.impl;

import br.com.travel.placesbooking.domain.Place;
import br.com.travel.placesbooking.repository.gateway.PlaceGateway;
import br.com.travel.placesbooking.usecase.GetByIdPlaceUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetByIdPlaceUseCaseImpl implements GetByIdPlaceUseCase {

    private final PlaceGateway placeGateway;

    @Override
    public Optional<Place> execute(String id) {
        return placeGateway.findById(id);
    }
}
