package com.tw.androidskeleton.ui.base.module;

import android.app.Application;

import com.tw.androidskeleton.ui.base.AndroidSkeletonApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    AndroidSkeletonApplication application;

    public AppModule(AndroidSkeletonApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideAndroidSkeletonApplication() {
        return application;
    }
}
