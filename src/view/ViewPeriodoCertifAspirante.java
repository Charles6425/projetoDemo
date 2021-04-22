/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.ModelPeriodoCertifAspirante;
import controller.ControllerPeriodoCertifAspirante;
import controller.ControllerAluno;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.BLTiraAcentos;

/**
 *
 * @author charles
 */
public class ViewPeriodoCertifAspirante extends javax.swing.JFrame {

    ModelPeriodoCertifAspirante modelPeriodoCertificado = new ModelPeriodoCertifAspirante();
    ControllerPeriodoCertifAspirante controllerPeriodoCertificado = new ControllerPeriodoCertifAspirante();
    ControllerAluno controllerAluno = new ControllerAluno();
    ArrayList<ModelPeriodoCertifAspirante> listaModePeriodo = new ArrayList<>();
    String salvarAlterar;
    public String codAluno;
    
    /**
     * Creates new form ModeloMini
     */
    public ViewPeriodoCertifAspirante() {
        initComponents();
        setLocationRelativeTo(null);
        habilitaCampo(false);
        btAlterar.setEnabled(true);
        btCancelar.setEnabled(false);
        btSalvar.setEnabled(false);
        btNovo.setEnabled(true);
        this.carregarPeriodoCertificado();

    }
    
    private void gerarRelatorio(){
        int linha = this.tbDescricao.getSelectedRow();
        int codigo = (Integer) tbDescricao.getValueAt(linha, 0);
        controllerAluno.gerarRelatorioCertificadoAspirante(codigo, Integer.parseInt(codAluno));
        System.out.println(codAluno);
        
    }

    private boolean recuperarProduto() {
        salvarAlterar = "alterar";
        //recebe a linha selecionada
        int linha = this.tbDescricao.getSelectedRow();
        try {
            //recupera os dados do banco
            int codigo = (Integer) tbDescricao.getValueAt(linha, 0);
            //pega o codigo do ncm na linha selecionada  
            modelPeriodoCertificado = controllerPeriodoCertificado.getPeriodoCertifAspiranteController(codigo);
            
            //seta os dados na interface
            this.txCodigo.setText(String.valueOf(modelPeriodoCertificado.getId()));
            this.txDescricao.setText(modelPeriodoCertificado.getDescricao());
            txPeriodo.setText(modelPeriodoCertificado.getPeriodo());
            txDataConclusao.setText(modelPeriodoCertificado.getData_conclusao());
            habilitaCampo(true);
            btSalvar.setEnabled(true);
            btCancelar.setEnabled(true);
            btAlterar.setEnabled(false);
            btNovo.setEnabled(false);
            tbDescricao.getSelectionModel().clearSelection();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private void salvar() {
        modelPeriodoCertificado.setDescricao(txDescricao.getText());
        modelPeriodoCertificado.setPeriodo(txPeriodo.getText());
        modelPeriodoCertificado.setData_conclusao(txDataConclusao.getText());
        salvarAlterar = "novo";
        if (controllerPeriodoCertificado.salvarPeriodoCertifAspiranteController(modelPeriodoCertificado) > 0) {
            JOptionPane.showMessageDialog(this, "Registro salvo com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao salvar o registro!");
        }

    }

    private void alterar() {
        salvarAlterar = "alterar";
        modelPeriodoCertificado.setDescricao(txDescricao.getText());
        modelPeriodoCertificado.setPeriodo(txPeriodo.getText());
        modelPeriodoCertificado.setData_conclusao(txDataConclusao.getText());

        if (controllerPeriodoCertificado.atualizarPeriodoCertifAspiranteController(modelPeriodoCertificado)) {
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar o registro!");
        }

    }

    private void habilitaCampo(boolean condicao) {
        txCodigo.setEnabled(condicao);
        txDescricao.setEnabled(condicao);
        txDataConclusao.setEnabled(condicao);
        txPeriodo.setEnabled(condicao);

    }

    private void limpaCampos() {
        txCodigo.setText("");
        txDescricao.setText("");
        txDataConclusao.setText("");
        txPeriodo.setText("");
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
        txPeriodo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txDataConclusao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Periodo Certificado Aspirante");

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

        jLabel2.setText("Descrição");

        tbDescricao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição", "Período", "Dt. Conclusão"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbDescricao);
        if (tbDescricao.getColumnModel().getColumnCount() > 0) {
            tbDescricao.getColumnModel().getColumn(0).setResizable(false);
            tbDescricao.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        jLabel3.setText("Periodo");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirma.png"))); // NOI18N
        jButton1.setText("Gerar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Conclusão (Data da entrega)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btNovo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btSalvar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btAlterar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btCancelar))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                        .addComponent(txPeriodo)
                        .addComponent(jLabel3)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(txDescricao)))
                        .addComponent(txDataConclusao))
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(7, 7, 7)
                .addComponent(txDataConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btSalvar)
                        .addComponent(btAlterar)
                        .addComponent(btCancelar)
                        .addComponent(btNovo))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        if (txDescricao.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Necessário informar o campo descrição", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
        } else if (salvarAlterar.equals("novo")) {
            salvar();
            habilitaCampo(false);
            limpaCampos();
            this.carregarPeriodoCertificado();
            btAlterar.setEnabled(true);
            btCancelar.setEnabled(false);
            btSalvar.setEnabled(false);
            btNovo.setEnabled(true);

        } else if (salvarAlterar.equals("alterar")) {

            alterar();
            this.carregarPeriodoCertificado();
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

    private void carregarPeriodoCertificado() {
        listaModePeriodo = controllerPeriodoCertificado.getListaPeriodoCertifAspiranteController();
        DefaultTableModel modelo = (DefaultTableModel) tbDescricao.getModel();
        modelo.setNumRows(0);
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listaModePeriodo.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModePeriodo.get(i).getId(),
                listaModePeriodo.get(i).getDescricao(),
                listaModePeriodo.get(i).getPeriodo(),
                listaModePeriodo.get(i).getData_conclusao()
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
            java.util.logging.Logger.getLogger(ViewPeriodoCertifAspirante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPeriodoCertifAspirante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPeriodoCertifAspirante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPeriodoCertifAspirante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPeriodoCertifAspirante().setVisible(true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDescricao;
    private javax.swing.JTextField txCodigo;
    private javax.swing.JTextField txDataConclusao;
    private javax.swing.JTextField txDescricao;
    private javax.swing.JTextField txPeriodo;
    // End of variables declaration//GEN-END:variables

    public String getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(String codAluno) {
        this.codAluno = codAluno;
    }
}
