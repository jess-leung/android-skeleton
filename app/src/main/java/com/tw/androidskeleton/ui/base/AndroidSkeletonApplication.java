package com.tw.androidskeleton.ui.base;

import android.app.Application;

import com.tw.androidskeleton.ui.base.component.BaseComponent;
import com.tw.androidskeleton.ui.base.component.DaggerBaseComponent;
import com.tw.androidskeleton.ui.base.module.AppModule;
import com.tw.androidskeleton.ui.base.module.BaseModule;

public class AndroidSkeletonApplication extends Application {

    private BaseComponent baseComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        String endpoint = "http://wwc-chatroom-staging.herokuapp.com/";
        baseComponent = DaggerBaseComponent
                .builder()
                .baseModule(new BaseModule(endpoint))
                .appModule(new AppModule(this))
                .build();
    }

    public BaseComponent getBaseComponent() {
        return baseComponent;
    }

}
