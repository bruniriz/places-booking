package br.com.travel.placesbooking.controller;

import br.com.travel.placesbooking.converter.PlaceResourceRequestCustomToPlaceConverter;
import br.com.travel.placesbooking.converter.PlaceResourceRequestToPlaceConvert;
import br.com.travel.placesbooking.converter.PlaceToPlaceResourceResponseConvert;
import br.com.travel.placesbooking.resource.PlaceResource;
import br.com.travel.placesbooking.usecase.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("v1/places")
public class PlacesBookingController {

    private final PlaceResourceRequestToPlaceConvert placeResourceRequestToPlaceConvert;
    private final PlaceToPlaceResourceResponseConvert placeToPlaceResourceResponseConvert;
    private final PlaceResourceRequestCustomToPlaceConverter placeResourceRequestCustomToPlaceConverter;
    private final SavePlaceUseCase savePlaceUseCase;
    private final ListAllPlacesUseCase listAllPlacesUseCase;
    private final GetByIdPlaceUseCase getByIdPlaceUseCase;
    private final UpdatePlaceUseCase updatePlaceUseCase;
    private final DeletePlaceUseCase deletePlaceUseCase;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlaceResource save(@RequestBody final PlaceResource request) {
        log.info("[PLACES-BOOKING][POST][REQUEST] {} ", request);
        final var place = placeResourceRequestToPlaceConvert.convert(request);
        final var placeSaved = savePlaceUseCase.execute(place);
        final var placeResponse = placeToPlaceResourceResponseConvert.convert(place);
        log.info("[PLACES-BOOKING][POST][RESPONSE] {}", placeSaved);
        return placeResponse;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Page<PlaceResource> listAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        log.info("[PLACES-BOOKING][LIST-ALL][REQUEST]: page: {} size {}", page, size);
        return listAllPlacesUseCase.execute(page, size)
                .map(placeToPlaceResourceResponseConvert::convert);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PlaceResource getById(@PathVariable final String id) throws Exception {
        log.info("[PLACES-BOOKING][GET-BY-ID][REQUEST] {}", id);
        return Optional.ofNullable(id)
                .flatMap(getByIdPlaceUseCase::execute)
                .map(placeToPlaceResourceResponseConvert::convert)
                .orElseThrow(() -> new Exception("[PLACE-BOOKING][GET-BY-ID][RESPONSE]: Fail to find Place of id" + id + " in the base."));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PlaceResource update(@RequestBody final PlaceResource request, @PathVariable String id) {
        log.info("[PLACES-BOOKING][POST][REQUEST] {} ", request);
        final var response = ofNullable(request)
                .map(placeRequested -> placeResourceRequestCustomToPlaceConverter.convert(placeRequested, id))
                .map(updatePlaceUseCase::execute)
                .map(placeToPlaceResourceResponseConvert::convert)
                .orElseThrow(() -> new PlaceBookingResponseException("[PLACES-BOOKING][PUT][RESPONSE]: Fail to update Place of id" + request.getId() + " in the base."));
        return response;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final String id) {
        log.info("[PLACES-BOOKING][DELETE][REQUEST] {}", id);
        deletePlaceUseCase.execute(id);
    }

}
