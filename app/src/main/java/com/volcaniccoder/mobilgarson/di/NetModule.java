package com.volcaniccoder.mobilgarson.di;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.volcaniccoder.mobilgarson.api.MobilGarsonService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by volkan on 05.10.2016.
 */

@Module
public class NetModule {

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferances(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    String providesString() {
        return "hi volkan";
    }

//    @Provides
//    @Singleton
//    Gson provideGson() {
//        GsonBuilder gsonBuilder = new GsonBuilder();
//        return gsonBuilder.create();
//    }
//
//    @Provides
//    @Singleton
//    OkHttpClient provideOkHttpClient() {
//        OkHttpClient client = new OkHttpClient();
//        return client;
//    }

    @Provides
    @Singleton
    MobilGarsonService providesApiService(SharedPreferences preferences) {

        String baseUrl = "http://192.168.1.6:52545/mobilgarson/webresources/";

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .build();

        String savedUrl = preferences.getString("ip",null);
        if (savedUrl == null){
            preferences.edit().putString("ip",baseUrl).commit();
        }else {
            baseUrl = preferences.getString("ip",null);
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .client(client)
                .build();

        MobilGarsonService service = retrofit.create(MobilGarsonService.class);

        return service;
    }


}
