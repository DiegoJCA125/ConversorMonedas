import modulos.ConversorMoneda;
import modulos.Moneda;
import modulos.MonedasAceptadas;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConversorMoneda conversorMoneda = new ConversorMoneda();
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;
        ArrayList<String> resumenConversion = new ArrayList<>();

        System.out.println("************************");
        System.out.println("Bienvenido al conversor de Monedas Alura");
        System.out.println("************************");

        MonedasAceptadas.mostrarMonedasAceptadas();

        while(continuar){
            System.out.println("Por favor ingrese el codigo de la moneda de origen (en mayusculas): ");
            String monedaOrigen = entrada.nextLine();

            //valida la moneda admitida
            if(!MonedasAceptadas.esMonedasAceptadas(monedaOrigen)){
                System.out.println("La moneda ingresada no es admitida.");
                continue;
            }

            //obtengo el objeto moneda
            Moneda monedaData = conversorMoneda.ingresoUsuario(monedaOrigen);

            if(monedaData.getConversionRates() == null){
                System.out.println("No se encontraron tasas de conversion para la moneda ingresada");
                return;
            }

            System.out.println("\nPor favor, ingrese el codigo de la moneda destino (en mayuscula):");
            String monedaDestino = entrada.nextLine();

            if(!MonedasAceptadas.esMonedasAceptadas(monedaDestino)){
                System.out.println("La moneda ingresada no es admitida.");
                continue;
            }

            System.out.println("\nIngrese la cantidad de dinero que desea convertir");
            double cantidad = entrada.nextDouble();

            double cantidadConvertida = conversorMoneda.convertirMoneda(cantidad, monedaOrigen, monedaDestino);
            DecimalFormat formato = new DecimalFormat("#.##");
            String resultadoFormateado = formato.format(cantidadConvertida);

            System.out.println("\n" + cantidad + " " + monedaOrigen + " equivale a: " + resultadoFormateado + " " + monedaDestino);
            entrada.nextLine();

            resumenConversion.add(cantidad + " " + monedaOrigen + " equivale a: " + resultadoFormateado + " " + monedaDestino);

            //Opcion para salir o continuar
            System.out.println("\n ¿Quiere realizar otra conversion? Escribe C para continuar, cualquier otra tecla para salir.");
            String opcion = entrada.nextLine();
            if(!opcion.equalsIgnoreCase("C")){
                continuar = false;
            }
        }

        //Se muestra el resumen al usuario
        System.out.println("\n Resumen de las conversiones realizadas:");
        for(String consulta : resumenConversion){
            System.out.println("- " + consulta);
        }

        System.out.println("\n Gracias por utilizar nuestro conversor de moneda. \n");
        entrada.close();
    }
}
