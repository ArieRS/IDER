package jti46.ider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import jti46.ider.ModeLogin.Login;
import jti46.ider.RetrofiApi.ApiClient;
import jti46.ider.RetrofiApi.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignIn extends AppCompatActivity {

    Button buttonSignin1;

    EditText edtUsername , edtPassword;
    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_in);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        setContentView(R.layout.content_sign_in);
        buttonSignin1 = (Button) findViewById(R.id.signin1);
        edtPassword = (EditText) findViewById(R.id.password);
        edtUsername = (EditText) findViewById(R.id.username);
        mContext = getApplicationContext();


        buttonSignin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ApiInterface login = ApiClient.getClient().create(ApiInterface.class);
                Call<Login> resultLogin= login.postLogin(edtUsername.getText().toString(),edtPassword.getText().toString());

                resultLogin.enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(Call<Login> call, Response<Login> response) {
                        Intent mIntent;
                        String test = "";
                        Login hasil = response.body();
                        if (hasil.getStatus().equalsIgnoreCase("success")){
                            //1 ke dashboard user
                            if (hasil.getListResultLogins().get(0).getLevel().equalsIgnoreCase("1")){
                                mIntent= new Intent(mContext, UserDashboardActivity.class);
                                startActivity(mIntent);
                            }
                            //2 ke dashboard vendor
                            else if(hasil.getListResultLogins().get(0).getLevel().equalsIgnoreCase("2")){
                                mIntent= new Intent(mContext, VendorDashboardActivity.class);
                                startActivity(mIntent);
                            }
                        }else {
                            Global.showDialogError(mContext,"Login Failed", "Retry");
                        }
                    }

                    @Override
                    public void onFailure(Call<Login> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

//                if (edtPassword.getText().toString().equalsIgnoreCase("0")){
//                    mIntent= new Intent(mContext, UserDashboardActivity.class);
//                }else {
//                    mIntent= new Intent(mContext, VendorDashboardActivity.class);
//                }
//                startActivity(mIntent);

            }
        });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}
