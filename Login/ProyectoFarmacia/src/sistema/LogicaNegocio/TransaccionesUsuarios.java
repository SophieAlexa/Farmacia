/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.LogicaNegocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import sistemax.DAO.DaoProductos;
import sistemax.DAO.DaoUsuarios;
import sistemax.Identidades.Usuarios;

/**
 *
 * @author BENAVIDES
 */
public class TransaccionesUsuarios {
    
    Usuarios p;
    int res=0;
    DaoUsuarios ob=new DaoUsuarios();    
    
    public DefaultTableModel mostrar()
    {
        ArrayList<Usuarios> ar=new ArrayList<Usuarios>();
        DefaultTableModel tm;
        String[] title={"id","usuario","password","nombre","correo","last_session","id_tipo"};
        tm= new DefaultTableModel(title,0);
        
        try 
        {
            ar.addAll(ob.mostrar());
            Object[] vec= new Object[7];
            
            for(Usuarios v:ar)
            {
                vec[0]=v.getId();
                vec[1]=v.getUsuario();
                vec[2]=v.getPassword();
                vec[3]=v.getNombre();
                vec[4]=v.getCorreo();
                vec[5]=v.getLast_session();
                vec[6]=v.getId_tipo();
                
                tm.addRow(vec);
            }
        } 
        catch (Exception e) 
        {
            
        }
        return tm;
    }
    
    public void agregar(String usuario, String password, String nombre, String correo, String last_session, String id_tipo)
    {
        try 
        {
            p=new Usuarios(usuario, password, nombre, correo, last_session, Integer.parseInt(id_tipo));
            res=ob.agregarUsuarios(p);
            
            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Registro Ingresado Correctamente");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Registro NO Ingresado Correctamente");
            }
        } 
        catch (Exception e) 
        {
            
        }
    }
    
    
     public void modificar(String id, String usuario, String password, String nombre, String correo, String last_session, String id_tipo)
    {
        try 
        {
            p=new Usuarios(Integer.valueOf(id), usuario, password, nombre, correo, last_session, Integer.valueOf(id_tipo));
            res=ob.modificarUsuarios(p);
            
            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado Correctamente");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El Registro NO se Modifico Correctamente");
            }
        } 
        catch (Exception e) 
        {
            
        }
    }
     
      public void eliminar(String id)
    {
        try 
        {
            p=new Usuarios(Integer.parseInt(id));
            res=ob.eliminarUsuarios(p);
            
            if(res>0)
            {
                JOptionPane.showMessageDialog(null, "Registro eliminado Correctamente");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El Registro NO se Elimino Correctamente");
            }
        } 
        catch (Exception e) 
        {
            
        }
    }
      
      
      public void mostrarReporteUsuarios()
      {
          Connection conexion=null;
          JasperReport reporte;
          
          try 
          {
              Class.forName("com.mysql.jdbc.Driver");
              conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/farmacia",
                      "root","");
              
          } 
          catch (SQLException | ClassNotFoundException e) 
          {
              JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Realizar la conexion",1);
          }
          
          try 
          {
              reporte = JasperCompileManager.compileReport("src/Reportes/ReporteUsuarios.jrxml");
              JasperPrint jp= JasperFillManager.fillReport(reporte,null,conexion);
              JasperViewer.viewReport(jp,false);
          } 
          catch (Exception e) 
          {
              JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Realizar la conexion",1);
          }
      }      
      
      
    public String[] llenarUsuario(String cc)
    {
        String[] carrera = new String[1];
        
        if(cc.equalsIgnoreCase("Selecciona"))
        {
            carrera[0] = "";
            
        }
        
        if(cc.equalsIgnoreCase("Administrador"))
        {
            carrera[0] = "1";
            
        }
        
        if(cc.equalsIgnoreCase("Usuario"))
        {
            carrera[0] = "2";
            
        }
        
      
        
        return carrera;
    } 
      
}
