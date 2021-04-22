/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerAluno;
import controller.ControllerCadEndereco;
import controller.ControllerEmpresa;
import controller.ControllerProdutos;
import controller.ControllerTurma;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.print.attribute.Size2DSyntax.MM;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelAluno;
import model.ModelCadEndereco;
import model.ModelEmpresa;
import model.ModelProdutos;
import model.ModelTurma;
import relatorios.DAORelatorios;
import util.BLDatas;
import util.BLMascaras;

/**
 *
 * @author charles
 */
public class ViewEncaminhamento extends javax.swing.JFrame {

    ModelEmpresa modelEmpresa = new ModelEmpresa();
    ModelTurma modelTurma = new ModelTurma();
    ModelCadEndereco modelCadEndereco = new ModelCadEndereco();
    ModelAluno modelAluno = new ModelAluno();
    ControllerAluno controllerAluno = new ControllerAluno();
    ControllerCadEndereco controllerCadEndereco = new ControllerCadEndereco();
    ControllerTurma controllerTurma = new ControllerTurma();
    ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
    ArrayList<ModelEmpresa> listaModelEmpresas = new ArrayList<>();
    ArrayList<ModelTurma> listaModelTurmas = new ArrayList<>();
    ArrayList<ModelCadEndereco> listaModelCadEndereco = new ArrayList<>();
    ArrayList<ModelAluno> listaModelAlunos = new ArrayList<>();
    ArrayList<ModelAluno> listaModelAlunos2 = new ArrayList<>();
    private static int gera;

    /**
     * Creates new form ViewEncaminhamento
     */
    public ViewEncaminhamento() {
        initComponents();
        setLocationRelativeTo(null);
        preencherCbEmpresa();
        preencherTurma();
        preencherBairro();
        tbEncaminhamento();
        cbStatus.setSelectedIndex(1);

    }

    private void preencherCbEmpresa() {
        listaModelEmpresas = controllerEmpresa.getListaEmpresaController();

        cbEmpresa.removeAllItems();
        for (int i = 0; i < listaModelEmpresas.size(); i++) {
            cbEmpresa.addItem(listaModelEmpresas.get(i).getCodigoEmpresa() + " - " + listaModelEmpresas.get(i).getRazao());

        }

    }

    private void preencherTurma() {
        listaModelTurmas = controllerTurma.getListaTurmaController();

        cbTurma.removeAllItems();
        for (int i = 0; i < listaModelTurmas.size(); i++) {
            cbTurma.addItem(listaModelTurmas.get(i).getDescricao());

        }

    }

    /**
     * select do cep no banco de dados no cadastro de cep criado
     */
    private void preencherBairro() {
        listaModelCadEndereco = controllerCadEndereco.getListaCadEnderecoController();
        cbBairro.removeAllItems();
        for (int i = 0; i < listaModelCadEndereco.size(); i++) {
            cbBairro.addItem(listaModelCadEndereco.get(i).getEnd_bairro());

        }
    }

    private void tbEncaminhamento() {
        listaModelAlunos = controllerAluno.getListaGeralController();

        for (int i = 0; i < listaModelAlunos.size(); i++) {

        }
    }

    /**
     * pesquisa com todosos filtros setado
     */
    private void encamComTodosFiltros() {
        BLDatas bl = new BLDatas();
        Date dtNascimento = null;
        Date dtNascimentoFim = null;
        try {
            dtNascimento = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataNascimentoIni.getDate()));
            dtNascimentoFim = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataNascimentoFinal.getDate()));

            Date dataAtual = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String nascimento = dateFormat.format(dtNascimento);
            String nascimentoFim = dateFormat.format(dtNascimentoFim);
            listaModelAlunos = controllerAluno.getListaEncSemController(cbStatus.getSelectedIndex(), cbTurma.getSelectedIndex() + 1,
                    nascimento, nascimentoFim, (String) cbSexo.getSelectedItem(), (String) cbBairro.getSelectedItem());
        } catch (Exception ex) {
            Logger.getLogger(ViewEncaminhamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel modelo = (DefaultTableModel) tbAspirante.getModel();
        modelo.setNumRows(0);
        for (int i = 0; i < listaModelAlunos.size(); i++) {
            //pega a quantidade de linhas e joga na variavel
            modelo.addRow(new Object[]{
                listaModelAlunos.get(i).getId(),
                listaModelAlunos.get(i).getNome_aluno(),
                listaModelAlunos.get(i).getBairro(),
                listaModelAlunos.get(i).getPort3(),
                listaModelAlunos.get(i).getMat3(),
                listaModelAlunos.get(i).getInf3(),
                listaModelAlunos.get(i).getRed3(),
                listaModelAlunos.get(i).getAtiv_fis3(),
                listaModelAlunos.get(i).getNad3(),
                listaModelAlunos.get(i).getSqv3(),
                listaModelAlunos.get(i).getNat3(),
                listaModelAlunos.get(i).getEd_moral3(),
                listaModelAlunos.get(i).getAtitudes3(),});
        }

    }

    /**
     * pesquisa com todosos filtros setado
     */
    private void encamComTodosBairos() {
        BLDatas bl = new BLDatas();
        Date dtNascimento = null;
        Date dtNascimentoFim = null;
        try {
            dtNascimento = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataNascimentoIni.getDate()));
            dtNascimentoFim = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataNascimentoFinal.getDate()));

            Date dataAtual = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String nascimento = dateFormat.format(dtNascimento);
            String nascimentoFim = dateFormat.format(dtNascimentoFim);
            listaModelAlunos = controllerAluno.getListaTodosBairrosController(cbStatus.getSelectedIndex(), cbTurma.getSelectedIndex() + 1,
                    nascimento, nascimentoFim, (String) cbSexo.getSelectedItem());
        } catch (Exception ex) {
            Logger.getLogger(ViewEncaminhamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel modelo = (DefaultTableModel) tbAspirante.getModel();
        modelo.setNumRows(0);
        for (int i = 0; i < listaModelAlunos.size(); i++) {
            //pega a quantidade de linhas e joga na variavel
            modelo.addRow(new Object[]{
                listaModelAlunos.get(i).getId(),
                listaModelAlunos.get(i).getNome_aluno(),
                listaModelAlunos.get(i).getBairro(),
                listaModelAlunos.get(i).getPort3(),
                listaModelAlunos.get(i).getMat3(),
                listaModelAlunos.get(i).getInf3(),
                listaModelAlunos.get(i).getRed3(),
                listaModelAlunos.get(i).getAtiv_fis3(),
                listaModelAlunos.get(i).getNad3(),
                listaModelAlunos.get(i).getSqv3(),
                listaModelAlunos.get(i).getNat3(),
                listaModelAlunos.get(i).getEd_moral3(),
                listaModelAlunos.get(i).getAtitudes3(),});
        }

    }
    /**
     * pesquisa com todosos filtros setado
     */
    private void encamComTodasTurmas() {
        BLDatas bl = new BLDatas();
        Date dtNascimento = null;
        Date dtNascimentoFim = null;
        try {
            dtNascimento = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataNascimentoIni.getDate()));
            dtNascimentoFim = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataNascimentoFinal.getDate()));

            Date dataAtual = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String nascimento = dateFormat.format(dtNascimento);
            String nascimentoFim = dateFormat.format(dtNascimentoFim);
            listaModelAlunos = controllerAluno.getListaEncSemTurmaController(cbStatus.getSelectedIndex(), nascimento, nascimentoFim, nascimento, nascimento);
     } catch (Exception ex) {
            Logger.getLogger(ViewEncaminhamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel modelo = (DefaultTableModel) tbAspirante.getModel();
        modelo.setNumRows(0);
        for (int i = 0; i < listaModelAlunos.size(); i++) {
            //pega a quantidade de linhas e joga na variavel
            modelo.addRow(new Object[]{
                listaModelAlunos.get(i).getId(),
                listaModelAlunos.get(i).getNome_aluno(),
                listaModelAlunos.get(i).getBairro(),
                listaModelAlunos.get(i).getPort3(),
                listaModelAlunos.get(i).getMat3(),
                listaModelAlunos.get(i).getInf3(),
                listaModelAlunos.get(i).getRed3(),
                listaModelAlunos.get(i).getAtiv_fis3(),
                listaModelAlunos.get(i).getNad3(),
                listaModelAlunos.get(i).getSqv3(),
                listaModelAlunos.get(i).getNat3(),
                listaModelAlunos.get(i).getEd_moral3(),
                listaModelAlunos.get(i).getAtitudes3(),});
        }

    }

    /**
     * pesquisa com todosos filtros setado
     */
    private void encamAmbosSexos() {
        BLDatas bl = new BLDatas();
        Date dtNascimento = null;
        Date dtNascimentoFim = null;
        try {
            dtNascimento = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataNascimentoIni.getDate()));
            dtNascimentoFim = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataNascimentoFinal.getDate()));

            Date dataAtual = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String nascimento = dateFormat.format(dtNascimento);
            String nascimentoFim = dateFormat.format(dtNascimentoFim);
            listaModelAlunos = controllerAluno.getListaEncSemSexoController(cbStatus.getSelectedIndex(), cbTurma.getSelectedIndex() + 1,
                    nascimento, nascimentoFim, (String) cbBairro.getSelectedItem());
        } catch (Exception ex) {
            Logger.getLogger(ViewEncaminhamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel modelo = (DefaultTableModel) tbAspirante.getModel();
        modelo.setNumRows(0);
        for (int i = 0; i < listaModelAlunos.size(); i++) {
            //pega a quantidade de linhas e joga na variavel
            modelo.addRow(new Object[]{
                listaModelAlunos.get(i).getId(),
                listaModelAlunos.get(i).getNome_aluno(),
                listaModelAlunos.get(i).getBairro(),
                listaModelAlunos.get(i).getPort3(),
                listaModelAlunos.get(i).getMat3(),
                listaModelAlunos.get(i).getInf3(),
                listaModelAlunos.get(i).getRed3(),
                listaModelAlunos.get(i).getAtiv_fis3(),
                listaModelAlunos.get(i).getNad3(),
                listaModelAlunos.get(i).getSqv3(),
                listaModelAlunos.get(i).getNat3(),
                listaModelAlunos.get(i).getEd_moral3(),
                listaModelAlunos.get(i).getAtitudes3(),});
        }

    }

    /**
     * pesquisa com todosos filtros setado
     */
    private void encamTodosSexosBairros() {
        BLDatas bl = new BLDatas();
        Date dtNascimento = null;
        Date dtNascimentoFim = null;
        try {
            dtNascimento = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataNascimentoIni.getDate()));
            dtNascimentoFim = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataNascimentoFinal.getDate()));

            Date dataAtual = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String nascimento = dateFormat.format(dtNascimento);
            String nascimentoFim = dateFormat.format(dtNascimentoFim);
            listaModelAlunos = controllerAluno.getListaTodosSexosBairrosController(cbStatus.getSelectedIndex(), cbTurma.getSelectedIndex() + 1,
                    nascimento, nascimentoFim);
        } catch (Exception ex) {
            Logger.getLogger(ViewEncaminhamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel modelo = (DefaultTableModel) tbAspirante.getModel();
        modelo.setNumRows(0);
        for (int i = 0; i < listaModelAlunos.size(); i++) {
            //pega a quantidade de linhas e joga na variavel
            modelo.addRow(new Object[]{
                listaModelAlunos.get(i).getId(),
                listaModelAlunos.get(i).getNome_aluno(),
                listaModelAlunos.get(i).getBairro(),
                listaModelAlunos.get(i).getPort3(),
                listaModelAlunos.get(i).getMat3(),
                listaModelAlunos.get(i).getInf3(),
                listaModelAlunos.get(i).getRed3(),
                listaModelAlunos.get(i).getAtiv_fis3(),
                listaModelAlunos.get(i).getNad3(),
                listaModelAlunos.get(i).getSqv3(),
                listaModelAlunos.get(i).getNat3(),
                listaModelAlunos.get(i).getEd_moral3(),
                listaModelAlunos.get(i).getAtitudes3(),});
        }

    }

    private void encamTodosSexosBairrosTurmas() {
        BLDatas bl = new BLDatas();
        Date dtNascimento = null;
        Date dtNascimentoFim = null;
        try {
            dtNascimento = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataNascimentoIni.getDate()));
            dtNascimentoFim = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataNascimentoFinal.getDate()));

            Date dataAtual = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String nascimento = dateFormat.format(dtNascimento);
            String nascimentoFim = dateFormat.format(dtNascimentoFim);
            listaModelAlunos = controllerAluno.getListaTodosSexosBairrosTurmaController(cbStatus.getSelectedIndex(), nascimento, nascimentoFim);
        } catch (Exception ex) {
            Logger.getLogger(ViewEncaminhamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel modelo = (DefaultTableModel) tbAspirante.getModel();
        modelo.setNumRows(0);
        for (int i = 0; i < listaModelAlunos.size(); i++) {
            //pega a quantidade de linhas e joga na variavel
            modelo.addRow(new Object[]{
                listaModelAlunos.get(i).getId(),
                listaModelAlunos.get(i).getNome_aluno(),
                listaModelAlunos.get(i).getBairro(),
                listaModelAlunos.get(i).getPort3(),
                listaModelAlunos.get(i).getMat3(),
                listaModelAlunos.get(i).getInf3(),
                listaModelAlunos.get(i).getRed3(),
                listaModelAlunos.get(i).getAtiv_fis3(),
                listaModelAlunos.get(i).getNad3(),
                listaModelAlunos.get(i).getSqv3(),
                listaModelAlunos.get(i).getNat3(),
                listaModelAlunos.get(i).getEd_moral3(),
                listaModelAlunos.get(i).getAtitudes3(),});
        }

    }

    public void imprimeEncaminhamento() {
        DAORelatorios relatorios = new DAORelatorios();
        //relatorios.setGera(tbAspirante.getRowCount());
        for (int i = 0; i < tbAspirante.getRowCount(); i++) {
            relatorios.setGera((int) tbAspirante.getValueAt(i, 0));
            controllerAluno.gerarRelatorioEncaminhamento((int) tbAspirante.getValueAt(i, 0));

        }

    }

    private void removeItem() {
        int linhaSelecionada = tbAspirante.getSelectedRow();
        // Verificamos se existe realmente alguma linha selecionada
        if (linhaSelecionada < 0) {
            return;
        } else {
            // Obtem o modelo da JTable
            DefaultTableModel modelo = (DefaultTableModel) tbAspirante.getModel();
            // Remove a linha
            modelo.removeRow(linhaSelecionada);
        }
    }

    /*
    private String dataAtual() {
        int nasc = 1987;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date();
        
        return dateFormat.format(date);
        
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAspirante = new javax.swing.JTable();
        cbEmpresa = new javax.swing.JComboBox<>();
        cbStatus = new javax.swing.JComboBox<>();
        cbTurma = new javax.swing.JComboBox<>();
        cbSexo = new javax.swing.JComboBox<>();
        cbBairro = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btEncaminhar = new javax.swing.JButton();
        jcbSexo = new javax.swing.JCheckBox();
        jcbBairro = new javax.swing.JCheckBox();
        btLimpar = new javax.swing.JButton();
        txHorario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jcdDataEntrevista = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jcdDataNascimentoIni = new com.toedter.calendar.JDateChooser();
        jcdDataNascimentoFinal = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jcbTodasTurmas = new javax.swing.JCheckBox();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Encaminhameto");

        tbAspirante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Bairro", "L.P.", "MAT.", "INF.", "RED", "ATIV.F.", "NAD", "SQV", "NAT", "EMC", "Atitudes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbAspirante);

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inativo", "Ativo" }));

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FEMININO", "MASCULINO" }));

        jLabel1.setText("Empresa");

        jLabel2.setText("Situação");

        jLabel3.setText("Turma");

        jLabel4.setText("Sexo");

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar_foto.png"))); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        jLabel6.setText("Bairro");

        btEncaminhar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Direita um.png"))); // NOI18N
        btEncaminhar.setText("Encaminhar");
        btEncaminhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEncaminharActionPerformed(evt);
            }
        });

        jcbSexo.setText("Ambos os sexos");

        jcbBairro.setText("Todos os bairros");

        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/minus.png"))); // NOI18N
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        jLabel7.setText("Horario");

        jLabel8.setText("Data");

        jLabel9.setText("Data de Nasc. Inicial");

        jLabel10.setText("Data Nasc. Final");

        jcbTodasTurmas.setText("Todas as turmas");
        jcbTodasTurmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTodasTurmasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jcdDataEntrevista, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcdDataNascimentoIni, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcdDataNascimentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btLimpar)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbEmpresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jcbTodasTurmas))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jcbSexo))
                                        .addGap(71, 115, Short.MAX_VALUE))
                                    .addComponent(cbSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(94, 94, 94)
                                .addComponent(jLabel8)
                                .addGap(174, 174, 174)
                                .addComponent(jLabel9)
                                .addGap(99, 99, 99)
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btEncaminhar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbBairro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbBairro)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btEncaminhar))
                    .addComponent(cbEmpresa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBairro))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbSexo)
                            .addComponent(jcbBairro))
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jcbTodasTurmas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcdDataEntrevista, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcdDataNascimentoIni, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcdDataNascimentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        if (jcbBairro.isSelected() && jcbSexo.isSelected()) {
            encamTodosSexosBairros();
        } else if (jcbBairro.isSelected() && jcbSexo.isSelected() && jcbTodasTurmas.isSelected()) {
            encamTodosSexosBairrosTurmas();
        } else if (jcbBairro.isSelected()) {
            encamComTodosBairos();
        } else if (jcbTodasTurmas.isSelected()) {
            encamComTodasTurmas();
        } else if (jcbSexo.isSelected()) {
            encamAmbosSexos();
        } else if (!jcbBairro.isSelected() && !jcbSexo.isSelected()&&!jcbTodasTurmas.isSelected()) {
            encamComTodosFiltros();
        }


    }//GEN-LAST:event_btPesquisarActionPerformed

    private void limpaCampos() {
        cbBairro.setSelectedIndex(0);
        cbEmpresa.setSelectedIndex(0);
        cbSexo.setSelectedIndex(0);
        cbStatus.setSelectedIndex(0);
        cbTurma.setSelectedIndex(0);
        txHorario.setText("");

        DefaultTableModel modelo = (DefaultTableModel) tbAspirante.getModel();
        modelo.setNumRows(0);
    }

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        removeItem();

    }//GEN-LAST:event_btLimparActionPerformed

    private void btEncaminharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEncaminharActionPerformed
        imprimeEncaminhamento();
    }//GEN-LAST:event_btEncaminharActionPerformed

    private void jcbTodasTurmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTodasTurmasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTodasTurmasActionPerformed

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
            java.util.logging.Logger.getLogger(ViewEncaminhamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewEncaminhamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewEncaminhamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewEncaminhamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewEncaminhamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEncaminhar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JComboBox<String> cbBairro;
    private javax.swing.JComboBox<String> cbEmpresa;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JComboBox<String> cbTurma;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jcbBairro;
    private javax.swing.JCheckBox jcbSexo;
    private javax.swing.JCheckBox jcbTodasTurmas;
    private com.toedter.calendar.JDateChooser jcdDataEntrevista;
    private com.toedter.calendar.JDateChooser jcdDataNascimentoFinal;
    private com.toedter.calendar.JDateChooser jcdDataNascimentoIni;
    public javax.swing.JTable tbAspirante;
    private javax.swing.JTextField txHorario;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTable getTbAspirante() {
        return tbAspirante;
    }

    public void setTbAspirante(javax.swing.JTable tbAspirante) {
        this.tbAspirante = tbAspirante;
    }
}
