package br.com.travel.placesbooking.repository.gateway;

import br.com.travel.placesbooking.domain.Place;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PlaceGateway {
    Place save(Place place);
    Page<Place> listAll(int page, int size);
    Optional<Place> findById(String id);
    void delete(String id);
}
