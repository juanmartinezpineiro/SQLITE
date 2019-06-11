
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
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class Insertar {

    /**
     * Método para insertar filas en la tabla carnes
     *
     * @param codigobarras
     * @param nombreproducto
     * @param seccion
     * @param tipocarne
     * @return Inserción de fila en tabla
     */
    public static boolean insertarCarne(int codigobarras, String nombreproducto, String seccion, int tipocarne) {
        boolean insC = false;
        String sql = "INSERT INTO carnes VALUES(?,?,?,?)";
        try (Connection conn = conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigobarras);
            pstmt.setString(2, nombreproducto);
            pstmt.setString(3, seccion);
            pstmt.setInt(4, tipocarne);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Carne registrada correctamente");
            insC = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al introducir los datos");
            insC = false;
        }
        return insC;
    }

    /**
     * Método para insertar los valores definidos en la tabla tipoCarne
     *
     * @return Inserción de valores en tabla
     */
    public static boolean insertarTipoCarne() {
        boolean insCat = false;
        String sql1 = "INSERT INTO Categoria VALUES(1,'CERDO');";
        String sql2 = "INSERT INTO Categoria VALUES(2,'CONEJO');";
        String sql3 = "INSERT INTO Categoria VALUES(3,'TERNERA');";
        String sql4 = "INSERT INTO Categoria VALUES(4,'EQUINO');";
        try (Connection conn = conectar();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql1);
            stmt.execute(sql2);
            stmt.execute(sql3);
            stmt.execute(sql4);
            insCat = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            insCat = false;
        }
        return insCat;
    }

}