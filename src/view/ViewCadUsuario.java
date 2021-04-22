package view;

import controller.ControllerCadEndereco;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.ModelCadEndereco;
import static org.joda.time.format.ISODateTimeFormat.date;
import util.WebServiceCep;
import util.VerificaCpf;
import controller.ControllerUsuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.ModelUsuario;
import util.BLDatas;
import model.ModelUsuarioFerias;
import controller.ControllerUsuarioFerias;
import util.BLTiraAcentos;

/**
 *
 * @author charles
 */
public class ViewCadUsuario extends javax.swing.JFrame {

    ModelCadEndereco modelCadEndereco = new ModelCadEndereco();
    ModelUsuario modelUsuario = new ModelUsuario();
    ModelUsuarioFerias modelUsuarioFerias = new ModelUsuarioFerias();
    ControllerUsuario controllerUsuario = new ControllerUsuario();
    ControllerCadEndereco controllerCadEndereco = new ControllerCadEndereco();
    ControllerUsuarioFerias controllerUsuarioFerias = new ControllerUsuarioFerias();
    ArrayList<ModelCadEndereco> listaModelCadEndereco = new ArrayList<>();
    ArrayList<ModelUsuarioFerias> listaUsuarioFeriases = new ArrayList<>();
    VerificaCpf verificaCpf = new VerificaCpf();
    public int codigoUsuario;
    String salvarAlterar;

    public ViewCadUsuario() {
        initComponents();
        setLocationRelativeTo(null);
        habilitaCampo(false);
        btAlterar.setEnabled(false);
        btCancelar.setEnabled(false);
        btSalvar.setEnabled(false);
        btNovo.setEnabled(true);
        btPesquisar.setEnabled(true);

    }

    private void removeItemTb() {
        int linhaSelecionada = tbUsuarioFerias.getSelectedRow();
        // Verificamos se existe realmente alguma linha selecionada
        if (linhaSelecionada < 0) {
            return;
        } else {
            // Obtem o modelo da JTable
            DefaultTableModel modelo = (DefaultTableModel) tbUsuarioFerias.getModel();
            // Remove a linha
            modelo.removeRow(linhaSelecionada);
        }
    }

    private void adicionaUsuarioTb() {
        BLDatas bl = new BLDatas();

        DefaultTableModel modelo = (DefaultTableModel) tbUsuarioFerias.getModel();
        int cont = 0;
        modelUsuario = controllerUsuario.getUsuarioController(Integer.parseInt(txCodigo.getText()));
        for (int i = 0; i < cont; i++) {
            modelo.setNumRows(0);
        }
        try {
            //pega a quantidade de linhas e joga na variavel
            modelo.addRow(new Object[]{
                modelUsuario.getNome(),
                bl.formatarData(jcdDataIniFerias.getDate()),
                bl.formatarData(jcdDataFimFerias.getDate())
            });
        } catch (Exception ex) {
            Logger.getLogger(ViewAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void carregarUsuario(int pCodigoUsuario) {
        ControllerUsuario controllerUsuario = new ControllerUsuario();
        ModelUsuario modelUsuario = new ModelUsuario();
        modelUsuario = controllerUsuario.getUsuarioController(codigoUsuario);
        ControllerCadEndereco controllerCadEndereco = new ControllerCadEndereco();
        ModelCadEndereco modelCadEndereco = new ModelCadEndereco();
        modelCadEndereco = controllerCadEndereco.getCadEnderecoCodController(modelUsuario.getCod_endereco());

        txAgencia.setText(modelUsuario.getAgencia());
        txBairro.setText(modelCadEndereco.getEnd_bairro());
        txBanco.setText(modelUsuario.getBanco());
        txCargo.setText(modelUsuario.getCargo());
        txCel1.setText(modelUsuario.getCel_1());
        txCel2.setText(modelUsuario.getCel_2());
        txCep.setText(modelCadEndereco.getEnd_cep());
        txCodigo.setText(String.valueOf(modelUsuario.getId()));
        txComplemento.setText(modelUsuario.getComplemento());
        txCpf.setText(modelUsuario.getCpf());
        txCtps.setText(modelUsuario.getCtps());
        txEmail.setText(modelUsuario.getEmail());
        txLogradouro.setText(modelCadEndereco.getEnd_logradouro());
        txMunicipio.setText(modelCadEndereco.getEnd_cidade());
        txNome.setText(modelUsuario.getNome());
        txNumConta.setText(modelUsuario.getConta());
        txNumero.setText(modelUsuario.getNumero());
        txPis.setText(modelUsuario.getPis());
        txRg.setText(modelUsuario.getRg());
        txSerieUf.setText(modelUsuario.getSerie_uf());
        txTel1.setText(modelUsuario.getTel_1());
        txTel2.setText(modelUsuario.getTel_2());
        txUf.setText(modelCadEndereco.getEnd_uf());
        txUsuario.setText(modelUsuario.getUsuario());
        taAnotacoesDiversas.setText(modelUsuario.getAnotacoes_diversas());

        jcdDataAdmissao.setDate(modelUsuario.getDt_admissao());

        jcdDataDemissao.setDate(modelUsuario.getDt_demissao());

        jcdDataEmissaoCpts.setDate(modelUsuario.getDt_emissao_ctps());

        jcdDataEmissaoCpts.setDate(modelUsuario.getDt_emissao_rg());

        jcdDataNascimento.setDate(modelUsuario.getDt_nascimento());
        jcdEmissaoRg.setDate(modelUsuario.getDt_emissao_rg());
        
        listaUsuarioFeriases = controllerUsuarioFerias.getListaUsuarioFeriasController(modelUsuario.getId());
        DefaultTableModel modelo = (DefaultTableModel) tbUsuarioFerias.getModel();
        modelo.setNumRows(0);
        int cont = listaUsuarioFeriases.size();
        for (int i = 0; i < cont; i++) {
            modelUsuario = controllerUsuario.getUsuarioController(listaUsuarioFeriases.get(i).getId_usuario());
            modelo.addRow(new Object[]{
                modelUsuario.getNome(),
                listaUsuarioFeriases.get(i).getDt_inicio(),
                listaUsuarioFeriases.get(i).getDt_fim()
            });
        }
        
        

        /**
         * Permissões de acesso
         *
         */
        //Cadastro
        if (modelUsuario.getPerm_cad_aluno() == 1) {
            jcbCadAlunos.setSelected(true);

        } else if (modelUsuario.getPerm_cad_aluno() == 0) {
            jcbCadAlunos.setSelected(false);
        }

        if (modelUsuario.getPerm_cad_usuario() == 1) {
            jcbCadUsuarios.setSelected(true);

        } else if (modelUsuario.getPerm_cad_usuario() == 0) {
            jcbCadUsuarios.setSelected(false);
        }

        if (modelUsuario.getPerm_cad_empresa() == 1) {
            jcbCadEmpresa.setSelected(true);

        } else if (modelUsuario.getPerm_cad_empresa() == 0) {
            jcbCadEmpresa.setSelected(false);
        }

    }

    private void salvar() {
        BLDatas bl = new BLDatas();
        Date dtAdmissao = null;
        Date dtDemissao = null;
        Date dtEmiCtps = null;
        Date dtEmiRG = null;
        Date dtNasc = null;

        modelCadEndereco = controllerCadEndereco.getCadEnderecoController(txCep.getText());
        modelUsuario.setAgencia(txAgencia.getText());
        modelUsuario.setAnotacoes_diversas(taAnotacoesDiversas.getText());
        modelUsuario.setBanco(txBanco.getText());
        modelUsuario.setCargo(txCargo.getText());
        modelUsuario.setCel_1(txCel1.getText());
        modelUsuario.setCel_2(txCel2.getText());
        modelUsuario.setCod_endereco(modelCadEndereco.getEnd_codigo());
        modelUsuario.setComplemento(txComplemento.getText());
        modelUsuario.setConta(txNumConta.getText());
        modelUsuario.setCpf(txCpf.getText());
        modelUsuario.setCtps(txCtps.getText());

        try {
            dtAdmissao = bl.converterDataParaDateUS(jcdDataAdmissao.getDate());
            dtDemissao = bl.converterDataParaDateUS(jcdDataDemissao.getDate());
            dtEmiCtps = bl.converterDataParaDateUS(jcdDataEmissaoCpts.getDate());
            dtEmiRG = bl.converterDataParaDateUS(jcdEmissaoRg.getDate());
            dtNasc = bl.converterDataParaDateUS(jcdDataNascimento.getDate());

            modelUsuario.setDt_admissao(dtAdmissao);
            modelUsuario.setDt_demissao(dtDemissao);
            modelUsuario.setDt_emissao_ctps(dtEmiCtps);
            modelUsuario.setDt_emissao_rg(dtEmiRG);
            modelUsuario.setDt_nascimento(dtNasc);
        } catch (Exception e) {
        }

        modelUsuario.setEmail(txEmail.getText());
        modelUsuario.setNome(txNome.getText());
        modelUsuario.setNumero(txNumero.getText());
        modelUsuario.setPis(txPis.getText());
        modelUsuario.setRep_senha(new String(this.jpwRepSenha.getPassword()));
        modelUsuario.setSenha(new String(this.jpwSenha.getPassword()));
        modelUsuario.setRg(txRg.getText());
        modelUsuario.setSerie_uf(txSerieUf.getText());
        modelUsuario.setTel_1(txTel1.getText());
        modelUsuario.setTel_2(txTel2.getText());
        modelUsuario.setUsuario(txUsuario.getText());

        /**
         * Permissões de acesso
         */
        //Cadastro
        if (jcbCadAlunos.isSelected()) {
            modelUsuario.setPerm_cad_aluno(1);
        } else if (!jcbCadAlunos.isSelected()) {
            modelUsuario.setPerm_cad_aluno(0);
        }
        if (jcbCadEmpresa.isSelected()) {
            modelUsuario.setPerm_cad_empresa(1);
        } else if (!jcbCadEmpresa.isSelected()) {
            modelUsuario.setPerm_cad_empresa(0);
        }
        if (jcbCadUsuarios.isSelected()) {
            modelUsuario.setPerm_cad_usuario(1);
        } else if (!jcbCadUsuarios.isSelected()) {
            modelUsuario.setPerm_cad_usuario(0);
        }

        //salvar
        codigoUsuario = controllerUsuario.salvarUsuarioController(modelUsuario);
        if (codigoUsuario > 0) {
            modelUsuario.setId(codigoUsuario);

        }

        for (int i = 0; i < tbUsuarioFerias.getRowCount(); i++) {
            modelUsuarioFerias.setId_usuario(codigoUsuario);
            modelUsuarioFerias.setDt_inicio((String) tbUsuarioFerias.getValueAt(i, 1));
            modelUsuarioFerias.setDt_fim((String) tbUsuarioFerias.getValueAt(i, 2));
            controllerUsuarioFerias.salvarUsuarioFeriasController(modelUsuarioFerias);

        }

        JOptionPane.showMessageDialog(this, "Registro cadastrado com sucesso!");

    }

    private void alterar() {
        BLDatas bl = new BLDatas();
        Date dtAdmissao = null;
        Date dtDemissao = null;
        Date dtEmiCtps = null;
        Date dtEmiRG = null;
        Date dtNasc = null;

        modelCadEndereco = controllerCadEndereco.getCadEnderecoController(txCep.getText());
        modelUsuario.setId(Integer.parseInt(txCodigo.getText()));
        modelUsuario.setAgencia(txAgencia.getText());
        modelUsuario.setAnotacoes_diversas(taAnotacoesDiversas.getText());
        modelUsuario.setBanco(txBanco.getText());
        modelUsuario.setCargo(txCargo.getText());
        modelUsuario.setCel_1(txCel1.getText());
        modelUsuario.setCel_2(txCel2.getText());
        modelUsuario.setCod_endereco(modelCadEndereco.getEnd_codigo());
        modelUsuario.setComplemento(txComplemento.getText());
        modelUsuario.setConta(txNumConta.getText());
        modelUsuario.setCpf(txCpf.getText());
        modelUsuario.setCtps(txCtps.getText());

        try {
            dtAdmissao = bl.converterDataParaDateUS(jcdDataAdmissao.getDate());
            dtDemissao = bl.converterDataParaDateUS(jcdDataDemissao.getDate());
            dtEmiCtps = bl.converterDataParaDateUS(jcdDataEmissaoCpts.getDate());
            dtEmiRG = bl.converterDataParaDateUS(jcdEmissaoRg.getDate());
            dtNasc = bl.converterDataParaDateUS(jcdDataNascimento.getDate());

            modelUsuario.setDt_admissao(dtAdmissao);
            modelUsuario.setDt_demissao(dtDemissao);
            modelUsuario.setDt_emissao_ctps(dtEmiCtps);
            modelUsuario.setDt_emissao_rg(dtEmiRG);
            modelUsuario.setDt_nascimento(dtNasc);
        } catch (Exception e) {
        }

        modelUsuario.setEmail(txEmail.getText());
        modelUsuario.setNome(txNome.getText());
        modelUsuario.setNumero(txNumero.getText());
        modelUsuario.setPis(txPis.getText());
        modelUsuario.setRep_senha(new String(this.jpwRepSenha.getPassword()));
        modelUsuario.setSenha(new String(this.jpwSenha.getPassword()));
        modelUsuario.setRg(txRg.getText());
        modelUsuario.setSerie_uf(txSerieUf.getText());
        modelUsuario.setTel_1(txTel1.getText());
        modelUsuario.setTel_2(txTel2.getText());
        modelUsuario.setUsuario(txUsuario.getText());

        /**
         * Permissões de acesso
         */
        //Cadastro
        if (jcbCadAlunos.isSelected()) {
            modelUsuario.setPerm_cad_aluno(1);
        } else if (!jcbCadAlunos.isSelected()) {
            modelUsuario.setPerm_cad_aluno(0);
        }
        if (jcbCadEmpresa.isSelected()) {
            modelUsuario.setPerm_cad_empresa(1);
        } else if (!jcbCadEmpresa.isSelected()) {
            modelUsuario.setPerm_cad_empresa(0);
        }
        if (jcbCadUsuarios.isSelected()) {
            modelUsuario.setPerm_cad_usuario(1);
        } else if (!jcbCadUsuarios.isSelected()) {
            modelUsuario.setPerm_cad_usuario(0);
        }
        controllerUsuario.atualizarUsuarioController(modelUsuario);

        listaUsuarioFeriases = controllerUsuarioFerias.getListaUsuarioFeriasController();
        int cont = listaUsuarioFeriases.size();
        DefaultTableModel modelo = (DefaultTableModel) tbUsuarioFerias.getModel();
        int tabela = modelo.getRowCount();

        for (int i = cont; i < tabela; i++) {
            modelUsuarioFerias.setId_usuario(modelUsuario.getId());
            modelUsuarioFerias.setDt_inicio((String) tbUsuarioFerias.getValueAt(i, 1));
            modelUsuarioFerias.setDt_fim((String) tbUsuarioFerias.getValueAt(i, 2));
            controllerUsuarioFerias.salvarUsuarioFeriasController(modelUsuarioFerias);

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
        txCpf.setText("");
        txCtps.setText("");
        txEmail.setText("");
        txNome.setText("");
        txCargo.setText("");
        txUsuario.setText("");
        txNumConta.setText("");
        txPis.setText("");
        jpwSenha.setText("");
        jpwRepSenha.setText("");
        txRg.setText("");
        txSerieUf.setText("");
        txTel1.setText("");
        txTel2.setText("");
        txCep.setText("");
        txComplemento.setText("");
        txLogradouro.setText("");
        txBairro.setText("");
        txMunicipio.setText("");
        txNumero.setText("");
        txUf.setText("");
        Date date = null;
        jcdDataEmissaoCpts.setDate(date);
        jcdDataNascimento.setDate(date);
        jcdEmissaoRg.setDate(date);
        jcdDataIniFerias.setDate(date);
        jcdDataAdmissao.setDate(date);
        jcdDataDemissao.setDate(date);
        jcdDataFimFerias.setDate(date);
        taAnotacoesDiversas.setText("");
        jcbCadAlunos.setSelected(false);
        jcbCadEmpresa.setSelected(false);
        jcbCadUsuarios.setSelected(false);
        DefaultTableModel modelo = (DefaultTableModel) tbUsuarioFerias.getModel();
        modelo.setNumRows(0);

    }

    private void habilitaCampo(boolean condicao) {
        txAgencia.setEnabled(condicao);
        txBanco.setEnabled(condicao);
        txCodigo.setEnabled(condicao);
        txCpf.setEnabled(condicao);
        txCtps.setEnabled(condicao);
        txEmail.setEnabled(condicao);
        txNome.setEnabled(condicao);
        txCargo.setEnabled(condicao);
        txUsuario.setEnabled(condicao);
        txNumConta.setEnabled(condicao);
        txPis.setEnabled(condicao);
        jpwSenha.setEnabled(condicao);
        jpwRepSenha.setEnabled(condicao);
        txRg.setEnabled(condicao);
        txSerieUf.setEnabled(condicao);
        txTel1.setEnabled(condicao);
        txTel2.setEnabled(condicao);
        txCel1.setEnabled(condicao);
        txCel2.setEnabled(condicao);
        jcdDataEmissaoCpts.setEnabled(condicao);
        jcdDataNascimento.setEnabled(condicao);
        jcdEmissaoRg.setEnabled(condicao);
        cbSexo.setEnabled(condicao);
        cbSituacao.setEnabled(condicao);
        txCep.setEnabled(condicao);
        txComplemento.setEnabled(condicao);
        txLogradouro.setEnabled(condicao);
        txBairro.setEnabled(condicao);
        txMunicipio.setEnabled(condicao);
        txNumero.setEnabled(condicao);
        txUf.setEnabled(condicao);
        btPesquisaCep.setEnabled(condicao);
        taAnotacoesDiversas.setEnabled(condicao);
        btIncluirEntrevista.setEnabled(condicao);
        tbUsuarioFerias.setEnabled(condicao);
        jcdDataIniFerias.setEnabled(condicao);
        jcdDataAdmissao.setEnabled(condicao);
        jcdDataDemissao.setEnabled(condicao);
        jcdDataFimFerias.setEnabled(condicao);
        jcbCadAlunos.setEnabled(condicao);
        jcbCadEmpresa.setEnabled(condicao);
        jcbCadUsuarios.setEnabled(condicao);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txRg = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txCargo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txUsuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txCpf = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jcdEmissaoRg = new com.toedter.calendar.JDateChooser();
        jcdDataNascimento = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        txCtps = new javax.swing.JTextField();
        txSerieUf = new javax.swing.JTextField();
        jcdDataEmissaoCpts = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txPis = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txNumConta = new javax.swing.JTextField();
        txAgencia = new javax.swing.JTextField();
        txBanco = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jpwSenha = new javax.swing.JPasswordField();
        jpwRepSenha = new javax.swing.JPasswordField();
        jcdDataAdmissao = new com.toedter.calendar.JDateChooser();
        jLabel41 = new javax.swing.JLabel();
        jcdDataDemissao = new com.toedter.calendar.JDateChooser();
        jLabel42 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txTel1 = new javax.swing.JTextField();
        txTel2 = new javax.swing.JTextField();
        txCel1 = new javax.swing.JTextField();
        txCel2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txEmail = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
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
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taAnotacoesDiversas = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jcdDataIniFerias = new com.toedter.calendar.JDateChooser();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbUsuarioFerias = new javax.swing.JTable();
        btIncluirEntrevista = new javax.swing.JButton();
        jcdDataFimFerias = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        btRemover = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jcbCadAlunos = new javax.swing.JCheckBox();
        jcbCadEmpresa = new javax.swing.JCheckBox();
        jcbCadUsuarios = new javax.swing.JCheckBox();
        jcbCadProdutos = new javax.swing.JCheckBox();
        jcbCadHorarios = new javax.swing.JCheckBox();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        cbSituacao = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();
        cbSexo = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de usuários");
        setResizable(false);

        txCodigo.setEditable(false);
        txCodigo.setFocusable(false);

        jLabel2.setText("Código");
        jLabel2.setToolTipText("");

        txNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txNomeKeyReleased(evt);
            }
        });

        jLabel3.setText("Nome");

        jLabel4.setText("RG");

        txCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txCargoKeyReleased(evt);
            }
        });

        jLabel5.setText("Cargo");

        jLabel6.setText("Repetir a senha");

        jLabel7.setText("Usuario");

        txCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txCpfFocusLost(evt);
            }
        });

        jLabel14.setText("CPF");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Documentação");

        jLabel16.setText("Data de emissão do RG");

        jLabel17.setText("Data de Nascimento");

        jLabel18.setText("CPTS Nº");

        jLabel19.setText("Série/UF");

        jLabel20.setText("Dt. Emissão");

        txPis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPisActionPerformed(evt);
            }
        });

        jLabel21.setText("PIS");

        jLabel22.setText("Nº da Conta");

        jLabel23.setText("Agência");

        jLabel24.setText("Banco");

        jLabel9.setText("Senha");

        jLabel41.setText("Data Admissão");

        jLabel42.setText("Data Demissao");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(582, 582, 582))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jpwSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(jpwRepSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jcdDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel41))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel42)
                                            .addComponent(jcdDataDemissao, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txNumConta, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel18)
                                    .addComponent(txCtps, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txSerieUf)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel19)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(jcdDataEmissaoCpts, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addGap(147, 147, 147))
                                            .addComponent(txAgencia))
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel24)
                                            .addComponent(txBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txRg, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(177, 177, 177)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16)
                                            .addComponent(jcdEmissaoRg, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txPis, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21)
                                    .addComponent(jcdDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))))
                        .addGap(57, 57, 57))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel41))
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcdDataDemissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcdDataAdmissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jpwSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpwRepSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel4)
                            .addComponent(jLabel16)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcdEmissaoRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcdDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(jLabel18))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20)
                                .addComponent(jLabel21)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txCtps)
                                .addComponent(txSerieUf))
                            .addComponent(txPis)))
                    .addComponent(jcdDataEmissaoCpts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNumConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados", jPanel1);

        jLabel13.setText("Celular 2");

        jLabel12.setText("Celular 1");

        jLabel11.setText("Telefone 2");

        jLabel10.setText("Telefone 1");

        jLabel26.setText("E-mail");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txCep, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPesquisaCep))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel10))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32)
                                    .addComponent(txMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(307, 307, 307))
                    .addGroup(jPanel2Layout.createSequentialGroup()
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
                                            .addComponent(txNumero))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel30)
                                                .addGap(111, 111, 111))
                                            .addComponent(txComplemento)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txUf, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel33))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txTel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txTel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txCel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(txCel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel12)
                        .addComponent(jLabel11)))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txTel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txTel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txCel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txCel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jLabel26)
                .addGap(6, 6, 6)
                .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Endereço/Contato", jPanel2);

        taAnotacoesDiversas.setColumns(20);
        taAnotacoesDiversas.setRows(5);
        jScrollPane2.setViewportView(taAnotacoesDiversas);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Anotações Diversas", jPanel4);

        jLabel37.setText("Início");

        tbUsuarioFerias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Funcaionário", "Início", "Fim"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbUsuarioFerias);
        if (tbUsuarioFerias.getColumnModel().getColumnCount() > 0) {
            tbUsuarioFerias.getColumnModel().getColumn(0).setResizable(false);
            tbUsuarioFerias.getColumnModel().getColumn(1).setResizable(false);
            tbUsuarioFerias.getColumnModel().getColumn(2).setResizable(false);
        }

        btIncluirEntrevista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Seta à direita Fim.png"))); // NOI18N
        btIncluirEntrevista.setText("Incluir");
        btIncluirEntrevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirEntrevistaActionPerformed(evt);
            }
        });

        jLabel8.setText("Fim");

        btRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        btRemover.setText("Remover");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcdDataIniFerias, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jcdDataFimFerias, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btIncluirEntrevista)
                        .addGap(18, 18, 18)
                        .addComponent(btRemover)
                        .addGap(120, 120, 120)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btIncluirEntrevista)
                        .addComponent(btRemover))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcdDataIniFerias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcdDataFimFerias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Férias", jPanel5);

        jcbCadAlunos.setText("Cadastro de Alunos");

        jcbCadEmpresa.setText("Cadastro de Empresas");

        jcbCadUsuarios.setText("Cadastro de Usuários");

        jcbCadProdutos.setText("Cadastro de Produtos");
        jcbCadProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCadProdutosActionPerformed(evt);
            }
        });

        jcbCadHorarios.setText("Cadastro de horários");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbCadAlunos)
                    .addComponent(jcbCadEmpresa)
                    .addComponent(jcbCadUsuarios)
                    .addComponent(jcbCadProdutos)
                    .addComponent(jcbCadHorarios))
                .addContainerGap(681, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbCadAlunos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbCadEmpresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbCadUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbCadProdutos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbCadHorarios)
                .addContainerGap(223, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Cadastros", jPanel6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane1.addTab("Permissões de acesso", jPanel3);

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

        jLabel1.setText("Situacao");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo transparente.png"))); // NOI18N

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Lupa.png"))); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        jLabel27.setText("Sexo");

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
                            .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(jLabel27))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btNovo)
                        .addComponent(btSalvar)
                        .addComponent(btAlterar)
                        .addComponent(btCancelar))
                    .addComponent(jLabel25))
                .addGap(23, 80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txPisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPisActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        salvarAlterar = "novo";
        habilitaCampo(true);
        btPesquisar.setEnabled(false);
        btNovo.setEnabled(false);
        btAlterar.setEnabled(false);
        btSalvar.setEnabled(true);
        btCancelar.setEnabled(true);
        limpaCampos();
        txNome.requestFocusInWindow();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        if (salvarAlterar.equals("novo")) {
            salvar();
            limpaCampos();
            habilitaCampo(false);
            btAlterar.setEnabled(true);
            btCancelar.setEnabled(false);
            btSalvar.setEnabled(false);
            btNovo.setEnabled(true);
            btPesquisar.setEnabled(true);

        } else if (salvarAlterar.equals("alterar")) {
            alterar();
            limpaCampos();
            habilitaCampo(false);
            btAlterar.setEnabled(true);
            btCancelar.setEnabled(false);
            btSalvar.setEnabled(false);
            btNovo.setEnabled(true);
            btPesquisar.setEnabled(true);
        }


    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        salvarAlterar = "";
        habilitaCampo(false);
        btAlterar.setEnabled(true);
        btCancelar.setEnabled(false);
        btSalvar.setEnabled(false);
        btNovo.setEnabled(true);
        btPesquisar.setEnabled(true);
        limpaCampos();
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

    private void txCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txCpfFocusLost

        try {
            if (verificaCpf.isCpf(txCpf.getText()) == true) {

            } else {
                JOptionPane.showMessageDialog(this, "CPF Inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                txCpf.requestFocusInWindow();
                txCpf.setText("");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "CPF Inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            txCpf.requestFocusInWindow();
            txCpf.setText("");
        }
    }//GEN-LAST:event_txCpfFocusLost

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        salvarAlterar = "alterar";
        habilitaCampo(true);
        btAlterar.setEnabled(false);
        btCancelar.setEnabled(true);
        btNovo.setEnabled(false);
        btPesquisar.setEnabled(false);
        btSalvar.setEnabled(true);
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        ViewPesquisaUsuario viewPesquisaUsuario = new ViewPesquisaUsuario(this, rootPaneCheckingEnabled);
        viewPesquisaUsuario.setVisible(true);
        codigoUsuario = viewPesquisaUsuario.getReturnStatus();
        carregarUsuario(codigoUsuario);
        btPesquisar.setEnabled(false);
        btNovo.setEnabled(false);
        btAlterar.setEnabled(true);
        btCancelar.setEnabled(true);
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btIncluirEntrevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirEntrevistaActionPerformed
        adicionaUsuarioTb();
    }//GEN-LAST:event_btIncluirEntrevistaActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        removeItemTb();
    }//GEN-LAST:event_btRemoverActionPerformed

    private void txNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNomeKeyReleased
                // converte em maiusculo o que o usuario digitar
        this.txNome.setText(txNome.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txNome.setText(blTiraAcentos.TiraAcentos(txNome.getText()));
    }//GEN-LAST:event_txNomeKeyReleased

    private void txCargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCargoKeyReleased
               // converte em maiusculo o que o usuario digitar
        this.txCargo.setText(txCargo.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txCargo.setText(blTiraAcentos.TiraAcentos(txCargo.getText()));
    }//GEN-LAST:event_txCargoKeyReleased

    private void jcbCadProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCadProdutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCadProdutosActionPerformed

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
            java.util.logging.Logger.getLogger(ViewCadUsuario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCadUsuario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCadUsuario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCadUsuario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCadUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btIncluirEntrevista;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisaCep;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbSexo;
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
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JCheckBox jcbCadAlunos;
    private javax.swing.JCheckBox jcbCadEmpresa;
    private javax.swing.JCheckBox jcbCadHorarios;
    private javax.swing.JCheckBox jcbCadProdutos;
    private javax.swing.JCheckBox jcbCadUsuarios;
    private com.toedter.calendar.JDateChooser jcdDataAdmissao;
    private com.toedter.calendar.JDateChooser jcdDataDemissao;
    private com.toedter.calendar.JDateChooser jcdDataEmissaoCpts;
    private com.toedter.calendar.JDateChooser jcdDataFimFerias;
    private com.toedter.calendar.JDateChooser jcdDataIniFerias;
    private com.toedter.calendar.JDateChooser jcdDataNascimento;
    private com.toedter.calendar.JDateChooser jcdEmissaoRg;
    private javax.swing.JPasswordField jpwRepSenha;
    private javax.swing.JPasswordField jpwSenha;
    private javax.swing.JTextArea taAnotacoesDiversas;
    private javax.swing.JTable tbUsuarioFerias;
    private javax.swing.JTextField txAgencia;
    private javax.swing.JTextField txBairro;
    private javax.swing.JTextField txBanco;
    private javax.swing.JTextField txCargo;
    private javax.swing.JTextField txCel1;
    private javax.swing.JTextField txCel2;
    private javax.swing.JTextField txCep;
    private javax.swing.JTextField txCodigo;
    private javax.swing.JTextField txComplemento;
    private javax.swing.JTextField txCpf;
    private javax.swing.JTextField txCtps;
    private javax.swing.JTextField txEmail;
    private javax.swing.JTextField txLogradouro;
    private javax.swing.JTextField txMunicipio;
    private javax.swing.JTextField txNome;
    private javax.swing.JTextField txNumConta;
    private javax.swing.JTextField txNumero;
    private javax.swing.JTextField txPis;
    private javax.swing.JTextField txRg;
    private javax.swing.JTextField txSerieUf;
    private javax.swing.JTextField txTel1;
    private javax.swing.JTextField txTel2;
    private javax.swing.JTextField txUf;
    private javax.swing.JTextField txUsuario;
    // End of variables declaration//GEN-END:variables
}
