package com.example.blogs.ui.categories;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blogs.R;
import com.example.blogs.data.model.Category;
import com.example.blogs.ui.blogs.BlogsActivity;
import com.example.blogs.ui.common.OnItemClickListener;
import com.google.gson.Gson;

public class CategoriesFragment extends Fragment {

    private CategoriesAdapter categoryAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CategoriesViewModel homeViewModel = new ViewModelProvider(this, new CategoriesViewModelFactory()).get(CategoriesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_categories, container, false);

        ContentLoadingProgressBar progress = root.findViewById(R.id.progress);

        RecyclerView categoriesRecyclerView = root.findViewById(R.id.categories_recycler_view);
        OnItemClickListener<Category> onCategoryClickListener = (view, category) -> {
            Intent intent = new Intent(getActivity(), BlogsActivity.class);
            String categoryJson = new Gson().toJson(category);
            intent.putExtra("Category", categoryJson);
            intent.putExtra("CallerActivity", getActivity().getClass().getSimpleName());
            startActivity(intent);
        };

        categoryAdapter = new CategoriesAdapter(root.getContext(), onCategoryClickListener);
        categoriesRecyclerView.setAdapter(categoryAdapter);
        categoriesRecyclerView.setLayoutManager(new GridLayoutManager(root.getContext(), 2));

        progress.show();
        homeViewModel.getCategories().observe(getViewLifecycleOwner(), categories -> {
            categoryAdapter.setCategories(categories);
            progress.hide();
        });

        return root;
    }
}