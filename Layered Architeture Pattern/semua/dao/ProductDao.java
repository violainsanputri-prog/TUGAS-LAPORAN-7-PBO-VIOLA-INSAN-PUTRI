package dao;

import model.Product;
import java.util.List;

public interface ProductDao {
    void save(Product p);
    Product findById(int id);
    List<Product> findAll();
}
