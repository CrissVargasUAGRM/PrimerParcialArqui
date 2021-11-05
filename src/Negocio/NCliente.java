/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dato.DCliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Christian Vargas
 */
public class NCliente {
    private final DCliente DATOS;

    public NCliente() {
        this.DATOS = new DCliente();
    }
    
    public String insertar(String nombre, String direccion, int telefono){
        DATOS.setNombre(nombre);
        DATOS.setDireccion(direccion);
        DATOS.setTelefono(telefono);
        if(DATOS.insertar(nombre, direccion, telefono)){
            return "OK";
        }else{
            return "Error en el registro.";
        }
    }
    
    public DefaultComboBoxModel clientes(){
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<DCliente> lista = new ArrayList<>();
        lista = DATOS.listar();
        for (DCliente item : lista) {
            items.addElement(new DCliente(item.getId(), item.getNombre(), item.getDireccion(), item.getTelefono()));
        }
        return items;
    }
}
