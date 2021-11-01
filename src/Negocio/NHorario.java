/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dato.DHorario;
import Dato.DHorariosServicios;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.sql.Date;

/**
 *
 * @author Christian Vargas
 */
public class NHorario {
    private final DHorario DATOS;
    private DefaultTableModel modeloTabla;

    public NHorario() {
        this.DATOS = new DHorario();
    }
    
    public DefaultTableModel listar(){
        List<DHorario> lista = new ArrayList<>();
        lista.addAll(DATOS.listar());
        
        String[] titulos = {"id", "Fecha", "Hora"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String[] registros = new String[3];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        for (DHorario item : lista){
            registros[0] = Integer.toString(item.getId());
            registros[1] = sdf.format(item.getFecha());
            registros[2] = item.getHora();
            this.modeloTabla.addRow(registros);
        }
        return this.modeloTabla;
    }
    
    public String insertar(Date fecha, String hora, DefaultTableModel horariosServicios){
        DATOS.setFecha(fecha);
        DATOS.setHora(hora);
        
        List<DHorariosServicios> arraysHorariosServ = new ArrayList<>();
        int servicioId;
        String detalle;
        int doctorID;
        
        for(int i = 0; i<horariosServicios.getRowCount(); i++){
            servicioId = Integer.parseInt(String.valueOf(horariosServicios.getValueAt(i, 0)));
            detalle = String.valueOf(horariosServicios.getValueAt(i, 1));
            doctorID = Integer.parseInt(String.valueOf(horariosServicios.getValueAt(i, 2)));
            arraysHorariosServ.add(new DHorariosServicios(servicioId, detalle, doctorID));
        }
        
        DATOS.setHorariosServicios(arraysHorariosServ);
        
        if(DATOS.insertar(fecha, hora, DATOS)){
            return "OK";
        }else{
            return "Error en el registro";
        }
    }
    
}
