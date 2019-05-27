package com.ar4i.currencyconverter.data.database.dto;

public class CurrencyDto {
    private String id;
    private String code;
    private int nominal;
    private String name;
    private double value;

    public CurrencyDto(String id, String code, int nominal, String name, double value) {
        this.id = id;
        this.code = code;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public int getNominal() {
        return nominal;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}
