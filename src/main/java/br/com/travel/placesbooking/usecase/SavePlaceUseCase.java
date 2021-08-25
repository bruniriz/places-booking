package br.com.travel.placesbooking.usecase;

import br.com.travel.placesbooking.domain.Place;

public interface SavePlaceUseCase {
    Place execute(Place place);
}
