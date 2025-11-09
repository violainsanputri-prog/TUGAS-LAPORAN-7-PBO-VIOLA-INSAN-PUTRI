import java.util.ArrayList;
import java.util.Scanner;

import model.Product;

public class Main {
    private final ArrayList<Product> products = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public Main() {
        // Sample products
        products.add(new Product(1, "Laptop", 1500000));
        products.add(new Product(2, "Smartphone", 800000));
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.startMenuLoop();
        app.scanner.close();
    }

    public void startMenuLoop() {
        boolean running = true;

        while (running) {
            System.out.println("\n-- APLIKASI TANPA PATTERN --");
            System.out.println("1. Tampilkan Semua Produk");
            System.out.println("2. Tambah Produk Baru");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> displayAllProducts();
                    case 2 -> addNewProduct();
                    case 3 -> {
                        running = false;
                        System.out.println("Keluar dari aplikasi...");
                    }
                    default -> System.out.println("Opsi tidak valid. Silakan coba lagi.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Silakan masukkan angka.");
            }
        }
    }

    public void displayAllProducts() {
        System.out.println("\n-- Daftar Produk: --");
        for (Product product : products) {
            System.out.println(product.getId() + " - " + product.getName() + " - Rp" + product.getPrice());
        }
    }

    public void addNewProduct() {
        System.out.print("Masukkan Nama Produk: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan Harga Produk: ");
        String priceInput = scanner.nextLine();

        try {
            long price = Long.parseLong(priceInput);
            if (price < 0) {
                throw new IllegalArgumentException("Harga harus positif di atas nol.");
            }

            int newId = products.size() + 1;
            products.add(new Product(newId, name, price));
            System.out.println("Produk berhasil ditambahkan.");

        } catch (NumberFormatException e) {
            System.out.println("Harga tidak valid. Silakan masukkan angka.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
