package com.ar4i.currencyconverter.domain;

import com.ar4i.currencyconverter.data.models.CurrencyVm;

import java.util.List;

public interface ICurrencyInteractor {
    List<CurrencyVm> getCurrency();

    Double convert(CurrencyVm from, CurrencyVm to);
}
