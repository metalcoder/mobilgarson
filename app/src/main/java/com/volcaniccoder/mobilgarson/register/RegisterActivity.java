package com.volcaniccoder.mobilgarson.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.volcaniccoder.mobilgarson.MobilGarsonApp;
import com.volcaniccoder.mobilgarson.R;
import com.volcaniccoder.mobilgarson.login.LoginActivity;
import com.volcaniccoder.mobilgarson.models.pojo.LoginUserResult;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements IRegisterView {

    IRegisterPresenter presenter;
    @BindView(R.id.registerNameEditText)
    EditText registerNameEditText;
    @BindView(R.id.registerSurnameEditText)
    EditText registerSurnameEditText;
    @BindView(R.id.registerMailEditText)
    EditText registerMailEditText;
    @BindView(R.id.registerPasswordEditText)
    EditText registerPasswordEditText;
    @BindView(R.id.registerButton)
    Button registerButton;
    @BindView(R.id.activity_register)
    LinearLayout activityRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        init();
    }

    @Override
    public void init() {
        presenter = new RegisterPresenterImpl(this, (MobilGarsonApp) getApplication());

    }

    @OnClick(R.id.registerButton)
    public void registerClick(View view){
        LoginUserResult user = new LoginUserResult();
        user.setName(registerNameEditText.getText().toString());
        user.setMail(registerMailEditText.getText().toString());
        user.setSurname(registerSurnameEditText.getText().toString());
        user.setPassword(registerPasswordEditText.getText().toString());
        presenter.registerUser(user);
    }

    @Override
    public void success() {
        Toast.makeText(this, "Kayıt başarılı", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void fail() {
        Toast.makeText(this, "Bir hata oluştu", Toast.LENGTH_SHORT).show();
    }
}
