/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author yinna
 */
public class RolModel {

    private int id;

    private String nombre;

    public RolModel() {
    }

    /**
     * Constructor de la clase RolModel
     *
     * @param id
     * @param nombre
     */
    public RolModel(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
