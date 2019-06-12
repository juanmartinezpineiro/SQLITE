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
import java.util.ArrayList;

/**
 *
 * @author juan
 */
public class Consultas {

    /**
     * Método para buscar filas en tabla carne, especificando el campo
     *
     * @param campo
     * @param valor
     * @return Arraylist de todos los campos
     */
    public static ArrayList<String> consultaCarnes(String campo, Object valor) {
        ArrayList<String> carnes = new ArrayList<>();
        String sql = "SELECT codigobarras,nombreproducto,seccion,tipocarne"
                + " FROM carnes WHERE " + campo + "=?";
        try (Connection conn = conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, valor);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                carnes.add(rs.getInt("codigobarras") + ","
                        + rs.getString("nombreproducto") + ","
                        + rs.getString("seccion") + ","
                        + rs.getInt("tipocarne"));
            }
            return carnes;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return carnes;
        }
    }

    /**
     * Método que devuelve el nombre del tipo de animal, especificando el codigo
     * vinculado al animal
     *
     * @param cod
     * @return Nombre de Categoria
     */
    public static String obtenerAnimal(int cod) {
        String sql = "SELECT nombre FROM Categoria where id = ?;";
        String resultado = "";
        try (Connection conn = conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cod);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                resultado = rs.getString("animal");
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return resultado;
        }
    }

    /**
     * Método que devuelve el cod del animal, especificando su nombre
     *
     * @param animal
     * @return cod de animal
     */
    public static int obtenerCODAnimal(String animal) {
        String sql = "SELECT cod FROM Categoria where animal = ?;";
        int resultado = 0;
        try (Connection conn = conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, animal);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                resultado = rs.getInt("cod");
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return resultado;
        }
    }
}