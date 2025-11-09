package service;

import dao.ProductDao;
import model.Product;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductDao dao;

    public ProductServiceImpl(ProductDao dao) {
        this.dao = dao;
    }

    @Override
    public void addProduct(String name, long price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Harga harus lebih dari 0.");
        }
        int newId = dao.findAll().size() + 1;
        Product p = new Product(newId, name, price);
        dao.save(p);
    }

    @Override
    public Product getProduct(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return dao.findAll();
    }
}
