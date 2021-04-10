package pl.malek.service;

import pl.malek.model.Part;
import java.util.List;
import java.util.Optional;

public interface PartServiceInterface {
    List<Part> getParts();

    void addNewPart(Part part);

    Optional<Part> get(Long id);

    void delete(Long id);

    void update(Part part);
}
