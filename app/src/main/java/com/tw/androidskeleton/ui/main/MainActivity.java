package com.tw.androidskeleton.ui.main;

import android.os.Bundle;
import android.widget.TextView;

import com.tw.androidskeleton.R;
import com.tw.androidskeleton.ui.base.BaseActivity;
import com.tw.androidskeleton.ui.base.component.BaseComponent;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainActivityView {

    @Inject
    MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityPresenter.setView(this);
        mainActivityPresenter.onCreate();
    }

    @Override
    protected void inject(BaseComponent baseComponent) {
        baseComponent.inject(this);
    }

    @Override
    public void setupMessagesList(String message) {
        TextView messages = (TextView) findViewById(R.id.message_list);
        messages.setText(message);
    }
}
