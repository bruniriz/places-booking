package br.com.travel.placesbooking.converter;

import br.com.travel.placesbooking.domain.Place;
import br.com.travel.placesbooking.resource.PlaceResource;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlaceResourceRequestToPlaceConvert {

    private final ModelMapper modelMapper;

    public Place convert(PlaceResource placeResource) { //converte resource em dominio
        return modelMapper.map(placeResource, Place.class);

    }
}
