package com.tw.androidskeleton.data.service;

import com.tw.androidskeleton.data.model.Message;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

public interface MessageApi {
    @GET("/messages")
    Observable<List<Message>> getMessages();

    @POST("/messages")
    Observable<Message> sendMessage(@Body Message message);
}
