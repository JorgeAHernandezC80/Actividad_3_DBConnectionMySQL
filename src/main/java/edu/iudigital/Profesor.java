package edu.iudigital;

import java.util.Date;

public class Profesor extends Persona {
    private int id;
    private String areaEspecializacion;
    private String nivelAcademico;
    private int aniosExperiencia;
    private String materia;

    // Constructor sin ID (para insertar)
    public Profesor(String nombre, String apellido, Date fechaNacimiento, String genero,
                    double estatura, double peso, String areaEspecializacion,
                    int aniosExperiencia, String materia, String nivelAcademico) {
        super(nombre, apellido, fechaNacimiento, genero, estatura, peso);
        this.areaEspecializacion = areaEspecializacion;
        this.aniosExperiencia = aniosExperiencia;
        this.materia = materia;
        this.nivelAcademico = nivelAcademico;
    }

    // Constructor vacío
    public Profesor() {}

    // Getters
    public int getId() { return id; }
    public String getAreaEspecializacion() { return areaEspecializacion; }
    public int getAniosExperiencia() { return aniosExperiencia; }
    public String getMateria() { return materia; }
    public String getNivelAcademico() { return nivelAcademico; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setAreaEspecializacion(String areaEspecializacion) { this.areaEspecializacion = areaEspecializacion; }
    public void setAniosExperiencia(int aniosExperiencia) { this.aniosExperiencia = aniosExperiencia; }
    public void setMateria(String materia) { this.materia = materia; }
    public void setNivelAcademico(String nivelAcademico) { this.nivelAcademico = nivelAcademico; }
}
