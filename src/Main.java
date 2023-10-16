import java.io.IOException;
// Clase Principal (Main)
public class Main {
    public static void main(String[] args) {
        // definir variable de Empleado (worker)
        Empleado worker = null;
        // estructura try/catch/finally para manejar errores o excepciones
        try {
            // crear objeto
            worker = new Empleado();
        } catch (IOException e) {
            // en caso de no poder crear objeto, imprimir error
            System.err.println("Error al crear el objeto Empleado, porfavor ingrese denuevo sus datos");
        }finally {
            // cuando no hayan errores, calcular el salario
            double salarioNeto = CalcularSalarioNeto.calcularSalarioNeto(worker.getNombre(), worker.getCategoria(), worker.getAnios(), worker.getSalarioBase());
            System.out.println("_".repeat(20));
            // imprimir resultado de salario neto
            System.out.println("SALARIO NETO: " + salarioNeto);
        }

    }

}