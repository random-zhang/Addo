package com.zqt.oldfix.addo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import com.zqt.oldfix.addo.BR;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.MultiItemViewModel;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;


/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
public class MainViewModel extends BaseViewModel {

    public SingleLiveEvent<String> itemClickEvent = new SingleLiveEvent<>();
    public MainViewModel(@NonNull Application application) {
        super(application);
    }

}
