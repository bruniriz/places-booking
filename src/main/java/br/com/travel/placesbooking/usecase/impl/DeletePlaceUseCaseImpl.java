package br.com.travel.placesbooking.usecase.impl;

import br.com.travel.placesbooking.repository.gateway.PlaceGateway;
import br.com.travel.placesbooking.usecase.DeletePlaceUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeletePlaceUseCaseImpl implements DeletePlaceUseCase {

    private final PlaceGateway placeGateway;

    @Override
    public void execute(String id) {
        placeGateway.delete(id);

    }
}
