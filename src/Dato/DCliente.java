/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

import database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian Vargas
 */
public class DCliente {
    private int id;
    private String nombre;
    private String direccion;
    private int telefono;
    private final Conexion con;
    private PreparedStatement consulta;
    private ResultSet resp;
    private boolean flag;

    public DCliente() {
        this.con = Conexion.getInstancia();
    }

    public DCliente(int id, String nombre, String direccion, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.con = Conexion.getInstancia();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public List<DCliente> listar(){
        List<DCliente> registros = new ArrayList<>();
        try {
            consulta = con.conectar().prepareStatement("SELECT * FROM public.cliente ORDER BY id ASC ");
            
            resp = consulta.executeQuery();
            while(resp.next()){
                registros.add(new DCliente(resp.getInt(1), resp.getString(2), resp.getString(3), resp.getInt(4)));
            }
            consulta.close();
            resp.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            consulta = null;
            resp = null;
            con.desconectar();
        }
        return registros;
    }
    
    public boolean insertar(String nombre, String direccion, int telefono){
        flag = false;
        try {
            consulta = con.conectar().prepareStatement("INSERT INTO public.cliente(nombre, direccion, telefono)VALUES (?, ?, ?)");
            consulta.setString(1, nombre);
            consulta.setString(2, direccion);
            consulta.setInt(3, telefono);
            if(consulta.executeUpdate() > 0){
                flag = true;
            }
            consulta.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            consulta = null;
            con.desconectar();
        }
        return flag;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
