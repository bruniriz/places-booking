package br.com.travel.placesbooking.repository;

import br.com.travel.placesbooking.model.PlaceDB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaceRepository extends MongoRepository<PlaceDB, String> {
}
