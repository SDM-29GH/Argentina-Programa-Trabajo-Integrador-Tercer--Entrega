package entidades;

public class Equipo {
    private Integer equipoId;
    private String nombre;
    private String descripcion;

    public Equipo() {
    }

    public Equipo(String nombre, String descripcion) {
        this.equipoId = equipoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(Integer equipoId) {
        this.equipoId = equipoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return String.format("EQUIPO (equipoId: %s, nombre: %s, descripcion: %s)", equipoId, nombre, descripcion);
    }
}
