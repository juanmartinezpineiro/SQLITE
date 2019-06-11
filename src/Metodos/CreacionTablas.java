/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Metodos;

import static Metodos.Conectar.conectar;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author juan
 */
public class CreacionTablas {

    /**
     * Método de creación de la tabla carnes
     *
     * @return Creación tabla carnes
     */
    public static boolean crearTablaCarnes() {
        boolean ctr = false;
        String sql1 = "DROP TABLE IF EXISTS carnes;\n";
        String sql2 = "CREATE TABLE IF NOT EXISTS carnes (\n"
                + "codigobarras integer PRIMARY KEY,\n"
                + "nombreproducto text NOT NULL,\n"
                + "seccion text NOT NULL,\n"
                + "tipocarne integer,\n"
                + "FOREIGN KEY (tipocarne)\n"
                + "REFERENCES tipocarne(cod)\n"
                + ");";
        try (Connection conn = conectar();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql1);
            stmt.execute(sql2);
            ctr = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ctr = false;
        }
        return ctr;
    }

    /**
     * Método de creación de la tabla tipo de carne Animal
     *
     * @return Creación tabla Animal
     */
    public static boolean crearTablaAnimal() {
        boolean ctc = false;
        String sql1 = "DROP TABLE IF EXISTS tipocarne;\n";
        String sql = "CREATE TABLE IF NOT EXISTS tipocarne (\n"
                + "cod integer PRIMARY KEY,\n"
                + "animal text NOT NULL\n"
                + ");";
        try (Connection conn = conectar();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql1);
            stmt.execute(sql);
            ctc = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ctc = false;
        }
        return ctc;
    }

}