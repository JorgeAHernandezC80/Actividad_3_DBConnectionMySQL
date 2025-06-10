package edu.iudigital;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegistroProfesores {

    private final List<Profesor> listaProfesores;
    private static final int MAX_PROFESORES = 50;

    public RegistroProfesores() {
        this.listaProfesores = new ArrayList<>();
    }

    public boolean agregarProfesor(Profesor profesor) {
        if (listaProfesores.size() >= MAX_PROFESORES) {
            System.out.println("❌ Límite de 50 profesores alcanzado.");
            return false;
        }
        listaProfesores.add(profesor);
        return true;
    }
    //Previene las modificaciones externas
    public List<Profesor> obtenerProfesores() {
        return Collections.unmodifiableList(listaProfesores);
    }

    public int getCantidadRegistrados() {
        return listaProfesores.size();
    }
}
