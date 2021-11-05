/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dato.DReserva;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Christian Vargas
 */
public class NReserva {
    private final DReserva DATOS;
    private DefaultTableModel modeloTabla;

    public NReserva() {
        this.DATOS = new DReserva();
    }
    
    public DefaultTableModel listar(){
        List<DReserva> lista = new ArrayList<>();
        lista.addAll(DATOS.listar());
        
        String[] titulos = {"Id", "Detalle", "Cliente", "Fecha", "Hora", "Servicio"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String[] registros = new String[6];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        for (DReserva item : lista){
            registros[0] = Integer.toString(item.getId());
            registros[1] = item.getDetalle();
            registros[2] = item.getClienteNombre();
            registros[3] = sdf.format(item.getFecha());
            registros[4] = item.getHora();
            registros[5] = item.getServicio();
            this.modeloTabla.addRow(registros);
        }
        
        return this.modeloTabla;
    }
    
    public String insertar(String detalle, int idCliente, int idHorarioServicio){
        DATOS.setDetalle(detalle);
        DATOS.setIdCliente(idCliente);
        DATOS.setIdHorarioServicio(idHorarioServicio);
        if(DATOS.insertar(detalle, idCliente, idHorarioServicio)){
            return "OK";
        }else{
            return "Error en el registro.";
        }
    }
}
