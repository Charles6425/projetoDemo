/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerAluno;
import controller.ControllerEventos;
import controller.ControllerSala;
import controller.ControllerTurma;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.ModelAluno;
import model.ModelEventos;
import model.ModelSala;
import model.ModelTurma;
import util.BLDatas;
import util.BLTiraAcentos;
import model.ModelCodEvento;
import controller.ControllerCodEvento;

/**
 *
 * @author charles
 */
public class ViewEventos extends javax.swing.JFrame {

    ModelEventos modelEventos = new ModelEventos();
    ModelCodEvento modelCodEvento = new ModelCodEvento();
    ControllerCodEvento controllerCodEvento = new ControllerCodEvento();
    ControllerEventos controllerEventos = new ControllerEventos();
    ArrayList<ModelCodEvento>listaCodEventos = new ArrayList<>();
    ArrayList<ModelEventos> listaEventos = new ArrayList<>();
    public int codigoAluno;
    String salvarAlterar;

    /**
     * Creates new form ViewEventos
     */
    public ViewEventos() {
        initComponents();
        setLocationRelativeTo(null);
        preencherEvento();
    }
    
        public void preencherEvento() {
        listaCodEventos = controllerCodEvento.getListaCodEventoController();

        cbEvento.removeAllItems();
        for (int i = 0; i < listaCodEventos.size(); i++) {
            cbEvento.addItem(listaCodEventos.get(i).getDescricao());

        }

    }


    //carrega os dados do aluno
    private void carregarAlunos(int pcodigoAluno) {
        ControllerAluno controllerAluno = new ControllerAluno();
        ModelAluno modelAluno = new ModelAluno();
        modelAluno = controllerAluno.getGeralController(codigoAluno);

    }

    private void adicionaAluno() {
        BLDatas bl = new BLDatas();
        ModelAluno modelAluno = new ModelAluno();
        ModelTurma modelTurma = new ModelTurma();
        ModelSala modelSala = new ModelSala();
        ControllerSala controllerSala = new ControllerSala();
        ControllerTurma controllerTurma = new ControllerTurma();
        ControllerAluno controllerAluno = new ControllerAluno();
        modelAluno = controllerAluno.getGeralController(codigoAluno);
        modelTurma = controllerTurma.getTurmaController(modelAluno.getTurma());
        modelSala = controllerSala.getSalaController(modelAluno.getSala());

        DefaultTableModel modelo = (DefaultTableModel) tbAluno.getModel();
        int cont = 0;

        for (int i = 0; i < cont; i++) {
            modelo.setNumRows(0);
        }
        try {
            //pega a quantidade de linhas e joga na variavel
            modelo.addRow(new Object[]{
                modelAluno.getId(),
                modelAluno.getNome_aluno(),
                modelAluno.getRgm_aluno(),
                modelTurma.getDescricao(),
                modelSala.getDescricao()

            });
        } catch (Exception ex) {
            Logger.getLogger(ViewAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void habilitaCampo(Boolean condicao) {
        txCodigo.setEditable(condicao);
        txAno.setEditable(condicao);
          btPesquisar.setEnabled(condicao);

    }

    private void limpaCampos() {
        txAno.setText("");
        txCodigo.setText("");
        DefaultTableModel modelo = (DefaultTableModel) tbAluno.getModel();
        modelo.setNumRows(0);

    }

    private void salvar() {

        listaEventos = controllerEventos.getListaEventosController();
        int cont = tbAluno.getRowCount();

        for (int i = listaEventos.size(); i < cont; i++) {
            

            modelEventos.setAno(txAno.getText());
            modelEventos.setId_aluno((int) tbAluno.getValueAt(i, 0));
            modelEventos.setId_evento(cbEvento.getSelectedIndex()+1);
            controllerEventos.salvarEventosController(modelEventos);

        }

    }
    private void alterar() {

        listaEventos = controllerEventos.getListaEventosController();
        int cont = tbAluno.getRowCount();

        for (int i = listaEventos.size(); i < cont; i++) {
            

            modelEventos.setAno(txAno.getText());
            modelEventos.setId_aluno((int) tbAluno.getValueAt(i, 0));
            modelEventos.setId_evento(cbEvento.getSelectedIndex()+1);
            controllerEventos.atualizarEventosController(modelEventos);

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAluno = new javax.swing.JTable();
        txAno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btCancelar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btPesqEvento = new javax.swing.JButton();
        cbEvento = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eventos");

        txCodigo.setEditable(false);
        txCodigo.setFocusable(false);

        jLabel1.setText("Código");

        jLabel2.setText("Evento");

        tbAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "RGM", "Turma", "Sala"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbAluno);
        if (tbAluno.getColumnModel().getColumnCount() > 0) {
            tbAluno.getColumnModel().getColumn(0).setResizable(false);
            tbAluno.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbAluno.getColumnModel().getColumn(2).setResizable(false);
            tbAluno.getColumnModel().getColumn(3).setResizable(false);
            tbAluno.getColumnModel().getColumn(4).setResizable(false);
            tbAluno.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        jLabel3.setText("Ano");

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Lupa.png"))); // NOI18N
        btPesquisar.setText("    ");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        jLabel4.setText("Aspirante");

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

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Salvar.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Adicionar.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btPesqEvento.setText("Pesquisar Eventos");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Adicionar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Criar evento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txCodigo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btPesquisar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addContainerGap(90, Short.MAX_VALUE))
                            .addComponent(txAno)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(btPesqEvento))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txAno)
                    .addComponent(txCodigo)
                    .addComponent(cbEvento, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(8, 8, 8)
                .addComponent(btPesquisar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btPesqEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btSalvar)
                    .addComponent(btAlterar)
                    .addComponent(btCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        ViewPesquisaAluno viewPesquisaAluno = new ViewPesquisaAluno(this, rootPaneCheckingEnabled);
        viewPesquisaAluno.setVisible(true);
        codigoAluno = viewPesquisaAluno.getReturnStatus();
        carregarAlunos(codigoAluno);
        adicionaAluno();
        //limparVariavelImagem();
        // btPesquisar.setEnabled(false);

    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        habilitaCampo(false);
        btAlterar.setEnabled(false);
        btCancelar.setEnabled(false);
        btSalvar.setEnabled(false);
        btNovo.setEnabled(true);
        btPesquisar.setEnabled(true);
        btPesqEvento.setEnabled(true);
        limpaCampos();
        salvarAlterar = "";
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        salvarAlterar = "alterar";
        habilitaCampo(true);
        btPesquisar.setEnabled(false);
        btNovo.setEnabled(false);
        btAlterar.setEnabled(false);
        btSalvar.setEnabled(true);
        btCancelar.setEnabled(true);
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        if (salvarAlterar.equals("novo")) {
            salvar();
            habilitaCampo(false);
            limpaCampos();
            btAlterar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSalvar.setEnabled(false);
            btNovo.setEnabled(true);
            btPesquisar.setEnabled(true);
            btPesqEvento.setEnabled(true);
        } else if (salvarAlterar.equals("alterar")) {

            alterar();
            habilitaCampo(false);
            limpaCampos();
            btAlterar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSalvar.setEnabled(false);
            btNovo.setEnabled(true);
            btPesquisar.setEnabled(true);
            btPesqEvento.setEnabled(true);

        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        salvarAlterar = "novo";
        habilitaCampo(true);
        btPesquisar.setEnabled(true);
        btPesqEvento.setEnabled(false);
        btNovo.setEnabled(false);
        btAlterar.setEnabled(false);
        btSalvar.setEnabled(true);
        btCancelar.setEnabled(true);
        limpaCampos();

    }//GEN-LAST:event_btNovoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       ViewCodEvento viewCodEvento = new ViewCodEvento();
        viewCodEvento.setVisible(true);
        preencherEvento();
       
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewEventos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesqEvento;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbEvento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAluno;
    private javax.swing.JTextField txAno;
    private javax.swing.JTextField txCodigo;
    // End of variables declaration//GEN-END:variables
}