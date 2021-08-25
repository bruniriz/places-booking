package br.com.travel.placesbooking.usecase;

import br.com.travel.placesbooking.domain.Place;
import org.springframework.data.domain.Page;

public interface ListAllPlacesUseCase {
    Page<Place> execute(Integer page, Integer size);
}
