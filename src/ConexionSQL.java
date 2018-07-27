/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jair Parra
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionSQL {
//    cadena de conexion direccion del servidor base de datos usuario y contraseña
    static String cadenaConexion = "jdbc:postgresql://localhost/Transporte?" + "user=postgres&password=postgres";
    public static void main(String[] arg) {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultado = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(cadenaConexion);
            sentencia = conexion.createStatement();
            String consultaSQL = "SELECT * FROM prueba1";
            resultado = sentencia.executeQuery(consultaSQL);
            while (resultado.next()) {
                Long id = resultado.getLong("id");
                String nombres = resultado.getString("nombre");
                String telefono = resultado.getString("telefono");
                String celular = resultado.getString("celular");
                int version = resultado.getInt("version");
                System.out.println(id + "\t" + nombres + "\t" + telefono + "\t" + celular + "\t" + version);
            }
        } catch (Exception e) {
            e.printStackTrace();
            conexion = null;
        } finally {
            if (resultado != null) {
                try {
                    resultado.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
