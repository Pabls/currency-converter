package com.ar4i.currencyconverter.presentation.base.presenter;

public interface IBasePresenter<V> {
    void attachView(V view);

    void detachView();

    V getView();
}
