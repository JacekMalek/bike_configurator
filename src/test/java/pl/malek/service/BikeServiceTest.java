package pl.malek.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.malek.dto.BikeDto;
import pl.malek.model.Bike;
import pl.malek.repository.BikeRepository;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class BikeServiceTest {

    @Mock
    private BikeRepository bikeRepository;

    @InjectMocks
    private BikeService bikeService;

//TODO Sprawdzic jak zrobić testy


    @Test
    void getAll() {
    }

    @Test
    void shouldAdd() {
        //given
        BikeDto bikeDto = new BikeDto();
        bikeDto.setId(10L);
        bikeDto.setName("Rower");
        bikeDto.setFrame(bikeDto.getFrame());
        bikeDto.setWheel(bikeDto.getWheel());
        bikeDto.setBrake(bikeDto.getBrake());

        //when
        bikeService.add(bikeDto);

        //then
        assertEquals(bikeDto.getId(), 10L);
        assertEquals(bikeDto.getName(), "Rower");

    }

    //TODO Póki co nie działa, do zrobienia

    @Test
    void get() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}