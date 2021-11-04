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
import java.util.ArrayList;
import java.util.List;
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
    private String hora;
    
    private final Conexion con;
    private PreparedStatement consulta;
    private ResultSet resp;
    private boolean flag;

    public DHorariosServicios() {
        this.con = Conexion.getInstancia();
    }

    public DHorariosServicios(int id, int idServicio, int idHorario, String detalle, String estado, int idDoctor, String nombreServicio, String nombreDoctor, Date fecha, String hora) {
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

    public DHorariosServicios(int id, String nombreServicio, Date fecha, String hora, String nombreDoctor) {
        this.id = id;
        this.nombreServicio = nombreServicio;
        this.fecha = fecha;
        this.hora = hora;
        this.nombreDoctor = nombreDoctor;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public List<DHorariosServicios> listar(){
        List<DHorariosServicios> registros = new ArrayList<>();
        try {
            consulta = con.conectar().prepareStatement("SELECT horarioservicio.id, servicio.nombre as servicio, horario.fecha, horario.hora, doctor.nombre as doctor FROM public.horarioservicio inner join public.horario on horarioservicio.fk_horario_id = horario.id inner join public.servicio on horarioservicio.fk_servicio_id = servicio.id inner join public.doctor on horarioservicio.fk_doctor_id = doctor.id");
            resp = consulta.executeQuery();
            while(resp.next()){
                registros.add(new DHorariosServicios(resp.getInt(1), resp.getString(2), resp.getDate(3), resp.getString(4), resp.getString(5)));
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
