/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dato.DPaciente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian Vargas
 */
public class NPaciente {
    private final DPaciente DATOS;
    private DefaultTableModel modeloTabla;

    public NPaciente() {
        this.DATOS = new DPaciente();
    }
    
    public DefaultTableModel listar(){
        List<DPaciente> lista = new ArrayList<>();
        lista.addAll(DATOS.listar());
        
        String[] titulos = {"ID","Nombre","Edad","Especie","Raza","Doctor","Cliente"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String[] registros = new String[11];
        
        for (DPaciente item : lista){
            registros[0] = Integer.toString(item.getId());
            registros[1] = item.getNombre();
            registros[2] = item.getEdad();
            registros[3] = item.getEspecie();
            registros[4] = item.getRaza();
            registros[5] = item.getDoctorNombre();
            registros[6] = item.getClienteNombre();
            this.modeloTabla.addRow(registros);
        }
        
        return this.modeloTabla;
    }
    
    public String insertar(String nombre, String edad, String especie, String raza, int idDoctor, int idCliente){
        DATOS.setNombre(nombre);
        DATOS.setEdad(edad);
        DATOS.setEspecie(especie);
        DATOS.setRaza(raza);
        DATOS.setIdDoctor(idDoctor);
        DATOS.setIdCliente(idCliente);
        if(DATOS.insertar(nombre, edad, especie, raza, idDoctor, idCliente)){
            return "OK";
        }else{
            return "Error en el registro.";
        }
    }
    
    public String editar(String nombre, String edad, String especie, String raza, int idDoctor, int idCliente, int id){
        DATOS.setNombre(nombre);
        DATOS.setEdad(edad);
        DATOS.setEspecie(especie);
        DATOS.setRaza(raza);
        DATOS.setIdDoctor(idDoctor);
        DATOS.setIdCliente(idCliente);
        DATOS.setId(id);
        if(DATOS.editar(nombre, edad, especie, raza, idDoctor, idCliente, id)){
            return "OK";
        }else{
            return "Error en la actualizacion.";
        }
    }
    
    public String eliminar(int idPaciente){
        if(DATOS.eliminar(idPaciente)){
            return "OK";
        }else{
            return "No se pudo eliminar el doctor.";
        }
    }
}
