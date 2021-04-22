/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.ModelTurma;
import controller.ControllerTurma;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.BLDatas;
import util.BLTiraAcentos;

/**
 *
 * @author charles
 */
public class ViewTurma extends javax.swing.JFrame {

    ModelTurma modelTurma = new ModelTurma();
    ControllerTurma controllerTurma = new ControllerTurma();
    ArrayList<ModelTurma> listaModelTurmas = new ArrayList<>();
    String salvarAlterar;

    /**
     * Creates new form ModeloMini
     */
    public ViewTurma() {
        initComponents();
        setLocationRelativeTo(null);
        habilitaCampo(false);
        btAlterar.setEnabled(true);
        btCancelar.setEnabled(false);
        btSalvar.setEnabled(false);
        btNovo.setEnabled(true);
        this.carregarNcm();
        limpaCampos();
    }

    private boolean recuperarProduto() {
        salvarAlterar = "alterar";
        //recebe a linha selecionada
        int linha = this.tbDescricao.getSelectedRow();
        try {
            //recupera os dados do banco
            int codigo = (Integer) tbDescricao.getValueAt(linha, 0);
            
            //pega o codigo do ncm na linha selecionada  
            modelTurma = controllerTurma.getTurmaController(codigo);
            //seta os dados na interface
            this.txCodigo.setText(String.valueOf(modelTurma.getId()));
            this.txDescricao.setText(modelTurma.getDescricao());
            this.txDias.setText(modelTurma.getDias());
            this.txAno.setText(modelTurma.getAno());

            SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
            Date inicio, fim, formatura;
            try {
                inicio = formato.parse(modelTurma.getInicio());
                fim = formato.parse(modelTurma.getFim());
                formatura = formato.parse(modelTurma.getData_formatura());
//            dataEntrevista = formato.parse(modelAluno.getDt_entrevista());
                this.jcdInicio.setDate(inicio);
                this.jcdFim.setDate(fim);
                this.jcdDataFormatura.setDate(formatura);
                //   jcdDataEntrevista.setDate(dataEntrevista);

            } catch (ParseException ex) {
                Logger.getLogger(ViewAluno.class.getName()).log(Level.SEVERE, null, ex);
            }

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
        salvarAlterar = "novo";
        BLDatas bl = new BLDatas();
        Date dtInicio = null;
        Date dtFim = null;
        Date dtFormatura = null;

        modelTurma.setDescricao(txDescricao.getText());
        modelTurma.setAno(txAno.getText());
        modelTurma.setDias(txDias.getText());

        try {
            if (jcdInicio.getDate() == null) {
                dtInicio = null;
            } else {
                dtInicio = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdInicio.getDate()));
            }
            if (jcdFim.getDate() == null) {
                dtFim = null;
            } else {
                dtFim = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdFim.getDate()));
            }
            if (jcdDataFormatura.getDate() == null) {
                dtFormatura = null;
            } else {
                dtFormatura = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataFormatura.getDate()));
            }
        } catch (Exception e) {
        }

        if (controllerTurma.salvarTurmaController(modelTurma) > 0) {
            JOptionPane.showMessageDialog(this, "Registro salvo com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao salvar o registro!");
        }

    }

    private void alterar() {
        salvarAlterar = "alterar";
        BLDatas bl = new BLDatas();
        modelTurma.setDescricao(txDescricao.getText());
        modelTurma.setId(Integer.parseInt(txCodigo.getText()));
        
        Date inicio = null, fim =null, formatura = null;
           try {
            inicio = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdInicio.getDate()));
            fim = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdFim.getDate()));
            formatura = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataFormatura.getDate()));
        } catch (Exception ex) {
            Logger.getLogger(ViewAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
           DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dtInicio = dateFormat.format(inicio);
        String dtFim = dateFormat.format(fim);
        String dtFormatura = dateFormat.format(formatura);

        modelTurma.setInicio(dtInicio);
        modelTurma.setFim(dtFim);
        modelTurma.setData_formatura(dtFormatura);
        modelTurma.setAno(txAno.getText());
        modelTurma.setDias(txDias.getText());
           
        if (controllerTurma.atualizarTurmaController(modelTurma)) {
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar o registro!");
        }

    }

    private void habilitaCampo(boolean condicao) {
        txCodigo.setEnabled(condicao);
        txDescricao.setEnabled(condicao);
        txAno.setEnabled(condicao);
        txDias.setEnabled(condicao);
        jcdDataFormatura.setEnabled(condicao);
        jcdInicio.setEnabled(condicao);
        jcdFim.setEnabled(condicao);

    }

    private void limpaCampos() {
        txCodigo.setText("");
        txDescricao.setText("");
        txAno.setText("");
        txDias.setText("");
         Date date = null;
        jcdInicio.setDate(date);
        jcdFim.setDate(date);
        jcdDataFormatura.setDate(date);
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
        txAno = new javax.swing.JTextField();
        txDias = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcdInicio = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcdDataFormatura = new com.toedter.calendar.JDateChooser();
        jcdFim = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de turmas");

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

        jLabel1.setText("Código");

        jLabel2.setText("Descrição");

        tbDescricao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Ano", "Início", "Dias", "Fim", "Data de formatura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
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
            tbDescricao.getColumnModel().getColumn(3).setResizable(false);
            tbDescricao.getColumnModel().getColumn(4).setResizable(false);
            tbDescricao.getColumnModel().getColumn(5).setResizable(false);
            tbDescricao.getColumnModel().getColumn(6).setResizable(false);
        }

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        txDias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txDiasKeyReleased(evt);
            }
        });

        jLabel3.setText("Ano");

        jLabel4.setText("Início");

        jLabel5.setText("Dias");

        jLabel6.setText("Fim");

        jLabel7.setText("Data da formatura");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
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
                            .addComponent(txDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txAno, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcdInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txDias, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcdFim, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jcdDataFormatura, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcdFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcdDataFormatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcdInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btAlterar)
                    .addComponent(btCancelar)
                    .addComponent(btNovo))
                .addGap(28, 28, 28))
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
            btAlterar.setEnabled(true);
            btCancelar.setEnabled(false);
            btSalvar.setEnabled(false);
            btNovo.setEnabled(true);
            this.carregarNcm();

        } else if (salvarAlterar.equals("alterar")) {

            alterar();
            habilitaCampo(false);
            limpaCampos();

            btAlterar.setEnabled(true);
            btCancelar.setEnabled(false);
            btSalvar.setEnabled(false);
            btNovo.setEnabled(true);
            this.carregarNcm();

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
        this.txDescricao.setText(txDescricao.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txDescricao.setText(blTiraAcentos.TiraAcentos(txDescricao.getText()));
    }//GEN-LAST:event_txDescricaoKeyReleased

    private void txDiasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDiasKeyReleased
                // converte em maiusculo o que o usuario digitar
        this.txDias.setText(txDias.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txDias.setText(blTiraAcentos.TiraAcentos(txDias.getText()));
    }//GEN-LAST:event_txDiasKeyReleased

    private void carregarNcm() {
        listaModelTurmas = controllerTurma.getListaTurmaController();
        DefaultTableModel modelo = (DefaultTableModel) tbDescricao.getModel();
        modelo.setNumRows(0);
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listaModelTurmas.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelTurmas.get(i).getId(),
                listaModelTurmas.get(i).getDescricao(),
                listaModelTurmas.get(i).getAno(),
                listaModelTurmas.get(i).getInicio(),
                listaModelTurmas.get(i).getDias(),
                listaModelTurmas.get(i).getFim(),
                listaModelTurmas.get(i).getData_formatura(),});
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
            java.util.logging.Logger.getLogger(ViewTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTurma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jcdDataFormatura;
    private com.toedter.calendar.JDateChooser jcdFim;
    private com.toedter.calendar.JDateChooser jcdInicio;
    private javax.swing.JTable tbDescricao;
    private javax.swing.JTextField txAno;
    private javax.swing.JTextField txCodigo;
    private javax.swing.JTextField txDescricao;
    private javax.swing.JTextField txDias;
    // End of variables declaration//GEN-END:variables
}
