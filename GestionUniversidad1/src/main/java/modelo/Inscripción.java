package modelo;

import java.io.Serializable;

public class Inscripción implements Serializable {
    private Curso curso;
    private int año;
    private int semestre;
    private Estudiante estudiante;

    public Inscripción(Curso curso, int año, int semestre, Estudiante estudiante) {
        this.curso = curso;
        this.año = año;
        this.semestre = semestre;
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return "Inscripción: Curso=" + (curso != null ? curso.toString() : "Sin curso") +
               ", Año=" + año + ", Semestre=" + semestre + 
               ", Estudiante=" + (estudiante != null ? estudiante.toString() : "Sin estudiante");
    }
}
