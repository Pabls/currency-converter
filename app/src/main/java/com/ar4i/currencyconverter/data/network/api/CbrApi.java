package com.ar4i.currencyconverter.data.network.api;

import com.ar4i.currencyconverter.data.network.response.Currency;
import com.ar4i.currencyconverter.data.network.response.Response;

import org.simpleframework.xml.core.Persister;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CbrApi implements Api {

    private String apiUrl;

    public CbrApi(String url) {
        this.apiUrl = url;
    }

    @Override
    public List<Currency> getCurrency() {
        URL url;
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        List<Currency> currencies = new ArrayList<>();
        try {
            url = new URL(apiUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            if (inputStream == null) {
                return currencies;
            }

            reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("windows-1251")));

            StringBuffer buffer = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            if (buffer.length() == 0) {
                return currencies;
            }

            Reader stringReader = new StringReader(buffer.toString());
            Persister serializer = new Persister();
            Response response = null;
            try {
                response = serializer.read(Response.class, stringReader);
            } catch (Exception ex) {

            } finally {
                if (response != null)
                    currencies = response.getCurrencies();
            }
        } catch (Exception e) {
            return currencies;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    return currencies;
                }
            }
            return currencies;
        }
    }
}
