package com.volcaniccoder.mobilgarson.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.volcaniccoder.mobilgarson.MobilGarsonApp;
import com.volcaniccoder.mobilgarson.R;
import com.volcaniccoder.mobilgarson.dashboard.DashboardActivity;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @Inject
    String denemeStr;
    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenterImpl(this);

        ((MobilGarsonApp) getApplication()).getNetComponent().inject(this);

        Toast.makeText(this, ""+denemeStr, Toast.LENGTH_SHORT).show();

        startActivity(new Intent(this, DashboardActivity.class));
    }
}
