package br.com.travel.placesbooking.repository.gateway;

import br.com.travel.placesbooking.domain.PlaceDomain;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PlaceGateway {
    PlaceDomain save(PlaceDomain placeDomain);
    Page<PlaceDomain> listAll(int page, int size);
    Optional<PlaceDomain> findById(String id);
    PlaceDomain update(PlaceDomain placeDomain);
    void delete(String id);
}
