


package schoolmanagementsystem;

import java.time.LocalDate;

  


public class SchoolManagementSystem {

public static void main(String[] args) {
        // Crear instancias de Estudiante y Curso
        Estudiante estudiante1 = new Estudiante(1, "Juan", "Pérez", LocalDate.of(2000, 1, 15), "matriculado");
        Estudiante estudiante2 = new Estudiante(2, "Ana", "García", LocalDate.of(1999, 5, 22), "inactivo");

        Curso curso1 = new Curso(101, "Matemáticas", "Curso de álgebra y cálculo", 5, "v1.0");
        Curso curso2 = new Curso(102, "Historia", "Historia universal", 3, "v1.0");

        // Instanciar GestorAcademico
        GestorAcademico gestor = new GestorAcademico();

        // Probar los métodos
        gestor.matricularEstudiante(estudiante1);
        gestor.matricularEstudiante(estudiante2);

        gestor.agregarCurso(curso1);
        gestor.agregarCurso(curso2);

        try {
            gestor.inscribirEstudianteCurso(estudiante1, 101);
            gestor.inscribirEstudianteCurso(estudiante2, 102);

            // Intentar reinscripción para probar excepciones
            gestor.inscribirEstudianteCurso(estudiante1, 101); // Debería lanzar EstudianteYaInscritoException

        } catch (EstudianteYaInscritoException e) {
            System.out.println(e.getMessage());
        }

        try {
            gestor.desinscribirEstudianteCurso(1, 101);
        } catch (EstudianteNoInscritoEnCursoException e) {
            System.out.println(e.getMessage());
        }

        // Verificar inscripciones y desinscripciones
    }
}
