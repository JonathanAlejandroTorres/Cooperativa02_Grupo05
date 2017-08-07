/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.practica.banca_1.interfaces;

import ec.edu.espe.practica.banca_1.clases.Clientes;
import javax.swing.JOptionPane;

/**
 *
 * @author jeffe
 */
public class JDClientes extends javax.swing.JDialog {
private Clientes cli;
    /**
     * Creates new form JDClientes1
     */
    public JDClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         this.setLocationRelativeTo(this);
        cli=new Clientes();
        btngroupGenero.add(jrbMasculino);
        btngroupGenero.add(jrbFemenino);

    }
     public void Limpiar(){
        txtClienteCI.setText("");
        txtClienteNombres.setText("");         
        txtBuscarCI.setText("");
        txtIngresoMensual.setText("");
    }  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngroupGenero = new javax.swing.ButtonGroup();
        btnClienteNuevo = new javax.swing.JButton();
        btnClienteGuardar = new javax.swing.JButton();
        btnClienteEliminar = new javax.swing.JButton();
        pnlDatosCliente = new java.awt.Panel();
        txtIngresoMensual = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblRegistroNombre = new javax.swing.JLabel();
        txtClienteNombres = new javax.swing.JTextField();
        txtClienteCI = new javax.swing.JTextField();
        lblRegistroID1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jrbMasculino = new javax.swing.JRadioButton();
        jrbFemenino = new javax.swing.JRadioButton();
        btnClienteSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCliente = new javax.swing.JTable();
        btnClienteBuscarCI1 = new javax.swing.JButton();
        lblIngresarID = new javax.swing.JLabel();
        txtBuscarCI = new javax.swing.JTextField();
        btnClienteBuscarCI = new javax.swing.JButton();
        pnlRegistroTitulo = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnClienteNuevo.setText("MODIFICAR");
        btnClienteNuevo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnClienteNuevo.setMaximumSize(new java.awt.Dimension(85, 60));
        btnClienteNuevo.setMinimumSize(new java.awt.Dimension(85, 60));
        btnClienteNuevo.setPreferredSize(new java.awt.Dimension(85, 60));
        btnClienteNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteNuevoActionPerformed(evt);
            }
        });

        btnClienteGuardar.setText("GUARDAR");
        btnClienteGuardar.setMaximumSize(new java.awt.Dimension(85, 60));
        btnClienteGuardar.setMinimumSize(new java.awt.Dimension(85, 60));
        btnClienteGuardar.setPreferredSize(new java.awt.Dimension(85, 60));
        btnClienteGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteGuardarActionPerformed(evt);
            }
        });

        btnClienteEliminar.setText("Eliminar");
        btnClienteEliminar.setMaximumSize(new java.awt.Dimension(85, 60));
        btnClienteEliminar.setMinimumSize(new java.awt.Dimension(85, 60));
        btnClienteEliminar.setPreferredSize(new java.awt.Dimension(85, 60));
        btnClienteEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteEliminarActionPerformed(evt);
            }
        });

        pnlDatosCliente.setBackground(new java.awt.Color(204, 204, 204));

        txtIngresoMensual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Salario mensual:");

        lblRegistroNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblRegistroNombre.setText("Nombres:");

        txtClienteNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClienteNombresKeyTyped(evt);
            }
        });

        txtClienteCI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClienteCIKeyTyped(evt);
            }
        });

        lblRegistroID1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblRegistroID1.setText("CI:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Género:");

        jrbMasculino.setText("Masculino");
        jrbMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMasculinoActionPerformed(evt);
            }
        });

        jrbFemenino.setText("Femenino");

        javax.swing.GroupLayout pnlDatosClienteLayout = new javax.swing.GroupLayout(pnlDatosCliente);
        pnlDatosCliente.setLayout(pnlDatosClienteLayout);
        pnlDatosClienteLayout.setHorizontalGroup(
            pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosClienteLayout.createSequentialGroup()
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(lblRegistroID1)
                        .addGap(18, 18, 18)
                        .addComponent(txtClienteCI, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbMasculino)
                            .addComponent(jrbFemenino))))
                .addGap(73, 73, 73)
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIngresoMensual, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                        .addComponent(lblRegistroNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtClienteNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );
        pnlDatosClienteLayout.setVerticalGroup(
            pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosClienteLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegistroNombre)
                    .addComponent(txtClienteNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClienteCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRegistroID1))
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIngresoMensual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrbMasculino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrbFemenino)))
                .addContainerGap())
        );

        btnClienteSalir.setText("SALIR");
        btnClienteSalir.setMaximumSize(new java.awt.Dimension(85, 60));
        btnClienteSalir.setMinimumSize(new java.awt.Dimension(85, 60));
        btnClienteSalir.setPreferredSize(new java.awt.Dimension(85, 60));
        btnClienteSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteSalirActionPerformed(evt);
            }
        });

        jtbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Título 4"
            }
        ));
        jtbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbCliente);

        btnClienteBuscarCI1.setText("Liistado clientes");
        btnClienteBuscarCI1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteBuscarCI1ActionPerformed(evt);
            }
        });

        lblIngresarID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIngresarID.setText("Ingresar CI:");

        txtBuscarCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarCIActionPerformed(evt);
            }
        });
        txtBuscarCI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarCIKeyTyped(evt);
            }
        });

        btnClienteBuscarCI.setText("Buscar");
        btnClienteBuscarCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteBuscarCIActionPerformed(evt);
            }
        });

        pnlRegistroTitulo.setBackground(new java.awt.Color(102, 102, 102));
        pnlRegistroTitulo.setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 35)); // NOI18N
        jLabel1.setText("REGISTRO DE CLIENTES");

        javax.swing.GroupLayout pnlRegistroTituloLayout = new javax.swing.GroupLayout(pnlRegistroTitulo);
        pnlRegistroTitulo.setLayout(pnlRegistroTituloLayout);
        pnlRegistroTituloLayout.setHorizontalGroup(
            pnlRegistroTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(74, 74, 74)
                .addComponent(jLabel2)
                .addGap(21, 21, 21))
        );
        pnlRegistroTituloLayout.setVerticalGroup(
            pnlRegistroTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroTituloLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistroTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlRegistroTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnClienteNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)
                                .addComponent(btnClienteGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnClienteSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))))
                    .addComponent(pnlDatosCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnClienteBuscarCI1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(lblIngresarID)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarCI, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(btnClienteBuscarCI, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClienteEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlRegistroTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnClienteBuscarCI1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblIngresarID)
                        .addComponent(txtBuscarCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnClienteBuscarCI, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClienteEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClienteNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClienteGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClienteSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClienteNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteNuevoActionPerformed
        // TODO add your handling code here:
        /*cli.setCedula("");
        cli.setNombre("");
        Limpiar();*/
        cli.setCedula(txtClienteCI.getText());
        cli.setNombre(txtClienteNombres.getText());
        cli.setIngreso_mensual(Double.parseDouble(txtIngresoMensual.getText()));
        if(cli.buscarClieentes(jtbCliente)==1){
            cli.actualizarCliente();
            cli.listaClieentes(jtbCliente);
        }
        txtClienteCI.setText("");
        txtClienteNombres.setText("");
        txtIngresoMensual.setText("");
        
    }//GEN-LAST:event_btnClienteNuevoActionPerformed

    private void btnClienteGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteGuardarActionPerformed
        // TODO add your handling code here:
        //cli.actualizarCliente();
        cli.setCedula(txtClienteCI.getText());
        cli.setNombre(txtClienteNombres.getText());
        cli.setIngreso_mensual(Double.parseDouble(txtIngresoMensual.getText()));
        if(jrbMasculino.isSelected()==true){
            cli.setGenero("M");
        }else{
            cli.setGenero("F");
        }
        if(jrbMasculino.isSelected()==false && jrbFemenino.isSelected()==false){
            JOptionPane.showMessageDialog(pnlDatosCliente, "Escoja un Genero");
        }else{
            cli.buscarClieentes(jtbCliente);
            cli.nuevoCliente();
            cli.listaClieentes(jtbCliente);
            txtClienteCI.setText("");
            txtClienteNombres.setText("");
            txtIngresoMensual.setText("");
        }

    }//GEN-LAST:event_btnClienteGuardarActionPerformed

    private void btnClienteEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteEliminarActionPerformed
        // TODO add your handling code here:
        cli.setCedula(txtBuscarCI.getText());
        if(cli.buscarClieentes(jtbCliente)==1){
            cli.borrarCliente();
            cli.listaClieentes(jtbCliente);
        }
        txtBuscarCI.setText("");

    }//GEN-LAST:event_btnClienteEliminarActionPerformed

    private void txtClienteCIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteCIKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
            //JOptionPane.showMessageDialog(null, "Debe ingresar solo números.");
        }else{
            if(txtBuscarCI.getText().length() > 13){
                evt.consume();
                JOptionPane.showMessageDialog(null, "Dato ingresado incorrecto");
            }
        }
    }//GEN-LAST:event_txtClienteCIKeyTyped

    private void txtClienteNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteNombresKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if((c<'a' || c>'z')&&(c<'A' || c>'Z') && c !=' '){
            evt.consume();
            //JOptionPane.showMessageDialog(null, "Debe ingresar solo números.");
        }
    }//GEN-LAST:event_txtClienteNombresKeyTyped

    private void btnClienteSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();//CERRAR VENTANA
    }//GEN-LAST:event_btnClienteSalirActionPerformed

    private void jtbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbClienteMouseClicked
        // TODO add your handling code here:
        int a = jtbCliente.getSelectedRow();
        String ced = jtbCliente.getValueAt(a, 0).toString();
        String nom = jtbCliente.getValueAt(a, 1).toString();
        txtClienteCI.setText(ced);
        txtClienteCI.enable(false);
        txtClienteNombres.setText(nom);

        
    }//GEN-LAST:event_jtbClienteMouseClicked

    private void btnClienteBuscarCI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteBuscarCI1ActionPerformed
        // TODO add your handling code here:
        cli.listaClieentes(jtbCliente);
    }//GEN-LAST:event_btnClienteBuscarCI1ActionPerformed

    private void txtBuscarCIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCIKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
        }else{
            if(txtBuscarCI.getText().length() > 13){
                evt.consume();
                JOptionPane.showMessageDialog(null, "Dato ingresado incorrecto");
            }
        }
    }//GEN-LAST:event_txtBuscarCIKeyTyped

    private void btnClienteBuscarCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteBuscarCIActionPerformed
        // TODO add your handling code here:
        try{
            if(txtBuscarCI.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Debe ingresar el nÃºmero de cÃ©dula.");
            }else{
                if(cli.validarCedula(txtBuscarCI.getText()) == true){
                    cli.setCedula(txtBuscarCI.getText());
                    cli.buscarClieentes(jtbCliente);                    
                }
                txtBuscarCI.setText("");
            }
        }catch (Exception ex){

        }

    }//GEN-LAST:event_btnClienteBuscarCIActionPerformed

    private void txtBuscarCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarCIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarCIActionPerformed

    private void jrbMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbMasculinoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDClientes dialog = new JDClientes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClienteBuscarCI;
    private javax.swing.JButton btnClienteBuscarCI1;
    private javax.swing.JButton btnClienteEliminar;
    private javax.swing.JButton btnClienteGuardar;
    private javax.swing.JButton btnClienteNuevo;
    private javax.swing.JButton btnClienteSalir;
    private javax.swing.ButtonGroup btngroupGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrbFemenino;
    private javax.swing.JRadioButton jrbMasculino;
    private javax.swing.JTable jtbCliente;
    private javax.swing.JLabel lblIngresarID;
    private javax.swing.JLabel lblRegistroID1;
    private javax.swing.JLabel lblRegistroNombre;
    private java.awt.Panel pnlDatosCliente;
    private java.awt.Panel pnlRegistroTitulo;
    private javax.swing.JTextField txtBuscarCI;
    private javax.swing.JTextField txtClienteCI;
    private javax.swing.JTextField txtClienteNombres;
    private javax.swing.JTextField txtIngresoMensual;
    // End of variables declaration//GEN-END:variables
}
