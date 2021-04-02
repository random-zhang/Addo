package com.zqt.oldfix.addo.activity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.afollestad.materialdialogs.MaterialDialog;
import com.zqt.oldfix.addo.BR;
import com.zqt.oldfix.addo.fragment.HomeFragment;
import com.zqt.oldfix.addo.fragment.MoreFragment;
import com.zqt.oldfix.addo.R;
import com.zqt.oldfix.addo.fragment.MyFragment;
import com.zqt.oldfix.addo.viewmodel.MainViewModel;
import com.zqt.oldfix.addo.databinding.MainActivityBinding;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.MaterialDialogUtils;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

public class MainActivity extends BaseActivity< MainActivityBinding,MainViewModel> {
    private List<Fragment> mFragments;
    private float posX,curPosX;
    private int index=0;
    private NavigationController navigationController;
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.main_activity;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        initBottomTab();
        //初始化Fragment
        initFragment();

    }
    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new MoreFragment());
        mFragments.add(new MyFragment());
        commitAllowingStateLoss(index);
        binding.mainlayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        posX = event.getX();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        curPosX = event.getX();
                        break;
                    case MotionEvent.ACTION_UP: {
                        if ((curPosX - posX > 0) && (Math.abs(curPosX - posX) > 25)){
                            int i=index;
                            switch (i){
                                case 1:{
                                    index=0;

                                    break;
                                }
                                case 2:{
                                    index=1;
                                    break;
                                }
                            }
                        } else if ((curPosX - posX < 0) && (Math.abs(curPosX-posX) > 25)){
                            int i=index;
                            switch (i){
                                case 0:{
                                    index=1;
                                    break;
                                }
                                case 1:{
                                    index=2;
                                    break;
                                }
                            }
                        }
                        navigationController.setSelect(index);
                        commitAllowingStateLoss(index);
                        break;
                    }
                }
                return true;
            }
        });
    }
    private void initBottomTab() {
        navigationController = binding.pagerBottomTab.material()
                .addItem(R.drawable.home_icon, "首页")
                .addItem(R.drawable.more_icon, "更多操作")
                .addItem(R.drawable.my_icon, "我的")
                .setDefaultColor(ContextCompat.getColor(this, R.color.textColorVice))
                .build();
        //底部按钮的点击事件监听
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                commitAllowingStateLoss(index);
            }
            @Override
            public void onRepeat(int index) {
            }
        });
    }

    private void commitAllowingStateLoss(int position) {
        hideAllFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment currentFragment=mFragments.get(position);
        //getSupportFragmentManager().
        if (currentFragment != null) {
            transaction.show(currentFragment);
            transaction.replace(R.id.frameLayout, currentFragment);
        }
        transaction.commitAllowingStateLoss();
    }

    //隐藏所有Fragment
    private void hideAllFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < mFragments.size(); i++) {
            //Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(i + "");
            Fragment currentFragment = getSupportFragmentManager().findFragmentById(mFragments.get(i).getId());
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
        }
        transaction.commitAllowingStateLoss();
    }

}
