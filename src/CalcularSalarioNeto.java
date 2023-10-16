public class CalcularSalarioNeto{
    public static double calcularSalarioNeto(String nombre, String categoria, int anios, double salarioBase) {
        // imprimir datos

        System.out.println("\n".repeat(20));
        System.out.println("NOMBRE: " + nombre);
        System.out.println("_".repeat(20));
        System.out.println("SALARIO BASE: " + salarioBase);

        // calcular bono
        double bono = calcularBono(anios, salarioBase);

        System.out.println("BONO: " + bono);
        System.out.println("_".repeat(20));
        System.out.println("SUBTOTAL: " + (salarioBase + bono));
        System.out.println("_".repeat(20));
        System.out.println("DEDUCCIONES");

        // calcular seguro social
        double seguroSocial = calcularSeguroSocial(salarioBase);

        System.out.println("Seguro Social: " + seguroSocial);

        // calcular seguro educativo
        double seguroEducativo = calcularSeguroEducativo(salarioBase);

        System.out.println("Seguro Educativo: " + seguroEducativo);

        // calcular impuestos
        double impuestos = calcularImpuestoSobreLaRenta(salarioBase);

        System.out.println("Impuesto Sobre la Renta: " + impuestos);

        // calcular respuesta (salario neto)
        double salarioNeto = (salarioBase + bono) - seguroSocial - seguroEducativo - impuestos;

        // retornar respuesta
        return salarioNeto;
    }

    private static double calcularBono(int anios, double salarioBase) {
        if(anios > 5) {
            // si empleado tiene más de 5 años, definir bono (5% del salario base)
            return salarioBase * 0.05;
        } else {
            // de lo contrario, no tiene bono xd
            return 0;
        }
    }

    private static double calcularSeguroSocial(double salarioBase) {
        // calcula seguro social (9.75% del salario base)
        return salarioBase * 0.0975;
    }

    private static double calcularSeguroEducativo(double salarioBase) {
        // calcula seguro educativo (1.25% del salario base)
        return salarioBase * 0.0125;
    }

    private static double calcularImpuestoSobreLaRenta(double salarioBase) {
        // definir salario anual (24 veces el salario base)
        double salarioAnual = salarioBase * 24;
        if(salarioAnual <= 11000) {
            // no hay impuesto sobre renta si salario anual es menos de 11000
            return 0;
        } else if(salarioAnual > 11000 && salarioAnual<=50000) {
            // para salario anual desde 11_001 hasta 50_000...
            return ((salarioAnual - 11000) * 0.15)/24;
        } else {
            // para salario anual mayor a 50_000...
            return ((salarioAnual - 50000) * 0.25)/24;
        }
    }
}

