package com.example.blogs.ui.blog.info;

import android.content.Intent;
import android.os.Bundle;

import com.example.blogs.data.helper.DateHelper;
import com.example.blogs.data.model.Blog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.TextView;
import android.widget.Toast;

import com.example.blogs.R;
import com.google.gson.Gson;

public class BlogInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        String blogJson = intent.getStringExtra("Blog");

        Blog blog = new Gson().fromJson(blogJson, Blog.class);

        if (blog == null){
            Toast.makeText(this, "Invalid blog", Toast.LENGTH_LONG).show();
            return;
        }

        TextView blogName = findViewById(R.id.blog_name);
        TextView blogDescription = findViewById(R.id.blog_description);
        TextView blogUrl = findViewById(R.id.blog_url);
        TextView blogRss = findViewById(R.id.blog_rss);
        TextView blogDate = findViewById(R.id.blog_date);

        blogName.setText(blog.getName());
        blogDescription.setText(blog.getDescription());
        blogUrl.setText(blog.getUrl());
        blogRss.setText(blog.getRssFeed());
        blogDate.setText(DateHelper.getFormattedDate(blog.getSubmittedDate()));

    }
}