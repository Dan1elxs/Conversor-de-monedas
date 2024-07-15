# Conversor de Monedas

Este proyecto es un conversor de monedas que utiliza la API de ExchangeRate para obtener las tasas de cambio y permite a los usuarios convertir entre diferentes monedas.

## Características

- Obtención de tasas de cambio en tiempo real utilizando la API de ExchangeRate.
- Conversión de cantidades entre diferentes monedas.
- Interfaz de línea de comandos para interacción fácil con el usuario.

## Requisitos

- Java 11 o superior
- Maven
- Conexión a Internet para acceder a la API de ExchangeRate

## Configuración

1. Clona este repositorio:
    ```bash
    git clone https://github.com/Dan1elxs/Conversor-de-monedas.git
    cd Conversor-de-monedas
    ```

2. Asegúrate de tener Maven instalado y configurado en tu sistema. Luego, ejecuta el siguiente comando para descargar las dependencias:
    ```bash
    mvn clean install
    ```

3. Configura tu clave de API de ExchangeRate en el código (si es necesario).

## Uso

1. Ejecuta el programa:
    ```bash
    mvn exec:java -Dexec.mainClass="com.desarrollador.conversordemonedas.Main"
    ```

2. Sigue las instrucciones en la consola para convertir monedas.

## Estructura del Proyecto

- `src/main/java/com/desarrollador/conversordemonedas/`: Contiene las clases principales del proyecto.
    - `CurrencyConverter.java`: Clase que maneja la lógica de conversión de monedas.
    - `ExchangeRateApiClient.java`: Clase que maneja las solicitudes HTTP a la API de ExchangeRate.
    - `ExchangeRateApiResponse.java`: Clase que representa la respuesta de la API de ExchangeRate.
    - `Main.java`: Punto de entrada del programa.

## Contribución

Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT. Para más detalles, consulta el archivo `LICENSE`.
