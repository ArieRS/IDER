package jti46.ider.ModeLogin;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alhamdulillah on 3/11/17.
 */

public class ResultLogin {
    @SerializedName("Nama")
    String Nama;
    @SerializedName("Level")
    String Level;

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }
}
