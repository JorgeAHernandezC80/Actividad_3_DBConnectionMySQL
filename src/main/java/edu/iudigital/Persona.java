package edu.iudigital;

import java.util.Date;

public class Persona {
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String genero;
    private double estatura;
    private double peso;

    public Persona() {
        // Optionally initialize fields with default values
    }

    public Persona(String nombre, String apellido, Date fechaNacimiento, String genero, double estatura, double peso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.estatura = estatura;
        this.peso = peso;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public double getEstatura() {
        return estatura;
    }

    public double getPeso() {
        return peso;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
