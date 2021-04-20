package pl.malek.service;

import org.springframework.stereotype.Service;
import pl.malek.dto.PartDto;
import pl.malek.model.Category;
import pl.malek.model.Part;
import pl.malek.repository.PartRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartService implements MethodInterface<PartDto> {
    private final PartRepository partRepository;

    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<PartDto> getAll() {
       return partRepository.findAll()
                .stream()
                .map(part -> new PartDto(part.getName(), part.getWeight(),
                        part.getCategory(), part.getProducer(), part.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public void add(PartDto partDto) {
        Part part = new Part();
        part.setName(partDto.getName());
        part.setWeight(partDto.getWeight());
        part.setCategory(partDto.getCategory());;// Jeśli to zakomentuję to zapisywanie do bazy działą ale bez dodawania kategorii
        part.setProducer(partDto.getProducer());
        part.setPrice(partDto.getPrice());
        partRepository.save(part);
    }
//Nie wiem jak to przerobić!
    @Override
    public Optional<PartDto> get(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        partRepository.deleteById(id);
    }

    @Override
    public void update(PartDto partDto) {
        Part part = new Part();
        part.setId(partDto.getId());
        part.setWeight(partDto.getWeight());
        part.setCategory(partDto.getCategory());
        part.setProducer(partDto.getProducer());
        part.setPrice(partDto.getPrice());
        partRepository.save(part);
    }
}
