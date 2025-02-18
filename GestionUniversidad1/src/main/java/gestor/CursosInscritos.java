package gestor;

import modelo.Inscripción;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CursosInscritos {
    private final String archivo = "inscripciones.dat";
    private List<Inscripción> listado;

    public CursosInscritos() {
        this.listado = cargarDatos();
    }

    public void inscribirCurso(Inscripción inscripcion) {
        listado.add(inscripcion);
        guardarDatos();
    }

    public List<Inscripción> obtenerLista() {
        return new ArrayList<>(listado);
    }

    private void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(listado);
        } catch (IOException e) {
            System.out.println("Error guardando datos: " + e.getMessage());
        }
    }

    private List<Inscripción> cargarDatos() {
        File file = new File(archivo);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<Inscripción>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error cargando datos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
