package jti46.ider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SignUp extends AppCompatActivity {

    Button buttonsigninhere;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        buttonsigninhere = (Button) findViewById(R.id.signinhere);
        mContext = getApplicationContext();
        buttonsigninhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, MainActivity.class);
                startActivity(mIntent);
            }
        });
    }
}
