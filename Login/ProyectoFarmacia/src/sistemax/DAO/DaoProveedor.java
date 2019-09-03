/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemax.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sistemax.Identidades.Producto;
import sistemax.Identidades.Proveedor;

/**
 *
 * @author BENAVIDES
 */
public class DaoProveedor extends Conexion implements CrudProveedor {

    PreparedStatement ps; //Para sentencia sql
    ResultSet rs;
    Proveedor p;
    int res;
    
    @Override
    public ArrayList<Proveedor> mostrar() throws ClassNotFoundException, SQLException {
        ArrayList<Proveedor> ar = new ArrayList<Proveedor>();
        
        try 
        {
            ps=super.con().prepareStatement("select * from proveedores");
            rs=ps.executeQuery();
            
        while(rs.next())
            {
                p=new Proveedor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                ar.add(p);
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            super.con().close();
        }
        
        return ar;
    }

    @Override
    public int agregarProveedor(Proveedor p) throws ClassNotFoundException, SQLException {
        try 
        {
            ps=super.con().prepareStatement("Insert into "+
                    "proveedores(nombre,telefono,direccion) value (?,?,?)");
            
            ps.setString(1,p.getNombre());
            ps.setString(2,p.getTelefono());
            ps.setString(3,p.getDireccion());
            
            res=ps.executeUpdate();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            super.con().close();
        }
        
        return res;
    }

    @Override
    public int modificarProveedor(Proveedor p) throws ClassNotFoundException, SQLException {
        try 
        {
            ps=super.con().prepareStatement("update "
                    + "proveedores set nombre=?,telefono=?,direccion=? "
                    + "where id_proveedor=?");
            
            ps.setString(1,p.getNombre());
            ps.setString(2,p.getTelefono());
            ps.setString(3,p.getDireccion());
            ps.setInt(4, p.getId_proveedor());
            
            res=ps.executeUpdate();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            super.con().close();
        }
        
         return res;
    }

    @Override
    public int eliminarProveedor(Proveedor p) throws ClassNotFoundException, SQLException {
        try 
        {
            ps=super.con().prepareStatement("delete from "+
                    "proveedores where id_proveedor=? ");
            
           ps.setInt(1, p.getId_proveedor());
            
            res=ps.executeUpdate();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            super.con().close();
        }
        
        return res;
    }
    
    
}
