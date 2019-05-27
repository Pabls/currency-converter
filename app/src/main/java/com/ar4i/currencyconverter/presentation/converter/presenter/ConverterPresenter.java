package com.ar4i.currencyconverter.presentation.converter.presenter;

import android.util.Log;

import com.ar4i.currencyconverter.data.models.CurrencyVm;
import com.ar4i.currencyconverter.domain.ICurrencyInteractor;
import com.ar4i.currencyconverter.presentation.base.presenter.BasePresenter;
import com.ar4i.currencyconverter.presentation.converter.view.IConverterView;

import java.util.List;

public class ConverterPresenter extends BasePresenter<IConverterView> {

    private ICurrencyInteractor iCurrencyInteractor;

    public ConverterPresenter(ICurrencyInteractor ICurrencyInteractor) {
        iCurrencyInteractor = ICurrencyInteractor;
    }

    @Override
    public void attachView(IConverterView view) {
        super.attachView(view);
        getCurrency();
    }

    private void getCurrency() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                List<CurrencyVm> currency = iCurrencyInteractor.getCurrency();
                if (currency != null && !currency.isEmpty()) {
                    Log.d("currency ", String.valueOf(currency.size()));
                }
            }
        });
        thread.start();
    }
}
