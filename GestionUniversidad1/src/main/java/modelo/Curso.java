package modelo;

import java.io.Serializable;

public class Curso implements Serializable {
    private int id;
    private Programa programa;
    private boolean activo;

    public Curso(int id, Programa programa, boolean activo) {
        this.id = id;
        this.programa = programa;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Curso ID=" + id + ", Programa=" + programa.getNombre() + ", Activo=" + activo;
    }
}
