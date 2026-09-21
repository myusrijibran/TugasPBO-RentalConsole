package Model;

public class SewaPS4 extends SewaConsole {
    private int jumlahStikExtra;
    private final double BIAYA_STIK = 10000;

    public SewaPS4(String idSewa, String namaPenyewa, int durasiJam, double tarifPerJam, int jumlahStikExtra) {
        super(idSewa, namaPenyewa, durasiJam, tarifPerJam);
        this.jumlahStikExtra = jumlahStikExtra;
    }

    public int getJumlahStikExtra() { return jumlahStikExtra; }
    public void setJumlahStikExtra(int jumlahStikExtra) { this.jumlahStikExtra = jumlahStikExtra; }

    @Override
    public double hitungTotalBiaya() {
        return super.hitungTotalBiaya() + (jumlahStikExtra * BIAYA_STIK);
    }

    @Override
    public void tampilkanDetail() {
        String spek = "Stik Extra: " + jumlahStikExtra;
        System.out.printf("| %-6s | %-15s | %-8s | %-10d | Rp %-10.0f | %-20s |%n", 
                getIdSewa(), getNamaPenyewa(), "PS4", getDurasiJam(), hitungTotalBiaya(), spek);
    }
}
