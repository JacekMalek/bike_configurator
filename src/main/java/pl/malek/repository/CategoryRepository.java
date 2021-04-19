package pl.malek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.malek.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}