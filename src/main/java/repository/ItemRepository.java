package repository;

import domain.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, String>  {

  //void updateInventoryQuantity(Map<String, Object> param);

  //int getInventoryQuantity(String itemId);

  List<Item> findAllByProductId(String productId);

  Optional<Item> findById(String itemId);

}
