package com.example.blogs;

import android.app.Application;

import com.example.blogs.data.remote.BlogsApiManager;

public class MainApplication extends Application {

    public static BlogsApiManager blogsApiManager;

    @Override
    public void onCreate() {
        super.onCreate();
        blogsApiManager = BlogsApiManager.getInstance();
    }
}
