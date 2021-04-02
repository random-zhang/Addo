package com.zqt.oldfix.addo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.RxBus;
import me.goldze.mvvmhabit.bus.RxSubscriptions;

public class PhotoFixViewModel extends BaseViewModel {
    //订阅者
    private Disposable mSubscription;
    public PhotoFixViewModel(@NonNull Application application) {
        super(application);

    }
    public BindingCommand onFixButtonClicked=new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            showDialog();
        }
    });

    @Override
    public void registerRxBus() {
        mSubscription = RxBus.getDefault().toObservable(String.class)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                });
        //将订阅者加入管理站
        RxSubscriptions.add(mSubscription);
       // RxBus.getDefault().post(mainActivityEvent);
    }

}
