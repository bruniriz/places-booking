package br.com.travel.placesbooking.usecase;

import br.com.travel.placesbooking.domain.PlaceDomain;

public interface SavePlaceUseCase {
    PlaceDomain execute(PlaceDomain placeDomain);
}
