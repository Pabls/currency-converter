package com.ar4i.currencyconverter.app.di.module;

import com.ar4i.currencyconverter.data.network.api.CbrApi;

public class NetworkModule {
    private String url;

    public NetworkModule(String url) {
        this.url = url;
    }

    public CbrApi getApi() {
        return new CbrApi(url);
    }
}
