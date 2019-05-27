package com.ar4i.currencyconverter.app.di.module;

import com.ar4i.currencyconverter.BuildConfig;
import com.ar4i.currencyconverter.app.App;
import com.ar4i.currencyconverter.data.repository.CurrencyRepository;

public class RepositoryModule {
    private NetworkModule networkModule;
    private DataBaseModule dataBaseModule;
    private MapperModule mapperModule;

    public RepositoryModule() {
        this.networkModule = new NetworkModule(BuildConfig.CBR_URL);
        this.dataBaseModule = new DataBaseModule(App.getContext(),
                                                 BuildConfig.DB_NAME,
                                                 BuildConfig.DB_VERSION);
        this.mapperModule = new MapperModule();
    }

    public CurrencyRepository getCurrencyRepository() {
        return new CurrencyRepository(dataBaseModule.getCurrencyDao(),
                networkModule.getApi(),
                mapperModule.getCurrencyMapper());
    }
}
