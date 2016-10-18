package com.tw.androidskeleton.ui.base;

import java.lang.ref.WeakReference;

public class BasePresenter<V extends BaseView> {

    private WeakReference<V> views;

    public void setView(V view) {
        views = new WeakReference<>(view);
    }

    public V getView() {
        return views.get();
    }

}
