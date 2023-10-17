package Formularios;

import Clases.Datos;
import Clases.Opcion;
import Clases.Producto;
import Clases.Utilidades;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class frmFactura extends javax.swing.JInternalFrame {

    private Datos misDatos;
    private Stack<Stack> productos = new Stack();
    private int facNumb;


    public void setDatos(Datos misDatos) {
        this.misDatos = misDatos;
    }
    public frmFactura() {
        initComponents();
    }
    
    public String getTxtArea() {
        return txtArea.getText();
    }
    
    public void setCantidad(String cantidad) {
        cboCliente.setSelectedIndex(0);
        txtCantidad.setText(cantidad);
        btnAgregar.doClick();
    }
    
    public void agregarProducto(String cantidad) {
        cboCliente.setSelectedIndex(0);
        txtCantidad.setText(cantidad);
    }
    
    public int generateFactura() {
        btnGrabar.doClick();
        return this.facNumb;
    }
    
    public String setCliente() {
        return txtArea.getText();
    }
    
    private void crearFactura(){
        Border warnBorder = new LineBorder(new Color(250,0,0), 1);
        int total = 0;
        if(productos.size() == 0){
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar un producto");
            txtCantidad.requestFocusInWindow();
            txtCantidad.setBorder(warnBorder);
            return;
        }
        
        Random rand = new Random();
        int FN = rand.nextInt(1000);
        this.facNumb = FN;
        Producto[] data = this.misDatos.getProductos();
        txtArea.setText("***********************************************************************************************\n");
        txtArea.append("CLIENTE: " + cboCliente.getSelectedItem().toString().toUpperCase() + "\n");
        txtArea.append("N° FACTURA: " + FN + "\n");
        txtArea.append("FECHA: " + LocalDate.now() + "\n");
        txtArea.append("PROVEDOR: MJ-STORE\n");
        txtArea.append("-----------------------------------------------------------------------------------------------------------------------\n");
        txtArea.append("CODIGO           PRODUCTO             PRECIO                                                             CANTIDAD\n");
        txtArea.append("-----------------------------------------------------------------------------------------------------------------------\n");
        for(int i = 0; i < this.productos.size(); i++ ){
            int pIn = (int) this.productos.get(i).get(0);
            String id = data[pIn].getIdProducto();
            String name = data[pIn].getDescripcion();
            int precio = data[pIn].getPrecio();
            String cantidad = (String) this.productos.get(i).get(1);
            total += precio * parseInt(cantidad);
            txtArea.append(id + "             "  + name + "    S/ " + precio  + "                                                                                    " + cantidad + "\n");
          
        }
        
        txtArea.append("-----------------------------------------------------------------------------------------------------------------------\n");
        txtArea.append("                                                                                                                          TOTAL       ");
        txtArea.append("S/" + total + "\n");
        txtArea.append("***********************************************************************************************\n");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboCliente = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cboProducto = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnNueva = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("jButton1");

        setClosable(true);
        setTitle("Nueva Factura");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jLabel1.setText("Fecha");

        txtFecha.setEnabled(false);

        jLabel2.setText("Cliente");

        jLabel3.setText("Producto");

        jLabel4.setText("Cantidad");

        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadFocusLost(evt);
            }
        });
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/agregar24x24.png"))); // NOI18N
        btnAgregar.setToolTipText("Adiciona un producto a la factura");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/aceptar24x24.png"))); // NOI18N
        btnGrabar.setToolTipText("Graba la factura");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        txtArea.setEditable(false);
        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane2.setViewportView(txtArea);

        btnNueva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nuevo24x24.png"))); // NOI18N
        btnNueva.setToolTipText("Agregar una nueva factura");
        btnNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator3)
                            .addComponent(jScrollPane2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1))
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar)
                            .addComponent(btnGrabar))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNueva)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        Border warnBorder = new LineBorder(new Color(250,0,0), 1);
        if(txtCantidad.getText().equals("") ){
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar una cantidad");
            txtCantidad.requestFocusInWindow();
            txtCantidad.setBorder(warnBorder);
            return;
        }
        
        if (!Utilidades.isDouble(txtCantidad.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Debe digitar un valor numerico");
            txtCantidad.setBorder(warnBorder);
            txtCantidad.requestFocusInWindow();
            return;
        }
        int precio = Integer.parseInt(txtCantidad.getText());
        if (precio <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Debe digitar un valor mayor a 0");
            txtCantidad.setBorder(warnBorder);
            txtCantidad.requestFocusInWindow();
            return;
        }
        
        if(productos.size() == 0){
            txtArea.setText("Tus productos: \n");
        }
        
        Stack product = new Stack();
        product.push(cboProducto.getSelectedIndex());
        product.push(txtCantidad.getText());
        txtArea.append(cboProducto.getSelectedItem() + " " + txtCantidad.getText() + "\n");
        this.productos.push( product);
        txtCantidad.setText("");
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        
        Opcion opc;
        
        for (int i = 0; i < misDatos.numeroClientes(); i++) {
            opc = new Opcion(misDatos.getClientes()[i].getIdCliente(), 
                    misDatos.getClientes()[i].getNombres() + " "+ misDatos.getClientes()[i].getApellidos());
            cboCliente.addItem(opc);
        }
        
        // Cargamos los productos
        for (int i = 0; i < misDatos.numeroProductos(); i++) {
            opc = new Opcion( misDatos.getProductos()[i].getIdProducto(),
                    misDatos.getProductos()[i].getDescripcion());
            cboProducto.addItem(opc);
        }
        
        txtFecha.setText(Utilidades.formatDate(new Date()));
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        // TODO add your handling code here:
        this.crearFactura();
        Producto[] data = this.misDatos.getProductos();
        int total = 0;
        String fact = "";
        fact += "*************************************************************************************************\n";
        fact += "CLIENTE: " + cboCliente.getSelectedItem().toString().toUpperCase() + "\n";
        fact += "N° FACTURA: " + this.facNumb + "\n" ;
        fact += "FECHA: " + LocalDate.now() + "\n";
        fact += "PROVEDOR: MJ-STORE\n";
        fact += "--------------------------------------------------------------------------------------------------\n";
        fact += "CODIGO   PRODUCTO         PRECIO                                                          CANTIDAD\n" ;
        fact += "--------------------------------------------------------------------------------------------------\n";
        for(int i = 0; i < this.productos.size(); i++ ){
            int pIn = (int) this.productos.get(i).get(0);
            String id = data[pIn].getIdProducto();
            String name = data[pIn].getDescripcion();
            int precio = data[pIn].getPrecio();
            String cantidad = (String) this.productos.get(i).get(1);
            total += precio * parseInt(cantidad);
            fact += id + "   " + name + "     " + "S/" + precio + "                                                                 " + cantidad + "\n" ;
        }
        fact += "--------------------------------------------------------------------------------------------------\n";
        fact += "										TOTAL       " + "S/" + total + "\n" ;
        fact += "**************************************************************************************************";
        
            try {
                String path = "C:\\Users\\Lenovo\\Documents\\PROYECTO-ALG2\\Facturas\\";
                LocalDate today = LocalDate.now();
                String filename = path + today.toString()+"FN-"+ this.facNumb +".txt";
                FileWriter fileWriter = new FileWriter(filename );
                fileWriter.write(fact);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void txtCantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusLost
        // TODO add your handling code here:
        JTextField textField = new JTextField();
        Border defaultBorder = textField.getBorder();
        
        txtCantidad.setBorder(defaultBorder);
    }//GEN-LAST:event_txtCantidadFocusLost

    private void btnNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaActionPerformed
        // TODO add your handling code here:
        txtArea.setText("");
        this.productos.clear();
    }//GEN-LAST:event_btnNuevaActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnNueva;
    private javax.swing.JComboBox cboCliente;
    private javax.swing.JComboBox cboProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
