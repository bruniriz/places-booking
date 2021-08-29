package br.com.travel.placesbooking.converter;

import br.com.travel.placesbooking.model.PlaceDB;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Optional.ofNullable;

@Component
@NoArgsConstructor
public class MergeBetweenPlaceDbAndPlaceConverter {

    public PlaceDB convert(PlaceDB placeDB, final List<PlaceDB> placesContent) {
        return placesContent
                .stream()
                .filter(placeContent -> placeContent.getId().equalsIgnoreCase(placeDB.getId()))
                .map(placeContent -> mergePlace(placeContent, placeDB))
                .findAny()
                .get();
    }

    private PlaceDB mergePlace(PlaceDB placesContent, PlaceDB placeDB) {
        final var id = ofNullable(placesContent.getId())
                .orElse(placeDB.getId());
        return placeDB
                .toBuilder()
                .id(id)
                .name(placeDB.getName())
                .city(placeDB.getCity())
                .state(placeDB.getState())
                .build();
    }
}
