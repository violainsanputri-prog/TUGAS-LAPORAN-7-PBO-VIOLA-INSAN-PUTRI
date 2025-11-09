package controller;

import service.ProductService;
import view.ProductConsoleView;
import model.Product;

public class ProductController {
    private final ProductService service;
    private final ProductConsoleView view;

    public ProductController(ProductService service, ProductConsoleView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            int choice = view.showMainMenuAndGetChoice();
            switch (choice) {
                case 1:
                    try {
                        String name = view.inputName();
                        long price = view.inputPrice();
                        service.addProduct(name, price);
                        view.showMessage("✅ Produk berhasil ditambahkan.");
                    } catch (Exception e) {
                        view.showMessage("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    view.showProducts(service.getAllProducts());
                    break;
                case 3:
                    int id = view.inputId();
                    Product p = service.getProduct(id);
                    if (p != null) view.showMessage("Ditemukan: " + p);
                    else view.showMessage("Produk dengan ID " + id + " tidak ditemukan.");
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    view.showMessage("Pilihan tidak valid.");
            }
        }
        view.showMessage("Program selesai.");
    }
}
