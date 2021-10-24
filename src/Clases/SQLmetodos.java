/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import proyecto.de.escritorio.frmMenuAdmin;
import proyecto.de.escritorio.frmMenuInvitado;

/**
 *
 * @author rjcha
 */
public class SQLmetodos {

    Connection conexion;
    PreparedStatement sentencia_preparada;
    ResultSet resultado;
    String sql;
    frmMenuAdmin formulariomenuadmin = new frmMenuAdmin();
    frmMenuInvitado formulariomenuinvitado = new frmMenuInvitado();

    public void buscarUsuario(String usuario, String contraeña) {
        String Nivel_Usuiario;
        try {
            conexion = ConexionBD.conectar();
            // sql = "SELECT usuarios, contraseña FROM usuarios_registrados WHERE usuarios='" + usuario + "' && contraseña='" + contraeña + "'";
            sql = "SELECT * FROM usuarios_registrados WHERE usuarios='" + usuario + "' && contraseña='" + contraeña + "'";
            sentencia_preparada = (PreparedStatement) conexion.prepareStatement(sql);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                usuario = resultado.getString("usuarios");
                contraeña = resultado.getString("contraseña");

                if (usuario != null && contraeña != null) {
                    Nivel_Usuiario = resultado.getString("nivel");

                    switch (Nivel_Usuiario) {

                        case "administrador":
                            formulariomenuadmin.setVisible(true);
                            break;
                        case "invitado":
                            formulariomenuinvitado.setVisible(true);
                            break;
                    }
                }

                //formulariomenu.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Error en el usuario o contraseña ingresados");
            }
            conexion.close();
            ConexionBD.conectar();
        } catch (Exception e) {
            System.out.println("Error buscar: " + e);
        }
    }

}
