package persistencia;

//import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class DAO {

    protected Connection connection;
    protected ResultSet resultSet;
    protected Statement statement;

    private final String url = "jdbc:mysql://localhost:3306/pronostico_deportivo3?serverTimezone=UTC";
    private final String username = "root";
    private final String password = "root";

    protected void conectarBase() throws Exception {
        try{
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            ResultSet resulSet = statement.executeQuery("SELECT * FROM Equipo");

            while (resulSet.next()){
                System.out.println(resulSet.getString("nombre")+" | "+ resulSet.getString("descripcion"));
            }
            connection.close();
            statement.close();
            resulSet.close();
        }catch(Exception e){
            throw new Exception("Error de conexión");
        }
    }

    protected void desconectarBase() throws Exception {
        try {
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            throw new Exception("Error al desconectarse");
        }
    }

    protected void insertarModificarBorrar(String sql) throws Exception {
        try {
            conectarBase();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
                throw new Exception("Error al ejecutar rollback");
            }
            throw new Exception("Error al ejecutar sentencia");
        } finally {
            desconectarBase();
        }
    }

    protected void consultarBaseDatos(String sql) throws Exception {
        try {
            conectarBase();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (Exception e) {
            throw new Exception("Error al consultar");
        }
    }

}
