/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionuniversidad;

import gestor.CursosInscritos;
import gestor.CursosProfesores;
import gestor.InscripcionesPersonas;
import modelo.Curso;
import modelo.CursoProfesor;
import modelo.Estudiante;
import modelo.Facultad;
import modelo.Inscripción;
import modelo.Persona;
import modelo.Profesor;
import modelo.Programa;

/**
 *
 * @author JG COLOMBIA
 */
public class GestionUniversidad1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // Crear instancias de los gestores
        InscripcionesPersonas gestorPersonas = new InscripcionesPersonas();
       
        
        CursosProfesores gestorProfesores = new CursosProfesores();
        CursosInscritos gestorInscripciones = new CursosInscritos();

        // Crear una persona
        Persona persona1 = new Persona(1, "Juan", "Pérez", "juan@example.com");
        gestorPersonas.inscribir(persona1);

        // Buscar la persona por ID
        Persona encontrada = gestorPersonas.buscarPersona(1);
        if (encontrada != null) {
            System.out.println("Persona encontrada: " + encontrada.getNombres());
        }

        // Crear un profesor
        Profesor profesor1 = new Profesor(2, "Ana", "Gómez", "ana@example.com", "Tiempo Completo");
        CursoProfesor cursoProfesor1 = new CursoProfesor(profesor1, 2024, 1, new Curso(101, new Programa(1, "Ingeniería", 5, "A001", new Facultad(1, "Ciencias", persona1)), true));

        gestorProfesores.inscribir(cursoProfesor1);

        // Inscribir un estudiante en un curso
        Estudiante estudiante1 = new Estudiante(3, "Carlos", "Ramírez", "carlos@example.com", 12345, new Programa(1, "Ingeniería", 5, "A001", new Facultad(1, "Ciencias", persona1)), true, 4.5);
        Inscripción inscripcion1 = new Inscripción(new Curso(101, new Programa(1, "Ingeniería", 5, "A001", new Facultad(1, "Ciencias", persona1)), true), 2024, 1, estudiante1);

        gestorInscripciones.inscribirCurso(inscripcion1);

        // Mostrar los datos almacenados
        System.out.println("Lista de personas inscritas: " + gestorPersonas.obtenerLista());
        System.out.println("Lista de profesores en cursos: " + gestorProfesores.obtenerLista());
        System.out.println("Lista de inscripciones: " + gestorInscripciones.obtenerLista());
    }
    
}
