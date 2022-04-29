package repository;

import domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, String> {

    List<Category> findAll();

    Optional<Category> findById(String categoryId);

}
