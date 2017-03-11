package jti46.ider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;

public class SplashscreenActivity extends AppCompatActivity
{
    private static final int SPLASH_DURATION = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        this.startSplash();

    }

    private void startSplash()
    {
        this.getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashscreenActivity.this,UserDashboardActivity.class);
                SplashscreenActivity.this.startActivity(mainIntent);
                SplashscreenActivity.this.finish();
            }
        }, SplashscreenActivity.SPLASH_DURATION);
    }
}
