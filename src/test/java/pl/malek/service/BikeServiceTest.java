package pl.malek.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.malek.dto.BikeDto;
import pl.malek.repository.BikeRepository;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class BikeServiceTest {

    @Mock
    private BikeRepository bikeRepository;

    @InjectMocks
    private BikeService bikeService;


    @Test
    void getAll() {
    }

    @Test
    void shouldAdd() {
        //given


        //when


        //then

    }


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