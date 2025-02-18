package modelo;

public class Estudiante extends Persona {
    private double codigo;
    private Programa programa;
    private boolean activo;
    private double promedio;

    public Estudiante(double ID, String nombres, String apellidos, String email, double codigo, Programa programa, boolean activo, double promedio) {
        super(ID, nombres, apellidos, email);
        this.codigo = codigo;
        this.programa = programa;
        this.activo = activo;
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return super.toString() + ", Código: " + codigo + ", Programa: " + programa.getNombre() + ", Activo: " + activo + ", Promedio: " + promedio;
    }
}
