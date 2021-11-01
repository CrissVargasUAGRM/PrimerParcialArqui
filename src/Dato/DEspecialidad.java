
package Dato;

import database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian Vargas
 */
public class DEspecialidad {
    private int id;
    private String nombre;
    private String descripcion;
    private String area;
    private Conexion m_conexion;
    private PreparedStatement consulta;
    private ResultSet resp;
    private boolean flag;
    

    public DEspecialidad() {
        this.m_conexion = Conexion.getInstancia();
    }

    public DEspecialidad(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public DEspecialidad(int id, String nombre, String descripcion, String area) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.area = area;
        this.m_conexion = Conexion.getInstancia();
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Conexion getM_conexion() {
        return m_conexion;
    }

    public void setM_conexion(Conexion m_conexion) {
        this.m_conexion = m_conexion;
    }
    
    public List<DEspecialidad> listar(){
        List<DEspecialidad> registros = new ArrayList<>();
        try {
            consulta = m_conexion.conectar().prepareStatement("select * from especialidad");
            resp = consulta.executeQuery();
            while(resp.next()){
                registros.add(new DEspecialidad(resp.getInt(1),resp.getString(2),resp.getString(3),resp.getString(4)));
            }
            consulta.close();
            resp.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            consulta = null;
            resp = null;
            m_conexion.desconectar();
        }
        return registros;
    }
    
    public boolean registrar(String nombre, String descripcion,String area){
        flag = false;
        try {
            consulta = m_conexion.conectar().prepareStatement("INSERT INTO public.especialidad(nombre, descripcion, area) VALUES (?, ?, ?)");
            consulta.setString(1, nombre);
            consulta.setString(2, descripcion);
            consulta.setString(3, area);
            if(consulta.executeUpdate() > 0){
                flag = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            consulta = null;
            m_conexion.desconectar();
        }
        return flag;
    }
    
    public boolean editar(int id, String nombre, String descripcion, String area){
        flag = false;
        try {
            consulta = m_conexion.conectar().prepareStatement("UPDATE public.especialidad SET nombre=?, descripcion=?, area=? WHERE especialidad.id = ?");
            consulta.setString(1, nombre);
            consulta.setString(2, descripcion);
            consulta.setString(3, area);
            consulta.setInt(4, id);
            if(consulta.executeUpdate() > 0){
                flag = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            consulta = null;
            m_conexion.desconectar();
        }
        return flag;
    }
    
    public boolean eliminar(int id){
        flag = true;
        try {
            consulta = m_conexion.conectar().prepareStatement("DELETE FROM public.especialidad WHERE especialidad.id = ?");
            consulta.setInt(1, id);
            if(consulta.executeUpdate() > 0){
                flag = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            consulta = null;
            m_conexion.desconectar();
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DEspecialidad other = (DEspecialidad) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    
}
