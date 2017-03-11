package jti46.ider.ModeLogin;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alhamdulillah on 3/11/17.
 */

public class Login {
    @SerializedName("status")
    String status;
    @SerializedName("message")
    String message;
    @SerializedName("result")
    List<ResultLogin> listResultLogins = new ArrayList<ResultLogin>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultLogin> getListResultLogins() {
        return listResultLogins;
    }

    public void setListResultLogins(List<ResultLogin> listResultLogins) {
        this.listResultLogins = listResultLogins;
    }
}
