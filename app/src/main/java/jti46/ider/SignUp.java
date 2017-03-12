package jti46.ider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class SignUp extends AppCompatActivity {

    Button buttonsigninhere, buttonSignup1;
    EditText edtUsername, edtPassword;
    Context mContext;
    Spinner spinRole;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        spinRole = (Spinner) findViewById(R.id.spinRole);

        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, this.pelangganList());
        this.spinRole.setAdapter(categoriesAdapter);


        buttonsigninhere = (Button) findViewById(R.id.signinhere);
        buttonSignup1 = (Button) findViewById(R.id.signup1);
        edtUsername = (EditText) findViewById(R.id.username);
        edtPassword = (EditText) findViewById(R.id.username);

        mContext = getApplicationContext();
        buttonsigninhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, MainActivity.class);
                startActivity(mIntent);
            }
        });
        buttonSignup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private ArrayList<String> pelangganList() {
        ArrayList<String> categories = new ArrayList<>();

        categories.add("Pelanggan");
        categories.add("Pedagang");
        return categories;
    }
}
