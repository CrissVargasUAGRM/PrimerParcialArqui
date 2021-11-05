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
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian Vargas
 */
public class DReserva {
    private int id;
    private String detalle;
    private int idCliente;
    private int idHorarioServicio;
    private String clienteNombre;
    private Date fecha;
    private String hora;
    private String servicio;
    private PreparedStatement consulta;
    private ResultSet resp;
    private boolean flag;
    private final Conexion con;

    public DReserva() {
        this.con = Conexion.getInstancia();
    }

    public DReserva(int id, String detalle, int idCliente, int idHorarioServicio) {
        this.id = id;
        this.detalle = detalle;
        this.idCliente = idCliente;
        this.idHorarioServicio = idHorarioServicio;
        this.con = Conexion.getInstancia();
    }

    public DReserva(int id, String detalle, String clienteNombre, Date fecha, String hora, String servicio) {
        this.id = id;
        this.detalle = detalle;
        this.clienteNombre = clienteNombre;
        this.fecha = fecha;
        this.hora = hora;
        this.servicio = servicio;
        this.con = Conexion.getInstancia();
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdHorarioServicio() {
        return idHorarioServicio;
    }

    public void setIdHorarioServicio(int idHorarioServicio) {
        this.idHorarioServicio = idHorarioServicio;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
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

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    
        public List<DReserva> listar(){
        List<DReserva> registros = new ArrayList<>();
        try {
            consulta = con.conectar().prepareStatement("SELECT reserva.id, reserva.detalle, cliente.nombre as cliente, horario.fecha, horario.hora, servicio.nombre as servicio FROM public.reserva inner join public.cliente on reserva.fk_cliente_id = cliente.id inner join public.horarioservicio on reserva.fk_horarioservicio_id = horarioservicio.id inner join public.horario on horarioservicio.fk_horario_id = horario.id inner join public.servicio on horarioservicio.fk_servicio_id = servicio.id");
            resp = consulta.executeQuery();
            while(resp.next()){
                registros.add(new DReserva(resp.getInt(1), resp.getString(2), resp.getString(3), resp.getDate(4), resp.getString(5), resp.getString(6)));
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
        
    public boolean insertar(String detalle, int idCliente, int idHorarioServicio){
        flag = false;
        try {
            consulta = con.conectar().prepareStatement("INSERT INTO public.reserva(detalle, fk_cliente_id, fk_horarioservicio_id)VALUES (?, ?, ?)");
            consulta.setString(1, detalle);
            consulta.setInt(2, idCliente);
            consulta.setInt(3, idHorarioServicio);
            if(consulta.executeUpdate()> 0){
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
