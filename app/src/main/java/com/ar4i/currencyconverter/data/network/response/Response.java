package com.ar4i.currencyconverter.data.network.response;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "ValCurs")
public class Response {
    private String date;
    private String name;
    private List<Currency> currencies;

    @Attribute(name = "Date")
    public String getDate() {
        return date;
    }
    @Attribute(name = "Date")
    public void setDate(String date) {
        this.date = date;
    }

    @Attribute(name = "name")
    public String getName() {
        return name;
    }

    @Attribute(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    @ElementList(inline = true, name = "Valute")
    public List<Currency> getCurrencies() {
        return currencies;
    }

    @ElementList(inline = true, name = "Valute")
    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }
}
