package com.volcaniccoder.mobilgarson.login;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import com.volcaniccoder.mobilgarson.MobilGarsonApp;
import com.volcaniccoder.mobilgarson.api.MobilGarsonService;
import com.volcaniccoder.mobilgarson.models.pojo.LoginUserResult;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by volkan on 05.10.2016.
 */

public class LoginPresenterImpl implements ILoginPresenter {

    private ILoginView loginView;
    public static int userId;

    @Inject
    MobilGarsonService service;
    @Inject
    SharedPreferences preferences;

    public LoginPresenterImpl(ILoginView loginView, MobilGarsonApp application) {
        application.getNetComponent().inject(this);
        this.loginView = loginView;
    }

    public void validateLogin(String mail,String password) {

        service.getLoginAuthentication(mail, password).enqueue(new Callback<LoginUserResult>() {
            @Override
            public void onResponse(Call<LoginUserResult> call, Response<LoginUserResult> response) {
                LoginUserResult result = response.body();
                if (result != null){
                    userId = result.getId();
                    loginView.navigateToDashboard();
                }else {
                    loginView.loginFailed();
                }
            }

            @Override
            public void onFailure(Call<LoginUserResult> call, Throwable t) {
                Log.w("RETROFIT",t.getMessage());
                loginView.loginFailed();
            }
        });

    }

    @Override
    public SharedPreferences getBackdoorPreferences() {
        return preferences;
    }
}
