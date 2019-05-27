package com.ar4i.currencyconverter.app.di.module;

import com.ar4i.currencyconverter.data.mapper.CurrencyMapper;

public class MapperModule {

    public CurrencyMapper getCurrencyMapper() {
        return new CurrencyMapper();
    }
}
