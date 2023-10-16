import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Empleado {
    // Clase Empleado
    // solicita datos del empleado
    // crea un nuevo objeto con atributos únicos

    // atributos del empleado
    private String nombre;
    private String categoria;
    private int salarioBase;
    private String aniosStr;
    private int anios;

    // lanzar excepción I/O
    public Empleado() throws IOException {
        // crear lector
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        this.nombre = nombre;
        this.categoria = categoria;
        this.salarioBase = salarioBase;
        this.aniosStr = aniosStr;
        this.anios = anios;

        // ciclo para pedir el nombre hasta obtener respuesta válida
        while (true) {
            try {
                // pedir nombre
                System.out.println("Por favor ingrese su nombre:");
                this.nombre = reader.readLine();

                if (Pattern.matches(".*\\d.*", this.nombre)) {
                    // evitar que nombre tenga números
                    throw new InvalidNombreException("El nombre no puede contener números");
                } else if (this.nombre == null || this.nombre.isEmpty()) {
                    // evitar que nombre esté en blanco
                    throw new EmptyStringException("El campo esta vacio, ingresalo denuevo");
                } else {
                    // romper bucle si el nombre es válido
                    break;
                }
            } catch (InvalidNombreException e) {
                // capturar excepción de nombre inválido
                System.err.println(e.getMessage());
            } catch (EmptyStringException er) {
                // capturar excepción de nombre en blanco
                System.err.println(er.getMessage());
            } catch (IOException e) {
                // imprimir Stack Trace
                e.printStackTrace();
            }
        }

        // ciclo para pedir la categoria hasta que se ingrese una correcta
        while (true) {
            try {
                // pedir ingresar catecogría
                System.out.println("Por favor ingrese su categoria:\n (Gerencial/Licenciatura/Tecnico): ");
                this.categoria = reader.readLine();

                if (Pattern.matches(".*\\d.*", this.categoria)) {
                    // evitar que la categoría tenga números
                    throw new InvalidCategoriaException("La categoria no puede contener números");
                } else if (this.categoria == null || this.categoria.isEmpty()) {
                    // evitar que la categoría esté en blanco
                    throw new EmptyStringException("El campo esta vacio, ingresalo denuevo");
                } else if(!this.categoria.toLowerCase().equals("licenciatura") && !this.categoria.toLowerCase().equals("gerencial") && !this.categoria.toLowerCase().equals("tecnico")){
                    // evitar que se ingrese una categoría no existente
                    throw new InvalidCategoriaException("La categoria no es aceptada, intentelo denuevo");
                }else {
                    // salir del bucle cuando todo esté nice
                    break;
                }
            } catch (InvalidCategoriaException e) {//falta que en los
                // años de experiencia tome los errores de campo vacio, si mete una letra, o si mete un numero mayor a 2 caracteres
                // capturar excepción de categoría inválida
                System.err.println(e.getMessage());
            } catch (EmptyStringException e) {
                // capturar excepción de string vacía
                System.err.println(e.getMessage());
            }
        }

        while (true) {
            try {
                // pedir años de experiencia
                System.out.println("Por favor ingrese sus años de experiencia:");
                String input = reader.readLine();

                if (input == null || input.isEmpty()) {
                    // evitar que años de experiencia estén vacíos
                    throw new EmptyStringException("El campo no puede estar vacío.");
                }
                else if(input.contains(".")) {
                    // evitar que años de experiencia sean decimales
                    throw new DecimalNumberException("La entrada no puede ser un número decimal");
                }

                // convetir años a integer
                anios = Integer.parseInt(input);

                if (anios < 0 || anios >= 100) {
                    // evitar que años sea negativo a tenga 3 dígitos o más
                    throw new OutOfRangeException("El número no puede ser negativo o tener 3 dígitos.");
                } else {
                    break;
                }
            } catch (EmptyStringException| DecimalNumberException | OutOfRangeException e) {
                System.err.println(e.getMessage());
            }catch (NumberFormatException e){
                // evitar que se ingrese valores equivocados
                System.err.println("Ingresaste un valor equivocado, porfavor ingresa tu dato denuevo");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        establecerSalarioBase();
    }
        private void establecerSalarioBase() {

            // definir salario base según categoría
            switch (this.categoria.toLowerCase()) {
                case "gerencial" -> this.salarioBase = 2000;
                case "licenciatura" -> this.salarioBase = 1500;
                case "técnico" -> this.salarioBase = 700;
                case "tecnico" -> this.salarioBase = 700;
                default -> this.salarioBase = 0;
            }

        }

    public int getSalarioBase() {
        return salarioBase;
    }

    public int getAnios() {
        return anios;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getNombre() {
        return nombre;
    }
}