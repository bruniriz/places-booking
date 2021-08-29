package br.com.travel.placesbooking.usecase;

import br.com.travel.placesbooking.domain.PlaceDomain;

import java.util.Optional;

public interface GetByIdPlaceUseCase {
    Optional<PlaceDomain> execute(String id);
}
