/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

import database.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Christian Vargas
 */
public class DPaciente {
    private int id;
    private String nombre;
    private String edad;
    private String especie;
    private String raza;
    private int idDoctor;
    private int idCliente;
    private String doctorNombre;
    private String clienteNombre;
    private PreparedStatement consulta;
    private ResultSet resp;
    private boolean flag;
    private final Conexion con;

    public DPaciente() {
        this.con = Conexion.getInstancia();
    }

    public DPaciente(int id, String nombre, String edad, String especie, String raza, int idDoctor, int idCliente, String doctorNombre, String clienteNombre) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
        this.raza = raza;
        this.idDoctor = idDoctor;
        this.idCliente = idCliente;
        this.doctorNombre = doctorNombre;
        this.clienteNombre = clienteNombre;
        this.con = Conexion.getInstancia();
    }

    public DPaciente(int id, String nombre, String edad, String especie, String raza, String doctorNombre, String clienteNombre) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
        this.raza = raza;
        this.doctorNombre = doctorNombre;
        this.clienteNombre = clienteNombre;
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDoctorNombre() {
        return doctorNombre;
    }

    public void setDoctorNombre(String doctorNombre) {
        this.doctorNombre = doctorNombre;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public List<DPaciente> listar(){
        List<DPaciente> registros = new ArrayList<>();
        try {
            consulta = con.conectar().prepareStatement("SELECT paciente.id, paciente.nombre, edad, especie, raza, doctor.nombre as doctor, cliente.nombre as cliente FROM public.paciente inner join public.doctor on paciente.fk_doctor_id = doctor.id inner join public.cliente on paciente.fk_cliente_id = cliente.id");
            resp = consulta.executeQuery();
            while(resp.next()){
                registros.add(new DPaciente(resp.getInt(1), resp.getString(2), resp.getString(3), resp.getString(4), resp.getString(5), resp.getString(6), resp.getString(7)));
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
    
    public boolean insertar(String nombre, String edad, String especie, String raza, int idDoctor, int idCliente){
        flag = false;
        try {
            consulta = con.conectar().prepareStatement("INSERT INTO public.paciente(nombre, edad, especie, raza, fk_doctor_id, fk_cliente_id)VALUES (?, ?, ?, ?, ?, ?)");
            consulta.setString(1, nombre);
            consulta.setString(2, edad);
            consulta.setString(3, especie);
            consulta.setString(4, raza);
            consulta.setInt(5, idDoctor);
            consulta.setInt(6, idCliente);
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
    
    public boolean editar(String nombre, String edad, String especie, String raza, int idDoctor, int idCliente, int id){
        flag = false;
        try {
            consulta = con.conectar().prepareStatement("UPDATE public.paciente SET nombre=?, edad=?, especie=?, raza=?, fk_doctor_id=?, fk_cliente_id=? WHERE paciente.id = ?");
            consulta.setString(1, nombre);
            consulta.setString(2, edad);
            consulta.setString(3, especie);
            consulta.setString(4, raza);
            consulta.setInt(5, idDoctor);
            consulta.setInt(6, idCliente);
            consulta.setInt(7, id);
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

    public boolean eliminar(int idPaciente){
        flag = false;
        try {
            consulta = con.conectar().prepareStatement("DELETE FROM public.paciente WHERE paciente.id = ?");
            consulta.setInt(1, idPaciente);
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
