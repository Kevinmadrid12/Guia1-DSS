import java.util.Scanner;

//Kevin Humberto MMadridd Patzan
//27/02/2025 (actualizado)

public class ColegioMatricula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Solicitar y validar el nombre del estudiante
            String nombre = "";
            while (nombre.trim().isEmpty() || !nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+")) {
                System.out.print("Ingrese el nombre del estudiante (solo letras y espacios): ");
                nombre = scanner.nextLine();
                if (nombre.trim().isEmpty()) {
                    System.out.println("¡Error! El nombre no puede estar vacío.");
                } else if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+")) {
                    System.out.println("¡Error! El nombre solo puede contener letras y espacios.");
                }
            }

            // Solicitar y validar el apellido del estudiante
            String apellido = "";
            while (apellido.trim().isEmpty() || !apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+")) {
                System.out.print("Ingrese el apellido del estudiante (solo letras y espacios): ");
                apellido = scanner.nextLine();
                if (apellido.trim().isEmpty()) {
                    System.out.println("¡Error! El apellido no puede estar vacío.");
                } else if (!apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+")) {
                    System.out.println("¡Error! El apellido solo puede contener letras y espacios.");
                }
            }

            // Solicitar y validar la edad del estudiante
            int edad = -1;
            while (edad < 0) {
                System.out.print("Ingrese la edad del estudiante (debe ser un número positivo): ");
                if (scanner.hasNextInt()) {
                    edad = scanner.nextInt();
                    if (edad < 0) {
                        System.out.println("¡Error! La edad debe ser un número positivo.");
                    }
                } else {
                    System.out.println("¡Error! Debe ingresar un número válido.");
                    scanner.next();  // Limpiar el buffer del scanner
                }
                scanner.nextLine();  // Consumir el salto de línea
            }

            // Solicitar y validar el tipo de ingreso
            String tipoIngreso = "";
            while (!tipoIngreso.equalsIgnoreCase("Antiguo Ingreso") && !tipoIngreso.equalsIgnoreCase("Nuevo Ingreso")) {
                System.out.print("Tipo de ingreso (Antiguo Ingreso/Nuevo Ingreso): ");
                tipoIngreso = scanner.nextLine();
                if (!tipoIngreso.equalsIgnoreCase("Antiguo Ingreso") && !tipoIngreso.equalsIgnoreCase("Nuevo Ingreso")) {
                    System.out.println("¡Error! Tipo de ingreso no válido. Debe ser 'Antiguo Ingreso' o 'Nuevo Ingreso'.");
                }
            }

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