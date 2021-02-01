package com.example.blogs.ui.common;

import android.view.View;

public interface OnItemClickListener<T> {
    void onItemClicked(View view, T data);
}