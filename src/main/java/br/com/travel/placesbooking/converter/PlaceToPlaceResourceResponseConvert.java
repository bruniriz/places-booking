package br.com.travel.placesbooking.converter;

import br.com.travel.placesbooking.domain.PlaceDomain;
import br.com.travel.placesbooking.resource.PlaceResource;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlaceToPlaceResourceResponseConvert {

    private final ModelMapper modelMapper;

    public PlaceResource convert(PlaceDomain placeDomain) {
        return modelMapper.map(placeDomain, PlaceResource.class);
    }
}
