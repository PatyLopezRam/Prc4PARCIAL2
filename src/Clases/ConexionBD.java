/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author rjcha
 */
public class ConexionBD {

    public static String url = "jdbc:mysql://LocalHost/login_bd";
    public static String usuario = "root";
    public static String contraseña = "chachagua0818";

    public static Connection conectar() {
        Connection conexion = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexion establecida mensaje en consola..");
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);
        }
        return conexion;
    }

    public static void desconectar() {
        Connection conexion = null;
        if (conexion == null) {
            System.out.println("la variable de conexion ha sido puesta en null");
        }
    }
}
