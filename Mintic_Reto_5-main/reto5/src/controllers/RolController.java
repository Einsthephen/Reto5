/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import access.RolDAO;
import java.util.List;
import models.RolModel;

/**
 *
 * @author yinna - Puente entre la vista y las acciones que puede ejecutar de
 * base de datos (RolDAO)
 */
public class RolController {

    private RolDAO rolDAO;

    public RolController() {
        // cuando se cree la clase RolController se va a instanciar el objeto rolDAO
        rolDAO = new RolDAO();
    }

    /**
     * Llama al rolDAO y obtiene una lista de roles
     *
     * @return
     */
    public List<RolModel> obtenerRoles() {
        return rolDAO.obtenerRoles();
    }

    /**
     * Llama al rolDAO y obtiene un rol a partir de un id
     *
     * @param id
     * @return
     */
    public RolModel obtenerRol(int id) {
        return rolDAO.obtenerRol(id);
    }

    /**
     * Llama al rolDAO y agrega un rol a la base de datos
     *
     * @param id
     * @param nombre
     */
    public void agregarRol(int id, String nombre) {
        RolModel rol = new RolModel(id, nombre);
        rolDAO.agregarRol(rol);
    }

    /**
     * Llama al rolDAO y actualizar un rol a partir de su id
     *
     * @param id
     * @param nombre
     */
    public void actualizarRol(int id, String nombre) {
        RolModel rol = new RolModel(id, nombre);
        rolDAO.actualizarRol(rol);
    }

    /**
     * Llma al rolDAO y elimina un rol a partir de su id
     *
     * @param id
     */
    public void eliminarRol(int id) {
        rolDAO.eliminarRol(id);
    }

    /**
     * public static void main(String[] args) {
     *
     * RolDAO rolDao = new RolDAO();
     *
     * //List<RolModel> roles = rolDao.obtenerRoles(); //imprimir(roles);
     * //RolModel rol = new RolModel(3, "Directivo"); //rolDao.agregarRol(rol);
     * //RolModel rol = new RolModel(3, "Directivo nuevo");
     * //rolDao.actualizarRol(rol); //rolDao.eliminarRol(3); RolModel s =
     * rolDao.obtenerRol(2); System.out.println(s.getId() + " " +
     * s.getNombre());
     *
     * }
     *
     * public static void imprimir(List<RolModel> roles) { for (RolModel role :
     * roles) { System.out.println(role.getId() + ", " + role.getNombre()); } }
     *
     */
}
