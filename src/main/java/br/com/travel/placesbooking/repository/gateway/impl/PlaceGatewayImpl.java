package br.com.travel.placesbooking.repository.gateway.impl;

import br.com.travel.placesbooking.domain.Place;
import br.com.travel.placesbooking.model.PlaceDB;
import br.com.travel.placesbooking.repository.PlaceRepository;
import br.com.travel.placesbooking.repository.converter.PlaceDBToPlaceConverter;
import br.com.travel.placesbooking.repository.converter.PlaceToPlaceDBConverter;
import br.com.travel.placesbooking.repository.gateway.PlaceGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class PlaceGatewayImpl implements PlaceGateway {

    PlaceDBToPlaceConverter placeDBToPlaceConverter;
    PlaceToPlaceDBConverter placeToPlaceDBConverter;
    PlaceRepository placeRepository;

    @Override
    public Place save(Place place) {
        PlaceDB placeDB = placeToPlaceDBConverter.convert(place);
        PlaceDB savePlaceDB = placeRepository.save(placeDB);
        return placeDBToPlaceConverter.convert(savePlaceDB);
    }

    public Page<Place> listAll(int page, int size) {
        return placeRepository.findAll(PageRequest.of(page, size))
                .map(placeDB -> placeDBToPlaceConverter.convert(placeDB));
    }

    @Override
    public Optional<Place> findById(String id) {
        return placeRepository.findById(id)
                .map(placeDB -> placeDBToPlaceConverter.convert(placeDB));
    }

    @Override
    public void delete(String id) {
        placeRepository.deleteById(id);
    }
}
