/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerAluno;
import controller.ControllerCadEndereco;
import java.awt.Color;
import java.awt.Component;
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
import model.ModelAluno;
import model.ModelCadEndereco;
import util.BLTiraAcentos;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.ModelSala;
import controller.ControllerSala;
import model.ModelTurma;
import controller.ControllerTurma;
import model.ModelPeriodo;
import controller.ControllerPeriodo;
import model.ModelLocalAprendizagem;
import controller.ControllerLocalAprendizagem;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.BLDatas;

/**
 *
 * @author Administrador
 */
public class ViewPesquisaAlunoFiltro extends javax.swing.JDialog {

    String CLASS;
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
    ModelSala modelSala = new ModelSala();
    ModelAluno modelAluno = new ModelAluno();
    ModelTurma modelTurma = new ModelTurma();
    ModelPeriodo modelPeriodo = new ModelPeriodo();
    ModelLocalAprendizagem modelLocalAprendizagem = new ModelLocalAprendizagem();
    ControllerSala controllerSala = new ControllerSala();
    ControllerTurma controllerTurma = new ControllerTurma();
    ControllerPeriodo controllerPeriodo = new ControllerPeriodo();
    ControllerAluno controllerAluno = new ControllerAluno();
    ControllerLocalAprendizagem controllerLocalAprendizagem = new ControllerLocalAprendizagem();
    ArrayList<ModelSala> listaModelSalas = new ArrayList<>();
    ArrayList<ModelTurma> listaModelTurmas = new ArrayList<>();
    ArrayList<ModelPeriodo> listaModelPeriodo = new ArrayList<>();
    ArrayList<ModelLocalAprendizagem> listaModelLocal = new ArrayList<>();

    public ViewPesquisaAlunoFiltro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        setLocationRelativeTo(null);
        carregarCadastros();
        rbRgm.setSelected(true);
        txAluno.requestFocusInWindow();
        preencherSala();
        preencherTurma();
        preencherPeriodo();
        preencherLocalAprend();

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

    private void preencherSala() {
        listaModelSalas = controllerSala.getListaSalaController();

        cbSala.removeAllItems();
        for (int i = 0; i < listaModelSalas.size(); i++) {
            cbSala.addItem(listaModelSalas.get(i).getDescricao());

        }

    }

    private void preencherTurma() {
        listaModelTurmas = controllerTurma.getListaTurmaController();

        cbTurma.removeAllItems();
        for (int i = 0; i < listaModelTurmas.size(); i++) {
            cbTurma.addItem(listaModelTurmas.get(i).getDescricao());

        }

    }

    private void preencherPeriodo() {
        listaModelPeriodo = controllerPeriodo.getListaPeriodoController();

        cbPeriodo.removeAllItems();
        for (int i = 0; i < listaModelPeriodo.size(); i++) {
            cbPeriodo.addItem(listaModelPeriodo.get(i).getDescricao());

        }

    }

    private void preencherLocalAprend() {
        listaModelLocal = controllerLocalAprendizagem.getListaLocalAprendizagemController();

        cbLocalAprendizagem.removeAllItems();
        for (int i = 0; i < listaModelLocal.size(); i++) {
            cbLocalAprendizagem.addItem(listaModelLocal.get(i).getDescricao());

        }

    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    public void corNaLinha() {
        CLASS = "ATIVO";
        tbAluno.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component componente(JTable table, Object value, boolean isSelected, boolean haFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, haFocus, row, column);

                Color c = Color.WHITE;
                Object texto = table.getValueAt(row, 3);
                System.out.println(texto);
                if (texto != null && CLASS.equals(texto.toString())) {
                    c = Color.RED;
                    label.setBackground(c);
                    tbAluno.setSelectionForeground(Color.GREEN);

                }

                return label;

            }

        });
    }
    private void pesquisaPorSexo(){
        
        DefaultTableModel tabela = (DefaultTableModel) this.tbLocal.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabela);


        this.tbLocal.setRowSorter(sorter);
        String text = (String) cbSexo.getSelectedItem();

        sorter.setRowFilter(RowFilter.regexFilter(text, 8));
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
        txAluno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        rbRgm = new javax.swing.JRadioButton();
        rbNome = new javax.swing.JRadioButton();
        cbSala = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbTurma = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbPeriodo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbLocalAprendizagem = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btSexo = new javax.swing.JButton();
        btLocal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLocal = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSexo = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbPeriodo = new javax.swing.JTable();
        btPeriodo = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbTurma = new javax.swing.JTable();
        btTurma = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbSala = new javax.swing.JTable();
        btSala = new javax.swing.JButton();

        setTitle("Pesquisa de aspirantes");
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
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "rgm", "Situação", "Sala", "Turma", "Período", "Local", "Sexo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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

        txAluno.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txAluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txAlunoKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Aluno:");

        jButton1.setText("Config.");
        jButton1.setEnabled(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbRgm);
        rbRgm.setText("RGM");

        buttonGroup1.add(rbNome);
        rbNome.setText("Nome");

        jLabel2.setText("Sala");

        jLabel3.setText("Turma");

        jLabel4.setText("Período");

        jLabel5.setText("Local de Aprendizagem");

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULINO", "FEMININO" }));
        cbSexo.setToolTipText("");

        jLabel6.setText("Sexo");

        btSexo.setText("OK");
        btSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSexoActionPerformed(evt);
            }
        });

        btLocal.setText("Ok");
        btLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLocalActionPerformed(evt);
            }
        });

        tbLocal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Local"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbLocal);
        if (tbLocal.getColumnModel().getColumnCount() > 0) {
            tbLocal.getColumnModel().getColumn(0).setResizable(false);
        }

        tbSexo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sexo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbSexo);
        if (tbSexo.getColumnModel().getColumnCount() > 0) {
            tbSexo.getColumnModel().getColumn(0).setResizable(false);
        }

        tbPeriodo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Priodo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbPeriodo);
        if (tbPeriodo.getColumnModel().getColumnCount() > 0) {
            tbPeriodo.getColumnModel().getColumn(0).setResizable(false);
        }

        btPeriodo.setText("Ok");
        btPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPeriodoActionPerformed(evt);
            }
        });

        tbTurma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Turma"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tbTurma);
        if (tbTurma.getColumnModel().getColumnCount() > 0) {
            tbTurma.getColumnModel().getColumn(0).setResizable(false);
        }

        btTurma.setText("Ok");
        btTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTurmaActionPerformed(evt);
            }
        });

        tbSala.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sala"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tbSala);
        if (tbSala.getColumnModel().getColumnCount() > 0) {
            tbSala.getColumnModel().getColumn(0).setResizable(false);
        }

        btSala.setText("Ok");
        btSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(105, 105, 105)
                                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbSala, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btSala))
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btTurma))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cbPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btPeriodo))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbLocalAprendizagem, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(btLocal))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btSexo)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbRgm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbNome)
                                .addGap(53, 53, 53)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbRgm)
                                        .addComponent(rbNome)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btTurma)
                                .addComponent(btSala))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btSexo)
                                    .addComponent(btLocal)
                                    .addComponent(cbLocalAprendizagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btPeriodo))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1)
                        .addGap(16, 16, 16)
                        .addComponent(txAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addContainerGap())
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

    private void txAlunoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txAlunoKeyReleased
        DefaultTableModel tabela = (DefaultTableModel) this.tbAluno.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabela);

        //Charles - tornar a caixa de pesquisa em letra maiuscula e tirar acentos
        // converte em maiusculo o que o usuario digitar
        this.txAluno.setText(txAluno.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txAluno.setText(blTiraAcentos.TiraAcentos(txAluno.getText()));

        this.tbAluno.setRowSorter(sorter);
        String text = txAluno.getText();

        if (rbNome.isSelected()) {

            sorter.setRowFilter(RowFilter.regexFilter(text, 1));
        } else if (rbRgm.isSelected()) {

            sorter.setRowFilter(RowFilter.regexFilter(text, 2));

        }

        
        

    }//GEN-LAST:event_txAlunoKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        corNaLinha();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSexoActionPerformed
          
        BLDatas bl = new BLDatas();

        DefaultTableModel modelo = (DefaultTableModel) tbSexo.getModel();
        int cont = 0;

        for (int i = 0; i < cont; i++) {
            modelo.setNumRows(0);
        }
        try {
            //pega a quantidade de linhas e joga na variavel
            modelo.addRow(new Object[]{
                cbSexo.getSelectedItem(),
            });
        } catch (Exception ex) {
            Logger.getLogger(ViewAluno.class.getName()).log(Level.SEVERE, null, ex);
        }



    }//GEN-LAST:event_btSexoActionPerformed

    private void btLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLocalActionPerformed
        BLDatas bl = new BLDatas();

        DefaultTableModel modelo = (DefaultTableModel) tbLocal.getModel();
        int cont = 0;

        for (int i = 0; i < cont; i++) {
            modelo.setNumRows(0);
        }
        try {
            //pega a quantidade de linhas e joga na variavel
            modelo.addRow(new Object[]{
                cbLocalAprendizagem.getSelectedItem(),
            });
        } catch (Exception ex) {
            Logger.getLogger(ViewAluno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btLocalActionPerformed

    private void btPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPeriodoActionPerformed
               BLDatas bl = new BLDatas();

        DefaultTableModel modelo = (DefaultTableModel) tbPeriodo.getModel();
        int cont = 0;

        for (int i = 0; i < cont; i++) {
            modelo.setNumRows(0);
        }
        try {
            //pega a quantidade de linhas e joga na variavel
            modelo.addRow(new Object[]{
                cbPeriodo.getSelectedItem(),
            });
        } catch (Exception ex) {
            Logger.getLogger(ViewAluno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btPeriodoActionPerformed

    private void btTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTurmaActionPerformed
                     BLDatas bl = new BLDatas();

        DefaultTableModel modelo = (DefaultTableModel) tbTurma.getModel();
        int cont = 0;

        for (int i = 0; i < cont; i++) {
            modelo.setNumRows(0);
        }
        try {
            //pega a quantidade de linhas e joga na variavel
            modelo.addRow(new Object[]{
                cbTurma.getSelectedItem(),
            });
        } catch (Exception ex) {
        }   
    }//GEN-LAST:event_btTurmaActionPerformed

    private void btSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalaActionPerformed
                           BLDatas bl = new BLDatas();

        DefaultTableModel modelo = (DefaultTableModel) tbSala.getModel();
        int cont = 0;

        for (int i = 0; i < cont; i++) {
            modelo.setNumRows(0);
        }
        try {
            //pega a quantidade de linhas e joga na variavel
            modelo.addRow(new Object[]{
                cbSala.getSelectedItem(),
            });
        } catch (Exception ex) {
        }   
    }//GEN-LAST:event_btSalaActionPerformed

    private void doClose(int retStatus) {
        int linha = tbAluno.getSelectedRow();
        int codigo = (int) tbAluno.getValueAt(linha, 0);
        returnStatus = codigo;
        setVisible(false);
        dispose();
    }

    private void carregarCadastros() {
        ControllerAluno controllerAluno = new ControllerAluno();

        ArrayList<ModelAluno> listamModelAlunos = new ArrayList<>();
        modelSala = controllerSala.getSalaController(modelAluno.getSala());
        // listamModelAlunos = controllerAluno.getListaAlunoController();
        listamModelAlunos = controllerAluno.getListaGeralController();
        DefaultTableModel modelo = (DefaultTableModel) tbAluno.getModel();
        modelo.setNumRows(0);
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listamModelAlunos.size();
        for (int i = 0; i < cont; i++) {
            modelSala = controllerSala.getSalaController(listamModelAlunos.get(i).getSala());
            modelTurma = controllerTurma.getTurmaController(listamModelAlunos.get(i).getTurma());
            modelPeriodo = controllerPeriodo.getPeriodoController(listamModelAlunos.get(i).getPeriodo());
            modelLocalAprendizagem = controllerLocalAprendizagem.getLocalAprendizagemController(listamModelAlunos.get(i).getLocal_aprendizagem());

            modelo.addRow(new Object[]{
                listamModelAlunos.get(i).getId(),
                listamModelAlunos.get(i).getNome_aluno(),
                listamModelAlunos.get(i).getRgm_aluno(),
                listamModelAlunos.get(i).getSituacao(),
                modelSala.getDescricao(),
                modelTurma.getDescricao(),
                modelPeriodo.getDescricao(),
                modelLocalAprendizagem.getDescricao(),
                listamModelAlunos.get(i).getSexo()});
        }

    }

    /**
     * charles muller método que tira acentos e deixa com letra maiuscula
     * automaticamente
     */
    private void tirarAcentos() {

        ControllerAluno controllerAluno = new ControllerAluno();
        ArrayList<ModelAluno> listamModelAluno = new ArrayList<>();
        ModelAluno modelAluno = new ModelAluno();

        //listamModelUsuarios = controllerUsuario.getListaUsuarioController();
        listamModelAluno = controllerAluno.getListaAlunoController();
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        int cont = listamModelAluno.size();
        for (int i = 0; i < cont; i++) {
            modelAluno = controllerAluno.getAlunoController(listamModelAluno.get(i).getId());

            modelAluno.setNome_aluno(modelAluno.getNome_aluno().toUpperCase());
            modelAluno.setNome_aluno(blTiraAcentos.TiraAcentos(modelAluno.getNome_aluno()));
            controllerAluno.atualizarAlunoController(modelAluno);
            System.out.println(modelAluno.getNome_aluno());
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
            java.util.logging.Logger.getLogger(ViewPesquisaAlunoFiltro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPesquisaAlunoFiltro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPesquisaAlunoFiltro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPesquisaAlunoFiltro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewPesquisaAlunoFiltro dialog = new ViewPesquisaAlunoFiltro(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btLocal;
    private javax.swing.JButton btPeriodo;
    private javax.swing.JButton btSala;
    private javax.swing.JButton btSexo;
    private javax.swing.JButton btTurma;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> cbLocalAprendizagem;
    private javax.swing.JComboBox<String> cbPeriodo;
    private javax.swing.JComboBox<String> cbSala;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JComboBox<String> cbTurma;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton okButton;
    private javax.swing.JRadioButton rbNome;
    private javax.swing.JRadioButton rbRgm;
    private javax.swing.JTable tbAluno;
    private javax.swing.JTable tbLocal;
    private javax.swing.JTable tbPeriodo;
    private javax.swing.JTable tbSala;
    private javax.swing.JTable tbSexo;
    private javax.swing.JTable tbTurma;
    private javax.swing.JTextField txAluno;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;
}
