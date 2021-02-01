package com.example.blogs.ui.blogs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blogs.R;
import com.example.blogs.data.helper.DateHelper;
import com.example.blogs.data.model.Blog;
import com.example.blogs.ui.common.OnItemClickListener;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class BlogsAdapter extends RecyclerView.Adapter<BlogsAdapter.BlogViewHolder> {

    @NonNull
    private final Context context;
    private List<Blog> blogs = new ArrayList<>();
    private final OnItemClickListener<Blog> onBlogItemClickListener;

    public BlogsAdapter(@NonNull Context context, OnItemClickListener<Blog> onBlogItemClickListener) {
        this.context = context;
        this.onBlogItemClickListener = onBlogItemClickListener;
    }

    @Override
    public BlogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BlogViewHolder(LayoutInflater.from(context).inflate(R.layout.blog_item, parent, false));
    }

    @Override
    public void onBindViewHolder(BlogViewHolder holder, int position) {
        try {
            holder.setBlogItem(blogs.get(position));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return blogs == null ? 0 : blogs.size();
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
        this.notifyDataSetChanged();
    }

    class BlogViewHolder extends RecyclerView.ViewHolder {

        private final TextView blogName;
        private final TextView blogDescription;
        private final TextView blogDate;
        private final View regionItem;

        BlogViewHolder(View regionItem) {
            super(regionItem);
            this.regionItem = regionItem;
            blogName = regionItem.findViewById(R.id.blog_name);
            blogDescription = regionItem.findViewById(R.id.blog_description);
            blogDate = regionItem.findViewById(R.id.blog_date);
        }

        private void setBlogItem(Blog blog) throws ParseException {
            regionItem.setOnClickListener(view -> onBlogItemClickListener.onItemClicked(view, blog));
            blogName.setText(blog.getName());
            blogDescription.setText(blog.getDescription());

            String formattedDate = DateHelper.getFormattedDate(blog.getSubmittedDate());
            blogDate.setText(formattedDate);
        }

    }
}
