package com.example.blogs.ui.blogs;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blogs.R;
import com.example.blogs.data.model.Blog;
import com.example.blogs.ui.MainActivity;
import com.example.blogs.ui.blog.info.BlogInfoActivity;
import com.example.blogs.ui.common.OnItemClickListener;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class BlogsFragment extends Fragment {

    private BlogsAdapter blogsAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BlogsViewModel blogViewModel = new ViewModelProvider(this, new BlogsViewModelFactory()).get(BlogsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_blogs, container, false);

        ContentLoadingProgressBar progress = root.findViewById(R.id.progress);
        Bundle arguments = this.getArguments();

        String callerActivity = "";
        int categoryId = 0;
        if (arguments != null){
            callerActivity = arguments.getString("CallerActivity");
            categoryId = arguments.getInt("CategoryId");
        }

        RecyclerView blogsRecyclerView = root.findViewById(R.id.blogs_recycler_view);

        OnItemClickListener<Blog> onBlogClickListener = (view, blog) -> {
            Gson gson = new Gson();
            String blogJson = gson.toJson(blog);
            Intent intent = new Intent(getActivity(), BlogInfoActivity.class);
            intent.putExtra("Blog", blogJson);
            intent.putExtra("CallerActivity", getActivity().getClass().getSimpleName());
            startActivity(intent);
        };

        blogsAdapter = new BlogsAdapter(root.getContext(), onBlogClickListener);
        blogsRecyclerView.addItemDecoration(new DividerItemDecoration(root.getContext(), LinearLayout.VERTICAL));
        blogsRecyclerView.setAdapter(blogsAdapter);
        blogsRecyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));


        Snackbar make = Snackbar.make(getActivity().findViewById(android.R.id.content), "No blogs found for this category", BaseTransientBottomBar.LENGTH_INDEFINITE);

        Observer<List<Blog>> blogsObserver = blogs -> {
            if (blogs == null || blogs.size() == 0) {
                make.show();
                blogsAdapter.setBlogs(new ArrayList<>());
            } else {
                make.dismiss();
                blogsAdapter.setBlogs(blogs);
            }
            progress.hide();
        };
        progress.show();
        if (callerActivity.equals(MainActivity.class.getSimpleName())){
            blogViewModel.getBlogsByCategory(categoryId).observe(getViewLifecycleOwner(), blogsObserver);
        } else {
            blogViewModel.getBlogs().observe(getViewLifecycleOwner(), blogsObserver);
        }
        return root;
    }


}
