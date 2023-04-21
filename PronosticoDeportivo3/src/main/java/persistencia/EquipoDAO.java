package persistencia;

import entidades.Equipo;
import java.util.ArrayList;
import java.util.List;

public final class EquipoDAO extends DAO {

    public void guardarEquipo(Equipo equipo) throws Exception {
        try {
            if (equipo == null) {
                throw new Exception("Hay que agregar el equipo para guardarse");
            }

            String template = "INSERT INTO equipo VALUES (NULL, '%s', '%s');";
            String sql = String.format(template, equipo.getNombre(), equipo.getDescripcion());

            System.out.println("STATEMENT");
            System.out.println(sql);

            insertarModificarBorrar(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al guardar equipo");
        }
    }

    public void modificarEquipo(Equipo equipo) throws Exception {
        try {
            if (equipo == null) {
                throw new Exception("Hay que agregar el equipo");
            }
            String template = "UPDATE equipo SET nombre = '%s', descripcion = '%s' WHERE equipoId = %s;";
            String sql = String.format(template, equipo.getNombre(), equipo.getDescripcion(), equipo.getEquipoId());

            insertarModificarBorrar(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al modificar equipo");
        }
    }

    public void borrarEquipo(Integer equipoId) throws Exception {
        try {
            String sql = "DELETE FROM equipo WHERE equipoId = " + equipoId + ";";

            insertarModificarBorrar(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al eliminar equipo");
        }
    }

    public List<Equipo> obtenerEquipo() throws Exception {
        try {
            String sql = "SELECT * FROM equipo;";

            consultarBaseDatos(sql);

            List<Equipo> equipos = new ArrayList<>();
            Equipo equipo;

            while (resultSet.next()) {
                equipo = new Equipo();

                equipo.setEquipoId(resultSet.getInt("equipoId"));
                equipo.setNombre(resultSet.getString("nombre"));
                equipo.setDescripcion(resultSet.getString("descripcion"));

                equipos.add(equipo);
            }

            return equipos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener equipos");
        } finally {
            desconectarBase();
        }
    }

}
