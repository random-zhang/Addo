package com.zqt.oldfix.addo.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.databinding.ViewDataBinding;

import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

import static android.content.ContentValues.TAG;

public class MyRVAdapter<T> extends BindingRecyclerViewAdapter<T> {

    @Override
    public ViewDataBinding onCreateBinding(LayoutInflater inflater, @LayoutRes int layoutId, ViewGroup viewGroup) {
        ViewDataBinding binding = super.onCreateBinding(inflater, layoutId, viewGroup);
        Log.d(TAG, "created binding: " + binding);
        return binding;
    }

    @Override
    public void onBindBinding(ViewDataBinding binding, int bindingVariable, @LayoutRes int layoutId, int position, T item) {

        super.onBindBinding(binding, bindingVariable, layoutId, position, item);
        Log.d(TAG, "bound binding: " + binding + " at position: " + position);
    }
}
