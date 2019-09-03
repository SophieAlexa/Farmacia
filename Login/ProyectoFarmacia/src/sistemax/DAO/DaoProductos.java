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

/**
 *
 * @author BENAVIDES
 */
public class DaoProductos extends Conexion implements CrudProducto{
    
    PreparedStatement ps; //Para sentencia sql
    ResultSet rs;
    Producto p;
    int res;
    
    @Override
    public ArrayList<Producto> mostrar() throws ClassNotFoundException, SQLException {
        ArrayList<Producto> ar = new ArrayList<Producto>();
        
        try 
        {
            ps=super.con().prepareStatement("select * from productos");
            rs=ps.executeQuery();
            
        while(rs.next())
            {
                p=new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6) );
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
    public int agregarProducto(Producto p) throws ClassNotFoundException, SQLException {
         try 
        {
            ps=super.con().prepareStatement("Insert into "+
                    "productos(nombre_producto,fecha_recibido,fecha_vencimiento,id_proveedor,id) value (?,?,?,?,?)");
            
            ps.setString(1,p.getNombre_producto());
            ps.setString(2,p.getFecha_recibido());
            ps.setString(3,p.getFecha_vencimiento());
            ps.setInt(4,p.getId_proveedor());
            ps.setInt(5,p.getId());
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
    public int modificarProducto(Producto p) throws ClassNotFoundException, SQLException {
        try 
        {
            ps=super.con().prepareStatement("update "
                    + "productos set nombre_producto=?,fecha_recibido=?,fecha_vencimiento=?,id_proveedor=?,id=?"
                    + "where id_productos=?");
            
            ps.setString(1,p.getNombre_producto());
            ps.setString(2,p.getFecha_recibido());
            ps.setString(3,p.getFecha_vencimiento());
            ps.setInt(4,p.getId_proveedor());
            ps.setInt(5,p.getId());
            
            ps.setInt(6, p.getId_productos());
            
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
    public int eliminarProducto(Producto p) throws ClassNotFoundException, SQLException {
        try 
        {
            ps=super.con().prepareStatement("delete from "+
                    "productos where id_productos=? ");
            
           ps.setInt(1, p.getId_productos());
            
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