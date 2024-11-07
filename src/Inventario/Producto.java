/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventario;

/**
 *
 * @author Kevin Russo Emiliany
 */
public class Producto {
    public int cantidad,precio;
    public String nombre, descripcion;

    public Producto(String nombre, int precio, int cantidad,  String descripcion) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Producto{" + "cantidad=" + cantidad + ", precio=" + precio + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
}
