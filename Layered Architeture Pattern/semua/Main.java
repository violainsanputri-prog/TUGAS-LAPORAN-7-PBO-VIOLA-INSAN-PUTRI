import dao.InMemoryProductDao;
import service.ProductService;
import service.ProductServiceImpl;
import view.ProductConsoleView;
import controller.ProductController;

public class Main {
    public static void main(String[] args) {
        // Inisialisasi komponen (DAO, Service, View, Controller)
        InMemoryProductDao dao = new InMemoryProductDao();
        ProductService service = new ProductServiceImpl(dao);
        ProductConsoleView view = new ProductConsoleView();
        ProductController controller = new ProductController(service, view);

        // Jalankan aplikasi
        controller.run();
    }
}