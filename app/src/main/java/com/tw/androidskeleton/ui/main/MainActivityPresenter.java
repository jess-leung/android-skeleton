package com.tw.androidskeleton.ui.main;

import com.tw.androidskeleton.data.model.Message;
import com.tw.androidskeleton.data.service.MessageService;
import com.tw.androidskeleton.ui.base.BasePresenter;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivityPresenter extends BasePresenter<MainActivityView> {

    private MessageService messageService;

    public MainActivityPresenter(MessageService messageService) {
        this.messageService = messageService;
    }

    public void onCreate() {
        messageService.getMessages().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<List<Message>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Message> messages) {
                        getView().setupMessagesList(messages.get(0).getContent());
                    }
                });
    }
}
