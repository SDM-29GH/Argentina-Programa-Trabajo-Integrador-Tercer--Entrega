package entidades;

import java.util.ArrayList;

public class Ronda {
    private Integer nro;
    private ArrayList<Partido> partidos = new ArrayList<>();

    public Ronda() {
    }

    public Ronda(Integer nro, ArrayList<Partido> partidos) {
        this.nro = nro;
        this.partidos = partidos;
    }

    public Integer getNro() {
        return nro;
    }

    public void setNro(Integer nro) {
        this.nro = nro;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }
}
