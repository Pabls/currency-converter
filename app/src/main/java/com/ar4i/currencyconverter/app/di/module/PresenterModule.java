package com.ar4i.currencyconverter.app.di.module;

import com.ar4i.currencyconverter.presentation.converter.presenter.ConverterPresenter;

public class PresenterModule {
    private InteractorModule interactorModule;

    public PresenterModule() {
        interactorModule = new InteractorModule();
    }

    public ConverterPresenter getConverterPresenter() {
        return new ConverterPresenter(interactorModule.getCurrencyInteractor());
    }
}
