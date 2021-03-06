
package Vista;

import Modelo.Cripto;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 * Ventana Principal del programa de cifrado para la T.I.A.
 * @author JRBlanco
 */
public class VentanaMain extends javax.swing.JFrame {

    /**
     * Creates new form ventanaPrincipalVista
     */
    public VentanaMain() {
        
        initComponents();
        setLocationRelativeTo(null);   //Para que salga en el centro de la pantalla
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMensajeOuput = new javax.swing.JTextArea();
        lbMensaje = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMensajeInput = new javax.swing.JTextArea();
        btnCifrar = new javax.swing.JButton();
        btnDescifrar = new javax.swing.JButton();
        cbCodificacion = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnCopiar = new javax.swing.JButton();
        btnPegar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reto 2022 Programaci??n");
        setResizable(false);

        jLabel3.setText("Mensaje para cifrar o descifrar");

        txtMensajeOuput.setEditable(false);
        txtMensajeOuput.setColumns(20);
        txtMensajeOuput.setLineWrap(true);
        txtMensajeOuput.setRows(5);
        jScrollPane1.setViewportView(txtMensajeOuput);

        lbMensaje.setText("Mensaje");

        txtMensajeInput.setColumns(20);
        txtMensajeInput.setLineWrap(true);
        txtMensajeInput.setRows(5);
        jScrollPane2.setViewportView(txtMensajeInput);

        btnCifrar.setBackground(new java.awt.Color(55, 90, 129));
        btnCifrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCifrar.setText("Cifrar Mensaje");
        btnCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickCifrarMensaje(evt);
            }
        });

        btnDescifrar.setBackground(new java.awt.Color(76, 129, 55));
        btnDescifrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDescifrar.setForeground(new java.awt.Color(51, 51, 51));
        btnDescifrar.setText("Descifrar Mensaje");
        btnDescifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickDescifrarMensaje(evt);
            }
        });

        cbCodificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16" }));
        cbCodificacion.setSelectedIndex(2);

        jLabel1.setText("Clave de codificaci??n");

        btnCopiar.setText("Copiar");
        btnCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopiarclickCopiar(evt);
            }
        });

        btnPegar.setText("Pegar");
        btnPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPegarclickPegar(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(129, 55, 55));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPegar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbMensaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCopiar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCifrar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDescifrar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cbCodificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCifrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbCodificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(btnDescifrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnPegar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCopiar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMensaje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * M??todo que se lanza con el click en el bot??n de cifrarmensa
     * @param evt 
     */
    private void clickCifrarMensaje(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickCifrarMensaje
        
        if (txtMensajeInput.getText().length()!=0) { //Se comprueba que hay texto que cifrar en el jtextArea
            
            int codificacion = Integer.valueOf((String) cbCodificacion.getSelectedItem()); //Obtenemos el valor del 
            
            txtMensajeOuput.setText(Cripto.cifradoCesar(txtMensajeInput.getText(),codificacion));
            
            lbMensaje.setText("Jefe, aqu?? tiene el mensaje cifrado");
        } else {
            JOptionPane.showMessageDialog(this, "Jefe, pero que burro es usted, no hay nada para cifrar");
        }
        
    }//GEN-LAST:event_clickCifrarMensaje
    
    /**
     * M??todo que se lanza con el click en el bot??n de descifrarmensaje
     * @param evt 
     */
    private void clickDescifrarMensaje(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickDescifrarMensaje
        if (txtMensajeInput.getText().length()!=0) { //Se comprueba que hay texto que cifrar en el jtextArea
            
            int codificacion = Integer.valueOf((String) cbCodificacion.getSelectedItem()); //Obtenemos el valor del 
            codificacion *= (-1);   //Invierte el numero para decodificar
            txtMensajeOuput.setText(Cripto.cifradoCesar(txtMensajeInput.getText(),codificacion));
            
            lbMensaje.setText("Jefe, aqu?? tiene el mensaje descifrado");
        } else {
            JOptionPane.showMessageDialog(this, "Jefe, pero que burro es usted, no hay nada para descifrar");
        }
    }//GEN-LAST:event_clickDescifrarMensaje

    /**
     * M??todo que se lanza en el bot??n click para copiar en el portapapeles el 
     * texto del salida
     * @param evt 
     */
    private void btnCopiarclickCopiar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiarclickCopiar
        if (txtMensajeInput.getText().length()!=0) {    //Se comprueba que hay texto que cifrar en el jtextArea
            StringSelection stringSelection = new StringSelection(txtMensajeOuput.getText());       //Obtenemos el texto
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();                 //Preparamos para copiar el portapapeles
            clipboard.setContents(stringSelection, null);                                           //envia el texto al portapapeler
        } else {
            JOptionPane.showMessageDialog(rootPane, "A donde vas so animal, no hay nada que copiar");
        }
    }//GEN-LAST:event_btnCopiarclickCopiar

    /**
     * M??todo que se lanza en el bot??n click para pegar en el jtextarea de entrada
     * el texto si lo hubiera en el portapapeles
     * @param evt 
     */
    private void btnPegarclickPegar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPegarclickPegar
        Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();   //Prepara el portapapeles
        DataFlavor dataFlavor = DataFlavor.stringFlavor;                                //Para acceder a los datos del portapapeles

        if (systemClipboard.isDataFlavorAvailable(dataFlavor))                          //si hay datos
        {
            try {
                Object text = systemClipboard.getData(dataFlavor);                      //Obtiene los datos
                txtMensajeInput.setText((String) text);                                 //Escribe en el jTextArea el texto del portapapeles
                
            } catch (UnsupportedFlavorException ex) {
                Logger.getLogger(VentanaMain.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VentanaMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnPegarclickPegar

    /**
     * M??todo que se lanza con el click en el bot??n Borrar y lo que hace es 
     * vaciar toda la informaci??n de los textarea.
     * @param evt 
     */
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        txtMensajeInput.setText("");
        txtMensajeOuput.setText("");
    }//GEN-LAST:event_btnBorrarActionPerformed

    /**
     * M??tode que se lanza al pulsar el bot??n de salir y que lo que hace es finalizar el programa.
     * @param evt 
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
         if (JOptionPane.showConfirmDialog(rootPane, "??Estas seguro de salir?","Salir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(VentanaMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                new VentanaMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCifrar;
    private javax.swing.JButton btnCopiar;
    private javax.swing.JButton btnDescifrar;
    private javax.swing.JButton btnPegar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbCodificacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbMensaje;
    private javax.swing.JTextArea txtMensajeInput;
    private javax.swing.JTextArea txtMensajeOuput;
    // End of variables declaration//GEN-END:variables
}
