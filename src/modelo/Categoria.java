/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Breyner
 */
public class Categoria {

    private int id;
    private String denominacion;

    public Categoria(int id, String denominacion) {
        this.id = id;
        this.denominacion = denominacion;
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
