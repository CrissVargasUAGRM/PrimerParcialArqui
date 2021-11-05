
package Dato;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import database.Conexion;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian Vargas
 */
public class DHorario {
    private int id;
    private Date fecha;
    private String hora;
    private List<DHorariosServicios> horariosServicios;
    
    private final Conexion con;
    private PreparedStatement consulta;
    private ResultSet resp;
    private boolean flag;

    public DHorario() {
        this.con = Conexion.getInstancia();
    }

    public DHorario(int id, Date fecha, String hora, List<DHorariosServicios> horariosServicios) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.horariosServicios = horariosServicios;
        this.con = Conexion.getInstancia();
    }

    public DHorario(int id, Date fecha, String hora) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.con = Conexion.getInstancia();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<DHorariosServicios> getHorariosServicios() {
        return horariosServicios;
    }

    public void setHorariosServicios(List<DHorariosServicios> horariosServicios) {
        this.horariosServicios = horariosServicios;
    }
    
    public List<DHorario> listar(){
        List<DHorario> registros = new ArrayList<>();
        try {
            consulta = con.conectar().prepareStatement("SELECT * FROM public.horario ORDER BY id ASC ");
            resp = consulta.executeQuery();
            while(resp.next()){
                registros.add(new DHorario(resp.getInt(1), resp.getDate(2), resp.getString(3)));
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
    
    public boolean insertar(Date fecha, String hora, List<DHorariosServicios> arreglo){
        flag = false;
        Connection conn = null;
        try {
            conn = con.conectar();
            conn.setAutoCommit(false);
            String sql = "INSERT INTO public.horario(fecha, hora) VALUES (?, ?)";
            consulta = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            consulta.setDate(1, fecha);
            consulta.setString(2, hora);
            
            int filaAfectada = consulta.executeUpdate();
            resp = consulta.getGeneratedKeys();
            int idGenerado = 0;
            if(resp.next()){
                idGenerado = resp.getInt(1);
            }
            
            if(filaAfectada == 1){
                String sql2 = "INSERT INTO public.horarioservicio(fk_servicio_id, fk_horario_id, detalle, estado, fk_doctor_id) VALUES (?, ?, ?, 'activo', ?)";
                consulta = conn.prepareStatement(sql2);
                for(DHorariosServicios item : arreglo){
                    consulta.setInt(1, item.getIdServicio());
                    consulta.setInt(2, idGenerado);
                    consulta.setString(3, item.getDetalle());
                    consulta.setInt(4, item.getIdDoctor());
                    flag = consulta.executeUpdate() > 0;
                }
                conn.commit();
            }else{
                conn.rollback();
            }
       } catch (SQLException e) {
            try {
                if(conn != null){
                   conn.rollback();   
                }
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (SQLException ex) {
                Logger.getLogger(DHorario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }finally{
            try {
                if(resp!=null) resp.close();
                if(consulta!=null) consulta.close();
                if(conn!=null) conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DHorario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return flag;
    }
}
