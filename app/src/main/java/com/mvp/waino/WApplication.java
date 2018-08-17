package com.mvp.waino;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;

import java.util.logging.Level;

import okhttp3.OkHttpClient;

/**
 * @author waino
 * @date 2018/8/7
 * @desc todo
 */
public class WApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化网络请求，单单配置这条，会使用内部默认初始化的OkHttpClient来进行网络请求
        OkGo.getInstance().init(this);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //初始化Log拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor("OkGo-----");
        interceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        interceptor.setColorLevel(Level.INFO);
        builder.addInterceptor(interceptor);

    }
}
