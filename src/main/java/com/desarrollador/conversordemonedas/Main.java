package com.desarrollador.conversordemonedas;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            CurrencyConverter converter = new CurrencyConverter();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Bienvenido al Conversor de Monedas");
            System.out.println("Tasas de cambio disponibles:");
            System.out.println(converter.getExchangeRates());

            System.out.println("Ingrese el monto a convertir:");
            double amount = scanner.nextDouble();

            System.out.println("Ingrese la moneda de origen (ej. USD):");
            String fromCurrency = scanner.next();

            System.out.println("Ingrese la moneda de destino (ej. EUR):");
            String toCurrency = scanner.next();

            double convertedAmount = converter.convertCurrency(amount, fromCurrency, toCurrency);
            System.out.printf("%.2f %s = %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);

            scanner.close();
        } catch (IOException e) {
            System.err.println("Error al obtener las tasas de cambio desde la API: " + e.getMessage());
        }
    }
}
