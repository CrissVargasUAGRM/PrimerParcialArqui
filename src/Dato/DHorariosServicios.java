/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

import database.Conexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian Vargas
 */
public class DHorariosServicios {
    private int id;
    private int idServicio;
    private int idHorario;
    private String detalle;
    private String estado;
    private int idDoctor;
    private String nombreServicio;
    private String nombreDoctor;
    private Date fecha;
    private Time hora;
    
    private final Conexion con;
    private PreparedStatement consulta;
    private ResultSet resp;
    private boolean flag;

    public DHorariosServicios() {
        this.con = Conexion.getInstancia();
    }

    public DHorariosServicios(int id, int idServicio, int idHorario, String detalle, String estado, int idDoctor, String nombreServicio, String nombreDoctor, Date fecha, Time hora) {
        this.id = id;
        this.idServicio = idServicio;
        this.idHorario = idHorario;
        this.detalle = detalle;
        this.estado = estado;
        this.idDoctor = idDoctor;
        this.nombreServicio = nombreServicio;
        this.nombreDoctor = nombreDoctor;
        this.fecha = fecha;
        this.hora = hora;
        this.con = Conexion.getInstancia();
    }

    public DHorariosServicios(int idServicio, String detalle, int idDoctor) {
        this.idServicio = idServicio;
        this.detalle = detalle;
        this.idDoctor = idDoctor;
        this.con = Conexion.getInstancia();
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
    
    public boolean cambiarEstado(int id){
        flag = false;
        try {
            consulta = con.conectar().prepareStatement("UPDATE public.horarioservicio SET estado='inactivo' WHERE horarioservicio.id = ?");
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
}
