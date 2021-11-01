/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dato.DEspecialidad;
import Negocio.NDoctor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian Vargas
 */
public class FrmDoctor extends javax.swing.JInternalFrame {
    
    private final NDoctor DOCTOR;
    private String accion;

    /**
     * Creates new form FrmDoctor
     */
    public FrmDoctor() {
        initComponents();
        this.DOCTOR = new NDoctor();
        this.listar();
        tabGeneral.setEnabledAt(1, false);
        this.accion = "guardar";
        this.cargarEspecialidades();
    }
    
    private void ocultarCampos(){
        // id del doctor
        tablaDoctores.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaDoctores.getColumnModel().getColumn(0).setMinWidth(0);
        tablaDoctores.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tablaDoctores.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        //id de la especialidad
        tablaDoctores.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaDoctores.getColumnModel().getColumn(1).setMinWidth(0);
        tablaDoctores.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tablaDoctores.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
    }
    
    private void listar(){
        tablaDoctores.setModel(DOCTOR.listar());
        this.ocultarCampos();
    }
    
    private void cargarEspecialidades(){
        DefaultComboBoxModel items = this.DOCTOR.especialidades();
        cboEspecialidad.setModel(items);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabGeneral = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDoctores = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtProfesion = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        brnCancelar = new javax.swing.JButton();
        cboEspecialidad = new javax.swing.JComboBox<>();
        txtNroci = new javax.swing.JFormattedTextField();
        txtTelefono = new javax.swing.JFormattedTextField();
        txtid = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Doctores");

        tablaDoctores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaDoctores);

        btnNuevo.setText("Registrar doctor");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar doctor");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar doctor");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnNuevo)
                .addGap(65, 65, 65)
                .addComponent(btnEditar)
                .addGap(77, 77, 77)
                .addComponent(btnEliminar)
                .addContainerGap(266, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addGap(0, 34, Short.MAX_VALUE))
        );

        tabGeneral.addTab("Doctores", jPanel1);

        jLabel1.setText("Nombre");

        jLabel3.setText("Profesion");

        jLabel5.setText("Telefono");

        jLabel6.setText("Email");

        jLabel7.setText("Nro CI");

        jLabel8.setText("Direccion");

        jLabel9.setText("Especialidad");

        txtProfesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProfesionActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        brnCancelar.setText("Cancelar");
        brnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnCancelarActionPerformed(evt);
            }
        });

        txtNroci.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(btnGuardar)
                        .addGap(137, 137, 137)
                        .addComponent(brnCancelar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre)
                                    .addComponent(txtProfesion)
                                    .addComponent(txtNroci, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(199, 199, 199)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(19, 19, 19))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(137, 162, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(40, 40, 40)
                                .addComponent(cboEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDireccion)
                            .addComponent(txtEmail)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNroci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cboEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(brnCancelar))
                .addContainerGap(190, Short.MAX_VALUE))
        );

        tabGeneral.addTab("Registrar", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabGeneral)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabGeneral)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void brnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnCancelarActionPerformed
        // TODO add your handling code here:
        tabGeneral.setEnabledAt(0, true);
        tabGeneral.setEnabledAt(1, false);
        tabGeneral.setSelectedIndex(0);
        this.limpiar();
    }//GEN-LAST:event_brnCancelarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        tabGeneral.setEnabledAt(1, true);
        tabGeneral.setEnabledAt(0, false);
        tabGeneral.setSelectedIndex(1);
        this.accion= "guardar";
        btnGuardar.setText("Guardar");
    }//GEN-LAST:event_btnNuevoActionPerformed

    
    private void txtProfesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProfesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProfesionActionPerformed

    private void registrar(){
        String resp;
        DEspecialidad especialidad = (DEspecialidad)cboEspecialidad.getSelectedItem();
        resp = this.DOCTOR.insertar(txtNombre.getText(), txtProfesion.getText(), Integer.parseInt(txtTelefono.getText()), txtEmail.getText(), Integer.parseInt(txtNroci.getText()), txtDireccion.getText(), especialidad.getId());
        if(resp.equals("OK")){
            this.mensajeOk("Registrado correctamente");
            this.limpiar();
            this.listar();
        }else{
            this.mensajeError(resp);
        }
    }
    
    private void actualizar(){
        String resp;
        DEspecialidad especialidad = (DEspecialidad)cboEspecialidad.getSelectedItem();
        resp = this.DOCTOR.editar(txtNombre.getText(), txtProfesion.getText(), Integer.parseInt(txtTelefono.getText()), txtEmail.getText(), Integer.parseInt(txtNroci.getText()), txtDireccion.getText(), especialidad.getId(), Integer.parseInt(txtid.getText()));
        if(resp.equals("OK")){
            this.mensajeOk("Editado con exito");
            this.limpiar();
            this.listar();
            tabGeneral.setSelectedIndex(0);
            tabGeneral.setEnabledAt(1, false);
            tabGeneral.setEnabledAt(0, true);
        }else{
            this.mensajeError(resp);
        }
    }
    
    private void eliminar(int id){
        String resp;
        resp = DOCTOR.eliminar(id);
        if(resp.equals("OK")){
            this.mensajeOk("Eliminado");
            this.listar();
        }else{
            this.mensajeError(resp);
        }
        
    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(this.accion.equals("editar")){
            // editar
            this.actualizar();
        }else{
            this.registrar();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        if(tablaDoctores.getSelectedRowCount() == 1){
            String id = String.valueOf(tablaDoctores.getValueAt(tablaDoctores.getSelectedRow(), 0));
            int especialidadId = Integer.parseInt(String.valueOf(tablaDoctores.getValueAt(tablaDoctores.getSelectedRow(), 1)));
            String nombre = String.valueOf(tablaDoctores.getValueAt(tablaDoctores.getSelectedRow(), 2));
            String profesion = String.valueOf(tablaDoctores.getValueAt(tablaDoctores.getSelectedRow(), 4));
            String telefono = String.valueOf(tablaDoctores.getValueAt(tablaDoctores.getSelectedRow(), 6));
            String email = String.valueOf(tablaDoctores.getValueAt(tablaDoctores.getSelectedRow(), 7));
            String ci = String.valueOf(tablaDoctores.getValueAt(tablaDoctores.getSelectedRow(), 8));
            String direccion = String.valueOf(tablaDoctores.getValueAt(tablaDoctores.getSelectedRow(), 9));
            String especialidad = String.valueOf(tablaDoctores.getValueAt(tablaDoctores.getSelectedRow(), 10));
            
            txtid.setText(id);
            txtNombre.setText(nombre);
            txtProfesion.setText(profesion);
            txtTelefono.setText(telefono);
            txtEmail.setText(email);
            txtNroci.setText(ci);
            txtDireccion.setText(direccion);
            DEspecialidad select = new DEspecialidad(especialidadId, especialidad);
            cboEspecialidad.setSelectedItem(select);
            
            tabGeneral.setEnabledAt(0, false);
            tabGeneral.setEnabledAt(1, true);
            tabGeneral.setSelectedIndex(1);
            this.accion = "editar";
            btnGuardar.setText("Editar");
        }else{
            this.mensajeError("Selecciona un registro");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        String id = String.valueOf(tablaDoctores.getValueAt(tablaDoctores.getSelectedRow(), 0));
        if(JOptionPane.showConfirmDialog(this, "Deseas eliminar el doctor", "Eliminar", JOptionPane.YES_NO_OPTION) == 0){
            this.eliminar(Integer.parseInt(id));
        }else{
            this.mensajeError("selecciona un registro");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void limpiar(){
        txtNombre.setText("");
        txtProfesion.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        txtDireccion.setText("");
        txtNroci.setText("");
        this.accion = "guardar";
    }

    private void mensajeError(String mansaje){
        JOptionPane.showMessageDialog(this, mansaje, "Sistema", JOptionPane.ERROR_MESSAGE);
    }
    
    private void mensajeOk(String mansaje){
        JOptionPane.showMessageDialog(this, mansaje, "Sistema", JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboEspecialidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JTable tablaDoctores;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtNroci;
    private javax.swing.JTextField txtProfesion;
    private javax.swing.JFormattedTextField txtTelefono;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
