package com.ar4i.currencyconverter.presentation.converter.view;

import android.os.Bundle;

import com.ar4i.currencyconverter.R;
import com.ar4i.currencyconverter.app.App;
import com.ar4i.currencyconverter.presentation.base.view.BaseActivity;
import com.ar4i.currencyconverter.presentation.converter.presenter.ConverterPresenter;

public class ConverterActivity extends BaseActivity implements IConverterView {

    private ConverterPresenter converterPresenter;

    public void setPresenter(ConverterPresenter converterPresenter) {
        this.converterPresenter = converterPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getComponent().inject(this);
        converterPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        converterPresenter.detachView();
        super.onDestroy();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
