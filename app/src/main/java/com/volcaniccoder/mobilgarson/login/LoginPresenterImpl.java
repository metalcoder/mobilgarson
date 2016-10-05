package com.volcaniccoder.mobilgarson.login;

/**
 * Created by volkan on 05.10.2016.
 */

public class LoginPresenterImpl implements ILoginPresenter {

    private ILoginView loginView;
    private ILoginInteractor loginInteractor;

    public LoginPresenterImpl(ILoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }
}
