package com.zqt.oldfix.addo.viewmodel;

import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;

import com.afollestad.materialdialogs.MaterialDialog;
import com.zqt.oldfix.addo.R;
import com.zqt.oldfix.addo.activity.MainActivity;
import com.zqt.oldfix.addo.activity.PhotoFixActivity;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.MaterialDialogUtils;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;




public class HomeViewModel extends BaseViewModel<BaseModel> {
    public HomeViewModel(@NonNull Application application) {
        super(application);
    }
    public ObservableBoolean isShowDialog = new ObservableBoolean();
    public BindingCommand fixOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(PhotoFixActivity.class);
        }
    });

}
