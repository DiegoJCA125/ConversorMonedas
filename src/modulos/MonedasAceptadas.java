package modulos;

import java.util.HashSet;
import java.util.Set;

public class MonedasAceptadas {
    private static Set<String> monedasAceptadas;

    static{
        monedasAceptadas = new HashSet<>();
        monedasAceptadas.add("USD");
        monedasAceptadas.add("EUR");
        monedasAceptadas.add("GBP");
        monedasAceptadas.add("COP");
        monedasAceptadas.add("ARS");
        monedasAceptadas.add("PEN");
        monedasAceptadas.add("JPY");
        monedasAceptadas.add("MXN");
        monedasAceptadas.add("CNY");
        monedasAceptadas.add("BOB");
    }

    public static boolean esMonedasAceptadas(String moneda){
        return monedasAceptadas.contains(moneda);
    }

    public static String getNombreMonedas (String codigoMoneda){
        return switch (codigoMoneda) {
            case "USD" -> "USD = Dolar Estadounidense";
            case "EUR" -> "EUR = Euro";
            case "GBP" -> "GBP = Libra Esterlina";
            case "COP" -> "COP = Peso Colombiano";
            case "ARS" -> "ARS = Peso Argentino";
            case "PEN" -> "PEN = Sol Peruano";
            case "JPY" -> "JPY = Yen Japones";
            case "MXN" -> "MXN = Peso Mexicano";
            case "CNY" -> "CNY = Yuan Chino";
            case "BOB" -> "BOB = Boliviano";
            default -> "Desconocido";
        };
    }

    public static void mostrarMonedasAceptadas(){
        System.out.println("Monedas aceptas para la conversion: ");
        int index = 1;
        for (String moneda : monedasAceptadas){
            System.out.println(index + " " + getNombreMonedas(moneda));
            index++;
        }
    }
}
