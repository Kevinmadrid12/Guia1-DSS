//Hecho por Daniel Enrique Flores Lino
//Código fuente creado el 23/feb/2025
import javax.swing.JOptionPane;


public class Ejercicio2 {
    public static void main(String[] args) {
        //Declaración de variables
        int peso, distancia, express, vip;
        double subtotalPeso, subtotalDistancia, subTotal, costoExpress, descuentoVIP, precioTotal;
        String tarifaPeso, tarifaDistancia;
        StringBuilder mensaje = new StringBuilder();

        //Input y validación de datos
        JOptionPane.showMessageDialog(null, "ENCOMIENDAS EXPRESS\nHerramienta para calcular costos de envío");
        do {
            try {
                peso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el peso del paquete(kg)"));
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad numérica", "Error", JOptionPane.ERROR_MESSAGE);
                peso = 0;
                continue;
            }
            if (peso < 1) {
                JOptionPane.showMessageDialog(null, "El peso debe ser de al menos 1kg", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (peso < 1);

        do {
            try {
                distancia = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la distancia de envío(km)"));
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad numérica", "Error", JOptionPane.ERROR_MESSAGE);
                distancia = 0;
                continue;
            }
            if (distancia < 1) {
                JOptionPane.showMessageDialog(null, "La distancia debe ser al menos 1km", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (distancia < 1);

        express = JOptionPane.showConfirmDialog(null, "¿El cliente optó por Envío Express?", "Input", JOptionPane.YES_NO_OPTION);
        vip = JOptionPane.showConfirmDialog(null, "¿El cliente tiene tarjeta VIP?", "Input", JOptionPane.YES_NO_OPTION);

        //Cálculo de subtotal de peso
        if (peso <= 4) {
            subtotalPeso = peso * 1.2;
            tarifaPeso = "$1.20 por kg";
        }
        else if (peso <= 10) {
            subtotalPeso = peso * 1.35;
            tarifaPeso = "$1.35 por kg";
        }
        else if (peso <= 20) {
            subtotalPeso = peso * 1.6;
            tarifaPeso = "$1.60 por kg";
        }
        else {
            subtotalPeso = peso * 1.75;
            tarifaPeso = "$1.75 por kg";
        }

        //Cálculo de subtotal de distancia
        if (distancia <= 20) {
            subtotalDistancia = distancia * 0.2;
            tarifaDistancia = "$0.20 por km";
        }
        else if (distancia <= 40) {
            subtotalDistancia = distancia * 0.08;
            tarifaDistancia = "$0.08 por km";
        }
        else if (distancia <= 60) {
            subtotalDistancia = distancia * 0.06;
            tarifaDistancia = "$0.06 por km";
        }
        else {
            subtotalDistancia = distancia * 0.04;
            tarifaDistancia = "$0.04 por km";
        }

        //Cálculo de precio final
        subTotal = subtotalPeso + subtotalDistancia;

        if (express == 0) { //Si el cliente pagó por Express
            costoExpress = subTotal * 0.13;
        }
        else {
            costoExpress = 0;
        }

        if (vip == 0) { //Si el cliente es VIP
            descuentoVIP = subTotal * 0.1;
        }
        else {
            descuentoVIP = 0;
        }

        precioTotal = subTotal + costoExpress - descuentoVIP;

        //Output de datos
        mensaje = new StringBuilder("""
                DATOS DEL PAQUETE
                Peso: %skg
                Tarifa aplicada: %s
                
                DATOS DEL ENVÍO
                Distancia: %skm
                Tarifa aplicada: %s
                
                PRECIO DE ENVÍO
                Subtotal de peso: $%s
                Subtotal de distancia: $%s
                Subtotal general: $%s
                """);
        if (express == 0) {
            mensaje.append("\nCosto por envío express: $").append(costoExpress);
        }
        if (vip == 0) {
            mensaje.append("\nDescuento por tarjeta VIP: $").append(descuentoVIP);
        }
        mensaje.append("\nPrecio total del envío: $").append(precioTotal);

        JOptionPane.showMessageDialog(null, mensaje.toString().formatted(peso, tarifaPeso, distancia,
                tarifaDistancia, subtotalPeso, subtotalDistancia, subTotal));
    }
}
