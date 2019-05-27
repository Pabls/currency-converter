package com.ar4i.currencyconverter.data.repository;

import com.ar4i.currencyconverter.data.models.CurrencyVm;

import java.util.List;

public interface ICurrencyRepository {
    List<CurrencyVm> getCurrency();
}
