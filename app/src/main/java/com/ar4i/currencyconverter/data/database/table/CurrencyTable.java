package com.ar4i.currencyconverter.data.database.table;

import android.content.ContentValues;

public class CurrencyTable {

    private static final String TABLE_NAME = "currency";

    private static final String ID = "id";
    private static final String CODE = "code";
    private static final String NOMINAL = "nominal";
    private static final String NAME = "name";
    private static final String VALUE = "value";

    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS %s " +
            "( %s TEXT PRIMARY KEY, " +
            "%s TEXT, " +
            "%s NUMBER, " +
            "%s TEXT, " +
            "%s NUMBER " +
            ");";

    private static final String GET_CURRENCY = "SELECT * FROM %s";

    private static final String GET_CURRENCY_BY_ID = "SELECT * FROM %s WHERE %s LIKE %s";

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getId() { return ID; }

    public static String getCode() {
        return CODE;
    }

    public static String getNominal() { return NOMINAL; }

    public static String getName() {
        return NAME;
    }

    public static String getValue() {
        return VALUE;
    }

    public static String getTableCreationCommand() {
        return String.format(CREATE_TABLE, TABLE_NAME, ID, CODE, NOMINAL, NAME, VALUE);
    }

    public static String getCurrencySelectionCommand() {
        return String.format(GET_CURRENCY, TABLE_NAME);
    }

    public static String getCurrencyById(String id) {
        return String.format(GET_CURRENCY_BY_ID, TABLE_NAME, ID, id);
    }

    public static ContentValues toContentValues(String id,
                                                String code,
                                                int nominal,
                                                String name,
                                                double value) {
        ContentValues cv = new ContentValues();
        cv.put(ID, id);
        cv.put(CODE, code);
        cv.put(NOMINAL, nominal);
        cv.put(NAME, name);
        cv.put(VALUE, value);
        return cv;
    }
}
