package com.zqt.oldfix.addo.dialog;

import android.os.Bundle;

import com.zqt.oldfix.addo.BR;
import com.zqt.oldfix.addo.R;

import me.goldze.mvvmhabit.base.BaseActivity;

public class BottmDialog extends BaseActivity {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.buttom_dialog;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}
