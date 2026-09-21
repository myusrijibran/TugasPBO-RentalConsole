package Controller;

import Model.SewaConsole;
import Model.SewaPS4;
import Model.SewaPS5;
import java.util.ArrayList;

public class RentalController {
    private ArrayList<SewaConsole> daftarSewa;

    public RentalController() {
        daftarSewa = new ArrayList<>();
        
        daftarSewa.add(new SewaPS4("R001", "Budi", 2, 15000, 1));
        daftarSewa.add(new SewaPS4("R002", "Andi", 3, 15000, 0));
        daftarSewa.add(new SewaPS4("R003", "Siti", 1, 15000, 2));
        
        daftarSewa.add(new SewaPS5("R004", "Reza", 2, 25000, true));
        daftarSewa.add(new SewaPS5("R005", "Dika", 4, 25000, false));
        daftarSewa.add(new SewaPS5("R006", "Gilang", 1, 25000, true));
    }

    public void tambahSewa(SewaConsole sewa) {
        daftarSewa.add(sewa);
        System.out.println("Transaksi sewa berhasil ditambahkan!");
    }

    public void tampilkanSemuaSewa() {
        if (daftarSewa.isEmpty()) {
            System.out.println("Belum ada transaksi sewa.");
        } else {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.printf("| %-6s | %-15s | %-8s | %-10s | %-13s | %-20s |%n", 
                    "ID", "NAMA PENYEWA", "CONSOLE", "DURASI(JAM)", "TOTAL BIAYA", "KETERANGAN TAMBAHAN");
            System.out.println("-----------------------------------------------------------------------------------------");
            
            for (SewaConsole sewa : daftarSewa) {
                sewa.tampilkanDetail(); 
            }
            System.out.println("-----------------------------------------------------------------------------------------");
        }
    }

    public SewaConsole cariSewa(String id) {
        for (SewaConsole sewa : daftarSewa) {
            if (sewa.getIdSewa().equalsIgnoreCase(id)) {
                return sewa;
            }
        }
        return null;
    }

    public boolean hapusSewa(String id) {
        SewaConsole sewa = cariSewa(id);
        if (sewa != null) {
            daftarSewa.remove(sewa);
            return true;
        }
        return false;
    }
}