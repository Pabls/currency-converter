package com.ar4i.currencyconverter.app;

import android.app.Application;
import android.content.Context;

import com.ar4i.currencyconverter.app.di.component.ApplicationComponent;
import com.ar4i.currencyconverter.app.di.component.ApplicationComponentImpl;

public class App extends Application {
    private static Context context;
    private static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        component = new ApplicationComponentImpl();
    }

    public static Context getContext() {
        return context;
    }

    public static ApplicationComponent getComponent() {
        return component;
    }
}
