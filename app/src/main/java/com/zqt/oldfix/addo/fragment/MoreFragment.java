package com.zqt.oldfix.addo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.zqt.oldfix.addo.BR;
import com.zqt.oldfix.addo.R;
import com.zqt.oldfix.addo.viewmodel.MainViewModel;
import com.zqt.oldfix.addo.databinding.MoreFragmentBinding;
import com.zqt.oldfix.addo.viewmodel.MoreFragmentViewModel;

import me.goldze.mvvmhabit.base.BaseFragment;


public class MoreFragment extends BaseFragment< MoreFragmentBinding, MoreFragmentViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.more_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}
