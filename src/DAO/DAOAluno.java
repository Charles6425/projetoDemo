package DAO;

import model.ModelAluno;
import model.ModelCadEndereco;
import conexoes.ConexaoMySql;
import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Charles
 */
public class DAOAluno extends ConexaoMySql {

    /**
     * grava Aluno
     *
     * @param pModelAluno return int
     */
    public int salvarAlunoDAO(ModelAluno pModelAluno) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO cad_aluno ("
                    + "id,"
                    + "nome_aluno,"
                    + "rgm_aluno,"
                    + "mae,"
                    + "pai,"
                    + "rg_pai,"
                    + "cod_endereco,"
                    + "numero,"
                    + "complemento,"
                    + "tel_1,"
                    + "tel_2,"
                    + "tel_3,"
                    + "tel_4,"
                    + "cpf,"
                    + "rg_aluno,"
                    + "dt_emissao_rg,"
                    + "dt_nascimento,"
                    + "local_nascimento,"
                    + "uf_nascimento,"
                    + "ctps,"
                    + "serie_uf_cpts,"
                    + "dt_emissao_ctps,"
                    + "pis,"
                    + "num_conta,"
                    + "agencia,"
                    + "banco,"
                    + "seguro,"
                    + "baixa,"
                    + "data_baixa,"
                    + "anotacoes_diversas,"
                    + "homologacoes,"
                    + "sexo,"
                    + "escola,"
                    + "beneficio_social,"
                    + "numero_inscricao,"
                    + "tipo_residencia,"
                    + "valor_mensal_residencia,"
                    + "email,"
                    + "rg_mae,"
                    + "ferias_empresa_num,"
                    + "ferias_periodo_adquirido,"
                    + "ferias_periodo_gozado,"
                    + "situacao,"
                    + "salario, "
                    + "origem_aluno, "
                    + "anot_pedagogicas, "
                    + "anot_sociais, "
                    + "anot_psicologicas, "
                    + "anot_administrativas, "
                    + "cargo_aluno, "
                    + "formacao_basica, "
                    + "vt, "
                    + "cbo, "
                    + "insalubre, "
                    + "insalubre_sn, "
                    + "tipo_admissao, "
                    + "cor, "
                    + "cabelos, "
                    + "olhos, "
                    + "sinais, "
                    + "peso "
                    + ") VALUES ("
                    + "'" + pModelAluno.getId() + "',"
                    + "'" + pModelAluno.getNome_aluno() + "',"
                    + "'" + pModelAluno.getRgm_aluno() + "',"
                    + "'" + pModelAluno.getMae() + "',"
                    + "'" + pModelAluno.getPai() + "',"
                    + "'" + pModelAluno.getRg_pai() + "',"
                    + "'" + pModelAluno.getCod_endereco() + "',"
                    + "'" + pModelAluno.getNumero() + "',"
                    + "'" + pModelAluno.getComplemento() + "',"
                    + "'" + pModelAluno.getTel_1() + "',"
                    + "'" + pModelAluno.getTel_2() + "',"
                    + "'" + pModelAluno.getTel_3() + "',"
                    + "'" + pModelAluno.getTel_4() + "',"
                    + "'" + pModelAluno.getCpf() + "',"
                    + "'" + pModelAluno.getRg_aluno() + "',"
                    + "'" + pModelAluno.getDt_emissao_rg() + "',"
                    + "'" + pModelAluno.getDt_nascimento() + "',"
                    + "'" + pModelAluno.getLocal_nascimento() + "',"
                    + "'" + pModelAluno.getUf_nascimento() + "',"
                    + "'" + pModelAluno.getCtps() + "',"
                    + "'" + pModelAluno.getSerie_uf_cpts() + "',"
                    + "'" + pModelAluno.getDt_emissao_ctps() + "',"
                    + "'" + pModelAluno.getPis() + "',"
                    + "'" + pModelAluno.getNum_conta() + "',"
                    + "'" + pModelAluno.getAgencia() + "',"
                    + "'" + pModelAluno.getBanco() + "',"
                    + "'" + pModelAluno.getSeguro() + "',"
                    + "'" + pModelAluno.getBaixa() + "',"
                    + "'" + pModelAluno.getData_baixa() + "',"
                    + "'" + pModelAluno.getAnotacoes_diversas() + "',"
                    + "'" + pModelAluno.getHomologacoes() + "',"
                    + "'" + pModelAluno.getSexo() + "',"
                    + "'" + pModelAluno.getEscola() + "',"
                    + "'" + pModelAluno.getBeneficio_social() + "',"
                    + "'" + pModelAluno.getNumero_inscricao() + "',"
                    + "'" + pModelAluno.getTipo_residencia() + "',"
                    + "'" + pModelAluno.getValor_mensal_residencia() + "',"
                    + "'" + pModelAluno.getEmail() + "',"
                    + "'" + pModelAluno.getRg_mae() + "',"
                    + "'" + pModelAluno.getFerias_empresa_num() + "',"
                    + "'" + pModelAluno.getFerias_periodo_adquirido() + "',"
                    + "'" + pModelAluno.getFerias_periodo_gozado() + "',"
                    + "'" + pModelAluno.getSituacao() + "',"
                    + "'" + pModelAluno.getSalario() + "',"
                    + "'" + pModelAluno.getOrigem_aluno() + "',"
                    + "'" + pModelAluno.getAnot_pedagogicas() + "',"
                    + "'" + pModelAluno.getAnot_sociais() + "',"
                    + "'" + pModelAluno.getAnot_psicologicas() + "',"
                    + "'" + pModelAluno.getAnot_administrativas() + "',"
                    + "'" + pModelAluno.getCargo_aluno() + "',"
                    + "'" + pModelAluno.getFormacao_basica() + "',"
                    + "'" + pModelAluno.getVt() + "',"
                    + "'" + pModelAluno.getCbo() + "',"
                    + "'" + pModelAluno.getInsalubre() + "',"
                    + "'" + pModelAluno.getInsalubre_sn() + "',"
                    + "'" + pModelAluno.getTipo_admissao() + "',"
                    + "'" + pModelAluno.getCor() + "',"
                    + "'" + pModelAluno.getCabelos() + "',"
                    + "'" + pModelAluno.getOlhos() + "',"
                    + "'" + pModelAluno.getSinais() + "',"
                    + "'" + pModelAluno.getPeso() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * grava Aluno
     *
     * @param pModelAluno return int
     */
    public int salvarCadGeralDAO(ModelAluno pModelAluno) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO cad_geral ("
                    //  + "id,"
                    + "situacao,"
                    + "rgm_aluno,"
                    + "nome_aluno,"
                    + "sexo,"
                    + "sala,"
                    + "rg_aluno,"
                    + "cpf,"
                    + "dt_nascimento,"
                    + "reservista,"
                    + "cod_endereco,"
                    + "numero,"
                    + "complemento,"
                    + "tel_1,"
                    + "tel_2,"
                    + "tel_3,"
                    + "tel_4,"
                    + "responsavel,"
                    + "altura,"
                    + "visita_empresa,"
                    + "data_visita,"
                    + "inicio_curso,"
                    + "port1,"
                    + "mat1,"
                    + "red1,"
                    + "inf1,"
                    + "md1,"
                    + "port2,"
                    + "mat2,"
                    + "red2,"
                    + "atitudes2,"
                    + "inf2,"
                    + "md2,"
                    + "port3,"
                    + "mat3,"
                    + "red3,"
                    + "atitudes3,"
                    + "inf3,"
                    + "md3,"
                    + "turma,"
                    + "camiseta,"
                    + "data_baixa,"
                    + "turma_inicial,"
                    + "ctps,"
                    + "serie_uf_cpts,"
                    + "escola,"
                    + "cargo_aluno, "
                    + "cadastro_irregular, "
                    + "mae,"
                    + "pai,"
                    + "rg_mae,"
                    + "rg_pai,"
                    + "dt_emissao_rg,"
                    + "num_conta,"
                    + "agencia,"
                    + "dt_emissao_ctps,"
                    + "pis,"
                    + "email,"
                    + "local_nascimento,"
                    + "uf_nascimento,"
                    + "banco,"
                    + "turma_2_fase,"
                    + "segunda_fase_confirma,"
                    + "horario_2_fase,"
                    + "dia_2_fase,"
                    + "adv_falta,"
                    + "origem_aluno, "
                    + "anot_pedagogicas, "
                    + "anot_sociais, "
                    + "anot_psicologicas, "
                    + "anot_administrativas, "
                    + "empresa_virtual, "
                    + "cargo_virtual, "
                    + "observacao, "
                    + "vt, "
                    + "cbo, "
                    + "insalubre, "
                    + "insalubre_sn, "
                    + "tipo_admissao, "
                    + "convenio_odont, "
                    + "curso, "
                    + "horario, "
                    + "cor, "
                    + "cabelos, "
                    + "olhos, "
                    + "sinais, "
                    + "peso, "
                    + "dt_emissao_pis, "
                    + "nacionalidade, "
                    + "estado_civil, "
                    + "dt_inclusao, "
                    + "dt_termino_curso,"
                    + "dt_termino_contrato, "
                    + "dtia_atv_teorica,"
                    + "local_aprendizagem, "
                    + "int_per1, "
                    + "int_per2, "
                    + "int_per3, "
                    + "dias_intensivo, "
                    + "pendente_intensivo, "
                    + "voto_consciente, "
                    + "dia_curso, "
                    + "status, "
                    + "carga_horaria_total ,"
                    + "empresa,"
                    + "dt_admissao,"
                    + "dt_rescisao,"
                    + "periodo,"
                    + "horas_trabalhadas,"
                    + "intensivo,"
                    + "nota_cargo_virtual,"
                    + "port4,"
                    + "mat4,"
                    + "red4,"
                    + "atitudes4,"
                    + "inf4,"
                    + "md4,"
                    + "port5,"
                    + "mat5,"
                    + "red5,"
                    + "atitudes5,"
                    + "inf5,"
                    + "md5"

                    + ") VALUES ("
                    //   + "'" + pModelAluno.getId() + "',"
                    + "'" + pModelAluno.getSituacao() + "',"
                    + "'" + pModelAluno.getRgm_aluno() + "',"
                    + "'" + pModelAluno.getNome_aluno() + "',"
                    + "'" + pModelAluno.getSexo() + "',"
                    + "'" + pModelAluno.getSala() + "',"
                    + "'" + pModelAluno.getRg_aluno() + "',"
                    + "'" + pModelAluno.getCpf() + "',"
                    + "'" + pModelAluno.getDt_nascimento() + "',"
                    + "'" + pModelAluno.getReservista() + "',"
                    + "'" + pModelAluno.getCod_endereco() + "',"
                    + "'" + pModelAluno.getNumero() + "',"
                    + "'" + pModelAluno.getComplemento() + "',"
                    + "'" + pModelAluno.getTel_1() + "',"
                    + "'" + pModelAluno.getTel_2() + "',"
                    + "'" + pModelAluno.getTel_3() + "',"
                    + "'" + pModelAluno.getTel_4() + "',"
                    + "'" + pModelAluno.getResponsavel() + "',"
                    + "'" + pModelAluno.getAltura() + "',"
                    + "'" + pModelAluno.getVisita_empresa() + "',"
                    + "'" + pModelAluno.getData_visita() + "',"
                    + "'" + pModelAluno.getInicio_curso() + "',"
                    + "'" + pModelAluno.getPort1() + "',"
                    + "'" + pModelAluno.getMat1() + "',"
                    + "'" + pModelAluno.getRed1() + "',"
                    + "'" + pModelAluno.getInf1() + "',"
                    + "'" + pModelAluno.getMd1() + "',"
                    + "'" + pModelAluno.getPort2() + "',"
                    + "'" + pModelAluno.getMat2() + "',"
                    + "'" + pModelAluno.getRed2() + "',"
                    + "'" + pModelAluno.getAtitudes2() + "',"
                    + "'" + pModelAluno.getInf2() + "',"
                    + "'" + pModelAluno.getMd2() + "',"
                    + "'" + pModelAluno.getPort3() + "',"
                    + "'" + pModelAluno.getMat3() + "',"
                    + "'" + pModelAluno.getRed3() + "',"
                    + "'" + pModelAluno.getAtitudes3() + "',"
                    + "'" + pModelAluno.getInf3() + "',"
                    + "'" + pModelAluno.getMd3() + "',"
                    + "'" + pModelAluno.getTurma() + "',"
                    + "'" + pModelAluno.getCamiseta() + "',"
                    + "'" + pModelAluno.getData_baixa() + "',"
                    + "'" + pModelAluno.getTurma_inicial() + "',"
                    + "'" + pModelAluno.getCtps() + "',"
                    + "'" + pModelAluno.getSerie_uf_cpts() + "',"
                    + "'" + pModelAluno.getEscola() + "',"
                    + "'" + pModelAluno.getCargo_aluno() + "',"
                    + "'" + pModelAluno.getCadastro_irregular() + "',"
                    + "'" + pModelAluno.getMae() + "',"
                    + "'" + pModelAluno.getPai() + "',"
                    + "'" + pModelAluno.getRg_mae() + "',"
                    + "'" + pModelAluno.getRg_pai() + "',"
                    + "'" + pModelAluno.getDt_emissao_rg() + "',"
                    + "'" + pModelAluno.getNum_conta() + "',"
                    + "'" + pModelAluno.getAgencia() + "',"
                    + "'" + pModelAluno.getDt_emissao_ctps() + "',"
                    + "'" + pModelAluno.getPis() + "',"
                    + "'" + pModelAluno.getEmail() + "',"
                    + "'" + pModelAluno.getLocal_nascimento() + "',"
                    + "'" + pModelAluno.getUf_nascimento() + "',"
                    + "'" + pModelAluno.getBanco() + "',"
                    + "'" + pModelAluno.getTurma_2_fase() + "',"
                    + "'" + pModelAluno.getSegunda_fase_confirma() + "',"
                    + "'" + pModelAluno.getHorario_2_fase() + "',"
                    + "'" + pModelAluno.getDia_2_fase() + "',"
                    + "'" + pModelAluno.getAdv_falta() + "',"
                    + "'" + pModelAluno.getOrigem_aluno() + "',"
                    + "'" + pModelAluno.getAnot_pedagogicas() + "',"
                    + "'" + pModelAluno.getAnot_sociais() + "',"
                    + "'" + pModelAluno.getAnot_psicologicas() + "',"
                    + "'" + pModelAluno.getAnot_administrativas() + "',"
                    + "'" + pModelAluno.getEmpresa_virtual() + "',"
                    + "'" + pModelAluno.getCargo_virtual() + "',"
                    + "'" + pModelAluno.getObservacao() + "',"
                    + "'" + pModelAluno.getVt() + "',"
                    + "'" + pModelAluno.getCbo() + "',"
                    + "'" + pModelAluno.getInsalubre() + "',"
                    + "'" + pModelAluno.getInsalubre_sn() + "',"
                    + "'" + pModelAluno.getTipo_admissao() + "',"
                    + "'" + pModelAluno.getConvenio_odont() + "',"
                    + "'" + pModelAluno.getCurso() + "',"
                    + "'" + pModelAluno.getHorario() + "',"
                    + "'" + pModelAluno.getCor() + "',"
                    + "'" + pModelAluno.getCabelos() + "',"
                    + "'" + pModelAluno.getOlhos() + "',"
                    + "'" + pModelAluno.getSinais() + "',"
                    + "'" + pModelAluno.getPeso() + "',"
                    + "'" + pModelAluno.getDt_emissao_pis() + "',"
                    + "'" + pModelAluno.getNacionalidade() + "',"
                    + "'" + pModelAluno.getEstado_civil() + "',"
                    + "'" + pModelAluno.getDt_Inclusao() + "',"
                    + "'" + pModelAluno.getDt_termino_curso() + "',"
                    + "'" + pModelAluno.getDt_TerminoContrato() + "',"
                    + "'" + pModelAluno.getDiaAtivTeorica() + "',"
                    + "'" + pModelAluno.getLocal_aprendizagem() + "',"
                    + "'" + pModelAluno.getInt_per1() + "',"
                    + "'" + pModelAluno.getInt_per2() + "',"
                    + "'" + pModelAluno.getInt_per3() + "',"
                    + "'" + pModelAluno.getDias_intensivo() + "',"
                    + "'" + pModelAluno.getPendente_intensivo() + "',"
                    + "'" + pModelAluno.getVoto_consciente() + "',"
                    + "'" + pModelAluno.getDiaCurso() + "',"
                    + "'" + pModelAluno.getStatus() + "',"
                    + "'" + pModelAluno.getCarga_horaria_total() + "',"
                    + "'" + pModelAluno.getEmpresa() + "',"
                    + "'" + pModelAluno.getDt_admissao() + "',"
                    + "'" + pModelAluno.getDt_rescisao() + "',"
                    + "'" + pModelAluno.getPeriodo() + "',"
                    + "'" + pModelAluno.getHoras_trabalhadas() + "',"
                    + "'" + pModelAluno.getIntensivo() + "',"
                    + "'" + pModelAluno.getNota_cargo_virtual() + "',"
                    + "'" + pModelAluno.getPort4() + "',"
                    + "'" + pModelAluno.getMat4() + "',"
                    + "'" + pModelAluno.getRed4() + "',"
                    + "'" + pModelAluno.getAtitudes4() + "',"
                    + "'" + pModelAluno.getInf4() + "',"
                    + "'" + pModelAluno.getMd4() + "',"
                    + "'" + pModelAluno.getPort5() + "',"
                    + "'" + pModelAluno.getMat5() + "',"
                    + "'" + pModelAluno.getRed5() + "',"
                    + "'" + pModelAluno.getAtitudes5() + "',"
                    + "'" + pModelAluno.getInf5() + "',"
                    + "'" + pModelAluno.getMd5() + "'"
               
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera Aluno
     *
     * @param pId return ModelAluno
     */
    public ModelAluno getGeralDAO(int pId) {
        ModelAluno modelAluno = new ModelAluno();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id,"
                    + "situacao,"
                    + "rgm_aluno,"
                    + "nome_aluno,"
                    + "sexo,"
                    + "sala,"
                    + "rg_aluno,"
                    + "cpf,"
                    + "dt_nascimento,"
                    + "reservista,"
                    + "cod_endereco,"
                    + "numero,"
                    + "complemento,"
                    + "tel_1,"
                    + "tel_2,"
                    + "tel_3,"
                    + "tel_4,"
                    + "responsavel,"
                    + "altura,"
                    + "visita_empresa,"
                    + "data_visita,"
                    + "inicio_curso,"
                    + "port1,"
                    + "mat1,"
                    + "red1,"
                    + "inf1,"
                    + "md1,"
                    + "port2,"
                    + "mat2,"
                    + "red2,"
                    + "atitudes2,"
                    + "inf2,"
                    + "md2,"
                    + "port3,"
                    + "mat3,"
                    + "red3,"
                    + "atitudes3,"
                    + "inf3,"
                    + "md3,"
                    + "turma,"
                    + "camiseta,"
                    + "data_baixa,"
                    + "turma_inicial,"
                    + "ctps,"
                    + "serie_uf_cpts,"
                    + "escola,"
                    + "cargo_aluno, "
                    + "cadastro_irregular, "
                    + "mae,"
                    + "pai,"
                    + "rg_mae,"
                    + "rg_pai,"
                    + "dt_emissao_rg,"
                    + "num_conta,"
                    + "agencia,"
                    + "dt_emissao_ctps,"
                    + "pis,"
                    + "email,"
                    + "local_nascimento,"
                    + "uf_nascimento,"
                    + "banco,"
                    + "turma_2_fase,"
                    + "segunda_fase_confirma,"
                    + "horario_2_fase,"
                    + "dia_2_fase,"
                    + "adv_falta,"
                    + "origem_aluno, "
                    + "anot_pedagogicas, "
                    + "anot_sociais, "
                    + "anot_psicologicas, "
                    + "anot_administrativas, "
                    + "empresa_virtual, "
                    + "cargo_virtual, "
                    + "observacao, "
                    + "cep_apoio, "
                    + "vt, "
                    + "cbo, "
                    + "insalubre, "
                    + "insalubre_sn, "
                    + "tipo_admissao, "
                    + "convenio_odont ,"
                    + "curso, "
                    + "horario, "
                    + "cor, "
                    + "cabelos, "
                    + "olhos, "
                    + "sinais, "
                    + "peso, "
                    + "dt_emissao_pis, "
                    + "nacionalidade,"
                    + "estado_civil, "
                    + "status, "
                    + "dia_curso, "
                    + "voto_consciente, "
                    + "carga_horaria_total, "
                    + "local_aprendizagem, "
                    + "empresa, "
                    + "dt_admissao, "
                    + "dt_rescisao, "
                    + "dt_inclusao, "
                    + "dt_termino_contrato, "
                    + "periodo, "
                    + "horas_trabalhadas, "
                    + "dias_intensivo, "
                    + "pendente_intensivo, "
                    + "int_per1, "
                    + "int_per2, "
                    + "int_per3, "
                    + "intensivo, "
                    + "nota_cargo_virtual, "
                    + "port4,"
                    + "mat4,"
                    + "red4,"
                    + "atitudes4,"
                    + "inf4,"
                    + "md4,"
                    + "port5,"
                    + "mat5,"
                    + "red5,"
                    + "atitudes5,"
                    + "inf5,"
                    + "md5"

                    + " FROM"
                    + " cad_geral"
                    + " WHERE"
                    + " id = '" + pId + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelAluno.setId(this.getResultSet().getInt(1));
                modelAluno.setSituacao(this.getResultSet().getString(2));
                modelAluno.setRgm_aluno(this.getResultSet().getString(3));
                modelAluno.setNome_aluno(this.getResultSet().getString(4));
                modelAluno.setSexo(this.getResultSet().getString(5));
                modelAluno.setSala(this.getResultSet().getInt(6));
                modelAluno.setRg_aluno(this.getResultSet().getString(7));
                modelAluno.setCpf(this.getResultSet().getString(8));
                modelAluno.setDt_nascimento(this.getResultSet().getString(9));
                modelAluno.setReservista(this.getResultSet().getString(10));
                modelAluno.setCod_endereco(this.getResultSet().getInt(11));
                modelAluno.setNumero(this.getResultSet().getString(12));
                modelAluno.setComplemento(this.getResultSet().getString(13));
                modelAluno.setTel_1(this.getResultSet().getString(14));
                modelAluno.setTel_2(this.getResultSet().getString(15));
                modelAluno.setTel_3(this.getResultSet().getString(16));
                modelAluno.setTel_4(this.getResultSet().getString(17));
                modelAluno.setResponsavel(this.getResultSet().getString(18));
                modelAluno.setAltura(this.getResultSet().getFloat(19));
                modelAluno.setVisita_empresa(this.getResultSet().getString(20));
                modelAluno.setData_visita(this.getResultSet().getString(21));
                modelAluno.setInicio_curso(this.getResultSet().getString(22));
                modelAluno.setPort1(this.getResultSet().getFloat(23));
                modelAluno.setMat1(this.getResultSet().getFloat(24));
                modelAluno.setRed1(this.getResultSet().getFloat(25));
                modelAluno.setInf1(this.getResultSet().getFloat(26));
                modelAluno.setMd1(this.getResultSet().getFloat(27));
                modelAluno.setPort2(this.getResultSet().getFloat(28));
                modelAluno.setMat2(this.getResultSet().getFloat(29));
                modelAluno.setRed2(this.getResultSet().getFloat(30));
                modelAluno.setAtitudes2(this.getResultSet().getFloat(31));
                modelAluno.setInf2(this.getResultSet().getFloat(32));
                modelAluno.setMd2(this.getResultSet().getFloat(33));
                modelAluno.setPort3(this.getResultSet().getFloat(34));
                modelAluno.setMat3(this.getResultSet().getFloat(35));
                modelAluno.setRed3(this.getResultSet().getFloat(36));
                modelAluno.setAtitudes3(this.getResultSet().getFloat(37));
                modelAluno.setInf3(this.getResultSet().getFloat(38));
                modelAluno.setMd3(this.getResultSet().getFloat(39));
                modelAluno.setTurma(this.getResultSet().getInt(40));
                modelAluno.setCamiseta(this.getResultSet().getString(41));
                modelAluno.setData_baixa(this.getResultSet().getString(42));
                modelAluno.setTurma_inicial(this.getResultSet().getInt(43));
                modelAluno.setCtps(this.getResultSet().getString(44));
                modelAluno.setSerie_uf_cpts(this.getResultSet().getString(45));
                modelAluno.setEscola(this.getResultSet().getString(46));
                modelAluno.setCargo_aluno(this.getResultSet().getInt(47));
                modelAluno.setCadastro_irregular(this.getResultSet().getInt(48));
                modelAluno.setMae(this.getResultSet().getString(49));
                modelAluno.setPai(this.getResultSet().getString(50));
                modelAluno.setRg_mae(this.getResultSet().getString(51));
                modelAluno.setRg_pai(this.getResultSet().getString(52));
                modelAluno.setDt_emissao_rg(this.getResultSet().getString(53));
                modelAluno.setNum_conta(this.getResultSet().getString(54));
                modelAluno.setAgencia(this.getResultSet().getString(55));
                modelAluno.setDt_emissao_ctps(this.getResultSet().getString(56));
                modelAluno.setPis(this.getResultSet().getString(57));
                modelAluno.setEmail(this.getResultSet().getString(58));
                modelAluno.setLocal_nascimento(this.getResultSet().getString(59));
                modelAluno.setUf_nascimento(this.getResultSet().getString(60));
                modelAluno.setBanco(this.getResultSet().getString(61));
                modelAluno.setTurma_2_fase(this.getResultSet().getInt(62));
                modelAluno.setSegunda_fase_confirma(this.getResultSet().getInt(63));
                modelAluno.setHorario_2_fase(this.getResultSet().getString(64));
                modelAluno.setDia_2_fase(this.getResultSet().getString(65));
                modelAluno.setAdv_falta(this.getResultSet().getString(66));
                modelAluno.setOrigem_aluno(this.getResultSet().getInt(67));
                modelAluno.setAnot_pedagogicas(this.getResultSet().getString(68));
                modelAluno.setAnot_sociais(this.getResultSet().getString(69));
                modelAluno.setAnot_psicologicas(this.getResultSet().getString(70));
                modelAluno.setAnot_administrativas(this.getResultSet().getString(71));
                modelAluno.setEmpresa_virtual(this.getResultSet().getInt(72));
                modelAluno.setCargo_virtual(this.getResultSet().getInt(73));
                modelAluno.setObservacao(this.getResultSet().getString(74));
                modelAluno.setCep_apoio(this.getResultSet().getString(75));
                modelAluno.setVt(this.getResultSet().getInt(76));
                modelAluno.setCbo(this.getResultSet().getInt(77));
                modelAluno.setInsalubre(this.getResultSet().getFloat(78));
                modelAluno.setInsalubre_sn(this.getResultSet().getInt(79));
                modelAluno.setTipo_admissao(this.getResultSet().getInt(80));
                modelAluno.setConvenio_odont(this.getResultSet().getInt(81));
                modelAluno.setCurso(this.getResultSet().getInt(82));
                modelAluno.setHorario(this.getResultSet().getInt(83));
                modelAluno.setCor(this.getResultSet().getString(84));
                modelAluno.setCabelos(this.getResultSet().getString(85));
                modelAluno.setOlhos(this.getResultSet().getString(86));
                modelAluno.setSinais(this.getResultSet().getString(87));
                modelAluno.setPeso(this.getResultSet().getFloat(88));
                modelAluno.setDt_emissao_pis(this.getResultSet().getString(89));
                modelAluno.setNacionalidade(this.getResultSet().getString(90));
                modelAluno.setEstado_civil(this.getResultSet().getString(91));
                modelAluno.setStatus(this.getResultSet().getString(92));
                modelAluno.setDiaCurso(this.getResultSet().getString(93));
                modelAluno.setVoto_consciente(this.getResultSet().getString(94));
                modelAluno.setCarga_horaria_total(this.getResultSet().getString(95));
                modelAluno.setLocal_aprendizagem(this.getResultSet().getInt(96));
                modelAluno.setEmpresa(this.getResultSet().getInt(97));
                modelAluno.setDt_admissao(this.getResultSet().getString(98));
                modelAluno.setDt_rescisao(this.getResultSet().getString(99));
                modelAluno.setDt_Inclusao(this.getResultSet().getString(100));
                modelAluno.setDt_TerminoContrato(this.getResultSet().getString(101));
                modelAluno.setPeriodo(this.getResultSet().getInt(102));
                modelAluno.setHoras_trabalhadas(this.getResultSet().getInt(103));
                modelAluno.setDias_intensivo(this.getResultSet().getInt(104));
                modelAluno.setPendente_intensivo(this.getResultSet().getString(105));
                modelAluno.setInt_per1(this.getResultSet().getString(106));
                modelAluno.setInt_per2(this.getResultSet().getString(107));
                modelAluno.setInt_per3(this.getResultSet().getString(108));
                modelAluno.setIntensivo(this.getResultSet().getInt(109));
                modelAluno.setNota_cargo_virtual(this.getResultSet().getFloat(110));
                modelAluno.setPort4(this.getResultSet().getFloat(111));
                modelAluno.setMat4(this.getResultSet().getFloat(112));
                modelAluno.setRed4(this.getResultSet().getFloat(113));
                modelAluno.setAtitudes4(this.getResultSet().getFloat(114));
                modelAluno.setInf4(this.getResultSet().getFloat(115));
                modelAluno.setMd4(this.getResultSet().getFloat(116));
                modelAluno.setPort5(this.getResultSet().getFloat(117));
                modelAluno.setMat5(this.getResultSet().getFloat(118));
                modelAluno.setRed5(this.getResultSet().getFloat(119));
                modelAluno.setAtitudes5(this.getResultSet().getFloat(120));
                modelAluno.setInf5(this.getResultSet().getFloat(121));
                modelAluno.setMd5(this.getResultSet().getFloat(122));
                

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelAluno;
    }

    /**
     * recupera Aluno
     *
     * @param pId return ModelAluno
     */
    public ModelAluno getAlunoDAO(int pId) {
        ModelAluno modelAluno = new ModelAluno();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id,"
                    + "nome_aluno,"
                    + "rgm_aluno,"
                    + "mae,"
                    + "pai,"
                    + "rg_pai,"
                    + "cod_endereco,"
                    + "numero,"
                    + "complemento,"
                    + "tel_1,"
                    + "tel_2,"
                    + "tel_3,"
                    + "tel_4,"
                    + "cpf,"
                    + "rg_aluno,"
                    + "dt_emissao_rg,"
                    + "dt_nascimento,"
                    + "local_nascimento,"
                    + "uf_nascimento,"
                    + "ctps,"
                    + "serie_uf_cpts,"
                    + "dt_emissao_ctps,"
                    + "pis,"
                    + "num_conta,"
                    + "agencia,"
                    + "banco,"
                    + "seguro,"
                    + "baixa,"
                    + "data_baixa,"
                    + "anotacoes_diversas,"
                    + "homologacoes,"
                    + "sexo,"
                    + "escola,"
                    + "beneficio_social,"
                    + "numero_inscricao,"
                    + "tipo_residencia,"
                    + "valor_mensal_residencia,"
                    + "email,"
                    + "rg_mae,"
                    + "ferias_empresa_num,"
                    + "ferias_periodo_adquirido,"
                    + "ferias_periodo_gozado,"
                    + "cep,"
                    + "situacao,"
                    + "salario, "
                    + "origem_aluno, "
                    + "anot_pedagogicas, "
                    + "anot_sociais, "
                    + "anot_psicologicas, "
                    + "anot_administrativas, "
                    + "cargo_aluno, "
                    + "formacao_basica "
                    + " FROM"
                    + " cad_aluno"
                    + " WHERE"
                    + " id = '" + pId + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelAluno.setId(this.getResultSet().getInt(1));
                modelAluno.setNome_aluno(this.getResultSet().getString(2));
                modelAluno.setRgm_aluno(this.getResultSet().getString(3));
                modelAluno.setMae(this.getResultSet().getString(4));
                modelAluno.setPai(this.getResultSet().getString(5));
                modelAluno.setRg_pai(this.getResultSet().getString(6));
                modelAluno.setCod_endereco(this.getResultSet().getInt(7));
                modelAluno.setNumero(this.getResultSet().getString(8));
                modelAluno.setComplemento(this.getResultSet().getString(9));
                modelAluno.setTel_1(this.getResultSet().getString(10));
                modelAluno.setTel_2(this.getResultSet().getString(11));
                modelAluno.setTel_3(this.getResultSet().getString(12));
                modelAluno.setTel_4(this.getResultSet().getString(13));
                modelAluno.setCpf(this.getResultSet().getString(14));
                modelAluno.setRg_aluno(this.getResultSet().getString(15));
                modelAluno.setDt_emissao_rg(this.getResultSet().getString(16));
                modelAluno.setDt_nascimento(this.getResultSet().getString(17));
                modelAluno.setLocal_nascimento(this.getResultSet().getString(18));
                modelAluno.setUf_nascimento(this.getResultSet().getString(19));
                modelAluno.setCtps(this.getResultSet().getString(20));
                modelAluno.setSerie_uf_cpts(this.getResultSet().getString(21));
                modelAluno.setDt_emissao_ctps(this.getResultSet().getString(22));
                modelAluno.setPis(this.getResultSet().getString(23));
                modelAluno.setNum_conta(this.getResultSet().getString(24));
                modelAluno.setAgencia(this.getResultSet().getString(25));
                modelAluno.setBanco(this.getResultSet().getString(26));
                modelAluno.setSeguro(this.getResultSet().getInt(27));
                modelAluno.setBaixa(this.getResultSet().getInt(28));
                modelAluno.setData_baixa(this.getResultSet().getString(29));
                modelAluno.setAnotacoes_diversas(this.getResultSet().getString(30));
                modelAluno.setHomologacoes(this.getResultSet().getString(31));
                modelAluno.setSexo(this.getResultSet().getString(32));
                modelAluno.setEscola(this.getResultSet().getString(33));
                modelAluno.setBeneficio_social(this.getResultSet().getString(34));
                modelAluno.setNumero_inscricao(this.getResultSet().getString(35));
                modelAluno.setTipo_residencia(this.getResultSet().getString(36));
                modelAluno.setValor_mensal_residencia(this.getResultSet().getFloat(37));
                modelAluno.setEmail(this.getResultSet().getString(38));
                modelAluno.setRg_mae(this.getResultSet().getString(39));
                modelAluno.setFerias_empresa_num(this.getResultSet().getString(40));
                modelAluno.setFerias_periodo_adquirido(this.getResultSet().getString(41));
                modelAluno.setFerias_periodo_gozado(this.getResultSet().getString(42));
                modelAluno.setCep_importado(this.getResultSet().getString(43));
                modelAluno.setSituacao(this.getResultSet().getString(44));
                modelAluno.setSalario(this.getResultSet().getDouble(45));
                modelAluno.setOrigem_aluno(this.getResultSet().getInt(46));
                modelAluno.setAnot_pedagogicas(this.getResultSet().getString(47));
                modelAluno.setAnot_sociais(this.getResultSet().getString(48));
                modelAluno.setAnot_psicologicas(this.getResultSet().getString(49));
                modelAluno.setAnot_administrativas(this.getResultSet().getString(50));
                modelAluno.setCargo_aluno(this.getResultSet().getInt(51));
                modelAluno.setFormacao_basica(this.getResultSet().getInt(52));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelAluno;
    }

    /**
     * recupera uma lista de Aluno return ArrayList
     */
    public ArrayList<ModelAluno> getListaAlunoDAO() {
        ArrayList<ModelAluno> listamodelAluno = new ArrayList();
        ModelAluno modelAluno = new ModelAluno();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id,"
                    + "nome_aluno,"
                    + "rgm_aluno,"
                    + "mae,"
                    + "pai,"
                    + "rg_pai,"
                    + "cod_endereco,"
                    + "numero,"
                    + "complemento,"
                    + "tel_1,"
                    + "tel_2,"
                    + "tel_3,"
                    + "tel_4,"
                    + "cpf,"
                    + "rg_aluno,"
                    + "dt_emissao_rg,"
                    + "dt_nascimento,"
                    + "local_nascimento,"
                    + "uf_nascimento,"
                    + "ctps,"
                    + "serie_uf_cpts,"
                    + "dt_emissao_ctps,"
                    + "pis,"
                    + "num_conta,"
                    + "agencia,"
                    + "banco,"
                    + "seguro,"
                    + "baixa,"
                    + "data_baixa,"
                    + "anotacoes_diversas,"
                    + "homologacoes,"
                    + "sexo,"
                    + "escola,"
                    + "beneficio_social,"
                    + "numero_inscricao,"
                    + "tipo_residencia,"
                    + "valor_mensal_residencia,"
                    + "email,"
                    + "rg_mae,"
                    + "ferias_empresa_num,"
                    + "ferias_periodo_adquirido,"
                    + "ferias_periodo_gozado,"
                    + "cep,"
                    + "situacao,"
                    + "salario,"
                    + "origem_aluno,"
                    + "anot_pedagogicas, "
                    + "anot_sociais, "
                    + "anot_psicologicas, "
                    + "anot_administrativas, "
                    + "cargo_aluno, "
                    + "formacao_basica "
                    + " FROM"
                    + " cad_aluno"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelAluno = new ModelAluno();
                modelAluno.setId(this.getResultSet().getInt(1));
                modelAluno.setNome_aluno(this.getResultSet().getString(2));
                modelAluno.setRgm_aluno(this.getResultSet().getString(3));
                modelAluno.setMae(this.getResultSet().getString(4));
                modelAluno.setPai(this.getResultSet().getString(5));
                modelAluno.setRg_pai(this.getResultSet().getString(6));
                modelAluno.setCod_endereco(this.getResultSet().getInt(7));
                modelAluno.setNumero(this.getResultSet().getString(8));
                modelAluno.setComplemento(this.getResultSet().getString(9));
                modelAluno.setTel_1(this.getResultSet().getString(10));
                modelAluno.setTel_2(this.getResultSet().getString(11));
                modelAluno.setTel_3(this.getResultSet().getString(12));
                modelAluno.setTel_4(this.getResultSet().getString(13));
                modelAluno.setCpf(this.getResultSet().getString(14));
                modelAluno.setRg_aluno(this.getResultSet().getString(15));
                modelAluno.setDt_emissao_rg(this.getResultSet().getString(16));
                modelAluno.setDt_nascimento(this.getResultSet().getString(17));
                modelAluno.setLocal_nascimento(this.getResultSet().getString(18));
                modelAluno.setUf_nascimento(this.getResultSet().getString(19));
                modelAluno.setCtps(this.getResultSet().getString(20));
                modelAluno.setSerie_uf_cpts(this.getResultSet().getString(21));
                modelAluno.setDt_emissao_ctps(this.getResultSet().getString(22));
                modelAluno.setPis(this.getResultSet().getString(23));
                modelAluno.setNum_conta(this.getResultSet().getString(24));
                modelAluno.setAgencia(this.getResultSet().getString(25));
                modelAluno.setBanco(this.getResultSet().getString(26));
                modelAluno.setSeguro(this.getResultSet().getInt(27));
                modelAluno.setBaixa(this.getResultSet().getInt(28));
                modelAluno.setData_baixa(this.getResultSet().getString(29));
                modelAluno.setAnotacoes_diversas(this.getResultSet().getString(30));
                modelAluno.setHomologacoes(this.getResultSet().getString(31));
                modelAluno.setSexo(this.getResultSet().getString(32));
                modelAluno.setEscola(this.getResultSet().getString(33));
                modelAluno.setBeneficio_social(this.getResultSet().getString(34));
                modelAluno.setNumero_inscricao(this.getResultSet().getString(35));
                modelAluno.setTipo_residencia(this.getResultSet().getString(36));
                modelAluno.setValor_mensal_residencia(this.getResultSet().getFloat(37));
                modelAluno.setEmail(this.getResultSet().getString(38));
                modelAluno.setRg_mae(this.getResultSet().getString(39));
                modelAluno.setFerias_empresa_num(this.getResultSet().getString(40));
                modelAluno.setFerias_periodo_adquirido(this.getResultSet().getString(41));
                modelAluno.setFerias_periodo_gozado(this.getResultSet().getString(42));
                modelAluno.setCep_importado(this.getResultSet().getString(43));
                modelAluno.setSituacao(this.getResultSet().getString(44));
                modelAluno.setSalario(this.getResultSet().getDouble(45));
                modelAluno.setOrigem_aluno(this.getResultSet().getInt(46));
                modelAluno.setAnot_pedagogicas(this.getResultSet().getString(47));
                modelAluno.setAnot_sociais(this.getResultSet().getString(48));
                modelAluno.setAnot_psicologicas(this.getResultSet().getString(49));
                modelAluno.setAnot_administrativas(this.getResultSet().getString(50));
                modelAluno.setCargo_aluno(this.getResultSet().getInt(51));
                modelAluno.setFormacao_basica(this.getResultSet().getInt(52));

                listamodelAluno.add(modelAluno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelAluno;
    }

    /**
     * recupera uma lista de Aluno return ArrayList
     */
    public ArrayList<ModelAluno> getListaGeralDAO() {
        ArrayList<ModelAluno> listamodelAluno = new ArrayList();
        ModelAluno modelAluno = new ModelAluno();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id,"
                    + "situacao,"
                    + "rgm_aluno,"
                    + "nome_aluno,"
                    + "sexo,"
                    + "sala,"
                    + "rg_aluno,"
                    + "cpf,"
                    + "dt_nascimento,"
                    + "reservista,"
                    + "cod_endereco,"
                    + "numero,"
                    + "complemento,"
                    + "tel_1,"
                    + "tel_2,"
                    + "tel_3,"
                    + "tel_4,"
                    + "responsavel,"
                    + "altura,"
                    + "visita_empresa,"
                    + "data_visita,"
                    + "inicio_curso,"
                    + "port1,"
                    + "mat1,"
                    + "red1,"
                    + "inf1,"
                    + "md1,"
                    + "port2,"
                    + "mat2,"
                    + "red2,"
                    + "atitudes2,"
                    + "inf2,"
                    + "md2,"
                    + "port3,"
                    + "mat3,"
                    + "red3,"
                    + "atitudes3,"
                    + "inf3,"
                    + "md3,"
                    + "turma,"
                    + "camiseta,"
                    + "data_baixa,"
                    + "turma_inicial,"
                    + "ctps,"
                    + "serie_uf_cpts,"
                    + "escola,"
                    + "cargo_aluno, "
                    + "cadastro_irregular, "
                    + "mae,"
                    + "pai,"
                    + "rg_mae,"
                    + "rg_pai,"
                    + "dt_emissao_rg,"
                    + "num_conta,"
                    + "agencia,"
                    + "dt_emissao_ctps,"
                    + "pis,"
                    + "email,"
                    + "local_nascimento,"
                    + "uf_nascimento,"
                    + "banco,"
                    + "turma_2_fase,"
                    + "segunda_fase_confirma,"
                    + "horario_2_fase,"
                    + "dia_2_fase,"
                    + "adv_falta,"
                    + "origem_aluno, "
                    + "anot_pedagogicas, "
                    + "anot_sociais, "
                    + "anot_psicologicas, "
                    + "anot_administrativas, "
                    + "empresa_virtual, "
                    + "cargo_virtual, "
                    + "observacao, "
                    + "vt, "
                    + "cbo, "
                    + "insalubre, "
                    + "insalubre_sn, "
                    + "tipo_admissao, "
                    + "convenio_odont ,"
                    + "curso, "
                    + "horario, "
                    + "cor, "
                    + "cabelos, "
                    + "olhos, "
                    + "sinais, "
                    + "peso, "
                    + "dt_emissao_pis, "
                    + "nacionalidade, "
                    + "estado_civil, "
                    + "dt_inclusao, "
                    + "dt_termino_contrato, "
                    + "dtia_atv_teorica,"
                    + "local_aprendizagem, "
                    + "int_per1, "
                    + "int_per2, "
                    + "int_per3, "
                    + "dias_intensivo, "
                    + "pendente_intensivo, "
                    + "voto_consciente, "
                    + "status, "
                    + "dia_curso, "
                    + "carga_horaria_total, "
                    + "empresa, "
                    + "dt_admissao, "
                    + "dt_rescisao, "
                    + "periodo, "
                    + "horas_trabalhadas, "
                    + "pendente_intensivo, "
                    + "int_per1, "
                    + "int_per2, "
                    + "int_per3, "
                    + "intensivo, "
                    + "nota_cargo_virtual, "
                    + "port4,"
                    + "mat4,"
                    + "red4,"
                    + "atitudes4,"
                    + "inf4,"
                    + "md4,"
                    + "port5,"
                    + "mat5,"
                    + "red5,"
                    + "atitudes5,"
                    + "inf5,"
                    + "md5"
        
                    + " FROM"
                    + " cad_geral"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelAluno = new ModelAluno();
                modelAluno.setId(this.getResultSet().getInt(1));
                modelAluno.setSituacao(this.getResultSet().getString(2));
                modelAluno.setRgm_aluno(this.getResultSet().getString(3));
                modelAluno.setNome_aluno(this.getResultSet().getString(4));
                modelAluno.setSexo(this.getResultSet().getString(5));
                modelAluno.setSala(this.getResultSet().getInt(6));
                modelAluno.setRg_aluno(this.getResultSet().getString(7));
                modelAluno.setCpf(this.getResultSet().getString(8));
                modelAluno.setDt_nascimento(this.getResultSet().getString(9));
                modelAluno.setReservista(this.getResultSet().getString(10));
                modelAluno.setCod_endereco(this.getResultSet().getInt(11));
                modelAluno.setNumero(this.getResultSet().getString(12));
                modelAluno.setComplemento(this.getResultSet().getString(13));
                modelAluno.setTel_1(this.getResultSet().getString(14));
                modelAluno.setTel_2(this.getResultSet().getString(15));
                modelAluno.setTel_3(this.getResultSet().getString(16));
                modelAluno.setTel_4(this.getResultSet().getString(17));
                modelAluno.setResponsavel(this.getResultSet().getString(18));
                modelAluno.setAltura(this.getResultSet().getFloat(19));
                modelAluno.setVisita_empresa(this.getResultSet().getString(20));
                modelAluno.setData_visita(this.getResultSet().getString(21));
                modelAluno.setInicio_curso(this.getResultSet().getString(22));
                modelAluno.setPort1(this.getResultSet().getFloat(23));
                modelAluno.setMat1(this.getResultSet().getFloat(24));
                modelAluno.setRed1(this.getResultSet().getFloat(25));
                modelAluno.setInf1(this.getResultSet().getFloat(26));
                modelAluno.setMd1(this.getResultSet().getFloat(27));
                modelAluno.setPort2(this.getResultSet().getFloat(28));
                modelAluno.setMat2(this.getResultSet().getFloat(29));
                modelAluno.setRed2(this.getResultSet().getFloat(30));
                modelAluno.setAtitudes2(this.getResultSet().getFloat(31));
                modelAluno.setInf2(this.getResultSet().getFloat(32));
                modelAluno.setMd2(this.getResultSet().getFloat(33));
                modelAluno.setPort3(this.getResultSet().getFloat(34));
                modelAluno.setMat3(this.getResultSet().getFloat(35));
                modelAluno.setRed3(this.getResultSet().getFloat(36));
                modelAluno.setAtitudes3(this.getResultSet().getFloat(37));
                modelAluno.setInf3(this.getResultSet().getFloat(38));
                modelAluno.setMd3(this.getResultSet().getFloat(39));
                modelAluno.setTurma(this.getResultSet().getInt(40));
                modelAluno.setCamiseta(this.getResultSet().getString(41));
                modelAluno.setData_baixa(this.getResultSet().getString(42));
                modelAluno.setTurma_inicial(this.getResultSet().getInt(43));
                modelAluno.setCtps(this.getResultSet().getString(44));
                modelAluno.setSerie_uf_cpts(this.getResultSet().getString(45));
                modelAluno.setEscola(this.getResultSet().getString(46));
                modelAluno.setCargo_aluno(this.getResultSet().getInt(47));
                modelAluno.setCadastro_irregular(this.getResultSet().getInt(48));
                modelAluno.setMae(this.getResultSet().getString(49));
                modelAluno.setPai(this.getResultSet().getString(50));
                modelAluno.setRg_mae(this.getResultSet().getString(51));
                modelAluno.setRg_pai(this.getResultSet().getString(52));
                modelAluno.setDt_emissao_rg(this.getResultSet().getString(53));
                modelAluno.setNum_conta(this.getResultSet().getString(54));
                modelAluno.setAgencia(this.getResultSet().getString(55));
                modelAluno.setDt_emissao_ctps(this.getResultSet().getString(56));
                modelAluno.setPis(this.getResultSet().getString(57));
                modelAluno.setEmail(this.getResultSet().getString(58));
                modelAluno.setLocal_nascimento(this.getResultSet().getString(59));
                modelAluno.setUf_nascimento(this.getResultSet().getString(60));
                modelAluno.setBanco(this.getResultSet().getString(61));
                modelAluno.setTurma_2_fase(this.getResultSet().getInt(62));
                modelAluno.setSegunda_fase_confirma(this.getResultSet().getInt(63));
                modelAluno.setHorario_2_fase(this.getResultSet().getString(64));
                modelAluno.setDia_2_fase(this.getResultSet().getString(65));
                modelAluno.setAdv_falta(this.getResultSet().getString(66));
                modelAluno.setOrigem_aluno(this.getResultSet().getInt(67));
                modelAluno.setAnot_pedagogicas(this.getResultSet().getString(68));
                modelAluno.setAnot_sociais(this.getResultSet().getString(69));
                modelAluno.setAnot_psicologicas(this.getResultSet().getString(70));
                modelAluno.setAnot_administrativas(this.getResultSet().getString(71));
                modelAluno.setEmpresa_virtual(this.getResultSet().getInt(72));
                modelAluno.setCargo_virtual(this.getResultSet().getInt(73));
                modelAluno.setObservacao(this.getResultSet().getString(74));
                modelAluno.setVt(this.getResultSet().getInt(75));
                modelAluno.setCbo(this.getResultSet().getInt(76));
                modelAluno.setInsalubre(this.getResultSet().getFloat(77));
                modelAluno.setInsalubre_sn(this.getResultSet().getInt(78));
                modelAluno.setTipo_admissao(this.getResultSet().getInt(79));
                modelAluno.setConvenio_odont(this.getResultSet().getInt(80));
                modelAluno.setCurso(this.getResultSet().getInt(81));
                modelAluno.setHorario(this.getResultSet().getInt(82));
                modelAluno.setCor(this.getResultSet().getString(83));
                modelAluno.setCabelos(this.getResultSet().getString(84));
                modelAluno.setOlhos(this.getResultSet().getString(85));
                modelAluno.setSinais(this.getResultSet().getString(86));
                modelAluno.setPeso(this.getResultSet().getFloat(87));
                modelAluno.setDt_emissao_pis(this.getResultSet().getString(88));
                modelAluno.setNacionalidade(this.getResultSet().getString(89));
                modelAluno.setEstado_civil(this.getResultSet().getString(90));
                modelAluno.setDt_Inclusao(this.getResultSet().getString(91));
                modelAluno.setDt_TerminoContrato(this.getResultSet().getString(92));
                modelAluno.setDiaAtivTeorica(this.getResultSet().getInt(93));
                modelAluno.setLocal_aprendizagem(this.getResultSet().getInt(94));
                modelAluno.setInt_per1(this.getResultSet().getString(95));
                modelAluno.setInt_per2(this.getResultSet().getString(96));
                modelAluno.setInt_per3(this.getResultSet().getString(97));
                modelAluno.setDias_intensivo(this.getResultSet().getInt(98));
                modelAluno.setPendente_intensivo(this.getResultSet().getString(99));
                modelAluno.setVoto_consciente(this.getResultSet().getString(100));
                modelAluno.setStatus(this.getResultSet().getString(101));
                modelAluno.setDiaCurso(this.getResultSet().getString(102));
                modelAluno.setCarga_horaria_total(this.getResultSet().getString(103));
                modelAluno.setEmpresa(this.getResultSet().getInt(104));
                modelAluno.setDt_admissao(this.getResultSet().getString(105));
                modelAluno.setDt_rescisao(this.getResultSet().getString(106));
                modelAluno.setPeriodo(this.getResultSet().getInt(107));
                modelAluno.setHoras_trabalhadas(this.getResultSet().getInt(108));
                modelAluno.setPendente_intensivo(this.getResultSet().getString(109));
                modelAluno.setInt_per1(this.getResultSet().getString(110));
                modelAluno.setInt_per2(this.getResultSet().getString(111));
                modelAluno.setInt_per3(this.getResultSet().getString(112));
                modelAluno.setIntensivo(this.getResultSet().getInt(113));
                modelAluno.setNota_cargo_virtual(this.getResultSet().getFloat(114));
                modelAluno.setPort4(this.getResultSet().getFloat(115));
                modelAluno.setMat4(this.getResultSet().getFloat(116));
                modelAluno.setRed4(this.getResultSet().getFloat(117));
                modelAluno.setAtitudes4(this.getResultSet().getFloat(118));
                modelAluno.setInf4(this.getResultSet().getFloat(119));
                modelAluno.setMd4(this.getResultSet().getFloat(120));
                modelAluno.setPort5(this.getResultSet().getFloat(121));
                modelAluno.setMat5(this.getResultSet().getFloat(122));
                modelAluno.setRed5(this.getResultSet().getFloat(123));
                modelAluno.setAtitudes5(this.getResultSet().getFloat(124));
                modelAluno.setInf5(this.getResultSet().getFloat(125));
                modelAluno.setMd5(this.getResultSet().getFloat(126));
             
                listamodelAluno.add(modelAluno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelAluno;
    }

    /**
     * recupera uma lista de Aluno return ArrayList sem where
     */
    public ArrayList<ModelAluno> getListaEncSemDAO(int pSituacao, int pTurma, String pNascimento, String pNascimentoFim, String pSexo, String pBairro) {
        ArrayList<ModelAluno> listamodelAluno = new ArrayList();
        ArrayList<ModelCadEndereco> listamodeEnderecos = new ArrayList();
        ModelAluno modelAluno = new ModelAluno();
        ModelCadEndereco modelCadEndereco = new ModelCadEndereco();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "dt_nascimento,"
                    + "id,"
                    + "nome_aluno,"
                    + "sexo,"
                    + "situacao,"
                    + "turma,"
                    + "bairro, "
                    + "port3, "
                    + "mat3, "
                    + "nat3, "
                    + "inf3, "
                    + "nad3, "
                    + "sqv3, "
                    + "ativ_fis3, "
                    + "ed_moral3, "
                    + "md3 "
                    + " FROM gmz.vw_encaminhamento"
                    + " where situacao = '" + pSituacao + "'"
                    + " and turma ='" + pTurma + "'"
                    + " and dt_nascimento >='" + pNascimento + "'"
                    + " and dt_nascimento <='" + pNascimentoFim + "'"
                    + " and sexo ='" + pSexo + "'"
                    + " and bairro ='" + pBairro + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelAluno = new ModelAluno();
                modelAluno.setIdade(this.getResultSet().getInt(1));
                modelAluno.setId(this.getResultSet().getInt(2));
                modelAluno.setNome_aluno(this.getResultSet().getString(3));
                modelAluno.setSexo(this.getResultSet().getString(4));
                modelAluno.setSituacao(this.getResultSet().getString(5));
                modelAluno.setTurma(this.getResultSet().getInt(6));
                modelAluno.setBairro(this.getResultSet().getString(7));
                modelAluno.setPort3(this.getResultSet().getFloat(8));
                modelAluno.setMat3(this.getResultSet().getFloat(9));
                modelAluno.setNat3(this.getResultSet().getFloat(10));
                modelAluno.setInf3(this.getResultSet().getFloat(11));
                modelAluno.setNad3(this.getResultSet().getFloat(12));
                modelAluno.setSqv3(this.getResultSet().getFloat(13));
                modelAluno.setAtiv_fis3(this.getResultSet().getFloat(14));
                modelAluno.setEd_moral3(this.getResultSet().getFloat(15));
                modelAluno.setMd3(this.getResultSet().getFloat(16));

                listamodelAluno.add(modelAluno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelAluno;
    }

    /**
     * recupera uma lista de Aluno return ArrayList sem where
     */
    public ArrayList<ModelAluno> getListaEncSemTurmaDAO(int pSituacao, int pTurma, String pNascimento, String pNascimentoFim, String pSexo, String pBairro) {
        ArrayList<ModelAluno> listamodelAluno = new ArrayList();
        ArrayList<ModelCadEndereco> listamodeEnderecos = new ArrayList();
        ModelAluno modelAluno = new ModelAluno();
        ModelCadEndereco modelCadEndereco = new ModelCadEndereco();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "dt_nascimento,"
                    + "id,"
                    + "nome_aluno,"
                    + "sexo,"
                    + "situacao,"
                    + "turma,"
                    + "bairro, "
                    + "port3, "
                    + "mat3, "
                    + "nat3, "
                    + "inf3, "
                    + "nad3, "
                    + "sqv3, "
                    + "ativ_fis3, "
                    + "ed_moral3, "
                    + "md3 "
                    + " FROM gmz.vw_encaminhamento"
                    + " where situacao = '" + pSituacao + "'"
                    + " and dt_nascimento >='" + pNascimento + "'"
                    + " and dt_nascimento <='" + pNascimentoFim + "'"
                    + " and sexo ='" + pSexo + "'"
                    + " and bairro ='" + pBairro + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelAluno = new ModelAluno();
                modelAluno.setIdade(this.getResultSet().getInt(1));
                modelAluno.setId(this.getResultSet().getInt(2));
                modelAluno.setNome_aluno(this.getResultSet().getString(3));
                modelAluno.setSexo(this.getResultSet().getString(4));
                modelAluno.setSituacao(this.getResultSet().getString(5));
                modelAluno.setTurma(this.getResultSet().getInt(6));
                modelAluno.setBairro(this.getResultSet().getString(7));
                modelAluno.setPort3(this.getResultSet().getFloat(8));
                modelAluno.setMat3(this.getResultSet().getFloat(9));
                modelAluno.setNat3(this.getResultSet().getFloat(10));
                modelAluno.setInf3(this.getResultSet().getFloat(11));
                modelAluno.setNad3(this.getResultSet().getFloat(12));
                modelAluno.setSqv3(this.getResultSet().getFloat(13));
                modelAluno.setAtiv_fis3(this.getResultSet().getFloat(14));
                modelAluno.setEd_moral3(this.getResultSet().getFloat(15));
                modelAluno.setMd3(this.getResultSet().getFloat(16));

                listamodelAluno.add(modelAluno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelAluno;
    }

    /**
     * recupera uma lista de Aluno return ArrayList sem where
     */
    public ArrayList<ModelAluno> getListaTodosBairrosDAO(int pSituacao, int pTurma, String pNascimento, String pNascimentoFim, String pSexo) {
        ArrayList<ModelAluno> listamodelAluno = new ArrayList();
        ArrayList<ModelCadEndereco> listamodeEnderecos = new ArrayList();
        ModelAluno modelAluno = new ModelAluno();
        ModelCadEndereco modelCadEndereco = new ModelCadEndereco();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "dt_nascimento,"
                    + "id,"
                    + "nome_aluno,"
                    + "sexo,"
                    + "situacao,"
                    + "turma,"
                    + "bairro, "
                    + "port3, "
                    + "mat3, "
                    + "nat3, "
                    + "inf3, "
                    + "nad3, "
                    + "sqv3, "
                    + "ativ_fis3, "
                    + "ed_moral3, "
                    + "md3 "
                    + " FROM gmz.vw_encaminhamento"
                    + " where situacao = '" + pSituacao + "'"
                    + " and turma ='" + pTurma + "'"
                    + " and dt_nascimento >='" + pNascimento + "'"
                    + " and dt_nascimento <='" + pNascimentoFim + "'"
                    + " and sexo ='" + pSexo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelAluno = new ModelAluno();
                modelAluno.setIdade(this.getResultSet().getInt(1));
                modelAluno.setId(this.getResultSet().getInt(2));
                modelAluno.setNome_aluno(this.getResultSet().getString(3));
                modelAluno.setSexo(this.getResultSet().getString(4));
                modelAluno.setSituacao(this.getResultSet().getString(5));
                modelAluno.setTurma(this.getResultSet().getInt(6));
                modelAluno.setBairro(this.getResultSet().getString(7));
                modelAluno.setPort3(this.getResultSet().getFloat(8));
                modelAluno.setMat3(this.getResultSet().getFloat(9));
                modelAluno.setNat3(this.getResultSet().getFloat(10));
                modelAluno.setInf3(this.getResultSet().getFloat(11));
                modelAluno.setNad3(this.getResultSet().getFloat(12));
                modelAluno.setSqv3(this.getResultSet().getFloat(13));
                modelAluno.setAtiv_fis3(this.getResultSet().getFloat(14));
                modelAluno.setEd_moral3(this.getResultSet().getFloat(15));
                modelAluno.setMd3(this.getResultSet().getFloat(16));

                listamodelAluno.add(modelAluno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelAluno;
    }

    /**
     * recupera uma lista de Aluno return ArrayList sem where
     */
    public ArrayList<ModelAluno> getListaEncSemSexoDAO(int pSituacao, int pTurma, String pNascimento, String pNascimentoFim, String pBairro) {
        ArrayList<ModelAluno> listamodelAluno = new ArrayList();
        ArrayList<ModelCadEndereco> listamodeEnderecos = new ArrayList();
        ModelAluno modelAluno = new ModelAluno();
        ModelCadEndereco modelCadEndereco = new ModelCadEndereco();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "dt_nascimento,"
                    + "id,"
                    + "nome_aluno,"
                    + "sexo,"
                    + "situacao,"
                    + "turma,"
                    + "bairro, "
                    + "port3, "
                    + "mat3, "
                    + "nat3, "
                    + "inf3, "
                    + "nad3, "
                    + "sqv3, "
                    + "ativ_fis3, "
                    + "ed_moral3, "
                    + "md3 "
                    + " FROM gmz.vw_encaminhamento"
                    + " where situacao = '" + pSituacao + "'"
                    + " and turma ='" + pTurma + "'"
                    + " and dt_nascimento >='" + pNascimento + "'"
                    + " and dt_nascimento <='" + pNascimentoFim + "'"
                    + " and bairro ='" + pBairro + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelAluno = new ModelAluno();
                modelAluno.setIdade(this.getResultSet().getInt(1));
                modelAluno.setId(this.getResultSet().getInt(2));
                modelAluno.setNome_aluno(this.getResultSet().getString(3));
                modelAluno.setSexo(this.getResultSet().getString(4));
                modelAluno.setSituacao(this.getResultSet().getString(5));
                modelAluno.setTurma(this.getResultSet().getInt(6));
                modelAluno.setBairro(this.getResultSet().getString(7));
                modelAluno.setPort3(this.getResultSet().getFloat(8));
                modelAluno.setMat3(this.getResultSet().getFloat(9));
                modelAluno.setNat3(this.getResultSet().getFloat(10));
                modelAluno.setInf3(this.getResultSet().getFloat(11));
                modelAluno.setNad3(this.getResultSet().getFloat(12));
                modelAluno.setSqv3(this.getResultSet().getFloat(13));
                modelAluno.setAtiv_fis3(this.getResultSet().getFloat(14));
                modelAluno.setEd_moral3(this.getResultSet().getFloat(15));
                modelAluno.setMd3(this.getResultSet().getFloat(16));

                listamodelAluno.add(modelAluno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelAluno;
    }

    /**
     * recupera uma lista de Aluno return ArrayList sem where
     */
    public ArrayList<ModelAluno> getTodosSexosBairrosDAO(int pSituacao, int pTurma, String pNascimento, String pNascimentoFim) {
        ArrayList<ModelAluno> listamodelAluno = new ArrayList();
        ArrayList<ModelCadEndereco> listamodeEnderecos = new ArrayList();
        ModelAluno modelAluno = new ModelAluno();
        ModelCadEndereco modelCadEndereco = new ModelCadEndereco();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "dt_nascimento,"
                    + "id,"
                    + "nome_aluno,"
                    + "sexo,"
                    + "situacao,"
                    + "turma,"
                    + "bairro, "
                    + "port3, "
                    + "mat3, "
                    + "nat3, "
                    + "inf3, "
                    + "nad3, "
                    + "sqv3, "
                    + "ativ_fis3, "
                    + "ed_moral3, "
                    + "md3 "
                    + " FROM gmz.vw_encaminhamento"
                    + " where situacao = '" + pSituacao + "'"
                    + " and turma ='" + pTurma + "'"
                    + " and dt_nascimento >='" + pNascimento + "'"
                    + " and dt_nascimento <='" + pNascimentoFim + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelAluno = new ModelAluno();
                modelAluno.setIdade(this.getResultSet().getInt(1));
                modelAluno.setId(this.getResultSet().getInt(2));
                modelAluno.setNome_aluno(this.getResultSet().getString(3));
                modelAluno.setSexo(this.getResultSet().getString(4));
                modelAluno.setSituacao(this.getResultSet().getString(5));
                modelAluno.setTurma(this.getResultSet().getInt(6));
                modelAluno.setBairro(this.getResultSet().getString(7));
                modelAluno.setPort3(this.getResultSet().getFloat(8));
                modelAluno.setMat3(this.getResultSet().getFloat(9));
                modelAluno.setNat3(this.getResultSet().getFloat(10));
                modelAluno.setInf3(this.getResultSet().getFloat(11));
                modelAluno.setNad3(this.getResultSet().getFloat(12));
                modelAluno.setSqv3(this.getResultSet().getFloat(13));
                modelAluno.setAtiv_fis3(this.getResultSet().getFloat(14));
                modelAluno.setEd_moral3(this.getResultSet().getFloat(15));
                modelAluno.setMd3(this.getResultSet().getFloat(16));

                listamodelAluno.add(modelAluno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelAluno;
    }

    /**
     * recupera uma lista de Aluno return ArrayList sem where
     */
    public ArrayList<ModelAluno> getTodosSexosBairrosTurmaDAO(int pSituacao, String pNascimento, String pNascimentoFim) {
        ArrayList<ModelAluno> listamodelAluno = new ArrayList();
        ArrayList<ModelCadEndereco> listamodeEnderecos = new ArrayList();
        ModelAluno modelAluno = new ModelAluno();
        ModelCadEndereco modelCadEndereco = new ModelCadEndereco();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "dt_nascimento,"
                    + "id,"
                    + "nome_aluno,"
                    + "sexo,"
                    + "situacao,"
                    + "turma,"
                    + "bairro, "
                    + "port3, "
                    + "mat3, "
                    + "nat3, "
                    + "inf3, "
                    + "nad3, "
                    + "sqv3, "
                    + "ativ_fis3, "
                    + "ed_moral3, "
                    + "md3 "
                    + " FROM gmz.vw_encaminhamento"
                    + " where situacao = '" + pSituacao + "'"
                    + " and dt_nascimento >='" + pNascimento + "'"
                    + " and dt_nascimento <='" + pNascimentoFim + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelAluno = new ModelAluno();
                modelAluno.setIdade(this.getResultSet().getInt(1));
                modelAluno.setId(this.getResultSet().getInt(2));
                modelAluno.setNome_aluno(this.getResultSet().getString(3));
                modelAluno.setSexo(this.getResultSet().getString(4));
                modelAluno.setSituacao(this.getResultSet().getString(5));
                modelAluno.setTurma(this.getResultSet().getInt(6));
                modelAluno.setBairro(this.getResultSet().getString(7));
                modelAluno.setPort3(this.getResultSet().getFloat(8));
                modelAluno.setMat3(this.getResultSet().getFloat(9));
                modelAluno.setNat3(this.getResultSet().getFloat(10));
                modelAluno.setInf3(this.getResultSet().getFloat(11));
                modelAluno.setNad3(this.getResultSet().getFloat(12));
                modelAluno.setSqv3(this.getResultSet().getFloat(13));
                modelAluno.setAtiv_fis3(this.getResultSet().getFloat(14));
                modelAluno.setEd_moral3(this.getResultSet().getFloat(15));
                modelAluno.setMd3(this.getResultSet().getFloat(16));

                listamodelAluno.add(modelAluno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelAluno;
    }

    /**
     * atualiza Aluno
     *
     * @param pModelAluno return boolean
     */
    public boolean atualizarAlunoDAO(ModelAluno pModelAluno) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE cad_aluno SET "
                    + "id = '" + pModelAluno.getId() + "',"
                    + "nome_aluno = '" + pModelAluno.getNome_aluno() + "',"
                    + "rgm_aluno = '" + pModelAluno.getRgm_aluno() + "',"
                    + "mae = '" + pModelAluno.getMae() + "',"
                    + "pai = '" + pModelAluno.getPai() + "',"
                    + "rg_pai = '" + pModelAluno.getRg_pai() + "',"
                    + "cod_endereco = '" + pModelAluno.getCod_endereco() + "',"
                    + "numero = '" + pModelAluno.getNumero() + "',"
                    + "complemento = '" + pModelAluno.getComplemento() + "',"
                    + "tel_1 = '" + pModelAluno.getTel_1() + "',"
                    + "tel_2 = '" + pModelAluno.getTel_2() + "',"
                    + "tel_3 = '" + pModelAluno.getTel_3() + "',"
                    + "tel_4 = '" + pModelAluno.getTel_4() + "',"
                    + "cpf = '" + pModelAluno.getCpf() + "',"
                    + "rg_aluno = '" + pModelAluno.getRg_aluno() + "',"
                    + "dt_emissao_rg = '" + pModelAluno.getDt_emissao_rg() + "',"
                    + "dt_nascimento = '" + pModelAluno.getDt_nascimento() + "',"
                    + "local_nascimento = '" + pModelAluno.getLocal_nascimento() + "',"
                    + "uf_nascimento = '" + pModelAluno.getUf_nascimento() + "',"
                    + "ctps = '" + pModelAluno.getCtps() + "',"
                    + "serie_uf_cpts = '" + pModelAluno.getSerie_uf_cpts() + "',"
                    + "dt_emissao_ctps = '" + pModelAluno.getDt_emissao_ctps() + "',"
                    + "pis = '" + pModelAluno.getPis() + "',"
                    + "num_conta = '" + pModelAluno.getNum_conta() + "',"
                    + "agencia = '" + pModelAluno.getAgencia() + "',"
                    + "banco = '" + pModelAluno.getBanco() + "',"
                    + "seguro = '" + pModelAluno.getSeguro() + "',"
                    + "baixa = '" + pModelAluno.getBaixa() + "',"
                    + "data_baixa = '" + pModelAluno.getData_baixa() + "',"
                    + "anotacoes_diversas = '" + pModelAluno.getAnotacoes_diversas() + "',"
                    + "homologacoes = '" + pModelAluno.getHomologacoes() + "',"
                    + "sexo = '" + pModelAluno.getSexo() + "',"
                    + "escola = '" + pModelAluno.getEscola() + "',"
                    + "beneficio_social = '" + pModelAluno.getBeneficio_social() + "',"
                    + "numero_inscricao = '" + pModelAluno.getNumero_inscricao() + "',"
                    + "tipo_residencia = '" + pModelAluno.getTipo_residencia() + "',"
                    + "valor_mensal_residencia = '" + pModelAluno.getValor_mensal_residencia() + "',"
                    + "email = '" + pModelAluno.getEmail() + "',"
                    + "rg_mae = '" + pModelAluno.getRg_mae() + "',"
                    + "ferias_empresa_num = '" + pModelAluno.getFerias_empresa_num() + "',"
                    + "ferias_periodo_adquirido = '" + pModelAluno.getFerias_periodo_adquirido() + "',"
                    + "ferias_periodo_gozado = '" + pModelAluno.getFerias_periodo_gozado() + "',"
                    + "ferias_periodo_gozado = '" + pModelAluno.getCep_importado() + "',"
                    + "situacao = '" + pModelAluno.getSituacao() + "',"
                    + "salario = '" + pModelAluno.getSalario() + "',"
                    + "origem_aluno = '" + pModelAluno.getOrigem_aluno() + "',"
                    + "anot_pedagogicas = '" + pModelAluno.getAnot_pedagogicas() + "',"
                    + "anot_sociais = '" + pModelAluno.getAnot_sociais() + "',"
                    + "anot_psicologicas = '" + pModelAluno.getAnot_psicologicas() + "',"
                    + "anot_administrativas = '" + pModelAluno.getAnot_administrativas() + "',"
                    + "cargo_aluno = '" + pModelAluno.getCargo_aluno() + "',"
                    + "formacao_basica = '" + pModelAluno.getFormacao_basica() + "'"
                    + " WHERE "
                    + "id = '" + pModelAluno.getId() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * atualiza Geral
     *
     * @param pModelAluno return boolean
     */
    public boolean atualizarGeralDAO(ModelAluno pModelAluno) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE cad_geral SET "
                    + "id = '" + pModelAluno.getId() + "',"
                    + "nome_aluno = '" + pModelAluno.getNome_aluno() + "',"
                    + "rgm_aluno = '" + pModelAluno.getRgm_aluno() + "',"
                    + "mae = '" + pModelAluno.getMae() + "',"
                    + "pai = '" + pModelAluno.getPai() + "',"
                    + "rg_pai = '" + pModelAluno.getRg_pai() + "',"
                    + "cod_endereco = '" + pModelAluno.getCod_endereco() + "',"
                    + "numero = '" + pModelAluno.getNumero() + "',"
                    + "complemento = '" + pModelAluno.getComplemento() + "',"
                    + "tel_1 = '" + pModelAluno.getTel_1() + "',"
                    + "tel_2 = '" + pModelAluno.getTel_2() + "',"
                    + "tel_3 = '" + pModelAluno.getTel_3() + "',"
                    + "tel_4 = '" + pModelAluno.getTel_4() + "',"
                    + "cpf = '" + pModelAluno.getCpf() + "',"
                    + "rg_aluno = '" + pModelAluno.getRg_aluno() + "',"
                    + "dt_emissao_rg = '" + pModelAluno.getDt_emissao_rg() + "',"
                    + "dt_nascimento = '" + pModelAluno.getDt_nascimento() + "',"
                    + "local_nascimento = '" + pModelAluno.getLocal_nascimento() + "',"
                    + "uf_nascimento = '" + pModelAluno.getUf_nascimento() + "',"
                    + "ctps = '" + pModelAluno.getCtps() + "',"
                    + "serie_uf_cpts = '" + pModelAluno.getSerie_uf_cpts() + "',"
                    + "dt_emissao_ctps = '" + pModelAluno.getDt_emissao_ctps() + "',"
                    + "pis = '" + pModelAluno.getPis() + "',"
                    + "num_conta = '" + pModelAluno.getNum_conta() + "',"
                    + "agencia = '" + pModelAluno.getAgencia() + "',"
                    + "banco = '" + pModelAluno.getBanco() + "',"
                    + "data_baixa = '" + pModelAluno.getData_baixa() + "',"
                    // + "anotacoes_diversas = '" + pModelAluno.getAnotacoes_diversas() + "',"
                    //+ "homologacoes = '" + pModelAluno.getHomologacoes() + "',"
                    + "sexo = '" + pModelAluno.getSexo() + "',"
                    + "escola = '" + pModelAluno.getEscola() + "',"
                    //+ "beneficio_social = '" + pModelAluno.getBeneficio_social() + "',"
                    // + "numero_inscricao = '" + pModelAluno.getNumero_inscricao() + "',"
                    //  + "tipo_residencia = '" + pModelAluno.getTipo_residencia() + "',"
                    //   + "valor_mensal_residencia = '" + pModelAluno.getValor_mensal_residencia() + "',"
                    // + "email = '" + pModelAluno.getEmail() + "',"
                    + "rg_mae = '" + pModelAluno.getRg_mae() + "',"
                    //  + "ferias_empresa_num = '" + pModelAluno.getFerias_empresa_num() + "',"
                    // + "ferias_periodo_adquirido = '" + pModelAluno.getFerias_periodo_adquirido() + "',"
                    // + "ferias_periodo_gozado = '" + pModelAluno.getFerias_periodo_gozado() + "',"
                    //   + "ferias_periodo_gozado = '" + pModelAluno.getCep_importado() + "',"
                    + "situacao = '" + pModelAluno.getSituacao() + "',"
                    // + "salario = '" + pModelAluno.getSalario() + "',"
                     + "origem_aluno = '" + pModelAluno.getOrigem_aluno() + "',"
                    + "anot_pedagogicas = '" + pModelAluno.getAnot_pedagogicas() + "',"
                    + "anot_sociais = '" + pModelAluno.getAnot_sociais() + "',"
                    + "anot_psicologicas = '" + pModelAluno.getAnot_psicologicas() + "',"
                    + "anot_administrativas = '" + pModelAluno.getAnot_administrativas() + "',"
                    + "cargo_aluno = '" + pModelAluno.getCargo_aluno() + "',"
                    + "sala = '" + pModelAluno.getSala() + "',"
                    + "reservista = '" + pModelAluno.getReservista() + "',"
                    + "responsavel = '" + pModelAluno.getResponsavel() + "',"
                    + "altura = '" + pModelAluno.getAltura() + "',"
                    + "visita_empresa = '" + pModelAluno.getVisita_empresa() + "',"
                    + "data_visita = '" + pModelAluno.getData_visita() + "',"
                    + "inicio_curso = '" + pModelAluno.getInicio_curso() + "',"
                    + "port1 = '" + pModelAluno.getPort1() + "',"
                    + "port2 = '" + pModelAluno.getPort2() + "',"
                    + "port3 = '" + pModelAluno.getPort3() + "',"
                    + "port4 = '" + pModelAluno.getPort4() + "',"
                    + "port5 = '" + pModelAluno.getPort5() + "',"
                    + "mat1 = '" + pModelAluno.getMat1() + "',"
                    + "mat2 = '" + pModelAluno.getMat2() + "',"
                    + "mat3 = '" + pModelAluno.getMat3() + "',"
                    + "mat4 = '" + pModelAluno.getMat4() + "',"
                    + "mat5 = '" + pModelAluno.getMat5() + "',"
                    + "red1 = '" + pModelAluno.getRed1() + "',"
                    + "red2 = '" + pModelAluno.getRed2() + "',"
                    + "red3 = '" + pModelAluno.getRed3() + "',"
                    + "red4 = '" + pModelAluno.getRed4() + "',"
                    + "red5 = '" + pModelAluno.getRed5() + "',"
                    + "inf1 = '" + pModelAluno.getInf1() + "',"
                    + "inf2 = '" + pModelAluno.getInf2() + "',"
                    + "inf3 = '" + pModelAluno.getInf3() + "',"
                    + "inf4 = '" + pModelAluno.getInf4() + "',"
                    + "inf5 = '" + pModelAluno.getInf5() + "',"
                    + "md1 = '" + pModelAluno.getMd1() + "',"
                    + "md2 = '" + pModelAluno.getMd2() + "',"
                    + "md3 = '" + pModelAluno.getMd3() + "',"
                    + "md4 = '" + pModelAluno.getMd4() + "',"
                    + "md5 = '" + pModelAluno.getMd5() + "',"
                    + "atitudes2 = '" + pModelAluno.getAtitudes2() + "',"
                    + "atitudes3 = '" + pModelAluno.getAtitudes3() + "',"
                    + "atitudes4 = '" + pModelAluno.getAtitudes4() + "',"
                    + "atitudes5 = '" + pModelAluno.getAtitudes5() + "',"
                    + "turma = '" + pModelAluno.getTurma() + "',"
                    + "camiseta = '" + pModelAluno.getCamiseta() + "',"
                    + "data_baixa = '" + pModelAluno.getData_baixa() + "',"
                    + "turma_inicial = '" + pModelAluno.getTurma_inicial() + "',"
                    + "cadastro_irregular = '" + pModelAluno.getCadastro_irregular() + "',"
                    + "email = '" + pModelAluno.getEmail() + "',"
                    + "turma_2_fase = '" + pModelAluno.getTurma_2_fase() + "',"
                    + "segunda_fase_confirma = '" + pModelAluno.getSegunda_fase_confirma() + "',"
                    + "horario_2_fase = '" + pModelAluno.getHorario_2_fase() + "',"
                    + "dia_2_fase = '" + pModelAluno.getDia_2_fase() + "',"
                    + "adv_falta = '" + pModelAluno.getAdv_falta() + "',"
                    + "empresa_virtual = '" + pModelAluno.getEmpresa_virtual() + "',"
                    + "cargo_virtual = '" + pModelAluno.getCargo_virtual() + "',"
                    + "observacao = '" + pModelAluno.getObservacao() + "',"
                    + "vt = '" + pModelAluno.getVt() + "',"
                    + "cbo = '" + pModelAluno.getCbo() + "',"
                    + "insalubre = '" + pModelAluno.getInsalubre() + "',"
                    + "insalubre_sn = '" + pModelAluno.getInsalubre_sn() + "',"
                    + "tipo_admissao = '" + pModelAluno.getTipo_admissao() + "',"
                    + "convenio_odont = '" + pModelAluno.getConvenio_odont() + "',"
                    + "curso = '" + pModelAluno.getCurso() + "',"
                    + "horario = '" + pModelAluno.getHorario() + "',"
                    + "cor = '" + pModelAluno.getCor() + "',"
                    + "cabelos = '" + pModelAluno.getCabelos() + "',"
                    + "olhos = '" + pModelAluno.getOlhos() + "',"
                    + "sinais = '" + pModelAluno.getSinais() + "',"
                    + "peso = '" + pModelAluno.getPeso() + "',"
                    + "dt_emissao_pis = '" + pModelAluno.getDt_emissao_pis() + "',"
                    + "nacionalidade = '" + pModelAluno.getNacionalidade() + "',"
                    + "estado_civil = '" + pModelAluno.getEstado_civil() + "',"
                    + "dt_inclusao = '" + pModelAluno.getDt_Inclusao() + "',"
                    + "dt_termino_contrato = '" + pModelAluno.getDt_TerminoContrato() + "',"
                    + "local_aprendizagem = '" + pModelAluno.getLocal_aprendizagem() + "',"
                    + "int_per1 = '" + pModelAluno.getInt_per1() + "',"
                    + "int_per2 = '" + pModelAluno.getInt_per2() + "',"
                    + "int_per3 = '" + pModelAluno.getInt_per3() + "',"
                    + "dias_intensivo = '" + pModelAluno.getDias_intensivo() + "',"
                    + "pendente_intensivo= '" + pModelAluno.getPendente_intensivo() + "',"
                    + "voto_consciente = '" + pModelAluno.getVoto_consciente() + "',"
                    + "status = '" + pModelAluno.getStatus() + "',"
                    + "dia_curso = '" + pModelAluno.getDiaCurso() + "',"
                    + "carga_horaria_total = '" + pModelAluno.getCarga_horaria_total() + "',"
                    + "empresa = '" + pModelAluno.getEmpresa() + "',"
                    + "dt_admissao = '" + pModelAluno.getDt_admissao() + "',"
                    + "dt_rescisao = '" + pModelAluno.getDt_rescisao() + "',"
                    + "periodo = '" + pModelAluno.getPeriodo() + "',"
                    + "horas_trabalhadas = '" + pModelAluno.getHoras_trabalhadas() + "',"
                    + "intensivo = '" + pModelAluno.getIntensivo() + "',"
                    + "nota_cargo_virtual = '" + pModelAluno.getNota_cargo_virtual() + "'"
                    + " WHERE "
                    + "id = '" + pModelAluno.getId() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui Aluno
     *
     * @param pId return boolean
     */
    public boolean excluirAlunoDAO(int pId) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM cad_aluno "
                    + " WHERE "
                    + "id = '" + pId + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
//===============================================================================================================

    /**
     * Relatórios
     *
     * @param pSala
     * @return
     */
    public boolean gerarRelatorioAssPorSala(String pSala) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_sala.descricao='" + pSala + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioAssPorSala.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioAssPorTurma(String pSala) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_turma.descricao='" + pSala + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioAssPorSala.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * começa daqui
     *
     * @param pSala
     * @return
     */
    public boolean gerarRelatorioAprendizagemSala(String pSala) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_sala.descricao='" + pSala + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioAlunoAprendizagem.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioAprendizagemGeral(String pSala, String pTurma) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_sala.descricao='" + pSala + "' and " + "cad_turma.descricao ='" + pTurma + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioAlunoAprendizagem.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioAprendizagemTurma(String pSala) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_turma.descricao='" + pSala + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioAlunoAprendizagem.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioAprendizagemAssSala(String pSala) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_sala.descricao='" + pSala + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioAlunoAprendizagemAss.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioAprendizagemAssGeral(String pSala, String pTurma) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_sala.descricao='" + pSala + "' and " + "cad_turma.descricao ='" + pTurma + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioAlunoAprendizagemAss.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioAprendizagemAssTurma(String pSala) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_turma.descricao='" + pSala + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioAlunoAprendizagemAss.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioPreparatorioSala(String pSala) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_sala.descricao='" + pSala + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioAlunoPreparatorio.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioPreparatorioGeral(String pSala, String pTurma) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_sala.descricao='" + pSala + "' and " + "cad_turma.descricao ='" + pTurma + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioAlunoPreparatorio.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioPreparatorioAssSala(String pSala) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_sala.descricao='" + pSala + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioAlunoPreparatorioAss.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioPreparatorioAssGeral(String pSala, String pTurma) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_sala.descricao='" + pSala + "' and " + "cad_turma.descricao ='" + pTurma + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioAlunoPreparatorioAss.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioPreparatorioTurma(String pSala) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_turma.descricao='" + pSala + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioAlunoPreparatorio.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioPreparatorioAssTurma(String pSala) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_turma.descricao='" + pSala + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioAlunoPreparatorioAss.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioListaChamadaSala(String pSala) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_sala.descricao='" + pSala + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioListapresensa.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioListaChamadaTurma(String pSala) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_turma.descricao='" + pSala + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioListapresensa.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioListaChamadaAmbos(String pSala, String pTurma) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_sala.descricao='" + pSala + "' and cad_turma ='" + pTurma + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioListapresensa.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioOcorrenciaSala(String pSala) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_sala.descricao='" + pSala + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioOcorrencias.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioOcorrenciaTurma(String pSala) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_turma.descricao='" + pSala + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioOcorrencias.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioOcorrenciaAmbos(String pSala, String pTurma) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_sala.descricao='" + pSala + "' and cad_turma ='" + pTurma + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioOcorrencias.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioAvaliacaoSala(String pSala) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo,\n"
                    + "local_aprendizagem.descricao as local_aprendizagem\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id left join local_aprendizagem on cad_geral.local_aprendizagem = local_aprendizagem.id"
                    + " where cad_sala.descricao='" + pSala + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioFichaAvaliativa.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioAvaliacaoTurma(String pSala) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo,\n"
                    + "local_aprendizagem.descricao as local_aprendizagem\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id left join local_aprendizagem on cad_geral.local_aprendizagem = local_aprendizagem.id"
                    + " where cad_turma.descricao='" + pSala + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioFichaAvaliativa.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioAvaliacaoAmbos(String pSala, String pTurma) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo,\n"
                    + "local_aprendizagem.descricao as local_aprendizagem\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id left join local_aprendizagem on cad_geral.local_aprendizagem = local_aprendizagem.id"
                    + " where cad_sala.descricao='" + pSala + "' and cad_turma.descricao ='" + pTurma + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioFichaAvaliativa.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioAdvertenciaSala(int pSala) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     cad_geral.`id`,\n"
                    + "     cad_geral.`nome_aluno`,\n"
                    + "     cad_geral.`cod_endereco`,\n"
                    + "     cad_geral.`rgm_aluno`,\n"
                    + "     cad_geral.`dt_nascimento`,\n"
                    + "     motivo_advertencia.`id` as `id_motivo`,\n"
                    + "     motivo_advertencia.`motivo`,\n"
                    + "     motivo_advertencia.`data`\n"
                    + "    \n"
                    + "FROM\n"
                    + "      cad_geral inner join motivo_advertencia on cad_geral.id = motivo_advertencia.id_aluno"
                    + " where cad_geral.id ='" + pSala + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioAdvertencia.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioDeclaracao(int pSala) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "empresa_aluno.id ,\n"
                    + "empresa_aluno.id_aluno,\n"
                    + "empresa_aluno.id_empresa ,\n"
                    + "empresa_aluno.data_inicio ,\n"
                    + "empresa_aluno.data_termino,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep ,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep ,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN empresa_aluno on cad_geral.id = empresa_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = empresa_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_geral.id ='" + pSala + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioDeclaracaoCurso.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioVersoCertificado(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "id,\n"
                    + "descricao,\n"
                    + "qt_horas,\n"
                    + "texto\n"
                    + "FROM gmz.verso_certificado"
                    + " where id ='" + pCodigo + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioVersoCertificado.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioCertificadoAprendiz(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cg.id,\n"
                    + "cg.nome_aluno,\n"
                    + "cg.rg_aluno,\n"
                    + "cg.rgm_aluno,\n"
                    + "cg.dt_admissao,\n"
                    + "cg.dt_rescisao,\n"
                    + "\n"
                    + "qc.curso,\n"
                    + "cg.carga_horaria_total,\n"
                    + "cbo.descricao as cbo,\n"
                    + "emp.razao as empresa,\n"
                    + "ht.descricao as horario\n"
                    + "   \n"
                    + "FROM\n"
                    + "      cad_geral cg left join cad_empresa  emp on cg.empresa = emp.id\n"
                    + "      left join cad_cbo cbo on cg.cbo = cbo.id left join qual_curso qc on cg.curso = qc.id\n"
                    + "      left join horario_trabalhado ht on cg.horario = ht.id\n"
                    + "      "
                    + " where cg.id ='" + pCodigo + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioCertificadoAprendiz.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioCertificadoAspirante(int pCodigo, int pAluno) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     cad_geral.`id`,\n"
                    + "     cad_geral.`nome_aluno`,\n"
                    + "     cad_geral.`cod_endereco`,\n"
                    + "     cad_geral.`rgm_aluno`,\n"
                    + "     cad_geral.`rg_aluno`,\n"
                    + "     cad_geral.`dt_nascimento`,\n"
                    + "     ca.periodo,\n"
                    + "     ca.data_conclusao,\n"
                    + "     ca.id as id_periodo\n"
                    + "FROM\n"
                    + "      cad_geral cross join periodo_certif_aspirante ca"
                    + " where ca.id ='" + pCodigo + "' and cad_geral.id ='" + pAluno + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioCertificadoAspirante.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioAvaliacaoInstitucionalSala(String pSala) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id"
                    + " where cad_sala.descricao='" + pSala + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioAvaliacaoInstitucional.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioAprendizagemTeorica(int pCodigo, int pAluno) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_geral.dt_admissao,\n"
                    + "cad_geral.dt_rescisao,\n"
                    + "cad_geral.int_per1,\n"
                    + "cad_geral.int_per2,\n"
                    + "cad_geral.int_per3,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "curso.curso,\n"
                    + "intensivo.descricao as intensivo,\n"
                    + "h.descricao as tipo_contrato,\n"
                    + "ap.texto\n"
                    + "FROM\n"
                    + "cad_geral left join cad_empresa ce on cad_geral.empresa = ce.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id\n"
                    + "left join intensivo on cad_geral.intensivo = intensivo.id\n"
                    + "left join horario_trabalhado h on cad_geral.horario = h.id\n"
                    + "cross join aprendizagem_teorica ap"
                    + " where ap.id ='"+pCodigo+"' and cad_geral.id = '"+pAluno+"'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioAprendizagemTeorica.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    public boolean gerarRelatorioListaPresencaDiaria(int pTurma) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + "cad_geral.dt_nascimento,\n"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.rg_aluno,\n"
                    + "cad_geral.rg_mae,\n"
                    + "cad_geral.rgm_aluno,\n"
                    + "cad_geral.responsavel,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_geral.dt_admissao,\n"
                    + "cad_geral.dt_rescisao,\n"
                    + "cad_geral.int_per1,\n"
                    + "cad_geral.int_per2,\n"
                    + "cad_geral.int_per3,\n"
                    + "cad_sala.descricao as sala,\n"
                    + "cad_turma.descricao as turma,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "curso.curso,\n"
                    + "intensivo.descricao as intensivo,\n"
                    + "h.descricao as tipo_contrato,\n"
                    + "ap.texto\n"
                    + "FROM\n"
                    + "cad_geral left join cad_empresa ce on cad_geral.empresa = ce.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_sala on cad_geral.sala = cad_sala.id\n"
                    + "left join cad_turma on cad_geral.turma = cad_turma.id\n"
                    + "left join intensivo on cad_geral.intensivo = intensivo.id\n"
                    + "left join horario_trabalhado h on cad_geral.horario = h.id\n"
                    + "cross join aprendizagem_teorica ap"
                    + " where cad_turma.descricao ='"+pTurma+"'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioIntensListaPresensaDiario.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "C:/BLVendasPdvMySQL/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

}
