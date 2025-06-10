package edu.iudigital;

import java.util.Date;

public class Profesor {
    private int id;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String genero;
    private double estatura;
    private double peso;
    private String areaEspecializacion;
    private String nivelAcademico;
    private int aniosExperiencia;
    private String materia;

    // Constructor con todos los campos excepto el ID (para insertar)
    public Profesor(String nombre, String apellido, Date fechaNacimiento, String genero, double estatura, double peso, String areaEspecializacion, int aniosExperiencia, String materia, String nivelAcademico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.estatura = estatura;
        this.peso = peso;
        this.areaEspecializacion = areaEspecializacion;
        this.aniosExperiencia = aniosExperiencia;
        this.materia = materia;
        this.nivelAcademico = nivelAcademico;
    }


    // Constructor vacío
    public Profesor() {}

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public Date getFechaNacimiento() { return fechaNacimiento; }
    public String getGenero() { return genero; }
    public double getEstatura() { return estatura; }
    public double getPeso() { return peso; }
    public String getAreaEspecializacion() { return areaEspecializacion; }
    public int getAniosExperiencia() { return aniosExperiencia; }
    public String getMateria() { return materia; }
    public String getNivelAcademico() {return nivelAcademico; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setEstatura(double estatura) { this.estatura = estatura; }
    public void setPeso(double peso) { this.peso = peso; }
    public void setAreaEspecializacion(String areaEspecializacion) { this.areaEspecializacion = areaEspecializacion; }
    public void setAniosExperiencia(int aniosExperiencia) { this.aniosExperiencia = aniosExperiencia; }
    public void setMateria(String materia) { this.materia = materia; }
    public void setNivelAcademico(String nivelAcademico) { this.nivelAcademico = nivelAcademico; }
}
