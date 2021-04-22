/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.ModelMateria;
import model.ModelAluno;
import model.ModelAlunoFaltas;
import controller.ControllerAlunoFaltas;
import controller.ControllerAluno;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.BLMascaras;

/**
 *
 * @author charles
 */
public class ViewAlunoFalta extends javax.swing.JFrame {

    public static String getRgmAluno() {
        return rgmAluno;
    }

    public static void setRgmAluno(String aRgmAluno) {
        rgmAluno = aRgmAluno;
    }



    ModelMateria modelMateria = new ModelMateria();
    ModelAluno modelAluno = new ModelAluno();
    ModelAlunoFaltas modelAlunoFaltas = new ModelAlunoFaltas();
    ControllerAlunoFaltas controllerAlunoFaltas = new ControllerAlunoFaltas();
    ControllerAluno controllerAluno = new ControllerAluno();

    ArrayList<ModelAluno> listaModelAlunos = new ArrayList<>();
    ArrayList<ModelMateria> listaModelMaterias = new ArrayList<>();
    ArrayList<ModelAlunoFaltas> listaModelAlunoFaltases = new ArrayList<>();
    public int codigoProduto;
    public float quantidadeProduto;
    public static int codPrincipal;
    private static String rgmAluno;

    ViewProduto viewProduto;

    public ViewAlunoFalta() {
        initComponents();
        setLocationRelativeTo(null);

//        this.caregaItens();
        this.habilitaCampos(false);
        this.caregaNotas();
        btAdicionar.setEnabled(false);
        btCancelar.setEnabled(false);
        btCancelar.setEnabled(false);
        btExcluir.setEnabled(false);

        btSalvar.setEnabled(false);
        btRemoveIngr.setEnabled(false);
        btAlterar.setEnabled(true);

    }

    private void habilitaCampos(boolean condicao) {
        txNota.setEnabled(condicao);

    }

    private void caregaNotas() {
        

        
        
    }

    private void adicionarProdutoPesquisa(int pCodigoProduto) {
        ControllerAlunoFaltas controller = new ControllerAlunoFaltas();
        ModelAlunoFaltas modelAlunoFaltas = new ModelAlunoFaltas();
        DefaultTableModel modelo = (DefaultTableModel) tbMateria.getModel();
        modelAlunoFaltas = controllerAlunoFaltas.getAlunoFaltasController(pCodigoProduto);
        BLMascaras bLMascaras = new BLMascaras();

        modelo.addRow(new Object[]{
            modelMateria.getId(),
            modelMateria.getDescricao(),
            txNota.getText(),});

        quantidadeProduto = 1;

    }

    private void preencherTxItens(int pCodigoProduto) {
        ControllerAlunoFaltas controllerAlunoFaltas = new ControllerAlunoFaltas();
        ModelAlunoFaltas modelAlunoFaltas = new ModelAlunoFaltas();
        modelAlunoFaltas = controllerAlunoFaltas.getAlunoFaltasController(codigoProduto);
        txItem.setText(modelMateria.getDescricao());

    }

    private void limpaCampos() {
        codigoProduto = 0;
        txItem.setText("");
        txNota.setText("");

    }

    private void removeItem() {
        int linhaSelecionada = tbMateria.getSelectedRow();
        // Verificamos se existe realmente alguma linha selecionada
        if (linhaSelecionada < 0) {
            return;
        } else {
            // Obtem o modelo da JTable
            DefaultTableModel modelo = (DefaultTableModel) tbMateria.getModel();
            // Remove a linha
            modelo.removeRow(linhaSelecionada);
        }
    }

    private void limparTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbMateria.getModel();
        modelo.setNumRows(0);

    }

    private void salvar() {
        listaModelAlunoFaltases = controllerAlunoFaltas.getListaAlunoFaltasController();
        int cont = tbMateria.getRowCount();

        for (int i = listaModelAlunoFaltases.size(); i < cont; i++) {
            modelAlunoFaltas.setData(txRgm.getText());
            modelAlunoFaltas.setMotivo(txItem.getText());
            //modelAlunoNota.setNota(Float.parseFloat((String) tbMateria.getValueAt(i, 2)));
            //controllerAlunoNota.salvarAlunoNotaController(modelAlunoNota);
        }

        JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
    }

    /*

    private void caregaItens() {

        listaModelFichaTecnica = controllerFichaTecnica.getListaFichaTecnicaController(getCodPrincipal());

        DefaultTableModel modelo = (DefaultTableModel) tbProdutos.getModel();

        modelo.setNumRows(0);
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listaModelFichaTecnica.size();
        for (int i = 0; i < cont; i++) {
            modelProdutos = controllerProdutos.getProdutosController(listaModelFichaTecnica.get(i).getCod_item_composicao());
            modelo.addRow(new Object[]{
                listaModelFichaTecnica.get(i).getCod_item_composicao(),
                //listaModelFichaTecnica.get(i).getCod_item_composicao(),
                modelProdutos.getNome(),
                listaModelFichaTecnica.get(i).getQuantidade(),
                listaModelFichaTecnica.get(i).getCod_unidade(),
                //modelProdutos.getProd_custo() * listaModelFichaTecnica.get(i).getQuantidade() / modelProdutos.getFator_conversao(),});
               modelProdutos.getProd_custo() / modelProdutos.getFator_conversao(),});
                
        }
    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txCodigoPrincipal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txRgm = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btAdicionar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        txNota = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMateria = new javax.swing.JTable();
        txItem = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btRemoveIngr = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aluno - Faltas");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Aluno"));

        txDescricao.setEditable(false);
        txDescricao.setFocusable(false);

        jLabel2.setText("Aluno");

        txCodigoPrincipal.setEditable(false);

        jLabel1.setText("Código");

        txRgm.setEditable(false);

        jLabel6.setText("RGM");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txCodigoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txRgm))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txCodigoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txRgm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Composição de notas"));

        jLabel4.setText("Motivo");

        btAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/plus.png"))); // NOI18N
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/minus.png"))); // NOI18N
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        txNota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txNotaKeyReleased(evt);
            }
        });

        jLabel5.setText("Data");

        tbMateria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Motivo", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbMateria);
        if (tbMateria.getColumnModel().getColumnCount() > 0) {
            tbMateria.getColumnModel().getColumn(0).setResizable(false);
            tbMateria.getColumnModel().getColumn(1).setResizable(false);
            tbMateria.getColumnModel().getColumn(2).setResizable(false);
        }

        txItem.setFocusable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txItem, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txNota)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txNota, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txItem, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Salvar.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Editar.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btRemoveIngr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sair.png"))); // NOI18N
        btRemoveIngr.setText("Remover Tudo");
        btRemoveIngr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoveIngrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(btRemoveIngr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btCancelar))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRemoveIngr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAlterar)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        if (codigoProduto == 0) {
            JOptionPane.showMessageDialog(this, "Selecione um produto!", "Atenção!", JOptionPane.ERROR_MESSAGE);
        } else if (txNota.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Digite a quantidade!", "Atenção!", JOptionPane.ERROR_MESSAGE);
            txNota.requestFocusInWindow();

        } else {
            this.adicionarProdutoPesquisa(codigoProduto);

            limpaCampos();
        }
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        this.removeItem();
        limpaCampos();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        btAdicionar.setEnabled(true);
        btCancelar.setEnabled(true);
        btCancelar.setEnabled(true);
        btExcluir.setEnabled(true);

        btSalvar.setEnabled(true);
        btRemoveIngr.setEnabled(true);
        btAlterar.setEnabled(false);
        habilitaCampos(true);
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        salvar();
        btAdicionar.setEnabled(false);
        btCancelar.setEnabled(false);
        btCancelar.setEnabled(false);
        btExcluir.setEnabled(false);

        btSalvar.setEnabled(false);
        btRemoveIngr.setEnabled(false);
        btAlterar.setEnabled(true);
        habilitaCampos(false);
//        atualizaValorCusto(codPrincipal);

    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.limpaCampos();
        this.limparTabela();
        btAdicionar.setEnabled(false);
        btCancelar.setEnabled(false);
        btCancelar.setEnabled(false);
        btExcluir.setEnabled(false);

        btSalvar.setEnabled(false);
        btRemoveIngr.setEnabled(false);
        btAlterar.setEnabled(true);
        habilitaCampos(false);

    }//GEN-LAST:event_btCancelarActionPerformed

    private void txNotaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNotaKeyReleased
        this.txNota.setText(new BLMascaras().converterVirgulaParaPonto(this.txNota.getText()));

    }//GEN-LAST:event_txNotaKeyReleased

    private void btRemoveIngrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoveIngrActionPerformed
//        controllerFichaTecnica.excluirFichaTecnicaController((int) tbProdutos.getValueAt(tbProdutos.getSelectedRow(), 0), (Integer.parseInt(txCodigoPrincipal.getText())));

        JOptionPane.showMessageDialog(this, "Item removido com sucesso");
//        caregaItens();


    }//GEN-LAST:event_btRemoveIngrActionPerformed
    /*
    private float atualizaCusto() {
        float soma = 0;
        float valor = 0;

        int cont = tbProdutos.getRowCount();

        for (int i = 0; i < cont; i++) {
            modelProdutos = controllerProdutos.getProdutosController(Integer.parseInt((tbProdutos.getValueAt(i, 0).toString())));
            float fatorConversao = modelProdutos.getFator_conversao();
           // valor = modelProdutos.getProd_custo() * Float.parseFloat(tbProdutos.getValueAt(i, 2).toString());
            valor = Float.parseFloat(tbProdutos.getValueAt(i, 4).toString()) * Float.parseFloat(tbProdutos.getValueAt(i, 2).toString());
            
            soma = valor + soma;
            
            System.out.println(soma);
        }
        return (float) soma;
    }*/

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
            java.util.logging.Logger.getLogger(ViewAlunoFalta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAlunoFalta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAlunoFalta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAlunoFalta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAlunoFalta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btRemoveIngr;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbMateria;
    public javax.swing.JTextField txCodigoPrincipal;
    public javax.swing.JTextField txDescricao;
    private javax.swing.JTextField txItem;
    private javax.swing.JTextField txNota;
    public javax.swing.JTextField txRgm;
    // End of variables declaration//GEN-END:variables

    void setCodProduto(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCodPrincipal() {
        return codPrincipal;
    }

    public void setCodPrincipal(int codPrincipal) {
        this.codPrincipal = codPrincipal;
    }



}
