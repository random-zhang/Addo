package com.zqt.oldfix.addo.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.Nullable;

import com.afollestad.materialdialogs.MaterialDialog;
import com.zqt.oldfix.addo.BR;
import com.zqt.oldfix.addo.R;
import com.zqt.oldfix.addo.databinding.HomeFragmentBinding;
import com.zqt.oldfix.addo.viewmodel.HomeViewModel;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.utils.MaterialDialogUtils;

public class HomeFragment extends  BaseFragment<HomeFragmentBinding, HomeViewModel> {


    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.home_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
    @Override
    public void initData() {
        super.initData();
    }


}
