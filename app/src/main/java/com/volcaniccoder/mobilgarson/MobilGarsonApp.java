package com.volcaniccoder.mobilgarson;

import android.app.Application;

import com.volcaniccoder.mobilgarson.di.AppModule;
import com.volcaniccoder.mobilgarson.di.DaggerNetComponent;
import com.volcaniccoder.mobilgarson.di.NetComponent;
import com.volcaniccoder.mobilgarson.di.NetModule;

/**
 * Created by volkan on 05.10.2016.
 */

public class MobilGarsonApp extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule())
                .build();
    }

    public NetComponent getNetComponent(){
        return mNetComponent;
    }

}
