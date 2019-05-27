package com.ar4i.currencyconverter.data.database.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ar4i.currencyconverter.data.database.DBHelper;
import com.ar4i.currencyconverter.data.database.dto.CurrencyDto;
import com.ar4i.currencyconverter.data.database.table.CurrencyTable;

import java.util.ArrayList;
import java.util.List;

public class CurrencyDao implements ICurrencyDao {

    private DBHelper dBHelper;

    public CurrencyDao(DBHelper dBHelper) {
        this.dBHelper = dBHelper;
    }

    @Override
    public void insertCurrencies(List<CurrencyDto> currencyDtos) {
        if (currencyDtos == null || currencyDtos.isEmpty()) {
            return;
        }

        try {
            SQLiteDatabase db = getDb();
            for (CurrencyDto dto : currencyDtos) {
                db.replace(CurrencyTable.getTableName(), null, toContentValues(dto));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<CurrencyDto> getCurrencies() {
        List<CurrencyDto> currencies = new ArrayList<>();
        Cursor cursor = null;
        try {
            SQLiteDatabase db = getDb();
            cursor = db.rawQuery(CurrencyTable.getCurrencySelectionCommand(), null);
            if (cursor != null && cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    currencies.add(getCurrency(cursor));
                    cursor.moveToNext();
                }
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeCursor(cursor);
            closeConnection();
            return currencies;
        }
    }

    @Override
    public CurrencyDto getCurrencyById(String id) {
        CurrencyDto dto = null;
        Cursor cursor = null;
        try {
            SQLiteDatabase db = getDb();
            cursor = db.rawQuery(CurrencyTable.getCurrencyById(id), null);
            if (cursor != null && cursor.moveToFirst()) {
                dto = getCurrency(cursor);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeCursor(cursor);
            closeConnection();
            return dto;
        }
    }

    private SQLiteDatabase getDb() {
        return dBHelper.getWritableDatabase();
    }

    private ContentValues toContentValues(CurrencyDto dto) {
        return CurrencyTable.toContentValues(
                dto.getId(),
                dto.getCode(),
                dto.getNominal(),
                dto.getName(),
                dto.getValue()
        );
    }

    private void closeConnection() {
        if (dBHelper != null) {
            dBHelper.close();
        }
    }

    private void closeCursor(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    private CurrencyDto getCurrency(Cursor cursor) {
        String id = cursor.getString(cursor.getColumnIndex(CurrencyTable.getId()));
        String code = cursor.getString(cursor.getColumnIndex(CurrencyTable.getCode()));
        int nominal = cursor.getInt(cursor.getColumnIndex(CurrencyTable.getNominal()));
        String name = cursor.getString(cursor.getColumnIndex(CurrencyTable.getName()));
        double value = cursor.getDouble(cursor.getColumnIndex(CurrencyTable.getValue()));
        return new CurrencyDto(id, code, nominal, name, value);
    }
}
