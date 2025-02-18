package gestor;

import modelo.Persona;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InscripcionesPersonas {
    private final String archivo = "personas.dat";
    private List<Persona> listado;

    public InscripcionesPersonas() {
        this.listado = cargarDatos();
    }

    public void inscribir(Persona persona) {
        listado.add(persona);
        guardarDatos();
    }

    public void eliminar(Persona persona) {
        listado.remove(persona);
        guardarDatos();
    }

    public void actualizar(Persona persona) {
        for (int i = 0; i < listado.size(); i++) {
            if (listado.get(i).getID() == persona.getID()) {
                listado.set(i, persona);
                guardarDatos();
                break;
            }
        }
    }

    public Persona buscarPersona(double id) {
        for (Persona p : listado) {
            if (p.getID() == id) {
                return p;
            }
        }
        return null;
    }

    public List<Persona> obtenerLista() {
        return new ArrayList<>(listado);
    }

    private void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(listado);
        } catch (IOException e) {
            System.out.println("Error guardando datos: " + e.getMessage());
        }
    }

    private List<Persona> cargarDatos() {
        File file = new File(archivo);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<Persona>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error cargando datos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
