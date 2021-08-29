package br.com.travel.placesbooking.converter;

import br.com.travel.placesbooking.domain.PlaceDomain;
import br.com.travel.placesbooking.resource.PlaceResource;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlaceResourceRequestToPlaceConvert {

    private final ModelMapper modelMapper;

    public PlaceDomain convert(PlaceResource placeResource) { //converte resource em dominio
        return modelMapper.map(placeResource, PlaceDomain.class);

    }
}
