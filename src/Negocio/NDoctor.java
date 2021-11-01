
package Negocio;

import Dato.DDoctor;
import Dato.DEspecialidad;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian Vargas
 */
public class NDoctor {
    private final DDoctor DATOS;
    private final DEspecialidad DATOSESP;
    private DefaultTableModel modeloTabla;

    public NDoctor() {
        this.DATOS = new DDoctor();
        this.DATOSESP = new DEspecialidad();
    }
    
    public DefaultTableModel listar(){
        List<DDoctor> lista = new ArrayList<>();
        lista.addAll(DATOS.listar());
        
        String[] titulos = {"Id", "IDEspecialidad", "Doctor", "Nacimiento", "Profesion", "Matricula", "Telefono", "Email", "ci", "Direccion", "Especialidad"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String[] registros = new String[11];
        
        for (DDoctor item : lista){
            registros[0] = Integer.toString(item.getId());
            registros[1] = Integer.toString(item.getEspecialidadId());
            registros[2] = item.getNombre();
            registros[3] = item.getNacimiento();
            registros[4] = item.getProfesion();
            registros[5] = item.getMatricula();
            registros[6] = Integer.toString(item.getTelefono());
            registros[7] = item.getEmail();
            registros[8] = Integer.toString(item.getCi());
            registros[9] = item.getDireccion();
            registros[10] = item.getEspecialidadNombre();
            this.modeloTabla.addRow(registros);
        }
        
        return this.modeloTabla;
    }
    
    public String insertar(String nombre, String profesion, int telefono, String email, int ci, String direccion, int fk_especialidad_id){
        DATOS.setNombre(nombre);
        DATOS.setProfesion(profesion);
        DATOS.setTelefono(telefono);
        DATOS.setEmail(email);
        DATOS.setCi(ci);
        DATOS.setDireccion(direccion);
        DATOS.setEspecialidadId(fk_especialidad_id);
        if(DATOS.insertar(nombre, profesion, telefono, email, ci, direccion, fk_especialidad_id)){
            return "OK";
        }else{
            return "Error en el registro.";
        }
    }
    
    public String editar(String nombre, String profesion, int telefono, String email, int ci, String direccion, int fk_especialidad_id, int idDoctor){
        DATOS.setNombre(nombre);
        DATOS.setProfesion(profesion);
        DATOS.setTelefono(telefono);
        DATOS.setEmail(email);
        DATOS.setCi(ci);
        DATOS.setDireccion(direccion);
        DATOS.setEspecialidadId(fk_especialidad_id);
        DATOS.setId(idDoctor);
        if(DATOS.editar(nombre, profesion, telefono, email, ci, direccion, fk_especialidad_id, idDoctor)){
            return "OK";
        }else{
            return "Error en la actualizacion.";
        }
    }
    
    public String eliminar(int idDoctor){
        if(DATOS.eliminar(idDoctor)){
            return "OK";
        }else{
            return "No se pudo eliminar el doctor.";
        }
    }
    
    public DefaultComboBoxModel especialidades(){
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<DEspecialidad> lista = new ArrayList<>();
        lista = DATOSESP.listar();
        for (DEspecialidad item : lista) {
            items.addElement(new DEspecialidad(item.getId(), item.getNombre(), item.getDescripcion(), item.getArea()));
        }
        return items;
    }
    
    public DefaultComboBoxModel doctores(){
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<DDoctor> lista = new ArrayList<>();
        lista = DATOS.listar();
        for (DDoctor item : lista) {
            items.addElement(new DDoctor(item.getId(), item.getNombre()));
        }
        return items;
    }
}
