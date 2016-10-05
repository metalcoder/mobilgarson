package com.volcaniccoder.mobilgarson.di;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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


}
