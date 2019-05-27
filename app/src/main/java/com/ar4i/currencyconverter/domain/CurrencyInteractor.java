package com.ar4i.currencyconverter.domain;

import com.ar4i.currencyconverter.data.models.CurrencyVm;
import com.ar4i.currencyconverter.data.repository.ICurrencyRepository;

import java.util.List;

public class CurrencyInteractor implements ICurrencyInteractor {

    private ICurrencyRepository currencyRepository;

    public CurrencyInteractor(ICurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public List<CurrencyVm> getCurrency() {
        return currencyRepository.getCurrency();
    }

    @Override
    public Double convert(CurrencyVm from, CurrencyVm to) {
        return null;
    }
}
