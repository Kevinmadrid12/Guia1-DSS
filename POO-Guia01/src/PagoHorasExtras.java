import java.util.Scanner;

//Kevin Humberto MMadridd Patzan
//27/02/2025 (actualizado)

public class PagoHorasExtras {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el número de empleados
        System.out.print("Ingrese el número de empleados: ");
        int numEmpleados = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea

        // Definir el bono por hora para cada departamento
        double bonoGerencia = 3.50;
        double bonoAuditoria = 1.75;
        double bonoTecnologia = 2.25;
        double bonoContabilidad = 2.00;

        // Procesar la información de cada empleado
        for (int i = 0; i < numEmpleados; i++) {
            System.out.println("\nEmpleado #" + (i + 1));

            // Solicitar y validar el nombre del empleado
            String nombre = "";
            while (nombre.trim().isEmpty() || !nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+")) {
                System.out.print("Ingrese el nombre del empleado (solo letras y espacios): ");
                nombre = scanner.nextLine();
                if (nombre.trim().isEmpty()) {
                    System.out.println("¡Error! El nombre no puede estar vacío.");
                } else if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+")) {
                    System.out.println("¡Error! El nombre solo puede contener letras y espacios.");
                }
            }

            // Validar que el salario sea un número positivo
            double salario = -1;
            while (salario < 0) {
                System.out.print("Ingrese el salario del empleado (debe ser un número positivo): ");
                if (scanner.hasNextDouble()) {
                    salario = scanner.nextDouble();
                    if (salario < 0) {
                        System.out.println("¡Error! El salario debe ser un número positivo.");
                    }
                } else {
                    System.out.println("¡Error! Debe ingresar un número válido.");
                    scanner.next();  // Limpiar el buffer del scanner
                }
                scanner.nextLine();  // Consumir el salto de línea
            }

            // Validar que el departamento sea uno de los permitidos
            String departamento = "";
            while (true) {
                System.out.print("Ingrese el departamento (Gerencia, Auditoria, Tecnologia, Contabilidad): ");
                departamento = scanner.nextLine().toLowerCase();
                if (departamento.equals("gerencia") || departamento.equals("auditoria") || 
                    departamento.equals("tecnologia") || departamento.equals("contabilidad")) {
                    break;
                } else {
                    System.out.println("¡Error! Departamento no válido.");
                }
            }

            // Validar que las horas extras sean un número entero positivo y no excedan las 20 horas
            int horasExtras = -1;
            while (horasExtras < 0 || horasExtras > 20) {
                System.out.print("Ingrese las horas realizadas en el mes (máximo 20 horas extras): ");
                if (scanner.hasNextInt()) {
                    horasExtras = scanner.nextInt();
                    if (horasExtras < 0 || horasExtras > 20) {
                        System.out.println("¡Error! Las horas extras deben estar entre 0 y 20.");
                    }
                } else {
                    System.out.println("¡Error! Debe ingresar un número entero válido.");
                    scanner.next();  // Limpiar el buffer del scanner
                }
                scanner.nextLine();  // Consumir el salto de línea
            }

            // Determinar el bono por hora según el departamento
            double bonoPorHora = 0;
            switch (departamento) {
                case "gerencia":
                    bonoPorHora = bonoGerencia;
                    break;
                case "auditoria":
                    bonoPorHora = bonoAuditoria;
                    break;
                case "tecnologia":
                    bonoPorHora = bonoTecnologia;
                    break;
                case "contabilidad":
                    bonoPorHora = bonoContabilidad;
                    break;
            }

            // Calcular el pago de horas extras
            double pagoHorasExtras = (salario / 30) * horasExtras + bonoPorHora * horasExtras;

            // Mostrar los resultados
            System.out.println("\n===== Resultados del Empleado =====");
            System.out.println("Nombre: " + nombre);
            System.out.println("Salario: $" + salario);
            System.out.println("Departamento: " + departamento);
            System.out.println("Horas realizadas en el mes: " + horasExtras);
            System.out.println("Pago total de horas extras: $" + pagoHorasExtras);
        }

        scanner.close();
    }
}