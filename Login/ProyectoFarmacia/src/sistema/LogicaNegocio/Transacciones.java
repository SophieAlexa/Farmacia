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
import sistemax.Identidades.Producto;


/**
 *
 * @author BENAVIDES
 */
public class Transacciones {
    
   
    Producto p;
    int res=0;
    DaoProductos ob=new DaoProductos();    
    
    public DefaultTableModel mostrar()
    {
        ArrayList<Producto> ar=new ArrayList<Producto>();
        DefaultTableModel tm;
        String[] title={"id_productos","nombre_producto","fecha_recivido","fecha_vencimiento","id_proveedor","id"};
        tm= new DefaultTableModel(title,0);
        
        try 
        {
            ar.addAll(ob.mostrar());
            Object[] vec= new Object[6];
            
            for(Producto v:ar)
            {
                vec[0]=v.getId_productos();
                vec[1]=v.getNombre_producto();
                vec[2]=v.getFecha_recibido();
                vec[3]=v.getFecha_vencimiento();
                vec[4]=v.getId_proveedor();
                vec[5]=v.getId();
                
                tm.addRow(vec);
            }
        } 
        catch (Exception e) 
        {
            
        }
        return tm;
    }
    
    public void agregar(String nombre_producto, String fecha_recibido, String fecha_vencimiento, String id_proveedor, String id)
    {
        try 
        {
            p=new Producto(nombre_producto, fecha_recibido, fecha_vencimiento, Integer.parseInt(id_proveedor), Integer.parseInt(id));
            res=ob.agregarProducto(p);
            
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
    
    
     public void modificar(String id_productos, String nombre_producto, String fecha_recibido, String fecha_vencimiento, String id_proveedor, String id)
    {
        try 
        {
            p=new Producto(Integer.valueOf(id_productos), nombre_producto, fecha_recibido, fecha_vencimiento, Integer.valueOf(id_proveedor), Integer.valueOf(id));
            res=ob.modificarProducto(p);
            
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
     
      public void eliminar(String id_productos)
    {
        try 
        {
            p=new Producto(Integer.parseInt(id_productos));
            res=ob.eliminarProducto(p);
            
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
      
      
      public void mostrarReporteProductos()
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
              reporte = JasperCompileManager.compileReport("src/Reportes/ReporteProductos.jrxml");
              JasperPrint jp= JasperFillManager.fillReport(reporte,null,conexion);
              JasperViewer.viewReport(jp,false);
          } 
          catch (Exception e) 
          {
              JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Realizar la conexion",1);
          }
      }      
      
       public String[] llenarA(String escuela)
    {
        String[] alumno = new String[2];
        
        if(escuela.equalsIgnoreCase("Computacion"))
        {
            alumno[0] = "Sistemas";
            alumno[1] = "Redes";
        }
        
        if(escuela.equalsIgnoreCase("Alimentos"))
        {
            alumno[0] = "Gastronomia";
            alumno[1] = "Administracion";
        }
        
        if(escuela.equalsIgnoreCase("Mecatronica"))
        {
            alumno[0] = "Mecatronica1";
            alumno[1] = "Mecatronica2";
        }
        
        return alumno;
    } 
}
