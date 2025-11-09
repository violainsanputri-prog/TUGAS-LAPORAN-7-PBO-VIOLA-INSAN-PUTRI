import service.ProductService;
import service.ProductServiceDefault;
import model.Product;

public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductServiceDefault();

        // Tambah produk baru
        service.addProduct("Keyboard Logitech", 350000);

        // Tampilkan semua produk
        System.out.println("=== DAFTAR PRODUK ===");
        for (Product p : service.getAllProducts()) {
            System.out.println(p);
        }
    }
}
