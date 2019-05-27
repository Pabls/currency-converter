package com.ar4i.currencyconverter.app.di.module;

import android.content.Context;

import com.ar4i.currencyconverter.data.database.DBHelper;
import com.ar4i.currencyconverter.data.database.dao.CurrencyDao;

public class DataBaseModule {
    private Context context;
    private String name;
    private int version;

    public DataBaseModule(Context context, String name, int version) {
        this.context = context;
        this.name = name;
        this.version = version;
    }

    public CurrencyDao getCurrencyDao(){
        return new CurrencyDao(new DBHelper(context, name, version));
    }
}
