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
public class DServicio {
    private int id;
    private String inicial;
    private String nombre;
    private String descripcion;
    private int fk_categoria_id;
    private String CatNombre;
    private final Conexion con;
    private PreparedStatement consulta;
    private ResultSet resp;
    private boolean flag;

    public DServicio() {
        this.con = Conexion.getInstancia();
    }

    public DServicio(int id, String inicial, String nombre, String descripcion, int fk_categoria_id, String CatNombre ){
        this.id = id;
        this.inicial = inicial;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fk_categoria_id = fk_categoria_id;
        this.CatNombre = CatNombre;
        this.con = Conexion.getInstancia();
    }

    public DServicio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.con = Conexion.getInstancia();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInicial() {
        return inicial;
    }

    public void setInicial(String inicial) {
        this.inicial = inicial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFk_categoria_id() {
        return fk_categoria_id;
    }

    public void setFk_categoria_id(int fk_categoria_id) {
        this.fk_categoria_id = fk_categoria_id;
    }

    public String getCatNombre() {
        return CatNombre;
    }

    public void setCatNombre(String CatNombre) {
        this.CatNombre = CatNombre;
    }
    
    public List<DServicio> listar(){
        List<DServicio> registros = new ArrayList<>();
        try {
            consulta = con.conectar().prepareStatement("SELECT servicio.id, inicial, servicio.nombre, servicio.descripcion, categoria.id as idCat, categoria.nombre as categoria FROM public.servicio inner join public.categoria on categoria.id = servicio.fk_categoria_id");
            resp = consulta.executeQuery();
            while(resp.next()){
                registros.add(new DServicio(resp.getInt(1), resp.getString(2), resp.getString(3), resp.getString(4), resp.getInt(5), resp.getString(6)));
                
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
    
    public boolean insertar(String nombre, String descripcion, int idCat){
        flag = false;
        try {
            consulta = con.conectar().prepareStatement("INSERT INTO public.servicio(inicial, nombre, descripcion, fk_categoria_id) VALUES ('VET', ?, ?, ?)");
            consulta.setString(1, nombre);
            consulta.setString(2, descripcion);
            consulta.setInt(3, idCat);
            if(consulta.executeUpdate() > 0){
                flag = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            consulta = null;
            resp = null;
            con.desconectar();
        }
        return flag;
    }
    
    public boolean editar(String nombre, String descripcion, int idCat, int id){
        flag = false;
        try {
            consulta = con.conectar().prepareStatement("UPDATE public.servicio SET nombre=?, descripcion=?, fk_categoria_id=? WHERE servicio.id = ?;");
            consulta.setString(1, nombre);
            consulta.setString(2, descripcion);
            consulta.setInt(3, idCat);
            consulta.setInt(4, id);
            if(consulta.executeUpdate() > 0){
                flag = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            consulta = null;
            resp = null;
            con.desconectar();
        }
        return flag;
    }
    
    public boolean eliminar(int id){
        flag = false;
        try {
            consulta = con.conectar().prepareStatement("DELETE FROM public.servicio WHERE servicio.id = ?");
            consulta.setInt(1, id);
            if(consulta.executeUpdate() > 0){
                flag = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            consulta = null;
            resp = null;
            con.desconectar();
        }
        return flag;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
