package com.ar4i.currencyconverter.app.di.component;

import com.ar4i.currencyconverter.app.di.module.PresenterModule;
import com.ar4i.currencyconverter.presentation.converter.view.ConverterActivity;

public class ApplicationComponentImpl implements ApplicationComponent {
    private PresenterModule presenterModule;

    public ApplicationComponentImpl() {
        this.presenterModule = new PresenterModule();
    }

    @Override
    public void inject(ConverterActivity converterActivity) {
        converterActivity.setPresenter(presenterModule.getConverterPresenter());
    }
}
