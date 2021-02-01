package com.example.blogs.ui.categories;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.blogs.data.model.Category;
import com.example.blogs.data.repository.BlogsRepository;

import java.util.List;

public class CategoriesViewModel extends ViewModel {

    private final BlogsRepository categoryRepository;

    public CategoriesViewModel(BlogsRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public MutableLiveData<List<Category>> getCategories() {

        return categoryRepository.getCategories();
    }

}