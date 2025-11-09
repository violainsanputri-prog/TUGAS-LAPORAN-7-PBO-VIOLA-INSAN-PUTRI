import java.util.ArrayList;
import java.util.Scanner;
import dao.ProductDao;
import dao.memory.ProductDaoInMemory;
import model.Product;

public class Main {
    private final ProductDao productDao = new ProductDaoInMemory();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main app = new Main();
        app.startMenuLoop();
        app.scanner.close();
    }

    public void startMenuLoop() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== APLIKASI DAO PATTERN ===");
            System.out.println("1. Tampilkan Semua Produk");
            System.out.println("2. Tambah Produk Baru");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> displayProducts();
                    case 2 -> addNewProduct();
                    case 3 -> running = false;
                    default -> System.out.println("Opsi tidak valid.");
                }
            } catch (Exception e) {
                System.out.println("Input error: " + e.getMessage());
            }
        }
    }

    private void displayProducts() {
        System.out.println("\n=== Daftar Produk ===");
        ArrayList<Product> products = productDao.findAll();
        for (Product p : products) {
            System.out.println(p);
        }
    }

    private void addNewProduct() {
        System.out.print("Nama Produk: ");
        String name = scanner.nextLine();
        System.out.print("Harga Produk: ");
        double price = Double.parseDouble(scanner.nextLine());

        if (price <= 0) {
            System.out.println("Error: Harga harus angka positif lebih dari 0.");
            return;
        }

        int nextId = productDao.findAll().size() + 1;
        Product newProduct = new Product(nextId, name, price);
        productDao.save(newProduct);

        System.out.println("Produk berhasil ditambahkan!");
    }
}
