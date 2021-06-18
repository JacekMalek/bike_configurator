package pl.malek.service;


import org.junit.jupiter.api.Test;
import pl.malek.dto.FrameDto;
import pl.malek.model.Frame;
import pl.malek.repository.FrameRepository;


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

//        TODO Do Zrobienia testy

        frame.setName(frameDto.getName());
        frame.setSize(frameDto.getSize());
        frame.setMaterial(frameDto.getMaterial());
        frame.setProducer(frameDto.getProducer());
        frame.setWeight(frameDto.getWeight());
        frame.setPrice(frameDto.getPrice());
        frameRepository.save(frame);
    }
        //when



        //then


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