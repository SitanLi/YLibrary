package com.jy.baselibrary.base.mvp;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.jy.baselibrary.base.BaseAppcompatDialogFragment;
import com.jy.baselibrary.base.contract.BaseContract;


/**
 * Administrator
 * created at 2019/9/26 15:43
 * TODO:DialogFragment mvp模式基类
 */
public abstract class MvpBaseAppcompatDialogFragment<P extends BaseContract.BasePresenter> extends BaseAppcompatDialogFragment {

    protected P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
        attachView();
        attachMode();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        detachView();
    }

    /**
     * 在子View中初始化Presenter
     *
     * @return
     */
    protected abstract P initPresenter();

    /**
     * 初始化mode
     *
     * @return
     */
    protected abstract BaseContract.BaseModel initModel();


    /**
     * 挂载mode
     */
    private void attachMode() {
        if (mPresenter != null) {
            mPresenter.attachMode(initModel());
        }
    }

    /**
     * 挂载view
     */
    private void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    /**
     * 卸载view
     */
    private void detachView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
