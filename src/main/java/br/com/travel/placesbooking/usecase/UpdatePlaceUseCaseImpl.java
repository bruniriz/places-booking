package br.com.travel.placesbooking.usecase;

import br.com.travel.placesbooking.domain.PlaceDomain;
import br.com.travel.placesbooking.repository.gateway.PlaceGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdatePlaceUseCaseImpl implements UpdatePlaceUseCase {

    private final PlaceGateway placeGateway;

    @Override
    public PlaceDomain execute(PlaceDomain placeDomain) {
        return placeGateway.update(placeDomain);
    }
}
