/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Metodos;

import static Metodos.Conectar.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author juan
 */
public class Return {

    /**
     * Método que retorna un String con todos los campos de una fila,
     * especificando el Código de barras
     *
     * @param Codigobarras
     * @return Todos los campos de Competidor
     */
    public static String devolverCarne(int Codigobarras) {
        String sql = "SELECT codigobarras,nombreproducto,seccion,tipocarne"
                + " FROM carnes WHERE codigobarras=?";
        String resultado = "";
        try (Connection conn = conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Codigobarras);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                resultado = (rs.getInt("codigobarras") + ","
                        + rs.getString("nombreproducto") + ","
                        + rs.getString("seccion") + ","
                        + rs.getInt("tipocarne"));
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return resultado;
        }
    }

    /**
     * Método que retorna un String con todos los campos de una fila,
     * especificando el cod
     *
     * @param cod
     * @return Todos los campos de Categoria
     */
    public static String devolverCategoria(int cod) {
        String sql = "SELECT cod,animal"
                + " FROM tipocarne WHERE cod=?";
        String resultado = "";
        try (Connection conn = conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cod);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                resultado = (rs.getInt("cod") + ","
                        + rs.getString("animal"));
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return resultado;
        }
    }

}