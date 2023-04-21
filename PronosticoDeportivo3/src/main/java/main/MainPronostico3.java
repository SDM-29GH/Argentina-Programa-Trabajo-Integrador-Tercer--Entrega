package main;

import persistencia.EquipoDAO;
import servicios.EquipoServicio;

import java.sql.*;

public class MainPronostico3 {

    public static void main(String[] args) {

        EquipoServicio equipoServicio = new EquipoServicio();

        try{
            equipoServicio.imprimirEquipo();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
