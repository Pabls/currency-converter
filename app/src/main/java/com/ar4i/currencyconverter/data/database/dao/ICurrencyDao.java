package com.ar4i.currencyconverter.data.database.dao;

import com.ar4i.currencyconverter.data.database.dto.CurrencyDto;

import java.util.List;

public interface ICurrencyDao {
    void insertCurrencies(List<CurrencyDto> currencyDtos);

    List<CurrencyDto> getCurrencies();

    CurrencyDto getCurrencyById(String id);
}
