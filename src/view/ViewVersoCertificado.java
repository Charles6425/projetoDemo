/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.ModelVersoCertificado;
import controller.ControllerVersoCertificado;
import controller.ControllerAluno;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.BLTiraAcentos;

/**
 *
 * @author charles
 */
public class ViewVersoCertificado extends javax.swing.JFrame {

    ModelVersoCertificado modelVersoCertificado = new ModelVersoCertificado();
    ControllerVersoCertificado controllerVersoCertificado = new ControllerVersoCertificado();
    ControllerAluno controllerAluno = new ControllerAluno();
    ArrayList<ModelVersoCertificado> listaModelVersoCertificado = new ArrayList<>();
    String salvarAlterar;

    /**
     * Creates new form ModeloMini
     */
    public ViewVersoCertificado() {
        initComponents();
        setLocationRelativeTo(null);
        habilitaCampo(false);
        btAlterar.setEnabled(true);
        btCancelar.setEnabled(false);
        btSalvar.setEnabled(false);
        btNovo.setEnabled(true);
        this.carregarVersoCertificado();

    }
    
    private void gerarRelatorio(){
        int linha = this.tbDescricao.getSelectedRow();
        int codigo = (Integer) tbDescricao.getValueAt(linha, 0);
        controllerAluno.gerarRelatorioVersoCertificado(codigo);
        
    }

    private boolean recuperarProduto() {
        salvarAlterar = "alterar";
        //recebe a linha selecionada
        int linha = this.tbDescricao.getSelectedRow();
        try {
            //recupera os dados do banco
            int codigo = (Integer) tbDescricao.getValueAt(linha, 0);
            //pega o codigo do ncm na linha selecionada  
            modelVersoCertificado = controllerVersoCertificado.getVersoCertificadoController(codigo);
            
            //seta os dados na interface
            this.txCodigo.setText(String.valueOf(modelVersoCertificado.getId()));
            this.txDescricao.setText(modelVersoCertificado.getDescricao());
            txQtHoras.setText(modelVersoCertificado.getQt_horas());
            taTexto.setText(modelVersoCertificado.getTexto());
            habilitaCampo(true);
            btSalvar.setEnabled(true);
            btCancelar.setEnabled(true);
            btAlterar.setEnabled(false);
            btNovo.setEnabled(false);
            tbDescricao.getSelectionModel().clearSelection();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "C??digo inv??lido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private void salvar() {
        modelVersoCertificado.setDescricao(txDescricao.getText());
        modelVersoCertificado.setQt_horas(txQtHoras.getText());
        modelVersoCertificado.setTexto(taTexto.getText());
        salvarAlterar = "novo";
        if (controllerVersoCertificado.salvarVersoCertificadoController(modelVersoCertificado) > 0) {
            JOptionPane.showMessageDialog(this, "Registro salvo com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao salvar o registro!");
        }

    }

    private void alterar() {
        salvarAlterar = "alterar";
        modelVersoCertificado.setDescricao(txDescricao.getText());
        modelVersoCertificado.setQt_horas(txQtHoras.getText());
        modelVersoCertificado.setTexto(taTexto.getText());

        if (controllerVersoCertificado.atualizarVersoCertificadoController(modelVersoCertificado)) {
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar o registro!");
        }

    }

    private void habilitaCampo(boolean condicao) {
        txCodigo.setEnabled(condicao);
        txDescricao.setEnabled(condicao);
        taTexto.setEnabled(condicao);
        txQtHoras.setEnabled(condicao);

    }

    private void limpaCampos() {
        txCodigo.setText("");
        txDescricao.setText("");
        taTexto.setText("");
        txQtHoras.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btSalvar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        txCodigo = new javax.swing.JTextField();
        txDescricao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDescricao = new javax.swing.JTable();
        btNovo = new javax.swing.JButton();
        txQtHoras = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taTexto = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Verso do certificado");

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        txCodigo.setEditable(false);

        txDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txDescricaoKeyReleased(evt);
            }
        });

        jLabel1.setText("Id");

        jLabel2.setText("Descri????o");

        tbDescricao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descri????o", "Qt. horas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbDescricao);
        if (tbDescricao.getColumnModel().getColumnCount() > 0) {
            tbDescricao.getColumnModel().getColumn(0).setResizable(false);
            tbDescricao.getColumnModel().getColumn(1).setResizable(false);
            tbDescricao.getColumnModel().getColumn(2).setResizable(false);
        }

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade de horas");

        taTexto.setColumns(20);
        taTexto.setRows(5);
        jScrollPane2.setViewportView(taTexto);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirma.png"))); // NOI18N
        jButton1.setText("Gerar");
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
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 54, Short.MAX_VALUE))
                            .addComponent(txQtHoras))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txQtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSalvar)
                            .addComponent(btAlterar)
                            .addComponent(btCancelar)
                            .addComponent(btNovo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        if (txDescricao.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Necess??rio informar o campo descri????o", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
        } else if (salvarAlterar.equals("novo")) {
            salvar();
            habilitaCampo(false);
            limpaCampos();
            this.carregarVersoCertificado();
            btAlterar.setEnabled(true);
            btCancelar.setEnabled(false);
            btSalvar.setEnabled(false);
            btNovo.setEnabled(true);

        } else if (salvarAlterar.equals("alterar")) {

            alterar();
            this.carregarVersoCertificado();
            habilitaCampo(false);
            limpaCampos();

            btAlterar.setEnabled(true);
            btCancelar.setEnabled(false);
            btSalvar.setEnabled(false);
            btNovo.setEnabled(true);

    }//GEN-LAST:event_btSalvarActionPerformed
    }
    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        salvarAlterar = "novo";
        habilitaCampo(true);
        btAlterar.setEnabled(false);
        btCancelar.setEnabled(true);
        btSalvar.setEnabled(true);
        btNovo.setEnabled(false);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        recuperarProduto();
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        habilitaCampo(false);
        btAlterar.setEnabled(true);
        btCancelar.setEnabled(false);
        btSalvar.setEnabled(false);
        btNovo.setEnabled(true);

        limpaCampos();
        salvarAlterar = "";
    }//GEN-LAST:event_btCancelarActionPerformed

    private void txDescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDescricaoKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txDescricao.setText(txDescricao.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txDescricao.setText(blTiraAcentos.TiraAcentos(txDescricao.getText()));         // TODO add your handling code here:
    }//GEN-LAST:event_txDescricaoKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        gerarRelatorio();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void carregarVersoCertificado() {
        listaModelVersoCertificado = controllerVersoCertificado.getListaVersoCertificadoController();
        DefaultTableModel modelo = (DefaultTableModel) tbDescricao.getModel();
        modelo.setNumRows(0);
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listaModelVersoCertificado.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelVersoCertificado.get(i).getId(),
                listaModelVersoCertificado.get(i).getDescricao(),
                listaModelVersoCertificado.get(i).getQt_horas(),
            });
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
            java.util.logging.Logger.getLogger(ViewVersoCertificado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewVersoCertificado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewVersoCertificado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewVersoCertificado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewVersoCertificado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taTexto;
    private javax.swing.JTable tbDescricao;
    private javax.swing.JTextField txCodigo;
    private javax.swing.JTextField txDescricao;
    private javax.swing.JTextField txQtHoras;
    // End of variables declaration//GEN-END:variables
}
