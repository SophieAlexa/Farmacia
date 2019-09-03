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
public class Usuarios {
    
    private int id;
    private String usuario;
    private String password;
    private String nombre;
    private String correo;
    private String last_session;
    private int id_tipo;

    public Usuarios() {
    }

    public Usuarios(int id, String usuario, String password, String nombre, String correo, String last_session, int id_tipo) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.correo = correo;
        this.last_session = last_session;
        this.id_tipo = id_tipo;
    }

    public Usuarios(String usuario, String password, String nombre, String correo, String last_session, int id_tipo) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.correo = correo;
        this.last_session = last_session;
        this.id_tipo = id_tipo;
    }

    public Usuarios(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getLast_session() {
        return last_session;
    }

    public void setLast_session(String last_session) {
        this.last_session = last_session;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }
    
    
    
}
