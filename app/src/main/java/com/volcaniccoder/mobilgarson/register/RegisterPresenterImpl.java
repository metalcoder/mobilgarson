package com.volcaniccoder.mobilgarson.register;

import com.volcaniccoder.mobilgarson.MobilGarsonApp;
import com.volcaniccoder.mobilgarson.api.MobilGarsonService;
import com.volcaniccoder.mobilgarson.models.pojo.LoginUserResult;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by volkan.sahin on 21.12.2016.
 */

public class RegisterPresenterImpl implements IRegisterPresenter {

    private IRegisterView view;

    @Inject
    MobilGarsonService service;

    public RegisterPresenterImpl(IRegisterView view, MobilGarsonApp application) {
        this.view = view;
        application.getNetComponent().inject(this);
    }

    public void registerUser(LoginUserResult user) {
        service.createUser(user.getMail(), user.getPassword(), user.getName(), user.getSurname()).enqueue(new Callback<LoginUserResult>() {
            @Override
            public void onResponse(Call<LoginUserResult> call, Response<LoginUserResult> response) {
                LoginUserResult result = response.body();
                if (result != null) {
                    view.success();
                } else {
                    view.fail();
                }
            }

            @Override
            public void onFailure(Call<LoginUserResult> call, Throwable t) {
                view.fail();
            }
        });
    }
}
