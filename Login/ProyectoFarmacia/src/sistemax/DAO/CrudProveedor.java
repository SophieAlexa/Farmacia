/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemax.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import sistemax.Identidades.Proveedor;

/**
 *
 * @author BENAVIDES
 */
public interface CrudProveedor {
    
    public ArrayList<Proveedor> mostrar() throws ClassNotFoundException,SQLException;
    public int agregarProveedor(Proveedor p)throws ClassNotFoundException,SQLException;
    public int modificarProveedor(Proveedor p)throws ClassNotFoundException,SQLException;
    public int eliminarProveedor(Proveedor p)throws ClassNotFoundException,SQLException;
    
}
