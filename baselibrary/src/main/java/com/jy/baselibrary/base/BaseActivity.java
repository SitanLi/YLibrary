package com.jy.baselibrary.base;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jy.baselibrary.base.contract.BaseContract;
import com.jy.baselibrary.helper.LoadSirHelper;
import com.jy.baselibrary.utils.ToastUtils;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.components.RxActivity;

import org.jetbrains.annotations.NotNull;


/**
 * Administrator
 * created at 2018/11/21 11:24
 * TODO:activity基类
 */
public abstract class BaseActivity extends RxActivity implements BaseContract.BaseView {

    private LoadSirHelper loadSirHelper = new LoadSirHelper();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(initLayoutID());
        initUI(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ToastUtils.cancelToast();
    }

    /**
     * 初始化布局ID
     */
    protected abstract int initLayoutID();

    /**
     * 初始化UI
     */
    protected abstract void initUI(@Nullable Bundle savedInstanceState);


    @NonNull
    @Override
    public LifecycleProvider getLifecycleProvider() {
        return this;
    }

    @Override
    public void showPopWindowLoading(boolean flag) {
        loadSirHelper.showPopWindowLoading(this, flag);
    }

    @Override
    public void showLoading(@NotNull Object target, boolean flag) {
        loadSirHelper.showLoading(target, flag);
    }
}
