package Model;

public class SewaConsole {
    private String idSewa;
    private String namaPenyewa;
    private int durasiJam;
    private double tarifPerJam;

    public SewaConsole(String idSewa, String namaPenyewa, int durasiJam, double tarifPerJam) {
        this.idSewa = idSewa;
        this.namaPenyewa = namaPenyewa;
        this.durasiJam = durasiJam;
        this.tarifPerJam = tarifPerJam;
    }

    public String getIdSewa() { return idSewa; }
    public void setIdSewa(String idSewa) { this.idSewa = idSewa; }

    public String getNamaPenyewa() { return namaPenyewa; }
    public void setNamaPenyewa(String namaPenyewa) { this.namaPenyewa = namaPenyewa; }

    public int getDurasiJam() { return durasiJam; }
    public void setDurasiJam(int durasiJam) { this.durasiJam = durasiJam; }

    public double getTarifPerJam() { return tarifPerJam; }
    public void setTarifPerJam(double tarifPerJam) { this.tarifPerJam = tarifPerJam; }

    public double hitungTotalBiaya() {
        return durasiJam * tarifPerJam;
    }

    public void tampilkanDetail() {
    }
}
