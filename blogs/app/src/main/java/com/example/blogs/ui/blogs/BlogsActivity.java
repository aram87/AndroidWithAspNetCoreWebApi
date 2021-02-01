package com.example.blogs.ui.blogs;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.example.blogs.R;
import com.example.blogs.data.model.Category;
import com.google.gson.Gson;

public class BlogsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogs);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String categoryJson = intent.getStringExtra("Category");
        Category category = new Gson().fromJson(categoryJson, Category.class);

        setTitle(category.getName());
        String callerActivity = intent.getStringExtra("CallerActivity");

        BlogsFragment fragment = new BlogsFragment();
        Bundle args = new Bundle();
        args.putInt("CategoryId", category.getId());
        args.putString("CallerActivity", callerActivity);

        if (savedInstanceState == null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            fragment.setArguments(args);
            ft.replace(R.id.blogs_fragment_container, fragment);
            ft.commit();
        }
    }
}