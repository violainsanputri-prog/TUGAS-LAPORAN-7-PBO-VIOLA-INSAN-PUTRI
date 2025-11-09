import controller.ProductController;
import view.ProductConsoleView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ProductConsoleView view = new ProductConsoleView();
        ProductController controller = new ProductController(view);

        while (true) {
            System.out.println("\n=== MENU PRODUK ===");
            System.out.println("1. Tampilkan Produk");
            System.out.println("2. Tambah Produk");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");

            try {
                int pilihan = Integer.parseInt(input.nextLine());
                if (pilihan == 3) {
                    System.out.println("Keluar dari aplikasi.");
                    break;
                }
                controller.handlingPilihanMenu(pilihan);
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka 1-3.");
            }
        }

        input.close();
    }
}
