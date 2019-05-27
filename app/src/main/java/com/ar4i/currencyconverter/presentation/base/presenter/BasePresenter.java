package com.ar4i.currencyconverter.presentation.base.presenter;

import com.ar4i.currencyconverter.presentation.base.view.IBaseView;

public class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public V getView() {
        return this.view;
    }
}
