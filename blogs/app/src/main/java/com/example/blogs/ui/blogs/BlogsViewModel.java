package com.example.blogs.ui.blogs;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.blogs.data.model.Blog;
import com.example.blogs.data.model.Category;
import com.example.blogs.data.repository.BlogsRepository;

import java.util.List;

public class BlogsViewModel extends ViewModel {

    private MutableLiveData<List<Blog>> blogs;
    private BlogsRepository blogsRepository;

    public BlogsViewModel(BlogsRepository blogsRepository) {
        this.blogsRepository = blogsRepository;
    }

    public MutableLiveData<List<Blog>> getBlogsByCategory(int id) {
        blogs = blogsRepository.getBlogsByCategory(id);

        return blogs;
    }
    public MutableLiveData<List<Blog>> getBlogs() {
        blogs = blogsRepository.getBlogs();

        return blogs;
    }
}