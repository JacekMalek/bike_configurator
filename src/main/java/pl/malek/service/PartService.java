package pl.malek.service;


import org.springframework.stereotype.Repository;
import pl.malek.part.Part;
import pl.malek.repository.PartRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class PartService implements MethodInterface<Part> {
    private final PartRepository partRepository;

    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<Part> getAll() {
        return partRepository.findAll();
    }

    @Override
    public void add(Part part) {
        partRepository.save(part);
    }

    @Override
    public Optional<Part> get(Long id) {
        return partRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        partRepository.deleteById(id);
    }

    @Override
    public void update(Part part) {
        partRepository.save(part);
    }
}
