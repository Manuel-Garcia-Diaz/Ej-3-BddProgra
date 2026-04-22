/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Breyner
 */
public class Lista {

    private int id;
    private String denominacion;

    public Lista(int id, String denominacion) {
        this.id = id;
        this.denominacion = denominacion;
    }

    public int getId() { return id; }
    public String getDenominacion() { return denominacion; }

    @Override
    public String toString() { return denominacion; }
    
}
