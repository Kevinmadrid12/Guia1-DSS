import java.util.Scanner;

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

            // Solicitar datos del empleado
            System.out.print("Ingrese el nombre del empleado: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el salario del empleado: ");
            double salario = scanner.nextDouble();
            scanner.nextLine();  // Consumir el salto de línea

            System.out.print("Ingrese el departamento (Gerencia, Auditoria, Tecnologia, Contabilidad): ");
            String departamento = scanner.nextLine();

            System.out.print("Ingrese las horas realizadas en el mes (máximo 20 horas extras): ");
            int horasExtras = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            // Validar que las horas extras no excedan las 20 horas
            if (horasExtras > 20) {
                System.out.println("¡Error! El máximo de horas extras es 20.");
                continue;  // Salir de este ciclo y pasar al siguiente empleado
            }

            // Determinar el bono por hora según el departamento
            double bonoPorHora = 0;
            switch (departamento.toLowerCase()) {
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
                default:
                    System.out.println("¡Error! Departamento no válido.");
                    continue;
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
