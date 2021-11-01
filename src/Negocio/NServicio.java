
package Negocio;

import Dato.DServicio;
import Dato.DCategoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Christian Vargas
 */
public class NServicio {
    private final DServicio DATOS;
    private final DCategoria DATOSCAT;
    private final DServicio DATOSSERV;
    private DefaultTableModel modeloTabla;

    public NServicio() {
        this.DATOS = new DServicio();
        this.DATOSCAT = new DCategoria();
        this.DATOSSERV = new DServicio();
    }
    
    public DefaultTableModel listar(){
        List<DServicio> lista = new ArrayList<>();
        lista.addAll(DATOS.listar());
        
        String[] titulos = {"id","inicial","nombre","descripcion","idCat","categoria"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String[] registros = new String[6];
        
        for (DServicio item : lista) {
            registros[0] = Integer.toString(item.getId());
            registros[1] = item.getInicial();
            registros[2] = item.getNombre();
            registros[3] = item.getDescripcion();
            registros[4] = Integer.toString(item.getFk_categoria_id());
            registros[5] = item.getCatNombre();
            this.modeloTabla.addRow(registros);
        }
        return this.modeloTabla;
    }
    
    public DefaultComboBoxModel categorias(){
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<DCategoria> lista = new ArrayList<>();
        lista = DATOSCAT.listar();
        for (DCategoria item : lista) {
            items.addElement(new DCategoria(item.getId(), item.getNombre(), item.getDescripcion()));
        }
        return items;
    }
    
    public String insertar(String nombre, String descripcion, int idCat){
        DATOS.setNombre(nombre);
        DATOS.setDescripcion(descripcion);
        DATOS.setId(idCat);
        if(DATOS.insertar(nombre, descripcion, idCat)){
            return "OK";
        }else{
            return "Error al registrar";
        }
    }
    
    public String editar(String nombre, String descripcion, int idCat, int id){
        DATOS.setNombre(nombre);
        DATOS.setDescripcion(descripcion);
        DATOS.setFk_categoria_id(idCat);
        DATOS.setId(id);
        if(DATOS.editar(nombre, descripcion, idCat, id)){
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
    
    public DefaultComboBoxModel servicios(){
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<DServicio> lista = new ArrayList<>();
        lista = DATOSSERV.listar();
        for (DServicio item : lista) {
            items.addElement(new DServicio(item.getId(), item.getNombre()));
        }
        return items;
    }
}
