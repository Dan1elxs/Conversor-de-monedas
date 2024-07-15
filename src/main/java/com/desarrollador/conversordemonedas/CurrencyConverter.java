package com.desarrollador.conversordemonedas;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Map;

public class CurrencyConverter {
    private Map<String, Double> exchangeRates;

    public CurrencyConverter() throws IOException {
        String jsonResponse = ExchangeRateApiClient.getExchangeRatesJson();
        Gson gson = new Gson();
        ExchangeRateApiResponse response = gson.fromJson(jsonResponse, ExchangeRateApiResponse.class);
        this.exchangeRates = response.getConversion_rates();
    }

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        double fromRate = exchangeRates.get(fromCurrency.toUpperCase());
        double toRate = exchangeRates.get(toCurrency.toUpperCase());

        return (amount / fromRate) * toRate;
    }

    public Map<String, Double> getExchangeRates() {
        return exchangeRates;
    }
}
