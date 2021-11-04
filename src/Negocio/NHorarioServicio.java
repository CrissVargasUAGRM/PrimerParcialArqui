/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dato.DDoctor;
import Dato.DHorario;
import Dato.DHorariosServicios;
import Dato.DServicio;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian Vargas
 */
public class NHorarioServicio {
    private final DHorariosServicios DATOS;
    private final DServicio SERVICIO;
    private final DDoctor DOCTOR;
    private final DHorario HORARIO;
    
    private DefaultTableModel modeloTabla;

    public NHorarioServicio() {
        this.DATOS = new DHorariosServicios();
        this.SERVICIO = new DServicio();
        this.DOCTOR = new DDoctor();
        this.HORARIO = new DHorario();
    }
    
    public DefaultTableModel listar(){
        List<DHorariosServicios> lista = new ArrayList<>();
        lista.addAll(DATOS.listar());
        
        String[] titulos = {"Id", "Servicio", "Fecha", "Hora", "Doctor"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String[] registros = new String[5];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        for (DHorariosServicios item : lista){
        registros[0] = Integer.toString(item.getId());
        registros[1] = item.getNombreServicio();
        registros[2] = sdf.format(item.getFecha());
        registros[3] = item.getHora();
        registros[4] = item.getNombreDoctor();
        this.modeloTabla.addRow(registros);
        }
        return this.modeloTabla;
    }
    
}
