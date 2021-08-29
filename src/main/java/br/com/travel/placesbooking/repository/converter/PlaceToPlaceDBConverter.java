package br.com.travel.placesbooking.repository.converter;

import br.com.travel.placesbooking.domain.PlaceDomain;
import br.com.travel.placesbooking.model.PlaceDB;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlaceToPlaceDBConverter {

    private final ModelMapper modelMapper;

    public PlaceDB convert(final PlaceDomain placeDomain) {
        return modelMapper.map(placeDomain, PlaceDB.class);
    }
}
