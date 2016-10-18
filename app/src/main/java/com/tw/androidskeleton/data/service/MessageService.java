package com.tw.androidskeleton.data.service;

import com.tw.androidskeleton.data.model.Message;

import java.util.List;

import rx.Observable;

public class MessageService {

    MessageApi messageApi;

    public MessageService(MessageApi messageApi) {
        this.messageApi = messageApi;
    }

    public Observable<List<Message>> getMessages() {
        return messageApi.getMessages();
    }
}
