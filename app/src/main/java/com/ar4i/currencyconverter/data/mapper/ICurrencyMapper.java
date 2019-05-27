package com.ar4i.currencyconverter.data.mapper;

import java.util.List;

public interface ICurrencyMapper<N, D, V> {
    List<V> formNetworkToVm(List<N> nList);
    List<V> formDbToVm(List<D> dList);
    List<D> formNetworkToDb(List<N> nList);
}
