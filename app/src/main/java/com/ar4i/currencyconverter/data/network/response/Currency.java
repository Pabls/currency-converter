package com.ar4i.currencyconverter.data.network.response;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Valute")
public class Currency {

    private String id;
    private String charCode;
    private String numCode;
    private int nominal;
    private String name;
    private String value;

    @Attribute(name = "ID")
    public void setId(String id) {
        this.id = id;
    }

    @Element(name = "NumCode")
    public void setNumCode(String code) {
        this.numCode = code;
    }

    @Element(name = "CharCode")
    public void setCharCode(String code) {
        this.charCode = code;
    }

    @Element(name = "Nominal")
    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    @Element(name = "Name")
    public void setName(String name) {
        this.name = name;
    }

    @Element(name = "Value")
    public void setValue(String value) {
        this.value = value;
    }

    @Attribute(name = "ID")
    public String getId() {
        return id;
    }

    @Element(name = "NumCode")
    public String getNumCode() {
        return numCode;
    }

    @Element(name = "CharCode")
    public String getCharCode() {
        return charCode;
    }

    @Element(name = "Nominal")
    public int getNominal() {
        return nominal;
    }

    @Element(name = "Name")
    public String getName() {
        return name;
    }

    @Element(name = "Value")
    public String getValue() {
        return value;
    }
}
