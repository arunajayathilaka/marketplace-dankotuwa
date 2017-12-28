package com.app.arunaj.marketplace_dankotuwa.presentation.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.arunaj.marketplace_dankotuwa.R;
import com.app.arunaj.marketplace_dankotuwa.presentation.login.MPLoginActivity;

public class MPSplashViewActivity extends AppCompatActivity {

    private int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpsplash_view);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(MPSplashViewActivity.this,MPLoginActivity.class);
                startActivity(intent);
            }
        },SPLASH_TIME_OUT);
    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}
