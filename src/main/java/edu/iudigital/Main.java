package edu.iudigital;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main{
    private static final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("MM-dd-yyyy");
    private static final Pattern SOLO_LETRAS = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$");

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            RegistroProfesores registro = new RegistroProfesores();
            ProfesorDAO profesorDAO = new ProfesorDAO();

            int cantidad = solicitarNumeroEntero(scanner, "¿Cuántos profesores deseas registrar?: ");

            for (int i = 0; i < cantidad; i++) {
                System.out.println("\n📋 Ingrese los datos del profesor #" + (i + 1));

                String nombre = solicitarTextoSoloLetras(scanner, "Nombre: ");
                String apellido = solicitarTextoSoloLetras(scanner, "Apellido: ");
                Date fechaNacimiento = leerFecha(scanner, "Fecha de nacimiento (MM-dd-yyyy): ");
                String genero = solicitarTextoSoloLetras(scanner, "Género (Masculino/Femenino): ");
                double estatura = solicitarNumeroDouble(scanner, "Estatura (en metros, ej: 1.75): ");
                double peso = solicitarNumeroDouble(scanner, "Peso (en kg, ej: 65.5): ");
                String areaEspecializacion = solicitarTextoSoloLetras(scanner, "Área de especialización: ");
                int aniosExperiencia = solicitarNumeroEntero(scanner, "Años de experiencia: ");
                String materia = solicitarTextoSoloLetras(scanner, "Materia: ");
                String nivelAcademico = solicitarTextoSoloLetras(scanner, "Nivel Académico: ");

                Profesor profesor = new Profesor(
                        nombre,
                        apellido,
                        fechaNacimiento,
                        genero,
                        estatura,
                        peso,
                        areaEspecializacion,
                        aniosExperiencia,
                        materia,
                        nivelAcademico
                );


                // Guardar en base de datos
                profesorDAO.guardar(profesor);

                // Mostrar todos los profesores para verificar
                List<Profesor> profesores = profesorDAO.listarTodos();
                System.out.println("\n=== Profesores en base de datos ===");
                for (Profesor p : profesores) {
                    System.out.println(p.getId() + " - " + p.getNombre() + " " + p.getApellido());
                }

                // Guardar en registro local para mostrar
                registro.agregarProfesor(profesor);

                System.out.println("✅ Profesor agregado correctamente.");
            }

            // Mostrar resultados
            System.out.println("\n=== Profesores Registrados ===");
            for (Profesor p : registro.obtenerProfesores()) {
                System.out.println(p.getNombre() + " " + p.getApellido());
                System.out.println("Nacimiento: " + FORMATO_FECHA.format(p.getFechaNacimiento()));
                System.out.println("Género: " + p.getGenero());
                System.out.println("Estatura: " + p.getEstatura() + " m");
                System.out.println("Peso: " + p.getPeso() + " kg");
                System.out.println("Especialización: " + p.getAreaEspecializacion());
                System.out.println("Nivel Académico: " + p.getNivelAcademico());
                System.out.println("Experiencia: " + p.getAniosExperiencia() + " años");
                System.out.println("Materia: " + p.getMateria());
                System.out.println("Nivel Académico: " + p.getNivelAcademico());
                System.out.println("----------------------------------");
            }
        }
    }

    // Validar solo letras
    private static String solicitarTextoSoloLetras(Scanner scanner, String mensaje) {
        String valor;
        do {
            System.out.print(mensaje);
            valor = scanner.nextLine().trim();
            if (!SOLO_LETRAS.matcher(valor).matches()) {
                System.out.println("❌ Solo se permiten letras. Intenta de nuevo.");
            }
        } while (!SOLO_LETRAS.matcher(valor).matches());
        return valor;
    }

    // Validar número entero
    private static int solicitarNumeroEntero(Scanner scanner, String mensaje) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            try {
                valor = Integer.parseInt(entrada.trim());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("❌ Solo se permiten números enteros.");
            }
        }
        return valor;
    }

    // Validar número decimal
    private static double solicitarNumeroDouble(Scanner scanner, String mensaje) {
        double valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            try {
                valor = Double.parseDouble(entrada.trim());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("❌ Solo se permiten números reales.");
            }
        }
        return valor;
    }

    // Validar fecha
    private static Date leerFecha(Scanner scanner, String mensaje) {
        Date fecha = null;
        while (fecha == null) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                fecha = FORMATO_FECHA.parse(entrada);
            } catch (ParseException e) {
                System.out.println("❌ Formato inválido. Usa MM-dd-yyyy");
            }
        }
        return fecha;
    }
}
