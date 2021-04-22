package view;

import controller.ControllerCadEndereco;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.ModelCadEndereco;
import static org.joda.time.format.ISODateTimeFormat.date;
import util.WebServiceCep;
import util.VerificaCpf;
import controller.ControllerAluno;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelAluno;
import util.BLDatas;
import model.ModelEmpresa;
import controller.ControllerEmpresa;
import javax.swing.table.DefaultTableModel;
import util.BLMascaras;
import model.ModelEntrevistaAluno;
import controller.ControllerEntrevistaAluno;
import DAO.DAOInserirImagem;
import model.ModelBucarImagem;
import controller.ControllerBucarImagem;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import model.ModelInserirImagem;
import model.Modeladmicao;
import controller.Controlleradmicao;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import util.BLTiraAcentos;
import util.FolhaPagamento;
import util.ManipularImagem;
import model.ModelOrigemAluno;
import controller.ControllerOrigemAluno;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import model.ModelCargo;
import controller.ControllerCargo;
import controller.ControllerFormacaoBasica;
import controller.ControllerTurma;
import controller.ControllerSala;
import model.ModelFormacaoBasica;
import model.ModelSala;
import model.ModelTurma;

/**
 *
 * @author charles
 */
public class ViewAluno extends javax.swing.JFrame {

    ModelInserirImagem modelInserirImagem = new ModelInserirImagem();
    ModelCadEndereco modelCadEndereco = new ModelCadEndereco();
    ModelAluno modelAluno = new ModelAluno();
    ModelEmpresa modelEmpresa = new ModelEmpresa();
    ModelEntrevistaAluno modelEntrevistaAluno = new ModelEntrevistaAluno();
    ModelOrigemAluno modelOrigemAluno = new ModelOrigemAluno();
    ModelBucarImagem modelBucarImagem = new ModelBucarImagem();
    Modeladmicao modeladmicao = new Modeladmicao();
    ModelCargo modelCargo = new ModelCargo();
    ModelFormacaoBasica modelFormacaoBasica = new ModelFormacaoBasica();
    ModelTurma modelTurma = new ModelTurma();
    ModelSala modelSala = new ModelSala();
    BufferedImage imagem;
    ControllerBucarImagem controllerBucarImagem = new ControllerBucarImagem();
    ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
    ControllerAluno controllerAluno = new ControllerAluno();
    ControllerCadEndereco controllerCadEndereco = new ControllerCadEndereco();
    ControllerEntrevistaAluno controllerEntrevistaAluno = new ControllerEntrevistaAluno();
    ControllerOrigemAluno controllerOrigemAluno = new ControllerOrigemAluno();
    Controlleradmicao controlleradmicao = new Controlleradmicao();
    ControllerCargo controllerCargo = new ControllerCargo();
    ControllerFormacaoBasica controllerFormacaoBasica = new ControllerFormacaoBasica();
    ControllerTurma controllerTurma = new ControllerTurma();
    ControllerSala controllerSala = new ControllerSala();
    DAOInserirImagem daoInserirImagem = new DAOInserirImagem();
    ArrayList<ModelAluno> listaModelAlunos = new ArrayList<>();
    ArrayList<Modeladmicao> listaModeladmicaos = new ArrayList<>();
    ArrayList<ModelCadEndereco> listaModelCadEndereco = new ArrayList<>();
    ArrayList<ModelEmpresa> listaModelEmpresas = new ArrayList<>();
    ArrayList<ModelEntrevistaAluno> listaEntrevistaAlunos = new ArrayList<>();
    ArrayList<ModelOrigemAluno> listaModelOrigemAlunos = new ArrayList<>();
    ArrayList<ModelCargo> listaModelCargos = new ArrayList<>();
    ArrayList<ModelFormacaoBasica> listaModelFormacaoBasicas = new ArrayList<>();
    ArrayList<ModelTurma> listaModelTurmas = new ArrayList<>();
    ArrayList<ModelSala> listaModelSalas = new ArrayList<>();
    VerificaCpf verificaCpf = new VerificaCpf();
    String salvarAlterar;
    public int codigoAluno;

    public ViewAluno() {

        initComponents();
        /**
         * método para a resolução de tela
         */


        setLocationRelativeTo(null);
        habilitaCampo(false);
        btAlterar.setEnabled(false);
        btCancelar.setEnabled(false);
        btSalvar.setEnabled(false);
        btNovo.setEnabled(true);
        btPesquisar.setEnabled(true);
        preencherCbEmpresa();
        preencherCbEmpresaAdm();
        preencherCbAlunoOrigem();
        preencherCbAlunoCargo();
        preencherCbFormacao();
        preencherTurma();
        preencherSala();
        lbNomeApresentacao.setText("");
        lbRGMApresentacao.setText("");

    }

    private void calculoDaFolha() {
        List<FolhaPagamento.FaixaIRPF> faixas = Arrays.asList(
                new FolhaPagamento.FaixaIRPF(0.0, 0.0, 1499.15),
                new FolhaPagamento.FaixaIRPF(7.5, 1499.16, 2246.75),
                new FolhaPagamento.FaixaIRPF(15.0, 2246.76, 2995.70),
                new FolhaPagamento.FaixaIRPF(22.5, 2995.70, 3743.19),
                new FolhaPagamento.FaixaIRPF(27.5, 3743.20, Double.MAX_VALUE));

        Double salario = Double.parseDouble(txSalario.getText());

        Double salarioAux = 900.0;
        Double imposto = 0.0;
        for (FolhaPagamento.FaixaIRPF faixa : faixas) {

            if (faixa.getAliquota() == 0.0) {

                salarioAux -= faixa.getValorFinal();
                continue;
            }

            Double valorCalculo = salarioAux;
            if (salario > faixa.getValorFinal()) {

                valorCalculo = faixa.getValorFinal() - faixa.getValorInicio();
            }

            imposto += ((valorCalculo / 100) * faixa.getAliquota());
            salarioAux -= valorCalculo;

            if (faixa.getValorFinal() > salario) {
                break;
            }
        }
        System.out.println("Valor imposto: " + imposto);
        System.out.println("Salario sem IRPF: " + (salario - imposto));
    }

    public static class FaixaIRPF {

        private Double aliquota;

        private Double valorInicio;

        private Double valorFinal;

        public FaixaIRPF(Double aliquota, Double valorInicio, Double valorFinal) {
            this.aliquota = aliquota;
            this.valorFinal = valorFinal;
            this.valorInicio = valorInicio;
        }

        public Double getAliquota() {
            return aliquota;
        }

        public void setAliquota(Double aliquota) {
            this.aliquota = aliquota;
        }

        public Double getValorFinal() {
            return valorFinal;
        }

        public void setValorFinal(Double valorFinal) {
            this.valorFinal = valorFinal;
        }

        public Double getValorInicio() {
            return valorInicio;
        }

        public void setValorInicio(Double valorInicio) {
            this.valorInicio = valorInicio;
        }

    }

    private void selecionaImagem() {
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();

            try {
                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 300, 160);

                lblImagem.setIcon(new ImageIcon(imagem));

            } catch (Exception ex) {
                // System.out.println(ex.printStackTrace().toString());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
        }
    }

    private void excluirImagem() {
        ModelInserirImagem obj = new ModelInserirImagem();
        DAOInserirImagem dao = new DAOInserirImagem();
        Boolean foi = dao.excluir(codigoAluno);
        limparVariavelImagem();
    }

    private void salvarImagem() {
        try {
            ModelInserirImagem obj = new ModelInserirImagem();
            obj.setImagem(ManipularImagem.getImgBytes(imagem));
            obj.setId_aluno(codigoAluno);
            DAOInserirImagem dao = new DAOInserirImagem();

            // Boolean foi = dao.inserir(obj);
            Boolean foi = dao.salvarImagemDAO(obj);
            if (foi) {
                //JOptionPane.showMessageDialog(rootPane, "Imagem enviada com sucesso");

            } else {
                JOptionPane.showMessageDialog(rootPane, "Imagem não enviada");

            }
           

        } catch (Exception ex) {
            Logger.getLogger(ViewAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void limparVariavelImagem() {
        ModelInserirImagem obj = new ModelInserirImagem();
        obj.setImagem(null);
        obj.setId_aluno(0);

    }


    /*
    private void carregaImagem(int codAluno) {
        Integer id = Integer.parseInt(txCodigo.getText());
        DAOInserirImagem dao = new DAOInserirImagem();
        ModelInserirImagem exe = dao.buscar(id);
        ManipularImagem.exibiImagemLabel(exe.getImagem(), lblImagem);
    }*/
    private void carregaImagem(int codAluno) {
        modelBucarImagem = controllerBucarImagem.getBucarImagemController(codigoAluno);
        Integer id = modelBucarImagem.getId_aluno();
        DAOInserirImagem dao = new DAOInserirImagem();
        ModelInserirImagem exe = dao.getImagem(id);
        ManipularImagem.exibiImagemLabel(exe.getImagem(), lblImagem);
    }

    private void adicionaEmpresa() {
        BLDatas bl = new BLDatas();

        DefaultTableModel modelo = (DefaultTableModel) tbEmpresaEntrevista.getModel();
        int cont = 0;

        for (int i = 0; i < cont; i++) {
            modelo.setNumRows(0);
        }
        try {
            //pega a quantidade de linhas e joga na variavel
            modelo.addRow(new Object[]{
                cbEmpresa.getSelectedItem(),
                bl.formatarData(jcdDataEntrevista.getDate()),
                txHorarioEntrevista.getText()
            });
        } catch (Exception ex) {
            Logger.getLogger(ViewAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preencherCbEmpresa() {
        listaModelEmpresas = controllerEmpresa.getListaEmpresaController();

        cbEmpresa.removeAllItems();
        for (int i = 0; i < listaModelEmpresas.size(); i++) {
            cbEmpresa.addItem(listaModelEmpresas.get(i).getCodigoEmpresa() + " - " + listaModelEmpresas.get(i).getRazao());

        }

    }

    private void preencherCbAlunoOrigem() {
        listaModelOrigemAlunos = controllerOrigemAluno.getListaOrigemAlunoController();

        cbOrigemAluno.removeAllItems();
        for (int i = 0; i < listaModelOrigemAlunos.size(); i++) {
            cbOrigemAluno.addItem(listaModelOrigemAlunos.get(i).getOrig_descricao());

        }

    }

    private void preencherCbAlunoCargo() {
        listaModelCargos = controllerCargo.getListaCargoController();

        cbCargo.removeAllItems();
        for (int i = 0; i < listaModelCargos.size(); i++) {
            cbCargo.addItem(listaModelCargos.get(i).getDescricao());

        }

    }

    private void preencherCbFormacao() {
        listaModelFormacaoBasicas = controllerFormacaoBasica.getListaFormacaoBasicaController();

        cbFormacao.removeAllItems();
        for (int i = 0; i < listaModelFormacaoBasicas.size(); i++) {
            cbFormacao.addItem(listaModelFormacaoBasicas.get(i).getDescricao());

        }

    }

    private void preencherTurma() {
        listaModelTurmas = controllerTurma.getListaTurmaController();

        cbTurma.removeAllItems();
        for (int i = 0; i < listaModelTurmas.size(); i++) {
            cbTurma.addItem(listaModelTurmas.get(i).getDescricao());

        }

    }

    private void preencherSala() {
        listaModelSalas = controllerSala.getListaSalaController();

        cbSala.removeAllItems();
        for (int i = 0; i < listaModelSalas.size(); i++) {
            cbSala.addItem(listaModelSalas.get(i).getDescricao());

        }

    }

    private void preencherCbEmpresaAdm() {
        listaModelEmpresas = controllerEmpresa.getListaEmpresaController();

        cbEmpresa_adm.removeAllItems();
        for (int i = 0; i < listaModelEmpresas.size(); i++) {
            //cbEmpresa_adm.addItem(listaModelEmpresas.get(i).getRazao());
            cbEmpresa_adm.addItem(listaModelEmpresas.get(i).getCodigoEmpresa() + " - " + listaModelEmpresas.get(i).getRazao());

        }

    }

    private void removeItem() {
        int linhaSelecionada = tbEmpresaEntrevista.getSelectedRow();
        // Verificamos se existe realmente alguma linha selecionada
        if (linhaSelecionada < 0) {
            return;
        } else {
            // Obtem o modelo da JTable
            DefaultTableModel modelo = (DefaultTableModel) tbEmpresaEntrevista.getModel();
            // Remove a linha
            modelo.removeRow(linhaSelecionada);
        }
    }

    //carrega os dados do aluno
    private void carregarAlunos(int pcodigoAluno) {
        ControllerAluno controllerAluno = new ControllerAluno();
        ControllerCadEndereco controllerCadEndereco = new ControllerCadEndereco();
        ModelCadEndereco modelCadEndereco = new ModelCadEndereco();

        ModelAluno modelAluno = new ModelAluno();
        modelAluno = controllerAluno.getAlunoController(codigoAluno);
        modelCadEndereco = controllerCadEndereco.getCadEnderecoCodController(modelAluno.getCod_endereco());

        modelBucarImagem = controllerBucarImagem.getBucarImagemController(modelAluno.getId());
        System.out.println(modelBucarImagem.getId_aluno());
        //dados
        txCodigo.setText(String.valueOf(modelAluno.getId()));
        txNome.setText(modelAluno.getNome_aluno());
        txAgencia.setText(modelAluno.getAgencia());
        txBanco.setText(modelAluno.getBanco());
        txRGM.setText(modelAluno.getRgm_aluno());
        txRg.setText(modelAluno.getRg_aluno());
        txNomeMae.setText(modelAluno.getMae());
        txNomePai.setText(modelAluno.getPai());
        txRgMae.setText(modelAluno.getRg_mae());
        txRgPai.setText(modelAluno.getRg_pai());
        txRg.setText(modelAluno.getRg_aluno());
        txCpf.setText(modelAluno.getCpf());
        txCtps.setText(modelAluno.getCtps());
        txSerieUf.setText(modelAluno.getSerie_uf_cpts());
        txPis.setText(modelAluno.getPis());
        txEscola.setText(modelAluno.getEscola());
        txLocalNascimento.setText(modelAluno.getLocal_nascimento());
        txUfLocalNascimento.setText(modelAluno.getUf_nascimento());
        txTipoResidencia.setText(modelAluno.getTipo_residencia());
        txPrestImovel.setText(String.valueOf(modelAluno.getValor_mensal_residencia()));
        txEmpFerias.setText(modelAluno.getFerias_empresa_num());
        txPeriodoFeriasAdq.setText(modelAluno.getFerias_periodo_adquirido());
        txPeriodoFeriasGoz.setText(modelAluno.getFerias_periodo_gozado());
        cbSexo.setSelectedItem(modelAluno.getSexo());
        txCep.setText("teste");
        lbNomeApresentacao.setText(modelAluno.getNome_aluno());
        lbRGMApresentacao.setText(modelAluno.getRgm_aluno());

        taAnDivAdm.setText(modelAluno.getAnot_administrativas());
        taAnDivPedagogicas.setText(modelAluno.getAnot_pedagogicas());
        taAnDivPsicologicas.setText(modelAluno.getAnot_psicologicas());
        taAnDivSociais.setText(modelAluno.getAnot_sociais());
        modelOrigemAluno = controllerOrigemAluno.getOrigemAlunoController(modelAluno.getOrigem_aluno());
        cbOrigemAluno.setSelectedItem(modelOrigemAluno.getOrig_descricao());
        modelFormacaoBasica = controllerFormacaoBasica.getFormacaoBasicaController(modelAluno.getFormacao_basica());
        cbFormacao.setSelectedItem(modelFormacaoBasica.getDescricao());

        modelCargo = controllerCargo.getCargoController(modelAluno.getCargo_aluno());
        cbCargo.setSelectedItem(modelCargo.getDescricao());



        if (modelAluno.getSexo().equals("M")) {
            cbSexo.setSelectedItem("Masculino");

        } else {
            cbSexo.setSelectedItem("Feminino");

        }

        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
        Date dataRg, dataCpts, dataNascimento, dataEntrevista;
        try {
            dataRg = formato.parse(modelAluno.getDt_emissao_rg());
            dataCpts = formato.parse(modelAluno.getDt_emissao_ctps());
            dataNascimento = formato.parse(modelAluno.getDt_nascimento());
//            dataEntrevista = formato.parse(modelAluno.getDt_entrevista());
            jcdEmissaoRg.setDate(dataRg);
            jcdDataEmissaoCPTS.setDate(dataCpts);
            jcdDataNascimento.setDate(dataNascimento);
            //   jcdDataEntrevista.setDate(dataEntrevista);

        } catch (ParseException ex) {
            Logger.getLogger(ViewAluno.class.getName()).log(Level.SEVERE, null, ex);
        }

        // jcdDataBaixa.setDate(modelAluno.getData_baixa());
        taAnotacoesDiversas.setText(modelAluno.getAnotacoes_diversas());
        taHomologacoes.setText(modelAluno.getHomologacoes());
        taPerfil.setText(modelAluno.getPerfil());

        if (modelAluno.getBaixa() == 1) {
            jcbBaixa.setSelected(true);

        } else {
            jcbBaixa.setSelected(false);
        }
        if (modelAluno.getSeguro() == 1) {
            jcbSeguro.setSelected(true);

        } else {
            jcbSeguro.setSelected(false);
        }
        if (modelBucarImagem.getId_aluno() == 0) {
            lblImagem.setIcon(null);
        } else {
            carregaImagem(modelBucarImagem.getId_aluno());
        }

        //endereço/contato
        txCep.setText(modelCadEndereco.getEnd_cep());
        txLogradouro.setText(modelCadEndereco.getEnd_logradouro());
        txBairro.setText(modelCadEndereco.getEnd_bairro());
        txMunicipio.setText(modelCadEndereco.getEnd_cidade());
        txNumero.setText(modelAluno.getNumero());
        txComplemento.setText(modelAluno.getComplemento());
        txEnderecoUF.setText(modelCadEndereco.getEnd_uf());
        txEmail.setText(modelAluno.getEmail());
        txCel1.setText(modelAluno.getTel_3());
        txCel2.setText(modelAluno.getTel_4());
        txTel1.setText(modelAluno.getTel_1());
        txTel2.setText(modelAluno.getTel_2());

        listaEntrevistaAlunos = controllerEntrevistaAluno.getListaEntrevistaAlunoController(modelAluno.getId());
        DefaultTableModel modelo = (DefaultTableModel) tbEmpresaEntrevista.getModel();
        modelo.setNumRows(0);
        int cont = listaEntrevistaAlunos.size();
        for (int i = 0; i < cont; i++) {
            modelEmpresa = controllerEmpresa.getEmpresaController(listaEntrevistaAlunos.get(i).getId_empresa());
            modelo.addRow(new Object[]{
                modelEmpresa.getRazao(),
                listaEntrevistaAlunos.get(i).getData_entrevista(),
                listaEntrevistaAlunos.get(i).getHorario_entrevista()
            });
        }
    }

    private void alterar() {
        modelCadEndereco = controllerCadEndereco.getCadEnderecoController(txCep.getText());
        BLDatas bl = new BLDatas();
        Date dtBaixa = null;
        Date dtEmissaoCpts = null;
        Date dtEmissaoRg = null;
        Date dtNascimento = null;
        try {
            dtEmissaoRg = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdEmissaoRg.getDate()));
            dtEmissaoCpts = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataEmissaoCPTS.getDate()));
            dtNascimento = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataNascimento.getDate()));
        } catch (Exception ex) {
            Logger.getLogger(ViewAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        modelAluno.setAgencia(txAgencia.getText());
        modelAluno.setAnotacoes_diversas(taAnotacoesDiversas.getText());
        if (jcbBaixa.isSelected() == true) {
            modelAluno.setBaixa(1);
        } else {
            modelAluno.setBaixa(0);
        }
        modelAluno.setBanco(txBanco.getText());
        modelAluno.setId(Integer.parseInt(txCodigo.getText()));
        modelAluno.setBeneficio_social(cbBeneficioSocial.getSelectedItem().toString());
        modelAluno.setCod_endereco(modelCadEndereco.getEnd_codigo());
        modelAluno.setComplemento(txComplemento.getText());
        modelAluno.setCpf(txCpf.getText());
        modelAluno.setCtps(txCtps.getText());
        modelAluno.setData_baixa(jcdDataBaixa.getDateFormatString());
        modelAluno.setSalario(Double.parseDouble(txSalario.getText()));
        modelAluno.setOrigem_aluno(cbOrigemAluno.getSelectedIndex() + 1);
        modelAluno.setCargo_aluno(cbCargo.getSelectedIndex() + 1);

        modelAluno.setFormacao_basica(cbFormacao.getSelectedIndex() + 1);

        modelAluno.setAnot_administrativas(taAnDivAdm.getText());
        modelAluno.setAnot_pedagogicas(taAnDivPedagogicas.getText());
        modelAluno.setAnot_psicologicas(taAnDivPsicologicas.getText());
        modelAluno.setAnot_sociais(taAnDivSociais.getText());

        modelAluno.setPerfil(taPerfil.getText());

        Date dataAtual = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String rg = dateFormat.format(dtEmissaoRg);
        String cpts = dateFormat.format(dtEmissaoCpts);
        String nascimento = dateFormat.format(dtNascimento);

        modelAluno.setDt_emissao_rg(rg);
        modelAluno.setDt_emissao_ctps(cpts);
        modelAluno.setDt_nascimento(nascimento);


        if (cbSexo.getSelectedItem() == "Masculino") {
            modelAluno.setSexo("M");

        } else if (cbSexo.getSelectedItem() == "Feminino") {
            modelAluno.setSexo("F");
        }

        modelAluno.setSala(cbSala.getSelectedIndex() + 1);
        modelAluno.setTurma(cbTurma.getSelectedIndex() + 1);

        modelAluno.setEmail(txEmail.getText());
        modelAluno.setEscola(txEscola.getText());
        modelAluno.setHomologacoes(taHomologacoes.getText());
        modelAluno.setLocal_nascimento(txLocalNascimento.getText());
        modelAluno.setUf_nascimento(txUfLocalNascimento.getText());
        modelAluno.setMae(txNomeMae.getText());
        modelAluno.setNome_aluno(txNome.getText());
        modelAluno.setNum_conta(txNumConta.getText());
        modelAluno.setNumero(txNumero.getText());
        modelAluno.setNumero_inscricao(txNumInscricao.getText());
        modelAluno.setPai(txNomePai.getText());
        modelAluno.setPis(txPis.getText());
        modelAluno.setRg_aluno(txRg.getText());
        modelAluno.setRg_pai(txRgPai.getText());
        modelAluno.setRg_mae(txRgMae.getText());
        modelAluno.setRgm_aluno(txRGM.getText());
        modelAluno.setFerias_empresa_num(txEmpFerias.getText());
        modelAluno.setFerias_periodo_adquirido(txPeriodoFeriasAdq.getText());
        modelAluno.setFerias_periodo_gozado(txPeriodoFeriasGoz.getText());
        if (jcbSeguro.isSelected() == true) {
            modelAluno.setSeguro(1);
        } else {
            modelAluno.setSeguro(0);
        }
        modelAluno.setSerie_uf_cpts(txSerieUf.getText());
        modelAluno.setSexo(cbSexo.getSelectedItem().toString());
        modelAluno.setTel_1(txTel1.getText());
        modelAluno.setTel_2(txTel2.getText());
        modelAluno.setTel_3(txCel1.getText());
        modelAluno.setTel_4(txCel2.getText());
        modelAluno.setTipo_residencia(txTipoResidencia.getText());
        modelAluno.setUf_nascimento(txUfLocalNascimento.getText());
        modelAluno.setValor_mensal_residencia(Float.parseFloat(txPrestImovel.getText()));
        /*
        if (controllerAluno.atualizarAlunoController(modelAluno)) {
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
            
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar o registro!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }*/
        controllerAluno.atualizarAlunoController(modelAluno);

        listaEntrevistaAlunos = controllerEntrevistaAluno.getListaEntrevistaAlunoController(modelAluno.getId());
        int cont = listaEntrevistaAlunos.size();
        DefaultTableModel modelo = (DefaultTableModel) tbEmpresaEntrevista.getModel();
        int tabela = modelo.getRowCount();

        for (int i = cont; i < tabela; i++) {
            modelEntrevistaAluno.setId_aluno(codigoAluno);
            modelEntrevistaAluno.setId_empresa(cbEmpresa.getSelectedIndex() + 1);
            modelEntrevistaAluno.setData_entrevista((String) tbEmpresaEntrevista.getValueAt(i, 1));
            modelEntrevistaAluno.setHorario_entrevista((String) tbEmpresaEntrevista.getValueAt(i, 2));
            controllerEntrevistaAluno.salvarEntrevistaAlunoController(modelEntrevistaAluno);
        }
        JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");

    }

    private void salvar() {

        modelCadEndereco = controllerCadEndereco.getCadEnderecoController(txCep.getText());
        BLDatas bl = new BLDatas();
        Date dtBaixa = null;
        Date dtEmissaoCpts = null;
        Date dtEmissaoRg = null;
        Date dtNascimento = null;
        Date dtEntrevista = null;
        try {
            if (jcdEmissaoRg.getDate() == null) {
                dtEmissaoRg = null;
            } else {
                dtEmissaoRg = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdEmissaoRg.getDate()));
            }
            if (jcdDataEmissaoCPTS.getDate() == null) {
                dtEmissaoCpts = null;
            } else {
                dtEmissaoCpts = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataEmissaoCPTS.getDate()));
            }
            if (jcdDataNascimento.getDate() == null) {
                dtNascimento = null;
            } else {
                dtNascimento = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataNascimento.getDate()));
            }


        } catch (Exception ex) {
            Logger.getLogger(ViewAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        modelAluno.setAgencia(txAgencia.getText());
        modelAluno.setAnotacoes_diversas(taAnotacoesDiversas.getText());
        if (jcbBaixa.isSelected() == true) {
            modelAluno.setBaixa(1);
        } else {
            modelAluno.setBaixa(0);
        }
        modelInserirImagem.setId_aluno(codigoAluno);

        modelAluno.setBanco(txBanco.getText());
        modelAluno.setBeneficio_social(cbBeneficioSocial.getSelectedItem().toString());
        modelAluno.setCod_endereco(modelCadEndereco.getEnd_codigo());
        modelAluno.setComplemento(txComplemento.getText());
        modelAluno.setCpf(txCpf.getText());
        modelAluno.setCtps(txCtps.getText());
        modelAluno.setSalario(Double.parseDouble(txSalario.getText()));
        modelAluno.setData_baixa(jcdDataBaixa.getDateFormatString());
        modelAluno.setPerfil(taPerfil.getText());
        modelAluno.setOrigem_aluno(cbOrigemAluno.getSelectedIndex() + 1);
        modelAluno.setCargo_aluno(cbCargo.getSelectedIndex() + 1);
        modelAluno.setFormacao_basica(cbFormacao.getSelectedIndex() + 1);
        modelAluno.setSala(cbSala.getSelectedIndex() + 1);
        modelAluno.setTurma(cbTurma.getSelectedIndex() + 1);

        modelAluno.setAnot_administrativas(taAnDivAdm.getText());
        modelAluno.setAnot_pedagogicas(taAnDivPedagogicas.getText());
        modelAluno.setAnot_psicologicas(taAnDivPsicologicas.getText());
        modelAluno.setAnot_sociais(taAnDivSociais.getText());

        Date dataAtual = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String rg = dateFormat.format(dtEmissaoRg);
        String cpts = dateFormat.format(dtEmissaoCpts);
        String nascimento = dateFormat.format(dtNascimento);

        if (cbSexo.getSelectedItem() == "Masculino") {
            modelAluno.setSexo("M");

        } else if (cbSexo.getSelectedItem() == "Feminino") {
            modelAluno.setSexo("F");
        }

        modelAluno.setDt_emissao_rg(rg);
        modelAluno.setDt_emissao_ctps(cpts);
        modelAluno.setDt_nascimento(nascimento);

        modelAluno.setEmail(txEmail.getText());
        modelAluno.setEscola(txEscola.getText());
        modelAluno.setHomologacoes(taHomologacoes.getText());
        modelAluno.setLocal_nascimento(txLocalNascimento.getText());
        modelAluno.setUf_nascimento(txUfLocalNascimento.getText());
        modelAluno.setMae(txNomeMae.getText());
        modelAluno.setNome_aluno(txNome.getText());
        modelAluno.setNum_conta(txNumConta.getText());
        modelAluno.setNumero(txNumero.getText());
        modelAluno.setNumero_inscricao(txNumInscricao.getText());
        modelAluno.setPai(txNomePai.getText());
        modelAluno.setPis(txPis.getText());
        modelAluno.setRg_aluno(txRg.getText());
        modelAluno.setRg_pai(txRgPai.getText());
        modelAluno.setRg_mae(txRgMae.getText());
        modelAluno.setRgm_aluno(txRGM.getText());
        modelAluno.setFerias_empresa_num(txEmpFerias.getText());
        modelAluno.setFerias_periodo_adquirido(txPeriodoFeriasAdq.getText());
        modelAluno.setFerias_periodo_gozado(txPeriodoFeriasGoz.getText());
        if (jcbSeguro.isSelected() == true) {
            modelAluno.setSeguro(1);
        } else {
            modelAluno.setSeguro(0);
        }
        modelAluno.setSerie_uf_cpts(txSerieUf.getText());
        modelAluno.setSexo(cbSexo.getSelectedItem().toString());
        modelAluno.setTel_1(txTel1.getText());
        modelAluno.setTel_2(txTel2.getText());
        modelAluno.setTel_3(txCel1.getText());
        modelAluno.setTel_4(txCel2.getText());
        modelAluno.setTipo_residencia(txTipoResidencia.getText());
        modelAluno.setUf_nascimento(txUfLocalNascimento.getText());
        modelAluno.setValor_mensal_residencia(Float.parseFloat(txPrestImovel.getText()));

        /*
       modelAluno.setAdmicao(jcdDataAdmicao.getDateFormatString());
        modelAluno.setApresentacao_ppi(jcdDataPPi.getDateFormatString());
        modelAluno.setDt_cadastro(jcdDataCadastro.getDateFormatString());
        modelAluno.setRecisao(jcdDataRecisao.getDateFormatString());
        modelAluno.setCarga(cbCarga.getSelectedIndex());
        modelAluno.setEmpresa(cbEmpresa_adm.getSelectedIndex());
        modelAluno.setQual_curso(cbCurso.getSelectedIndex());
        modelAluno.setQual_curso(cbCurso.getSelectedIndex());
        modelAluno.setT(cbT.getSelectedIndex());
        modelAluno.setTurma(cbT.getSelectedIndex());
        modelAluno.setDia_2((String) cbTurma.getSelectedItem());
        modelAluno.setHorario(cbHorario.getSelectedIndex());
        modelAluno.setFormacao_basica(cbFormacao.getSelectedIndex());
         */
        codigoAluno = controllerAluno.salvarAlunoController(modelAluno);
        if (codigoAluno > 0) {
            modelAluno.setId(codigoAluno);

            JOptionPane.showMessageDialog(this, "Registro salvo com sucesso!");
        }

        for (int i = 0; i < tbEmpresaEntrevista.getRowCount(); i++) {
            modelEntrevistaAluno.setId_aluno(codigoAluno);
            modelEntrevistaAluno.setId_empresa(cbEmpresa.getSelectedIndex() + 1);
            modelEntrevistaAluno.setData_entrevista((String) tbEmpresaEntrevista.getValueAt(i, 1));
            modelEntrevistaAluno.setHorario_entrevista((String) tbEmpresaEntrevista.getValueAt(i, 2));

            if (controllerEntrevistaAluno.salvarEntrevistaAlunoController(modelEntrevistaAluno) > 0) {
                JOptionPane.showMessageDialog(this, "Registro salvo com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao salvar o registro!");
            }

        }

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
            txEnderecoUF.setText(listaModelCadEndereco.get(i).getEnd_uf());

        }
    }

    private boolean salvarCepWeb() {
        modelCadEndereco.setEnd_cep(txCep.getText());
        modelCadEndereco.setEnd_logradouro(txLogradouro.getText());
        modelCadEndereco.setEnd_bairro(txBairro.getText());
        modelCadEndereco.setEnd_cidade(txMunicipio.getText());
        modelCadEndereco.setEnd_uf(txEnderecoUF.getText());

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
            txEnderecoUF.setText(webServiceCep.getUf());

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
        txNomeMae.setText("");
        txNomePai.setText("");
        txNumConta.setText("");
        txPis.setText("");
        txRGM.setText("");
        txRg.setText("");
        txRgPai.setText("");
        txRgMae.setText("");
        txSerieUf.setText("");
        txTel1.setText("");
        txTel2.setText("");
        txCep.setText("");
        lbNomeApresentacao.setText("");
        lbRGMApresentacao.setText("");
        txComplemento.setText("");
        txLogradouro.setText("");
        txBairro.setText("");
        txMunicipio.setText("");
        txEnderecoUF.setText("");
        Date date = null;
        jcdDataEmissaoCPTS.setDate(date);
        jcdDataNascimento.setDate(date);
        jcdEmissaoRg.setDate(date);
        jcdDataEntrevista.setDate(date);
        taAnotacoesDiversas.setText("");
        taHomologacoes.setText("");
        txEmpFerias.setText("");
        txPeriodoFeriasAdq.setText("");
        txPeriodoFeriasGoz.setText("");
        txEscola.setText("");
        txLocalNascimento.setText("");
        txUfLocalNascimento.setText("");
        txTipoResidencia.setText("");
        txPrestImovel.setText("");
        txNumInscricao.setText("");
        taAnDivAdm.setText("");
        taAnDivPedagogicas.setText("");
        taAnDivPsicologicas.setText("");
        taAnDivSociais.setText("");
        jcdDataBaixa.setDate(date);
        jcbBaixa.setSelected(false);
        jcbSeguro.setSelected(false);
        cbBeneficioSocial.setSelectedIndex(0);
        cbEmpresa.setSelectedIndex(0);
        cbSexo.setSelectedIndex(0);
        cbCargo.setSelectedIndex(0);
        cbOrigemAluno.setSelectedIndex(0);
        cbSituacao.setSelectedIndex(0);
        DefaultTableModel modelo = (DefaultTableModel) tbEmpresaEntrevista.getModel();
        modelo.setNumRows(0);
        lblImagem.setIcon(null);

    }

    private void habilitaCampo(boolean condicao) {
        txAgencia.setEnabled(condicao);
        taPerfil.setEnabled(condicao);
        txSalario.setEnabled(condicao);
        txBanco.setEnabled(condicao);
        txCodigo.setEnabled(condicao);
        txCpf.setEnabled(condicao);
        txCtps.setEnabled(condicao);
        txEmail.setEnabled(condicao);
        txNome.setEnabled(condicao);
        txNomeMae.setEnabled(condicao);
        txNomePai.setEnabled(condicao);
        txNumConta.setEnabled(condicao);
        txPis.setEnabled(condicao);
        txRGM.setEnabled(condicao);
        txRgMae.setEnabled(condicao);
        txRgPai.setEnabled(condicao);
        txRg.setEnabled(condicao);
        txSerieUf.setEnabled(condicao);
        txTel1.setEnabled(condicao);
        txTel2.setEnabled(condicao);
        txCel1.setEnabled(condicao);
        txCel2.setEnabled(condicao);
        jcdDataEmissaoCPTS.setEnabled(condicao);
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
        txEnderecoUF.setEnabled(condicao);
        btPesquisaCep.setEnabled(condicao);
        taAnotacoesDiversas.setEnabled(condicao);
        taHomologacoes.setEnabled(condicao);
        btIncluirEntrevista.setEnabled(condicao);
        cbEmpresa.setEnabled(condicao);
        tbEmpresaEntrevista.setEnabled(condicao);
        jcdDataEntrevista.setEnabled(condicao);
        txPeriodoFeriasAdq.setEnabled(condicao);
        txPeriodoFeriasGoz.setEnabled(condicao);
        txEmpFerias.setEnabled(condicao);
        txEscola.setEnabled(condicao);
        txLocalNascimento.setEnabled(condicao);
        txUfLocalNascimento.setEnabled(condicao);
        txTipoResidencia.setEnabled(condicao);
        txPrestImovel.setEnabled(condicao);
        txNumInscricao.setEnabled(condicao);
        jcdDataBaixa.setEnabled(condicao);
        jcbBaixa.setEnabled(condicao);
        jcbSeguro.setEnabled(condicao);
        cbBeneficioSocial.setEnabled(condicao);
        btRmover.setEnabled(condicao);
        btRemoverImagem.setEnabled(condicao);
        btFoto.setEnabled(condicao);
        cbCarga.setEnabled(condicao);
        cbCurso.setEnabled(condicao);
        cbDia2.setEnabled(condicao);
        cbEmpresa.setEnabled(condicao);
        cbEmpresa_adm.setEnabled(condicao);
        cbFormacao.setEnabled(condicao);
        cbHorario.setEnabled(condicao);
        cbLocal.setEnabled(condicao);
        cbT.setEnabled(condicao);
        cbTurma.setEnabled(condicao);
        jcdDataAdmicao.setEnabled(condicao);
        jcdDataBaixa.setEnabled(condicao);
        jcdDataCadastro.setEnabled(condicao);
        jcdDataPPi.setEnabled(condicao);
        jcdDataRecisao.setEnabled(condicao);
        cbOrigemAluno.setEnabled(condicao);
        cbSala.setEnabled(condicao);
        cbCargo.setEnabled(condicao);
        taAnDivAdm.setEnabled(condicao);
        taAnDivPedagogicas.setEnabled(condicao);
        taAnDivPsicologicas.setEnabled(condicao);
        taAnDivSociais.setEnabled(condicao);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txRg = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txNomeMae = new javax.swing.JTextField();
        txRgMae = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txNomePai = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txRgPai = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
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
        jcdDataEmissaoCPTS = new com.toedter.calendar.JDateChooser();
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
        txRGM = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jcbBaixa = new javax.swing.JCheckBox();
        jcbSeguro = new javax.swing.JCheckBox();
        cbBeneficioSocial = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jcdDataBaixa = new com.toedter.calendar.JDateChooser();
        jLabel42 = new javax.swing.JLabel();
        txEscola = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txLocalNascimento = new javax.swing.JTextField();
        txUfLocalNascimento = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txPrestImovel = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        txTipoResidencia = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
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
        txEnderecoUF = new javax.swing.JTextField();
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
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        taPerfil = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jcdDataEntrevista = new com.toedter.calendar.JDateChooser();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbEmpresaEntrevista = new javax.swing.JTable();
        btIncluirEntrevista = new javax.swing.JButton();
        btRmover = new javax.swing.JButton();
        cbEmpresa = new javax.swing.JComboBox<>();
        txHorarioEntrevista = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        btEncaminhamento = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        taAnDivAdministrativas = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taAnDivPedagogicas = new javax.swing.JTextArea();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        taAnDivSociais = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        taAnDivPsicologicas = new javax.swing.JTextArea();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        taAnDivAdm = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        taAnotacoesDiversas = new javax.swing.JTextArea();
        jLabel66 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        cbEmpresa_adm = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        cbCurso = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        cbCarga = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        cbT = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        cbDia2 = new javax.swing.JComboBox<>();
        cbHorario = new javax.swing.JComboBox<>();
        jLabel55 = new javax.swing.JLabel();
        cbLocal = new javax.swing.JComboBox<>();
        jLabel56 = new javax.swing.JLabel();
        jcdDataCadastro = new com.toedter.calendar.JDateChooser();
        jLabel57 = new javax.swing.JLabel();
        jcdDataPPi = new com.toedter.calendar.JDateChooser();
        jLabel58 = new javax.swing.JLabel();
        jcdDataAdmicao = new com.toedter.calendar.JDateChooser();
        jcdDataRecisao = new com.toedter.calendar.JDateChooser();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        txSalario = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txEmpFerias = new javax.swing.JTextField();
        txPeriodoFeriasAdq = new javax.swing.JTextField();
        txPeriodoFeriasGoz = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taHomologacoes = new javax.swing.JTextArea();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        cbSituacao = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        txNumInscricao = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        lblImagem = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btNotas = new javax.swing.JButton();
        btFaltas = new javax.swing.JButton();
        btSaida = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        cbOrigemAluno = new javax.swing.JComboBox<>();
        jLabel67 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        lbNomeApresentacao = new javax.swing.JLabel();
        lbRGMApresentacao = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        btRemoverImagem = new javax.swing.JButton();
        btFoto = new javax.swing.JButton();
        jLabel68 = new javax.swing.JLabel();
        cbCargo = new javax.swing.JComboBox<>();
        jLabel69 = new javax.swing.JLabel();
        cbFormacao = new javax.swing.JComboBox<>();
        cbTurma = new javax.swing.JComboBox<>();
        jLabel53 = new javax.swing.JLabel();
        cbSala = new javax.swing.JComboBox<>();
        jLabel61 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de alunos");

        txCodigo.setEditable(false);
        txCodigo.setFocusable(false);

        jLabel2.setText("Código");
        jLabel2.setToolTipText("");

        txNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNomeActionPerformed(evt);
            }
        });
        txNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txNomeKeyReleased(evt);
            }
        });

        jLabel3.setText("Nome");

        jLabel4.setText("RG");

        txNomeMae.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txNomeMaeKeyReleased(evt);
            }
        });

        txRgMae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txRgMaeActionPerformed(evt);
            }
        });

        jLabel5.setText("Nome da Mãe");

        jLabel6.setText("RG");

        txNomePai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txNomePaiKeyReleased(evt);
            }
        });

        jLabel7.setText("Nome do pai");

        jLabel8.setText("RG");

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

        jLabel18.setText("CTPS Nº");

        jLabel19.setText("Série/UF");

        jLabel20.setText("Data de Emissão");

        txPis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPisActionPerformed(evt);
            }
        });

        jLabel21.setText("PIS");

        txBanco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txBancoKeyReleased(evt);
            }
        });

        jLabel22.setText("Nº da Conta");

        jLabel23.setText("Agência");

        jLabel24.setText("Banco");

        jLabel9.setText("RGM");

        jcbBaixa.setText("Baixa");

        jcbSeguro.setText("Seguro");

        cbBeneficioSocial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bolsa Familia", "Renda Cidada", "BCP", "PETI" }));

        jLabel41.setText("Beneficio Social");

        jLabel42.setText("Data da baixa");

        txEscola.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txEscolaKeyReleased(evt);
            }
        });

        jLabel43.setText("Escola");

        txLocalNascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txLocalNascimentoKeyReleased(evt);
            }
        });

        txUfLocalNascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txUfLocalNascimentoKeyReleased(evt);
            }
        });

        jLabel44.setText("Local de Nascimento");

        jLabel45.setText("UF");

        txPrestImovel.setText("0");

        jLabel47.setText("Valor da prestação do imóvel");

        txTipoResidencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txTipoResidenciaKeyReleased(evt);
            }
        });

        jLabel48.setText("Tipo de residência");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel22)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel15)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txCpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                        .addComponent(txNumConta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                        .addComponent(cbBeneficioSocial, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txCtps, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                        .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txTipoResidencia))
                                    .addComponent(jLabel48))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel43)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel19)
                                                    .addGap(0, 0, Short.MAX_VALUE))
                                                .addComponent(txSerieUf))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jcdDataEmissaoCPTS, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel20))
                                            .addGap(9, 9, 9))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel23)
                                                    .addGap(147, 147, 147))
                                                .addComponent(txPrestImovel, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txEscola, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txAgencia, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel24)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel44)
                                                                .addComponent(txLocalNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel45)
                                                                .addComponent(txUfLocalNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jcdDataBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jcbBaixa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcbSeguro))
                                    .addComponent(jLabel42)
                                    .addComponent(txPis, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txNomeMae, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txNomePai))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txRgMae, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txRGM, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txRgPai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(172, 172, 172)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txRg, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcdEmissaoRg, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcdDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))))
                        .addGap(0, 66, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txRGM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txRgMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txRgPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcdEmissaoRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcdDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txCtps)
                                        .addComponent(txSerieUf))
                                    .addComponent(txPis)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcdDataEmissaoCPTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txNumConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbBaixa)
                            .addComponent(jcbSeguro))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel41)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel43)
                                        .addComponent(jLabel44)))
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcdDataBaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbBeneficioSocial)
                                .addComponent(txEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txLocalNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txUfLocalNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txPrestImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txTipoResidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        txLogradouro.setEditable(false);

        txBairro.setEditable(false);

        txMunicipio.setEditable(false);

        txEnderecoUF.setEditable(false);

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
                                            .addComponent(txEnderecoUF, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(txEnderecoUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        taPerfil.setColumns(20);
        taPerfil.setRows(5);
        jScrollPane4.setViewportView(taPerfil);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Perfil", jPanel9);

        jLabel36.setText("Empresa");

        jLabel37.setText("Data");

        tbEmpresaEntrevista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empresa", "Data", "Horário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbEmpresaEntrevista);
        if (tbEmpresaEntrevista.getColumnModel().getColumnCount() > 0) {
            tbEmpresaEntrevista.getColumnModel().getColumn(0).setResizable(false);
            tbEmpresaEntrevista.getColumnModel().getColumn(1).setResizable(false);
            tbEmpresaEntrevista.getColumnModel().getColumn(2).setResizable(false);
        }

        btIncluirEntrevista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Seta à direita Fim.png"))); // NOI18N
        btIncluirEntrevista.setText("Incluir");
        btIncluirEntrevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirEntrevistaActionPerformed(evt);
            }
        });

        btRmover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        btRmover.setText("Remover");
        btRmover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRmoverActionPerformed(evt);
            }
        });

        jLabel65.setText("Horário");

        btEncaminhamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Report.png"))); // NOI18N
        btEncaminhamento.setText("Encaminhamento");
        btEncaminhamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEncaminhamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(cbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcdDataEntrevista, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65)
                            .addComponent(txHorarioEntrevista, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btIncluirEntrevista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRmover, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btEncaminhamento)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37)
                            .addComponent(jLabel65))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcdDataEntrevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btIncluirEntrevista)
                        .addComponent(btRmover))
                    .addComponent(txHorarioEntrevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btEncaminhamento)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Entrevistas", jPanel5);

        taAnDivPedagogicas.setColumns(20);
        taAnDivPedagogicas.setRows(5);
        jScrollPane2.setViewportView(taAnDivPedagogicas);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
        );

        taAnDivAdministrativas.addTab("Pedagógicas", jPanel10);

        taAnDivSociais.setColumns(20);
        taAnDivSociais.setRows(5);
        jScrollPane5.setViewportView(taAnDivSociais);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
        );

        taAnDivAdministrativas.addTab("Sociais", jPanel11);

        taAnDivPsicologicas.setColumns(20);
        taAnDivPsicologicas.setRows(5);
        jScrollPane6.setViewportView(taAnDivPsicologicas);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
        );

        taAnDivAdministrativas.addTab("Psicológicas", jPanel12);

        taAnDivAdm.setColumns(20);
        taAnDivAdm.setRows(5);
        jScrollPane7.setViewportView(taAnDivAdm);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
        );

        taAnDivAdministrativas.addTab("Administrativas", jPanel13);

        taAnotacoesDiversas.setColumns(20);
        taAnotacoesDiversas.setRows(5);
        jScrollPane8.setViewportView(taAnotacoesDiversas);

        jLabel66.setText("Texto Livre");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(taAnDivAdministrativas)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel66)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(taAnDivAdministrativas, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Anotações Diversas", jPanel4);

        jLabel49.setText("Empresa");

        jLabel50.setText("Qual Curso");

        jLabel51.setText("Carga");

        jLabel52.setText("Tipo Cont");

        jLabel54.setText("Dia 2");

        jLabel55.setText("Horário");

        cbLocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));

        jLabel56.setText("Local");

        jLabel57.setText("Data do Cadastro");

        jLabel58.setText("Inicio PPI");

        jLabel59.setText("Admição");

        jLabel60.setText("Recisão");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel49)
                                    .addComponent(cbCurso, 0, 209, Short.MAX_VALUE)
                                    .addComponent(jLabel50)
                                    .addComponent(jLabel56)
                                    .addComponent(jLabel59))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jcdDataAdmicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(274, 274, 274)
                                .addComponent(jLabel57))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jcdDataRecisao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                        .addComponent(cbCarga, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel60)
                                    .addComponent(cbT, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel52))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbDia2, 0, 145, Short.MAX_VALUE)
                                    .addComponent(jLabel54)
                                    .addComponent(jLabel55)
                                    .addComponent(cbHorario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(cbLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(cbEmpresa_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jcdDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58)
                            .addComponent(jcdDataPPi, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(jLabel57)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel58)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jcdDataCadastro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbEmpresa_adm, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcdDataPPi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(jLabel51)
                            .addComponent(jLabel54))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56)
                            .addComponent(jLabel52))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel60)
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcdDataRecisao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcdDataAdmicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(210, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Admissão", jPanel7);

        txSalario.setText("0");

        jLabel62.setText("Salário");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62))
                .addContainerGap(723, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel62)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(348, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Salário", jPanel8);

        txPeriodoFeriasGoz.setToolTipText("");

        jLabel38.setText("Empresa Nº");

        jLabel39.setText("Período adquirido");

        jLabel40.setText("Período Gozado");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txEmpFerias, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txPeriodoFeriasAdq, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(txPeriodoFeriasGoz, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txEmpFerias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txPeriodoFeriasAdq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txPeriodoFeriasGoz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(356, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Férias", jPanel6);

        taHomologacoes.setColumns(20);
        taHomologacoes.setRows(5);
        jScrollPane1.setViewportView(taHomologacoes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Homologações", jPanel3);

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

        jLabel1.setText("Situação");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo transparente.png"))); // NOI18N

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        jLabel27.setText("Sexo");

        jLabel46.setText("Inscrição");

        lblImagem.setBackground(new java.awt.Color(204, 204, 204));
        lblImagem.setToolTipText("");
        lblImagem.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToolBar1.setRollover(true);

        btNotas.setText("Notas");
        btNotas.setFocusable(false);
        btNotas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNotas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNotasActionPerformed(evt);
            }
        });
        jToolBar1.add(btNotas);

        btFaltas.setText("Faltas");
        btFaltas.setFocusable(false);
        btFaltas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btFaltas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btFaltas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFaltasActionPerformed(evt);
            }
        });
        jToolBar1.add(btFaltas);

        btSaida.setText("Aut. Saída");
        btSaida.setFocusable(false);
        btSaida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSaida.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaidaActionPerformed(evt);
            }
        });
        jToolBar1.add(btSaida);

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Lupa.png"))); // NOI18N
        btPesquisar.setText("    ");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        jLabel67.setText("Origem do Aluno");

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel63.setText("RGM:");

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel64.setText("Nome:");

        lbNomeApresentacao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbNomeApresentacao.setForeground(new java.awt.Color(255, 0, 51));
        lbNomeApresentacao.setText("nome");

        lbRGMApresentacao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbRGMApresentacao.setForeground(new java.awt.Color(255, 0, 51));
        lbRGMApresentacao.setText("RGM");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63)
                    .addComponent(jLabel64))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNomeApresentacao)
                    .addComponent(lbRGMApresentacao))
                .addGap(0, 166, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNomeApresentacao)
                    .addComponent(jLabel64))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRGMApresentacao)
                    .addComponent(jLabel63)))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Procurar/Excluir Foto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        btRemoverImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        btRemoverImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverImagemActionPerformed(evt);
            }
        });

        btFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Lupa.png"))); // NOI18N
        btFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btFoto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btRemoverImagem)
                .addGap(49, 49, 49))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btRemoverImagem)
                    .addComponent(btFoto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel68.setText("Cargo Virtual");

        jLabel69.setText("Formação Básica");

        jLabel53.setText("Turma");

        jLabel61.setText("Sala");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 161, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btPesquisar)
                                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cbFormacao, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel46)
                                                .addComponent(txNumInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel69))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel27))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbOrigemAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel67))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel68)
                                            .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel53))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel61)
                                            .addComponent(cbSala, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txNumInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel67)
                                    .addComponent(jLabel68))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbOrigemAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel69)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbFormacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel53)
                                    .addComponent(jLabel61))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btPesquisar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btNovo)
                        .addComponent(btSalvar)
                        .addComponent(btAlterar)
                        .addComponent(btCancelar)))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txRgMaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txRgMaeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txRgMaeActionPerformed

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
        txPrestImovel.setText("0");
        txNome.requestFocusInWindow();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        if (txNomeMae.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Necessário informar o nome da mãe", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
        } else if (txCpf.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Necessário informar o CPF", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
        } else if (salvarAlterar.equals("novo")) {
            salvar();
            habilitaCampo(false);
            limpaCampos();
            salvarImagem();
            btAlterar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSalvar.setEnabled(false);
            btNovo.setEnabled(true);
            btPesquisar.setEnabled(true);
        } else if (salvarAlterar.equals("alterar")) {

            alterar();
            habilitaCampo(false);
            limpaCampos();
            salvarImagem();
            limparVariavelImagem();
            btAlterar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSalvar.setEnabled(false);
            btNovo.setEnabled(true);
            btPesquisar.setEnabled(true);

        }

    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        habilitaCampo(false);
        btAlterar.setEnabled(false);
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

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        ViewPesquisaAluno viewPesquisaAluno = new ViewPesquisaAluno(this, rootPaneCheckingEnabled);
        viewPesquisaAluno.setVisible(true);
        codigoAluno = viewPesquisaAluno.getReturnStatus();
        carregarAlunos(codigoAluno);
        limparVariavelImagem();
        // btPesquisar.setEnabled(false);
        btAlterar.setEnabled(true);
        btCancelar.setEnabled(true);
        btNovo.setEnabled(false);
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        salvarAlterar = "alterar";
        habilitaCampo(true);
        btPesquisar.setEnabled(false);
        btNovo.setEnabled(false);
        btAlterar.setEnabled(false);
        btSalvar.setEnabled(true);
        btCancelar.setEnabled(true);

    }//GEN-LAST:event_btAlterarActionPerformed

    private void btIncluirEntrevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirEntrevistaActionPerformed
        adicionaEmpresa();
    }//GEN-LAST:event_btIncluirEntrevistaActionPerformed

    private void btRmoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRmoverActionPerformed
        removeItem();
        controllerEntrevistaAluno.excluirEntrevistaAlunoController(Integer.parseInt(txCodigo.getText()));


    }//GEN-LAST:event_btRmoverActionPerformed

    private void txNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNomeKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txNome.setText(txNome.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txNome.setText(blTiraAcentos.TiraAcentos(txNome.getText()));
    }//GEN-LAST:event_txNomeKeyReleased

    private void txNomeMaeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNomeMaeKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txNomeMae.setText(txNomeMae.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txNomeMae.setText(blTiraAcentos.TiraAcentos(txNomeMae.getText()));
    }//GEN-LAST:event_txNomeMaeKeyReleased

    private void txNomePaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNomePaiKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txNomePai.setText(txNomePai.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txNomePai.setText(blTiraAcentos.TiraAcentos(txNomePai.getText()));
    }//GEN-LAST:event_txNomePaiKeyReleased

    private void txEscolaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txEscolaKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txEscola.setText(txEscola.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txEscola.setText(blTiraAcentos.TiraAcentos(txEscola.getText()));
    }//GEN-LAST:event_txEscolaKeyReleased

    private void txLocalNascimentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txLocalNascimentoKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txLocalNascimento.setText(txLocalNascimento.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txLocalNascimento.setText(blTiraAcentos.TiraAcentos(txLocalNascimento.getText()));
    }//GEN-LAST:event_txLocalNascimentoKeyReleased

    private void txUfLocalNascimentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txUfLocalNascimentoKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txUfLocalNascimento.setText(txUfLocalNascimento.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txUfLocalNascimento.setText(blTiraAcentos.TiraAcentos(txUfLocalNascimento.getText()));
    }//GEN-LAST:event_txUfLocalNascimentoKeyReleased

    private void txTipoResidenciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txTipoResidenciaKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txTipoResidencia.setText(txTipoResidencia.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txTipoResidencia.setText(blTiraAcentos.TiraAcentos(txTipoResidencia.getText()));
    }//GEN-LAST:event_txTipoResidenciaKeyReleased

    private void txBancoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txBancoKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txBanco.setText(txBanco.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txBanco.setText(blTiraAcentos.TiraAcentos(txBanco.getText()));
    }//GEN-LAST:event_txBancoKeyReleased

    private void btFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFotoActionPerformed
        selecionaImagem();
    }//GEN-LAST:event_btFotoActionPerformed

    private void btRemoverImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverImagemActionPerformed
        excluirImagem();
        lblImagem.setIcon(null);

    }//GEN-LAST:event_btRemoverImagemActionPerformed

    private void txNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNomeActionPerformed

    private void btNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNotasActionPerformed
        ViewAlunoNota viewAlunoNota = new ViewAlunoNota();
        viewAlunoNota.setVisible(true);
        viewAlunoNota.txCodigoPrincipal.setText(txCodigo.getText());
        viewAlunoNota.txDescricao.setText(txNome.getText());
        viewAlunoNota.txRgm.setText(txRGM.getText());
        viewAlunoNota.setRgmAluno(txRGM.getText());
        System.err.println("teste da tela de aluno" + viewAlunoNota.getRgmAluno());


    }//GEN-LAST:event_btNotasActionPerformed

    private void btEncaminhamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEncaminhamentoActionPerformed
        controllerAluno.gerarRelatorioEncaminhamento(Integer.parseInt(txCodigo.getText()));


    }//GEN-LAST:event_btEncaminhamentoActionPerformed

    private void btFaltasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFaltasActionPerformed
        ViewAlunoFalta viewAlunoFalta = new ViewAlunoFalta();
        viewAlunoFalta.setVisible(true);
        viewAlunoFalta.txCodigoPrincipal.setText(txCodigo.getText());
        viewAlunoFalta.txDescricao.setText(txNome.getText());
        viewAlunoFalta.txRgm.setText(txRGM.getText());
        viewAlunoFalta.setRgmAluno(txRGM.getText());
        System.err.println("teste da tela de aluno" + viewAlunoFalta.getRgmAluno());


    }//GEN-LAST:event_btFaltasActionPerformed

    private void btSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaidaActionPerformed
        controllerAluno.gerarRelatorioSaida(Integer.parseInt(txCodigo.getText()));
    }//GEN-LAST:event_btSaidaActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAluno.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAluno.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAluno.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAluno.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEncaminhamento;
    private javax.swing.JButton btFaltas;
    private javax.swing.JButton btFoto;
    private javax.swing.JButton btIncluirEntrevista;
    private javax.swing.JButton btNotas;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisaCep;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btRemoverImagem;
    private javax.swing.JButton btRmover;
    private javax.swing.JButton btSaida;
    private javax.swing.JButton btSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbBeneficioSocial;
    private javax.swing.JComboBox<String> cbCarga;
    private javax.swing.JComboBox<String> cbCargo;
    private javax.swing.JComboBox<String> cbCurso;
    private javax.swing.JComboBox<String> cbDia2;
    private javax.swing.JComboBox<String> cbEmpresa;
    private javax.swing.JComboBox<String> cbEmpresa_adm;
    private javax.swing.JComboBox<String> cbFormacao;
    private javax.swing.JComboBox<String> cbHorario;
    private javax.swing.JComboBox<String> cbLocal;
    private javax.swing.JComboBox<String> cbOrigemAluno;
    private javax.swing.JComboBox<String> cbSala;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JComboBox<String> cbSituacao;
    private javax.swing.JComboBox<String> cbT;
    private javax.swing.JComboBox<String> cbTurma;
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
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JCheckBox jcbBaixa;
    private javax.swing.JCheckBox jcbSeguro;
    private com.toedter.calendar.JDateChooser jcdDataAdmicao;
    private com.toedter.calendar.JDateChooser jcdDataBaixa;
    private com.toedter.calendar.JDateChooser jcdDataCadastro;
    private com.toedter.calendar.JDateChooser jcdDataEmissaoCPTS;
    private com.toedter.calendar.JDateChooser jcdDataEntrevista;
    private com.toedter.calendar.JDateChooser jcdDataNascimento;
    private com.toedter.calendar.JDateChooser jcdDataPPi;
    private com.toedter.calendar.JDateChooser jcdDataRecisao;
    private com.toedter.calendar.JDateChooser jcdEmissaoRg;
    private javax.swing.JLabel lbNomeApresentacao;
    private javax.swing.JLabel lbRGMApresentacao;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JTextArea taAnDivAdm;
    private javax.swing.JTabbedPane taAnDivAdministrativas;
    private javax.swing.JTextArea taAnDivPedagogicas;
    private javax.swing.JTextArea taAnDivPsicologicas;
    private javax.swing.JTextArea taAnDivSociais;
    private javax.swing.JTextArea taAnotacoesDiversas;
    private javax.swing.JTextArea taHomologacoes;
    private javax.swing.JTextArea taPerfil;
    private javax.swing.JTable tbEmpresaEntrevista;
    private javax.swing.JTextField txAgencia;
    private javax.swing.JTextField txBairro;
    private javax.swing.JTextField txBanco;
    private javax.swing.JTextField txCel1;
    private javax.swing.JTextField txCel2;
    private javax.swing.JTextField txCep;
    public javax.swing.JTextField txCodigo;
    private javax.swing.JTextField txComplemento;
    private javax.swing.JTextField txCpf;
    private javax.swing.JTextField txCtps;
    private javax.swing.JTextField txEmail;
    private javax.swing.JTextField txEmpFerias;
    private javax.swing.JTextField txEnderecoUF;
    private javax.swing.JTextField txEscola;
    private javax.swing.JTextField txHorarioEntrevista;
    private javax.swing.JTextField txLocalNascimento;
    private javax.swing.JTextField txLogradouro;
    private javax.swing.JTextField txMunicipio;
    private javax.swing.JTextField txNome;
    private javax.swing.JTextField txNomeMae;
    private javax.swing.JTextField txNomePai;
    private javax.swing.JTextField txNumConta;
    private javax.swing.JTextField txNumInscricao;
    private javax.swing.JTextField txNumero;
    private javax.swing.JTextField txPeriodoFeriasAdq;
    private javax.swing.JTextField txPeriodoFeriasGoz;
    private javax.swing.JTextField txPis;
    private javax.swing.JTextField txPrestImovel;
    private javax.swing.JTextField txRGM;
    private javax.swing.JTextField txRg;
    private javax.swing.JTextField txRgMae;
    private javax.swing.JTextField txRgPai;
    public javax.swing.JTextField txSalario;
    private javax.swing.JTextField txSerieUf;
    private javax.swing.JTextField txTel1;
    private javax.swing.JTextField txTel2;
    private javax.swing.JTextField txTipoResidencia;
    private javax.swing.JTextField txUfLocalNascimento;
    // End of variables declaration//GEN-END:variables
}
