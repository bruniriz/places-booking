package br.com.travel.placesbooking.usecase;

import br.com.travel.placesbooking.domain.Place;

import java.util.Optional;

public interface GetByIdPlaceUseCase {
    Optional<Place> execute(String id);
}
