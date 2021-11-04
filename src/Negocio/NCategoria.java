
package Negocio;

import Dato.DCategoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author Christian Vargas
 */
public class NCategoria {
    private final DCategoria DATOS;

    public NCategoria() {
        this.DATOS = new DCategoria();
    }
    
    public DefaultComboBoxModel categorias(){
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<DCategoria> lista = new ArrayList<>();
        lista = DATOS.listar();
        for (DCategoria item : lista) {
            items.addElement(new DCategoria(item.getId(), item.getNombre(), item.getDescripcion()));
        }
        return items;
    }
    
}
