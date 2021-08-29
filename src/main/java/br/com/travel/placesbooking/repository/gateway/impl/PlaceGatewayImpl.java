package br.com.travel.placesbooking.repository.gateway.impl;

import br.com.travel.placesbooking.converter.MergeBetweenPlaceDbAndPlaceConverter;
import br.com.travel.placesbooking.domain.PlaceDomain;
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

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class PlaceGatewayImpl implements PlaceGateway {

    private final PlaceDBToPlaceConverter placeDBToPlaceConverter;
    private final PlaceToPlaceDBConverter placeToPlaceDBConverter;
    private final PlaceRepository placeRepository;
    private final MergeBetweenPlaceDbAndPlaceConverter mergeBetweenPlaceDbAndPlaceConverter;

    @Override
    public PlaceDomain save(PlaceDomain placeDomain) {
        PlaceDB placeDB = placeToPlaceDBConverter.convert(placeDomain);
        PlaceDB savePlaceDB = placeRepository.save(placeDB);
        return placeDBToPlaceConverter.convert(savePlaceDB);
    }

    public Page<PlaceDomain> listAll(int page, int size) {
        return placeRepository.findAll(PageRequest.of(page, size))
                .map(placeDB -> placeDBToPlaceConverter.convert(placeDB));
    }

    @Override
    public Optional<PlaceDomain> findById(String id) {
        return placeRepository.findById(id)
                .map(placeDB -> placeDBToPlaceConverter.convert(placeDB));
    }

    @Override
    public PlaceDomain update(PlaceDomain placeDomain) {
        return placeRepository.findById(placeDomain.getId())
                .map(placeDB -> getPlaceDB(placeDomain, placeDB))
                .map(placeRepository::save)
                .map(placeDBToPlaceConverter::convert)
                .orElseThrow();
    }

    private PlaceDB getPlaceDB(PlaceDomain placeDomain, PlaceDB placeDB) {
        final var convert = placeToPlaceDBConverter.convert(placeDomain);
        return mergeBetweenPlaceDbAndPlaceConverter.convert(placeDB, List.of(convert));

    }

    @Override
    public void delete(String id) {
        placeRepository.deleteById(id);
    }
}
