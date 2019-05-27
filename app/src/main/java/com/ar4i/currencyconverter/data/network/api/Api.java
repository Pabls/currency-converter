package com.ar4i.currencyconverter.data.network.api;

import com.ar4i.currencyconverter.data.network.response.Currency;

import java.util.List;

public interface Api {
    List<Currency> getCurrency();
}
