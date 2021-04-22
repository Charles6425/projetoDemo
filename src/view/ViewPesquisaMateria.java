/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerMateria;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.ModelMateria;
import util.BLTiraAcentos;
import javax.swing.JFrame;

/**
 *
 * @author Administrador
 */
public class ViewPesquisaMateria extends javax.swing.JDialog {

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;

    /**
     * Creates new form ViewPesquisarProdutoPDV
     */
    public ViewPesquisaMateria(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        setLocationRelativeTo(null);
        carregarVendedor();


        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAluno = new javax.swing.JTable();
        txVendedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setTitle("Pesquisa de Matéria");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        tbAluno.setAutoCreateRowSorter(true);
        tbAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAluno.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbAluno.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbAluno);
        if (tbAluno.getColumnModel().getColumnCount() > 0) {
            tbAluno.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbAluno.getColumnModel().getColumn(1).setMinWidth(400);
            tbAluno.getColumnModel().getColumn(1).setMaxWidth(500);
        }

        txVendedor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txVendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txVendedorKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Aluno:");

        jButton1.setText("Config.");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txVendedor)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(228, 228, 228)
                                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addGap(20, 20, 20))
        );

        getRootPane().setDefaultButton(okButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        doClose(RET_OK);
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void txVendedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txVendedorKeyReleased
        DefaultTableModel tabela = (DefaultTableModel) this.tbAluno.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabela);

        //Charles - tornar a caixa de pesquisa em letra maiuscula e tirar acentos
        // converte em maiusculo o que o usuario digitar
        this.txVendedor.setText(txVendedor.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txVendedor.setText(blTiraAcentos.TiraAcentos(txVendedor.getText()));

        this.tbAluno.setRowSorter(sorter);
        String text = txVendedor.getText();

        

        
            sorter.setRowFilter(RowFilter.regexFilter(text, 1));
  


    }//GEN-LAST:event_txVendedorKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tirarAcentos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void doClose(int retStatus) {
        int linha = tbAluno.getSelectedRow();
        int codigo = (int) tbAluno.getValueAt(linha, 0);
        returnStatus = codigo;
        setVisible(false);
        dispose();
    }

    private void carregarVendedor() {
        ControllerMateria controllerMateria = new ControllerMateria();
        ArrayList<ModelMateria> listaModelMaterias = new ArrayList<>();
        //listamModelUsuarios = controllerUsuario.getListaUsuarioController();
        listaModelMaterias = controllerMateria.getListaMateriaController() ;
        DefaultTableModel modelo = (DefaultTableModel) tbAluno.getModel();
        modelo.setNumRows(0);
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listaModelMaterias.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelMaterias.get(i).getId(),
                listaModelMaterias.get(i).getDescricao(),
                
            });
        }
    }

    /**
     * charles muller método que tira acentos e deixa com letra maiuscula
     * automaticamente
     */
    private void tirarAcentos() {

        ControllerMateria controllerMateria= new ControllerMateria();
        ArrayList<ModelMateria> listamModelMaterias = new ArrayList<>();
        ModelMateria modelMateria = new ModelMateria();

        //listamModelUsuarios = controllerUsuario.getListaUsuarioController();
        listamModelMaterias = controllerMateria.getListaMateriaController();
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        int cont = listamModelMaterias.size();
        for (int i = 0; i < cont; i++) {
            modelMateria= controllerMateria.getMateriaController(listamModelMaterias.get(i).getId());

            modelMateria.setDescricao(modelMateria.getDescricao().toUpperCase());
            modelMateria.setDescricao(blTiraAcentos.TiraAcentos(modelMateria.getDescricao()));
            controllerMateria.atualizarMateriaController(modelMateria);
            System.out.println(modelMateria.getDescricao());
        }

    }

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
            java.util.logging.Logger.getLogger(ViewPesquisaMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPesquisaMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPesquisaMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPesquisaMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewPesquisaMateria dialog = new ViewPesquisaMateria(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton okButton;
    private javax.swing.JTable tbAluno;
    private javax.swing.JTextField txVendedor;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;
}
