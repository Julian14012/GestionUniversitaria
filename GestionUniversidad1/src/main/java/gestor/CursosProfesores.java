package gestor;

import modelo.CursoProfesor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CursosProfesores {
    private final String archivo = "cursos_profesores.dat";
    private List<CursoProfesor> listado;

    public CursosProfesores() {
        this.listado = cargarDatos();
    }

    public void inscribir(CursoProfesor cursoProfesor) {
        listado.add(cursoProfesor);
        guardarDatos();
    }

    public List<CursoProfesor> obtenerLista() {
        return new ArrayList<>(listado);
    }

    private void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(listado);
        } catch (IOException e) {
            System.out.println("Error guardando datos: " + e.getMessage());
        }
    }

    private List<CursoProfesor> cargarDatos() {
        File file = new File(archivo);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<CursoProfesor>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error cargando datos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
