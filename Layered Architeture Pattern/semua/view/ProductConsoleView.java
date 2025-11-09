package view;

import model.Product;
import java.util.List;
import java.util.Scanner;

public class ProductConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public int showMainMenuAndGetChoice() {
        System.out.println("\n=== PRODUCT MENU ===");
        System.out.println("1. Tambah Product");
        System.out.println("2. Tampilkan Semua Product");
        System.out.println("3. Cari Product by ID");
        System.out.println("0. Exit");
        System.out.print("Pilih: ");
        int c = -1;
        try { c = Integer.parseInt(scanner.nextLine()); } catch (Exception e) { }
        return c;
    }

    public String inputName() {
        System.out.print("Nama produk: ");
        return scanner.nextLine();
    }

    public long inputPrice() {
        System.out.print("Harga (angka): ");
        long price = 0;
        try { price = Long.parseLong(scanner.nextLine()); } catch (Exception e) { }
        return price;
    }

    public int inputId() {
        System.out.print("Masukkan ID: ");
        int id = -1;
        try { id = Integer.parseInt(scanner.nextLine()); } catch (Exception e) { }
        return id;
    }

    public void showProducts(List<Product> list) {
        System.out.println("\n--- DAFTAR PRODUK ---");
        if (list.isEmpty()) {
            System.out.println("(kosong)");
            return;
        }
        for (Product p : list) {
            System.out.println(p);
        }
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}
