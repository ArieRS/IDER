package jti46.ider.FramesVendorDashboard;

/**
 * Created by alhamdulillah on 3/12/17.
 */

public class PesananModel {
    String nama;
    String catatan;
    String totalHarga;

    public PesananModel(String nama, String catatan, String totalHarga) {
        this.nama = nama;
        this.catatan = catatan;
        this.totalHarga = totalHarga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(String totalHarga) {
        this.totalHarga = totalHarga;
    }
}
