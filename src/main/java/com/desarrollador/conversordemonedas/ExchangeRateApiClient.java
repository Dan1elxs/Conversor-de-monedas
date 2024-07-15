package com.desarrollador.conversordemonedas;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ExchangeRateApiClient {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/397728e928139f2fb8209222/latest/USD";

    public static String getExchangeRatesJson() throws IOException {
        // Establece la URL de la API de tasas de cambio
        URL url = new URL(API_URL);

        // Abre una conexión HTTP con la URL
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET"); // Configura el método de solicitud como GET

        int responseCode = conn.getResponseCode(); // Obtiene el código de respuesta HTTP
        if (responseCode == HttpURLConnection.HTTP_OK) { // Si la respuesta es exitosa (código 200)
            Scanner scanner = new Scanner(conn.getInputStream()); // Lee la respuesta desde el flujo de entrada
            StringBuilder response = new StringBuilder();
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine()); // Lee cada línea de la respuesta y la concatena
            }
            scanner.close(); // Cierra el scanner
            return response.toString(); // Devuelve la respuesta como una cadena JSON
        } else {
            throw new IOException("Error al obtener tasas de cambio. Código de respuesta: " + responseCode);
        }
    }
}
