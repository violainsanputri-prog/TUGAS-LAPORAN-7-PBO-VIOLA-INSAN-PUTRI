package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Product;

public class ProductConsoleView {
    private final Scanner scanner;

    public ProductConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayAllProducts(ArrayList<Product> products) {
        System.out.println("\n---- Daftar Produk ----");
        if (products.isEmpty()) {
            System.out.println("Tidak ada produk tersedia.");
        } else {
            for (Product product : products) {
                System.out.println(product.getId() + " - " + product.getName()
                        + " Rp. " + product.getPrice());
            }
        }
    }

    public String getProductNameFromUser() {
        System.out.print("Masukkan Nama Produk: ");
        return scanner.nextLine();
    }

    public String getProductPriceFromUser() {
        System.out.print("Masukkan Harga Produk: ");
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println("INFO: " + message);
    }

    public void displayError(String message) {
        System.out.println("ERROR: " + message);
    }
}
