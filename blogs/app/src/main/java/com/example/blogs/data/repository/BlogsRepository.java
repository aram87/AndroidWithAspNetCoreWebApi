package com.example.blogs.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.blogs.data.model.Blog;
import com.example.blogs.data.remote.BlogsApiManager;
import com.example.blogs.data.model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlogsRepository {

    private static volatile BlogsRepository instance;

    private final BlogsApiManager blogsApiManager;

    private final MutableLiveData<List<Category>> categories = new MutableLiveData<>();
    private final MutableLiveData<List<Blog>> blogsByCategory = new MutableLiveData<>();
    private final MutableLiveData<List<Blog>> blogs = new MutableLiveData<>();

    private BlogsRepository(BlogsApiManager blogsApiManager) {
        this.blogsApiManager = blogsApiManager;
    }

    public static BlogsRepository getInstance(BlogsApiManager blogsApiManager) {
        if (instance == null) {
            instance = new BlogsRepository(blogsApiManager);
        }
        return instance;
    }

    public MutableLiveData<List<Category>> getCategories(){
        blogsApiManager.getCategories(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful()){
                    List<Category> body = response.body();
                    categories.setValue(body);
                } else{
                    categories.postValue(null);
                }
            }
            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                categories.postValue(null);
            }
        });

        return categories;
    }

    public MutableLiveData<List<Blog>> getBlogsByCategory(int id){
        blogsApiManager.getBlogsByCategory(id, new Callback<List<Blog>>() {
            @Override
            public void onResponse(Call<List<Blog>> call, Response<List<Blog>> response) {
                if (response.isSuccessful()){
                    List<Blog> body = response.body();
                    blogsByCategory.setValue(body);
                } else{
                    blogsByCategory.postValue(null);
                }
            }
            @Override
            public void onFailure(Call<List<Blog>> call, Throwable t) {
                blogsByCategory.postValue(null);
            }
        });

        return blogsByCategory;
    }

    public MutableLiveData<List<Blog>> getBlogs(){
        blogsApiManager.getBlogs(new Callback<List<Blog>>() {
            @Override
            public void onResponse(Call<List<Blog>> call, Response<List<Blog>> response) {
                if (response.isSuccessful()){
                    List<Blog> body = response.body();
                    blogs.setValue(body);
                } else{
                    blogs.postValue(null);
                }
            }
            @Override
            public void onFailure(Call<List<Blog>> call, Throwable t) {
                blogs.postValue(null);
            }
        });

        return blogs;
    }
}
