/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Breyner
 */
public class Producto {

    private int id;
    private String denominacion;
    private int idCategoria;

    public Producto(int id, String denominacion, int idCategoria) {
        this.id = id;
        this.denominacion = denominacion;
        this.idCategoria = idCategoria;
    }

    public int getId() {
        return id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    @Override
    public String toString() {
        return denominacion;
    }
}
