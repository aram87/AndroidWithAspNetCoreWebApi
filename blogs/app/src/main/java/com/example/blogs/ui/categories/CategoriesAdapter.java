package com.example.blogs.ui.categories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blogs.R;
import com.example.blogs.data.model.Category;
import com.example.blogs.ui.common.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {

    @NonNull
    private final Context context;
    private List<Category> categories = new ArrayList<>();
    private final OnItemClickListener<Category> onCategoryClickListener;

    public CategoriesAdapter(@NonNull Context context, OnItemClickListener<Category> onCategoryClickListener) {
        this.context = context;
        this.onCategoryClickListener = onCategoryClickListener;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.category_item, parent, false));
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.setCategoryItem(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories == null ? 0 : categories.size();
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
        this.notifyDataSetChanged();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {

        private final TextView categoryName;
        private final View categoryItem;

        CategoryViewHolder(View categoryItem) {
            super(categoryItem);
            categoryName = categoryItem.findViewById(R.id.category_name);
            this.categoryItem = categoryItem;
        }

        private void setCategoryItem(Category category){
            categoryName.setText(category.getName());
            categoryItem.setOnClickListener(view -> onCategoryClickListener.onItemClicked(view, category));
        }

    }
}
