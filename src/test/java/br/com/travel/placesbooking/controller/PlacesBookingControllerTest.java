package br.com.travel.placesbooking.controller;

import br.com.travel.placesbooking.converter.PlaceResourceRequestToPlaceConvert;
import br.com.travel.placesbooking.converter.PlaceToPlaceResourceResponseConvert;
import br.com.travel.placesbooking.domain.Place;
import br.com.travel.placesbooking.resource.PlaceResource;
import br.com.travel.placesbooking.usecase.ListAllPlacesUseCase;
import br.com.travel.placesbooking.usecase.SavePlaceUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlacesBookingControllerTest {

    @InjectMocks
    private PlacesBookingController placesBookingController;

    @Spy
    private PlaceResourceRequestToPlaceConvert placeResourceRequestToPlaceConvert = new PlaceResourceRequestToPlaceConvert(new ModelMapper());
    @Spy
    private PlaceToPlaceResourceResponseConvert placeToPlaceResourceResponseConvert = new PlaceToPlaceResourceResponseConvert(new ModelMapper());

    @Mock
    private SavePlaceUseCase savePlaceUseCase;
    @Mock
    private ListAllPlacesUseCase listAllPlacesUseCase;

    @Test
    @DisplayName("Savind a place, expected success")
    public void testShouldExecuteSavePlaceResource() {

        Place place = Place
                .builder()
                .id("1234")
                .city("Sao Paulo")
                .name("Sampa")
                .state("SP")
                .createdAt(LocalDateTime.now())
                .build();

        PlaceResource resource = PlaceResource
                .builder()
                .name("Sampa")
                .city("Sao Paulo")
                .state("SP")
                .build();

        when(savePlaceUseCase.execute(any(Place.class))).thenReturn(place);
        placesBookingController.save(resource);

        verify(placeResourceRequestToPlaceConvert, atLeastOnce()).convert(any(PlaceResource.class));
        verify(placeToPlaceResourceResponseConvert, atLeastOnce()).convert(any(Place.class));
        verify(savePlaceUseCase, atLeastOnce()).execute(any(Place.class));

        assertAll("Booking",
                () -> assertEquals("Sampa", resource.getName()),
                () -> assertEquals("Sao Paulo", resource.getCity()),
                () -> assertEquals("SP", resource.getState())
        );
    }

    @Test
    @DisplayName("List all place, excpected success")
    public void testShouldExecuteListAllPlace() {

        Place place = Place
                .builder()
                .name("Sampa")
                .city("Sao Paulo")
                .state("SP")
                .build();

        when(listAllPlacesUseCase.execute(anyInt(), anyInt())).thenReturn(new PageImpl<>(List.of(place)));
        final var response = placesBookingController.listAll(0, 10);

        verify(listAllPlacesUseCase, atLeastOnce()).execute(anyInt(), anyInt());

        assertNotNull(response);

    }


}