package com.volcaniccoder.mobilgarson.di;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.volcaniccoder.mobilgarson.api.MobilGarsonService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by volkan on 05.10.2016.
 */

@Module
public class NetModule {

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferances(Application application){
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    String providesString(){
        return "hi volkan";
    }

    @Provides
    @Singleton
    MobilGarsonService providesApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.7:52545/mobilgarson/webresources/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MobilGarsonService service = retrofit.create(MobilGarsonService.class);

        return service;
    }


}
