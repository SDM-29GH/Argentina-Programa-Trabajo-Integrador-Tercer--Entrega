package servicios;

import entidades.Equipo;
import persistencia.EquipoDAO;

import java.util.List;

public class EquipoServicio {

    private final EquipoDAO equipoDAO;

    public EquipoServicio(){
        equipoDAO = new EquipoDAO();
    }

    public void crearEquipo(String nombre, String descripcion) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("El nombre es obligatorio");
            }

            if (descripcion == null || descripcion.trim().isEmpty()) {
                throw new Exception("La descripcion es obligatorio");
            }

            Equipo equipo = new Equipo();

            equipo.setNombre(nombre);
            equipo.setDescripcion(descripcion);

            equipoDAO.guardarEquipo(equipo);
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirEquipo() throws Exception {
        try {
            List<Equipo> equipos = equipoDAO.obtenerEquipo();

            if (equipos.isEmpty()) {
                throw new Exception("No existen los equipos");
            } else {
                System.out.println("LISTA DE EQUIPOS");
                System.out.printf("%-10s%-15s%-15s%-20s\n", "ID", "NOMBRE", "DESCRIPCION");
                for (Equipo equipo : equipos) {
                    System.out.printf("%-10s%-15s%-15s%-20s\n", equipo.getEquipoId(), equipo.getNombre(), equipo.getDescripcion());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
