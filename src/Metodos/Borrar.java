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

/**
 *
 * @author juan
 */
public class Borrar {
        

    /**
     * Método para borrar una fila de la tabla carnes, especificando el código de barras
     * @param codigobarras
     * @return Borrar fila Competición
     */
    public static boolean borrarCodigoBarras(int codigobarras){
        boolean brCom=false;
        String sql = "DELETE FROM carnes WHERE CBarras=?";
        try (Connection conn = conectar();
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setInt(1, codigobarras);
            pstmt.executeUpdate();
            brCom=true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            brCom=false;
        }return brCom;
    }
    
}