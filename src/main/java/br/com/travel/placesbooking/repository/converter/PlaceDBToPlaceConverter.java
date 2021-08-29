package br.com.travel.placesbooking.repository.converter;

import br.com.travel.placesbooking.domain.PlaceDomain;
import br.com.travel.placesbooking.model.PlaceDB;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlaceDBToPlaceConverter {

    private final ModelMapper modelMapper;

    public PlaceDomain convert(final PlaceDB placeDB) {
        return modelMapper.map(placeDB, PlaceDomain.class);
    }
}
