package com.example.blogs.data.remote;

import com.example.blogs.data.model.Blog;
import com.example.blogs.data.model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IBlogsApi {
    @GET("categories")
    Call<List<Category>> getCategories();

    @GET("categories/{id}/blogs")
    Call<List<Blog>> getBlogsByCategory(@Path("id") int id);

    @GET("blogs")
    Call<List<Blog>> getBlogs();
}
