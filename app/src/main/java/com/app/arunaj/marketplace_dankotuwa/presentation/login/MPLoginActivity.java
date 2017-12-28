package com.app.arunaj.marketplace_dankotuwa.presentation.login;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.arunaj.marketplace_dankotuwa.R;
import com.app.arunaj.marketplace_dankotuwa.presentation.BaseActivity;
import com.app.arunaj.marketplace_dankotuwa.presentation.BasePresenter;
import com.app.arunaj.marketplace_dankotuwa.presentation.activities.MPDashBoardActivity;
import com.app.arunaj.marketplace_dankotuwa.util.EmailValidator;
import com.app.arunaj.marketplace_dankotuwa.util.MPSharedPreferences;

public class MPLoginActivity extends BaseActivity implements MPLoginView {

    private String mEmail;
    private String mPassword;
    private TextInputEditText mPasswordText;
    private TextInputEditText mEmailText;
    private TextView mEmailFailText;
    private TextView mPasswordFailText;
    private ProgressBar mLoginProgressBar;
    private IMPLoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MPSharedPreferences.context = getApplicationContext();
        boolean loggedIn = MPSharedPreferences.getBooleanPreference("loggedIn", false);
        if (loggedIn) {
            directToHome();
        } else {
            setContentView(R.layout.activity_login);
            mEmailText = (TextInputEditText) findViewById(R.id.input_email);
            mPasswordText = (TextInputEditText) findViewById(R.id.input_password);
            mEmailFailText = (TextView) findViewById(R.id.email_fail_text);
            mPasswordFailText = (TextView) findViewById(R.id.password_fail_text);
            mLoginProgressBar = (ProgressBar) findViewById(R.id.login_progress);
            String lastLogin = MPSharedPreferences.getStringPreference("lastLoggedInUser");
            mEmailText.setText(lastLogin);
            mLoginPresenter = new MPLoginPresenterImp();
            mLoginPresenter.onAttached(this);
        }
    }

    public void onLoginClick(View view) {
        mEmailFailText.setVisibility(View.GONE);
        mPasswordFailText.setVisibility(View.GONE);
        mLoginProgressBar.setVisibility(View.GONE);
        mEmail = mEmailText.getText().toString();
        mPassword = mPasswordText.getText().toString();
        if (new EmailValidator().validate(mEmail)) {
            if (mPassword.isEmpty()) {
                setLoginFailMessage(mPasswordFailText, R.string.password_empty_text);
            } else {
                mLoginProgressBar.setVisibility(View.VISIBLE);
                requestForAsyncLogin();
            }
        } else {
            setLoginFailMessage(mEmailFailText, R.string.incorrect_email_text);
        }
    }

    public void onForgotPasswordClick(View view) {
       /* mEmail = mEmailText.getText().toString();
        Intent intent = new Intent(this, ResetPasswordActivity.class);
        intent.putExtra("email", mEmail);
        startActivity(intent);*/
    }

    public void saveToken(String token, int id) {
        MPSharedPreferences.setBooleanPreference("loggedIn", true);
        Log.d("token", token);
        MPSharedPreferences.setStringPreference("token", token);
        MPSharedPreferences.setStringPreference("lastLoggedInUser", mEmail);
        MPSharedPreferences.setIntPreference("id", id);
    }

    public void directToHome() {
       /* Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
        finish();*/
    }

    public void setPasswordEmpty() {
        mPasswordText.setText("");
    }

    public void dismissProgress() {
        mLoginProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void requestForAsyncLogin() {
        new LoginAsyncCall().execute();
    }

//    @Override
//    public String serverErrorMsg() {
//        return getResources().getString(R.string.error_response_null);
//    }

    public void setLoginFailMessage(TextView textView, int msg){
        textView.setText(msg);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void displayServerErrorToast() {
        super.displayServerErrorToast();
    }

    @Override
    public void setLoginFailMessage(TextView textView, String msg) {
        if (textView == null) {
            textView = mEmailFailText;
        }
        textView.setText(msg);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setPresenter(BasePresenter presenter) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    private class LoginAsyncCall extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            mLoginPresenter.verifyLogin(mEmail, mPassword);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mLoginPresenter.onFinishAsynLoginCall();
        }
    }
}
