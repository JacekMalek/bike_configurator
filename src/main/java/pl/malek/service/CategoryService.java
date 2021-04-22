package pl.malek.service;

import org.springframework.stereotype.Service;
import pl.malek.model.Category;
import pl.malek.dto.CategoryDto;
import pl.malek.repository.CategoryRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CategoryService implements MethodInterface<CategoryDto> {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<CategoryDto> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> new CategoryDto(category.getId(), category.getName()))
                .collect(Collectors.toList());
    }

    public void add(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
    }

    @Override
    public Optional<CategoryDto> get(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void update(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
    }


}
