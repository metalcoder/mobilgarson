package com.volcaniccoder.mobilgarson.login;

import android.content.SharedPreferences;

/**
 * Created by volkan on 05.10.2016.
 */

public interface ILoginPresenter {

    void validateLogin(String mail,String password);

    SharedPreferences getBackdoorPreferences();
}

