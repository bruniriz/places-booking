package br.com.travel.placesbooking.converter;

import br.com.travel.placesbooking.domain.PlaceDomain;
import br.com.travel.placesbooking.resource.PlaceResource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class PlaceResourceRequestCustomToPlaceConverter {

    public PlaceDomain convert(PlaceResource placeResource, String id) {
        return PlaceDomain
                .builder()
                .id(id)
                .name(placeResource.getName())
                .city(placeResource.getCity())
                .state(placeResource.getState())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
