package dao;

import model.Product;
import java.util.ArrayList;
import java.util.List;

public class InMemoryProductDao implements ProductDao {
    private final List<Product> productList = new ArrayList<>();

    public InMemoryProductDao() {
        // sample initial data
        productList.add(new Product(1, "Laptop ASUS", 9500000));
        productList.add(new Product(2, "Monitor Dell", 2500000));
    }

    @Override
    public void save(Product p) {
        productList.add(p);
    }

    @Override
    public Product findById(int id) {
        for (Product p : productList) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }
}
