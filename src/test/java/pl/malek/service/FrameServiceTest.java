package pl.malek.service;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pl.malek.dto.FrameDto;
import pl.malek.model.Frame;
import pl.malek.repository.FrameRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


class FrameServiceTest {

    FrameRepository frameRepository;

    FrameService frameService;

    @Test
    void getAll() {
    }

    @Test
    void shouldAddNewFrame() {
        //given
        Frame frame  = new Frame();
        FrameDto frameDto = new FrameDto();
        frameDto.setId(10L);
        frame.setId(frameDto.getId());

        //when
       // frameService.add(frameDto);
        frameRepository.save(frame);

        //then
        Assert.assertSame(frame.getId(), 10L);

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