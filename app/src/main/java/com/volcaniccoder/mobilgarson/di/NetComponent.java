package com.volcaniccoder.mobilgarson.di;

import com.volcaniccoder.mobilgarson.login.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by volkan on 05.10.2016.
 */

@Singleton
@Component(modules = {AppModule.class,NetModule.class})
public interface NetComponent {
    void inject(LoginActivity activity);
}
