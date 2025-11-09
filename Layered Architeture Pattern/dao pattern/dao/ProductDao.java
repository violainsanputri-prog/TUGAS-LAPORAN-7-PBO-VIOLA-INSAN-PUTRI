package dao;

import java.util.ArrayList;
import model.Product;

public interface ProductDao {
    ArrayList<Product> findAll();
    void save(Product product);
}
