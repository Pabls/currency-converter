package com.ar4i.currencyconverter.app.di.module;

import com.ar4i.currencyconverter.domain.CurrencyInteractor;

public class InteractorModule {

    private RepositoryModule repositoryModule;


    public InteractorModule() {
        repositoryModule = new RepositoryModule();
    }

    public CurrencyInteractor getCurrencyInteractor() {
        return new CurrencyInteractor(repositoryModule.getCurrencyRepository());
    }
}
