package com.example.blogs.ui.blogs;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.blogs.MainApplication;
import com.example.blogs.data.repository.BlogsRepository;

public class BlogsViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(BlogsViewModel.class)) {
            return (T) new BlogsViewModel(BlogsRepository.getInstance(MainApplication.blogsApiManager));
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}
