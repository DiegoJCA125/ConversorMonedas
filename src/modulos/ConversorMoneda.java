package modulos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMoneda {
    public double obtenerTasaConversion(String monedaOrigen, String monedaDestino){
        Moneda datosMoneda = ingresoUsuario(monedaOrigen);
        return datosMoneda.getConversionRates().get(monedaDestino);
    }

    // metodo para la conversion de una cantidad a otra moneda
    public double convertirMoneda(double cantidad, String monedaOrigen, String monedaDestino){
        double tasaConversion = obtenerTasaConversion(monedaOrigen, monedaDestino);
        return cantidad * tasaConversion;
    }

    //Obtengo los datos de la moneda desde la API
    public Moneda ingresoUsuario(String moneda){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/87240e4873b8669cd031592f/latest/" + moneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();
        HttpResponse<String> response;

        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            Gson gson = new Gson();
            Moneda monedaData = gson.fromJson(responseBody, Moneda.class);

            //revisamos si las tasas de conversion se han inicializado
            if(monedaData == null || monedaData.getConversionRates() == null){
                throw new RuntimeException("No se pudo obtener datos validos para la moneda ingresada");
            }
            return monedaData;
        } catch (Exception e){
            throw new RuntimeException("Error al obtener la moneda " + e.getMessage());
        }
    }
}
