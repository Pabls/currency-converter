package com.ar4i.currencyconverter.data.mapper;

import com.ar4i.currencyconverter.data.database.dto.CurrencyDto;
import com.ar4i.currencyconverter.data.models.CurrencyVm;
import com.ar4i.currencyconverter.data.network.response.Currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyMapper implements ICurrencyMapper<Currency, CurrencyDto, CurrencyVm> {

    @Override
    public List<CurrencyVm> formNetworkToVm(List<Currency> currencies) {
        List<CurrencyVm> vms = new ArrayList<>();
        if (currencies != null && !currencies.isEmpty()) {
            for (Currency currency : currencies) {
                vms.add(getCurrencyVm(currency.getId(),
                        currency.getCharCode(),
                        currency.getNominal(),
                        currency.getName(),
                        toDouble(currency.getValue())));
            }
        }
        return vms;
    }

    @Override
    public List<CurrencyVm> formDbToVm(List<CurrencyDto> currencyDtos) {
        List<CurrencyVm> vms = new ArrayList<>();
        if (currencyDtos != null && !currencyDtos.isEmpty()) {
            for (CurrencyDto currency : currencyDtos) {
                vms.add(getCurrencyVm(currency.getId(),
                        currency.getCode(),
                        currency.getNominal(),
                        currency.getName(),
                        currency.getValue()));
            }
        }
        return vms;
    }

    @Override
    public List<CurrencyDto> formNetworkToDb(List<Currency> currencies) {
        List<CurrencyDto> dtos = new ArrayList<>();
        if (currencies != null && !currencies.isEmpty()) {
            for (Currency currency : currencies) {
                dtos.add(new CurrencyDto(currency.getId(),
                        currency.getCharCode(),
                        currency.getNominal(),
                        currency.getName(),
                        toDouble(currency.getValue())));
            }
        }
        return dtos;
    }

    private CurrencyVm getCurrencyVm(String id, String code, int nominal, String name, double value) {
        return new CurrencyVm(id, code, nominal, name, value);
    }

    private double toDouble(String value){
        return Double.valueOf(value.replace(",", "."));
    }
}
