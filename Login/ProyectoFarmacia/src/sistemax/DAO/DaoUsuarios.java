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
import sistemax.Identidades.Usuarios;

/**
 *
 * @author BENAVIDES
 */
public class DaoUsuarios extends Conexion implements CrudUsuario{

    PreparedStatement ps; //Para sentencia sql
    ResultSet rs;
    Usuarios p;
    int res;
    
    @Override
    public ArrayList<Usuarios> mostrar() throws ClassNotFoundException, SQLException {
        ArrayList<Usuarios> ar = new ArrayList<Usuarios>();
        
        try 
        {
            ps=super.con().prepareStatement("select * from usuarios");
            rs=ps.executeQuery();
            
        while(rs.next())
            {
                p=new Usuarios(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6),rs.getInt(7) );
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
    public int agregarUsuarios(Usuarios p)throws ClassNotFoundException,SQLException{
         try 
        {
            ps=super.con().prepareStatement("Insert into "+
                    "usuarios(usuario,password,nombre,correo,last_session,id_tipo) value (?,?,?,?,?,?)");
            
            ps.setString(1,p.getUsuario());
            ps.setString(2,p.getPassword());
            ps.setString(3,p.getNombre());
            ps.setString(4,p.getCorreo());
            ps.setString(5,p.getLast_session());
            ps.setInt(6,p.getId_tipo());
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
    public int modificarUsuarios(Usuarios p)throws ClassNotFoundException,SQLException{
        try 
        {
            ps=super.con().prepareStatement("update "
                    + "usuarios set usuario=?,password=?,nombre=?,correo=?,last_session=?,id_tipo=?"
                    + "where id=?");
            
            ps.setString(1,p.getUsuario());
            ps.setString(2,p.getPassword());
            ps.setString(3,p.getNombre());
            ps.setString(4,p.getCorreo());
            ps.setString(5,p.getLast_session());
            ps.setInt(6,p.getId_tipo());
            ps.setInt(7, p.getId());
            
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
    public int eliminarUsuarios(Usuarios p)throws ClassNotFoundException,SQLException{
        try 
        {
            ps=super.con().prepareStatement("delete from "+
                    "usuarios where id=? ");
            
           ps.setInt(1, p.getId());
            
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
