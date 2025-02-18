package modelo;

import java.io.Serializable;

public class Programa implements Serializable {
    private double ID;
    private String nombre;
    private double duracion;
    private String registro;
    private Facultad facultad;

    public Programa(double ID, String nombre, double duracion, String registro, Facultad facultad) {
        this.ID = ID;
        this.nombre = nombre;
        this.duracion = duracion;
        this.registro = registro;
        this.facultad = facultad;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Programa: " + nombre + ", Facultad: " + facultad.getNombre();
    }
}
