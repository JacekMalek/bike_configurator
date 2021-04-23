package pl.malek.service;

import org.springframework.stereotype.Service;
import pl.malek.dto.FrameDto;
import pl.malek.model.Frame;
import pl.malek.repository.FrameRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FrameService implements MethodInterface<FrameDto>{
    public final FrameRepository frameRepository;

    public FrameService(FrameRepository frameRepository) {
        this.frameRepository = frameRepository;
    }


    @Override
    public List<FrameDto> getAll() {
        return frameRepository.findAll()
                .stream()
                .map(frame -> new FrameDto(frame.getId(), frame.getName(),frame.getSize(), frame.getMaterial(), frame.getProducer(),
                        frame.getWeight(), frame.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public void add(FrameDto frameDto) {
        Frame frame = new Frame();
        frame.setName(frameDto.getName());
        frame.setSize(frameDto.getSize());
        frame.setMaterial(frameDto.getMaterial());
        frame.setProducer(frameDto.getProducer());
        frame.setWeight(frameDto.getWeight());
        frame.setPrice(frameDto.getPrice());
        frameRepository.save(frame);
    }

    @Override
    public Optional<FrameDto> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        frameRepository.deleteById(id);
    }

    @Override
    public void update(FrameDto frameDto) {

    }
}
