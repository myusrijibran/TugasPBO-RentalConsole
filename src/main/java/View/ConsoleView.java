package View;

import Controller.RentalController;
import Model.SewaConsole;
import Model.SewaPS4;
import Model.SewaPS5;
import java.util.Scanner;

public class ConsoleView {
    private RentalController controller;
    private Scanner scanner;

    public ConsoleView() {
        controller = new RentalController();
        scanner = new Scanner(System.in);
    }

    public void mulai() {
        int pilihan = 0;
        do {
            System.out.println("\n=== SISTEM RENTAL CONSOLE GAME ===");
            System.out.println("1. Lihat Daftar Sewa");
            System.out.println("2. Tambah Sewa PS4");
            System.out.println("3. Tambah Sewa PS5");
            System.out.println("4. Perpanjang Durasi Sewa (Update)");
            System.out.println("5. Selesaikan Sewa (Delete)");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");

            try {
                pilihan = Integer.parseInt(scanner.nextLine());
                switch (pilihan) {
                    case 1: controller.tampilkanSemuaSewa(); break;
                    case 2: inputSewaPS4(); break;
                    case 3: inputSewaPS5(); break;
                    case 4: updateDurasiSewa(); break;
                    case 5: hapusDataSewa(); break;
                    case 6: System.out.println("Sistem ditutup. Terima kasih!"); break;
                    default: System.out.println("Pilihan tidak valid.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Input menu harus berupa angka!");
            }
        } while (pilihan != 6);
    }

    private void inputSewaPS4() {
        try {
            System.out.print("Masukkan ID Sewa: ");
            String id = scanner.nextLine();
            System.out.print("Masukkan Nama Penyewa: ");
            String nama = scanner.nextLine();
            System.out.print("Durasi Sewa (Jam): ");
            int durasi = Integer.parseInt(scanner.nextLine());
            System.out.print("Jumlah Stik Extra (0 jika tidak ada): ");
            int stik = Integer.parseInt(scanner.nextLine());

            controller.tambahSewa(new SewaPS4(id, nama, durasi, 15000, stik));
        } catch (NumberFormatException e) {
            System.out.println("Error: Durasi dan jumlah stik harus berupa angka bulat!");
        }
    }

    private void inputSewaPS5() {
        try {
            System.out.print("Masukkan ID Sewa: ");
            String id = scanner.nextLine();
            System.out.print("Masukkan Nama Penyewa: ");
            String nama = scanner.nextLine();
            System.out.print("Durasi Sewa (Jam): ");
            int durasi = Integer.parseInt(scanner.nextLine());
            System.out.print("Akses Game VIP? (ya/tidak): ");
            boolean vip = scanner.nextLine().equalsIgnoreCase("ya");

            controller.tambahSewa(new SewaPS5(id, nama, durasi, 25000, vip));
        } catch (NumberFormatException e) {
            System.out.println("Error: Durasi harus berupa angka bulat!");
        }
    }

    private void updateDurasiSewa() {
        System.out.print("Masukkan ID Sewa yang akan diperpanjang: ");
        String id = scanner.nextLine();
        SewaConsole sewa = controller.cariSewa(id);

        if (sewa != null) {
            try {
                System.out.println("Penyewa: " + sewa.getNamaPenyewa() + " | Durasi saat ini: " + sewa.getDurasiJam() + " Jam");
                System.out.print("Masukkan tambahan durasi (Jam): ");
                int tambahDurasi = Integer.parseInt(scanner.nextLine());
                
                sewa.setDurasiJam(sewa.getDurasiJam() + tambahDurasi);
                System.out.println("Durasi berhasil diperbarui! Total durasi sekarang: " + sewa.getDurasiJam() + " Jam");
            } catch (NumberFormatException e) {
                System.out.println("Error: Tambahan durasi harus berupa angka!");
            }
        } else {
            System.out.println("ID Sewa tidak ditemukan.");
        }
    }

    private void hapusDataSewa() {
        System.out.print("Masukkan ID Sewa yang telah selesai: ");
        String id = scanner.nextLine();
        if (controller.hapusSewa(id)) {
            System.out.println("Sewa dengan ID '" + id + "' telah diselesaikan dan dihapus dari daftar.");
        } else {
            System.out.println("Gagal menghapus! ID Sewa tidak ditemukan.");
        }
    }
}
