package com.app.arunaj.marketplace_dankotuwa.presentation.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.arunaj.marketplace_dankotuwa.R;

public class MPLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_sign_in_user,btn_exit_app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mplogin);

        btn_sign_in_user = (Button) findViewById(R.id.btn_sign_in_user);
        btn_sign_in_user.setOnClickListener(this);

        btn_exit_app = (Button) findViewById(R.id.btn_exit_app);
        btn_exit_app.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sign_in_user:
                Intent i = new Intent(MPLoginActivity.this,MPDashBoardActivity.class);
                startActivity(i);
                break;
            case R.id.btn_exit_app:
                finish();
                break;
        }
    }
}
