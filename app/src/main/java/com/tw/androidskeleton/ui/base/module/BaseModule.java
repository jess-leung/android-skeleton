package com.tw.androidskeleton.ui.base.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.androidskeleton.data.service.MessageApi;
import com.tw.androidskeleton.data.service.MessageService;
import com.tw.androidskeleton.ui.main.MainActivityPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class BaseModule {

    String baseUrl;

    public BaseModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public MessageService provideMessageService(Retrofit retrofit) {
        MessageApi messageApi = retrofit.create(MessageApi.class);
        return new MessageService(messageApi);
    }

    @Provides
    @Singleton
    public MainActivityPresenter provideMainActivityPresenter(MessageService messageService) {
        return new MainActivityPresenter(messageService);
    }
}
