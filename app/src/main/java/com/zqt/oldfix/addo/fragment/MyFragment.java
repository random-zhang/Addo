package com.zqt.oldfix.addo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.zqt.oldfix.addo.BR;
import com.zqt.oldfix.addo.R;
import com.zqt.oldfix.addo.adapter.MyRVAdapter;
import com.zqt.oldfix.addo.databinding.MyFragmentBinding;
import com.zqt.oldfix.addo.viewmodel.MyViewModel;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;


public class MyFragment extends BaseFragment<MyFragmentBinding, MyViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.my_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        //给RecyclerView添加Adpter，请使用自定义的Adapter继承BindingRecyclerViewAdapter，重写onBindBinding方法，里面有你要的Item对应的binding对象。
        // Adapter属于View层的东西, 不建议定义到ViewModel中绑定，以免内存泄漏
       binding.setAdapter(new BindingRecyclerViewAdapter());
    }
}
