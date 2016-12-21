package com.volcaniccoder.mobilgarson.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.volcaniccoder.mobilgarson.BuildConfig;
import com.volcaniccoder.mobilgarson.MobilGarsonApp;
import com.volcaniccoder.mobilgarson.R;
import com.volcaniccoder.mobilgarson.dashboard.DashboardActivity;
import com.volcaniccoder.mobilgarson.register.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @BindView(R.id.loginMailEditText)
    EditText loginMailEditText;
    @BindView(R.id.loginPasswordEditText)
    EditText loginPasswordEditText;
    @BindView(R.id.loginButton)
    Button loginButton;
    @BindView(R.id.loginNewUserTextView)
    TextView loginNewUserTextView;
    @BindView(R.id.activity_login)
    LinearLayout activityLogin;

    ILoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenterImpl(this, ((MobilGarsonApp) getApplication()));

        if (BuildConfig.DEBUG) {
            loginMailEditText.setText("vs@vs.com");
            loginPasswordEditText.setText("1");
        }

    }

    @OnClick(R.id.loginButton)
    public void loginButtonClick(View view) {
        loginPresenter.validateLogin(loginMailEditText.getText().toString(),
                loginPasswordEditText.getText().toString());
    }

    @OnClick(R.id.loginNewUserTextView)
    public void loginNewUserClick(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void navigateToDashboard() {
        startActivity(new Intent(this, DashboardActivity.class));
    }

    public void loginFailed() {
        Toast.makeText(this, "Yanlis Bilgi", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
    }
}
