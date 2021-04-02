package com.zqt.oldfix.addo.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zqt.oldfix.addo.R;
import com.zqt.oldfix.addo.databinding.MainActivityBinding;
import com.zqt.oldfix.addo.databinding.PhotoFixActivityBinding;
import com.zqt.oldfix.addo.util.PhotoUtils;
import com.zqt.oldfix.addo.viewmodel.MainViewModel;

import com.zqt.oldfix.addo.BR;
import com.zqt.oldfix.addo.viewmodel.PhotoFixViewModel;

import java.io.File;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.ImageUtils;
import me.goldze.mvvmhabit.utils.Utils;

public class PhotoFixActivity extends BaseActivity<PhotoFixActivityBinding, PhotoFixViewModel> {
    private Uri uri;
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.photo_fix_activity;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void showDialog(String title) {
        // MaterialDialog.Builder builder = MaterialDialogUtils.showBasicDialogNoCancel(getActivity(),"ss","ss");
        showBottomDialog();
    }

    private void showBottomDialog(){
        //1、使用Dialog、设置style
        final Dialog dialog = new Dialog( this,R.style.DialogTheme);
        //2、设置布局
        View view = View.inflate(this,R.layout.buttom_dialog,null);
        dialog.setContentView(view);

        Window window = dialog.getWindow();
        //设置弹出位置
        window.setGravity(Gravity.BOTTOM);
        //设置弹出动画
        window.setWindowAnimations(R.style.main_menu_animStyle);
        //设置对话框大小
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();

        dialog.findViewById(R.id.tv_take_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSDPicture();
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.tv_take_pic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }
    public void getSDPicture(){
        PhotoUtils.apply(this,uri);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Activity.DEFAULT_KEYS_DIALER) {//调用相机
            //在手机相册中显示刚拍摄的图片
            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            mediaScanIntent.setData(uri);

            sendBroadcast(mediaScanIntent);
            //  updatePortrait();//上传到数据库
        }

    }



}
