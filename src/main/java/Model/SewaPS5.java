package Model;

public class SewaPS5 extends SewaConsole {
    private boolean isAksesGameVIP;
    private final double CHARGE_VIP = 25000;

    public SewaPS5(String idSewa, String namaPenyewa, int durasiJam, double tarifPerJam, boolean isAksesGameVIP) {
        super(idSewa, namaPenyewa, durasiJam, tarifPerJam);
        this.isAksesGameVIP = isAksesGameVIP;
    }

    public boolean isAksesGameVIP() { return isAksesGameVIP; }
    public void setAksesGameVIP(boolean isAksesGameVIP) { this.isAksesGameVIP = isAksesGameVIP; }

    @Override
    public double hitungTotalBiaya() {
        double total = super.hitungTotalBiaya();
        if (isAksesGameVIP) {
            total += CHARGE_VIP;
        }
        return total;
    }

    @Override
    public void tampilkanDetail() {
        String spek = "Game VIP: " + (isAksesGameVIP ? "Ya" : "Tidak");
        System.out.printf("| %-6s | %-15s | %-8s | %-10d | Rp %-10.0f | %-20s |%n", 
                getIdSewa(), getNamaPenyewa(), "PS5", getDurasiJam(), hitungTotalBiaya(), spek);
    }
}
