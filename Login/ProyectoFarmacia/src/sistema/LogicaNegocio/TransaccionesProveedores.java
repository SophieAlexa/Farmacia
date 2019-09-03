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
import sistemax.DAO.DaoProveedor;
import sistemax.Identidades.Producto;
import sistemax.Identidades.Proveedor;

/**
 *
 * @author BENAVIDES
 */
public class TransaccionesProveedores {
    
    
    Proveedor p;
    int res=0;
    DaoProveedor ob=new DaoProveedor();    
    public DefaultTableModel mostrar()
    {
        ArrayList<Proveedor> ar=new ArrayList<Proveedor>();
        DefaultTableModel tm;
        String[] title={"Id","Nombre","Telefono","Direccion"};
        tm= new DefaultTableModel(title,0);
        
        try 
        {
            ar.addAll(ob.mostrar());
            Object[] vec= new Object[4];
            
            for(Proveedor v:ar)
            {
                vec[0]=v.getId_proveedor();
                vec[1]=v.getNombre();
                vec[2]=v.getTelefono();
                vec[3]=v.getDireccion();
                
                tm.addRow(vec);
            }
        } 
        catch (Exception e) 
        {
            
        }
        return tm;
    }
    
    
    public void agregar(String nombre, String telefono, String direccion)
    {
        try 
        {
            p=new Proveedor(nombre, telefono, direccion);
            res=ob.agregarProveedor(p);
            
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
    
    
    public void modificar(String id_proveedor, String nombre, String telefono, String direccion)
    {
        try 
        {
            p=new Proveedor(Integer.valueOf(id_proveedor), nombre,telefono,direccion);
            res=ob.modificarProveedor(p);
            
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
    
    
    public void eliminar(String id_Proveedor)
    {
        try 
        {
            p=new Proveedor(Integer.parseInt(id_Proveedor));
            res=ob.eliminarProveedor(p);
            
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
    
    
    public void mostrarReporteProveedores()
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
              reporte = JasperCompileManager.compileReport("src/Reportes/ReporteProveedores.jrxml");
              JasperPrint jp= JasperFillManager.fillReport(reporte,null,conexion);
              JasperViewer.viewReport(jp,false);
          } 
          catch (Exception e) 
          {
              JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Realizar la conexion",1);
          }
      }      
    
    
    
}
