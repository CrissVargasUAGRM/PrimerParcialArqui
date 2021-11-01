
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
public class DDoctor {
    private int id;
    private int especialidadId;
    private String especialidadNombre;
    private String nombre;
    private String nacimiento;
    private String profesion;
    private String matricula;
    private int telefono;
    private String email;
    private int ci;
    private String direccion;
    private final Conexion con;
    private PreparedStatement consulta;
    private ResultSet resp;
    private boolean flag;

    public DDoctor() {
        this.con = Conexion.getInstancia();
    }

    public DDoctor(int id, int especialidadId, String nombre, String nacimiento, String profesion, String matricula, int telefono, String email, int ci, String direccion, String especialidadNombre) {
        this.id = id;
        this.especialidadId = especialidadId;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.profesion = profesion;
        this.matricula = matricula;
        this.telefono = telefono;
        this.email = email;
        this.ci = ci;
        this.direccion = direccion;
        this.especialidadNombre = especialidadNombre;
        this.con = Conexion.getInstancia();
    }

    public DDoctor(int id, String nombre) {
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

    public int getEspecialidadId() {
        return especialidadId;
    }

    public void setEspecialidadId(int especialidadId) {
        this.especialidadId = especialidadId;
    }

    public String getEspecialidadNombre() {
        return especialidadNombre;
    }

    public void setEspecialidadNombre(String especialidadNombre) {
        this.especialidadNombre = especialidadNombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<DDoctor> listar(){
        List<DDoctor> registros = new ArrayList<>();
        try {
            consulta = con.conectar().prepareStatement("SELECT doctor.id, especialidad.id, doctor.nombre, nacimiento, profesion, matricula, telefono, email, ci, direccion, especialidad.nombre as especialidad FROM public.doctor inner join public.especialidad on especialidad.id = doctor.fk_especialidad_id");
            resp = consulta.executeQuery();
            while(resp.next()){
                registros.add(new DDoctor(resp.getInt(1), resp.getInt(2), resp.getString(3), resp.getString(4), resp.getString(5), resp.getString(6), resp.getInt(7), resp.getString(8), resp.getInt(9), resp.getString(10), resp.getString(11)));
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
    
    public boolean insertar(String nombre, String profesion, int telefono, String email, int ci, String direccion, int fk_especialidad_id){
        flag = false;
        try {
            consulta = con.conectar().prepareStatement("INSERT INTO public.doctor(nombre, nacimiento, profesion, matricula, telefono, email, ci, direccion, fk_especialidad_id) VALUES (?, '1995-02-21', ?, ?, ?, ?, ?, ?, ?)");
            consulta.setString(1, nombre);
            consulta.setString(2, profesion);
            consulta.setString(3, "VET-888");
            consulta.setInt(4, telefono);
            consulta.setString(5, email);
            consulta.setInt(6, ci);
            consulta.setString(7, direccion);
            consulta.setInt(8, fk_especialidad_id);
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
    
    public boolean editar(String nombre, String profesion, int telefono, String email, int ci, String direccion, int fk_especialidad_id, int idDoctor){
        flag = false;
        try {
            consulta = con.conectar().prepareStatement("UPDATE public.doctor SET nombre=?, profesion=?, telefono=?, email=?, ci=?, direccion=?, fk_especialidad_id=? WHERE doctor.id = ?");
            consulta.setString(1, nombre);
            consulta.setString(2, profesion);
            consulta.setInt(3, telefono);
            consulta.setString(4, email);
            consulta.setInt(5, ci);
            consulta.setString(6, direccion);
            consulta.setInt(7, fk_especialidad_id);
            consulta.setInt(8, idDoctor);
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
    
    public boolean eliminar(int idDoctor){
        flag = false;
        try {
            consulta = con.conectar().prepareStatement("DELETE FROM public.doctor WHERE doctor.id = ?");
            consulta.setInt(1, idDoctor);
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
    
    
    
    /*public static void main(String[] args) {
        DDoctor lista = new DDoctor();
        System.out.println(lista.listar());
        for (int i = 0; i < lista.listar().size(); i++) {
            System.out.println(lista.listar().get(i).getEspecialidadId());
        }
    }*/

    @Override
    public String toString() {
        return nombre;
    }
}
