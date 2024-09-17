/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorAcademico implements ServiciosAcademicosI {
    private List<Estudiante> estudiantes;
    private List<Curso> cursos;
    private Map<Curso, List<Estudiante>> inscripciones;

    public GestorAcademico() {
        estudiantes = new ArrayList<>();
        cursos = new ArrayList<>();
        inscripciones = new HashMap<>();
    }

    
    public void matricularEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
        }
    }

   
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
            inscripciones.put(curso, new ArrayList<>());
        }
    }

 
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        Curso curso = cursos.stream().filter(c -> c.getId() == idCurso).findFirst().orElse(null);
        if (curso == null) {
            throw new IllegalArgumentException("Curso no encontrado");
        }
        if (!estudiantes.contains(estudiante)) {
            throw new IllegalArgumentException("Estudiante no matriculado");
        }
        if (inscripciones.get(curso).contains(estudiante)) {
            throw new EstudianteYaInscritoException("El estudiante ya está inscrito en este curso");
        }
        inscripciones.get(curso).add(estudiante);
    }

    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        Curso curso = cursos.stream().filter(c -> c.getId() == idCurso).findFirst().orElse(null);
        Estudiante estudiante = estudiantes.stream().filter(e -> e.getId() == idEstudiante).findFirst().orElse(null);

        if (curso == null || estudiante == null) {
            throw new IllegalArgumentException("Curso o estudiante no encontrado");
        }
        if (!inscripciones.get(curso).remove(estudiante)) {
            throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso");
        }
    }
}