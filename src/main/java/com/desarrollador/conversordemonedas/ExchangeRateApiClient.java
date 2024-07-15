package com.desarrollador.conversordemonedas;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ExchangeRateApiClient {
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/${EXCH_APK}/latest/USD";

    public static String getExchangeRatesJson() throws IOException {
        // Obtener la API key desde la variable de entorno
        String apiKey = System.getenv("EXCH_APK");
        String apiUrl = BASE_URL.replace("${EXCH_APK}", apiKey);

        // Establecer la URL de la API de tasas de cambio
        URL url = new URL(apiUrl);

        // Abrir una conexión HTTP con la URL
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET"); // Configurar el método de solicitud como GET

        int responseCode = conn.getResponseCode(); // Obtener el código de respuesta HTTP
        if (responseCode == HttpURLConnection.HTTP_OK) { // Si la respuesta es exitosa (código 200)
            Scanner scanner = new Scanner(conn.getInputStream()); // Leer la respuesta desde el flujo de entrada
            StringBuilder response = new StringBuilder();
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine()); // Leer cada línea de la respuesta y concatenarla
            }
            scanner.close(); // Cerrar el scanner
            return response.toString(); // Devolver la respuesta como una cadena JSON
        } else {
            throw new IOException("Error al obtener tasas de cambio. Código de respuesta: " + responseCode);
        }
    }
}
