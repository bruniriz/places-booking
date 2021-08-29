package br.com.travel.placesbooking.usecase;

import br.com.travel.placesbooking.domain.PlaceDomain;
import org.springframework.data.domain.Page;

public interface ListAllPlacesUseCase {
    Page<PlaceDomain> execute(Integer page, Integer size);
}
