package com.example.blogs.data.remote;

import com.example.blogs.data.model.Blog;
import com.example.blogs.data.model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class BlogsApiManager {

    private static IBlogsApi service;
    private static BlogsApiManager apiManager;

    private BlogsApiManager() {
        service = RetrofitService.Create();
    }

    public static BlogsApiManager getInstance() {
        if (apiManager == null) {
            apiManager = new BlogsApiManager();
        }
        return apiManager;
    }
    public void getCategories(Callback<List<Category>> callback){
        Call<List<Category>> categoriesCall = service.getCategories();
        categoriesCall.enqueue(callback);
    }
    public void getBlogsByCategory(int id, Callback<List<Blog>> callback){
        Call<List<Blog>> blogsByCategoryCall = service.getBlogsByCategory(id);
        blogsByCategoryCall.enqueue(callback);
    }
    public void getBlogs(Callback<List<Blog>> callback){
        Call<List<Blog>> blogsCall = service.getBlogs();
        blogsCall.enqueue(callback);
    }
}
