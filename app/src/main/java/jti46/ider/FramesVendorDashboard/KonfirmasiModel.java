package jti46.ider.FramesVendorDashboard;

import android.widget.Button;

/**
 * Created by alhamdulillah on 3/12/17.
 */

public class KonfirmasiModel {
    String nama;
    String alamat;
    String totalHarga;
    //ini gak perlu :)
    Button buttonTerima, buttonTolak;

    public KonfirmasiModel(String nama, String alamat, String totalHarga) {
        this.nama = nama;
        this.alamat = alamat;
        this.totalHarga = totalHarga;
    }

    public String getNama() {

        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(String totalHarga) {
        this.totalHarga = totalHarga;
    }

    public Button getButtonTerima() {
        return buttonTerima;
    }

    public void setButtonTerima(Button buttonTerima) {
        this.buttonTerima = buttonTerima;
    }

    public Button getButtonTolak() {
        return buttonTolak;
    }

    public void setButtonTolak(Button buttonTolak) {
        this.buttonTolak = buttonTolak;
    }
}
