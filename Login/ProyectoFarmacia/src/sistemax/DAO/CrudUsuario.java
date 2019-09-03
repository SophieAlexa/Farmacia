/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemax.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import sistemax.Identidades.Usuarios;

/**
 *
 * @author BENAVIDES
 */
public interface CrudUsuario {
    
    public ArrayList<Usuarios> mostrar() throws ClassNotFoundException,SQLException;
    public int agregarUsuarios(Usuarios p)throws ClassNotFoundException,SQLException;
    public int modificarUsuarios(Usuarios p)throws ClassNotFoundException,SQLException;
    public int eliminarUsuarios(Usuarios p)throws ClassNotFoundException,SQLException;
    
}
