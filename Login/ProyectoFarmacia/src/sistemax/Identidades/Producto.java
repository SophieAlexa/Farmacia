/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemax.Identidades;

/**
 *
 * @author BENAVIDES
 */
public class Producto {
    
    private int id_productos;
    private String nombre_producto;
    private String fecha_recibido;
    private String fecha_vencimiento;
    private int id_proveedor;
    private int id;

    public Producto() {
    }

    public Producto(int id_productos, String nombre_producto, String fecha_recibido, String fecha_vencimiento, int id_proveedor, int id) {
        this.id_productos = id_productos;
        this.nombre_producto = nombre_producto;
        this.fecha_recibido = fecha_recibido;
        this.fecha_vencimiento = fecha_vencimiento;
        this.id_proveedor = id_proveedor;
        this.id = id;
    }

    public Producto(String nombre_producto, String fecha_recibido, String fecha_vencimiento, int id_proveedor, int id) {
        this.nombre_producto = nombre_producto;
        this.fecha_recibido = fecha_recibido;
        this.fecha_vencimiento = fecha_vencimiento;
        this.id_proveedor = id_proveedor;
        this.id = id;
    }

    public Producto(int id_productos) {
        this.id_productos = id_productos;
    }

    public int getId_productos() {
        return id_productos;
    }

    public void setId_productos(int id_productos) {
        this.id_productos = id_productos;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getFecha_recibido() {
        return fecha_recibido;
    }

    public void setFecha_recibido(String fecha_recibido) {
        this.fecha_recibido = fecha_recibido;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
