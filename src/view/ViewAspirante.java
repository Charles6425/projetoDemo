/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.DAOInserirImagem;
//import static com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor.Uri.Enum.table;
import model.ModelCadEndereco;
import controller.ControllerCadEndereco;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelInserirImagem;
import util.ManipularImagem;
import util.WebServiceCep;
import model.ModelAluno;
import model.ModelSala;
import controller.ControllerAluno;
import controller.ControllerBucarImagem;
import controller.ControllerSala;
import controller.ControllerTurma;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelTurma;
import util.BLDatas;
import util.BLMascaras;
import util.BLTiraAcentos;
import model.ModelEmpresaVirtual;
import controller.ControllerEmpresaVirtual;
import model.ModelCargoVirtual;
import model.ModelSegFaseTurma;
import controller.ControllerCargoVirtual;
import controller.ControllerSegFaseTurma;
import controller.ControllerEmpresa;
import controller.ControllerEntrevistaAluno;
import java.awt.Dimension;
import java.awt.Toolkit;
import model.ModelBucarImagem;
import model.ModelEmpresa;
import model.ModelEntrevistaAluno;
import model.ModelDependentes;
import controller.ControllerDependentes;
import model.ModelCodigoAdms;
import model.ModelCadCBO;
import model.ModelHorario;
import controller.ControllerHorario;
import controller.ControllerCadCBO;
import controller.ControllerCodigoAdms;
import model.ModelCurso;
import controller.ControllerCurso;
import model.ModelAdmissao;
import model.ModelDiaCurso;
import controller.ControllerAdmissao;
import controller.ControllerCadastroSituacao;
import controller.ControllerDiaCurso;
import model.ModelHorasTrabalhadas;
import controller.ControllerHorasTrabalhadas;
import java.awt.Color;
import model.ModelCadastroSituacao;
import model.ModelLocalAprendizagem;
import controller.ControllerLocalAprendizagem;
import controller.ControllerPeriodo;
import model.ModelPeriodo;
import model.ModelDiasIntensivo;
import controller.ControllerDiasIntensivo;
import model.ModelIntensivo;
import model.ModelOrigemAluno;
import controller.ControllerIntensivo;
import controller.ControllerOrigemAluno;

/**
 *
 * @author charles
 */
public class ViewAspirante extends javax.swing.JFrame {

    ModelCadEndereco modelCadEndereco = new ModelCadEndereco();
    ModelIntensivo modelIntensivo = new ModelIntensivo();
    ModelDiasIntensivo modelDiasIntensivo = new ModelDiasIntensivo();
    ModelPeriodo modelPeriodo = new ModelPeriodo();
    ModelLocalAprendizagem localAprendizagem = new ModelLocalAprendizagem();
    ModelDiaCurso modelDiaCurso = new ModelDiaCurso();
    ModelHorasTrabalhadas modelHorasTrabalhadas = new ModelHorasTrabalhadas();
    ModelCurso modelCurso = new ModelCurso();
    ModelCadCBO modelCadCBO = new ModelCadCBO();
    ModelHorario modelHorario = new ModelHorario();
    ModelAluno modelAluno = new ModelAluno();
    ModelEmpresa modelEmpresa = new ModelEmpresa();
    ModelCodigoAdms modelCodigoAdms = new ModelCodigoAdms();
    ModelDependentes modelDependentes = new ModelDependentes();
    ModelEntrevistaAluno modelEntrevistaAluno = new ModelEntrevistaAluno();
    ModelSala modelSala = new ModelSala();
    ModelTurma modelTurma = new ModelTurma();
    ModelSegFaseTurma modelSegFaseTurma = new ModelSegFaseTurma();
    ModelEmpresaVirtual modelEmpresaVirtual = new ModelEmpresaVirtual();
    ModelCargoVirtual modelCargoVirtual = new ModelCargoVirtual();
    ModelBucarImagem modelBucarImagem = new ModelBucarImagem();
    ModelAdmissao modelAdmissao = new ModelAdmissao();
    ModelOrigemAluno modelOrigemAluno = new ModelOrigemAluno();
    ModelCadastroSituacao cadastroSituacao = new ModelCadastroSituacao();
    ControllerOrigemAluno controllerOrigemAluno = new ControllerOrigemAluno();
    ControllerCadastroSituacao controllerCadastroSituacao = new ControllerCadastroSituacao();
    ControllerAdmissao controllerAdmissao = new ControllerAdmissao();
    ControllerIntensivo controllerIntensivo = new ControllerIntensivo();
    ControllerPeriodo controllerPeriodo = new ControllerPeriodo();
    ControllerHorasTrabalhadas controllerHorasTrabalhadas = new ControllerHorasTrabalhadas();
    ControllerCodigoAdms controllerCodigoAdms = new ControllerCodigoAdms();
    ControllerCurso controllerCurso = new ControllerCurso();
    ControllerLocalAprendizagem controllerLocalAprendizagem = new ControllerLocalAprendizagem();
    ControllerCadCBO controllerCadCBO = new ControllerCadCBO();
    ControllerHorario controllerHorario = new ControllerHorario();
    ControllerBucarImagem controllerBucarImagem = new ControllerBucarImagem();
    ControllerDependentes controllerDependentes = new ControllerDependentes();
    ControllerDiasIntensivo controllerDiasIntensivo = new ControllerDiasIntensivo();
    ControllerDiaCurso controllerDiaCurso = new ControllerDiaCurso();
    ControllerEmpresaVirtual controllerEmpresaVirtual = new ControllerEmpresaVirtual();
    ControllerCargoVirtual controllerCargoVirtual = new ControllerCargoVirtual();
    ControllerAluno controllerAluno = new ControllerAluno();
    ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
    ControllerEntrevistaAluno controllerEntrevistaAluno = new ControllerEntrevistaAluno();
    ControllerSala controllerSala = new ControllerSala();
    ControllerTurma controllerTurma = new ControllerTurma();
    ControllerSegFaseTurma controllerSegFaseTurma = new ControllerSegFaseTurma();
    ControllerCadEndereco controllerCadEndereco = new ControllerCadEndereco();
    ArrayList<ModelCadEndereco> listaModelCadEndereco = new ArrayList<>();
    ArrayList<ModelAluno> listaModelAlunos = new ArrayList<>();
    ArrayList<ModelEmpresa> listaModelEmpresas = new ArrayList<>();
    ArrayList<ModelEntrevistaAluno> listaModelEntrevistaAlunos = new ArrayList<>();
    ArrayList<ModelSala> listaModelSalas = new ArrayList<>();
    ArrayList<ModelTurma> listaModelTurmas = new ArrayList<>();
    ArrayList<ModelEmpresaVirtual> listaEmpresaVirtuals = new ArrayList<>();
    ArrayList<ModelCargoVirtual> listaCargoVirtuals = new ArrayList<>();
    ArrayList<ModelSegFaseTurma> listaSegFaseTurmas = new ArrayList<>();
    ArrayList<ModelCodigoAdms> listaModelCodigoAdmses = new ArrayList<>();
    ArrayList<ModelCadCBO> listaModelCadCBOs = new ArrayList<>();
    ArrayList<ModelHorario> listaModelHorarios = new ArrayList<>();
    ArrayList<ModelCurso> listaModelCursos = new ArrayList<>();
    ArrayList<ModelAdmissao> listaModelAdmissaos = new ArrayList<>();
    ArrayList<ModelDiaCurso> listaModelDiaCursos = new ArrayList<>();
    ArrayList<ModelHorasTrabalhadas> listaHorasTrabalhadases = new ArrayList<>();
    ArrayList<ModelCadastroSituacao> listaCadastroSituacaos = new ArrayList<>();
    ArrayList<ModelLocalAprendizagem> listaAprendizagems = new ArrayList<>();
    ArrayList<ModelPeriodo> listaPeriodos = new ArrayList<>();
    ArrayList<ModelDiasIntensivo> listaDiasIntensivos = new ArrayList<>();
    ArrayList<ModelIntensivo> listaModelIntensivos = new ArrayList<>();
    ArrayList<ModelDependentes> listaModelDependentes = new ArrayList<>();
    ArrayList<ModelOrigemAluno> listaModelOrigemAlunos = new ArrayList<>();
    BufferedImage imagem;
    String salvarAlterar;
    public int codigoAluno;

    /**
     * Creates new form ViewAspirante
     */
    public ViewAspirante() {
        initComponents();

        limpaCampos();
        habilitaCampo(false);
        preencherSala();
        preencherTurma();
        preencherCbEmpresa();
        preencherCbEmpresaAdmissao();
        preencherEmpresaVirtual();
        preencherCargoVirtual();
        btAlterar.setEnabled(false);
        btCancelar.setEnabled(false);
        btSalvar.setEnabled(false);
        btNovo.setEnabled(true);
        btPesquisar.setEnabled(true);
        lbNomeApresentacao.setText("");
        //ajustaTela();
        setLocationRelativeTo(null);
        preencherTipoAms();
        preencherCBO();
        preencherHorario();
        preencherCurso();
        preencherCargaHoraria();
        preencherDiaCurso();
        calculaSalario();
        preencherSituacao();
        preencherLocalAprend();
        preencherPeriodo();
        preencherDiasIntensivo();
        preencherCargaHorariaTotal();
        preencherCbIntensivo();
        preencherCbOrigeAluno();
        jcb2Fase.setVisible(false);

    }

    private void ajustaTela() {
        Toolkit kit = Toolkit.getDefaultToolkit();

        Dimension tamTela = kit.getScreenSize();
        int resTela = kit.getScreenResolution();

//Pegando a largura total da tela
        int larg = tamTela.width;

//Pegando a altura total da tela
        int alt = tamTela.height;

        /*Se você quiser que o seu JFrame ocupe 70% da tela por exemplo 
multiplique a largura e altura totais por 0,7*/
        int minhaLargura = (int) (larg * 0.7);
        int minhaAltura = (int) (alt * 0.95);

//Mandando o JFrame utilizar suas dimensões
        setSize(minhaLargura, minhaAltura);
    }

    private void ajustaTela2() {

    }

    private void calculaMedia1() {
        Float soma;
        soma = Float.parseFloat(txPort1.getText()) + Float.parseFloat(txMat1.getText())
                + Float.parseFloat(txRed1.getText()) + Float.parseFloat(txInf1.getText());
        txMedia1.setText(String.valueOf(soma / 4));
    }

    private void calculaMedia2() {
        Float soma1, soma2;
        soma1 = Float.parseFloat(txPort2.getText()) + Float.parseFloat(txMat2.getText())
                + Float.parseFloat(txRed2.getText()) + Float.parseFloat(txInf2.getText());
        soma2 = Float.parseFloat(txAtit2.getText());

        txMedia2.setText(String.valueOf((soma1 + soma2) / 5));
    }

    private void calculaMedia3() {
        Float soma1, soma2;
        soma1 = Float.parseFloat(txPort3.getText()) + Float.parseFloat(txMat3.getText())
                + Float.parseFloat(txRed3.getText()) + Float.parseFloat(txInf3.getText());
        soma2 = Float.parseFloat(txAtit3.getText());

        txMedia3.setText(String.valueOf((soma1 + soma2) / 5));
    }

    private void calculaMedia4() {
        Float soma1, soma2;
        soma1 = Float.parseFloat(txPort4.getText()) + Float.parseFloat(txMat4.getText())
                + Float.parseFloat(txRed4.getText()) + Float.parseFloat(txInf5.getText());
        soma2 = Float.parseFloat(txAtit5.getText());

        txMedia4.setText(String.valueOf((soma1 + soma2) / 5));
    }

    private void calculaMedia5() {
        Float soma1, soma2;
        soma1 = Float.parseFloat(txPort5.getText()) + Float.parseFloat(txMat5.getText())
                + Float.parseFloat(txRed5.getText()) + Float.parseFloat(txInf5.getText());
        soma2 = Float.parseFloat(txAtit5.getText());

        txMedia5.setText(String.valueOf((soma1 + soma2) / 5));
    }

    private void salvarAdmissao() {
        BLDatas bl = new BLDatas();
        Date dtInicio = null;
        Date dtTermino = null;
        try {
            dtInicio = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataAdmissao.getDate()));
            dtTermino = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataRescisao.getDate()));
        } catch (Exception ex) {
            Logger.getLogger(ViewAspirante.class.getName()).log(Level.SEVERE, null, ex);
        }

        modelAdmissao.setEmpresa(cbEmpAdmissao.getSelectedIndex() + 1);
        modelAdmissao.setAprendiz(Integer.parseInt(txCodigo.getText()));
        modelAdmissao.setHorario((String) cbHorario.getSelectedItem());
        modelAdmissao.setTipo_admissao(cbTipoAdimissao.getSelectedIndex() + 1);
        modelAdmissao.setSalario(Float.parseFloat(txSalario.getText()));
        modelAdmissao.setCbo(cbCBO.getSelectedIndex() + 1);
        modelAdmissao.setCurso(cbDiaCurso.getSelectedIndex() + 1);
        modelAdmissao.setInsalubre_percentual(Float.parseFloat(txPerctInsalubridade.getText()));

        if (jcbConvenioOdontologico.isSelected()) {
            modelAdmissao.setConvenio_odont(1);

        } else {
            modelAdmissao.setConvenio_odont(0);
        }

        if (jcbInsalubre.isSelected()) {
            modelAdmissao.setInsalubre(1);

        } else {
            modelAdmissao.setInsalubre(0);
        }
        if (jcbVt.isSelected()) {
            modelAdmissao.setDesconto_vt(1);

        } else {
            modelAdmissao.setDesconto_vt(0);
        }

        Date dataAtual = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String inicio = dateFormat.format(dtInicio);
        modelAdmissao.setInicio(inicio);
        String termino = dateFormat.format(dtTermino);
        modelAdmissao.setTermino(termino);

        if (controllerAdmissao.salvarAdmissaoController(modelAdmissao) > 0) {
            JOptionPane.showMessageDialog(this, "Registro salvo com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao salvar o registro!");
        }

    }

    private void alterarAdmissao() {
        BLDatas bl = new BLDatas();
        Date dtInicio = null;
        Date dtTermino = null;
        try {
            dtInicio = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataAdmissao.getDate()));
            dtTermino = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataRescisao.getDate()));
        } catch (Exception ex) {
            Logger.getLogger(ViewAspirante.class.getName()).log(Level.SEVERE, null, ex);
        }

        modelAdmissao.setEmpresa(cbEmpAdmissao.getSelectedIndex() + 1);
        modelAdmissao.setAprendiz(Integer.parseInt(txCodigo.getText()));
        modelAdmissao.setHorario((String) cbHorario.getSelectedItem());
        modelAdmissao.setTipo_admissao(cbTipoAdimissao.getSelectedIndex() + 1);
        modelAdmissao.setSalario(Float.parseFloat(txSalario.getText()));
        modelAdmissao.setCbo(cbCBO.getSelectedIndex() + 1);
        modelAdmissao.setCurso(cbDiaCurso.getSelectedIndex() + 1);
        modelAdmissao.setInsalubre_percentual(Float.parseFloat(txPerctInsalubridade.getText()));

        if (jcbConvenioOdontologico.isSelected()) {
            modelAdmissao.setConvenio_odont(1);

        } else {
            modelAdmissao.setConvenio_odont(0);
        }

        if (jcbInsalubre.isSelected()) {
            modelAdmissao.setInsalubre(1);

        } else {
            modelAdmissao.setInsalubre(0);
        }
        if (jcbVt.isSelected()) {
            modelAdmissao.setDesconto_vt(1);

        } else {
            modelAdmissao.setDesconto_vt(0);
        }

        Date dataAtual = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String inicio = dateFormat.format(dtInicio);
        modelAdmissao.setInicio(inicio);
        String termino = dateFormat.format(dtTermino);
        modelAdmissao.setTermino(termino);

        if (controllerAdmissao.atualizarAdmissaoController(modelAdmissao)) {
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterado o registro!");
        }

    }

    private void salvar() {
        modelCadEndereco = controllerCadEndereco.getCadEnderecoController(txCep.getText());
        BLDatas bl = new BLDatas();
        Date dtBaixa = null;
        Date dtEmissaoCpts = null;
        Date dtEmissaoPIS = null;
        Date dtEmissaoRg = null;
        Date dtNascimento = null;
        Date dtInclusao = null;
        Date dtTerminoContrato = null;
        Date dtTerminoCurso = null;
        Date dtAdmissao = null;
        Date dtRescisao = null;

        try {
            if (jcdEmissaoRg.getDate() == null) {
                dtEmissaoRg = null;
            } else {
                dtEmissaoRg = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdEmissaoRg.getDate()));
            }

            if (jcdDataAdmissao.getDate() == null) {
                dtAdmissao = null;
            } else {
                dtAdmissao = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataAdmissao.getDate()));
            }
            if (jcdDataRescisao.getDate() == null) {
                dtRescisao = null;
            } else {
                dtRescisao = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataRescisao.getDate()));
            }

            if (jcdDataEmissaoCTPS.getDate() == null) {
                dtEmissaoCpts = null;
            } else {
                dtEmissaoCpts = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataEmissaoCTPS.getDate()));
            }
            /*   if (jcdDataEmissaoPIS.getDate() == null) {
                dtEmissaoPIS = null;
            } else {
                dtEmissaoPIS = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataEmissaoPIS.getDate()));
            }*/
            if (jcdDataNascimento.getDate() == null) {
                dtNascimento = null;
            } else {
                dtNascimento = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataNascimento.getDate()));
            }
            if (jcdBaixa.getDate() == null) {
                dtBaixa = null;
            } else {
                dtBaixa = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdBaixa.getDate()));
            }
            if (jcdDataInclusao.getDate() == null) {
                dtInclusao = null;
            } else {
                dtInclusao = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataInclusao.getDate()));
            }
            if (jcdTerminoContrato.getDate() == null) {
                dtTerminoContrato = null;
            } else {
                dtTerminoContrato = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdTerminoContrato.getDate()));
            }

        } catch (Exception ex) {
            Logger.getLogger(ViewAluno.class.getName()).log(Level.SEVERE, null, ex);
        }

        modelAluno.setNome_aluno(txNome.getText());
        modelAluno.setRgm_aluno(txRGM.getText());
        modelAluno.setReservista(txRa.getText());
        modelAluno.setSexo(cbSexo.getSelectedItem().toString());
        modelAluno.setCod_endereco(modelCadEndereco.getEnd_codigo());
        modelAluno.setComplemento(txComplemento.getText());
        modelAluno.setEmpresa(cbEmpAdmissao.getSelectedIndex() + 1);
        modelAluno.setNumero(txNumero.getText());
        modelAluno.setCpf(txCpf.getText());
        modelAluno.setCamiseta(txCamiseta.getText());
        modelAluno.setSala(cbSalas.getSelectedIndex() + 1);
        modelAluno.setTurma(cbTurma.getSelectedIndex() + 1);
        modelAluno.setCargo_virtual(cbCargoVirtual.getSelectedIndex() + 1);
        modelAluno.setEmpresa_virtual(cbEmpresaVirtual.getSelectedIndex() + 1);
        modelAluno.setCtps(txCtps.getText());
        modelAluno.setSerie_uf_cpts(txSerieUfCtps.getText());
        modelAluno.setPort1(Float.parseFloat(txPort1.getText()));
        modelAluno.setPort2(Float.parseFloat(txPort2.getText()));
        modelAluno.setPort3(Float.parseFloat(txPort3.getText()));
        modelAluno.setPort4(Float.parseFloat(txPort4.getText()));
        modelAluno.setPort5(Float.parseFloat(txPort5.getText()));
        modelAluno.setMat1(Float.parseFloat(txMat1.getText()));
        modelAluno.setMat2(Float.parseFloat(txMat2.getText()));
        modelAluno.setMat3(Float.parseFloat(txMat3.getText()));
        modelAluno.setMat4(Float.parseFloat(txMat4.getText()));
        modelAluno.setMat5(Float.parseFloat(txMat5.getText()));
        modelAluno.setRed1(Float.parseFloat(txRed1.getText()));
        modelAluno.setRed2(Float.parseFloat(txRed2.getText()));
        modelAluno.setRed3(Float.parseFloat(txRed3.getText()));
        modelAluno.setRed4(Float.parseFloat(txRed4.getText()));
        modelAluno.setRed5(Float.parseFloat(txRed5.getText()));
        modelAluno.setInf1(Float.parseFloat(txInf1.getText()));
        modelAluno.setInf2(Float.parseFloat(txInf2.getText()));
        modelAluno.setInf3(Float.parseFloat(txInf3.getText()));
        modelAluno.setInf4(Float.parseFloat(txInf4.getText()));
        modelAluno.setInf5(Float.parseFloat(txInf5.getText()));
        modelAluno.setMd1(Float.parseFloat(txMedia1.getText()));
        modelAluno.setMd2(Float.parseFloat(txMedia2.getText()));
        modelAluno.setMd3(Float.parseFloat(txMedia3.getText()));
        modelAluno.setMd4(Float.parseFloat(txMedia4.getText()));
        modelAluno.setMd5(Float.parseFloat(txMedia5.getText()));
        modelAluno.setCarga_horaria_total((String) cbCargaHoraria.getSelectedItem());
        modelAluno.setPeriodo(cbPeriodo.getSelectedIndex() + 1);
        modelAluno.setHoras_trabalhadas(cbHorasTrabalhadas.getSelectedIndex() + 1);
        modelAluno.setPendente_intensivo(txPendenteIntensivo.getText());
        modelAluno.setInt_per1(txIntensPeriodo1.getText());
        modelAluno.setInt_per2(txIntensPeriodo2.getText());
        modelAluno.setInt_per3(txIntensPeriodo3.getText());
        modelAluno.setIntensivo(cbCursoIntensivo.getSelectedIndex() + 1);
        modelAluno.setOrigem_aluno(cbOrigemAluno.getSelectedIndex() + 1);

        modelAluno.setAtitudes2(Float.parseFloat(txAtit2.getText()));
        modelAluno.setAtitudes3(Float.parseFloat(txAtit3.getText()));
        modelAluno.setAtitudes4(Float.parseFloat(txAtit4.getText()));
        modelAluno.setAtitudes5(Float.parseFloat(txAtit5.getText()));
        modelAluno.setAltura(Float.parseFloat(txAltura.getText()));
        modelAluno.setEscola(txEscola.getText());
        modelAluno.setObservacao(taObservacao.getText());
        modelAluno.setCbo(cbCBO.getSelectedIndex() + 1);
        modelAluno.setDiaCurso((String) cbDiaCurso.getSelectedItem());
        modelAluno.setCurso(cbQualCurso.getSelectedIndex() + 1);
        modelAluno.setHorario(cbHorario.getSelectedIndex() + 1);
        modelAluno.setTipo_admissao(cbTipoAdimissao.getSelectedIndex() + 1);
        modelAluno.setInsalubre(Float.parseFloat(txPerctInsalubridade.getText()));
        modelAluno.setSalario(Double.parseDouble(txSalario.getText()));
        modelAluno.setCor(txCor.getText());
        modelAluno.setCabelos(txCabelos.getText());
        modelAluno.setOlhos(txOlhos.getText());
        modelAluno.setSinais(txSinais.getText());
        modelAluno.setPis(txPis.getText());
        modelAluno.setPeso(Float.parseFloat(txPeso.getText()));
        modelAluno.setEstado_civil((String) cbEstCivil1.getSelectedItem());
        modelAluno.setNacionalidade(txNacionalidade.getText());
        modelAluno.setNota_cargo_virtual(Float.parseFloat(txNotaCargoVirt.getText()));

        modelAluno.setStatus((String) cbStatus.getSelectedItem());

        modelAluno.setLocal_aprendizagem(cbLocalAprendizagem.getSelectedIndex() + 1);
        modelAluno.setInt_per1(txIntensPeriodo1.getText());
        modelAluno.setInt_per2(txIntensPeriodo2.getText());
        modelAluno.setInt_per3(txIntensPeriodo3.getText());
        modelAluno.setDias_intensivo(cbDiasIntensivo.getSelectedIndex() + 1);
        modelAluno.setPendente_intensivo(txPendenteIntensivo.getText());
        modelAluno.setVoto_consciente(txVotoConsciente.getText());

        if (jcbConvenioOdontologico.isSelected()) {
            modelAluno.setConvenio_odont(1);
        } else {
            modelAluno.setConvenio_odont(0);
        }
        if (jcbInsalubre.isSelected()) {
            modelAluno.setInsalubre_sn(1);
        } else {
            modelAluno.setInsalubre_sn(0);
        }
        if (jcbVt.isSelected()) {
            modelAluno.setVt(1);
        } else {
            modelAluno.setVt(0);
        }
        modelAluno.setAnot_administrativas(taAdministrativa.getText());
        modelAluno.setAnot_pedagogicas(taPedagogicas.getText());
        modelAluno.setAnot_psicologicas(taPsicologicas.getText());
        modelAluno.setAnot_sociais(taSociais.getText());
        modelAluno.setBanco(txBanco.getText());
        modelAluno.setNum_conta(txNumeroConta.getText());
        modelAluno.setAgencia(txAgencia.getText());
        modelAluno.setEmail(txEmail.getText());
        modelAluno.setResponsavel(txResponsavel.getText());
        modelAluno.setMae(txNomeMae.getText());
        modelAluno.setPai(txNomePai.getText());
        modelAluno.setRg_mae(txRgMae.getText());
        modelAluno.setPis(txPis.getText());
        modelAluno.setRg_pai(txRgPai.getText());
        modelAluno.setTel_1(txTel1.getText());
        modelAluno.setTel_2(txTel2.getText());
        modelAluno.setTel_3(txTel3.getText());
        modelAluno.setTel_4(txTel4.getText());
        modelAluno.setRg_aluno(txRg.getText());
        modelAluno.setLocal_nascimento(txLocalNascimento.getText());
        modelAluno.setUf_nascimento(txUfLocalNascimento.getText());
        modelAluno.setSituacao((String) cbSituacao.getSelectedItem());
        modelAluno.setDiaAtivTeorica(cbDiaAtivTeorica.getSelectedIndex() + 1);

        if (jcb2Fase.isSelected()) {
            modelAluno.setSegunda_fase_confirma(1);

        } else {
            modelAluno.setSegunda_fase_confirma(0);
        }
        if (jcbCadIrregular.isSelected()) {
            modelAluno.setCadastro_irregular(1);

        } else {
            modelAluno.setCadastro_irregular(0);
        }

        Date dataAtual = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if (jcdBaixa.getDate() == null) {

        } else {
            String baixa = dateFormat.format(dtBaixa);
            modelAluno.setData_baixa(baixa);
        }
        if (jcdDataEmissaoCTPS.getDate() == null) {

        } else {
            String cpts = dateFormat.format(dtEmissaoCpts);
            modelAluno.setDt_emissao_ctps(cpts);
        }
        /*        if (jcdDataEmissaoPIS.getDate() == null) {

        } else {
            String pis = dateFormat.format(dtEmissaoPIS);
            modelAluno.setDt_emissao_pis(pis);
        }*/
        if (jcdEmissaoRg.getDate() == null) {

        } else {
            String rg = dateFormat.format(dtEmissaoRg);
            modelAluno.setDt_emissao_rg(rg);
        }
        if (jcdDataInclusao.getDate() == null) {

        } else {
            String inclusao = dateFormat.format(dtInclusao);
            modelAluno.setDt_Inclusao(inclusao);
        }
        if (jcdDataRescisao.getDate() == null) {

        } else {
            String terminoContrato = dateFormat.format(dtTerminoContrato);
            modelAluno.setDt_TerminoContrato(terminoContrato);
        }
        if (jcdDataNascimento.getDate() == null) {

        } else {
            String nascimento = dateFormat.format(dtNascimento);
            modelAluno.setDt_nascimento(nascimento);
        }
        if (jcdDataAdmissao.getDate() == null) {

        } else {
            String admissao = dateFormat.format(dtAdmissao);
            modelAluno.setDt_admissao(admissao);
        }
        if (jcdDataRescisao.getDate() == null) {

        } else {
            String rescisao = dateFormat.format(dtRescisao);
            modelAluno.setDt_rescisao(rescisao);
        }

        codigoAluno = controllerAluno.salvarGeralController(modelAluno);
        if (codigoAluno > 0) {
            modelAluno.setId(codigoAluno);

            JOptionPane.showMessageDialog(this, "Registro salvo com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao salvar o registro!");
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
        for (int j = 0; j < tbDependente.getRowCount(); j++) {
            modelDependentes.setId_asp(codigoAluno);
            modelDependentes.setNome((String) tbDependente.getValueAt(j, 0));
            modelDependentes.setIdade(Integer.parseInt((String) tbDependente.getValueAt(j, 1)));
            modelDependentes.setSexo((String) tbDependente.getValueAt(j, 2));

            controllerDependentes.salvarDependentesController(modelDependentes);

        }

    }

    private void alterar() {
        modelCadEndereco = controllerCadEndereco.getCadEnderecoController(txCep.getText());
        BLDatas bl = new BLDatas();
        Date dtBaixa = null;
        Date dtEmissaoCpts = null;
        Date dtEmissaoPIS = null;
        Date dtEmissaoRg = null;
        Date dtNascimento = null;
        Date dtInclusao = null;
        Date dtTerminoContrato = null;
        Date dtAdmissao = null;
        Date dtRescisao = null;

        try {
            if (jcdEmissaoRg.getDate() == null) {
                dtEmissaoRg = null;
            } else {
                dtEmissaoRg = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdEmissaoRg.getDate()));
            }
            /* if (jcdDataEmissaoPIS.getDate() == null) {
                dtEmissaoPIS = null;
            } else {
                dtEmissaoPIS = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataEmissaoPIS.getDate()));
            }*/
            if (jcdDataAdmissao.getDate() == null) {
                dtAdmissao = null;
            } else {
                dtAdmissao = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataAdmissao.getDate()));
            }
            if (jcdDataRescisao.getDate() == null) {
                dtRescisao = null;
            } else {
                dtRescisao = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataRescisao.getDate()));
            }

            if (jcdDataEmissaoCTPS.getDate() == null) {
                dtEmissaoCpts = null;
            } else {
                dtEmissaoCpts = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataEmissaoCTPS.getDate()));
            }
            if (jcdDataNascimento.getDate() == null) {
                dtNascimento = null;
            } else {
                dtNascimento = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataNascimento.getDate()));
            }
            if (jcdBaixa.getDate() == null) {
                dtBaixa = null;
            } else {
                dtBaixa = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdBaixa.getDate()));
            }
            if (jcdDataInclusao.getDate() == null) {
                dtInclusao = null;
            } else {
                dtInclusao = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdDataInclusao.getDate()));
            }
            if (jcdTerminoContrato.getDate() == null) {
                dtTerminoContrato = null;
            } else {
                dtTerminoContrato = bl.converterDataParaDateUS(bl.converterDataParaDateUS(jcdTerminoContrato.getDate()));
            }

        } catch (Exception ex) {
            Logger.getLogger(ViewAluno.class.getName()).log(Level.SEVERE, null, ex);
        }

        modelAluno.setNome_aluno(txNome.getText());
        modelAluno.setId(Integer.parseInt(txCodigo.getText()));
        modelAluno.setRgm_aluno(txRGM.getText());
        modelAluno.setReservista(txRa.getText());
        modelAluno.setSexo(cbSexo.getSelectedItem().toString());
        modelAluno.setCod_endereco(modelCadEndereco.getEnd_codigo());
        modelAluno.setComplemento(txComplemento.getText());
        modelAluno.setNumero(txNumero.getText());
        modelAluno.setCpf(txCpf.getText());
        modelAluno.setCamiseta(txCamiseta.getText());
        modelAluno.setSala(cbSalas.getSelectedIndex() + 1);
        modelAluno.setTurma(cbTurma.getSelectedIndex() + 1);
        modelAluno.setCtps(txCtps.getText());
        modelAluno.setSerie_uf_cpts(txSerieUfCtps.getText());
        modelAluno.setPort1(Float.parseFloat(txPort1.getText()));
        modelAluno.setPort2(Float.parseFloat(txPort2.getText()));
        modelAluno.setPort3(Float.parseFloat(txPort3.getText()));
        modelAluno.setPort4(Float.parseFloat(txPort4.getText()));
        modelAluno.setPort5(Float.parseFloat(txPort5.getText()));
        modelAluno.setMat1(Float.parseFloat(txMat1.getText()));
        modelAluno.setMat2(Float.parseFloat(txMat2.getText()));
        modelAluno.setMat3(Float.parseFloat(txMat3.getText()));
        modelAluno.setMat4(Float.parseFloat(txMat4.getText()));
        modelAluno.setMat5(Float.parseFloat(txMat5.getText()));
        modelAluno.setRed1(Float.parseFloat(txRed1.getText()));
        modelAluno.setRed2(Float.parseFloat(txRed2.getText()));
        modelAluno.setRed3(Float.parseFloat(txRed3.getText()));
        modelAluno.setRed4(Float.parseFloat(txRed4.getText()));
        modelAluno.setRed5(Float.parseFloat(txRed5.getText()));
        modelAluno.setInf1(Float.parseFloat(txInf1.getText()));
        modelAluno.setInf2(Float.parseFloat(txInf2.getText()));
        modelAluno.setInf3(Float.parseFloat(txInf3.getText()));
        modelAluno.setInf4(Float.parseFloat(txInf4.getText()));
        modelAluno.setInf5(Float.parseFloat(txInf5.getText()));
        modelAluno.setMd1(Float.parseFloat(txMedia1.getText()));
        modelAluno.setMd2(Float.parseFloat(txMedia2.getText()));
        modelAluno.setMd3(Float.parseFloat(txMedia3.getText()));
        modelAluno.setMd4(Float.parseFloat(txMedia4.getText()));
        modelAluno.setMd5(Float.parseFloat(txMedia5.getText()));
        modelAluno.setCarga_horaria_total((String) cbCargaHoraria.getSelectedItem());
        modelAluno.setBanco(txBanco.getText());
        modelAluno.setNum_conta(txNumeroConta.getText());
        modelAluno.setPeriodo(cbPeriodo.getSelectedIndex() + 1);
        modelAluno.setHoras_trabalhadas(cbHorasTrabalhadas.getSelectedIndex() + 1);
        modelAluno.setPendente_intensivo(txPendenteIntensivo.getText());
        modelAluno.setInt_per1(txIntensPeriodo1.getText());
        modelAluno.setInt_per2(txIntensPeriodo2.getText());
        modelAluno.setInt_per3(txIntensPeriodo3.getText());
        modelAluno.setIntensivo(cbCursoIntensivo.getSelectedIndex() + 1);
        modelAluno.setNota_cargo_virtual(Float.parseFloat(txNotaCargoVirt.getText()));
        modelAluno.setOrigem_aluno(cbOrigemAluno.getSelectedIndex() + 1);
        modelAluno.setAgencia(txAgencia.getText());
        modelAluno.setAtitudes2(Float.parseFloat(txAtit2.getText()));
        modelAluno.setAtitudes3(Float.parseFloat(txAtit3.getText()));
        modelAluno.setAtitudes4(Float.parseFloat(txAtit4.getText()));
        modelAluno.setAtitudes5(Float.parseFloat(txAtit5.getText()));
        modelAluno.setCargo_virtual(cbCargoVirtual.getSelectedIndex() + 1);
        modelAluno.setEmpresa_virtual(cbEmpresaVirtual.getSelectedIndex() + 1);
        modelAluno.setAltura(Float.parseFloat(txAltura.getText()));
        modelAluno.setEscola(txEscola.getText());
        modelAluno.setSalario(Double.parseDouble(txSalario.getText()));
        modelAluno.setCor(txCor.getText());
        modelAluno.setCabelos(txCabelos.getText());
        modelAluno.setOlhos(txOlhos.getText());
        modelAluno.setSinais(txSinais.getText());
        modelAluno.setPis(txPis.getText());
        modelAluno.setPeso(Float.parseFloat(txPeso.getText()));
        modelAluno.setEstado_civil((String) cbEstCivil1.getSelectedItem());
        modelAluno.setSituacao((String) cbSituacao.getSelectedItem());
        modelAluno.setNacionalidade(txNacionalidade.getText());
        modelAluno.setStatus((String) cbStatus.getSelectedItem());
        modelAluno.setEmpresa(cbEmpAdmissao.getSelectedIndex() + 1);
        modelAluno.setLocal_aprendizagem(cbLocalAprendizagem.getSelectedIndex() + 1);
        modelAluno.setInt_per1(txIntensPeriodo1.getText());
        modelAluno.setInt_per2(txIntensPeriodo2.getText());
        modelAluno.setInt_per3(txIntensPeriodo3.getText());
        modelAluno.setDias_intensivo(cbDiasIntensivo.getSelectedIndex() + 1);
        modelAluno.setPendente_intensivo(txPendenteIntensivo.getText());
        modelAluno.setVoto_consciente(txVotoConsciente.getText());
        modelAluno.setDiaAtivTeorica(cbDiaAtivTeorica.getSelectedIndex() + 1);
        modelAluno.setCurso(cbQualCurso.getSelectedIndex() + 1);
        modelAluno.setDiaCurso((String) cbDiaCurso.getSelectedItem());
        modelAluno.setHorario(cbHorario.getSelectedIndex() + 1);

        modelAluno.setCbo(cbCBO.getSelectedIndex() + 1);
        modelAluno.setTipo_admissao(cbTipoAdimissao.getSelectedIndex() + 1);
        modelAluno.setInsalubre(Float.parseFloat(txPerctInsalubridade.getText()));

        if (jcbConvenioOdontologico.isSelected()) {
            modelAluno.setConvenio_odont(1);
        } else {
            modelAluno.setConvenio_odont(0);
        }
        if (jcbInsalubre.isSelected()) {
            modelAluno.setInsalubre_sn(1);
        } else {
            modelAluno.setInsalubre_sn(0);
        }
        if (jcbVt.isSelected()) {
            modelAluno.setVt(1);
        } else {
            modelAluno.setVt(0);
        }

        modelAluno.setAnot_administrativas(taAdministrativa.getText());
        modelAluno.setAnot_pedagogicas(taPedagogicas.getText());
        modelAluno.setAnot_psicologicas(taPsicologicas.getText());
        modelAluno.setAnot_sociais(taSociais.getText());
        modelAluno.setObservacao(taObservacao.getText());
        modelAluno.setEmail(txEmail.getText());
        modelAluno.setResponsavel(txResponsavel.getText());
        modelAluno.setMae(txNomeMae.getText());
        modelAluno.setPai(txNomePai.getText());
        modelAluno.setRg_mae(txRgMae.getText());
        modelAluno.setRg_pai(txRgPai.getText());
        modelAluno.setTel_1(txTel1.getText());
        modelAluno.setTel_2(txTel2.getText());
        modelAluno.setTel_3(txTel3.getText());
        modelAluno.setTel_4(txTel4.getText());
        modelAluno.setRg_aluno(txRg.getText());
        modelAluno.setLocal_nascimento(txLocalNascimento.getText());
        modelAluno.setUf_nascimento(txUfLocalNascimento.getText());
        if (jcb2Fase.isSelected()) {
            modelAluno.setSegunda_fase_confirma(1);

        } else {
            modelAluno.setSegunda_fase_confirma(0);
        }

        if (jcbCadIrregular.isSelected()) {
            modelAluno.setCadastro_irregular(1);

        } else {
            modelAluno.setCadastro_irregular(0);
        }

        Date dataAtual = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if (jcdBaixa.getDate() == null) {

        } else {
            String baixa = dateFormat.format(dtBaixa);
            modelAluno.setData_baixa(baixa);
        }
        if (jcdDataEmissaoCTPS.getDate() == null) {

        } else {
            String cpts = dateFormat.format(dtEmissaoCpts);
            modelAluno.setDt_emissao_ctps(cpts);
        }
        /*        if (jcdDataEmissaoPIS.getDate() == null) {

        } else {
            String pis = dateFormat.format(dtEmissaoPIS);
            modelAluno.setDt_emissao_pis(pis);
        }*/
        if (jcdEmissaoRg.getDate() == null) {

        } else {
            String rg = dateFormat.format(dtEmissaoRg);
            modelAluno.setDt_emissao_rg(rg);
        }
        if (jcdDataInclusao.getDate() == null) {

        } else {
            String inclusao = dateFormat.format(dtInclusao);
            modelAluno.setDt_Inclusao(inclusao);
        }

        if (jcdDataNascimento.getDate() == null) {

        } else {
            String nascimento = dateFormat.format(dtNascimento);
            modelAluno.setDt_nascimento(nascimento);
        }
        if (jcdDataAdmissao.getDate() == null) {

        } else {
            String admissao = dateFormat.format(dtAdmissao);
            modelAluno.setDt_admissao(admissao);
        }
        if (jcdDataRescisao.getDate() == null) {

        } else {
            String rescisao = dateFormat.format(dtRescisao);
            modelAluno.setDt_rescisao(rescisao);
        }
        if (jcdTerminoContrato.getDate() == null) {

        } else {
            String terminoContrato = dateFormat.format(dtTerminoContrato);
            modelAluno.setDt_TerminoContrato(terminoContrato);
        }

        //modelAluno.setDt_nascimento(nascimento);
        if (controllerAluno.atualizarGeralController(modelAluno)) {

            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar o registro!");
        }

        listaModelEntrevistaAlunos = controllerEntrevistaAluno.getListaEntrevistaAlunoController(modelAluno.getId());
        int cont = listaModelEntrevistaAlunos.size();
        DefaultTableModel modelo = (DefaultTableModel) tbEmpresaEntrevista.getModel();
        int tabela = modelo.getRowCount();

        for (int i = cont; i < tabela; i++) {
            modelEntrevistaAluno.setId_aluno(codigoAluno);
            modelEntrevistaAluno.setId_empresa(cbEmpresa.getSelectedIndex() + 1);
            modelEntrevistaAluno.setData_entrevista((String) tbEmpresaEntrevista.getValueAt(i, 1));
            modelEntrevistaAluno.setHorario_entrevista((String) tbEmpresaEntrevista.getValueAt(i, 2));
            controllerEntrevistaAluno.salvarEntrevistaAlunoController(modelEntrevistaAluno);
        }

        for (int j = 0; j < tbDependente.getRowCount(); j++) {
            modelDependentes.setId_asp(codigoAluno);
            modelDependentes.setNome((String) tbDependente.getValueAt(j, 0));
            modelDependentes.setIdade(Integer.parseInt((String) tbDependente.getValueAt(j, 1)));
            modelDependentes.setSexo((String) tbDependente.getValueAt(j, 2));
            System.out.println(modelDependentes);
            if (modelDependentes.getId() == 0) {
                controllerDependentes.salvarDependentesController(modelDependentes);
            } else {
                controllerDependentes.atualizarDependentesController(modelDependentes);

            }
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
        listaPeriodos = controllerPeriodo.getListaPeriodoController();

        cbPeriodo.removeAllItems();
        for (int i = 0; i < listaPeriodos.size(); i++) {
            cbPeriodo.addItem(listaPeriodos.get(i).getDescricao());

        }

    }

    private void preencherLocalAprend() {
        listaAprendizagems = controllerLocalAprendizagem.getListaLocalAprendizagemController();

        cbLocalAprendizagem.removeAllItems();
        for (int i = 0; i < listaAprendizagems.size(); i++) {
            cbLocalAprendizagem.addItem(listaAprendizagems.get(i).getDescricao());

        }

    }

    private void preencherTipoAms() {
        listaModelCodigoAdmses = controllerCodigoAdms.getListaCodigoAdmsController();

        cbTipoAdimissao.removeAllItems();
        for (int i = 0; i < listaModelCodigoAdmses.size(); i++) {
            cbTipoAdimissao.addItem(listaModelCodigoAdmses.get(i).getDescricao());

        }

    }

    private void preencherCBO() {
        listaModelCadCBOs = controllerCadCBO.getListaCadCBOController();

        cbCBO.removeAllItems();
        for (int i = 0; i < listaModelCadCBOs.size(); i++) {
            cbCBO.addItem(listaModelCadCBOs.get(i).getDescricao());

        }

    }

    private void preencherHorario() {
        listaModelHorarios = controllerHorario.getListaHorarioController();

        cbHorario.removeAllItems();
        for (int i = 0; i < listaModelHorarios.size(); i++) {
            cbHorario.addItem(listaModelHorarios.get(i).getDescricao());

        }

    }

    private void preencherSituacao() {
        listaCadastroSituacaos = controllerCadastroSituacao.getListaCadastroSituacaoController();

        cbSituacao.removeAllItems();
        for (int i = 0; i < listaCadastroSituacaos.size(); i++) {
            cbSituacao.addItem(listaCadastroSituacaos.get(i).getDescricao());

        }

    }

    private void preencherCurso() {
        listaModelCursos = controllerCurso.getListaCursoController();

        cbQualCurso.removeAllItems();
        for (int i = 0; i < listaModelCursos.size(); i++) {
            cbQualCurso.addItem(listaModelCursos.get(i).getCurso());

        }

    }

    private void preencherCargaHorariaTotal() {
        listaModelCursos = controllerCurso.getListaCursoController();

        cbCargaHoraria.removeAllItems();
        for (int i = 0; i < listaModelCursos.size(); i++) {
            cbCargaHoraria.addItem(listaModelCursos.get(i).getCategoria_pratica());

        }

    }

    private void preencherCargaHoraria() {
        listaHorasTrabalhadases = controllerHorasTrabalhadas.getListaHorasTrabalhadasController();
        cbHorasTrabalhadas.removeAllItems();
        for (int i = 0; i < listaHorasTrabalhadases.size(); i++) {
            cbHorasTrabalhadas.addItem(listaHorasTrabalhadases.get(i).getDescricao());

        }

    }

    private void preencherDiaCurso() {
        listaModelDiaCursos = controllerDiaCurso.getListaDiaCursoController();
        cbDiaCurso.removeAllItems();
        for (int i = 0; i < listaModelDiaCursos.size(); i++) {
            cbDiaCurso.addItem(listaModelDiaCursos.get(i).getDia());

        }

    }

    private void preencherDiasIntensivo() {
        listaDiasIntensivos = controllerDiasIntensivo.getListaDiasIntensivoController();
        cbDiasIntensivo.removeAllItems();
        for (int i = 0; i < listaDiasIntensivos.size(); i++) {
            cbDiasIntensivo.addItem(listaDiasIntensivos.get(i).getDescricao());

        }

    }

    private void preencherSala() {
        listaModelSalas = controllerSala.getListaSalaController();

        cbSalas.removeAllItems();
        for (int i = 0; i < listaModelSalas.size(); i++) {
            cbSalas.addItem(listaModelSalas.get(i).getDescricao());

        }

    }

    private void preencherEmpresaVirtual() {
        listaEmpresaVirtuals = controllerEmpresaVirtual.getListaEmpresaVirtualController();

        cbEmpresaVirtual.removeAllItems();
        cbEmpresaVirtual.addItem("");
        for (int i = 0; i < listaEmpresaVirtuals.size(); i++) {
            cbEmpresaVirtual.addItem(listaEmpresaVirtuals.get(i).getDescricao());

        }

    }

    private void preencherCargoVirtual() {
        listaCargoVirtuals = controllerCargoVirtual.getListaCargoVirtualController();

        cbCargoVirtual.removeAllItems();
        cbCargoVirtual.addItem("");
        for (int i = 0; i < listaCargoVirtuals.size(); i++) {

            cbCargoVirtual.addItem(listaCargoVirtuals.get(i).getDescricao());

        }

    }

    private void habilitaCampo(boolean condicao) {
        txCodigo.setEditable(condicao);
        txCpf.setEditable(condicao);
        txNacionalidade.setEditable(condicao);
        txCor.setEditable(condicao);
        txPeso.setEditable(condicao);
        txOlhos.setEditable(condicao);
        txSinais.setEditable(condicao);
        txCabelos.setEditable(condicao);
        txEscola.setEditable(condicao);
        txAltura.setEditable(condicao);
        txCtps.setEditable(condicao);
        txNome.setEditable(condicao);
        txNomeMae.setEditable(condicao);
        txNomePai.setEditable(condicao);
        txRGM.setEditable(condicao);
        txRgMae.setEditable(condicao);
        txRgPai.setEditable(condicao);
        txRg.setEditable(condicao);
        txRa.setEditable(condicao);
        txCamiseta.setEditable(condicao);
        txResponsavel.setEditable(condicao);
        txTel1.setEditable(condicao);
        txTel2.setEditable(condicao);
        txTel3.setEditable(condicao);
        txTel4.setEditable(condicao);
        txIdadeDp.setEditable(condicao);
        txDependente.setEditable(condicao);
        jcdDataNascimento.setEnabled(condicao);
        jcdEmissaoRg.setEnabled(condicao);
        jcdDataEmissaoCTPS.setEnabled(condicao);
        jcdDataEntrevista.setEnabled(condicao);
        jcdBaixa.setEnabled(condicao);
        cbSexo.setEnabled(condicao);
        cbSexoDependente.setEnabled(condicao);
        cbSalas.setEnabled(condicao);
        cbStatus.setEnabled(condicao);
        txCep.setEditable(condicao);
        txSerieUfCtps.setEditable(condicao);
        txComplemento.setEditable(condicao);
        txHorarioEntrevista.setEditable(condicao);
        txLogradouro.setEditable(condicao);
        txLocalNascimento.setEditable(condicao);
        txUfLocalNascimento.setEditable(condicao);
        cbEstCivil1.setEnabled(condicao);
        txBairro.setEditable(condicao);
        txMunicipio.setEditable(condicao);
        txNumero.setEditable(condicao);
        txEnderecoUF.setEditable(condicao);
        btPesquisaCep.setEnabled(condicao);
        btRemoverImagem.setEnabled(condicao);
        btFoto.setEnabled(condicao);
        cbTurma.setEnabled(condicao);
        cbEmpresaVirtual.setEnabled(condicao);
        cbCargoVirtual.setEnabled(condicao);
        cbSituacao.setEnabled(condicao);
        cbCursoIntensivo.setEnabled(condicao);
        cbSexo.setEnabled(condicao);
        cbOrigemAluno.setEnabled(condicao);
        jcb2Fase.setEnabled(condicao);
        jcbCadIrregular.setEnabled(condicao);
        txEmail.setEditable(condicao);
        txPort1.setEditable(condicao);
        txPort2.setEditable(condicao);
        txPort3.setEditable(condicao);
        txPort4.setEditable(condicao);
        txPort5.setEditable(condicao);
        txMat1.setEditable(condicao);
        txMat2.setEditable(condicao);
        txMat3.setEditable(condicao);
        txMat4.setEditable(condicao);
        txMat5.setEditable(condicao);
        txRed1.setEditable(condicao);
        txRed2.setEditable(condicao);
        txRed3.setEditable(condicao);
        txRed4.setEditable(condicao);
        txRed5.setEditable(condicao);
        txInf1.setEditable(condicao);
        txInf2.setEditable(condicao);
        txInf3.setEditable(condicao);
        txInf4.setEditable(condicao);
        txInf5.setEditable(condicao);
        txMedia1.setEditable(condicao);
        txMedia2.setEditable(condicao);
        txMedia3.setEditable(condicao);
        txMedia4.setEditable(condicao);
        txMedia5.setEditable(condicao);
        txPis.setEditable(condicao);
        txNumeroConta.setEditable(condicao);
        txAgencia.setEditable(condicao);
        txBanco.setEditable(condicao);
        txAtit2.setEditable(condicao);
        txAtit3.setEditable(condicao);
        txAtit4.setEditable(condicao);
        txAtit5.setEditable(condicao);
        taAdministrativa.setEditable(condicao);
        taPedagogicas.setEditable(condicao);
        taPsicologicas.setEditable(condicao);
        taSociais.setEditable(condicao);
        taObservacao.setEditable(condicao);
        cbEmpAdmissao.setEnabled(condicao);
        jcdDataAdmissao.setEnabled(condicao);
        jcdDataRescisao.setEnabled(condicao);
        jcdDataInclusao.setEnabled(condicao);
        jcdTerminoContrato.setEnabled(condicao);
        cbSalas.setEnabled(condicao);
        cbTurma.setEnabled(condicao);
        cbDiaAtivTeorica.setEnabled(condicao);
        cbCargaHoraria.setEnabled(condicao);
        cbQualCurso.setEnabled(condicao);
        cbHorario.setEnabled(condicao);
        cbLocalAprendizagem.setEnabled(condicao);
        cbDiaCurso.setEnabled(condicao);
        txIntensPeriodo1.setEditable(condicao);
        txIntensPeriodo2.setEditable(condicao);
        txIntensPeriodo3.setEditable(condicao);
        txNotaCargoVirt.setEditable(condicao);
        txVotoConsciente.setEditable(condicao);
        txPendenteIntensivo.setEditable(condicao);
        cbDiasIntensivo.setEnabled(condicao);
        cbCBO.setEnabled(condicao);
        cbHorasTrabalhadas.setEnabled(condicao);
        cbEmpresaVirtual.setEnabled(condicao);
        cbCargoVirtual.setEnabled(condicao);
        cbPeriodo.setEnabled(condicao);

    }

    private void limpaCampos() {
        DefaultTableModel modelo = (DefaultTableModel) tbEmpresaEntrevista.getModel();
        DefaultTableModel modeloD = (DefaultTableModel) tbDependente.getModel();
        modelo.setNumRows(0);
        modeloD.setNumRows(0);
        txCodigo.setText("");
        txCabelos.setText("");
        taAdministrativa.setText("");
        taPedagogicas.setText("");
        taPsicologicas.setText("");
        taSociais.setText("");
        txNacionalidade.setText("");
        txCor.setText("");
        txPeso.setText("");
        txOlhos.setText("");
        txSinais.setText("");
        taObservacao.setText("");
        txCpf.setText("");
        txCtps.setText("");
        txNome.setText("");
        txNomeMae.setText("");
        txHorarioEntrevista.setText("");
        txNomePai.setText("");
        txRGM.setText("");
        txRg.setText("");
        txRa.setText("");
        txCamiseta.setText("");
        txResponsavel.setText("");
        txRgPai.setText("");
        txRgMae.setText("");
        txTel1.setText("");
        txTel2.setText("");
        txTel3.setText("");
        txTel4.setText("");
        txCep.setText("");
        txAgencia.setText("");
        txNumeroConta.setText("");
        txBanco.setText("");
        txNumero.setText("");
        txAltura.setText("0");
        txEscola.setText("");
        txPort1.setText("0");
        txPort2.setText("0");
        txPort3.setText("0");
        txPort4.setText("0");
        txPort5.setText("0");
        txMat1.setText("0");
        txMat2.setText("0");
        txMat3.setText("0");
        txMat4.setText("0");
        txMat5.setText("0");
        txInf1.setText("0");
        txInf2.setText("0");
        txInf3.setText("0");
        txInf4.setText("0");
        txInf5.setText("0");
        txRed1.setText("0");
        txRed2.setText("0");
        txRed3.setText("0");
        txRed4.setText("0");
        txRed5.setText("0");
        txMedia1.setText("0");
        txMedia2.setText("0");
        txMedia3.setText("0");
        txMedia4.setText("0");
        txMedia5.setText("0");
        txAtit2.setText("0");
        txAtit3.setText("0");
        txAtit4.setText("0");
        txAtit5.setText("0");
        txSerieUfCtps.setText("");
        txComplemento.setText("");
        txLogradouro.setText("");
        txBairro.setText("");
        txMunicipio.setText("");
        txEnderecoUF.setText("");
        txLocalNascimento.setText("");
        txUfLocalNascimento.setText("");
        txEmail.setText("");
        txDependente.setText("");
        txIdadeDp.setText("");
        txIntensPeriodo1.setText("");
        txIntensPeriodo2.setText("");
        txIntensPeriodo3.setText("");
        txPendenteIntensivo.setText("");
        txVotoConsciente.setText("");
        txNotaCargoVirt.setText("0");
        jcb2Fase.setSelected(false);
        jcbCadIrregular.setSelected(false);
        Date date = null;
        jcdDataNascimento.setDate(date);
        jcdEmissaoRg.setDate(date);
        jcdDataEmissaoCTPS.setDate(date);
        jcdBaixa.setDate(date);
        jcdDataAdmissao.setDate(date);
        jcdDataRescisao.setDate(date);
        jcdDataInclusao.setDate(date);
        jcdTerminoContrato.setDate(date);
        cbSexo.setSelectedIndex(0);
        cbSituacao.setSelectedIndex(0);
        cbEmpAdmissao.setSelectedIndex(-1);
        cbSalas.setSelectedIndex(-1);
        cbTurma.setSelectedIndex(-1);
        cbOrigemAluno.setSelectedIndex(-1);
        cbDiaAtivTeorica.setSelectedIndex(-1);
        cbCargaHoraria.setSelectedIndex(-1);
        cbQualCurso.setSelectedIndex(-1);
        cbHorario.setSelectedIndex(-1);
        cbLocalAprendizagem.setSelectedIndex(-1);
        cbDiaCurso.setSelectedIndex(-1);
        cbCBO.setSelectedIndex(-1);
        cbPeriodo.setSelectedIndex(-1);
        cbHorasTrabalhadas.setSelectedIndex(-1);
        cbDiasIntensivo.setSelectedIndex(-1);
        cbEmpresaVirtual.setSelectedIndex(-1);
        cbCargoVirtual.setSelectedIndex(-1);
        cbCursoIntensivo.setSelectedIndex(-1);
        cbEstCivil1.setSelectedIndex(0);

        lblImagem.setIcon(null);
        jcbCadIrregular.setForeground(Color.black);

    }

    //carrega os dados do aluno
    private void carregarAlunos(int pcodigoAluno) {
        ControllerAdmissao controllerAdmissao = new ControllerAdmissao();
        ModelAdmissao modelAdmissao = new ModelAdmissao();
        modelAdmissao = controllerAdmissao.getAdmissaoController(codigoAluno);
        ControllerAluno controllerAluno = new ControllerAluno();
        ControllerCadEndereco controllerCadEndereco = new ControllerCadEndereco();
        ModelCadEndereco modelCadEndereco = new ModelCadEndereco();
        ModelAluno modelAluno = new ModelAluno();
        modelAluno = controllerAluno.getGeralController(codigoAluno);
        modelCadEndereco = controllerCadEndereco.getCadEnderecoCodController(modelAluno.getCod_endereco());

        cadastroSituacao = controllerCadastroSituacao.getCadastroSituacaoController(modelAluno.getSituacao());
        modelBucarImagem = controllerBucarImagem.getBucarImagemController(modelAluno.getId());
        if (modelBucarImagem.getId_aluno() == 0) {

        } else {
            Integer id = modelBucarImagem.getId_aluno();
            DAOInserirImagem dao = new DAOInserirImagem();
            ModelInserirImagem exe = dao.buscar(id);
            ManipularImagem.exibiImagemLabel(exe.getImagem(), lblImagem);
        }

        //dados
        txCodigo.setText(String.valueOf(modelAluno.getId()));
        txNome.setText(modelAluno.getNome_aluno());
        txRGM.setText(modelAluno.getRgm_aluno());
        txRg.setText(modelAluno.getRg_aluno());
        txRa.setText(modelAluno.getReservista());
        txCamiseta.setText(modelAluno.getCamiseta());
        txResponsavel.setText(modelAluno.getResponsavel());
        txNomeMae.setText(modelAluno.getMae());
        txNomePai.setText(modelAluno.getPai());
        txRgMae.setText(modelAluno.getRg_mae());
        txRgPai.setText(modelAluno.getRg_pai());
        txRg.setText(modelAluno.getRg_aluno());
        txCpf.setText(modelAluno.getCpf());
        txCtps.setText(modelAluno.getCtps());
        txPerctInsalubridade.setText("0");
        txSerieUfCtps.setText(modelAluno.getSerie_uf_cpts());
        txLocalNascimento.setText(modelAluno.getLocal_nascimento());
        txUfLocalNascimento.setText(modelAluno.getUf_nascimento());
        cbSexo.setSelectedItem(modelAluno.getSexo());
        cbCargaHoraria.setSelectedItem(modelAluno.getCarga_horaria_total());
        txBanco.setText(modelAluno.getBanco());
        txAgencia.setText(modelAluno.getAgencia());
        txNumeroConta.setText(modelAluno.getNum_conta());
        txEmail.setText(modelAluno.getEmail());
        txEscola.setText(modelAluno.getEscola());
        txVotoConsciente.setText(modelAluno.getVoto_consciente());
        if (modelAluno.getSituacao().equals("INATIVO")) {
            lbNomeApresentacao.setForeground(Color.red);
            lbNomeApresentacao.setText(modelAluno.getNome_aluno());
        } else {
            lbNomeApresentacao.setForeground(Color.blue);
            lbNomeApresentacao.setText(modelAluno.getNome_aluno());
        }

        txTel1.setText(modelAluno.getTel_1());
        txTel2.setText(modelAluno.getTel_2());
        txTel3.setText(modelAluno.getTel_3());
        txTel4.setText(modelAluno.getTel_4());
        txCor.setText(modelAluno.getCor());
        txPeso.setText(String.valueOf(modelAluno.getPeso()));
        txCabelos.setText(modelAluno.getCabelos());
        txOlhos.setText(modelAluno.getOlhos());
        txSinais.setText(modelAluno.getSinais());
        txPis.setText(modelAluno.getPis());
        cbStatus.setSelectedItem(modelAluno.getStatus());
        txPort1.setText(String.valueOf(modelAluno.getPort1()));
        txPort2.setText(String.valueOf(modelAluno.getPort2()));
        txPort3.setText(String.valueOf(modelAluno.getPort3()));
        txPort4.setText(String.valueOf(modelAluno.getPort4()));
        txPort5.setText(String.valueOf(modelAluno.getPort5()));
        txMat1.setText(String.valueOf(modelAluno.getMat1()));
        txMat2.setText(String.valueOf(modelAluno.getMat2()));
        txMat3.setText(String.valueOf(modelAluno.getMat3()));
        txMat4.setText(String.valueOf(modelAluno.getMat4()));
        txMat5.setText(String.valueOf(modelAluno.getMat5()));
        txRed1.setText(String.valueOf(modelAluno.getRed1()));
        txRed2.setText(String.valueOf(modelAluno.getRed2()));
        txRed3.setText(String.valueOf(modelAluno.getRed3()));
        txRed4.setText(String.valueOf(modelAluno.getRed4()));
        txRed5.setText(String.valueOf(modelAluno.getRed5()));
        txInf1.setText(String.valueOf(modelAluno.getInf1()));
        txInf2.setText(String.valueOf(modelAluno.getInf2()));
        txInf3.setText(String.valueOf(modelAluno.getInf3()));
        txInf4.setText(String.valueOf(modelAluno.getInf4()));
        txInf5.setText(String.valueOf(modelAluno.getInf5()));
        txMedia1.setText(String.valueOf(modelAluno.getMd1()));
        txMedia2.setText(String.valueOf(modelAluno.getMd2()));
        txMedia3.setText(String.valueOf(modelAluno.getMd3()));
        txMedia4.setText(String.valueOf(modelAluno.getMd4()));
        txMedia5.setText(String.valueOf(modelAluno.getMd5()));
        txAtit2.setText(String.valueOf(modelAluno.getAtitudes2()));
        txAtit3.setText(String.valueOf(modelAluno.getAtitudes3()));
        txAtit4.setText(String.valueOf(modelAluno.getAtitudes4()));
        txAtit5.setText(String.valueOf(modelAluno.getAtitudes5()));
        txPendenteIntensivo.setText(modelAluno.getPendente_intensivo());
        txIntensPeriodo1.setText(modelAluno.getInt_per1());
        txIntensPeriodo2.setText(modelAluno.getInt_per2());
        txIntensPeriodo3.setText(modelAluno.getInt_per3());
        cbCursoIntensivo.setSelectedIndex(modelAluno.getIntensivo() - 1);
        cbOrigemAluno.setSelectedIndex(modelAluno.getOrigem_aluno() - 1);
        txNotaCargoVirt.setText(String.valueOf(modelAluno.getNota_cargo_virtual()));

        txIntensPeriodo1.setText(modelAluno.getInt_per1());
        txIntensPeriodo2.setText(modelAluno.getInt_per2());
        txIntensPeriodo3.setText(modelAluno.getInt_per3());

        txAltura.setText(String.valueOf(modelAluno.getAltura()));
        txSalario.setText(String.valueOf(modelAluno.getSalario()));
        cbCBO.setSelectedIndex(modelAluno.getCbo() - 1);
        cbHorario.setSelectedIndex(modelAluno.getHorario() - 1);
        cbQualCurso.setSelectedIndex(modelAluno.getCurso() - 1);
        cbPeriodo.setSelectedIndex(modelAluno.getPeriodo() - 1);
        cbHorasTrabalhadas.setSelectedIndex(modelAluno.getHoras_trabalhadas() - 1);

        cbDiaCurso.setSelectedItem(modelAluno.getDiaCurso());
        //txPerctInsalubridade.setText(String.valueOf(modelAluno.getInsalubre()));
        taAdministrativa.setText(modelAluno.getAnot_administrativas());
        taPedagogicas.setText(modelAluno.getAnot_pedagogicas());
        taPsicologicas.setText(modelAluno.getAnot_psicologicas());
        taSociais.setText(modelAluno.getAnot_sociais());
        taObservacao.setText(modelAluno.getObservacao());
        //txSalario.setText(String.valueOf(modelAdmissao.getSalario()));
        cbTipoAdimissao.setSelectedIndex(modelAdmissao.getTipo_admissao() - 1);
        cbEmpAdmissao.setSelectedIndex(modelAluno.getEmpresa() - 1);
        cbTurma.setSelectedIndex(modelAluno.getTurma() - 1);
        cbSalas.setSelectedIndex(modelAluno.getSala() - 1);
        cbLocalAprendizagem.setSelectedIndex(modelAluno.getLocal_aprendizagem() - 1);
        cbEstCivil1.setSelectedItem(modelAluno.getEstado_civil());
        cbEmpresaVirtual.setSelectedIndex(modelAluno.getEmpresa_virtual() - 1);
        cbCargoVirtual.setSelectedIndex(modelAluno.getCargo_virtual() - 1);
        cbDiasIntensivo.setSelectedIndex(modelAluno.getDias_intensivo() - 1);
        cbDiaAtivTeorica.setSelectedIndex(modelAluno.getDiaAtivTeorica() - 1);

        // txPerctInsalubridade.setText(String.valueOf(modelAdmissao.getInsalubre_percentual()));
        txNacionalidade.setText(modelAluno.getNacionalidade());
        cbSituacao.setSelectedItem(modelAluno.getSituacao());

        if (modelAluno.getSegunda_fase_confirma() == 1) {
            jcb2Fase.setSelected(true);

        } else {
            jcb2Fase.setSelected(false);
        }
        if (modelAluno.getCadastro_irregular() == 1) {
            jcbCadIrregular.setSelected(true);
            jcbCadIrregular.setForeground(Color.red);

        } else {
            jcbCadIrregular.setSelected(false);
            jcbCadIrregular.setForeground(Color.black);
        }
        if (modelAdmissao.getConvenio_odont() == 0) {
            jcbConvenioOdontologico.setSelected(false);
        } else {
            jcbConvenioOdontologico.setSelected(true);
        }
        if (modelAdmissao.getDesconto_vt() == 0) {
            jcbVt.setSelected(false);
        } else {
            jcbVt.setSelected(true);
        }
        if (modelAdmissao.getInsalubre() == 0) {
            jcbInsalubre.setSelected(false);
        } else {
            jcbInsalubre.setSelected(true);
        }

        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
        Date dataRg, dataCpts, dataNascimento, dataEntrevista, dataBaixa, dtEmissaoPis, dtInicio,
                dtTermino, dtAdmissao, dtRescisao, dtInclusao;
        try {

            if (modelAluno.getDt_nascimento().equals("null") || modelAluno.getDt_nascimento().equals("") || modelAluno.getDt_nascimento() == null) {

            } else {

                dataNascimento = formato.parse(modelAluno.getDt_nascimento());
                jcdDataNascimento.setDate(dataNascimento);
            }
            if (modelAluno.getData_baixa().equals("null") || modelAluno.getData_baixa().equals("") || modelAluno.getData_baixa() == null) {

            } else {

                dataBaixa = formato.parse(modelAluno.getData_baixa());
                jcdBaixa.setDate(dataBaixa);
            }
            if (modelAluno.getDt_emissao_ctps().equals("null") || modelAluno.getDt_emissao_ctps().equals("") || modelAluno.getDt_emissao_ctps() == null) {

            } else {

                dataCpts = formato.parse(modelAluno.getDt_emissao_ctps());
                jcdDataEmissaoCTPS.setDate(dataCpts);
            }
            if (modelAluno.getDt_emissao_rg().equals("null") || modelAluno.getDt_emissao_rg().equals("") || modelAluno.getDt_emissao_rg() == null) {

            } else {
                dataRg = formato.parse(modelAluno.getDt_emissao_rg());
                jcdEmissaoRg.setDate(dataRg);
            }
            if (modelAluno.getDt_admissao().equals("null") || modelAluno.getDt_admissao().equals("") || modelAluno.getDt_admissao() == null) {

            } else {
                dtAdmissao = formato.parse(modelAluno.getDt_admissao());
                jcdDataAdmissao.setDate(dtAdmissao);
            }
            if (modelAluno.getDt_admissao().equals("null") || modelAluno.getDt_admissao().equals("") || modelAluno.getDt_admissao() == null) {

            } else {
                dtAdmissao = formato.parse(modelAluno.getDt_admissao());
                jcdDataAdmissao.setDate(dtAdmissao);
            }
            if (modelAluno.getDt_rescisao().equals("null") || modelAluno.getDt_rescisao().equals("") || modelAluno.getDt_rescisao() == null) {

            } else {
                dtRescisao = formato.parse(modelAluno.getDt_rescisao());
                jcdDataRescisao.setDate(dtRescisao);
            }
            if (modelAluno.getDt_Inclusao() == null || modelAluno.getDt_Inclusao().equals("") || modelAluno.getDt_Inclusao().equals("null")) {

            } else {
                dtInclusao = formato.parse(modelAluno.getDt_Inclusao());
                jcdDataInclusao.setDate(dtInclusao);
            }
            if (modelAluno.getDt_TerminoContrato() == null || modelAluno.getDt_TerminoContrato().equals("") || modelAluno.getDt_TerminoContrato().equals("null")) {

            } else {
                dtTermino = formato.parse(modelAluno.getDt_TerminoContrato());
                jcdTerminoContrato.setDate(dtTermino);
            }
            /*           if (modelAluno.getDt_emissao_pis().equals("null") || modelAluno.getDt_emissao_pis().equals("")) {

            } else {
                dtEmissaoPis = formato.parse(modelAluno.getDt_emissao_pis());
                jcdDataEmissaoPIS.setDate(dtEmissaoPis);
            }*/

 /*  if (modelAdmissao.getInicio() ==null || modelAdmissao.getInicio().equals("")) {

            } else {
                dtInicio = formato.parse(modelAdmissao.getInicio());
                jcdDataAdmicao.setDate(dtInicio);
            }*/
 /*            if (modelAdmissao.getTermino().equals("null") || modelAdmissao.getTermino().equals("")) {

            } else {
                dtTermino = formato.parse(modelAdmissao.getTermino());
                jcdDataTermino.setDate(dtTermino);
            }*/
//            dataEntrevista = formato.parse(modelAluno.getDt_entrevista());
            //   jcdDataEntrevista.setDate(dataEntrevista);
        } catch (ParseException ex) {
            Logger.getLogger(ViewAluno.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (modelAluno.getCod_endereco() == 0) {
            txCep.setText(modelAluno.getCep_apoio());
        } else {

            //endereço/contato
            txCep.setText(modelCadEndereco.getEnd_cep());
            txLogradouro.setText(modelCadEndereco.getEnd_logradouro());
            txBairro.setText(modelCadEndereco.getEnd_bairro());
            txMunicipio.setText(modelCadEndereco.getEnd_cidade());
            txNumero.setText(modelAluno.getNumero());
            txComplemento.setText(modelAluno.getComplemento());
            txEnderecoUF.setText(modelCadEndereco.getEnd_uf());
            txTel4.setText(modelAluno.getTel_3());
            txTel3.setText(modelAluno.getTel_4());
            txTel1.setText(modelAluno.getTel_1());
            txTel2.setText(modelAluno.getTel_2());
        }

        listaModelEntrevistaAlunos = controllerEntrevistaAluno.getListaEntrevistaAlunoController(modelAluno.getId());
        DefaultTableModel modelo = (DefaultTableModel) tbEmpresaEntrevista.getModel();
        modelo.setNumRows(0);
        int cont = listaModelEntrevistaAlunos.size();
        for (int i = 0; i < cont; i++) {
            modelEmpresa = controllerEmpresa.getEmpresaController(listaModelEntrevistaAlunos.get(i).getId_empresa());
            modelo.addRow(new Object[]{
                modelEmpresa.getRazao(),
                listaModelEntrevistaAlunos.get(i).getData_entrevista(),
                listaModelEntrevistaAlunos.get(i).getHorario_entrevista()
            });
        }
        listaModelDependentes = controllerDependentes.getListaDependentesController(modelAluno.getId());
        DefaultTableModel modeloD = (DefaultTableModel) tbDependente.getModel();
        modeloD.setNumRows(0);
        int contD = listaModelDependentes.size();
        for (int j = 0; j < contD; j++) {

            modeloD.addRow(new Object[]{
                listaModelDependentes.get(j).getNome(),
                listaModelDependentes.get(j).getIdade(),
                listaModelDependentes.get(j).getSexo()
            });
        }

    }

    private void salvarImagem() {
        try {

            if (lblImagem.equals("")) {

            } else {

                ModelInserirImagem obj = new ModelInserirImagem();
                obj.setImagem(ManipularImagem.getImgBytes(imagem));
                obj.setId_aluno(codigoAluno);

                DAOInserirImagem dao = new DAOInserirImagem();

                Boolean foi = dao.inserir(obj);
                // Boolean foi = dao.salvarImagemDAO(obj);
                if (foi) {

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Imagem não enviada");

                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ViewAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void calculaSalario() {
        float valorHora = (float) (6.53 * 20);
        int multiplicador = Integer.parseInt((String) cbHorasTrabalhadas.getSelectedItem());
        float salario = multiplicador * valorHora;
        txSalario.setText(String.valueOf(salario));

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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        txNacionalidade = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        txCor = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        txPeso = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        txCabelos = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        txOlhos = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        txCamiseta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbEstCivil1 = new javax.swing.JComboBox<>();
        jLabel99 = new javax.swing.JLabel();
        txAltura = new javax.swing.JTextField();
        txSinais = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        txEscola = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        txResponsavel = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txRa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jcbCadIrregular = new javax.swing.JCheckBox();
        cbSalas = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbTurma = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jcdDataInclusao = new com.toedter.calendar.JDateChooser();
        jLabel104 = new javax.swing.JLabel();
        cbDiaAtivTeorica = new javax.swing.JComboBox<>();
        jLabel105 = new javax.swing.JLabel();
        jcdTerminoContrato = new com.toedter.calendar.JDateChooser();
        jLabel106 = new javax.swing.JLabel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel24 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        cbQualCurso = new javax.swing.JComboBox<>();
        cbHorario = new javax.swing.JComboBox<>();
        cbLocalAprendizagem = new javax.swing.JComboBox<>();
        jLabel107 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        txIntensPeriodo1 = new javax.swing.JTextField();
        txIntensPeriodo2 = new javax.swing.JTextField();
        txIntensPeriodo3 = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        cbDiaCurso = new javax.swing.JComboBox<>();
        jLabel97 = new javax.swing.JLabel();
        cbCBO = new javax.swing.JComboBox<>();
        jLabel80 = new javax.swing.JLabel();
        cbPeriodo = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        cbHorasTrabalhadas = new javax.swing.JComboBox<>();
        cbDiasIntensivo = new javax.swing.JComboBox<>();
        jLabel136 = new javax.swing.JLabel();
        txPendenteIntensivo = new javax.swing.JTextField();
        jLabel137 = new javax.swing.JLabel();
        cbCursoIntensivo = new javax.swing.JComboBox<>();
        jLabel60 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        cbOrigemAluno = new javax.swing.JComboBox<>();
        jLabel63 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        txPort1 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txMat1 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txRed1 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txInf1 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txMedia1 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txPort2 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        txPort3 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        txMat2 = new javax.swing.JTextField();
        txInf2 = new javax.swing.JTextField();
        txMat3 = new javax.swing.JTextField();
        txInf3 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        txRed3 = new javax.swing.JTextField();
        txRed2 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        txAtit2 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        txAtit3 = new javax.swing.JTextField();
        txMedia2 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txMedia3 = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        txPort4 = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        txMat4 = new javax.swing.JTextField();
        txInf4 = new javax.swing.JTextField();
        jLabel115 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        txRed4 = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        txAtit4 = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        txMedia4 = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();
        txPort5 = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        txMat5 = new javax.swing.JTextField();
        txInf5 = new javax.swing.JTextField();
        jLabel127 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        txRed5 = new javax.swing.JTextField();
        jLabel134 = new javax.swing.JLabel();
        txAtit5 = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        txMedia5 = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        cbEmpresaVirtual = new javax.swing.JComboBox<>();
        jLabel68 = new javax.swing.JLabel();
        cbCargoVirtual = new javax.swing.JComboBox<>();
        jLabel69 = new javax.swing.JLabel();
        txNotaCargoVirt = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txVotoConsciente = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jToolBar7 = new javax.swing.JToolBar();
        btCertificadoAprendiz = new javax.swing.JButton();
        btCertificadoAspirante = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jToolBar6 = new javax.swing.JToolBar();
        btPreparatorio = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        btSaida = new javax.swing.JButton();
        jToolBar5 = new javax.swing.JToolBar();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        btAvalAspirante = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jcbSalas = new javax.swing.JCheckBox();
        jcbTurma = new javax.swing.JCheckBox();
        jToolBar8 = new javax.swing.JToolBar();
        jButton15 = new javax.swing.JButton();
        jcdDataAdmissao = new com.toedter.calendar.JDateChooser();
        jLabel83 = new javax.swing.JLabel();
        jcdDataRescisao = new com.toedter.calendar.JDateChooser();
        jLabel84 = new javax.swing.JLabel();
        cbEmpAdmissao = new javax.swing.JComboBox<>();
        jLabel89 = new javax.swing.JLabel();
        jcb2Fase = new javax.swing.JCheckBox();
        cbCargaHoraria = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        txDependente = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        btIncluirDep = new javax.swing.JButton();
        btRemoverDp = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbDependente = new javax.swing.JTable();
        txIdadeDp = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        cbSexoDependente = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        cbEmpresa = new javax.swing.JComboBox<>();
        jcdDataEntrevista = new com.toedter.calendar.JDateChooser();
        jLabel74 = new javax.swing.JLabel();
        txHorarioEntrevista = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        btIncluirEntrevista = new javax.swing.JButton();
        btRmover = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbEmpresaEntrevista = new javax.swing.JTable();
        btEncaminhamento = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel17 = new javax.swing.JPanel();
        txSalario = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        cbTipoAdimissao = new javax.swing.JComboBox<>();
        jcbInsalubre = new javax.swing.JCheckBox();
        jcbConvenioOdontologico = new javax.swing.JCheckBox();
        jcbVt = new javax.swing.JCheckBox();
        txPerctInsalubridade = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        btConfirmaAdmissao = new javax.swing.JButton();
        btCancelaAdmissao = new javax.swing.JButton();
        btCalculaSalario = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        btRegEmpregado = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        btFichaAuxAdm = new javax.swing.JButton();
        btAssAdm = new javax.swing.JButton();
        btComercio = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel87 = new javax.swing.JLabel();
        jToolBar3 = new javax.swing.JToolBar();
        btArco = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        jToolBar4 = new javax.swing.JToolBar();
        btAux2 = new javax.swing.JButton();
        btAssAdm2 = new javax.swing.JButton();
        btComercio1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btArco1 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taPedagogicas = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taSociais = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taPsicologicas = new javax.swing.JTextArea();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        taAdministrativa = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        taObservacao = new javax.swing.JTextArea();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        taRecrutamento = new javax.swing.JTextArea();
        jPanel18 = new javax.swing.JPanel();
        txCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txRGM = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jcdBaixa = new com.toedter.calendar.JDateChooser();
        txNomeMae = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txNomePai = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txRgMae = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txRgPai = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jcdDataNascimento = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        lblImagem = new javax.swing.JLabel();
        btFoto = new javax.swing.JButton();
        btRemoverImagem = new javax.swing.JButton();
        jcdEmissaoRg = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txRg = new javax.swing.JTextField();
        txCpf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txLocalNascimento = new javax.swing.JTextField();
        txUfLocalNascimento = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        txCtps = new javax.swing.JTextField();
        txSerieUfCtps = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        txPis = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        txTel1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txTel2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txCep = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        btPesquisaCep = new javax.swing.JButton();
        txLogradouro = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txNumero = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txComplemento = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txBairro = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txMunicipio = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txEnderecoUF = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txTel3 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txTel4 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jcdDataEmissaoCTPS = new com.toedter.calendar.JDateChooser();
        jLabel102 = new javax.swing.JLabel();
        txEmail = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txNumeroConta = new javax.swing.JTextField();
        txAgencia = new javax.swing.JTextField();
        txBanco = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        lbNomeApresentacao = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        cbSituacao = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
        jLabel138 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Aspirante");
        setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txNacionalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNacionalidadeActionPerformed(evt);
            }
        });
        txNacionalidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txNacionalidadeKeyReleased(evt);
            }
        });

        jLabel100.setText("Nacionalidade");

        txCor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txCorKeyReleased(evt);
            }
        });

        jLabel90.setText("Cor");

        txPeso.setText("0");
        txPeso.setToolTipText("");
        txPeso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txPesoFocusGained(evt);
            }
        });
        txPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPesoActionPerformed(evt);
            }
        });
        txPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txPesoKeyReleased(evt);
            }
        });

        jLabel94.setText("Peso");

        txCabelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCabelosActionPerformed(evt);
            }
        });
        txCabelos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txCabelosKeyReleased(evt);
            }
        });

        jLabel93.setText("Cabelos");

        txOlhos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txOlhosKeyReleased(evt);
            }
        });

        jLabel91.setText("Olhos");

        txCamiseta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCamisetaActionPerformed(evt);
            }
        });
        txCamiseta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txCamisetaKeyReleased(evt);
            }
        });

        jLabel4.setText("Camiseta");

        cbEstCivil1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLTEIRO", "CASADO", "AMASIADO", "OUTROS" }));
        cbEstCivil1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstCivil1ActionPerformed(evt);
            }
        });

        jLabel99.setText("Estado Civil");

        txAltura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txAlturaFocusGained(evt);
            }
        });
        txAltura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txAlturaKeyReleased(evt);
            }
        });

        txSinais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSinaisActionPerformed(evt);
            }
        });
        txSinais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txSinaisKeyReleased(evt);
            }
        });

        jLabel92.setText("Sinais");

        txEscola.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txEscolaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txEscolaKeyReleased(evt);
            }
        });

        jLabel72.setText("Escola");

        txResponsavel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txResponsavelKeyReleased(evt);
            }
        });

        jLabel16.setText("Responsável");

        jLabel6.setText("RA");

        jLabel53.setText("Altura");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel53)
                                    .addComponent(txAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel94))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txOlhos, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel91))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txCor, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel90))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel93)
                                    .addComponent(txCabelos, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txEscola, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                    .addComponent(jLabel100)
                                    .addComponent(txNacionalidade))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txRa)
                                    .addComponent(cbEstCivil1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel99))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(txSinais, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(517, 517, 517))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel92)
                            .addComponent(txResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txCamiseta, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel100)
                    .addComponent(jLabel99))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNacionalidade, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(cbEstCivil1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel72)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(txRa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel94)
                            .addComponent(jLabel91)
                            .addComponent(jLabel90)
                            .addComponent(jLabel93))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txOlhos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txCor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txCabelos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel92)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txSinais, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(txCamiseta, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );

        jTabbedPane1.addTab("Informações Adicionais", jPanel3);

        jcbCadIrregular.setText("Cad. Irregular");
        jcbCadIrregular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbCadIrregularMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jcbCadIrregularMouseExited(evt);
            }
        });

        jLabel11.setText("Salas");

        cbTurma.setAutoscrolls(true);

        jLabel9.setText("Turma");

        jLabel104.setText("Data de Inclusão");

        jLabel105.setText("Dia de atividade teórica");

        jLabel106.setText("Data de término do contrato");

        jLabel107.setText("Local de Aprendizagem");

        jLabel109.setText("Intensivo Período 1 ");

        jLabel110.setText("Intensivo Período 2");

        jLabel111.setText("Intensivo Período 3");

        jLabel112.setText("Qual Curso");

        jLabel113.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel113.setText("Curso Intensivo");

        jLabel97.setText("Dia do Curso");

        cbCBO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCBOActionPerformed(evt);
            }
        });

        jLabel80.setText("CBO");

        jLabel26.setText("Período");

        cbHorasTrabalhadas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbHorasTrabalhadasKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbHorasTrabalhadasKeyReleased(evt);
            }
        });

        jLabel136.setText("Dias Intensivo");

        jLabel137.setText("Pendente Intensivo");

        jLabel60.setText("Curso Intensivo");

        jLabel61.setText("Horário");

        jLabel62.setText("Horas Trabalhadas");

        cbOrigemAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOrigemAlunoActionPerformed(evt);
            }
        });

        jLabel63.setText("Origem");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel109)
                                    .addComponent(jLabel110)
                                    .addComponent(jLabel111))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txIntensPeriodo1)
                                    .addComponent(txIntensPeriodo2)
                                    .addComponent(txIntensPeriodo3))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(cbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbOrigemAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel63)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbDiasIntensivo, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel136)
                                            .addComponent(cbCursoIntensivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel60)
                                        .addGap(146, 146, 146)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbQualCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txPendenteIntensivo)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel112)
                                            .addComponent(jLabel137))
                                        .addGap(0, 129, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel61)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbCBO, 0, 183, Short.MAX_VALUE)
                                        .addComponent(jLabel80)
                                        .addComponent(jLabel97)
                                        .addComponent(cbDiaCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel107)
                                .addGap(147, 147, 147))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel26)
                                        .addComponent(cbLocalAprendizagem, 0, 169, Short.MAX_VALUE)
                                        .addComponent(cbPeriodo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbHorasTrabalhadas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel62))
                                .addGap(90, 90, 90))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel113)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel113)
                .addGap(9, 9, 9)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel112)
                                    .addComponent(jLabel60))
                                .addGap(8, 8, 8)
                                .addComponent(cbQualCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbCursoIntensivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel136)
                            .addComponent(jLabel137))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbDiasIntensivo)
                            .addComponent(txPendenteIntensivo)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel80)
                            .addComponent(jLabel107))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCBO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbLocalAprendizagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel97)
                                .addGap(6, 6, 6)
                                .addComponent(cbDiaCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61)
                            .addComponent(jLabel62))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel109)
                    .addComponent(txIntensPeriodo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbHorasTrabalhadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel110)
                    .addComponent(txIntensPeriodo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel111)
                    .addComponent(txIntensPeriodo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbOrigemAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Curso de Aprendizagem", jPanel24);

        txPort1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txPort1FocusGained(evt);
            }
        });
        txPort1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPort1ActionPerformed(evt);
            }
        });
        txPort1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txPort1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txPort1KeyReleased(evt);
            }
        });

        jLabel39.setText("L.P.");

        jLabel40.setText("MAT");

        txMat1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txMat1FocusGained(evt);
            }
        });
        txMat1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txMat1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txMat1KeyReleased(evt);
            }
        });

        jLabel41.setText("RED");

        txRed1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txRed1FocusGained(evt);
            }
        });
        txRed1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txRed1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txRed1KeyReleased(evt);
            }
        });

        jLabel42.setText("INF");

        txInf1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txInf1FocusGained(evt);
            }
        });
        txInf1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txInf1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txInf1KeyReleased(evt);
            }
        });

        jLabel43.setText("Média");

        txMedia1.setEditable(false);

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setText("1ª");

        jLabel46.setText("L.P.");

        txPort2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txPort2FocusGained(evt);
            }
        });
        txPort2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txPort2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txPort2KeyReleased(evt);
            }
        });

        jLabel67.setText("L.P.");

        txPort3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txPort3FocusGained(evt);
            }
        });
        txPort3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txPort3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txPort3KeyReleased(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setText("2ª");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setText("3ª");

        jLabel47.setText("MAT");

        jLabel66.setText("MAT");

        jLabel48.setText("INF");

        jLabel65.setText("INF");

        txMat2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txMat2FocusGained(evt);
            }
        });
        txMat2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txMat2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txMat2KeyReleased(evt);
            }
        });

        txInf2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txInf2FocusGained(evt);
            }
        });
        txInf2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txInf2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txInf2KeyReleased(evt);
            }
        });

        txMat3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txMat3FocusGained(evt);
            }
        });
        txMat3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txMat3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txMat3KeyReleased(evt);
            }
        });

        txInf3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txInf3FocusGained(evt);
            }
        });
        txInf3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txInf3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txInf3KeyReleased(evt);
            }
        });

        jLabel54.setText("RED");

        jLabel59.setText("RED");

        txRed3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txRed3FocusGained(evt);
            }
        });
        txRed3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txRed3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txRed3KeyReleased(evt);
            }
        });

        txRed2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txRed2FocusGained(evt);
            }
        });
        txRed2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txRed2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txRed2KeyReleased(evt);
            }
        });

        jLabel55.setText("Atitudes");

        txAtit2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txAtit2FocusGained(evt);
            }
        });
        txAtit2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txAtit2KeyPressed(evt);
            }
        });

        jLabel58.setText("Atitudes");

        txAtit3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txAtit3FocusGained(evt);
            }
        });
        txAtit3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txAtit3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txAtit3KeyReleased(evt);
            }
        });

        txMedia2.setEditable(false);

        jLabel56.setText("Média");

        jLabel57.setText("Média");

        txMedia3.setEditable(false);

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel82.setText("4ª");

        txPort4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txPort4FocusGained(evt);
            }
        });
        txPort4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txPort4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txPort4KeyReleased(evt);
            }
        });

        jLabel108.setText("L.P.");

        jLabel114.setText("MAT");

        txMat4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txMat4FocusGained(evt);
            }
        });
        txMat4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txMat4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txMat4KeyReleased(evt);
            }
        });

        txInf4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txInf4FocusGained(evt);
            }
        });
        txInf4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txInf4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txInf4KeyReleased(evt);
            }
        });

        jLabel115.setText("INF");

        jLabel121.setText("RED");

        txRed4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txRed4FocusGained(evt);
            }
        });
        txRed4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txRed4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txRed4KeyReleased(evt);
            }
        });

        jLabel122.setText("Atitudes");

        txAtit4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txAtit4FocusGained(evt);
            }
        });
        txAtit4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txAtit4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txAtit4KeyReleased(evt);
            }
        });

        jLabel123.setText("Média");

        txMedia4.setEditable(false);

        jLabel124.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel124.setText("5ª");

        txPort5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txPort5FocusGained(evt);
            }
        });
        txPort5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txPort5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txPort5KeyReleased(evt);
            }
        });

        jLabel125.setText("L.P.");

        jLabel126.setText("MAT");

        txMat5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txMat5FocusGained(evt);
            }
        });
        txMat5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txMat5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txMat5KeyReleased(evt);
            }
        });

        txInf5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txInf5FocusGained(evt);
            }
        });
        txInf5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txInf5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txInf5KeyReleased(evt);
            }
        });

        jLabel127.setText("INF");

        jLabel133.setText("RED");

        txRed5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txRed5FocusGained(evt);
            }
        });
        txRed5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txRed5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txRed5KeyReleased(evt);
            }
        });

        jLabel134.setText("Atitudes");

        txAtit5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txAtit5FocusGained(evt);
            }
        });
        txAtit5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txAtit5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txAtit5KeyReleased(evt);
            }
        });

        jLabel135.setText("Média");

        txMedia5.setEditable(false);

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Projetos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        jLabel68.setText("Empresa Virtual");

        jLabel69.setText("Cargo Virtual");

        txNotaCargoVirt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txNotaCargoVirtFocusGained(evt);
            }
        });
        txNotaCargoVirt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txNotaCargoVirtKeyReleased(evt);
            }
        });

        jLabel23.setText("Nota");

        txVotoConsciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txVotoConscienteKeyReleased(evt);
            }
        });

        jLabel24.setText("Voto consciente");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txVotoConsciente)
                    .addComponent(cbEmpresaVirtual, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbCargoVirtual, 0, 130, Short.MAX_VALUE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txNotaCargoVirt)))
                    .addComponent(jLabel24))
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txNotaCargoVirt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEmpresaVirtual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCargoVirtual, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addGap(6, 6, 6)
                .addComponent(txVotoConsciente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel45)))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel44)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txPort1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(txPort2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67)
                    .addComponent(txPort3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel108)
                    .addComponent(txPort4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel125)
                    .addComponent(txPort5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txMat1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel66)
                            .addComponent(txMat3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel114)
                            .addComponent(txMat4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel126)
                            .addComponent(txMat5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txInf4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel115)
                            .addComponent(txInf5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel127)
                            .addComponent(txRed1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txInf3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel65)))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(txMat2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(txInf2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(txInf1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54)
                    .addComponent(txRed2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59)
                    .addComponent(txRed3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel121)
                    .addComponent(txRed4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel133)
                    .addComponent(txRed5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(txMedia1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55)
                    .addComponent(txAtit2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58)
                    .addComponent(txAtit3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel122)
                    .addComponent(txAtit4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel134)
                    .addComponent(txAtit5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56)
                    .addComponent(jLabel57)
                    .addComponent(txMedia2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txMedia3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel123)
                    .addComponent(txMedia4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel135)
                    .addComponent(txMedia5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41)
                            .addComponent(jLabel42)
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txPort1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txMat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txRed1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txInf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txMedia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jLabel55)
                    .addComponent(jLabel56))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txPort2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txMat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txInf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txRed2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txAtit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txMedia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel67)
                            .addComponent(jLabel66)
                            .addComponent(jLabel65))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(txPort3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txMat3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txInf3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59)
                            .addComponent(jLabel58)
                            .addComponent(jLabel57))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txRed3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txAtit3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txMedia3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel108)
                    .addComponent(jLabel114)
                    .addComponent(jLabel115)
                    .addComponent(jLabel121)
                    .addComponent(jLabel122)
                    .addComponent(jLabel123))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(txPort4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txMat4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txInf4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txRed4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txAtit4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txMedia4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel125)
                    .addComponent(jLabel126)
                    .addComponent(jLabel127)
                    .addComponent(jLabel133)
                    .addComponent(jLabel134)
                    .addComponent(jLabel135))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel124)
                    .addComponent(txPort5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txMat5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txInf5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txRed5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txAtit5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txMedia5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 51, Short.MAX_VALUE))
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel48))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel47))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel46))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel44)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Notas", jPanel25);

        jToolBar7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar7.setRollover(true);

        btCertificadoAprendiz.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btCertificadoAprendiz.setText("Certificado aprendiz");
        btCertificadoAprendiz.setFocusable(false);
        btCertificadoAprendiz.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCertificadoAprendiz.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCertificadoAprendiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCertificadoAprendizActionPerformed(evt);
            }
        });
        jToolBar7.add(btCertificadoAprendiz);

        btCertificadoAspirante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btCertificadoAspirante.setText("Certificado aspirante");
        btCertificadoAspirante.setFocusable(false);
        btCertificadoAspirante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCertificadoAspirante.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCertificadoAspirante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCertificadoAspiranteActionPerformed(evt);
            }
        });
        jToolBar7.add(btCertificadoAspirante);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setText("Verso Certificado (todos)");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar7.add(jButton7);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(769, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jToolBar7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Certificados", jPanel26);

        jToolBar6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar6.setRollover(true);

        btPreparatorio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btPreparatorio.setText("Preparatório");
        btPreparatorio.setFocusable(false);
        btPreparatorio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btPreparatorio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btPreparatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPreparatorioActionPerformed(evt);
            }
        });
        jToolBar6.add(btPreparatorio);

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton8.setText("Preparatório com assinatura");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar6.add(jButton8);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setText("Aprendizagem ");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar6.add(jButton6);

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton9.setText("Aprendizagem com assinatura");
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar6.add(jButton9);

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton14.setText("Avaliação empresa");
        jButton14.setFocusable(false);
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jToolBar6.add(jButton14);

        btSaida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btSaida.setText("Aut. Saída");
        btSaida.setFocusable(false);
        btSaida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSaida.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaidaActionPerformed(evt);
            }
        });
        jToolBar6.add(btSaida);

        jToolBar5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar5.setRollover(true);

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton10.setText("Lista de presença");
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jToolBar5.add(jButton10);

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton11.setText("Declaração");
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jToolBar5.add(jButton11);

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton12.setText("Ocorrências");
        jButton12.setFocusable(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jToolBar5.add(jButton12);

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton13.setText("Advertência");
        jButton13.setFocusable(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jToolBar5.add(jButton13);

        btAvalAspirante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btAvalAspirante.setText("Avaliação aspirante");
        btAvalAspirante.setFocusable(false);
        btAvalAspirante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAvalAspirante.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btAvalAspirante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAvalAspiranteActionPerformed(evt);
            }
        });
        jToolBar5.add(btAvalAspirante);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("Aprendizagem teórica");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar5.add(jButton5);

        jcbSalas.setSelected(true);
        jcbSalas.setText("Salas");

        jcbTurma.setText("Turma");

        jToolBar8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar8.setRollover(true);

        jButton15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton15.setText("Lista de presença diária");
        jButton15.setFocusable(false);
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jToolBar8.add(jButton15);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToolBar6, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToolBar8, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jcbSalas)
                        .addGap(18, 18, 18)
                        .addComponent(jcbTurma)))
                .addContainerGap(433, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbTurma)
                    .addComponent(jcbSalas))
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar6, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar8, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Relatórios", jPanel6);

        jLabel83.setText("Admissão");

        jLabel84.setText("Rescisão");

        jLabel89.setText("Empresa");

        jcb2Fase.setText("jCheckBox1");
        jcb2Fase.setEnabled(false);

        jLabel52.setText("Carga horária ");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEmpAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcdDataAdmissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcdDataRescisao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcdDataInclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel104))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDiaAtivTeorica, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel105))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel106)
                            .addComponent(jcdTerminoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jcb2Fase)
                        .addComponent(jcbCadIrregular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbCargaHoraria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel52))
                .addGap(85, 85, 85))
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel83)
                            .addComponent(jLabel84))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcdDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcdDataRescisao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel89)
                        .addGap(6, 6, 6)
                        .addComponent(cbEmpAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jcb2Fase)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbCadIrregular)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel104)
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcdDataInclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel105)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbDiaAtivTeorica, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel106)
                            .addComponent(jLabel52))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbCargaHoraria)
                            .addComponent(jcdTerminoContrato, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Pedagógico", jPanel23);

        txDependente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txDependenteKeyReleased(evt);
            }
        });

        jLabel78.setText("Dependente");

        btIncluirDep.setText("Incluir");
        btIncluirDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirDepActionPerformed(evt);
            }
        });

        btRemoverDp.setText("Remover");
        btRemoverDp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverDpActionPerformed(evt);
            }
        });

        tbDependente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Idade", "Sexo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tbDependente);

        jLabel76.setText("Idade");

        cbSexoDependente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FEMININO", "MASCULINO" }));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel78)
                            .addComponent(txDependente, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(txIdadeDp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSexoDependente, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btIncluirDep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRemoverDp, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel78)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel76)
                        .addGap(1, 1, 1)))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txDependente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txIdadeDp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSexoDependente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btIncluirDep, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btRemoverDp, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(287, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dependentes", jPanel14);

        jLabel73.setText("Empresa");

        jLabel74.setText("Data");

        jLabel75.setText("Horário");

        btIncluirEntrevista.setText("Incluir");
        btIncluirEntrevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirEntrevistaActionPerformed(evt);
            }
        });

        btRmover.setText("Remover");
        btRmover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRmoverActionPerformed(evt);
            }
        });

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
        jScrollPane6.setViewportView(tbEmpresaEntrevista);

        btEncaminhamento.setText("Encaminhar");
        btEncaminhamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEncaminhamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel73)
                            .addComponent(cbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcdDataEntrevista, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel74))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel75)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(txHorarioEntrevista, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btIncluirEntrevista)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btRmover, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btEncaminhamento)))
                        .addGap(0, 153, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel74)
                            .addComponent(jLabel75))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcdDataEntrevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txHorarioEntrevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btRmover)
                            .addComponent(btIncluirEntrevista)
                            .addComponent(btEncaminhamento)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(311, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Entrevista", jPanel13);

        jPanel17.setLayout(null);

        txSalario.setEditable(false);
        txSalario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txSalarioKeyReleased(evt);
            }
        });
        jPanel17.add(txSalario);
        txSalario.setBounds(740, 30, 70, 32);

        jLabel85.setText("Salário");
        jPanel17.add(jLabel85);
        jLabel85.setBounds(740, 10, 120, 14);

        jLabel79.setText("Tipo de admissão");
        jPanel17.add(jLabel79);
        jLabel79.setBounds(485, 11, 200, 14);

        jPanel17.add(cbTipoAdimissao);
        cbTipoAdimissao.setBounds(489, 31, 240, 32);

        jcbInsalubre.setText("Insalubre");
        jcbInsalubre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbInsalubreActionPerformed(evt);
            }
        });
        jPanel17.add(jcbInsalubre);
        jcbInsalubre.setBounds(740, 110, 190, 23);

        jcbConvenioOdontologico.setText("Convenio odontológico");
        jPanel17.add(jcbConvenioOdontologico);
        jcbConvenioOdontologico.setBounds(740, 70, 230, 23);

        jcbVt.setText("Desconto V.T.");
        jPanel17.add(jcbVt);
        jcbVt.setBounds(740, 90, 230, 23);

        txPerctInsalubridade.setText("0");
        txPerctInsalubridade.setToolTipText("");
        txPerctInsalubridade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txPerctInsalubridadeKeyReleased(evt);
            }
        });
        jPanel17.add(txPerctInsalubridade);
        txPerctInsalubridade.setBounds(740, 140, 62, 30);

        jLabel77.setText("% Insalub.");
        jPanel17.add(jLabel77);
        jLabel77.setBounds(810, 150, 60, 20);

        btConfirmaAdmissao.setText("Confirma");
        btConfirmaAdmissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmaAdmissaoActionPerformed(evt);
            }
        });
        jPanel17.add(btConfirmaAdmissao);
        btConfirmaAdmissao.setBounds(700, 420, 110, 23);

        btCancelaAdmissao.setText("cancela ");
        jPanel17.add(btCancelaAdmissao);
        btCancelaAdmissao.setBounds(811, 420, 100, 23);

        btCalculaSalario.setText("Calc.");
        btCalculaSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalculaSalarioActionPerformed(evt);
            }
        });
        jPanel17.add(btCalculaSalario);
        btCalculaSalario.setBounds(820, 30, 70, 30);

        jToolBar1.setRollover(true);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Contrato");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        btRegEmpregado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btRegEmpregado.setText("Registro de Empregado");
        btRegEmpregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegEmpregadoActionPerformed(evt);
            }
        });
        jToolBar1.add(btRegEmpregado);

        jPanel17.add(jToolBar1);
        jToolBar1.setBounds(10, 290, 389, 20);

        jTabbedPane3.addTab("Dados", jPanel17);

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel86.setText("CURSO DE APRENDIZAGEM POR CBO");

        jToolBar2.setBorder(null);
        jToolBar2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar2.setRollover(true);

        btFichaAuxAdm.setText("Aux. Administrativo CBO 4510-05");
        btFichaAuxAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFichaAuxAdmActionPerformed(evt);
            }
        });
        jToolBar2.add(btFichaAuxAdm);

        btAssAdm.setText("Assist.Adm CBO 4510-10");
        btAssAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAssAdmActionPerformed(evt);
            }
        });
        jToolBar2.add(btAssAdm);

        btComercio.setText("Com. e Varejo CBO 5211-10");
        btComercio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComercioActionPerformed(evt);
            }
        });
        jToolBar2.add(btComercio);

        jButton3.setText("Aliment. Linha de prod. CBO 7842-05");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton3);

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel87.setText("ARCO");

        jToolBar3.setBorder(null);
        jToolBar3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar3.setRollover(true);

        btArco.setText("Arco de Serv. Adm. CBO 4510-05");
        btArco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btArcoActionPerformed(evt);
            }
        });
        jToolBar3.add(btArco);

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel88.setText("CONTRATO PEDAGÓGICO");

        jToolBar4.setBorder(null);
        jToolBar4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar4.setRollover(true);

        btAux2.setText("Aux. Administrativo CBO 4510-05");
        btAux2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAux2ActionPerformed(evt);
            }
        });
        jToolBar4.add(btAux2);

        btAssAdm2.setText("Assist.Adm CBO 4510-10");
        btAssAdm2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAssAdm2ActionPerformed(evt);
            }
        });
        jToolBar4.add(btAssAdm2);

        btComercio1.setText("Com. e Varejo CBO 5211-10");
        btComercio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComercio1ActionPerformed(evt);
            }
        });
        jToolBar4.add(btComercio1);

        jButton4.setText("Aliment. Linha de prod. CBO 7842-05");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton4);

        btArco1.setText("Arco de Serv. Adm. CBO 4510-05");
        btArco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btArco1ActionPerformed(evt);
            }
        });
        jToolBar4.add(btArco1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel86)
                        .addGap(123, 123, 123)
                        .addComponent(jLabel87))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel88))
                .addContainerGap(362, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(jLabel87)
                    .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(247, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Ficha de Matrícula", jPanel4);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1118, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Contrato", jPanel19);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1118, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Registro de empregado", jPanel20);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Carta do banco");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(960, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addContainerGap(425, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Banco", jPanel21);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3))
        );

        jTabbedPane1.addTab("Admissão", jPanel16);

        taPedagogicas.setColumns(20);
        taPedagogicas.setRows(5);
        jScrollPane1.setViewportView(taPedagogicas);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Pedagógicas", jPanel8);

        taSociais.setColumns(20);
        taSociais.setRows(5);
        jScrollPane2.setViewportView(taSociais);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Sociais", jPanel9);

        taPsicologicas.setColumns(20);
        taPsicologicas.setRows(5);
        jScrollPane3.setViewportView(taPsicologicas);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Psicológicas", jPanel10);

        taAdministrativa.setColumns(20);
        taAdministrativa.setRows(5);
        jScrollPane4.setViewportView(taAdministrativa);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Administrativas", jPanel11);

        taObservacao.setColumns(20);
        taObservacao.setRows(5);
        jScrollPane5.setViewportView(taObservacao);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Observação", jPanel12);

        taRecrutamento.setColumns(20);
        taRecrutamento.setRows(5);
        jScrollPane8.setViewportView(taRecrutamento);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Recrutamento e seleção", jPanel22);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(296, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Anotações Diversas", jPanel7);

        jLabel1.setText("Código");

        jLabel2.setText("RGM");

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

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FEMININO", "MASCULINO" }));

        jLabel5.setText("Sexo");

        jLabel17.setText("Baixa");

        txNomeMae.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txNomeMaeKeyReleased(evt);
            }
        });

        jLabel12.setText("Nome da mãe");

        txNomePai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNomePaiActionPerformed(evt);
            }
        });
        txNomePai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txNomePaiKeyReleased(evt);
            }
        });

        jLabel14.setText("Nome do pai");

        jLabel13.setText("RG mãe");

        jLabel15.setText("RG do pai");

        jLabel10.setText("Nascimento");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagem.setText("foto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar_foto.png"))); // NOI18N
        btFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFotoActionPerformed(evt);
            }
        });

        btRemoverImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LIxo_foto.png"))); // NOI18N
        btRemoverImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverImagemActionPerformed(evt);
            }
        });

        jLabel22.setText("Data de emissão");

        jLabel7.setText("RG");

        txRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txRgActionPerformed(evt);
            }
        });

        txCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCpfActionPerformed(evt);
            }
        });

        jLabel8.setText("CPF");

        txLocalNascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txLocalNascimentoKeyReleased(evt);
            }
        });

        txUfLocalNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txUfLocalNascimentoActionPerformed(evt);
            }
        });
        txUfLocalNascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txUfLocalNascimentoKeyReleased(evt);
            }
        });

        jLabel35.setText("UF Nasc.");

        jLabel27.setText("Local de nascimento");

        jLabel101.setText("CTPS");

        txSerieUfCtps.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txSerieUfCtpsKeyReleased(evt);
            }
        });

        jLabel103.setText("Série/UF");

        jLabel95.setText("PIS");

        jLabel18.setText("Tel residencial");

        jLabel19.setText("Tel recado");

        jLabel34.setText("CEP");

        btPesquisaCep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Zoom.png"))); // NOI18N
        btPesquisaCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaCepActionPerformed(evt);
            }
        });

        txLogradouro.setEditable(false);

        jLabel28.setText("Logradouro");

        jLabel29.setText("Número");

        jLabel30.setText("Complemento");

        txBairro.setEditable(false);

        jLabel31.setText("Bairro");

        txMunicipio.setEditable(false);
        txMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txMunicipioActionPerformed(evt);
            }
        });

        jLabel32.setText("Município");

        txEnderecoUF.setEditable(false);

        jLabel33.setText("UF");

        jLabel20.setText("Cel pessoal");

        jLabel21.setText("WhatsApp");

        jLabel102.setText("Data de emissão");

        jLabel37.setText("E-mail");

        txBanco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txBancoKeyReleased(evt);
            }
        });

        jLabel49.setText("N° da Conta");

        jLabel50.setText("Agêcia");

        jLabel51.setText("Banco");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txRgMae, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txRgPai, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txRGM, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(54, 54, 54)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(txTel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(txTel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txTel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(52, 52, 52)
                                .addComponent(jLabel19)
                                .addGap(81, 81, 81)
                                .addComponent(jLabel20)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txTel4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addGap(278, 278, 278)
                                        .addComponent(jLabel32)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel33))
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel34)
                                            .addComponent(txCep, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6)
                                        .addComponent(btPesquisaCep)
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel28)
                                            .addComponent(txLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(txNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(txBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txEnderecoUF, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(txComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(btRemoverImagem)
                                .addGap(25, 25, 25)
                                .addComponent(btFoto))
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcdBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(108, 108, 108)
                                .addComponent(jLabel27))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jcdDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txLocalNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(txUfLocalNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel101)
                                .addGap(138, 138, 138)
                                .addComponent(jLabel103)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel102))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txCtps)
                                        .addComponent(txNumeroConta, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                                    .addComponent(jLabel49))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel50)
                                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel18Layout.createSequentialGroup()
                                            .addComponent(txSerieUfCtps, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(6, 6, 6)
                                            .addComponent(jcdDataEmissaoCTPS, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txAgencia)))))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel95)
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txPis)
                                .addComponent(txBanco, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                            .addComponent(jLabel51)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(238, 238, 238)
                        .addComponent(jLabel7)
                        .addGap(119, 119, 119)
                        .addComponent(jLabel22))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(txCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(txRg, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jcdEmissaoRg, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addComponent(jLabel12)
                                .addGap(6, 6, 6)
                                .addComponent(txNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel14)
                                .addGap(6, 6, 6)
                                .addComponent(txNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txRGM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addComponent(jLabel13)
                                .addGap(6, 6, 6)
                                .addComponent(txRgMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel15)
                                .addGap(6, 6, 6)
                                .addComponent(txRgPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel34)
                                .addGap(6, 6, 6)
                                .addComponent(txCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btPesquisaCep))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel28)
                                .addGap(6, 6, 6)
                                .addComponent(txLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel29)
                                .addGap(6, 6, 6)
                                .addComponent(txNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel30)
                                .addGap(6, 6, 6)
                                .addComponent(txComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txEnderecoUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel37)))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txTel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txTel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txTel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txTel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel7))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel22))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcdEmissaoRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel27)))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcdDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txLocalNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txUfLocalNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel102)
                                    .addComponent(jLabel103)
                                    .addComponent(jLabel95)
                                    .addComponent(jLabel101)))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel35))))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btRemoverImagem)
                            .addComponent(btFoto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcdBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcdDataEmissaoCTPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txCtps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txSerieUfCtps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txPis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50)
                    .addComponent(jLabel51))
                .addGap(3, 3, 3)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txNumeroConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Dados Cadastrais", jPanel18);

        lbNomeApresentacao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbNomeApresentacao.setForeground(new java.awt.Color(255, 0, 51));
        lbNomeApresentacao.setText("nomeAluno");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo transparente.png"))); // NOI18N

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

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Lupa.png"))); // NOI18N
        btPesquisar.setText("    ");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATIVO", "INATIVO" }));
        cbSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSituacaoActionPerformed(evt);
            }
        });

        jLabel36.setText("Situação");

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CURSO PREPARATORIO", "APRENDIZAGEM" }));
        cbStatus.setToolTipText("");
        cbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusActionPerformed(evt);
            }
        });

        jLabel138.setText("Status");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(lbNomeApresentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel138))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1022, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(288, 288, 288)
                                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbNomeApresentacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(btPesquisar))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel36)
                                .addComponent(jLabel138))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbStatus)
                                .addComponent(cbSituacao)))))
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btNovo)
                        .addComponent(btSalvar)
                        .addComponent(btAlterar)
                        .addComponent(btCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 1068, 712);
    }// </editor-fold>//GEN-END:initComponents

    private void txCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txCpfActionPerformed

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

    private void txMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txMunicipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txMunicipioActionPerformed

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

        if (txCpf.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Necessário informar o CPF", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
        } else if (salvarAlterar.equals("novo")) {
            salvar();
            habilitaCampo(false);
            limpaCampos();
            //  salvarImagem();
            btAlterar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSalvar.setEnabled(false);
            btNovo.setEnabled(true);
            btPesquisar.setEnabled(true);
            lbNomeApresentacao.setText("");
        } else if (salvarAlterar.equals("alterar")) {

            alterar();
            habilitaCampo(false);
            limpaCampos();
            //          salvarImagem();
            btAlterar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSalvar.setEnabled(false);
            btNovo.setEnabled(true);
            btPesquisar.setEnabled(true);
            lbNomeApresentacao.setText("");
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        salvarAlterar = "alterar";
        habilitaCampo(true);
        btPesquisar.setEnabled(false);
        btNovo.setEnabled(false);
        btAlterar.setEnabled(false);
        btSalvar.setEnabled(true);
        btCancelar.setEnabled(true);
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        habilitaCampo(false);
        btAlterar.setEnabled(false);
        btCancelar.setEnabled(false);
        btSalvar.setEnabled(false);
        btNovo.setEnabled(true);
        btPesquisar.setEnabled(true);
        lbNomeApresentacao.setText("");
        limpaCampos();
        salvarAlterar = "";
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        ViewPesquisaAluno viewPesquisaAluno = new ViewPesquisaAluno(this, rootPaneCheckingEnabled);
        viewPesquisaAluno.setVisible(true);
        codigoAluno = viewPesquisaAluno.getReturnStatus();
        carregarAlunos(codigoAluno);
        //limparVariavelImagem();
        // btPesquisar.setEnabled(false);
        btAlterar.setEnabled(true);
        btCancelar.setEnabled(true);
        btNovo.setEnabled(false);
    }//GEN-LAST:event_btPesquisarActionPerformed

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

    private void txPort1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPort1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPort1ActionPerformed

    private void txPort1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPort1KeyReleased
        this.txPort1.setText(new BLMascaras().converterVirgulaParaPonto(this.txPort1.getText()));

        calculaMedia1();

    }//GEN-LAST:event_txPort1KeyReleased

    private void txPort1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPort1KeyPressed
//        this.txPort1.setText(new BLMascaras().converterVirgulaParaPonto(this.txPort1.getText()));
        //      calculaMedia1();

    }//GEN-LAST:event_txPort1KeyPressed

    private void txMat1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMat1KeyReleased
        this.txMat1.setText(new BLMascaras().converterVirgulaParaPonto(this.txMat1.getText()));
        calculaMedia1();

    }//GEN-LAST:event_txMat1KeyReleased

    private void txMat1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMat1KeyPressed


    }//GEN-LAST:event_txMat1KeyPressed

    private void txRed1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRed1KeyReleased
        this.txRed1.setText(new BLMascaras().converterVirgulaParaPonto(this.txRed1.getText()));
        calculaMedia1();

    }//GEN-LAST:event_txRed1KeyReleased

    private void txRed1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRed1KeyPressed


    }//GEN-LAST:event_txRed1KeyPressed

    private void txInf1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txInf1KeyReleased
        this.txInf1.setText(new BLMascaras().converterVirgulaParaPonto(this.txInf1.getText()));
        calculaMedia1();

    }//GEN-LAST:event_txInf1KeyReleased

    private void txInf1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txInf1KeyPressed


    }//GEN-LAST:event_txInf1KeyPressed

    private void txPort2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPort2KeyReleased
        this.txPort2.setText(new BLMascaras().converterVirgulaParaPonto(this.txPort2.getText()));
        calculaMedia2();

    }//GEN-LAST:event_txPort2KeyReleased

    private void txPort2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPort2KeyPressed


    }//GEN-LAST:event_txPort2KeyPressed

    private void txMat2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMat2KeyPressed


    }//GEN-LAST:event_txMat2KeyPressed

    private void txMat2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMat2KeyReleased
        this.txMat2.setText(new BLMascaras().converterVirgulaParaPonto(this.txMat2.getText()));
        calculaMedia2();

    }//GEN-LAST:event_txMat2KeyReleased

    private void txInf2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txInf2KeyPressed


    }//GEN-LAST:event_txInf2KeyPressed

    private void txInf2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txInf2KeyReleased
        this.txInf2.setText(new BLMascaras().converterVirgulaParaPonto(this.txInf2.getText()));
        calculaMedia2();

    }//GEN-LAST:event_txInf2KeyReleased

    private void txRed2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRed2KeyPressed

    }//GEN-LAST:event_txRed2KeyPressed

    private void txRed2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRed2KeyReleased
        this.txRed2.setText(new BLMascaras().converterVirgulaParaPonto(this.txRed2.getText()));
        calculaMedia2();

    }//GEN-LAST:event_txRed2KeyReleased

    private void txAtit2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txAtit2KeyPressed


    }//GEN-LAST:event_txAtit2KeyPressed

    private void txPort3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPort3KeyPressed

    }//GEN-LAST:event_txPort3KeyPressed

    private void txPort3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPort3KeyReleased
        calculaMedia3();
        this.txPort3.setText(new BLMascaras().converterVirgulaParaPonto(this.txPort3.getText()));
    }//GEN-LAST:event_txPort3KeyReleased

    private void txMat3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMat3KeyPressed

    }//GEN-LAST:event_txMat3KeyPressed

    private void txMat3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMat3KeyReleased
        calculaMedia3();
        this.txMat3.setText(new BLMascaras().converterVirgulaParaPonto(this.txMat3.getText()));
    }//GEN-LAST:event_txMat3KeyReleased

    private void txInf3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txInf3KeyPressed

    }//GEN-LAST:event_txInf3KeyPressed

    private void txInf3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txInf3KeyReleased
        calculaMedia3();
        this.txInf3.setText(new BLMascaras().converterVirgulaParaPonto(this.txInf3.getText()));
    }//GEN-LAST:event_txInf3KeyReleased

    private void txRed3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRed3KeyPressed

    }//GEN-LAST:event_txRed3KeyPressed

    private void txRed3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRed3KeyReleased
        calculaMedia3();
        this.txRed3.setText(new BLMascaras().converterVirgulaParaPonto(this.txRed3.getText()));
    }//GEN-LAST:event_txRed3KeyReleased

    private void txAtit3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txAtit3KeyPressed

    }//GEN-LAST:event_txAtit3KeyPressed

    private void txAtit3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txAtit3KeyReleased
        calculaMedia3();
        this.txAtit3.setText(new BLMascaras().converterVirgulaParaPonto(this.txAtit3.getText()));
    }//GEN-LAST:event_txAtit3KeyReleased

    private void txMat1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txMat1FocusGained
        this.txMat1.selectAll();
    }//GEN-LAST:event_txMat1FocusGained

    private void txPort1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txPort1FocusGained
        this.txPort1.selectAll();
    }//GEN-LAST:event_txPort1FocusGained

    private void txRed1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txRed1FocusGained
        this.txRed1.selectAll();
    }//GEN-LAST:event_txRed1FocusGained

    private void txInf1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txInf1FocusGained
        this.txInf1.selectAll();
    }//GEN-LAST:event_txInf1FocusGained

    private void txPort2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txPort2FocusGained
        this.txPort2.selectAll();
    }//GEN-LAST:event_txPort2FocusGained

    private void txPort3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txPort3FocusGained
        this.txPort3.selectAll();
    }//GEN-LAST:event_txPort3FocusGained

    private void txMat2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txMat2FocusGained
        this.txMat2.selectAll();
    }//GEN-LAST:event_txMat2FocusGained

    private void txMat3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txMat3FocusGained
        this.txMat3.selectAll();
    }//GEN-LAST:event_txMat3FocusGained

    private void txInf2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txInf2FocusGained
        this.txInf2.selectAll();
    }//GEN-LAST:event_txInf2FocusGained

    private void txInf3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txInf3FocusGained
        this.txInf3.selectAll();
    }//GEN-LAST:event_txInf3FocusGained

    private void txRed2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txRed2FocusGained
        this.txRed2.selectAll();
    }//GEN-LAST:event_txRed2FocusGained

    private void txRed3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txRed3FocusGained
        this.txRed3.selectAll();
    }//GEN-LAST:event_txRed3FocusGained

    private void txAtit2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txAtit2FocusGained
        this.txAtit2.selectAll();
    }//GEN-LAST:event_txAtit2FocusGained

    private void txAtit3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txAtit3FocusGained
        this.txAtit3.selectAll();
    }//GEN-LAST:event_txAtit3FocusGained

    private void btIncluirEntrevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirEntrevistaActionPerformed
        adicionaEmpresa();
    }//GEN-LAST:event_btIncluirEntrevistaActionPerformed

    private void btRmoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRmoverActionPerformed
        removeItem();
        controllerEntrevistaAluno.excluirEntrevistaAlunoController(Integer.parseInt(txCodigo.getText()));

    }//GEN-LAST:event_btRmoverActionPerformed

    private void btEncaminhamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEncaminhamentoActionPerformed
        controllerAluno.gerarRelatorioEncaminhamento(Integer.parseInt(txCodigo.getText()));

    }//GEN-LAST:event_btEncaminhamentoActionPerformed

    private void btSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaidaActionPerformed
        ViewMotivoSaida viewMotivoSaida = new ViewMotivoSaida();
        viewMotivoSaida.setVisible(true);
        viewMotivoSaida.txCodigoAluno.setText(txCodigo.getText());
        viewMotivoSaida.txNome.setText(txNome.getText());

//        controllerAluno.gerarRelatorioSaida(Integer.parseInt(txCodigo.getText()));
    }//GEN-LAST:event_btSaidaActionPerformed

    private void btIncluirDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirDepActionPerformed
        adicionaDependente();
        txDependente.setText("");
        txIdadeDp.setText("");

    }//GEN-LAST:event_btIncluirDepActionPerformed

    private void btRemoverDpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverDpActionPerformed
        removeDependente();
    }//GEN-LAST:event_btRemoverDpActionPerformed

    private void jcbInsalubreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbInsalubreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbInsalubreActionPerformed

    private void txPerctInsalubridadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPerctInsalubridadeKeyReleased
        this.txPerctInsalubridade.setText(new BLMascaras().converterVirgulaParaPonto(this.txPerctInsalubridade.getText()));
    }//GEN-LAST:event_txPerctInsalubridadeKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        controllerAluno.gerarRelatorioContrato411005(Integer.parseInt(txCodigo.getText()));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        controllerAluno.gerarRelatorioContratoBanco(Integer.parseInt(txCodigo.getText()));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btFichaAuxAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFichaAuxAdmActionPerformed
        controllerAluno.gerarRelatorioFichaMatrAuxAdm(Integer.parseInt(txCodigo.getText()));
    }//GEN-LAST:event_btFichaAuxAdmActionPerformed

    private void btAssAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAssAdmActionPerformed
        controllerAluno.gerarRelatorioFichaMatrAssistAdm(Integer.parseInt(txCodigo.getText()));
    }//GEN-LAST:event_btAssAdmActionPerformed

    private void btComercioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComercioActionPerformed
        controllerAluno.gerarRelatorioFichaMatrComercio(Integer.parseInt(txCodigo.getText()));
    }//GEN-LAST:event_btComercioActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        controllerAluno.gerarRelatorioFichaMatrAlimentador(Integer.parseInt(txCodigo.getText()));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btArcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btArcoActionPerformed
        controllerAluno.gerarRelatorioFichaMatrArco(Integer.parseInt(txCodigo.getText()));
    }//GEN-LAST:event_btArcoActionPerformed

    private void btAux2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAux2ActionPerformed
        controllerAluno.gerarRelatorioFichaMatrAuxAdm2(Integer.parseInt(txCodigo.getText()));
    }//GEN-LAST:event_btAux2ActionPerformed

    private void btAssAdm2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAssAdm2ActionPerformed
        controllerAluno.gerarRelatorioFichaMatrAssistAdm2(Integer.parseInt(txCodigo.getText()));
    }//GEN-LAST:event_btAssAdm2ActionPerformed

    private void btComercio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComercio1ActionPerformed
        controllerAluno.gerarRelatorioFichaMatrComercio2(Integer.parseInt(txCodigo.getText()));
    }//GEN-LAST:event_btComercio1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        controllerAluno.gerarRelatorioFichaMatrAlimentador2(Integer.parseInt(txCodigo.getText()));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btArco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btArco1ActionPerformed
        controllerAluno.gerarRelatorioFichaMatrArco2(Integer.parseInt(txCodigo.getText()));
    }//GEN-LAST:event_btArco1ActionPerformed

    private void txSalarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSalarioKeyReleased
        //  this.txSalario.setText(new BLMascaras().converterVirgulaParaPonto(this.txSalario.getText()));
    }//GEN-LAST:event_txSalarioKeyReleased

    private void btConfirmaAdmissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmaAdmissaoActionPerformed
        salvarAdmissao();
    }//GEN-LAST:event_btConfirmaAdmissaoActionPerformed

    private void btRegEmpregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegEmpregadoActionPerformed
        controllerAluno.gerarRelatorioFichaRegistro(Integer.parseInt(txCodigo.getText()));
    }//GEN-LAST:event_btRegEmpregadoActionPerformed

    private void cbCBOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCBOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCBOActionPerformed

    private void cbHorasTrabalhadasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbHorasTrabalhadasKeyPressed

    }//GEN-LAST:event_cbHorasTrabalhadasKeyPressed

    private void cbHorasTrabalhadasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbHorasTrabalhadasKeyReleased

    }//GEN-LAST:event_cbHorasTrabalhadasKeyReleased

    private void btCalculaSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalculaSalarioActionPerformed
        calculaSalario();
    }//GEN-LAST:event_btCalculaSalarioActionPerformed

    private void btRemoverImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverImagemActionPerformed
        excluirImagem();
        //lblImagem.setIcon(null);
    }//GEN-LAST:event_btRemoverImagemActionPerformed

    private void btFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFotoActionPerformed
        selecionaImagem();
    }//GEN-LAST:event_btFotoActionPerformed

    private void txOlhosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txOlhosKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txOlhos.setText(txOlhos.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txOlhos.setText(blTiraAcentos.TiraAcentos(txOlhos.getText()));
    }//GEN-LAST:event_txOlhosKeyReleased

    private void txCabelosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCabelosKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txCabelos.setText(txCabelos.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txCabelos.setText(blTiraAcentos.TiraAcentos(txCabelos.getText()));
    }//GEN-LAST:event_txCabelosKeyReleased

    private void txCabelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCabelosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txCabelosActionPerformed

    private void txPesoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPesoKeyReleased
        this.txPeso.setText(new BLMascaras().converterVirgulaParaPonto(this.txPeso.getText()));
    }//GEN-LAST:event_txPesoKeyReleased

    private void txPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPesoActionPerformed

    private void txCorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCorKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txCor.setText(txCor.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txCor.setText(blTiraAcentos.TiraAcentos(txCor.getText()));
    }//GEN-LAST:event_txCorKeyReleased

    private void txAlturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txAlturaKeyReleased
        this.txAltura.setText(new BLMascaras().converterVirgulaParaPonto(this.txAltura.getText()));
    }//GEN-LAST:event_txAlturaKeyReleased

    private void txAlturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txAlturaFocusGained
        this.txAltura.selectAll();
    }//GEN-LAST:event_txAlturaFocusGained

    private void txEscolaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txEscolaKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txEscola.setText(txEscola.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txEscola.setText(blTiraAcentos.TiraAcentos(txEscola.getText()));
    }//GEN-LAST:event_txEscolaKeyReleased

    private void txNomePaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNomePaiKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txNomePai.setText(txNomePai.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txNomePai.setText(blTiraAcentos.TiraAcentos(txNomePai.getText()));
    }//GEN-LAST:event_txNomePaiKeyReleased

    private void txNomePaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNomePaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNomePaiActionPerformed

    private void txNomeMaeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNomeMaeKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txNomeMae.setText(txNomeMae.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txNomeMae.setText(blTiraAcentos.TiraAcentos(txNomeMae.getText()));
    }//GEN-LAST:event_txNomeMaeKeyReleased

    private void txResponsavelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txResponsavelKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txResponsavel.setText(txResponsavel.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txResponsavel.setText(blTiraAcentos.TiraAcentos(txResponsavel.getText()));
    }//GEN-LAST:event_txResponsavelKeyReleased

    private void cbSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSituacaoActionPerformed

    private void txCamisetaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCamisetaKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txCamiseta.setText(txCamiseta.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txCamiseta.setText(blTiraAcentos.TiraAcentos(txCamiseta.getText()));
    }//GEN-LAST:event_txCamisetaKeyReleased

    private void txCamisetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCamisetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txCamisetaActionPerformed

    private void txNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNomeKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txNome.setText(txNome.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txNome.setText(blTiraAcentos.TiraAcentos(txNome.getText()));
    }//GEN-LAST:event_txNomeKeyReleased

    private void txNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNomeActionPerformed

    private void cbEstCivil1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstCivil1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEstCivil1ActionPerformed

    private void txNacionalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNacionalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNacionalidadeActionPerformed

    private void txRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txRgActionPerformed

    private void txUfLocalNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txUfLocalNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txUfLocalNascimentoActionPerformed

    private void txPort4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txPort4FocusGained
        this.txPort4.selectAll();
    }//GEN-LAST:event_txPort4FocusGained

    private void txPort4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPort4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPort4KeyPressed

    private void txPort4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPort4KeyReleased
        this.txPort4.setText(new BLMascaras().converterVirgulaParaPonto(this.txPort4.getText()));
        calculaMedia4();        // TODO add your handling code here:
    }//GEN-LAST:event_txPort4KeyReleased

    private void txMat4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txMat4FocusGained
        this.txMat4.selectAll();
    }//GEN-LAST:event_txMat4FocusGained

    private void txMat4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMat4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txMat4KeyPressed

    private void txMat4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMat4KeyReleased
        this.txMat4.setText(new BLMascaras().converterVirgulaParaPonto(this.txMat4.getText()));
        calculaMedia4();
    }//GEN-LAST:event_txMat4KeyReleased

    private void txInf4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txInf4FocusGained
        this.txInf4.selectAll();
    }//GEN-LAST:event_txInf4FocusGained

    private void txInf4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txInf4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txInf4KeyPressed

    private void txInf4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txInf4KeyReleased
        this.txInf4.setText(new BLMascaras().converterVirgulaParaPonto(this.txInf4.getText()));
        calculaMedia4();
    }//GEN-LAST:event_txInf4KeyReleased

    private void txRed4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txRed4FocusGained
        this.txRed4.selectAll();
    }//GEN-LAST:event_txRed4FocusGained

    private void txRed4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRed4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txRed4KeyPressed

    private void txRed4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRed4KeyReleased
        this.txRed4.setText(new BLMascaras().converterVirgulaParaPonto(this.txRed4.getText()));
        calculaMedia4();
    }//GEN-LAST:event_txRed4KeyReleased

    private void txAtit4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txAtit4FocusGained
        this.txAtit4.selectAll();
    }//GEN-LAST:event_txAtit4FocusGained

    private void txAtit4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txAtit4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txAtit4KeyPressed

    private void txAtit4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txAtit4KeyReleased
        this.txAtit4.setText(new BLMascaras().converterVirgulaParaPonto(this.txAtit4.getText()));
        calculaMedia4();
    }//GEN-LAST:event_txAtit4KeyReleased

    private void txPort5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txPort5FocusGained
        this.txPort5.selectAll();
    }//GEN-LAST:event_txPort5FocusGained

    private void txPort5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPort5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPort5KeyPressed

    private void txPort5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPort5KeyReleased
        this.txPort5.setText(new BLMascaras().converterVirgulaParaPonto(this.txPort5.getText()));
        calculaMedia5();
    }//GEN-LAST:event_txPort5KeyReleased

    private void txMat5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txMat5FocusGained
        this.txMat5.selectAll();
    }//GEN-LAST:event_txMat5FocusGained

    private void txMat5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMat5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txMat5KeyPressed

    private void txMat5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMat5KeyReleased
        this.txMat5.setText(new BLMascaras().converterVirgulaParaPonto(this.txMat5.getText()));
        calculaMedia5();
    }//GEN-LAST:event_txMat5KeyReleased

    private void txInf5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txInf5FocusGained
        this.txInf5.selectAll();
    }//GEN-LAST:event_txInf5FocusGained

    private void txInf5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txInf5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txInf5KeyPressed

    private void txInf5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txInf5KeyReleased
        this.txInf5.setText(new BLMascaras().converterVirgulaParaPonto(this.txInf5.getText()));
        calculaMedia5();
    }//GEN-LAST:event_txInf5KeyReleased

    private void txRed5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txRed5FocusGained
        this.txRed5.selectAll();
    }//GEN-LAST:event_txRed5FocusGained

    private void txRed5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRed5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txRed5KeyPressed

    private void txRed5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRed5KeyReleased
        this.txRed5.setText(new BLMascaras().converterVirgulaParaPonto(this.txRed5.getText()));
        calculaMedia5();
    }//GEN-LAST:event_txRed5KeyReleased

    private void txAtit5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txAtit5FocusGained
        this.txAtit5.selectAll();
    }//GEN-LAST:event_txAtit5FocusGained

    private void txAtit5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txAtit5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txAtit5KeyPressed

    private void txAtit5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txAtit5KeyReleased
        this.txAtit5.setText(new BLMascaras().converterVirgulaParaPonto(this.txAtit5.getText()));
        calculaMedia5();
    }//GEN-LAST:event_txAtit5KeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (jcbSalas.isSelected() && !jcbTurma.isSelected()) {
            controllerAluno.gerarRelatorioAprendizagemSala((String) cbSalas.getSelectedItem());
        } else if (!jcbSalas.isSelected() && jcbTurma.isSelected()) {
            controllerAluno.gerarRelatorioAprendizagemTurma((String) cbTurma.getSelectedItem());

        } else {

            controllerAluno.gerarRelatorioAprendizagemGeral((String) cbSalas.getSelectedItem(), (String) cbTurma.getSelectedItem());
        }


    }//GEN-LAST:event_jButton6ActionPerformed

    private void btPreparatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPreparatorioActionPerformed

        if (jcbSalas.isSelected() && !jcbTurma.isSelected()) {
            controllerAluno.gerarRelatorioPreparatorioSala((String) cbSalas.getSelectedItem());
        } else if ((!jcbSalas.isSelected()) && (jcbTurma.isSelected())) {
            controllerAluno.gerarRelatorioPreparatorioTurma((String) cbTurma.getSelectedItem());

        } else {

            controllerAluno.gerarRelatorioPreparatorioGeral((String) cbSalas.getSelectedItem(), (String) cbTurma.getSelectedItem());
        }


    }//GEN-LAST:event_btPreparatorioActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (jcbSalas.isSelected() && !jcbTurma.isSelected()) {
            controllerAluno.gerarRelatorioAprendizagemAssSala((String) cbSalas.getSelectedItem());
        } else if (!jcbSalas.isSelected() && jcbTurma.isSelected()) {
            controllerAluno.gerarRelatorioAprendizagemAssTurma((String) cbTurma.getSelectedItem());

        } else {

            controllerAluno.gerarRelatorioAprendizagemAssGeral((String) cbSalas.getSelectedItem(), (String) cbTurma.getSelectedItem());
        }


    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        if (jcbSalas.isSelected() && !jcbTurma.isSelected()) {
            controllerAluno.gerarRelatoriopreparatorioAssSala((String) cbSalas.getSelectedItem());
        } else if (!jcbSalas.isSelected() && jcbTurma.isSelected()) {
            controllerAluno.gerarRelatoriopreparatorioAssTurma((String) cbTurma.getSelectedItem());

        } else {

            controllerAluno.gerarRelatoriopreparatorioAssGeral((String) cbSalas.getSelectedItem(), (String) cbTurma.getSelectedItem());
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (jcbSalas.isSelected() && !jcbTurma.isSelected()) {
            controllerAluno.gerarRelatorioListaChamadaSala((String) cbSalas.getSelectedItem());
        } else if (!jcbSalas.isSelected() && jcbTurma.isSelected()) {
            controllerAluno.gerarRelatorioListaChamadaTurma((String) cbTurma.getSelectedItem());

        } else {

            controllerAluno.gerarRelatorioListaChamadaAmbos((String) cbSalas.getSelectedItem(), (String) cbTurma.getSelectedItem());
        }


    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        controllerAluno.gerarRelatorioDeclaracao(Integer.parseInt(txCodigo.getText()));
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (jcbSalas.isSelected() && !jcbTurma.isSelected()) {
            controllerAluno.gerarRelatorioOcorrenciaSala((String) cbSalas.getSelectedItem());
        } else if (!jcbSalas.isSelected() && jcbTurma.isSelected()) {
            controllerAluno.gerarRelatorioOcorrenciaTurma((String) cbTurma.getSelectedItem());

        } else {

            controllerAluno.gerarRelatorioOcorrenciaAmbos((String) cbSalas.getSelectedItem(), (String) cbTurma.getSelectedItem());
        }


    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        ViewMotivoAdvertencia viewMotivoAdvertencia = new ViewMotivoAdvertencia();
        viewMotivoAdvertencia.setVisible(true);
        viewMotivoAdvertencia.txCodigoAluno.setText(txCodigo.getText());
        viewMotivoAdvertencia.txNome.setText(txNome.getText());
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (jcbSalas.isSelected() && !jcbTurma.isSelected()) {
            controllerAluno.gerarRelatorioAvaliacaoSala((String) cbSalas.getSelectedItem());
        } else if (!jcbSalas.isSelected() && jcbTurma.isSelected()) {
            controllerAluno.gerarRelatorioAvaliacaoTurma((String) cbTurma.getSelectedItem());

        } else {

            controllerAluno.gerarRelatorioAvaliacaoAmbos((String) cbSalas.getSelectedItem(), (String) cbTurma.getSelectedItem());
        }


    }//GEN-LAST:event_jButton14ActionPerformed

    private void cbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbStatusActionPerformed

    private void jcbCadIrregularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbCadIrregularMouseClicked

        if (jcbCadIrregular.isSelected()) {
            jcbCadIrregular.setForeground(Color.red);
        } else {
            jcbCadIrregular.setForeground(Color.black);
        }


    }//GEN-LAST:event_jcbCadIrregularMouseClicked

    private void jcbCadIrregularMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbCadIrregularMouseExited

    }//GEN-LAST:event_jcbCadIrregularMouseExited

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new ViewVersoCertificado().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txBancoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txBancoKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txBanco.setText(txBanco.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txBanco.setText(blTiraAcentos.TiraAcentos(txBanco.getText()));
    }//GEN-LAST:event_txBancoKeyReleased

    private void txSinaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSinaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txSinaisActionPerformed

    private void btCertificadoAprendizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCertificadoAprendizActionPerformed
        controllerAluno.gerarRelatorioCertificadoAprendiz(Integer.parseInt(txCodigo.getText()));
    }//GEN-LAST:event_btCertificadoAprendizActionPerformed

    private void txEscolaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txEscolaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txEscolaKeyPressed

    private void txNacionalidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNacionalidadeKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txNacionalidade.setText(txNacionalidade.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txNacionalidade.setText(blTiraAcentos.TiraAcentos(txNacionalidade.getText()));
    }//GEN-LAST:event_txNacionalidadeKeyReleased

    private void txSinaisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSinaisKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txSinais.setText(txSinais.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txSinais.setText(blTiraAcentos.TiraAcentos(txSinais.getText()));
    }//GEN-LAST:event_txSinaisKeyReleased

    private void txPesoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txPesoFocusGained
        this.txPeso.selectAll();
    }//GEN-LAST:event_txPesoFocusGained

    private void txSerieUfCtpsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSerieUfCtpsKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txSerieUfCtps.setText(txSerieUfCtps.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txSerieUfCtps.setText(blTiraAcentos.TiraAcentos(txSerieUfCtps.getText()));
    }//GEN-LAST:event_txSerieUfCtpsKeyReleased

    private void txNotaCargoVirtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txNotaCargoVirtFocusGained
        this.txNotaCargoVirt.selectAll();
    }//GEN-LAST:event_txNotaCargoVirtFocusGained

    private void txNotaCargoVirtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNotaCargoVirtKeyReleased
        this.txNotaCargoVirt.setText(new BLMascaras().converterVirgulaParaPonto(this.txNotaCargoVirt.getText()));
    }//GEN-LAST:event_txNotaCargoVirtKeyReleased

    private void txVotoConscienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txVotoConscienteKeyReleased
        this.txVotoConsciente.setText(new BLMascaras().converterVirgulaParaPonto(this.txVotoConsciente.getText()));
        // converte em maiusculo o que o usuario digitar
        this.txVotoConsciente.setText(txVotoConsciente.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txVotoConsciente.setText(blTiraAcentos.TiraAcentos(txVotoConsciente.getText()));
    }//GEN-LAST:event_txVotoConscienteKeyReleased

    private void txDependenteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDependenteKeyReleased
        // converte em maiusculo o que o usuario digitar
        this.txDependente.setText(txDependente.getText().toUpperCase());
        //tira acentos
        BLTiraAcentos blTiraAcentos = new BLTiraAcentos();
        this.txDependente.setText(blTiraAcentos.TiraAcentos(txDependente.getText()));
    }//GEN-LAST:event_txDependenteKeyReleased

    private void btCertificadoAspiranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCertificadoAspiranteActionPerformed
        ViewPeriodoCertifAspirante viewPeriodoCertifAspirante = new ViewPeriodoCertifAspirante();
        viewPeriodoCertifAspirante.setVisible(true);
        viewPeriodoCertifAspirante.setCodAluno(txCodigo.getText());

    }//GEN-LAST:event_btCertificadoAspiranteActionPerformed

    private void btAvalAspiranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAvalAspiranteActionPerformed
        controllerAluno.gerarRelatorioAvaliacaoInstitucionalSala((String) cbSalas.getSelectedItem());

    }//GEN-LAST:event_btAvalAspiranteActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ViewAprendizagemTeorica viewAprendizagemTeorica = new ViewAprendizagemTeorica();
        viewAprendizagemTeorica.setVisible(true);
        viewAprendizagemTeorica.setCodAluno(txCodigo.getText());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cbOrigemAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOrigemAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbOrigemAlunoActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        ViewPresencaDiaria viewPresencaDiaria = new ViewPresencaDiaria();
        viewPresencaDiaria.setVisible(true);
        viewPresencaDiaria.setCodAluno(txCodigo.getText());
    }//GEN-LAST:event_jButton15ActionPerformed

    private void preencherCbEmpresa() {
        listaModelEmpresas = controllerEmpresa.getListaEmpresaController();

        cbEmpresa.removeAllItems();
        for (int i = 0; i < listaModelEmpresas.size(); i++) {
            cbEmpresa.addItem(listaModelEmpresas.get(i).getCodigoEmpresa() + " - " + listaModelEmpresas.get(i).getRazao());

        }

    }

    private void preencherCbIntensivo() {
        listaModelIntensivos = controllerIntensivo.getListaIntensivoController();

        cbCursoIntensivo.removeAllItems();
        for (int i = 0; i < listaModelIntensivos.size(); i++) {
            cbCursoIntensivo.addItem(listaModelIntensivos.get(i).getDescricao());

        }

    }

    private void preencherCbOrigeAluno() {
        listaModelOrigemAlunos = controllerOrigemAluno.getListaOrigemAlunoController();

        cbOrigemAluno.removeAllItems();
        for (int i = 0; i < listaModelOrigemAlunos.size(); i++) {
            cbOrigemAluno.addItem(listaModelOrigemAlunos.get(i).getOrig_descricao());

        }

    }

    private void preencherCbEmpresaAdmissao() {
        listaModelEmpresas = controllerEmpresa.getListaEmpresaController();

        cbEmpAdmissao.removeAllItems();
        for (int i = 0; i < listaModelEmpresas.size(); i++) {
            cbEmpAdmissao.addItem(listaModelEmpresas.get(i).getCodigoEmpresa() + " - " + listaModelEmpresas.get(i).getRazao());

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

    private void removeDependente() {
        int linhaSelecionada = tbDependente.getSelectedRow();
        // Verificamos se existe realmente alguma linha selecionada
        if (linhaSelecionada < 0) {
            return;
        } else {
            // Obtem o modelo da JTable
            DefaultTableModel modelo = (DefaultTableModel) tbDependente.getModel();
            // Remove a linha
            modelo.removeRow(linhaSelecionada);
        }
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

    private void adicionaDependente() {
        BLDatas bl = new BLDatas();

        DefaultTableModel modelo = (DefaultTableModel) tbDependente.getModel();
        int cont = 0;

        for (int i = 0; i < cont; i++) {
            modelo.setNumRows(0);
        }
        try {
            //pega a quantidade de linhas e joga na variavel
            modelo.addRow(new Object[]{
                txDependente.getText(),
                txIdadeDp.getText(),
                cbSexoDependente.getSelectedItem()
            });
        } catch (Exception ex) {
            Logger.getLogger(ViewAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void selecionaImagem() {
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();

            try {
                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 190, 160);

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
        lblImagem.setIcon(null);
        obj.setImagem(null);

        //limparVariavelImagem();
    }

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
            java.util.logging.Logger.getLogger(ViewAspirante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAspirante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAspirante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAspirante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAspirante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btArco;
    private javax.swing.JButton btArco1;
    private javax.swing.JButton btAssAdm;
    private javax.swing.JButton btAssAdm2;
    private javax.swing.JButton btAux2;
    private javax.swing.JButton btAvalAspirante;
    private javax.swing.JButton btCalculaSalario;
    private javax.swing.JButton btCancelaAdmissao;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCertificadoAprendiz;
    private javax.swing.JButton btCertificadoAspirante;
    private javax.swing.JButton btComercio;
    private javax.swing.JButton btComercio1;
    private javax.swing.JButton btConfirmaAdmissao;
    private javax.swing.JButton btEncaminhamento;
    private javax.swing.JButton btFichaAuxAdm;
    private javax.swing.JButton btFoto;
    private javax.swing.JButton btIncluirDep;
    private javax.swing.JButton btIncluirEntrevista;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisaCep;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btPreparatorio;
    private javax.swing.JButton btRegEmpregado;
    private javax.swing.JButton btRemoverDp;
    private javax.swing.JButton btRemoverImagem;
    private javax.swing.JButton btRmover;
    private javax.swing.JButton btSaida;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbCBO;
    private javax.swing.JComboBox<String> cbCargaHoraria;
    private javax.swing.JComboBox<String> cbCargoVirtual;
    private javax.swing.JComboBox<String> cbCursoIntensivo;
    private javax.swing.JComboBox<String> cbDiaAtivTeorica;
    private javax.swing.JComboBox<String> cbDiaCurso;
    private javax.swing.JComboBox<String> cbDiasIntensivo;
    private javax.swing.JComboBox<String> cbEmpAdmissao;
    private javax.swing.JComboBox<String> cbEmpresa;
    private javax.swing.JComboBox<String> cbEmpresaVirtual;
    private javax.swing.JComboBox<String> cbEstCivil1;
    private javax.swing.JComboBox<String> cbHorario;
    private javax.swing.JComboBox<String> cbHorasTrabalhadas;
    private javax.swing.JComboBox<String> cbLocalAprendizagem;
    private javax.swing.JComboBox<String> cbOrigemAluno;
    private javax.swing.JComboBox<String> cbPeriodo;
    private javax.swing.JComboBox<String> cbQualCurso;
    private javax.swing.JComboBox<String> cbSalas;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JComboBox<String> cbSexoDependente;
    private javax.swing.JComboBox<String> cbSituacao;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JComboBox<String> cbTipoAdimissao;
    private javax.swing.JComboBox<String> cbTurma;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
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
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JToolBar jToolBar7;
    private javax.swing.JToolBar jToolBar8;
    private javax.swing.JCheckBox jcb2Fase;
    private javax.swing.JCheckBox jcbCadIrregular;
    private javax.swing.JCheckBox jcbConvenioOdontologico;
    private javax.swing.JCheckBox jcbInsalubre;
    private javax.swing.JCheckBox jcbSalas;
    private javax.swing.JCheckBox jcbTurma;
    private javax.swing.JCheckBox jcbVt;
    private com.toedter.calendar.JDateChooser jcdBaixa;
    private com.toedter.calendar.JDateChooser jcdDataAdmissao;
    private com.toedter.calendar.JDateChooser jcdDataEmissaoCTPS;
    private com.toedter.calendar.JDateChooser jcdDataEntrevista;
    private com.toedter.calendar.JDateChooser jcdDataInclusao;
    private com.toedter.calendar.JDateChooser jcdDataNascimento;
    private com.toedter.calendar.JDateChooser jcdDataRescisao;
    private com.toedter.calendar.JDateChooser jcdEmissaoRg;
    private com.toedter.calendar.JDateChooser jcdTerminoContrato;
    private javax.swing.JLabel lbNomeApresentacao;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JTextArea taAdministrativa;
    private javax.swing.JTextArea taObservacao;
    private javax.swing.JTextArea taPedagogicas;
    private javax.swing.JTextArea taPsicologicas;
    private javax.swing.JTextArea taRecrutamento;
    private javax.swing.JTextArea taSociais;
    private javax.swing.JTable tbDependente;
    private javax.swing.JTable tbEmpresaEntrevista;
    private javax.swing.JTextField txAgencia;
    private javax.swing.JTextField txAltura;
    private javax.swing.JTextField txAtit2;
    private javax.swing.JTextField txAtit3;
    private javax.swing.JTextField txAtit4;
    private javax.swing.JTextField txAtit5;
    private javax.swing.JTextField txBairro;
    private javax.swing.JTextField txBanco;
    private javax.swing.JTextField txCabelos;
    private javax.swing.JTextField txCamiseta;
    private javax.swing.JTextField txCep;
    private javax.swing.JTextField txCodigo;
    private javax.swing.JTextField txComplemento;
    private javax.swing.JTextField txCor;
    private javax.swing.JTextField txCpf;
    private javax.swing.JTextField txCtps;
    private javax.swing.JTextField txDependente;
    private javax.swing.JTextField txEmail;
    private javax.swing.JTextField txEnderecoUF;
    private javax.swing.JTextField txEscola;
    private javax.swing.JTextField txHorarioEntrevista;
    private javax.swing.JTextField txIdadeDp;
    private javax.swing.JTextField txInf1;
    private javax.swing.JTextField txInf2;
    private javax.swing.JTextField txInf3;
    private javax.swing.JTextField txInf4;
    private javax.swing.JTextField txInf5;
    private javax.swing.JTextField txIntensPeriodo1;
    private javax.swing.JTextField txIntensPeriodo2;
    private javax.swing.JTextField txIntensPeriodo3;
    private javax.swing.JTextField txLocalNascimento;
    private javax.swing.JTextField txLogradouro;
    private javax.swing.JTextField txMat1;
    private javax.swing.JTextField txMat2;
    private javax.swing.JTextField txMat3;
    private javax.swing.JTextField txMat4;
    private javax.swing.JTextField txMat5;
    private javax.swing.JTextField txMedia1;
    private javax.swing.JTextField txMedia2;
    private javax.swing.JTextField txMedia3;
    private javax.swing.JTextField txMedia4;
    private javax.swing.JTextField txMedia5;
    private javax.swing.JTextField txMunicipio;
    private javax.swing.JTextField txNacionalidade;
    private javax.swing.JTextField txNome;
    private javax.swing.JTextField txNomeMae;
    private javax.swing.JTextField txNomePai;
    private javax.swing.JTextField txNotaCargoVirt;
    private javax.swing.JTextField txNumero;
    private javax.swing.JTextField txNumeroConta;
    private javax.swing.JTextField txOlhos;
    private javax.swing.JTextField txPendenteIntensivo;
    private javax.swing.JTextField txPerctInsalubridade;
    private javax.swing.JTextField txPeso;
    private javax.swing.JTextField txPis;
    private javax.swing.JTextField txPort1;
    private javax.swing.JTextField txPort2;
    private javax.swing.JTextField txPort3;
    private javax.swing.JTextField txPort4;
    private javax.swing.JTextField txPort5;
    private javax.swing.JTextField txRGM;
    private javax.swing.JTextField txRa;
    private javax.swing.JTextField txRed1;
    private javax.swing.JTextField txRed2;
    private javax.swing.JTextField txRed3;
    private javax.swing.JTextField txRed4;
    private javax.swing.JTextField txRed5;
    private javax.swing.JTextField txResponsavel;
    private javax.swing.JTextField txRg;
    private javax.swing.JTextField txRgMae;
    private javax.swing.JTextField txRgPai;
    private javax.swing.JTextField txSalario;
    private javax.swing.JTextField txSerieUfCtps;
    private javax.swing.JTextField txSinais;
    private javax.swing.JTextField txTel1;
    private javax.swing.JTextField txTel2;
    private javax.swing.JTextField txTel3;
    private javax.swing.JTextField txTel4;
    private javax.swing.JTextField txUfLocalNascimento;
    private javax.swing.JTextField txVotoConsciente;
    // End of variables declaration//GEN-END:variables
}
