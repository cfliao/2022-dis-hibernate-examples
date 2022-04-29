package service;

import domain.Category;
import domain.Item;
import domain.Product;
import repository.CategoryRepository;
import repository.ItemRepository;
import repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("catalogService")
public class CatalogService {

    private static final Logger log = LoggerFactory.getLogger(CatalogService.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ItemRepository itemRepository;

//    public static void main(String[] args) {
//
//        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
//        appContext.scan(new String[]{"jpetstore.repository", "jpetstore.service"});
//        appContext.refresh();
//
//        CatalogService svc = (CatalogService) appContext.getBean("catalogService");
//        svc.test();
//
//        appContext.close();
//    }

    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }

    public Optional<Product> getProduct(String productId) {
        return productRepository.findById(productId);
    }

    public List<Item> getItemListByProduct(String productId) {
        return itemRepository.findAllByProductId(productId);
    }

    public Optional<Item> getItem(String itemId) {
        return itemRepository.findById(itemId);
    }

    public boolean isItemInStock(String itemId) {
        Optional<Item> item = getItem(itemId);
        return item.isPresent() ? item.get().getQuantity() > 0 : false;
    }

    public List<Product> getProductListByCategory(String categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public List<Product> searchProductList(String keywords) {
        List<Product> products = new ArrayList<>();
        for (String keyword : keywords.split("\\s+")) {
            products.addAll(productRepository.findByNameContaining(keyword.toLowerCase()));
        }
        return products;
    }

    public Optional<Category> getCategory(String categoryId) {
        return categoryRepository.findById(categoryId);
    }

    void test() {
//        log.info("-------------------------------");
//        for (Category category : getCategoryList()) {
//            log.info(category.toString());
//        }
//        log.info("-------------------------------");
//        Optional<Category> category = getCategory("DOGS");
//        log.info(String.valueOf(category));
//        log.info("-------------------------------");
//
//        Optional<Product> product = getProduct("FI-SW-01");
//        log.info(String.valueOf(product.get()));
//
//        log.info("-------------------------------");
//        for (Product p : getProductListByCategory("DOGS")) {
//            log.info(p.toString());
//        }
//
//        log.info("-------------------------------");
//        for (Product p : searchProductList("fish")) {
//            log.info(p.toString());
//        }

//        log.info("-------------------------------");
//        for (Item item : getItemListByProduct("K9-BD-01")) {
//            log.info(item.toString());
//        }

        Optional<Item> item = getItem("EST-6");
        log.info(String.valueOf(item.get()));
        log.info(String.valueOf(isItemInStock("EST-1")));
        log.info(String.valueOf(isItemInStock("EST-6")));
    }
}
