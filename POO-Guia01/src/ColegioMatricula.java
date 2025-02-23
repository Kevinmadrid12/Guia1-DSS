import java.util.Scanner;

public class ColegioMatricula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Solicitar datos del estudiante
            System.out.print("Ingrese el nombre del estudiante: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Ingrese el apellido del estudiante: ");
            String apellido = scanner.nextLine();
            
            System.out.print("Ingrese la edad del estudiante: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            System.out.print("Tipo de ingreso (Antiguo Ingreso/Nuevo Ingreso): ");
            String tipoIngreso = scanner.nextLine();
            
            // Determinar costo de matrícula según la edad
            double costoMatricula;
            if (edad > 15) {
                costoMatricula = 100;
            } else if (edad > 10) {
                costoMatricula = 125;
            } else {
                costoMatricula = 150;
            }
            
            // Determinar descuento
            double descuento = 0;
            if (tipoIngreso.equalsIgnoreCase("Antiguo Ingreso")) {
                descuento = costoMatricula * 0.25;
            }
            
            // Calcular costo final
            double costoFinal = costoMatricula - descuento;
            
            // Mostrar resultados
            System.out.println("\n===== Información de Matrícula =====");
            System.out.println("Nombre: " + nombre);
            System.out.println("Apellido: " + apellido);
            System.out.println("Valor de la matrícula: $" + costoMatricula);
            System.out.println("Descuento obtenido: $" + descuento);
            System.out.println("Valor final a pagar: $" + costoFinal);
        } finally {
            // Cerrar el scanner
            scanner.close();
        }
    }
}
