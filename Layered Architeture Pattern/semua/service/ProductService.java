package service;

import model.Product;
import java.util.List;

public interface ProductService {
    void addProduct(String name, long price);
    Product getProduct(int id);
    List<Product> getAllProducts();
}
