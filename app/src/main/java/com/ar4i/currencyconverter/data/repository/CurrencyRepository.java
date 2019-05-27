package com.ar4i.currencyconverter.data.repository;

import com.ar4i.currencyconverter.data.database.dao.ICurrencyDao;
import com.ar4i.currencyconverter.data.database.dto.CurrencyDto;
import com.ar4i.currencyconverter.data.mapper.ICurrencyMapper;
import com.ar4i.currencyconverter.data.models.CurrencyVm;
import com.ar4i.currencyconverter.data.network.api.Api;
import com.ar4i.currencyconverter.data.network.response.Currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyRepository implements ICurrencyRepository {
    private ICurrencyDao currencyDao;
    private Api api;
    private ICurrencyMapper<Currency, CurrencyDto, CurrencyVm> currencyMapper;

    public CurrencyRepository(ICurrencyDao currencyDao,
                              Api api,
                              ICurrencyMapper<Currency, CurrencyDto, CurrencyVm> currencyMapper) {
        this.currencyDao = currencyDao;
        this.api = api;
        this.currencyMapper = currencyMapper;
    }

    @Override
    public List<CurrencyVm> getCurrency() {
        List<CurrencyVm> currencyVms = new ArrayList<>();
        List<Currency> res = api.getCurrency();
        if (res != null && !res.isEmpty()) {
            saveCurrencyToDb(res);
            currencyVms = currencyMapper.formNetworkToVm(res);
        } else {
            List<CurrencyDto> dtos = getCurrenciesFromDb();
            if (dtos != null && !dtos.isEmpty()) {
                currencyVms = currencyMapper.formDbToVm(dtos);
            }
        }
        return currencyVms;
    }

    private void saveCurrencyToDb(List<Currency> currencies) {
        if (currencyDao != null) {
            List<CurrencyDto> dtos = currencyMapper.formNetworkToDb(currencies);
            currencyDao.insertCurrencies(dtos);
        }
    }

    private List<CurrencyDto> getCurrenciesFromDb() {
        return currencyDao.getCurrencies();
    }
}
