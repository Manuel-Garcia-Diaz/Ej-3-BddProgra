/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Breyner
 */
public class Conexion {

    Connection conexion;

    public int registrarDriver() {
        int resultado;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            resultado = 0;
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
            resultado = -1;
        }
        return resultado;
    }

    public int conectar(String url) {
        int resultado;

        try {

            conexion = DriverManager.getConnection(url, "root", "root");
            resultado = 0;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,
                    null, ex);
            resultado = -1;
        }
        return resultado;
    }

    public int conectar() {
        int resultado;
        Config config = new Config(); // Instanciamos el lector de config

        try {
            // Obtenemos los valores del archivo externo
            String url = config.getProp("db.url");
            String user = config.getProp("db.user");
            String pass = config.getProp("db.pass");

            conexion = DriverManager.getConnection(url, user, pass);
            resultado = 0;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            resultado = -1;
        }
        return resultado;
    }

    public int establecer() {
        int resultado;
        resultado = registrarDriver();
        if (resultado != -1) {

            resultado = conectar();
        }
        return resultado;
    }

    public void cerrar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

    }

    public Connection getConexion() {
        try {
            // Si la conexion esta vacia o se ha cerrado, la establecemos
            if (conexion == null || conexion.isClosed()) {
                establecer(); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
}
