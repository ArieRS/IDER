package jti46.ider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignIn extends AppCompatActivity {

    Button buttonSignin1;
    EditText edtPassword;
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
        mContext = getApplicationContext();

        buttonSignin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent;
                if (edtPassword.getText().toString().equalsIgnoreCase("0")){
                    mIntent= new Intent(mContext, UserDashboardActivity.class);
                }else {
                    mIntent= new Intent(mContext, VendorDashboardActivity.class);
                }
                startActivity(mIntent);
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
