/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Metodos;

import static Metodos.Conectar.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class Modificar {

    /**
     * Método para modificar el piloto y vehiculo de una fila de la tabla rally,
     * especificando el dorsal
     *
     * @param nombreproducto
     * @param seccion
     * @param codigobarras
     * @return modificación de nombreproducto y seccion en fila de tabla Competidor
     */
    public static boolean modificarProducto(String nombreproducto, String seccion, int codigobarras) {
        boolean modCom = false;
        String sql = "UPDATE carnes SET Piloto = ? , "
                + "seccion = ? "
                + "WHERE codigobarras = ?";
        try (Connection conn = conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreproducto);
            pstmt.setString(2, seccion);
            pstmt.setInt(3, codigobarras);
            pstmt.executeUpdate();
            modCom = true;
            JOptionPane.showMessageDialog(null, "Sección cambiada!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            modCom = false;
        }
        return modCom;
    }

    /**
     * Método para modificar el producto de sección y vehiculo la tabla carnes
 especificando el id de la tipocarne
     *
     * @param nombreproducto
     * @param seccion
     * @param tipocarne
     * @param codigobarras
     * @return modificación de nombreproducto, seccion y Categoría en la tabla
 Competidor
     *
     */
    public static boolean modificarSeccionProducto(String nombreproducto, String seccion, int tipocarne, int codigobarras) {
        boolean modCat = false;
        String sql = "UPDATE carnes SET nombreproducto = ? , "
                + "seccion = ? , "
                + "tipocarne = ?"
                + "WHERE codigobarras = ?";
        try (Connection conn = conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreproducto);
            pstmt.setString(2, seccion);
            pstmt.setInt(3, tipocarne);
            pstmt.setInt(4, codigobarras);
            pstmt.executeUpdate();
            modCat = true;
            JOptionPane.showMessageDialog(null, "El producto ha sido modificado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            modCat = false;
        }
        return modCat;
    }
}
