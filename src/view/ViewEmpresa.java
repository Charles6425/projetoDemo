package view;

import controller.ControllerCadEndereco;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.ModelCadEndereco;
import static org.joda.time.format.ISODateTimeFormat.date;
import util.WebServiceCep;
import util.VerificaCpf;
import model.ModelEmpresa;
import controller.ControllerEmpresa;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import util.BLDatas;
import util.BLTiraAcentos;
import model.ModelContatoEmpresa;
import controller.ControllerContatoEmpresa;
import controller.ControllerUnidadeEmpresa;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.ModelUnidadeEmpresa;

/**
 *
 * @author charles
 */
public class ViewEmpresa extends javax.swing.JFrame {

    ModelCadEndereco modelCadEndereco = new ModelCadEndereco();
    ModelEmpresa modelEmpresa = new ModelEmpresa();

    ModelContatoEmpresa modelContatoEmpresa = new ModelContatoEmpresa();
    ControllerContatoEmpresa controllerContatoEmpresa = new ControllerContatoEmpresa();
    ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
    ControllerCadEndereco controllerCadEndereco = new ControllerCadEndereco();
    ArrayList<ModelEmpresa> listaModelEmpresas = new ArrayList<>();
    ArrayList<ModelCadEndereco> listaModelCadEndereco = new ArrayList<>();
    ArrayList<ModelContatoEmpresa> listaContatoEmpresas = new ArrayList<>();
    VerificaCpf verificaCpf = new VerificaCpf();
    String salvarAlterar;
    public int codigoEmpresa;

    public ViewEmpresa() {
        initComponents();
        setLocationRelativeTo(null);
        habilitaCampo(false);
        btAlterar.setEnabled(false);
        btCancelar.setEnabled(false);
        btSalvar.setEnabled(false);
        btNovo.setEnabled(true);
        btPesquisar.setEnabled(true);

    }

    private void removeItemTB() {
        int linhaSelecionada = tbContatos.getSelectedRow();
        // Verificamos se existe realmente alguma linha selecionada
        if (linhaSelecionada < 0) {
            return;
        } else {
            // Obtem o modelo da JTable
            DefaultTableModel modelo = (DefaultTableModel) tbContatos.getModel();
            // Remove a linha
            modelo.removeRow(linhaSelecionada);
        }
    }

    private void adicionaContatoEmpresa() {
        BLDatas bl = new BLDatas();

        DefaultTableModel modelo = (DefaultTableModel) tbContatos.getModel();
        int cont = 0;

        for (int i = 0; i < cont; i++) {
            modelo.setNumRows(0);
        }
        try {
            //pega a quantidade de linhas e joga na variavel
            modelo.addRow(new Object[]{
                txContatoTb.getText(),
                txEmailTb.getText(),
                txTelTb.getText()
            });
        } catch (Exception ex) {
            Logger.getLogger(ViewAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarEmpresas(int pCodigoEmpresa) {
        ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
        ControllerCadEndereco controllerCadEndereco = new ControllerCadEndereco();
        ModelCadEndereco modelCadEndereco = new ModelCadEndereco();
        ModelEmpresa modelEmpresa = new ModelEmpresa();
        modelEmpresa = controllerEmpresa.getEmpresaController(codigoEmpresa);
        modelCadEndereco = controllerCadEndereco.getCadEnderecoCodController(modelEmpresa.getCod_endereco());
        ModelUnidadeEmpresa modelUnidadeEmpresa = new ModelUnidadeEmpresa();
        ControllerUnidadeEmpresa controllerUnidadeEmpresa = new ControllerUnidadeEmpresa();
        //dados
        txAgencia.setText(modelEmpresa.getAgencia());
        txBairro.setText(modelCadEndereco.getEnd_bairro());
        txBanco.setText(modelEmpresa.getBanco());
        txCNPJ.setText(modelEmpresa.getCnpj());
        txCargo.setText(modelEmpresa.getContato_cargo());
        txCel1.setText(modelEmpresa.getTel3());
        txCel2.setText(modelEmpresa.getTel4());
        txCodigo.setText(String.valueOf(modelEmpresa.getId()));
        txContato.setText(modelEmpresa.getContato());
        txCnae.setText(modelEmpresa.getCnae());
        txContatoTel.setText(modelEmpresa.getContato_tel());
        txEmail.setText(modelEmpresa.getEmail());
        txIe.setText(modelEmpresa.getIe());
        txCodigoEmpresa.setText(modelEmpresa.getCodigoEmpresa());
        txNomeFantasia.setText(modelEmpresa.getNome_fantasia());
        txNumConta.setText(modelEmpresa.getNum_da_conta());

        if (modelEmpresa.getCod_endereco() == 0) {
            txCep.setText(modelEmpresa.getCep_auxiliar());
        } else {

            txCep.setText(modelCadEndereco.getEnd_cep());
            txNumero.setText(modelEmpresa.getNumero());
            txComplemento.setText(modelEmpresa.getComplemento());
            txLogradouro.setText(modelCadEndereco.getEnd_logradouro());
            txMunicipio.setText(modelCadEndereco.getEnd_cidade());
        }
        txTel1.setText(modelEmpresa.getTel1());
        txTel2.setText(modelEmpresa.getTel2());
        txUf.setText(modelCadEndereco.getEnd_uf());
        txRazao.setText(modelEmpresa.getRazao());

        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
        Date dtSituacao, dtAbertura;

        try {

            if (modelEmpresa.getDt_situacao_cadastral() == null || modelEmpresa.getDt_situacao_cadastral().equals("") || modelEmpresa.getDt_situacao_cadastral().equals("null")) {
                System.out.println(modelEmpresa.getDt_situacao_cadastral());
            } else {

                dtSituacao = formato.parse(modelEmpresa.getDt_situacao_cadastral());
                jcdDataSitCadastral.setDate(dtSituacao);
            }

            if (modelEmpresa.getDt_abertura() == null || modelEmpresa.getDt_abertura().equals("") || modelEmpresa.getDt_abertura().equals("null")) {

            } else {
                dtAbertura = formato.parse(modelEmpresa.getDt_abertura());
                jcdDtAbertura.setDate(dtAbertura);
            }

        } catch (ParseException ex) {
            Logger.getLogger(ViewEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }

        txUnidade.setText(String.valueOf(modelEmpresa.getUnidade()));
        System.out.println(modelEmpresa.getUnidade());

        listaContatoEmpresas = controllerContatoEmpresa.getListaContatoEmpresaController(modelEmpresa.getId());
        DefaultTableModel modelo = (DefaultTableModel) tbContatos.getModel();
        modelo.setNumRows(0);
        int cont = listaContatoEmpresas.size();
        for (int i = 0; i < cont; i++) {

            modelo.addRow(new Object[]{
                listaContatoEmpresas.get(i).getNome(),
                listaContatoEmpresas.get(i).getEmail(),
                listaContatoEmpresas.get(i).getTel()
            });
        }

    }

    private void salvar() {
        BLDatas bl = new BLDatas();

        modelCadEndereco = controllerCadEndereco.getCadEnderecoController(txCep.getText());
        modelEmpresa.setAgencia(txAgencia.getText());
        modelEmpresa.setBanco(txBanco.getText());
        modelEmpresa.setCnae(txCNPJ.getText());
        modelEmpresa.setCnpj(txCNPJ.getText());
        modelEmpresa.setCod_endereco(modelCadEndereco.getEnd_codigo());
        modelEmpresa.setComplemento(txComplemento.getText());
        modelEmpresa.setContato(txContato.getText());
        modelEmpresa.setContato_cargo(txCargo.getText());
        modelEmpresa.setContato_tel(txCargo.getText());
        modelEmpresa.setContato_tel(txContatoTel.getText());
        modelEmpresa.setIe(txIe.getText());
        modelEmpresa.setNome_fantasia(txNomeFantasia.getText());
        modelEmpresa.setNum_da_conta(txNumConta.getText());
        modelEmpresa.setNumero(txNumero.getText());
        modelEmpresa.setRazao(txRazao.getText());
        modelEmpresa.setTel1(txTel1.getText());
        modelEmpresa.setTel2(txTel2.getText());
        modelEmpresa.setTel3(txCel1.getText());
        modelEmpresa.setTel4(txCel2.getText());
        modelEmpresa.setCodigoEmpresa(txCodigoEmpresa.getText());
        modelEmpresa.setUnidade(Integer.parseInt(txUnidade.getText()));
        Date dtAbertura = null;
        Date dtSituacao = null;

        try {
            if (jcdDtAbertura.getDate() == null) {
            } else {
                dtAbertura = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDtAbertura.getDate()));
            }

            if (jcdDataSitCadastral.getDate() == null) {

            } else {
                dtSituacao = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataSitCadastral.getDate()));
            }

        } catch (Exception ex) {
            Logger.getLogger(ViewAluno.class.getName()).log(Level.SEVERE, null, ex);
        }

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if (jcdDtAbertura.getDate() == null) {

        } else {
            String abertura = dateFormat.format(dtAbertura);
            modelEmpresa.setDt_abertura(abertura);
        }
        if (jcdDataSitCadastral.getDate() == null) {

        } else {
            String situacao = dateFormat.format(dtSituacao);
            modelEmpresa.setDt_situacao_cadastral(situacao);
        }

        codigoEmpresa = controllerEmpresa.salvarEmpresaController(modelEmpresa);

        if (codigoEmpresa > 0) {
            modelEmpresa.setId(codigoEmpresa);

        }

        for (int i = 0; i < tbContatos.getRowCount(); i++) {
            modelContatoEmpresa.setNome((String) tbContatos.getValueAt(i, 0));
            modelContatoEmpresa.setEmail((String) tbContatos.getValueAt(i, 1));
            modelContatoEmpresa.setTel((String) tbContatos.getValueAt(i, 2));
            modelContatoEmpresa.setId_empresa(codigoEmpresa);
            controllerContatoEmpresa.salvarContatoEmpresaController(modelContatoEmpresa);
        }
        JOptionPane.showMessageDialog(this, "Registro salvo com sucesso!");
    }

    private void alterar() {
        BLDatas bl = new BLDatas();

        modelCadEndereco = controllerCadEndereco.getCadEnderecoController(txCep.getText());
        modelEmpresa.setAgencia(txAgencia.getText());
        modelEmpresa.setId(Integer.parseInt(txCodigo.getText()));
        modelEmpresa.setBanco(txBanco.getText());
        modelEmpresa.setCnae(txCNPJ.getText());
        modelEmpresa.setCnpj(txCNPJ.getText());
        modelEmpresa.setCod_endereco(modelCadEndereco.getEnd_codigo());

        modelEmpresa.setComplemento(txComplemento.getText());
        modelEmpresa.setContato(txContato.getText());
        modelEmpresa.setContato_cargo(txCargo.getText());
        modelEmpresa.setContato_tel(txCargo.getText());
        modelEmpresa.setContato_tel(txContatoTel.getText());
        modelEmpresa.setIe(txIe.getText());
        modelEmpresa.setNome_fantasia(txNomeFantasia.getText());
        modelEmpresa.setNum_da_conta(txNumConta.getText());
        modelEmpresa.setNumero(txNumero.getText());
        modelEmpresa.setRazao(txRazao.getText());
        modelEmpresa.setTel1(txTel1.getText());
        modelEmpresa.setTel2(txTel2.getText());
        modelEmpresa.setTel3(txCel1.getText());
        modelEmpresa.setTel4(txCel2.getText());
        modelEmpresa.setCodigoEmpresa(txCodigoEmpresa.getText());
        modelEmpresa.setUnidade(Integer.parseInt(txUnidade.getText()));

        Date dtAbertura = null;
        Date dtSituacao = null;
        try {
            if (jcdDtAbertura.getDate() == null) {
            } else {
                dtAbertura = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDtAbertura.getDate()));
            }

            if (jcdDataSitCadastral.getDate() == null) {

            } else {
                dtSituacao = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataSitCadastral.getDate()));
            }
        } catch (Exception ex) {
            Logger.getLogger(ViewAluno.class.getName()).log(Level.SEVERE, null, ex);
        }

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if (jcdDtAbertura.getDate() == null) {

        } else {
            String abertura = dateFormat.format(dtAbertura);
            modelEmpresa.setDt_abertura(abertura);
        }
        if (jcdDataSitCadastral.getDate() == null) {

        } else {
            String situacao = dateFormat.format(dtSituacao);
            modelEmpresa.setDt_situacao_cadastral(situacao);
        }

        controllerEmpresa.atualizarEmpresaController(modelEmpresa);

        listaContatoEmpresas = controllerContatoEmpresa.getListaContatoEmpresaController(Integer.parseInt(txCodigo.getText()));
        int cont = listaContatoEmpresas.size();
        DefaultTableModel modelo = (DefaultTableModel) tbContatos.getModel();
        int tabela = modelo.getRowCount();

        for (int i = cont; i < tabela; i++) {
            modelContatoEmpresa.setNome((String) tbContatos.getValueAt(i, 0));
            modelContatoEmpresa.setEmail((String) tbContatos.getValueAt(i, 1));
            modelContatoEmpresa.setTel((String) tbContatos.getValueAt(i, 2));
            modelContatoEmpresa.setId_empresa(codigoEmpresa);
            controllerContatoEmpresa.salvarContatoEmpresaController(modelContatoEmpresa);
        }

        JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");

    }

    /**
     * select do cep no banco de dados no cadastro de cep criado
     */
    private void carregaCepBd() {
        listaModelCadEndereco = controllerCadEndereco.getListaCadEnderecoController(txCep.getText());
        int cont = listaModelCadEndereco.size();
        for (int i = 0; i < cont; i++) {
            txLogradouro.setText(listaModelCadEndereco.get(i).getEnd_logradouro());
            txBairro.setText(listaModelCadEndereco.get(i).getEnd_bairro());
            txMunicipio.setText(listaModelCadEndereco.get(i).getEnd_cidade());
            txUf.setText(listaModelCadEndereco.get(i).getEnd_uf());

        }
    }

    private boolean salvarCepWeb() {
        modelCadEndereco.setEnd_cep(txCep.getText());
        modelCadEndereco.setEnd_logradouro(txLogradouro.getText());
        modelCadEndereco.setEnd_bairro(txBairro.getText());
        modelCadEndereco.setEnd_cidade(txMunicipio.getText());
        modelCadEndereco.setEnd_uf(txUf.getText());

        if (controllerCadEndereco.salvarCadEnderecoController(modelCadEndereco) > 0) {

            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao gravar p CEP, verifique os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private boolean AlterarCepWeb() {
        modelCadEndereco.setEnd_cep(txCep.getText());
        modelCadEndereco.setEnd_logradouro(txLogradouro.getText());
        modelCadEndereco.setEnd_bairro(txBairro.getText());
        modelCadEndereco.setEnd_cidade(txMunicipio.getText());
        modelCadEndereco.setEnd_uf(txUf.getText());

        if (controllerCadEndereco.atualizarCadEnderecoController(modelCadEndereco)) {

            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao gravar p CEP, verifique os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    /**
     * Busca o cep no webservice
     */
    private void carregaCepWeb() {
        WebServiceCep webServiceCep = WebServiceCep.searchCep(txCep.getText());
        //A ferramenta de busca ignora qualquer caracter que nï¿½o seja nï¿½mero.

        //caso a busca ocorra bem, imprime os resultados.
        if (webServiceCep.wasSuccessful()) {
            // System.out.println("Cep: " + webServiceCep.getCep());

            txLogradouro.setText(webServiceCep.getLogradouroFull());
            txBairro.setText(webServiceCep.getBairro());
            txMunicipio.setText(webServiceCep.getCidade());
            txUf.setText(webServiceCep.getUf());

            //caso haja problemas imprime as excessões.
        } else {
            JOptionPane.showMessageDialog(this, "Erro numero: " + webServiceCep.getResulCode() + "\nDescricao do erro: " + webServiceCep.getResultText(), "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void limpaCampos() {
        txAgencia.setText("");
        txBanco.setText("");
        txCel1.setText("");
        txCel2.setText("");
        txCodigo.setText("");
        txEmail.setText("");
        txRazao.setText("");
        txNomeFantasia.setText("");
        txContato.setText("");
        txNumConta.setText("");
        txCNPJ.setText("");
        txContatoTel.setText("");
        txTel1.setText("");
        txTel2.setText("");
        txCep.setText("");
        txComplemento.setText("");
        txLogradouro.setText("");
        txBairro.setText("");
        txMunicipio.setText("");
        txNumero.setText("");
        txUf.setText("");
        txCargo.setText("");
        txCnae.setText("");
        txContatoTb.setText("");
        txEmailTb.setText("");
        txTelTb.setText("");
        txCodigoEmpresa.setText("");
        txUnidade.setText("");
        Date date = null;
        jcdDataSitCadastral.setDate(date);
        jcdDtAbertura.setDate(date);

        DefaultTableModel modelo = (DefaultTableModel) tbContatos.getModel();
        modelo.setNumRows(0);

    }

    private void habilitaCampo(boolean condicao) {
        txAgencia.setEditable(condicao);
        txBanco.setEditable(condicao);
        txCodigo.setEditable(condicao);
        txEmail.setEditable(condicao);
        txRazao.setEditable(condicao);
        txNomeFantasia.setEditable(condicao);
        txContato.setEditable(condicao);
        txNumConta.setEditable(condicao);
        txCNPJ.setEditable(condicao);
        txIe.setEditable(condicao);
        txContatoTel.setEditable(condicao);
        txTel1.setEditable(condicao);
        txTel2.setEditable(condicao);
        txCel1.setEditable(condicao);
        txCel2.setEditable(condicao);
        jcdDataSitCadastral.setEnabled(condicao);
        jcdDtAbertura.setEnabled(condicao);
        cbSituacao.setEditable(condicao);
        txCep.setEditable(condicao);
        txComplemento.setEditable(condicao);
        txLogradouro.setEditable(condicao);
        txBairro.setEditable(condicao);
        txMunicipio.setEditable(condicao);
        txNumero.setEditable(condicao);
        txUf.setEditable(condicao);
        txCargo.setEditable(condicao);
        txCnae.setEditable(condicao);
        btPesquisaCep.setEnabled(condicao);
        txContatoTb.setEditable(condicao);
        txEmailTb.setEditable(condicao);
        txTelTb.setEditable(condicao);
        tbContatos.setEnabled(condicao);
        txCodigoEmpresa.setEditable(condicao);
        txUnidade.setEditable(condicao);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txRazao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txNomeFantasia = new javax.swing.JTextField();
        txIe = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txContato = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txContatoTel = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jcdDtAbertura = new com.toedter.calendar.JDateChooser();
        jcdDataSitCadastral = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        txNumConta = new javax.swing.JTextField();
        txAgencia = new javax.swing.JTextField();
        txBanco = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txCNPJ = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txCnae = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txCargo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txEmail = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txTel1 = new javax.swing.JTextField();
        txTel2 = new javax.swing.JTextField();
        txCel1 = new javax.swing.JTextField();
        txCel2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btPesquisaCep = new javax.swing.JButton();
        txLogradouro = new javax.swing.JTextField();
        txNumero = new javax.swing.JTextField();
        txComplemento = new javax.swing.JTextField();
        txBairro = new javax.swing.JTextField();
        txMunicipio = new javax.swing.JTextField();
        txUf = new javax.swing.JTextField();
        txCep = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbContatos = new javax.swing.JTable();
        txContatoTb = new javax.swing.JTextField();
        txEmailTb = new javax.swing.JTextField();
        txTelTb = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btAdContato = new javax.swing.JButton();
        btRemoveContato = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        cbSituacao = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();
        txCodigoEmpresa = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txUnidade = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Empresas");
        setResizable(false);

        txCodigo.setEditable(false);
        txCodigo.setFocusable(false);

        jLabel2.setText("Código");
        jLabel2.setToolTipText("");

        txRazao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txRazaoFocusLost(evt);
            }
        });
        txRazao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txRazaoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txRazaoKeyReleased(evt);
            }
        });

        jLabel3.setText("Razão Social");

        txNomeFantasia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txNomeFantasiaKeyReleased(evt);
            }
        });

        txIe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txIeActionPerformed(evt);
            }
        });

        jLabel5.setText("Nome Fantasia");

        jLabel6.setText("I.E.");

        txContato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txContatoKeyReleased(evt);
            }
        });

        jLabel7.setText("Contato / Responsável");

        jLabel8.setText("Celular / Ramal");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Documentação");

        jLabel16.setText("Data de abertura");

        jLabel17.setText("Data de situação cadastral");

        txBanco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txBancoKeyReleased(evt);
            }
        });

        jLabel22.setText("Nº da Conta");

        jLabel23.setText("Agência");

        jLabel24.setText("Banco");

        txCNPJ.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txCNPJFocusLost(evt);
            }
        });
        txCNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCNPJActionPerformed(evt);
            }
        });

        jLabel9.setText("CNPJ");

        jLabel4.setText("CNAE principal");

        txCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txCargoKeyReleased(evt);
            }
        });

        jLabel14.setText("Cargo");

        jLabel26.setText("E-mail");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txNomeFantasia)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txRazao)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(txContato))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(txContatoTel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txIe, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txCNPJ, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(txEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcdDtAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jcdDataSitCadastral, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txCnae, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txNumConta, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(0, 277, Short.MAX_VALUE))
                            .addComponent(txBanco))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txRazao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txIe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel14)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txContatoTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(jcdDataSitCadastral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jcdDtAbertura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txCnae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel22)
                                        .addComponent(jLabel23)
                                        .addComponent(jLabel24))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txNumConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))))
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados", jPanel1);

        jLabel13.setText("Celular 2");

        jLabel12.setText("Celular 1");

        jLabel11.setText("Telefone 2");

        jLabel10.setText("Telefone 1");

        btPesquisaCep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Zoom.png"))); // NOI18N
        btPesquisaCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaCepActionPerformed(evt);
            }
        });

        jLabel28.setText("Logradouro");

        jLabel29.setText("Número");

        jLabel30.setText("Complemento");

        jLabel31.setText("Bairro");

        jLabel32.setText("Município");

        jLabel33.setText("UF");

        jLabel34.setText("CEP");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Contato");

        tbContatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Email", "Tel/Cel"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbContatos);
        if (tbContatos.getColumnModel().getColumnCount() > 0) {
            tbContatos.getColumnModel().getColumn(0).setResizable(false);
            tbContatos.getColumnModel().getColumn(1).setResizable(false);
            tbContatos.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel18.setText("Contato");

        jLabel19.setText("E-mail");

        jLabel20.setText("Tel/Cel");

        btAdContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Seta à direita Fim.png"))); // NOI18N
        btAdContato.setText("Adicionar");
        btAdContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdContatoActionPerformed(evt);
            }
        });

        btRemoveContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        btRemoveContato.setText("Remover");
        btRemoveContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoveContatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel29)
                                                .addGap(42, 42, 42))
                                            .addComponent(txNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel30)
                                                .addGap(111, 111, 111))
                                            .addComponent(txComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txUf, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel33))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txCep, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel34))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btPesquisaCep))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel31))
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel32)
                                            .addComponent(txMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txTel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(txCel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txTel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(txCel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txContatoTb, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txEmailTb, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel20)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txTelTb)))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btAdContato)
                        .addGap(34, 34, 34)
                        .addComponent(btRemoveContato)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btPesquisaCep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(7, 7, 7)
                        .addComponent(txComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel35)
                .addGap(4, 4, 4)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txContatoTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txEmailTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txTelTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txTel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txCel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txTel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txCel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAdContato)
                    .addComponent(btRemoveContato))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Endereço/Contato", jPanel2);

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Adicionar.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Salvar.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Editar.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        jLabel1.setText("Situacao Cadastral");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo transparente.png"))); // NOI18N

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Lupa.png"))); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        jLabel21.setText("Codigo Empresa");

        jLabel27.setText("Unidade");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txCodigoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel21)
                    .addComponent(jLabel27))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar)
                    .addComponent(txCodigoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btNovo)
                        .addComponent(btSalvar)
                        .addComponent(btAlterar)
                        .addComponent(btCancelar))
                    .addComponent(jLabel25))
                .addGap(23, 79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        salvarAlterar = "novo";
        habilitaCampo(true);
        btPesquisar.setEnabled(false);
        btNovo.setEnabled(false);
        btAlterar.setEnabled(false);
        btSalvar.setEnabled(true);
        btCancelar.setEnabled(true);
        limpaCampos();
        txRazao.requestFocusInWindow();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        //System.out.println(salvarAlterar);

        if (txRazao.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Necessário informar a razão social", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
        } else if (txContato.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Necessário informar o nome de um contato", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
        } else if (salvarAlterar.equals("novo")) {
            salvar();
            habilitaCampo(false);
            limpaCampos();
            btAlterar.setEnabled(true);
            btCancelar.setEnabled(false);
            btSalvar.setEnabled(false);
            btNovo.setEnabled(true);
            btPesquisar.setEnabled(true);
        } else {
            alterar();
            habilitaCampo(false);
            limpaCampos();
            btAlterar.setEnabled(true);
            btCancelar.setEnabled(false);
            btSalvar.setEnabled(false);
            btNovo.setEnabled(true);
            btPesquisar.setEnabled(true);

        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        habilitaCampo(false);
        btAlterar.setEnabled(true);
        btCancelar.setEnabled(false);
        btSalvar.setEnabled(false);
        btNovo.setEnabled(true);
        btPesquisar.setEnabled(true);
        limpaCampos();
        salvarAlterar = "";
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btPesquisaCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaCepActionPerformed

        modelCadEndereco = controllerCadEndereco.getCadEnderecoController(txCep.getText());
        if (txCep.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Digite um CEP!", "Erro", JOptionPane.ERROR_MESSAGE);

        } else if (modelCadEndereco.getEnd_cep() == null) {

            this.carregaCepWeb();
            salvarCepWeb();
        } else {
            this.carregaCepBd();
        }

    }//GEN-LAST:event_btPesquisaCepActionPerformed
    private void btAlteraCepActionPerformed(java.awt.event.ActionEvent evt) {

        /**
         * Métofo que altera o cadastro por importação de cep
         *
         */
        WebServiceCep webServiceCep = WebServiceCep.searchCep(txCep.getText());
        this.carregaCepWeb();
        if (webServiceCep.wasSuccessful()) {
            AlterarCepWeb();
        } else {
            JOptionPane.showMessageDialog(this, "Erro numero: " + webServiceCep.getResulCode() + "\nDescricao do erro: " + webServiceCep.getResultText(), "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void txIeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txIeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txIeActionPerformed

    private void txCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCNPJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txCNPJActionPerformed

    private void txCNPJFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txCNPJFocusLost
        try {
            if (verificaCpf.isCnpjValido(txCNPJ.getText()) == true) {

            } else {
                JOptionPane.showMessageDialog(this, "CNPJ Inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                txCNPJ.requestFocusInWindow();
                txCNPJ.setText("");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "CNPJ Inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            txCNPJ.requestFocusInWindow();
            txCNPJ.setText("");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txCNPJFocusLost

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        salvarAlterar = "alterar";
        habilitaCampo(true);
        btPesquisar.setEnabled(false);
        btNovo.setEnabled(false);
        btAlterar.setEnabled(false);
        btSalvar.setEnabled(true);
        btCancelar.setEnabled(true);
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        ViewPesquisaEmpresa viewPesquisaEmpresa = new ViewPesquisaEmpresa(this, rootPaneCheckingEnabled);
        viewPesquisaEmpresa.setVisible(true);
        codigoEmpresa = viewPesquisaEmpresa.getReturnStatus();

        carregarEmpresas(codigoEmpresa);
        btAlterar.setEnabled(true);
        btCancelar.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void txRazaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRazaoKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txRazao.setText(txRazao.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txRazao.setText(blTiraAcentos.TiraAcentos(txRazao.getText()));
    }//GEN-LAST:event_txRazaoKeyReleased

    private void txNomeFantasiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNomeFantasiaKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txNomeFantasia.setText(txNomeFantasia.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txNomeFantasia.setText(blTiraAcentos.TiraAcentos(txNomeFantasia.getText()));
    }//GEN-LAST:event_txNomeFantasiaKeyReleased

    private void txCargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCargoKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txCargo.setText(txCargo.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txCargo.setText(blTiraAcentos.TiraAcentos(txCargo.getText()));
    }//GEN-LAST:event_txCargoKeyReleased

    private void txBancoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txBancoKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txBanco.setText(txBanco.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txBanco.setText(blTiraAcentos.TiraAcentos(txBanco.getText()));
    }//GEN-LAST:event_txBancoKeyReleased

    private void txContatoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txContatoKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txContato.setText(txContato.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txContato.setText(blTiraAcentos.TiraAcentos(txContato.getText()));
    }//GEN-LAST:event_txContatoKeyReleased

    private void btAdContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdContatoActionPerformed
        adicionaContatoEmpresa();
        txContatoTb.setText("");
        txEmailTb.setText("");
        txTelTb.setText("");
    }//GEN-LAST:event_btAdContatoActionPerformed

    private void btRemoveContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoveContatoActionPerformed
        removeItemTB();
    }//GEN-LAST:event_btRemoveContatoActionPerformed

    private void txRazaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRazaoKeyPressed
        // converte em maiusculo o que o usuario digitar
        this.txRazao.setText(txRazao.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txRazao.setText(blTiraAcentos.TiraAcentos(txRazao.getText()));
    }//GEN-LAST:event_txRazaoKeyPressed

    private void txRazaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txRazaoFocusLost
        this.txRazao.setText(txRazao.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txRazao.setText(blTiraAcentos.TiraAcentos(txRazao.getText()));
    }//GEN-LAST:event_txRazaoFocusLost

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
            java.util.logging.Logger.getLogger(ViewEmpresa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewEmpresa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewEmpresa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewEmpresa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewEmpresa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdContato;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisaCep;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btRemoveContato;
    private javax.swing.JButton btSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser jcdDataSitCadastral;
    private com.toedter.calendar.JDateChooser jcdDtAbertura;
    private javax.swing.JTable tbContatos;
    private javax.swing.JTextField txAgencia;
    private javax.swing.JTextField txBairro;
    private javax.swing.JTextField txBanco;
    private javax.swing.JTextField txCNPJ;
    private javax.swing.JTextField txCargo;
    private javax.swing.JTextField txCel1;
    private javax.swing.JTextField txCel2;
    private javax.swing.JTextField txCep;
    private javax.swing.JTextField txCnae;
    private javax.swing.JTextField txCodigo;
    private javax.swing.JTextField txCodigoEmpresa;
    private javax.swing.JTextField txComplemento;
    private javax.swing.JTextField txContato;
    private javax.swing.JTextField txContatoTb;
    private javax.swing.JTextField txContatoTel;
    private javax.swing.JTextField txEmail;
    private javax.swing.JTextField txEmailTb;
    private javax.swing.JTextField txIe;
    private javax.swing.JTextField txLogradouro;
    private javax.swing.JTextField txMunicipio;
    private javax.swing.JTextField txNomeFantasia;
    private javax.swing.JTextField txNumConta;
    private javax.swing.JTextField txNumero;
    private javax.swing.JTextField txRazao;
    private javax.swing.JTextField txTel1;
    private javax.swing.JTextField txTel2;
    private javax.swing.JTextField txTelTb;
    private javax.swing.JTextField txUf;
    private javax.swing.JTextField txUnidade;
    // End of variables declaration//GEN-END:variables
}
