package modelo;

public class Profesor extends Persona {
    private String tipoContrato;

    public Profesor(double ID, String nombres, String apellidos, String email, String tipoContrato) {
        super(ID, nombres, apellidos, email);
        this.tipoContrato = tipoContrato;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo de Contrato: " + tipoContrato;
    }
}
