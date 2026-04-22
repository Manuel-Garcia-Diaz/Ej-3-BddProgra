/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dam
 */
//una clase con la estructura del registro por cada una de las tablas que forman la base de datos
public class listaModelos {
    int codigoLista;
    int codigoProducto;
    int cantidad;

    public listaModelos(int codigoLista, int codigoProducto, int cantidad) {
        this.codigoLista = codigoLista;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
    }

    public int getCodigoLista() {
        return codigoLista;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    
    
}
