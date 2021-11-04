
package Negocio;

import Dato.DEspecialidad;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Christian Vargas
 */
public class NEspecilidad {
    private DEspecialidad DATOS;
    private DefaultTableModel modeloTabla;

    public NEspecilidad() {
        this.DATOS = new DEspecialidad();
    }

    public DefaultTableModel listar(){
        List<DEspecialidad> lista = new ArrayList<>();
        lista.addAll(DATOS.listar());
        
        String[] titulos = {"Nro","Nombre","Descripcion","Area"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String[] registros = new String[4];
        
        for (DEspecialidad item : lista) {
            registros[0] = Integer.toString(item.getId());
            registros[1] = item.getNombre();
            registros[2] = item.getDescripcion();
            registros[3] = item.getArea();
            this.modeloTabla.addRow(registros);
        }
        
        return this.modeloTabla;
    }
    
    public String insertar(String nombre, String descripcion, String area){
        DATOS.setNombre(nombre);
        DATOS.setDescripcion(descripcion);
        DATOS.setArea(area);
        if(DATOS.registrar(nombre, descripcion, area)){
            return "OK";
        }else{
            return "Error al registrar";
        }
    }
    
    public String editar(int id, String nombre, String descripcion, String area){
        DATOS.setId(id);
        DATOS.setNombre(nombre);
        DATOS.setDescripcion(descripcion);
        DATOS.setArea(area);
        if(DATOS.editar(id, nombre, descripcion, area)){
            return "OK";
        }else{
            return "Error al editar";
        }
    }
    
    public String eliminar(int id){
        DATOS.setId(id);
        if(DATOS.eliminar(id)){
            return "OK";
        }else{
            return "Error al eliminar";
        }
    }
    
        public DefaultComboBoxModel especialidades(){
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<DEspecialidad> lista = new ArrayList<>();
        lista = DATOS.listar();
        for (DEspecialidad item : lista) {
            items.addElement(new DEspecialidad(item.getId(), item.getNombre(), item.getDescripcion(), item.getArea()));
        }
        return items;
    }
}
