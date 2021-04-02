package com.zqt.oldfix.addo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import com.zqt.oldfix.addo.BR;
import com.zqt.oldfix.addo.R;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.MultiItemViewModel;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

public class MyViewModel  extends BaseViewModel {
    public MyViewModel(@NonNull Application application) {
        super(application);
        MyItemViewModel item = new MyItemViewModel(this);
        MyItemViewModel item2 = new MyItemViewModel(this);
        observableList.add(item);
        observableList.add(item2);
    }
    //给RecyclerView添加ObservableList
    public ObservableList<MyItemViewModel> observableList = new ObservableArrayList<>();
    //RecyclerView多布局添加ItemBinding
    public final ItemBinding<MyItemViewModel> itemBinding = ItemBinding.of(BR.viewModel, R.layout.item_my);

}
