package pl.malek.calculator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import pl.malek.dto.BikeDto;
import pl.malek.repository.BikeRepository;
import pl.malek.service.BikeService;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {

    @Mock
    BikeRepository bikeRepository;

    @InjectMocks
    BikeService bikeService;


    @Test
    void shouldCalculatePrice() {

    }
}