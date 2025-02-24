import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Capturamos el nombre del cliente
        String nombreApellido;

        while (true){
            try {
                System.out.print("Ingrese su nombre y apellido: ");
                nombreApellido = scanner.nextLine().trim();

                if (!nombreApellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
                    throw new IllegalAccessException("⚠ ERROR: El nombre solo debe contener letras y espacios.");
                }
                break;

            }catch(IllegalAccessException e){
                System.out.println(e.getMessage());
            }

        }

        //Seleccion del tipo de jet a alquilar

        int tipoJet ;
        double PrecioHora ;
        while (true){
            try {
                System.out.println("Seleccione el tipo de jet:");
                System.out.println("1. Light Jet ($3,000/hora)");
                System.out.println("2. Super Jet ($4,500/hora)");
                System.out.print("Opcion: ");

                tipoJet = Integer.parseInt(scanner.nextLine());

                if (tipoJet == 1){
                    PrecioHora = 3000;
                    break;
                } else if (tipoJet == 2){
                    PrecioHora = 4500;
                    break;
                } else {
                    System.out.println("⚠ Error: Seleccione una opción válida (1 o 2).");
                }
            }catch(NumberFormatException e){
                System.out.println("⚠ Error: Ingrese un valor válido.");
            }
        }

        //Captura de la cantidad de horas

        int horas;

        while (true){
            try {
                System.out.print("Ingrese la cantidad de horas de alquiler: ");
                horas = Integer.parseInt(scanner.nextLine());

                if (horas > 0){
                    break;
                } else {
                    System.out.println("⚠ Error: La cantidad de horas debe ser mayor a 0.");
                }
            } catch (NumberFormatException e){
                System.out.println("⚠ Error: Ingrese un valor valido.");
            }
        }

        //Calculo para el descuento

        double descuento = 0;

        if (horas >= 4 && horas <= 8){
            descuento = 0.15;
        } else if (horas >= 9 && horas <= 12){
            descuento = 0.20;
        } else if (horas >= 13 && horas <= 16){
            descuento = 0.25;
        } else if (horas >= 17 ){
            descuento = 0.30;
        }

        //Calculamos el monto total

        double subtotal = horas * PrecioHora;
        double descuentoAplicado = subtotal * descuento;
        double total = subtotal - descuentoAplicado;

        //Muestramos la informacion
        System.out.println("\n********** Factura de alquiler **********");
        System.out.println("Nombre: " + nombreApellido);
        System.out.println("Tipo de jet: " + (tipoJet == 1 ? "Light Jet" : "Super Jet"));
        System.out.println("Horas de alquiler: " + horas);
        System.out.println("Precio por hora: $" + PrecioHora);
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento: $" + (descuento * 100) + "%");
        System.out.println("Total: $" + total);

        scanner.close();

    }

}
