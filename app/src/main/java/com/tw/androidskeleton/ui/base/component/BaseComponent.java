package com.tw.androidskeleton.ui.base.component;

import com.tw.androidskeleton.ui.base.module.AppModule;
import com.tw.androidskeleton.ui.base.module.BaseModule;
import com.tw.androidskeleton.ui.base.PerActivity;
import com.tw.androidskeleton.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@PerActivity
@Component(modules = {BaseModule.class, AppModule.class})
public interface BaseComponent {
    void inject(MainActivity mainActivity);
}
