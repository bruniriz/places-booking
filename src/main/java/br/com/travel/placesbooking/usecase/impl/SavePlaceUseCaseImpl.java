package br.com.travel.placesbooking.usecase.impl;

import br.com.travel.placesbooking.domain.Place;
import br.com.travel.placesbooking.repository.gateway.PlaceGateway;
import br.com.travel.placesbooking.usecase.SavePlaceUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SavePlaceUseCaseImpl implements SavePlaceUseCase {

    private final PlaceGateway placeGateway;

    @Override
    public Place execute(Place place) {
        return placeGateway.save(place);
    }
}
