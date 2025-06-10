package edu.iudigital;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO {

    // Guardar un profesor
    public void guardar(Profesor profesor) {
        String sql = "INSERT INTO profesores (nombre, apellido, fecha_nacimiento, genero, estatura, peso, area_especializacion, anios_experiencia, materia, nivel_academico) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, profesor.getNombre());
            stmt.setString(2, profesor.getApellido());
            stmt.setDate(3, new java.sql.Date(profesor.getFechaNacimiento().getTime()));
            stmt.setString(4, profesor.getGenero());
            stmt.setDouble(5, profesor.getEstatura());
            stmt.setDouble(6, profesor.getPeso());
            stmt.setString(7, profesor.getAreaEspecializacion());
            stmt.setInt(8, profesor.getAniosExperiencia());
            stmt.setString(9, profesor.getMateria());
            stmt.setString(10, profesor.getNivelAcademico());
            stmt.executeUpdate();
            System.out.println("✅ Profesor guardado correctamente.");

        } catch (SQLException e) {
            System.err.println("❌ Error al guardar el profesor.");
            e.printStackTrace();
        }
    }

    // Listar todos los profesores
    public List<Profesor> listarTodos() {
        List<Profesor> profesores = new ArrayList<>();
        String sql = "SELECT * FROM profesor";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Profesor p = new Profesor(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("genero"),
                        rs.getDouble("estatura"),
                        rs.getDouble("peso"),
                        rs.getString("area_especializacion"),
                        rs.getInt("anios_experiencia"),
                        rs.getString("materia"),
                        rs.getString("nivel_academico")
                );

                p.setId(rs.getInt("id_profesor"));
                profesores.add(p);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al obtener los profesores.");
            e.printStackTrace();
        }

        return profesores;
    }

    // Buscar profesor por ID
    public Profesor buscarPorId(int id) {
        String sql = "SELECT * FROM profesor WHERE id_profesor = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Profesor p = new Profesor(
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getDate("fecha_nacimiento"),
                            rs.getString("genero"),
                            rs.getDouble("estatura"),
                            rs.getDouble("peso"),
                            rs.getString("area_especializacion"),
                            rs.getInt("anios_experiencia"),
                            rs.getString("materia"),
                            rs.getString("nivel_academico")  // <-- nuevo campo
                    );

                    p.setId(rs.getInt("id_profesor"));
                    return p;
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al buscar profesor por ID.");
            e.printStackTrace();
        }
        return null; // No encontrado
    }
}
