//Hecho por Daniel Enrique Flores Lino
import javax.swing.JOptionPane;
import java.time.Year;
import java.util.Date;

public class Ejercicio1 {
    public static void main(String[] args) {
        //Declaración de variables
        String tipo, marca, origen;
        int añoFab, percentImpuesto, seleccion, year = Year.now().getValue();
        double costoInicial, costoImpuesto, costoFlete, matricula, totalImportacion, costoFinal;
        String[] opcionesTipo = {"Sedán", "Pickup", "Microbús", "Motocicleta"};
        String[] opcionesOrigen = {"Estados Unidos", "China"};

        //Input y validación de datos
        JOptionPane.showMessageDialog(null, "Importaciones NEW CARS\nCalculadora de costo de importación");
        seleccion = JOptionPane.showOptionDialog(null, "Seleccione el tipo de vehículo", "Tipo",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesTipo, opcionesTipo[0]);
        switch (seleccion) {
            case 0 -> tipo = "Sedán";
            case 1 -> tipo = "Pickup";
            case 2 -> tipo = "Microbús";
            case 3 -> tipo = "Motocicleta";
            default -> tipo = "N/A";
        }

        marca = JOptionPane.showInputDialog(null,
                "Ingrese la marca del vehículo", "Marca", JOptionPane.QUESTION_MESSAGE);
        while (marca.isEmpty()) {
            marca = JOptionPane.showInputDialog(null,
                    "Ingrese la marca del vehículo\nError: este campo no puede estar vacío", "Marca", JOptionPane.ERROR_MESSAGE);
        }

        costoInicial = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el costo del vehículo ($)",
                "Costo inicial", JOptionPane.QUESTION_MESSAGE));

        seleccion = JOptionPane.showOptionDialog(null, "Seleccione el origen del vehículo", "Origen",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesOrigen, opcionesOrigen[0]);
        origen = (seleccion == 0) ? "Estados Unidos" : "China";

        do {
            try {
                añoFab = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Ingrese el año de fabricación del vehículo", "Año", JOptionPane.QUESTION_MESSAGE));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un año", "Error", JOptionPane.ERROR_MESSAGE);
                añoFab = 0;
                continue;
            }
            if (year - añoFab > 15) {
                JOptionPane.showMessageDialog(null, "No se aceptan vehículos mayores a 15 años de fabricación",
                        "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            if (añoFab > year) {
                JOptionPane.showMessageDialog(null, "El año de fabricación no puede ser mayor a 2025",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (añoFab > year || year - añoFab > 15);

        //Cálculo de impuesto
        if (year - añoFab >= 10 && year - añoFab <= 15) {
            percentImpuesto = 16;
        }
        else if (year - añoFab >= 5 && year - añoFab <= 9) {
            percentImpuesto = 13;
        }
        else {
            percentImpuesto = 11;
        }

        //Cálculo de flete
        if (origen.equals("China")) {
            switch (tipo) {
                case "Sedán" -> costoFlete = 1700;
                case "Pickup" -> costoFlete = 1900;
                case "Microbús" -> costoFlete = 2400;
                case "Motocicleta" -> costoFlete = 1300;
                default -> costoFlete = 0;
            }
        }
        else {
            switch (tipo) {
                case "Sedán" -> costoFlete = 1200;
                case "Pickup" -> costoFlete = 1500;
                case "Microbús" -> costoFlete = 1700;
                case "Motocicleta" -> costoFlete = 900;
                default -> costoFlete = 0;
            }
        }

        //Cálculo de matrícula
        if (añoFab >= 2020 && añoFab <= 2025) {
            matricula = 11.99;
        }
        else if (añoFab >= 2016 && añoFab <= 2019) {
            matricula = 13.99;
        }
        else {
            matricula = 15.99;
        }

        //Cálculo de total de importación
        costoImpuesto = costoInicial * percentImpuesto / 100;
        totalImportacion = costoImpuesto + costoFlete + matricula;
        costoFinal = costoInicial + costoImpuesto + costoFlete + matricula;

        //Output de datos
        JOptionPane.showMessageDialog(null, ("""
                        DATOS DEL VEHÍCULO
                        Tipo de vehículo: %s
                        Marca: %s
                        Año de fabricación: %d
                        Costo inicial: $%s
                        
                        DATOS DE IMPORTACIÓN
                        Impuesto: %d%% ($%s)
                        Flete: $%s (desde %s)
                        Matrícula inicial: $%s
                        Total de imporación: $%s
                        Costo final: $%s
                        """).formatted(tipo, marca, añoFab, costoInicial, percentImpuesto,
                        costoImpuesto, costoFlete, origen, matricula, totalImportacion, costoFinal));
    }
}
