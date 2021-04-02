package com.zqt.oldfix.addo.util;

import android.Manifest;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;

import com.tbruyelle.rxpermissions2.RxPermissions;


import java.io.File;
import java.io.IOException;
import java.util.Objects;

import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class PhotoUtils {//图片相关类
    public static void apply(BaseActivity context,Uri uri){
        //请求打开相机权限
        RxPermissions rxPermissions = new RxPermissions( context);
        rxPermissions.request(Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            //ToastUtils.showShort("权限已经打开，直接跳入相机");
                            Toast.makeText(context,"权限已经打开，直接跳入相机",Toast.LENGTH_SHORT).show();
                            useCamera(context,uri);

                        } else {
                            //ToastUtils.showShort("权限被拒绝");
                            Toast.makeText(context,"权限被拒绝",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public static void useCamera(BaseActivity context,Uri uri) {//调用相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File storageDir;
        File externalFileRootDir = context.getExternalFilesDir(null);
        do {
            externalFileRootDir = Objects.requireNonNull(externalFileRootDir).getParentFile();
        } while (Objects.requireNonNull(externalFileRootDir).getAbsolutePath().contains("/Android"));

        String saveDir = Objects.requireNonNull(externalFileRootDir).getAbsolutePath();
        String savePath = saveDir + File.separator+ Environment.DIRECTORY_DCIM + File.separator+ "images";
        //String storePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + File.separator + "images";//照片储存的位置
       //Environment.
        storageDir = new File(savePath);
        storageDir.mkdirs();
        File file=null;
        try {
             file = File.createTempFile(System.currentTimeMillis() + "", ".jpg", storageDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
         uri = FileProvider.getUriForFile(context, "com.zqt.oldfix", file);
        //添加权限
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

        Bundle bundle=new Bundle();
        bundle.putString("uri",uri.toString());
        context.startActivityForResult(intent, Activity.DEFAULT_KEYS_DIALER);
    }


}
