package br.com.travel.placesbooking.usecase;

import br.com.travel.placesbooking.domain.Place;
import br.com.travel.placesbooking.repository.gateway.PlaceGateway;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListAllPlacesUseCaseImpl implements ListAllPlacesUseCase {

    private final PlaceGateway placeGateway;

    @Override
    public Page<Place> execute(Integer page, Integer size) {
        return placeGateway.listAll(page, size);
    }
}
