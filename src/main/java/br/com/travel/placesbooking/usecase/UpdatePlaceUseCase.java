package br.com.travel.placesbooking.usecase;

import br.com.travel.placesbooking.domain.PlaceDomain;

public interface UpdatePlaceUseCase {
    PlaceDomain execute(PlaceDomain placeDomain);
}
