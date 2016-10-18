package com.tw.androidskeleton.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tw.androidskeleton.ui.base.component.BaseComponent;


public abstract class BaseActivity extends AppCompatActivity {

    protected abstract void inject(BaseComponent baseComponent);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(((AndroidSkeletonApplication) getApplication()).getBaseComponent());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
