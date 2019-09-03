/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemax.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import sistemax.Identidades.Producto;

/**
 *
 * @author BENAVIDES
 */
interface CrudProducto {
    
    public ArrayList<Producto> mostrar() throws ClassNotFoundException,SQLException;
    public int agregarProducto(Producto p)throws ClassNotFoundException,SQLException;
    public int modificarProducto(Producto p)throws ClassNotFoundException,SQLException;
    public int eliminarProducto(Producto p)throws ClassNotFoundException,SQLException;

}
