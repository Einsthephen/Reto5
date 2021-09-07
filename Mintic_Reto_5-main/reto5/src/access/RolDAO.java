/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.RolModel;
import utils.ConnectionDB;

/**
 *
 * @author yinna - Clase con lógica para acceder a los datos de la tabla roles
 */
public class RolDAO {

    private Connection conn;

    /**
     * Ejecuta el query que lista todos los roles en la base de datos
     *
     * @return Lista de objetos tipo RolModel
     */
    public List<RolModel> obtenerRoles() {
        // lógica para poder traer todos los roles
        List<RolModel> roles = new ArrayList<RolModel>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "SELECT rol.id as id, rol.nombre as nombre FROM roles rol;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                RolModel rol = new RolModel(result.getInt(1), result.getString(2));
                roles.add(rol);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        };
        return roles;
    }

    /**
     * Ejecuta el query que obtiene un rol con base en un id
     *
     * @param id
     * @return retorna un objeto de tipo RolModel
     */
    public RolModel obtenerRol(int id) {
        // logica para poder traer un rol basado en el id
        RolModel rol = null;
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "SELECT rol.id as id, rol.nombre as nombre FROM roles rol WHERE rol.id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                rol = new RolModel(result.getInt(1), result.getString(2));

            }
        } catch (SQLException ex) {
            System.err.println(ex);
        };
        return rol;
    }

    /**
     * Ejecuta un insert que agrega un rol a la base de datos
     *
     * @param rol
     */
    public void agregarRol(RolModel rol) {

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "INSERT INTO roles(id, nombre)" + "VALUES(?,?);";
            PreparedStatement statement = conn.prepareStatement(sql); //va a listar la preparación deun query
            //la transformación
            statement.setInt(1, rol.getId());
            statement.setString(2, rol.getNombre());
            int rowsInsert = statement.executeUpdate();
            if (rowsInsert > 0) {
                System.out.println(" Inserción exitosa !");
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }

    /**
     * Ejecuta un update que actualiza los valores de un rol en base datos
     *
     * @param rol
     */
    public void actualizarRol(RolModel rol) {

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "UPDATE roles SET nombre=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, rol.getNombre());
            statement.setInt(2, rol.getId());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("El registro fue actualizado exitosamente !");
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    /**
     * Ejecuta un delete que elimina un rol en base de datos
     *
     * @param id
     */
    public void eliminarRol(int id) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "DELETE from roles WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("El registro fue eliminado exitosamente !");
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
}
