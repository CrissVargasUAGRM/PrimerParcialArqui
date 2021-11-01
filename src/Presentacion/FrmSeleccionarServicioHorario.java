/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dato.DDoctor;
import Dato.DServicio;
import Negocio.NDoctor;
import Negocio.NServicio;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Christian Vargas
 */
public class FrmSeleccionarServicioHorario extends javax.swing.JDialog {
    private FrmHorarios vista;
    
    private final NServicio SERVICIO;
    private final NDoctor DOCTOR;

    /**
     * Creates new form FrmSeleccionarServicioHorario
     */
    public FrmSeleccionarServicioHorario(java.awt.Frame parent, FrmHorarios frm, boolean modal) {
        super(parent, modal);
        initComponents();
        this.SERVICIO = new NServicio();
        this.DOCTOR = new NDoctor();
        this.setLocationRelativeTo(null);
        this.vista = frm;
        this.cargarServicios();
        this.cargarDoctores();
        
        this.setVisible(true);
    }
    
    private void cargarServicios(){
        DefaultComboBoxModel items = this.SERVICIO.servicios();
        cboServicios.setModel(items);
    }
    
    private void cargarDoctores(){
        DefaultComboBoxModel items = this.DOCTOR.doctores();
        cboDoctor.setModel(items);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboServicios = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cboDoctor = new javax.swing.JComboBox<>();
        tbnCargar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdetalle = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Servicio: ");

        jLabel2.setText("Doctor:");

        tbnCargar.setText("Cargar");
        tbnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnCargarActionPerformed(evt);
            }
        });

        jLabel3.setText("Detalle:");

        txtdetalle.setColumns(20);
        txtdetalle.setRows(5);
        jScrollPane1.setViewportView(txtdetalle);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(tbnCargar)
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cboDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbnCargar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(316, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnCargarActionPerformed
        // TODO add your handling code here:
        DServicio servicios = (DServicio)cboServicios.getSelectedItem();
        DDoctor doctores = (DDoctor)cboDoctor.getSelectedItem();
        String idServ = String.valueOf(servicios.getId());
        String servicioNombre = servicios.getNombre();
        String detalle = txtdetalle.getText();
        String idDoctor = String.valueOf(doctores.getId());
        String doctorNombre = doctores.getNombre();
        
        this.vista.agregarHorariosServicios(idServ, detalle, idDoctor,doctorNombre,servicioNombre);
    }//GEN-LAST:event_tbnCargarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboDoctor;
    private javax.swing.JComboBox<String> cboServicios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton tbnCargar;
    private javax.swing.JTextArea txtdetalle;
    // End of variables declaration//GEN-END:variables
}