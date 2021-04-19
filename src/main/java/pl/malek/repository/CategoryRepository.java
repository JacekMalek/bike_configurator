package pl.malek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.malek.category.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}