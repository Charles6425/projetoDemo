package relatorios;

import conexoes.ConexaoMySql;
import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import model.ModelContaPagar;
import model.ModelContaReceber;
import model.ModelProdutos;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;
import view.ViewEncaminhamento;

/**
 *
 * @author Administrador
 */
public class DAORelatorios extends ConexaoMySql {

    public static int gera;

    public static int getGera() {
        return gera;
    }

    public static void setGera(int aGera) {
        gera = aGera;
    }

    public boolean gerarRelatorioEncaminhamento(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "cad_geral.id,\n"
                    + " cad_geral.dt_nascimento,"
                    + "cad_geral.nome_aluno,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "entrevista_aluno.id ,\n"
                    + "entrevista_aluno.id_aluno,\n"
                    + "entrevista_aluno.id_empresa ,\n"
                    + "entrevista_aluno.data_entrevista ,\n"
                    + "entrevista_aluno.horario_entrevista,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
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
                    + "cad_end1.end_uf as uf_emp \n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN entrevista_aluno on cad_geral.id = entrevista_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = entrevista_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco"
                    + "                 where cad_geral.id ='" + pCodigo + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioEncaminhamento.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "Relatorios/rel" + getGera() + ".pdf";
            System.out.println(getGera());
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();


            /*bkp do teste de varias impressões
            String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();*/
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioSaida(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     cad_geral.`id`,\n"
                    + "     cad_geral.`nome_aluno`,\n"
                    + "     cad_geral.`cod_endereco`,\n"
                    + "     cad_geral.`rgm_aluno`,\n"
                    + "     cad_geral.`dt_nascimento`,\n"
                    + "     motivo_saida.`id` as `id_motivo`,\n"
                    + "     motivo_saida.`motivo`,\n"
                    + "     motivo_saida.`data`\n"
                    + "    \n"
                    + "FROM\n"
                    + "      cad_geral inner join motivo_saida on cad_geral.id = motivo_saida.id_aluno"
                    + " where cad_geral.`id` = '" + pCodigo + "' and  motivo_saida.`data` >= date(NOW())");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioSaida.jasper");
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

    

    public boolean gerarRelatorioContrato411005(int pCodigo) {
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
                    + "entrevista_aluno.id ,\n"
                    + "entrevista_aluno.id_aluno,\n"
                    + "entrevista_aluno.id_empresa ,\n"
                    + "entrevista_aluno.data_entrevista ,\n"
                    + "entrevista_aluno.horario_entrevista,\n"
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
                    + "cad_geral LEFT JOIN entrevista_aluno on cad_geral.id = entrevista_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = entrevista_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id"
                    + " where cad_geral.`id` = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioContrato411005.jasper");
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

    public boolean gerarFichaMatAuxAdm(int pCodigo) {
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
                    + "entrevista_aluno.id ,\n"
                    + "entrevista_aluno.id_aluno,\n"
                    + "entrevista_aluno.id_empresa ,\n"
                    + "entrevista_aluno.data_entrevista ,\n"
                    + "entrevista_aluno.horario_entrevista,\n"
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
                    + "cad_geral LEFT JOIN entrevista_aluno on cad_geral.id = entrevista_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = entrevista_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id"
                    + " where cad_geral.`id` = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioFichaMatrAuxAdm.jasper");
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

    public boolean gerarFichaMatAssAdm(int pCodigo) {
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
                    + "entrevista_aluno.id ,\n"
                    + "entrevista_aluno.id_aluno,\n"
                    + "entrevista_aluno.id_empresa ,\n"
                    + "entrevista_aluno.data_entrevista ,\n"
                    + "entrevista_aluno.horario_entrevista,\n"
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
                    + "cad_geral LEFT JOIN entrevista_aluno on cad_geral.id = entrevista_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = entrevista_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id"
                    + " where cad_geral.`id` = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioFichaMatrAssistAdm.jasper");
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

    public boolean gerarFichaMatComercio(int pCodigo) {
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
                    + "entrevista_aluno.id ,\n"
                    + "entrevista_aluno.id_aluno,\n"
                    + "entrevista_aluno.id_empresa ,\n"
                    + "entrevista_aluno.data_entrevista ,\n"
                    + "entrevista_aluno.horario_entrevista,\n"
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
                    + "cad_geral LEFT JOIN entrevista_aluno on cad_geral.id = entrevista_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = entrevista_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id"
                    + " where cad_geral.`id` = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioFichaMatrComercio.jasper");
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

    public boolean gerarFichaMatAlimentador(int pCodigo) {
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
                    + "entrevista_aluno.id ,\n"
                    + "entrevista_aluno.id_aluno,\n"
                    + "entrevista_aluno.id_empresa ,\n"
                    + "entrevista_aluno.data_entrevista ,\n"
                    + "entrevista_aluno.horario_entrevista,\n"
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
                    + "cad_geral LEFT JOIN entrevista_aluno on cad_geral.id = entrevista_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = entrevista_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id"
                    + " where cad_geral.`id` = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioFichaMatrAlimentador.jasper");
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

    public boolean gerarFichaMatArco(int pCodigo) {
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
                    + "entrevista_aluno.id ,\n"
                    + "entrevista_aluno.id_aluno,\n"
                    + "entrevista_aluno.id_empresa ,\n"
                    + "entrevista_aluno.data_entrevista ,\n"
                    + "entrevista_aluno.horario_entrevista,\n"
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
                    + "cad_geral LEFT JOIN entrevista_aluno on cad_geral.id = entrevista_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = entrevista_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id"
                    + " where cad_geral.`id` = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioFichaMatrArcoServAdm.jasper");
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

    public boolean gerarFichaMatAux2(int pCodigo) {
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
                    + "entrevista_aluno.id ,\n"
                    + "entrevista_aluno.id_aluno,\n"
                    + "entrevista_aluno.id_empresa ,\n"
                    + "entrevista_aluno.data_entrevista ,\n"
                    + "entrevista_aluno.horario_entrevista,\n"
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
                    + "cad_geral LEFT JOIN entrevista_aluno on cad_geral.id = entrevista_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = entrevista_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id"
                    + " where cad_geral.`id` = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioFichaMatrAuxAdm2.jasper");
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

    public boolean gerarFichaMatAss2(int pCodigo) {
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
                    + "entrevista_aluno.id ,\n"
                    + "entrevista_aluno.id_aluno,\n"
                    + "entrevista_aluno.id_empresa ,\n"
                    + "entrevista_aluno.data_entrevista ,\n"
                    + "entrevista_aluno.horario_entrevista,\n"
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
                    + "cad_geral LEFT JOIN entrevista_aluno on cad_geral.id = entrevista_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = entrevista_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id"
                    + " where cad_geral.`id` = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioFichaMatrAssAdm2.jasper");
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

    public boolean gerarFichaMatComercio2(int pCodigo) {
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
                    + "entrevista_aluno.id ,\n"
                    + "entrevista_aluno.id_aluno,\n"
                    + "entrevista_aluno.id_empresa ,\n"
                    + "entrevista_aluno.data_entrevista ,\n"
                    + "entrevista_aluno.horario_entrevista,\n"
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
                    + "cad_geral LEFT JOIN entrevista_aluno on cad_geral.id = entrevista_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = entrevista_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id"
                    + " where cad_geral.`id` = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioFichaMatrComercio2.jasper");
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

    public boolean gerarFichaMatAlimentador2(int pCodigo) {
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
                    + "entrevista_aluno.id ,\n"
                    + "entrevista_aluno.id_aluno,\n"
                    + "entrevista_aluno.id_empresa ,\n"
                    + "entrevista_aluno.data_entrevista ,\n"
                    + "entrevista_aluno.horario_entrevista,\n"
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
                    + "cad_geral LEFT JOIN entrevista_aluno on cad_geral.id = entrevista_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = entrevista_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id"
                    + " where cad_geral.`id` = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioFichaMatrAlimentador2.jasper");
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

    public boolean gerarFichaMatArco2(int pCodigo) {
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
                    + "entrevista_aluno.id ,\n"
                    + "entrevista_aluno.id_aluno,\n"
                    + "entrevista_aluno.id_empresa ,\n"
                    + "entrevista_aluno.data_entrevista ,\n"
                    + "entrevista_aluno.horario_entrevista,\n"
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
                    + "cad_geral LEFT JOIN entrevista_aluno on cad_geral.id = entrevista_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = entrevista_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id"
                    + " where cad_geral.`id` = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioFichaMatrArcoServAdm2.jasper");
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

    public boolean gerarFichaRegistro(int pCodigo) {
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
                    + "cad_geral.cpf,\n"
                    + "cad_geral.mae,\n"
                    + "cad_geral.local_nascimento,\n"
                    + "cad_geral.pai,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "cad_geral.numero as num_aluno,\n"
                    + "cad_geral.tel_1,\n"
                    + "cad_geral.pis,\n"
                    + "cad_geral.altura,\n"
                    + "cad_geral.cor,\n"
                    + "cad_geral.olhos,\n"
                    + "cad_geral.cabelos,\n"
                    + "cad_geral.sinais,\n"
                    + "cad_geral.peso,\n"
                    + "cad_geral.dt_emissao_pis,\n"
                    + "cad_geral.nacionalidade,\n"
                    + "cad_geral.estado_civil,\n"
                    + "ce.id,\n"
                    + "ce.razao ,\n"
                    + "ce.contato ,\n"
                    + "ce.cnpj ,\n"
                    + "ce.cod_endereco as cod_end_empresa ,\n"
                    + "ce.numero as num_empresa,\n"
                    + "ce.complemento,\n"
                    + "cad_end.end_codigo ,\n"
                    + "cad_end.end_cep as cep_aluno,\n"
                    + "cad_end.end_logradouro rua_aluno,\n"
                    + "cad_end.end_bairro as bairro_aluno ,\n"
                    + "cad_end.end_cidade as cid_aluno,\n"
                    + "cad_end.end_uf as uf_aluno,\n"
                    + "cad_end1.end_codigo ,\n"
                    + "cad_end1.end_cep as cep_aluno,\n"
                    + "cad_end1.end_logradouro rua_emp,\n"
                    + "cad_end1.end_bairro as bairro_emp,\n"
                    + "cad_end1.end_cidade as cid_emp,\n"
                    + "cad_end1.end_uf as uf_emp,\n"
                    + "h.descricao as horario,\n"
                    + "curso.curso,\n"
                    + "cbo.descricao as cbo,\n"
                    + "admissao.inicio,\n"
                    + "admissao.salario,\n"
                    + "admissao.empresa\n"
                    + "FROM\n"
                    + "cad_geral LEFT JOIN admissao on cad_geral.id = admissao.aprendiz\n"
                    + "LEFT join cad_empresa ce on ce.id = admissao.empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id\n"
                    + " where cad_geral.`id` = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioFichaRegistro.jasper");
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

    public boolean gerarRelatorioContratoBanco(int pCodigo) {
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
                    + "cad_geral.cpf,\n"
                    + "cad_geral.cod_endereco,\n"
                    + "entrevista_aluno.id ,\n"
                    + "entrevista_aluno.id_aluno,\n"
                    + "entrevista_aluno.id_empresa ,\n"
                    + "entrevista_aluno.data_entrevista ,\n"
                    + "entrevista_aluno.horario_entrevista,\n"
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
                    + "cad_geral LEFT JOIN entrevista_aluno on cad_geral.id = entrevista_aluno.id_aluno\n"
                    + "LEFT join cad_empresa ce on ce.id = entrevista_aluno.id_empresa\n"
                    + "LEFT join cad_endereco cad_end on cad_end.end_codigo = cad_geral.cod_endereco\n"
                    + "LEFT join cad_endereco cad_end1 on cad_end1.end_codigo = ce.cod_endereco\n"
                    + "LEFT JOIN horario h on cad_geral.horario = h.id\n"
                    + "left join qual_curso curso on cad_geral.curso = curso.id\n"
                    + "left join cad_cbo cbo on cad_geral.cbo = cbo.id"
                    + " where cad_geral.`id` = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioContratoBanco.jasper");
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

    public boolean gerarRelatorioVendaDataIniFim(Date pDataIni, Date pDataFim, String pStatus) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     vendas.`CODIGO` AS vendas_CODIGO,\n"
                    + "     vendas.`CLIENTES_CODIGO` AS vendas_CLIENTES_CODIGO,\n"
                    + "     vendas.`DATA_VENDA` AS vendas_DATA_VENDA,\n"
                    + "     vendas.`VALOR_TOTAL` AS vendas_VALOR_TOTAL,\n"
                    + "     vendas.`troco` AS vendas_troco,\n"
                    + "     vendas.`DESCONTO` AS vendas_DESCONTO,\n"
                    + "     vendas.`TIPO_PAGAMENTO` AS vendas_TIPO_PAGAMENTO,\n"
                    + "     vendas.`chave_acesso` AS vendas_chave_acesso,\n"
                    + "     vendas.`cpf_cliente` AS vendas_cpf_cliente,\n"
                    + "     vendas.`comanda` AS vendas_comanda,\n"
                    + "     vendas.`status` AS vendas_status,\n"
                    + "     vendas.`terminal` AS vendas_terminal,\n"
                    + "     vendas.`vendedor` AS vendas_vendedor,\n"
                    + "     vendas.`hora` AS vendas_hora,\n"
                    + "     cad_cliente.`CODIGO` AS cad_cliente_CODIGO,\n"
                    + "     cad_cliente.`NOME` AS cad_cliente_NOME,\n"
                    + "     cad_cliente.`ENDERECO` AS cad_cliente_ENDERECO,\n"
                    + "     cad_cliente.`TELEFONE` AS cad_cliente_TELEFONE,\n"
                    + "     cad_cliente.`numero` AS cad_cliente_numero,\n"
                    + "     cad_cliente.`complemento` AS cad_cliente_complemento,\n"
                    + "     cad_cliente.`data_nasc` AS cad_cliente_data_nasc,\n"
                    + "     cad_cliente.`cpf` AS cad_cliente_cpf,\n"
                    + "     cad_cliente.`referencia` AS cad_cliente_referencia,\n"
                    + "     cad_cliente.`email` AS cad_cliente_email,\n"
                    + "     tbl_usuarios.`pk_codigo` AS tbl_usuarios_pk_codigo,\n"
                    + "     tbl_usuarios.`nome` AS tbl_usuarios_nome,\n"
                    + "     tbl_usuarios.`login` AS tbl_usuarios_login,\n"
                    + "     tbl_usuarios.`senha` AS tbl_usuarios_senha,\n"
                    + "     tbl_usuarios.`grupo` AS tbl_usuarios_grupo,\n"
                    + "     tbl_usuarios.`tempo` AS tbl_usuarios_tempo\n"
                    + "FROM\n"
                    + "     `cad_cliente` cad_cliente INNER JOIN `vendas` vendas ON cad_cliente.`CODIGO` = vendas.`CLIENTES_CODIGO`\n"
                    + "     left JOIN `tbl_usuarios` tbl_usuarios ON vendas.`vendedor` = tbl_usuarios.`pk_codigo`"
                    + " Where vendas.DATA_VENDA between '" + pDataIni + "' and '" + pDataFim + "' and vendas.status = '" + pStatus + "'"
            );
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioVendasData.jasper");
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
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "ErroCha2:", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, e);

            return false;
        }
        return true;
    }

    public boolean gerarRelatorioOP(Date pDataIni, Date pDataFim, String pStatus) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     ordem_producao.`id` AS ordem_producao_id,\n"
                    + "     ordem_producao.`data` AS ordem_producao_data,\n"
                    + "     ordem_producao.`cod_item` AS ordem_producao_cod_item,\n"
                    + "     ordem_producao.`qt_item` AS ordem_producao_qt_item,\n"
                    + "     ordem_producao.`un_item` AS ordem_producao_un_item,\n"
                    + "     ordem_producao.`cod_usuario` AS ordem_producao_cod_usuario,\n"
                    + "     ordem_producao.`custo_total` AS ordem_producao_custo_total,\n"
                    + "     ordem_producao.`status` AS ordem_producao_status,\n"
                    + "     produtos.`CODIGO` AS produtos_CODIGO,\n"
                    + "     produtos.`FORNECEDORES_CODIGO` AS produtos_FORNECEDORES_CODIGO,\n"
                    + "     produtos.`NOME` AS produtos_NOME,\n"
                    + "     produtos.`VALOR` AS produtos_VALOR,\n"
                    + "     produtos.`ESTOQUE` AS produtos_ESTOQUE,\n"
                    + "     produtos.`CODIGO_BARRAS` AS produtos_CODIGO_BARRAS,\n"
                    + "     produtos.`prod_grupo` AS produtos_prod_grupo,\n"
                    + "     produtos.`prod_un` AS produtos_prod_un,\n"
                    + "     produtos.`prod_ncm` AS produtos_prod_ncm,\n"
                    + "     produtos.`prod_cest` AS produtos_prod_cest,\n"
                    + "     produtos.`prod_origem` AS produtos_prod_origem,\n"
                    + "     produtos.`prod_tributacao` AS produtos_prod_tributacao,\n"
                    + "     produtos.`prod_situacao` AS produtos_prod_situacao,\n"
                    + "     produtos.`prod_nome_resumido` AS produtos_prod_nome_resumido,\n"
                    + "     produtos.`prod_ingrediente` AS produtos_prod_ingrediente,\n"
                    + "     produtos.`utiliza_composicao` AS produtos_utiliza_composicao,\n"
                    + "     produtos.`prod_anvisa` AS produtos_prod_anvisa,\n"
                    + "     produtos.`prod_custo` AS produtos_prod_custo,\n"
                    + "     produtos.`prod_estoque_minimo` AS produtos_prod_estoque_minimo,\n"
                    + "     produtos.`fator_conversao` AS produtos_fator_conversao,\n"
                    + "     produtos.`forca_de_vendas` AS produtos_forca_de_vendas,\n"
                    + "     produtos.`fator_conversao_estoque` AS produtos_fator_conversao_estoque,\n"
                    + "     produtos.`un_volume` AS produtos_un_volume,\n"
                    + "     produtos.`nao_fraciona` AS produtos_nao_fraciona,\n"
                    + "     tbl_usuarios.`pk_codigo` AS tbl_usuarios_pk_codigo,\n"
                    + "     tbl_usuarios.`nome` AS tbl_usuarios_nome,\n"
                    + "     tbl_usuarios.`login` AS tbl_usuarios_login,\n"
                    + "     tbl_usuarios.`senha` AS tbl_usuarios_senha,\n"
                    + "     tbl_usuarios.`grupo` AS tbl_usuarios_grupo,\n"
                    + "     tbl_usuarios.`tempo` AS tbl_usuarios_tempo\n"
                    + " FROM\n"
                    + "     `produtos` produtos inner JOIN `ordem_producao` ordem_producao ON produtos.`CODIGO` = ordem_producao.`cod_item`\n"
                    + "     inner JOIN `tbl_usuarios` tbl_usuarios ON ordem_producao.`cod_usuario` = tbl_usuarios.`pk_codigo`"
                    + " where cast(data as date)  between ' " + pDataIni + "' and '" + pDataFim + "' and ordem_producao.`status`= '" + pStatus + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioOP.jasper");
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
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "ErroCha2:", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, e);

            return false;
        }
        return true;
    }

    public boolean gerarRelatorioEstoqueMinimo() {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     produtos.`CODIGO` AS produtos_CODIGO,\n"
                    + "     produtos.`FORNECEDORES_CODIGO` AS produtos_FORNECEDORES_CODIGO,\n"
                    + "     produtos.`NOME` AS produtos_NOME,\n"
                    + "     produtos.`VALOR` AS produtos_VALOR,\n"
                    + "     produtos.`ESTOQUE` AS produtos_ESTOQUE,\n"
                    + "     produtos.`CODIGO_BARRAS` AS produtos_CODIGO_BARRAS,\n"
                    + "     produtos.`prod_grupo` AS produtos_prod_grupo,\n"
                    + "     produtos.`prod_un` AS produtos_prod_un,\n"
                    + "     produtos.`prod_ncm` AS produtos_prod_ncm,\n"
                    + "     produtos.`prod_cest` AS produtos_prod_cest,\n"
                    + "     produtos.`prod_origem` AS produtos_prod_origem,\n"
                    + "     produtos.`prod_tributacao` AS produtos_prod_tributacao,\n"
                    + "     produtos.`prod_situacao` AS produtos_prod_situacao,\n"
                    + "     produtos.`prod_nome_resumido` AS produtos_prod_nome_resumido,\n"
                    + "     produtos.`prod_ingrediente` AS produtos_prod_ingrediente,\n"
                    + "     produtos.`utiliza_composicao` AS produtos_utiliza_composicao,\n"
                    + "     produtos.`prod_anvisa` AS produtos_prod_anvisa,\n"
                    + "     produtos.`prod_custo` AS produtos_prod_custo,\n"
                    + "     produtos.`prod_estoque_minimo` AS produtos_prod_estoque_minimo,\n"
                    + "     produtos.`fator_conversao` AS produtos_fator_conversao\n"
                    + " FROM\n"
                    + "     produtos where produtos.`ESTOQUE` <=  produtos.`prod_estoque_minimo`"
                    + "");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioEstoqueMinimo.jasper");
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

    public boolean gerarRelatorioEstoqueMinimoGrupo(int pGrupo) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     produtos.`CODIGO` AS produtos_CODIGO,\n"
                    + "     produtos.`FORNECEDORES_CODIGO` AS produtos_FORNECEDORES_CODIGO,\n"
                    + "     produtos.`NOME` AS produtos_NOME,\n"
                    + "     produtos.`VALOR` AS produtos_VALOR,\n"
                    + "     produtos.`ESTOQUE` AS produtos_ESTOQUE,\n"
                    + "     produtos.`CODIGO_BARRAS` AS produtos_CODIGO_BARRAS,\n"
                    + "     produtos.`prod_grupo` AS produtos_prod_grupo,\n"
                    + "     produtos.`prod_un` AS produtos_prod_un,\n"
                    + "     produtos.`prod_ncm` AS produtos_prod_ncm,\n"
                    + "     produtos.`prod_cest` AS produtos_prod_cest,\n"
                    + "     produtos.`prod_origem` AS produtos_prod_origem,\n"
                    + "     produtos.`prod_tributacao` AS produtos_prod_tributacao,\n"
                    + "     produtos.`prod_situacao` AS produtos_prod_situacao,\n"
                    + "     produtos.`prod_nome_resumido` AS produtos_prod_nome_resumido,\n"
                    + "     produtos.`prod_ingrediente` AS produtos_prod_ingrediente,\n"
                    + "     produtos.`utiliza_composicao` AS produtos_utiliza_composicao,\n"
                    + "     produtos.`prod_anvisa` AS produtos_prod_anvisa,\n"
                    + "     produtos.`prod_custo` AS produtos_prod_custo,\n"
                    + "     produtos.`prod_estoque_minimo` AS produtos_prod_estoque_minimo,\n"
                    + "     produtos.`fator_conversao` AS produtos_fator_conversao\n"
                    + " FROM\n"
                    + "     produtos where produtos.`ESTOQUE` <=  produtos.`prod_estoque_minimo` "
                    + " and produtos.`prod_grupo` =' " + pGrupo + "'"
                    + "");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioEstoqueMinimo.jasper");
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

    public boolean gerarRelatorioVendaProdutoDataIniFim(Date pDataIni, Date pDataFim, String pStatus) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     vendas_produto.`CODIGO` AS vendas_produto_CODIGO,\n"
                    + "     vendas_produto.`CODIGO_PRODUTO` AS vendas_produto_CODIGO_PRODUTO,\n"
                    + "     vendas_produto.`CODIGO_VENDA` AS vendas_produto_CODIGO_VENDA,\n"
                    + "     vendas_produto.`QUANTIDADE` AS vendas_produto_QUANTIDADE,\n"
                    + "     vendas_produto.`item` AS vendas_produto_item,\n"
                    + "     vendas_produto.`nome` AS vendas_produto_nome,\n"
                    + "     vendas.`CODIGO` AS vendas_CODIGO,\n"
                    + "     vendas.`CLIENTES_CODIGO` AS vendas_CLIENTES_CODIGO,\n"
                    + "     vendas.`DATA_VENDA` AS vendas_DATA_VENDA,\n"
                    + "     vendas.`VALOR_TOTAL` AS vendas_VALOR_TOTAL,\n"
                    + "     vendas.`TIPO_PAGAMENTO` AS vendas_TIPO_PAGAMENTO,\n"
                    + "     vendas.`status` AS vendas_status,\n"
                    + "     vendas.`terminal` AS vendas_terminal,\n"
                    + "     vendas.`hora` AS vendas_hora,\n"
                    + "     vendas.`vendedor` AS vendas_vendedor,\n"
                    + "     ven_tipo_pagto.`ven_id` AS ven_tipo_pagto_ven_id,\n"
                    + "     ven_tipo_pagto.`ven_cod_venda` AS ven_tipo_pagto_ven_cod_venda,\n"
                    + "     ven_tipo_pagto.`ven_tipo_pagto` AS ven_tipo_pagto_ven_tipo_pagto,\n"
                    + "     ven_tipo_pagto.`ven_valor` AS ven_tipo_pagto_ven_valor,\n"
                    + "     ven_tipo_pagto.`ven_valor_digitado` AS ven_tipo_pagto_ven_valor_digitado,\n"
                    + "     ven_tipo_pagto.`ven_data_venda` AS ven_tipo_pagto_ven_data_venda,\n"
                    + "     ven_tipo_pagto.`ven_hora` AS ven_tipo_pagto_ven_hora,\n"
                    + "     ven_tipo_pagto.`ven_bandeira` AS ven_tipo_pagto_ven_bandeira,\n"
                    + "     ven_tipo_pagto.`ven_id_caixa` AS ven_tipo_pagto_ven_id_caixa,\n"
                    + "     ven_tipo_pagto.`ven_id_turno` AS ven_tipo_pagto_ven_id_turno,\n"
                    + "     ven_tipo_pagto.`ven_status_turno` AS ven_tipo_pagto_ven_status_turno,\n"
                    + "     vendas_produto.`valor` AS vendas_produto_valor,\n"
                    + "     produtos.`CODIGO` AS produtos_CODIGO,\n"
                    + "     produtos.`NOME` AS produtos_NOME,\n"
                    + "     produtos.`VALOR` AS produtos_VALOR,\n"
                    + "     produtos.`CODIGO_BARRAS` AS produtos_CODIGO_BARRAS,\n"
                    + "     produtos.`prod_grupo` AS produtos_prod_grupo,\n"
                    + "     produtos.`prod_nome_resumido` AS produtos_prod_nome_resumido,\n"
                    + "     produtos.`prod_un` AS produtos_prod_un,\n"
                    + "     tipo_pagamento.`pk_codigo` AS tipo_pagamento_pk_codigo,\n"
                    + "     tipo_pagamento.`descricao` AS tipo_pagamento_descricao,\n"
                    + "     vendas.`DESCONTO` AS vendas_DESCONTO,\n"
                    + "     tbl_usuarios.`pk_codigo` AS tbl_usuarios_pk_codigo,\n"
                    + "     tbl_usuarios.`nome` AS tbl_usuarios_nome\n"
                    + "FROM\n"
                    + "     `vendas` vendas INNER JOIN `vendas_produto` vendas_produto ON vendas.`CODIGO` = vendas_produto.`CODIGO_VENDA`\n"
                    + "     left JOIN `ven_tipo_pagto` ven_tipo_pagto ON vendas.`TIPO_PAGAMENTO` = ven_tipo_pagto.`ven_tipo_pagto`\n"
                    + "     AND vendas.`CODIGO` = ven_tipo_pagto.`ven_cod_venda`\n"
                    + "     LEFT JOIN `tbl_usuarios` tbl_usuarios ON vendas.`vendedor` = tbl_usuarios.`pk_codigo`\n"
                    + "     left JOIN `tipo_pagamento` tipo_pagamento ON ven_tipo_pagto.`ven_tipo_pagto` = tipo_pagamento.`pk_codigo`\n"
                    + "     INNER JOIN `produtos` produtos ON vendas_produto.`CODIGO_PRODUTO` = produtos.`CODIGO`" + " Where vendas.DATA_VENDA between '" + pDataIni + "' and '" + pDataFim + "' and vendas.status = '" + pStatus + "'"
            );
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatoriovendasProdutosData.jasper");
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

    public boolean gerarRelatorioComissaoVendedores(Date pDataIni, Date pDataFim) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     vendas.`CODIGO` AS vendas_CODIGO,\n"
                    + "     vendas.`CLIENTES_CODIGO` AS vendas_CLIENTES_CODIGO,\n"
                    + "     vendas.`DATA_VENDA` AS vendas_DATA_VENDA,\n"
                    + "     vendas.`VALOR_TOTAL` AS vendas_VALOR_TOTAL,\n"
                    + "     vendas.`DESCONTO` AS vendas_DESCONTO,\n"
                    + "     vendas.`TIPO_PAGAMENTO` AS vendas_TIPO_PAGAMENTO,\n"
                    + "     vendas.`status` AS vendas_status,\n"
                    + "     vendas.`vendedor` AS vendas_vendedor,\n"
                    + "     tbl_usuarios.`pk_codigo` AS tbl_usuarios_pk_codigo,\n"
                    + "     tbl_usuarios.`nome` AS tbl_usuarios_nome,\n"
                    + "     tbl_usuarios.`login` AS tbl_usuarios_login,\n"
                    + "     tbl_usuarios.`comissao` AS tbl_usuarios_comissao\n"
                    + " FROM\n"
                    + "     `vendas` vendas INNER JOIN `tbl_usuarios` tbl_usuarios ON vendas.`vendedor` = tbl_usuarios.`pk_codigo`\n"
                    + " where vendas.`DATA_VENDA` between '" + pDataIni + "' and '" + pDataFim + "' "
                    + " group by tbl_usuarios.`login`, vendas.`CODIGO`");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioComissao.jasper");
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

    public boolean gerarRelatorioProdutosMaisVendidos(Date pDataIni, Date pDataFim) {
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + " codigo_produto,p.prod_nome_resumido,  sum(quantidade) as 'Total vendido', v.DATA_VENDA"
                    + " FROM vendas_produto vp "
                    + " join vendas v on v.codigo = vp.codigo_venda"
                    + " join produtos p on p.codigo = vp.codigo_produto"
                    + " WHERE v.data_venda between '" + pDataIni + "' and '" + pDataFim + "'"
                    + " group by "
                    + " codigo_produto, quantidade, v.data_venda, p.prod_nome_resumido"
                    + " order by quantidade,v.data_venda "
            );
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioProdutosMaisVendidos.jasper");
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

    public boolean gerarRelatorioOP(int pID) {
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT\n"
                    + "     produtos.`CODIGO` AS produtos_CODIGO,\n"
                    + "     produtos.`NOME` AS produtos_NOME,\n"
                    + "     produtos.`VALOR` AS produtos_VALOR,\n"
                    + "     produtos.`ESTOQUE` AS produtos_ESTOQUE,\n"
                    + "     produtos.`CODIGO_BARRAS` AS produtos_CODIGO_BARRAS,\n"
                    + "     produtos.`prod_un` AS produtos_prod_un,\n"
                    + "     ordem_producao.`id` AS ordem_producao_id,\n"
                    + "     ordem_producao.`data` AS ordem_producao_data,\n"
                    + "     ordem_producao.`cod_item` AS ordem_producao_cod_item,\n"
                    + "     ordem_producao.`qt_item` AS ordem_producao_qt_item,\n"
                    + "     ordem_producao.`un_item` AS ordem_producao_un_item,\n"
                    + "     ordem_producao.`cod_usuario` AS ordem_producao_cod_usuario,\n"
                    + "     ordem_producao.`custo_total` AS ordem_producao_custo_total,\n"
                    + "     produtos.`prod_custo` AS produtos_prod_custo,\n"
                    + "     cad_unidade.`un_codigo` AS cad_unidade_un_codigo,\n"
                    + "     cad_unidade.`un_descricao` AS cad_unidade_un_descricao\n"
                    + "  FROM\n"
                    + "     `ordem_producao` ordem_producao INNER JOIN "
                    + " `produtos` produtos ON ordem_producao.`cod_item` = produtos.`CODIGO`\n"
                    + "     INNER JOIN `cad_unidade` cad_unidade ON produtos.`prod_un` = cad_unidade.`un_codigo`"
                    + " where ordem_producao.id = ' " + pID + "'"
            );
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioOrdemProducao.jasper");
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

    public boolean gerarRelatorioFechamentoCaixa(int pID) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     movimento.`id` AS movimento_id,\n"
                    + "     movimento.`id_gerente` AS movimento_id_gerente,\n"
                    + "     movimento.`data_abertura` AS movimento_data_abertura,\n"
                    + "     movimento.`hora_abertura` AS movimento_hora_abertura,\n"
                    + "     movimento.`data_fechamento` AS movimento_data_fechamento,\n"
                    + "     movimento.`hora_fechamento` AS movimento_hora_fechamento,\n"
                    + "     movimento.`total_suprimento` AS movimento_total_suprimento,\n"
                    + "     movimento.`total_sangria` AS movimento_total_sangria,\n"
                    + "     movimento.`total_venda` AS movimento_total_venda,\n"
                    + "     movimento.`total_desconto` AS movimento_total_desconto,\n"
                    + "     movimento.`total_acrescimo` AS movimento_total_acrescimo,\n"
                    + "     movimento.`total_final` AS movimento_total_final,\n"
                    + "     movimento.`total_recebido` AS movimento_total_recebido,\n"
                    + "     movimento.`total_troco` AS movimento_total_troco,\n"
                    + "     movimento.`total_cancelado` AS movimento_total_cancelado,\n"
                    + "     movimento.`status_movimento` AS movimento_status_movimento,\n"
                    + "     movimento.`id_empresa` AS movimento_id_empresa,\n"
                    + "     movimento.`id_turno` AS movimento_id_turno,\n"
                    + "     movimento.`id_caixa` AS movimento_id_caixa,\n"
                    + "     movimento.`id_operador` AS movimento_id_operador,\n"
                    + "     movimento.`id_gerente_fechto` AS movimento_id_gerente_fechto,\n"
                    + "     movimento.`id_operador_fechto` AS movimento_id_operador_fechto,\n"
                    + "     tbl_usuarios.`pk_codigo` AS tbl_usuarios_pk_codigo,\n"
                    + "     tbl_usuarios.`nome` AS tbl_usuarios_nome,\n"
                    + "     tbl_usuarios.`login` AS tbl_usuarios_login,\n"
                    + "     tbl_usuarios.`senha` AS tbl_usuarios_senha,\n"
                    + "     tbl_usuarios.`grupo` AS tbl_usuarios_grupo,\n"
                    + "     tbl_usuarios.`tempo` AS tbl_usuarios_tempo\n"
                    + " FROM\n"
                    + "     `tbl_usuarios` tbl_usuarios INNER JOIN `movimento` movimento ON tbl_usuarios.`pk_codigo` = movimento.`id_gerente_fechto`"
                    + " where movimento.`id` = '" + pID + "'"
            );
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/FechamentoCaixa.jasper");
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

    public boolean gerarRelatorioRomaneioEntrega(int pVendaCodigo) {
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT\n"
                    + "     vendas.`CODIGO` AS vendas_CODIGO,\n"
                    + "     vendas.`CLIENTES_CODIGO` AS vendas_CLIENTES_CODIGO,\n"
                    + "     vendas.`DATA_VENDA` AS vendas_DATA_VENDA,\n"
                    + "     vendas.`VALOR_TOTAL` AS vendas_VALOR_TOTAL,\n"
                    + "     vendas.`TIPO_PAGAMENTO` AS vendas_TIPO_PAGAMENTO,\n"
                    + "     vendas_produto.`CODIGO` AS vendas_produto_CODIGO,\n"
                    + "     vendas_produto.`CODIGO_PRODUTO` AS vendas_produto_CODIGO_PRODUTO,\n"
                    + "     vendas_produto.`CODIGO_VENDA` AS vendas_produto_CODIGO_VENDA,\n"
                    + "     vendas_produto.`QUANTIDADE` AS vendas_produto_QUANTIDADE,\n"
                    + "     vendas_produto.`un_descricao` AS vendas_produto_un_descricao,\n"
                    + "     cad_cliente.`CODIGO` AS cad_cliente_CODIGO,\n"
                    + "     cad_cliente.`NOME` AS cad_cliente_NOME,\n"
                    + "     cad_cliente.`ENDERECO` AS cad_cliente_ENDERECO,\n"
                    + "     cad_cliente.`TELEFONE` AS cad_cliente_TELEFONE,\n"
                    + "     cad_cliente.`numero` AS cad_cliente_numero,\n"
                    + "     cad_cliente.`complemento` AS cad_cliente_complemento,\n"
                    + "     cad_cliente.`data_nasc` AS cad_cliente_data_nasc,\n"
                    + "     cad_cliente.`cpf` AS cad_cliente_cpf,\n"
                    + "     cad_cliente.`referencia` AS cad_cliente_referencia,\n"
                    + "     cad_cliente.`email` AS cad_cliente_email,\n"
                    + "     produtos.`CODIGO` AS produtos_CODIGO,\n"
                    + "     produtos.`FORNECEDORES_CODIGO` AS produtos_FORNECEDORES_CODIGO,\n"
                    + "     produtos.`NOME` AS produtos_NOME,\n"
                    + "     produtos.`VALOR` AS produtos_VALOR,\n"
                    + "     produtos.`ESTOQUE` AS produtos_ESTOQUE,\n"
                    + "     produtos.`CODIGO_BARRAS` AS produtos_CODIGO_BARRAS,\n"
                    + "     produtos.`prod_grupo` AS produtos_prod_grupo,\n"
                    + "     produtos.`prod_un` AS produtos_prod_un,\n"
                    + "     produtos.`prod_ncm` AS produtos_prod_ncm,\n"
                    + "     produtos.`prod_cest` AS produtos_prod_cest,\n"
                    + "     produtos.`prod_origem` AS produtos_prod_origem,\n"
                    + "     produtos.`prod_tributacao` AS produtos_prod_tributacao,\n"
                    + "     produtos.`prod_situacao` AS produtos_prod_situacao,\n"
                    + "     produtos.`prod_nome_resumido` AS produtos_prod_nome_resumido,\n"
                    + "     produtos.`prod_ingrediente` AS produtos_prod_ingrediente,\n"
                    + "     produtos.`utiliza_composicao` AS produtos_utiliza_composicao,\n"
                    + "     produtos.`prod_anvisa` AS produtos_prod_anvisa,\n"
                    + "     produtos.`prod_custo` AS produtos_prod_custo,\n"
                    + "     produtos.`prod_estoque_minimo` AS produtos_prod_estoque_minimo,\n"
                    + "     cad_endereco.`end_codigo` AS cad_endereco_end_codigo,\n"
                    + "     cad_endereco.`end_cep` AS cad_endereco_end_cep,\n"
                    + "     cad_endereco.`end_logradouro` AS cad_endereco_end_logradouro,\n"
                    + "     cad_endereco.`end_bairro` AS cad_endereco_end_bairro,\n"
                    + "     cad_endereco.`end_cidade` AS cad_endereco_end_cidade,\n"
                    + "     cad_endereco.`end_uf` AS cad_endereco_end_uf,\n"
                    + "     cad_endereco.`end_cod_ibge` AS cad_endereco_end_cod_ibge\n"
                    + "FROM\n"
                    + "     `vendas` vendas INNER JOIN `vendas_produto` vendas_produto ON vendas.`CODIGO` = vendas_produto.`CODIGO_VENDA`\n"
                    + "     INNER JOIN `cad_cliente` cad_cliente ON vendas.`CLIENTES_CODIGO` = cad_cliente.`CODIGO`\n"
                    + "     LEFT JOIN `cad_endereco` cad_endereco ON cad_cliente.`ENDERECO` = cad_endereco.`end_codigo`\n"
                    + "     INNER JOIN `produtos` produtos ON vendas_produto.`CODIGO_PRODUTO` = produtos.`CODIGO`"
                    + " where vendas.CODIGO = ' " + pVendaCodigo + "'"
            );
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/romaneioEntregaSalara.jasper");
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

    public boolean gerarRelatorioMovimentoCaixa(Date pDataIni, Date pDataFim) {
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT\n"
                    + "     movto_caixa.`movto_id` AS movto_caixa_movto_id,\n"
                    + "     movto_caixa.`movto_valor` AS movto_caixa_movto_valor,\n"
                    + "     movto_caixa.`movto_motivo` AS movto_caixa_movto_motivo,\n"
                    + "     movto_caixa.`movto_tipo` AS movto_caixa_movto_tipo,\n"
                    + "     movto_caixa.`movto_operador` AS movto_caixa_movto_operador,\n"
                    + "     movto_caixa.`movto_terminal` AS movto_caixa_movto_terminal,\n"
                    + "     movto_caixa.`movto_data` AS movto_caixa_movto_data,\n"
                    + "     movto_caixa.`movto_hora` AS movto_caixa_movto_hora,\n"
                    + "     tbl_usuarios.`pk_codigo` AS tbl_usuarios_pk_codigo,\n"
                    + "     tbl_usuarios.`nome` AS tbl_usuarios_nome,\n"
                    + "     tbl_usuarios.`login` AS tbl_usuarios_login,\n"
                    + "     tbl_usuarios.`senha` AS tbl_usuarios_senha,\n"
                    + "     tbl_usuarios.`grupo` AS tbl_usuarios_grupo,\n"
                    + "     tbl_usuarios.`tempo` AS tbl_usuarios_tempo\n"
                    + " FROM\n"
                    + "     `movto_caixa` movto_caixa INNER JOIN `tbl_usuarios` tbl_usuarios ON movto_caixa.`movto_operador` = tbl_usuarios.`pk_codigo` "
                    + " Where movto_caixa.movto_data between '" + pDataIni + "' and '" + pDataFim + "'"
            );
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioMovimentoCaixa.jasper");
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

    public boolean gerarRelatorioProdutos() {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     produtos.`CODIGO` AS produtos_CODIGO,\n"
                    + "     produtos.`FORNECEDORES_CODIGO` AS produtos_FORNECEDORES_CODIGO,\n"
                    + "     produtos.`NOME` AS produtos_NOME,\n"
                    + "     produtos.`VALOR` AS produtos_VALOR,\n"
                    + "     produtos.`ESTOQUE` AS produtos_ESTOQUE,\n"
                    + "     produtos.`CODIGO_BARRAS` AS produtos_CODIGO_BARRAS,\n"
                    + "     produtos.`prod_grupo` AS produtos_prod_grupo,\n"
                    + "     produtos.`prod_un` AS produtos_prod_un,\n"
                    + "     produtos.`prod_ncm` AS produtos_prod_ncm,\n"
                    + "     produtos.`prod_cest` AS produtos_prod_cest,\n"
                    + "     produtos.`prod_origem` AS produtos_prod_origem,\n"
                    + "     produtos.`prod_tributacao` AS produtos_prod_tributacao,\n"
                    + "     produtos.`prod_situacao` AS produtos_prod_situacao,\n"
                    + "     produtos.`prod_nome_resumido` AS produtos_prod_nome_resumido,\n"
                    + "     produtos.`prod_ingrediente` AS produtos_prod_ingrediente,\n"
                    + "     produtos.`utiliza_composicao` AS produtos_utiliza_composicao,\n"
                    + "     produtos.`prod_anvisa` AS produtos_prod_anvisa,\n"
                    + "     produtos.`prod_custo` AS produtos_prod_custo,\n"
                    + "     produtos.`prod_estoque_minimo` AS produtos_prod_estoque_minimo,\n"
                    + "     produtos.`fator_conversao` AS produtos_fator_conversao,\n"
                    + "     total_custo.`codigo` AS total_custo_codigo,\n"
                    + "     total_custo.`estoque` AS total_custo_estoque,\n"
                    + "     total_custo.`prod_custo` AS total_custo_prod_custo,\n"
                    + "     total_custo.`custo total` AS total_custo_custo_total,\n"
                    + "     vw_total_valor_vda.`codigo` AS vw_total_valor_vda_codigo,\n"
                    + "     vw_total_valor_vda.`estoque` AS vw_total_valor_vda_estoque,\n"
                    + "     vw_total_valor_vda.`valor` AS vw_total_valor_vda_valor,\n"
                    + "     vw_total_valor_vda.`valor_total_venda` AS vw_total_valor_vda_valor_total_venda,\n"
                    + "     produtos.`forca_de_vendas` AS produtos_forca_de_vendas,\n"
                    + "     produtos.`fator_conversao_estoque` AS produtos_fator_conversao_estoque,\n"
                    + "     produtos.`un_volume` AS produtos_un_volume,\n"
                    + "     cad_unidade.`un_codigo` AS cad_unidade_un_codigo,\n"
                    + "     cad_unidade.`un_descricao` AS cad_unidade_un_descricao\n"
                    + "FROM\n"
                    + "     `total_custo` total_custo INNER JOIN `produtos` produtos ON total_custo.`codigo` = produtos.`CODIGO`\n"
                    + "     INNER JOIN `vw_total_valor_vda` vw_total_valor_vda ON produtos.`CODIGO` = vw_total_valor_vda.`codigo`\n"
                    + "     INNER JOIN `cad_unidade` cad_unidade ON produtos.`prod_un` = cad_unidade.`un_codigo`");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioProdutos.jasper");
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

    public boolean gerarRelatorioMovitoEstoqueData(Date pDataIni, Date pDataFim) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     ajuste_estoque.`id` AS ajuste_estoque_id,\n"
                    + "     ajuste_estoque.`data` AS ajuste_estoque_data,\n"
                    + "     ajuste_estoque.`motivo` AS ajuste_estoque_motivo,\n"
                    + "     ajuste_estoque.`cod_usuario` AS ajuste_estoque_cod_usuario,\n"
                    + "     ajuste_estoque.`cod_produto` AS ajuste_estoque_cod_produto,\n"
                    + "     ajuste_estoque.`qt_movimentada` AS ajuste_estoque_qt_movimentada,\n"
                    + "     ajuste_estoque.`tipo_movimento` AS ajuste_estoque_tipo_movimento,\n"
                    + "     ajuste_estoque.`saldo_anterior` AS ajuste_estoque_saldo_anterior,\n"
                    + "     ajuste_estoque.`estoque_atualizado` AS ajuste_estoque_estoque_atualizado,\n"
                    + "     tbl_usuarios.`pk_codigo` AS tbl_usuarios_pk_codigo,\n"
                    + "     tbl_usuarios.`nome` AS tbl_usuarios_nome,\n"
                    + "     tbl_usuarios.`login` AS tbl_usuarios_login,\n"
                    + "     tbl_usuarios.`senha` AS tbl_usuarios_senha,\n"
                    + "     tbl_usuarios.`grupo` AS tbl_usuarios_grupo,\n"
                    + "     tbl_usuarios.`tempo` AS tbl_usuarios_tempo,\n"
                    + "     produtos.`CODIGO` AS produtos_CODIGO,\n"
                    + "     produtos.`FORNECEDORES_CODIGO` AS produtos_FORNECEDORES_CODIGO,\n"
                    + "     produtos.`NOME` AS produtos_NOME,\n"
                    + "     produtos.`VALOR` AS produtos_VALOR,\n"
                    + "     produtos.`ESTOQUE` AS produtos_ESTOQUE,\n"
                    + "     produtos.`CODIGO_BARRAS` AS produtos_CODIGO_BARRAS,\n"
                    + "     produtos.`prod_grupo` AS produtos_prod_grupo,\n"
                    + "     produtos.`prod_un` AS produtos_prod_un,\n"
                    + "     produtos.`prod_ncm` AS produtos_prod_ncm,\n"
                    + "     produtos.`prod_cest` AS produtos_prod_cest,\n"
                    + "     produtos.`prod_origem` AS produtos_prod_origem,\n"
                    + "     produtos.`prod_tributacao` AS produtos_prod_tributacao,\n"
                    + "     produtos.`prod_situacao` AS produtos_prod_situacao,\n"
                    + "     produtos.`prod_nome_resumido` AS produtos_prod_nome_resumido,\n"
                    + "     produtos.`prod_ingrediente` AS produtos_prod_ingrediente,\n"
                    + "     produtos.`utiliza_composicao` AS produtos_utiliza_composicao,\n"
                    + "     produtos.`prod_anvisa` AS produtos_prod_anvisa,\n"
                    + "     produtos.`prod_custo` AS produtos_prod_custo,\n"
                    + "     produtos.`prod_estoque_minimo` AS produtos_prod_estoque_minimo,\n"
                    + "     produtos.`fator_conversao` AS produtos_fator_conversao,\n"
                    + "     produtos.`forca_de_vendas` AS produtos_forca_de_vendas,\n"
                    + "     produtos.`fator_conversao_estoque` AS produtos_fator_conversao_estoque,\n"
                    + "     produtos.`un_volume` AS produtos_un_volume,\n"
                    + "     produtos.`nao_fraciona` AS produtos_nao_fraciona,\n"
                    + "     cad_unidade.`un_codigo` AS cad_unidade_un_codigo,\n"
                    + "     cad_unidade.`un_descricao` AS cad_unidade_un_descricao,\n"
                    + "     cad_grupo_prod.`gru_codigo` AS cad_grupo_prod_gru_codigo,\n"
                    + "     cad_grupo_prod.`gru_descricao` AS cad_grupo_prod_gru_descricao\n"
                    + " FROM\n"
                    + "     `tbl_usuarios` tbl_usuarios INNER JOIN `ajuste_estoque` ajuste_estoque ON tbl_usuarios.`pk_codigo` = ajuste_estoque.`cod_usuario`\n"
                    + "     INNER JOIN `produtos` produtos ON ajuste_estoque.`cod_produto` = produtos.`CODIGO`\n"
                    + "     INNER JOIN `cad_unidade` cad_unidade ON produtos.`prod_un` = cad_unidade.`un_codigo`\n"
                    + "     INNER JOIN `cad_grupo_prod` cad_grupo_prod ON produtos.`prod_grupo` = cad_grupo_prod.`gru_codigo`"
                    + " where ajuste_estoque.`data` between ' " + pDataIni + " ' and '" + pDataFim + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioMovimentacaoEstoque.jasper");
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

    public boolean gerarRelatorioMovitoEstoqueDataPoduto(Date pDataIni, Date pDataFim, int pProduto) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     ajuste_estoque.`id` AS ajuste_estoque_id,\n"
                    + "     ajuste_estoque.`data` AS ajuste_estoque_data,\n"
                    + "     ajuste_estoque.`motivo` AS ajuste_estoque_motivo,\n"
                    + "     ajuste_estoque.`cod_usuario` AS ajuste_estoque_cod_usuario,\n"
                    + "     ajuste_estoque.`cod_produto` AS ajuste_estoque_cod_produto,\n"
                    + "     ajuste_estoque.`qt_movimentada` AS ajuste_estoque_qt_movimentada,\n"
                    + "     ajuste_estoque.`tipo_movimento` AS ajuste_estoque_tipo_movimento,\n"
                    + "     ajuste_estoque.`saldo_anterior` AS ajuste_estoque_saldo_anterior,\n"
                    + "     ajuste_estoque.`estoque_atualizado` AS ajuste_estoque_estoque_atualizado,\n"
                    + "     tbl_usuarios.`pk_codigo` AS tbl_usuarios_pk_codigo,\n"
                    + "     tbl_usuarios.`nome` AS tbl_usuarios_nome,\n"
                    + "     tbl_usuarios.`login` AS tbl_usuarios_login,\n"
                    + "     tbl_usuarios.`senha` AS tbl_usuarios_senha,\n"
                    + "     tbl_usuarios.`grupo` AS tbl_usuarios_grupo,\n"
                    + "     tbl_usuarios.`tempo` AS tbl_usuarios_tempo,\n"
                    + "     produtos.`CODIGO` AS produtos_CODIGO,\n"
                    + "     produtos.`FORNECEDORES_CODIGO` AS produtos_FORNECEDORES_CODIGO,\n"
                    + "     produtos.`NOME` AS produtos_NOME,\n"
                    + "     produtos.`VALOR` AS produtos_VALOR,\n"
                    + "     produtos.`ESTOQUE` AS produtos_ESTOQUE,\n"
                    + "     produtos.`CODIGO_BARRAS` AS produtos_CODIGO_BARRAS,\n"
                    + "     produtos.`prod_grupo` AS produtos_prod_grupo,\n"
                    + "     produtos.`prod_un` AS produtos_prod_un,\n"
                    + "     produtos.`prod_ncm` AS produtos_prod_ncm,\n"
                    + "     produtos.`prod_cest` AS produtos_prod_cest,\n"
                    + "     produtos.`prod_origem` AS produtos_prod_origem,\n"
                    + "     produtos.`prod_tributacao` AS produtos_prod_tributacao,\n"
                    + "     produtos.`prod_situacao` AS produtos_prod_situacao,\n"
                    + "     produtos.`prod_nome_resumido` AS produtos_prod_nome_resumido,\n"
                    + "     produtos.`prod_ingrediente` AS produtos_prod_ingrediente,\n"
                    + "     produtos.`utiliza_composicao` AS produtos_utiliza_composicao,\n"
                    + "     produtos.`prod_anvisa` AS produtos_prod_anvisa,\n"
                    + "     produtos.`prod_custo` AS produtos_prod_custo,\n"
                    + "     produtos.`prod_estoque_minimo` AS produtos_prod_estoque_minimo,\n"
                    + "     produtos.`fator_conversao` AS produtos_fator_conversao,\n"
                    + "     produtos.`forca_de_vendas` AS produtos_forca_de_vendas,\n"
                    + "     produtos.`fator_conversao_estoque` AS produtos_fator_conversao_estoque,\n"
                    + "     produtos.`un_volume` AS produtos_un_volume,\n"
                    + "     produtos.`nao_fraciona` AS produtos_nao_fraciona,\n"
                    + "     cad_unidade.`un_codigo` AS cad_unidade_un_codigo,\n"
                    + "     cad_unidade.`un_descricao` AS cad_unidade_un_descricao,\n"
                    + "     cad_grupo_prod.`gru_codigo` AS cad_grupo_prod_gru_codigo,\n"
                    + "     cad_grupo_prod.`gru_descricao` AS cad_grupo_prod_gru_descricao\n"
                    + " FROM\n"
                    + "     `tbl_usuarios` tbl_usuarios INNER JOIN `ajuste_estoque` ajuste_estoque ON tbl_usuarios.`pk_codigo` = ajuste_estoque.`cod_usuario`\n"
                    + "     INNER JOIN `produtos` produtos ON ajuste_estoque.`cod_produto` = produtos.`CODIGO`\n"
                    + "     INNER JOIN `cad_unidade` cad_unidade ON produtos.`prod_un` = cad_unidade.`un_codigo`\n"
                    + "     INNER JOIN `cad_grupo_prod` cad_grupo_prod ON produtos.`prod_grupo` = cad_grupo_prod.`gru_codigo`"
                    + " where ajuste_estoque.`data` between ' " + pDataIni + " ' and '" + pDataFim + "'"
                    + " and produtos.`CODIGO`=' " + pProduto + " '");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioMovimentacaoEstoque.jasper");
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

    public boolean gerarRelatorioMovitoEstoqueDataGrupo(Date pDataIni, Date pDataFim, String pGrupo) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     ajuste_estoque.`id` AS ajuste_estoque_id,\n"
                    + "     ajuste_estoque.`data` AS ajuste_estoque_data,\n"
                    + "     ajuste_estoque.`motivo` AS ajuste_estoque_motivo,\n"
                    + "     ajuste_estoque.`cod_usuario` AS ajuste_estoque_cod_usuario,\n"
                    + "     ajuste_estoque.`cod_produto` AS ajuste_estoque_cod_produto,\n"
                    + "     ajuste_estoque.`qt_movimentada` AS ajuste_estoque_qt_movimentada,\n"
                    + "     ajuste_estoque.`tipo_movimento` AS ajuste_estoque_tipo_movimento,\n"
                    + "     ajuste_estoque.`saldo_anterior` AS ajuste_estoque_saldo_anterior,\n"
                    + "     ajuste_estoque.`estoque_atualizado` AS ajuste_estoque_estoque_atualizado,\n"
                    + "     tbl_usuarios.`pk_codigo` AS tbl_usuarios_pk_codigo,\n"
                    + "     tbl_usuarios.`nome` AS tbl_usuarios_nome,\n"
                    + "     tbl_usuarios.`login` AS tbl_usuarios_login,\n"
                    + "     tbl_usuarios.`senha` AS tbl_usuarios_senha,\n"
                    + "     tbl_usuarios.`grupo` AS tbl_usuarios_grupo,\n"
                    + "     tbl_usuarios.`tempo` AS tbl_usuarios_tempo,\n"
                    + "     produtos.`CODIGO` AS produtos_CODIGO,\n"
                    + "     produtos.`FORNECEDORES_CODIGO` AS produtos_FORNECEDORES_CODIGO,\n"
                    + "     produtos.`NOME` AS produtos_NOME,\n"
                    + "     produtos.`VALOR` AS produtos_VALOR,\n"
                    + "     produtos.`ESTOQUE` AS produtos_ESTOQUE,\n"
                    + "     produtos.`CODIGO_BARRAS` AS produtos_CODIGO_BARRAS,\n"
                    + "     produtos.`prod_grupo` AS produtos_prod_grupo,\n"
                    + "     produtos.`prod_un` AS produtos_prod_un,\n"
                    + "     produtos.`prod_ncm` AS produtos_prod_ncm,\n"
                    + "     produtos.`prod_cest` AS produtos_prod_cest,\n"
                    + "     produtos.`prod_origem` AS produtos_prod_origem,\n"
                    + "     produtos.`prod_tributacao` AS produtos_prod_tributacao,\n"
                    + "     produtos.`prod_situacao` AS produtos_prod_situacao,\n"
                    + "     produtos.`prod_nome_resumido` AS produtos_prod_nome_resumido,\n"
                    + "     produtos.`prod_ingrediente` AS produtos_prod_ingrediente,\n"
                    + "     produtos.`utiliza_composicao` AS produtos_utiliza_composicao,\n"
                    + "     produtos.`prod_anvisa` AS produtos_prod_anvisa,\n"
                    + "     produtos.`prod_custo` AS produtos_prod_custo,\n"
                    + "     produtos.`prod_estoque_minimo` AS produtos_prod_estoque_minimo,\n"
                    + "     produtos.`fator_conversao` AS produtos_fator_conversao,\n"
                    + "     produtos.`forca_de_vendas` AS produtos_forca_de_vendas,\n"
                    + "     produtos.`fator_conversao_estoque` AS produtos_fator_conversao_estoque,\n"
                    + "     produtos.`un_volume` AS produtos_un_volume,\n"
                    + "     produtos.`nao_fraciona` AS produtos_nao_fraciona,\n"
                    + "     cad_unidade.`un_codigo` AS cad_unidade_un_codigo,\n"
                    + "     cad_unidade.`un_descricao` AS cad_unidade_un_descricao,\n"
                    + "     cad_grupo_prod.`gru_codigo` AS cad_grupo_prod_gru_codigo,\n"
                    + "     cad_grupo_prod.`gru_descricao` AS cad_grupo_prod_gru_descricao\n"
                    + " FROM\n"
                    + "     `tbl_usuarios` tbl_usuarios INNER JOIN `ajuste_estoque` ajuste_estoque ON tbl_usuarios.`pk_codigo` = ajuste_estoque.`cod_usuario`\n"
                    + "     INNER JOIN `produtos` produtos ON ajuste_estoque.`cod_produto` = produtos.`CODIGO`\n"
                    + "     INNER JOIN `cad_unidade` cad_unidade ON produtos.`prod_un` = cad_unidade.`un_codigo`\n"
                    + "     INNER JOIN `cad_grupo_prod` cad_grupo_prod ON produtos.`prod_grupo` = cad_grupo_prod.`gru_codigo`"
                    + " where ajuste_estoque.`data` between ' " + pDataIni + " ' and '" + pDataFim + "' "
                    + " and cad_grupo_prod.`gru_descricao` = '" + pGrupo + "'");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioMovimentacaoEstoque.jasper");
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

    public boolean gerarRelatorioProdutosGrupo(int pGrupo) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     produtos.`CODIGO` AS produtos_CODIGO,\n"
                    + "     produtos.`FORNECEDORES_CODIGO` AS produtos_FORNECEDORES_CODIGO,\n"
                    + "     produtos.`NOME` AS produtos_NOME,\n"
                    + "     produtos.`VALOR` AS produtos_VALOR,\n"
                    + "     produtos.`ESTOQUE` AS produtos_ESTOQUE,\n"
                    + "     produtos.`CODIGO_BARRAS` AS produtos_CODIGO_BARRAS,\n"
                    + "     produtos.`prod_grupo` AS produtos_prod_grupo,\n"
                    + "     produtos.`prod_un` AS produtos_prod_un,\n"
                    + "     produtos.`prod_ncm` AS produtos_prod_ncm,\n"
                    + "     produtos.`prod_cest` AS produtos_prod_cest,\n"
                    + "     produtos.`prod_origem` AS produtos_prod_origem,\n"
                    + "     produtos.`prod_tributacao` AS produtos_prod_tributacao,\n"
                    + "     produtos.`prod_situacao` AS produtos_prod_situacao,\n"
                    + "     produtos.`prod_nome_resumido` AS produtos_prod_nome_resumido,\n"
                    + "     produtos.`prod_ingrediente` AS produtos_prod_ingrediente,\n"
                    + "     produtos.`utiliza_composicao` AS produtos_utiliza_composicao,\n"
                    + "     produtos.`prod_anvisa` AS produtos_prod_anvisa,\n"
                    + "     produtos.`prod_custo` AS produtos_prod_custo,\n"
                    + "     produtos.`prod_estoque_minimo` AS produtos_prod_estoque_minimo,\n"
                    + "     produtos.`fator_conversao` AS produtos_fator_conversao,\n"
                    + "     total_custo.`codigo` AS total_custo_codigo,\n"
                    + "     total_custo.`estoque` AS total_custo_estoque,\n"
                    + "     total_custo.`prod_custo` AS total_custo_prod_custo,\n"
                    + "     total_custo.`custo total` AS total_custo_custo_total,\n"
                    + "     vw_total_valor_vda.`codigo` AS vw_total_valor_vda_codigo,\n"
                    + "     vw_total_valor_vda.`estoque` AS vw_total_valor_vda_estoque,\n"
                    + "     vw_total_valor_vda.`valor` AS vw_total_valor_vda_valor,\n"
                    + "     vw_total_valor_vda.`valor_total_venda` AS vw_total_valor_vda_valor_total_venda,\n"
                    + "     produtos.`forca_de_vendas` AS produtos_forca_de_vendas,\n"
                    + "     produtos.`fator_conversao_estoque` AS produtos_fator_conversao_estoque,\n"
                    + "     produtos.`un_volume` AS produtos_un_volume,\n"
                    + "     cad_unidade.`un_codigo` AS cad_unidade_un_codigo,\n"
                    + "     cad_unidade.`un_descricao` AS cad_unidade_un_descricao\n"
                    + "FROM\n"
                    + "     `total_custo` total_custo INNER JOIN `produtos` produtos ON total_custo.`codigo` = produtos.`CODIGO`\n"
                    + "     INNER JOIN `vw_total_valor_vda` vw_total_valor_vda ON produtos.`CODIGO` = vw_total_valor_vda.`codigo`\n"
                    + "     INNER JOIN `cad_unidade` cad_unidade ON produtos.`prod_un` = cad_unidade.`un_codigo`"
                    + " where produtos.`prod_grupo` = '" + pGrupo + "'"
                    + "");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioProdutos.jasper");
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
     * barra 11_07_2018 charles
     *
     * @param pCodigo
     * @return
     */
    /**
     * recupera uma lista de Produtos return ArrayList
     */
    public ArrayList<ModelProdutos> getListaCodigoBarrasDAO() {
        ArrayList<ModelProdutos> listamodelProdutos = new ArrayList();
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "valor,"
                    + "codigo_barras"
                    + " FROM"
                    + " produtos"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProdutos = new ModelProdutos();
                modelProdutos.setCODIGO(this.getResultSet().getInt(1));
                modelProdutos.setNome(this.getResultSet().getString(2));
                modelProdutos.setValor(this.getResultSet().getFloat(3));
                modelProdutos.setCodigo_barras(this.getResultSet().getString(4));
                listamodelProdutos.add(modelProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelProdutos;
    }

    //09/07/2018 Charles - relatorio para gerar cod de barras a partir do Ireports
    public boolean gerarRelatorioProdutosCodBarras(String plista, int pQuantidade) {
        ArrayList<ModelProdutos> listaProdutos = new ArrayList<>();
        //Collection<ModelProdutos> listaProdutos = new ArrayList<>();
        ModelProdutos modelProdutos = new ModelProdutos();
        String select = " SELECT\n"
                + "     produtos.`CODIGO`,\n"
                + "     produtos.`CODIGO_BARRAS`,\n"
                + "     produtos.`NOME`, \n"
                + "     produtos.`VALOR`, \n"
                + "     produtos.`prod_nome_resumido` \n"
                + " FROM\n"
                + "  produtos"
                + " WHERE produtos.CODIGO_BARRAS in (" + plista + ")";
        try {
            this.conectar();
            int qt = 0;
            while (qt < pQuantidade) {
                this.executarSQL(select);
                while (getResultSet().next()) {
                    modelProdutos = new ModelProdutos();
                    modelProdutos.setCODIGO(this.getResultSet().getInt(1));
                    modelProdutos.setCodigo_barras(this.getResultSet().getString(2));
                    modelProdutos.setNome(this.getResultSet().getString(3));
                    modelProdutos.setValor(this.getResultSet().getFloat(4));
                    modelProdutos.setProd_nome_resumido(this.getResultSet().getString(5));
                    listaProdutos.add(modelProdutos);
                }
                qt++;
            }
            JRBeanCollectionDataSource jrRS = new JRBeanCollectionDataSource(listaProdutos, false);
            // caminho do arquivo dentro dos pacotes    
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioCodigoBarrasA4348Pimaco.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //Trata a exportação e apagar o arquivo pdf ao fechar
            String nomeArquivo = "Relatorios/rel.pdf";
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
        this.fecharConexao();
        return true;
    }

    public boolean gerarRelatorioFornecedores() {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     fornecedores.CODIGO AS fornecedores_CODIGO, "
                    + "     fornecedores.NOME AS fornecedores_NOME, "
                    + "     fornecedores.ENDERECO AS fornecedores_ENDERECO, "
                    + "     fornecedores.BAIRRO AS fornecedores_BAIRRO, "
                    + "     fornecedores.CEP AS fornecedores_CEP, "
                    + "     fornecedores.TELEFONE AS fornecedores_TELEFONE, "
                    + "     cidade.nome AS cidade_nome, "
                    + "     estado.uf AS estado_uf, "
                    + "     estado.nome AS estado_nome "
                    + " FROM "
                    + "     estado estado INNER JOIN cidade cidade ON estado.codigo = cidade.fk_cod_estado "
                    + "     INNER JOIN fornecedores fornecedores ON cidade.codigo = fornecedores.COD_CIDADE "
                    + "     AND fornecedores.COD_ESTADO = estado.codigo");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioFornecedores.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "Relatorios/rel.pdf";
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

    public boolean gerarRelatorioVenda(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT"
                    + "     vendas.CODIGO AS vendas_CODIGO,"
                    + "     vendas.CLIENTES_CODIGO AS vendas_CLIENTES_CODIGO,"
                    + "     vendas.DATA_VENDA AS vendas_DATA_VENDA,"
                    + "     vendas.VALOR_TOTAL AS vendas_VALOR_TOTAL,"
                    + "     vendas.DESCONTO AS vendas_DESCONTO,"
                    + "     vendas.TIPO_PAGAMENTO AS vendas_TIPO_PAGAMENTO,"
                    + "     vendas_produto.QUANTIDADE AS vendas_produto_QUANTIDADE,"
                    + "     produtos.CODIGO AS produtos_CODIGO,"
                    + "     produtos.NOME AS produtos_NOME,"
                    + "     produtos.VALOR AS produtos_VALOR,"
                    + "     clientes.CODIGO AS clientes_CODIGO,"
                    + "     clientes.NOME AS clientes_NOME,"
                    + "     clientes.ENDERECO AS clientes_ENDERECO,"
                    + "     clientes.BAIRRO AS clientes_BAIRRO,"
                    + "     clientes.CEP AS clientes_CEP,"
                    + "     clientes.TELEFONE AS clientes_TELEFONE,"
                    + "     cidade.nome AS cidade_nome,"
                    + "     estado.uf AS estado_uf"
                    + " FROM"
                    + "     vendas vendas INNER JOIN vendas_produto vendas_produto ON vendas.CODIGO = vendas_produto.CODIGO_VENDA"
                    + "     INNER JOIN produtos produtos ON vendas_produto.CODIGO_PRODUTO = produtos.CODIGO"
                    + "     INNER JOIN clientes clientes ON vendas.CLIENTES_CODIGO = clientes.CODIGO "
                    + "     INNER JOIN estado estado ON clientes.COD_ESTADO = estado.codigo "
                    + "     INNER JOIN cidade cidade ON clientes.COD_CIDADE = cidade.codigo "
                    + "     AND estado.codigo = cidade.fk_cod_estado where VENDAS.CODIGO = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioVendas.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "Relatorios/rel.pdf";
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

    public boolean gerarRelatorioPDV(int pCodigo) {

        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     empresa.`ID` AS empresa_ID,\n"
                    + "     empresa.`RAZAO_SOCIAL` AS empresa_RAZAO_SOCIAL,\n"
                    + "     empresa.`NOME_FANTASIA` AS empresa_NOME_FANTASIA,\n"
                    + "     empresa.`CNPJ` AS empresa_CNPJ,\n"
                    + "     empresa.`INSCRICAO_ESTADUAL` AS empresa_INSCRICAO_ESTADUAL,\n"
                    + "     empresa.`INSCRICAO_ESTADUAL_ST` AS empresa_INSCRICAO_ESTADUAL_ST,\n"
                    + "     empresa.`INSCRICAO_MUNICIPAL` AS empresa_INSCRICAO_MUNICIPAL,\n"
                    + "     empresa.`INSCRICAO_JUNTA_COMERCIAL` AS empresa_INSCRICAO_JUNTA_COMERCIAL,\n"
                    + "     empresa.`DATA_INSC_JUNTA_COMERCIAL` AS empresa_DATA_INSC_JUNTA_COMERCIAL,\n"
                    + "     empresa.`TIPO` AS empresa_TIPO,\n"
                    + "     empresa.`DATA_CADASTRO` AS empresa_DATA_CADASTRO,\n"
                    + "     empresa.`DATA_INICIO_ATIVIDADES` AS empresa_DATA_INICIO_ATIVIDADES,\n"
                    + "     empresa.`SUFRAMA` AS empresa_SUFRAMA,\n"
                    + "     empresa.`EMAIL` AS empresa_EMAIL,\n"
                    + "     empresa.`IMAGEM_LOGOTIPO` AS empresa_IMAGEM_LOGOTIPO,\n"
                    + "     empresa.`CRT` AS empresa_CRT,\n"
                    + "     empresa.`TIPO_REGIME` AS empresa_TIPO_REGIME,\n"
                    + "     empresa.`ALIQUOTA_PIS` AS empresa_ALIQUOTA_PIS,\n"
                    + "     empresa.`CONTATO` AS empresa_CONTATO,\n"
                    + "     empresa.`ALIQUOTA_COFINS` AS empresa_ALIQUOTA_COFINS,\n"
                    + "     empresa.`CODIGO_IBGE_CIDADE` AS empresa_CODIGO_IBGE_CIDADE,\n"
                    + "     empresa.`CODIGO_IBGE_UF` AS empresa_CODIGO_IBGE_UF,\n"
                    + "     empresa.`CODIGO_TERCEIROS` AS empresa_CODIGO_TERCEIROS,\n"
                    + "     empresa.`CODIGO_GPS` AS empresa_CODIGO_GPS,\n"
                    + "     empresa.`ALIQUOTA_SAT` AS empresa_ALIQUOTA_SAT,\n"
                    + "     empresa.`CEI` AS empresa_CEI,\n"
                    + "     empresa.`CODIGO_CNAE_PRINCIPAL` AS empresa_CODIGO_CNAE_PRINCIPAL,\n"
                    + "     empresa.`TIPO_CONTROLE_ESTOQUE` AS empresa_TIPO_CONTROLE_ESTOQUE,\n"
                    + "     vendas.`CODIGO` AS vendas_CODIGO,\n"
                    + "     vendas.`CLIENTES_CODIGO` AS vendas_CLIENTES_CODIGO,\n"
                    + "     vendas.`DATA_VENDA` AS vendas_DATA_VENDA,\n"
                    + "     vendas.`VALOR_TOTAL` AS vendas_VALOR_TOTAL,\n"
                    + "     vendas.`troco` AS vendas_troco,\n"
                    + "     vendas.`DESCONTO` AS vendas_DESCONTO,\n"
                    + "     vendas.`TIPO_PAGAMENTO` AS vendas_TIPO_PAGAMENTO,\n"
                    + "     vendas.`chave_acesso` AS vendas_chave_acesso,\n"
                    + "     vendas.`cpf_cliente` AS vendas_cpf_cliente,\n"
                    + "     vendas.`comanda` AS vendas_comanda,\n"
                    + "     vendas.`status` AS vendas_status,\n"
                    + "     vendas.`terminal` AS vendas_terminal,\n"
                    + "     vendas.`vendedor` AS vendas_vendedor,\n"
                    + "     vendas.`hora` AS vendas_hora,\n"
                    + "     vendas_produto.`CODIGO` AS vendas_produto_CODIGO,\n"
                    + "     vendas_produto.`CODIGO_PRODUTO` AS vendas_produto_CODIGO_PRODUTO,\n"
                    + "     vendas_produto.`CODIGO_VENDA` AS vendas_produto_CODIGO_VENDA,\n"
                    + "     vendas_produto.`QUANTIDADE` AS vendas_produto_QUANTIDADE,\n"
                    + "     vendas_produto.`item` AS vendas_produto_item,\n"
                    + "     vendas_produto.`nome` AS vendas_produto_nome,\n"
                    + "     vendas_produto.`un_descricao` AS vendas_produto_un_descricao,\n"
                    + "     vendas_produto.`ncm_num` AS vendas_produto_ncm_num,\n"
                    + "     vendas_produto.`cest_numero` AS vendas_produto_cest_numero,\n"
                    + "     vendas_produto.`origem` AS vendas_produto_origem,\n"
                    + "     vendas_produto.`cfop` AS vendas_produto_cfop,\n"
                    + "     vendas_produto.`pis` AS vendas_produto_pis,\n"
                    + "     vendas_produto.`cofins` AS vendas_produto_cofins,\n"
                    + "     vendas_produto.`ipi` AS vendas_produto_ipi,\n"
                    + "     vendas_produto.`valor` AS vendas_produto_valor,\n"
                    + "     vendas_produto.`codigo_barras` AS vendas_produto_codigo_barras,\n"
                    + "     vendas_produto.`cst` AS vendas_produto_cst,\n"
                    + "     vendas_produto.`comanda` AS vendas_produto_comanda,\n"
                    + "     produtos.`CODIGO` AS produtos_CODIGO,\n"
                    + "     produtos.`FORNECEDORES_CODIGO` AS produtos_FORNECEDORES_CODIGO,\n"
                    + "     produtos.`NOME` AS produtos_NOME,\n"
                    + "     produtos.`VALOR` AS produtos_VALOR,\n"
                    + "     produtos.`ESTOQUE` AS produtos_ESTOQUE,\n"
                    + "     produtos.`CODIGO_BARRAS` AS produtos_CODIGO_BARRAS,\n"
                    + "     produtos.`prod_grupo` AS produtos_prod_grupo,\n"
                    + "     produtos.`prod_un` AS produtos_prod_un,\n"
                    + "     produtos.`prod_ncm` AS produtos_prod_ncm,\n"
                    + "     produtos.`prod_cest` AS produtos_prod_cest,\n"
                    + "     produtos.`prod_origem` AS produtos_prod_origem,\n"
                    + "     produtos.`prod_tributacao` AS produtos_prod_tributacao,\n"
                    + "     produtos.`prod_situacao` AS produtos_prod_situacao,\n"
                    + "     produtos.`prod_nome_resumido` AS produtos_prod_nome_resumido,\n"
                    + "     produtos.`prod_ingrediente` AS produtos_prod_ingrediente,\n"
                    + "     produtos.`utiliza_composicao` AS produtos_utiliza_composicao,\n"
                    + "     produtos.`prod_anvisa` AS produtos_prod_anvisa,\n"
                    + "     produtos.`prod_custo` AS produtos_prod_custo,\n"
                    + "     produtos.`prod_estoque_minimo` AS produtos_prod_estoque_minimo,\n"
                    + "     produtos.`fator_conversao` AS produtos_fator_conversao,\n"
                    + "     ven_tipo_pagto.`ven_id` AS ven_tipo_pagto_ven_id,\n"
                    + "     ven_tipo_pagto.`ven_cod_venda` AS ven_tipo_pagto_ven_cod_venda,\n"
                    + "     ven_tipo_pagto.`ven_valor` AS ven_tipo_pagto_ven_valor,\n"
                    + "     ven_tipo_pagto.`ven_valor_digitado` AS ven_tipo_pagto_ven_valor_digitado,\n"
                    + "     ven_tipo_pagto.`ven_data_venda` AS ven_tipo_pagto_ven_data_venda,\n"
                    + "     ven_tipo_pagto.`ven_hora` AS ven_tipo_pagto_ven_hora,\n"
                    + "     ven_tipo_pagto.`ven_bandeira` AS ven_tipo_pagto_ven_bandeira,\n"
                    + "     ven_tipo_pagto.`ven_id_caixa` AS ven_tipo_pagto_ven_id_caixa,\n"
                    + "     ven_tipo_pagto.`ven_id_turno` AS ven_tipo_pagto_ven_id_turno,\n"
                    + "     ven_tipo_pagto.`ven_status_turno` AS ven_tipo_pagto_ven_status_turno,\n"
                    + "     ven_tipo_pagto.`ven_tipo_pagto` AS ven_tipo_pagto_ven_tipo_pagto\n"
                    + "FROM\n"
                    + "     `vendas` vendas INNER JOIN `vendas_produto` vendas_produto ON vendas.`CODIGO` = vendas_produto.`CODIGO_VENDA`\n"
                    + "     INNER JOIN `produtos` produtos ON vendas_produto.`CODIGO_PRODUTO` = produtos.`CODIGO`\n"
                    + "     INNER JOIN `ven_tipo_pagto` ven_tipo_pagto ON vendas.`CODIGO` = ven_tipo_pagto.`ven_cod_venda`,\n"
                    + "     `empresa` empresa"
                    + " where vendas.`CODIGO` = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/ComprovantePDV.jasper");
            //JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);
            JasperPrintManager.printReport(jasperPrint, false);

            //Imprime na tela***
            //  String nomeArquivo = "Relatorios/rel.pdf";
            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            // JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            //File file = new File(nomeArquivo);
            // try {
            //    Desktop.getDesktop().open(file);
            //} catch (Exception e) {
            //  JOptionPane.showConfirmDialog(null, e);
            //}
            //file.deleteOnExit();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;

    }

    /**
     * charles 13/10/2017
     *
     * @param pCodigoBarras
     * @return imprime pedido localizando pelo codigo de barras
     */
    public boolean gerarRelatorioCodBarrasPDV(int pCodigoBarras) {
        try {
            this.conectar();
            this.executarSQL("select VENDAS.CODIGO as VENDASCODIGO"
                    + "     , VENDAS.CLIENTES_CODIGO as VENDASCLIENTES_CODIGO"
                    + "     , VENDAS.DATA_VENDA as VENDASDATA_VENDA"
                    + "     , VENDAS.VALOR_TOTAL as VENDASVALOR_TOTAL"
                    + "     , VENDAS.DESCONTO as VENDASDESCONTO"
                    + "     , VENDAS_PRODUTO.CODIGO as VENDAS_PRODUTOCODIGO"
                    + "     , VENDAS_PRODUTO.CODIGO_PRODUTO as VENDAS_PRODUTOCODIGO_PRODUTO"
                    + "     , VENDAS_PRODUTO.CODIGO_VENDA as VENDAS_PRODUTOCODIGO_VENDA"
                    + "     , VENDAS_PRODUTO.QUANTIDADE as VENDAS_PRODUTOQUANTIDADE"
                    + "     , PRODUTOS.CODIGO as PRODUTOSCODIGO"
                    + "     , PRODUTOS.NOME as PRODUTOSNOME"
                    + "     , PRODUTOS.VALOR as PRODUTOSVALOR "
                    + "     , CLIENTES.CODIGO as CLIENTESCODIGO "
                    + " from VENDAS inner join VENDAS_PRODUTO on VENDAS.CODIGO = VENDAS_PRODUTO.CODIGO_VENDA "
                    + "inner join CLIENTES on VENDAS.CLIENTES_CODIGO = CLIENTES.CODIGO "
                    + "inner join PRODUTOS on VENDAS_PRODUTO.CODIGO_PRODUTO = PRODUTOS.CODIGO "
                    + " where VENDAS.CODIGO = '" + pCodigoBarras + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioPDV.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "Relatorios/rel.pdf";
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

    public boolean gerarRelatorioContaReceber(int pCiente) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     cad_cliente.`CODIGO` AS cad_cliente_CODIGO,\n"
                    + "     cad_cliente.`NOME` AS cad_cliente_NOME,\n"
                    + "     cad_cliente.`ENDERECO` AS cad_cliente_ENDERECO,\n"
                    + "     cad_cliente.`TELEFONE` AS cad_cliente_TELEFONE,\n"
                    + "     cad_cliente.`numero` AS cad_cliente_numero,\n"
                    + "     cad_cliente.`complemento` AS cad_cliente_complemento,\n"
                    + "     cad_cliente.`data_nasc` AS cad_cliente_data_nasc,\n"
                    + "     cad_cliente.`cpf` AS cad_cliente_cpf,\n"
                    + "     cad_cliente.`referencia` AS cad_cliente_referencia,\n"
                    + "     cad_cliente.`email` AS cad_cliente_email,\n"
                    + "     cad_endereco.`end_codigo` AS cad_endereco_end_codigo,\n"
                    + "     cad_endereco.`end_cep` AS cad_endereco_end_cep,\n"
                    + "     cad_endereco.`end_logradouro` AS cad_endereco_end_logradouro,\n"
                    + "     cad_endereco.`end_bairro` AS cad_endereco_end_bairro,\n"
                    + "     cad_endereco.`end_cidade` AS cad_endereco_end_cidade,\n"
                    + "     cad_endereco.`end_uf` AS cad_endereco_end_uf,\n"
                    + "     cad_endereco.`end_cod_ibge` AS cad_endereco_end_cod_ibge,\n"
                    + "     contas_receber.`PK_CODIGO` AS contas_receber_PK_CODIGO,\n"
                    + "     contas_receber.`FK_CODIGO_PESSOA` AS contas_receber_FK_CODIGO_PESSOA,\n"
                    + "     contas_receber.`DESCRICAO` AS contas_receber_DESCRICAO,\n"
                    + "     contas_receber.`DATA` AS contas_receber_DATA,\n"
                    + "     contas_receber.`VENCIMENTO` AS contas_receber_VENCIMENTO,\n"
                    + "     contas_receber.`FK_TIPO_PAGAMENTO` AS contas_receber_FK_TIPO_PAGAMENTO,\n"
                    + "     contas_receber.`OBSERVACAO` AS contas_receber_OBSERVACAO,\n"
                    + "     contas_receber.`SITUACAO` AS contas_receber_SITUACAO,\n"
                    + "     contas_receber.`VALOR` AS contas_receber_VALOR,\n"
                    + "     contas_receber.`PAGAMENTO` AS contas_receber_PAGAMENTO\n"
                    + "FROM\n"
                    + "     `cad_cliente` cad_cliente INNER JOIN `contas_receber` contas_receber ON cad_cliente.`CODIGO` = contas_receber.`FK_CODIGO_PESSOA`\n"
                    + "    left JOIN `cad_endereco` cad_endereco ON cad_cliente.`ENDERECO` = cad_endereco.`end_codigo`"
                    + "where contas_receber.`PK_CODIGO` ='" + pCiente + "'"
            );
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioContasReceber.jasper");
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

    public boolean gerarRelatorioContaPagar(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     fornecedores.`CODIGO` AS fornecedores_CODIGO,\n"
                    + "     fornecedores.`NOME` AS fornecedores_NOME,\n"
                    + "     fornecedores.`ENDERECO` AS fornecedores_ENDERECO,\n"
                    + "     fornecedores.`TELEFONE` AS fornecedores_TELEFONE,\n"
                    + "     fornecedores.`numero` AS fornecedores_numero,\n"
                    + "     fornecedores.`cnpj` AS fornecedores_cnpj,\n"
                    + "     fornecedores.`email` AS fornecedores_email,\n"
                    + "     fornecedores.`contato` AS fornecedores_contato,\n"
                    + "     cad_endereco.`end_codigo` AS cad_endereco_end_codigo,\n"
                    + "     cad_endereco.`end_cep` AS cad_endereco_end_cep,\n"
                    + "     cad_endereco.`end_logradouro` AS cad_endereco_end_logradouro,\n"
                    + "     cad_endereco.`end_bairro` AS cad_endereco_end_bairro,\n"
                    + "     cad_endereco.`end_cidade` AS cad_endereco_end_cidade,\n"
                    + "     cad_endereco.`end_uf` AS cad_endereco_end_uf,\n"
                    + "     cad_endereco.`end_cod_ibge` AS cad_endereco_end_cod_ibge,\n"
                    + "     contas_pagar.`PK_CODIGO` AS contas_pagar_PK_CODIGO,\n"
                    + "     contas_pagar.`FK_CODIGO_PESSOA` AS contas_pagar_FK_CODIGO_PESSOA,\n"
                    + "     contas_pagar.`DESCRICAO` AS contas_pagar_DESCRICAO,\n"
                    + "     contas_pagar.`DATA` AS contas_pagar_DATA,\n"
                    + "     contas_pagar.`VENCIMENTO` AS contas_pagar_VENCIMENTO,\n"
                    + "     contas_pagar.`FK_TIPO_PAGAMENTO` AS contas_pagar_FK_TIPO_PAGAMENTO,\n"
                    + "     contas_pagar.`OBSERVACAO` AS contas_pagar_OBSERVACAO,\n"
                    + "     contas_pagar.`SITUACAO` AS contas_pagar_SITUACAO,\n"
                    + "     contas_pagar.`VALOR` AS contas_pagar_VALOR,\n"
                    + "     contas_pagar.`PAGAMENTO` AS contas_pagar_PAGAMENTO\n"
                    + "FROM\n"
                    + "     `fornecedores` fornecedores INNER JOIN `contas_pagar` contas_pagar ON fornecedores.`CODIGO` = contas_pagar.`FK_CODIGO_PESSOA`\n"
                    + "     INNER JOIN `cad_endereco` cad_endereco ON fornecedores.`ENDERECO` = cad_endereco.`end_codigo`"
                    + "where contas_pagar.`PK_CODIGO` =' " + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioContasPagar.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "Relatorios/rel.pdf";
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

    public boolean gerarRelatorioVendaClienteData(Date pDataIni, Date pDataFim, int pCliente) {
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT\n"
                    + "     vendas.`CODIGO` AS vendas_CODIGO,\n"
                    + "     vendas.`CLIENTES_CODIGO` AS vendas_CLIENTES_CODIGO,\n"
                    + "     vendas.`DATA_VENDA` AS vendas_DATA_VENDA,\n"
                    + "     vendas.`VALOR_TOTAL` AS vendas_VALOR_TOTAL,\n"
                    + "     vendas.`troco` AS vendas_troco,\n"
                    + "     vendas.`DESCONTO` AS vendas_DESCONTO,\n"
                    + "     vendas.`TIPO_PAGAMENTO` AS vendas_TIPO_PAGAMENTO,\n"
                    + "     vendas.`chave_acesso` AS vendas_chave_acesso,\n"
                    + "     vendas.`cpf_cliente` AS vendas_cpf_cliente,\n"
                    + "     vendas.`comanda` AS vendas_comanda,\n"
                    + "     vendas.`status` AS vendas_status,\n"
                    + "     vendas.`terminal` AS vendas_terminal,\n"
                    + "     vendas.`vendedor` AS vendas_vendedor,\n"
                    + "     vendas.`hora` AS vendas_hora,\n"
                    + "     vendas_produto.`CODIGO` AS vendas_produto_CODIGO,\n"
                    + "     vendas_produto.`CODIGO_PRODUTO` AS vendas_produto_CODIGO_PRODUTO,\n"
                    + "     vendas_produto.`CODIGO_VENDA` AS vendas_produto_CODIGO_VENDA,\n"
                    + "     vendas_produto.`QUANTIDADE` AS vendas_produto_QUANTIDADE,\n"
                    + "     vendas_produto.`item` AS vendas_produto_item,\n"
                    + "     vendas_produto.`nome` AS vendas_produto_nome,\n"
                    + "     vendas_produto.`un_descricao` AS vendas_produto_un_descricao,\n"
                    + "     vendas_produto.`ncm_num` AS vendas_produto_ncm_num,\n"
                    + "     vendas_produto.`cest_numero` AS vendas_produto_cest_numero,\n"
                    + "     vendas_produto.`origem` AS vendas_produto_origem,\n"
                    + "     vendas_produto.`cfop` AS vendas_produto_cfop,\n"
                    + "     vendas_produto.`pis` AS vendas_produto_pis,\n"
                    + "     vendas_produto.`cofins` AS vendas_produto_cofins,\n"
                    + "     vendas_produto.`ipi` AS vendas_produto_ipi,\n"
                    + "     vendas_produto.`valor` AS vendas_produto_valor,\n"
                    + "     vendas_produto.`codigo_barras` AS vendas_produto_codigo_barras,\n"
                    + "     vendas_produto.`cst` AS vendas_produto_cst,\n"
                    + "     vendas_produto.`comanda` AS vendas_produto_comanda,\n"
                    + "     tipo_pagamento.`pk_codigo` AS tipo_pagamento_pk_codigo,\n"
                    + "     tipo_pagamento.`descricao` AS tipo_pagamento_descricao,\n"
                    + "     cad_cliente.`CODIGO` AS cad_cliente_CODIGO,\n"
                    + "     cad_cliente.`NOME` AS cad_cliente_NOME,\n"
                    + "     cad_cliente.`ENDERECO` AS cad_cliente_ENDERECO,\n"
                    + "     cad_cliente.`TELEFONE` AS cad_cliente_TELEFONE,\n"
                    + "     cad_cliente.`numero` AS cad_cliente_numero,\n"
                    + "     cad_cliente.`complemento` AS cad_cliente_complemento,\n"
                    + "     cad_cliente.`data_nasc` AS cad_cliente_data_nasc,\n"
                    + "     cad_cliente.`cpf` AS cad_cliente_cpf,\n"
                    + "     cad_cliente.`referencia` AS cad_cliente_referencia,\n"
                    + "     cad_cliente.`email` AS cad_cliente_email,\n"
                    + "     produtos.`CODIGO` AS produtos_CODIGO,\n"
                    + "     produtos.`NOME` AS produtos_NOME,\n"
                    + "     produtos.`CODIGO_BARRAS` AS produtos_CODIGO_BARRAS\n"
                    + "FROM\n"
                    + "     `vendas` vendas LEFT JOIN `vendas_produto` vendas_produto ON vendas.`CODIGO` = vendas_produto.`CODIGO_VENDA`\n"
                    + "     LEFT JOIN `tipo_pagamento` tipo_pagamento ON vendas.`TIPO_PAGAMENTO` = tipo_pagamento.`pk_codigo`\n"
                    + "     LEFT JOIN `cad_cliente` cad_cliente ON vendas.`CLIENTES_CODIGO` = cad_cliente.`CODIGO`\n"
                    + "     LEFT JOIN `produtos` produtos ON vendas_produto.`CODIGO_PRODUTO` = produtos.`CODIGO`"
                    + " where vendas.`DATA_VENDA` between '" + pDataIni + "' and '" + pDataFim + "' and vendas.`CLIENTES_CODIGO` = ' " + pCliente + "'"
            );
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioVendasClienteData.jasper");
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

    public boolean gerarRelatorioVendaClienteDataBKP(Date pDataIni, Date pDataFim, int pCliente) {
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT\n"
                    + "     vendas.`CODIGO` AS vendas_CODIGO,\n"
                    + "     vendas.`CLIENTES_CODIGO` AS vendas_CLIENTES_CODIGO,\n"
                    + "     vendas.`DATA_VENDA` AS vendas_DATA_VENDA,\n"
                    + "     vendas.`VALOR_TOTAL` AS vendas_VALOR_TOTAL,\n"
                    + "     vendas.`troco` AS vendas_troco,\n"
                    + "     vendas.`DESCONTO` AS vendas_DESCONTO,\n"
                    + "     vendas.`TIPO_PAGAMENTO` AS vendas_TIPO_PAGAMENTO,\n"
                    + "     vendas.`chave_acesso` AS vendas_chave_acesso,\n"
                    + "     vendas.`cpf_cliente` AS vendas_cpf_cliente,\n"
                    + "     vendas.`comanda` AS vendas_comanda,\n"
                    + "     vendas.`status` AS vendas_status,\n"
                    + "     vendas.`terminal` AS vendas_terminal,\n"
                    + "     vendas.`vendedor` AS vendas_vendedor,\n"
                    + "     vendas.`hora` AS vendas_hora,\n"
                    + "     vendas_produto.`CODIGO` AS vendas_produto_CODIGO,\n"
                    + "     vendas_produto.`CODIGO_PRODUTO` AS vendas_produto_CODIGO_PRODUTO,\n"
                    + "     vendas_produto.`CODIGO_VENDA` AS vendas_produto_CODIGO_VENDA,\n"
                    + "     vendas_produto.`QUANTIDADE` AS vendas_produto_QUANTIDADE,\n"
                    + "     vendas_produto.`item` AS vendas_produto_item,\n"
                    + "     vendas_produto.`nome` AS vendas_produto_nome,\n"
                    + "     vendas_produto.`un_descricao` AS vendas_produto_un_descricao,\n"
                    + "     vendas_produto.`ncm_num` AS vendas_produto_ncm_num,\n"
                    + "     vendas_produto.`cest_numero` AS vendas_produto_cest_numero,\n"
                    + "     vendas_produto.`origem` AS vendas_produto_origem,\n"
                    + "     vendas_produto.`cfop` AS vendas_produto_cfop,\n"
                    + "     vendas_produto.`pis` AS vendas_produto_pis,\n"
                    + "     vendas_produto.`cofins` AS vendas_produto_cofins,\n"
                    + "     vendas_produto.`ipi` AS vendas_produto_ipi,\n"
                    + "     vendas_produto.`valor` AS vendas_produto_valor,\n"
                    + "     vendas_produto.`codigo_barras` AS vendas_produto_codigo_barras,\n"
                    + "     vendas_produto.`cst` AS vendas_produto_cst,\n"
                    + "     vendas_produto.`comanda` AS vendas_produto_comanda,\n"
                    + "     tipo_pagamento.`pk_codigo` AS tipo_pagamento_pk_codigo,\n"
                    + "     tipo_pagamento.`descricao` AS tipo_pagamento_descricao,\n"
                    + "     cad_cliente.`CODIGO` AS cad_cliente_CODIGO,\n"
                    + "     cad_cliente.`NOME` AS cad_cliente_NOME,\n"
                    + "     cad_cliente.`ENDERECO` AS cad_cliente_ENDERECO,\n"
                    + "     cad_cliente.`TELEFONE` AS cad_cliente_TELEFONE,\n"
                    + "     cad_cliente.`numero` AS cad_cliente_numero,\n"
                    + "     cad_cliente.`complemento` AS cad_cliente_complemento,\n"
                    + "     cad_cliente.`data_nasc` AS cad_cliente_data_nasc,\n"
                    + "     cad_cliente.`cpf` AS cad_cliente_cpf,\n"
                    + "     cad_cliente.`referencia` AS cad_cliente_referencia,\n"
                    + "     cad_cliente.`email` AS cad_cliente_email \n"
                    + "FROM\n"
                    + "     `vendas` vendas INNER JOIN `vendas_produto` vendas_produto ON vendas.`CODIGO` = vendas_produto.`CODIGO_VENDA`\n"
                    + "     INNER JOIN `tipo_pagamento` tipo_pagamento ON vendas.`TIPO_PAGAMENTO` = tipo_pagamento.`pk_codigo`\n"
                    + "     INNER JOIN `cad_cliente` cad_cliente ON vendas.`CLIENTES_CODIGO` = cad_cliente.`CODIGO`"
                    + " where vendas.`DATA_VENDA` between '" + pDataIni + "' and '" + pDataFim + "' and vendas.`CLIENTES_CODIGO` = ' " + pCliente + "'"
            );
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioVendasClienteData.jasper");
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

    public boolean gerarRelatorioVendaCliente(String pCliente) {
        try {
            this.conectar();
            this.executarSQL("SELECT * FROM clientes INNER JOIN vendas ON clientes.CODIGO = vendas.CLIENTES_CODIGO INNER JOIN tipo_pagamento ON vendas.TIPO_PAGAMENTO = tipo_pagamento.pk_codigo WHERE nome = '" + pCliente + "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioVendasPeriodo.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            //String nomeArquivo = "D:/sistema/csController/Relatorios/rel.pdf";
            String nomeArquivo = "Relatorios/rel.pdf";
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
     * Gerar relatório de venda de uma conta a receber
     *
     * @param pCodigo
     * @return
     */
    public boolean gerarRelatorioContaVenda(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     vendas.CODIGO AS vendas_CODIGO, "
                    + "     vendas.CLIENTES_CODIGO AS vendas_CLIENTES_CODIGO, "
                    + "     vendas.DATA_VENDA AS vendas_DATA_VENDA, "
                    + "     vendas.VALOR_TOTAL AS vendas_VALOR_TOTAL, "
                    + "     vendas.DESCONTO AS vendas_DESCONTO, "
                    + "     vendas.TIPO_PAGAMENTO AS vendas_TIPO_PAGAMENTO, "
                    + "     vendas_produto.CODIGO AS vendas_produto_CODIGO, "
                    + "     vendas_produto.CODIGO_PRODUTO AS vendas_produto_CODIGO_PRODUTO, "
                    + "     vendas_produto.CODIGO_VENDA AS vendas_produto_CODIGO_VENDA, "
                    + "     vendas_produto.QUANTIDADE AS vendas_produto_QUANTIDADE, "
                    + "     produtos.CODIGO AS produtos_CODIGO, "
                    + "     produtos.FORNECEDORES_CODIGO AS produtos_FORNECEDORES_CODIGO, "
                    + "     produtos.NOME AS produtos_NOME, "
                    + "     produtos.VALOR AS produtos_VALOR, "
                    + "     produtos.ESTOQUE AS produtos_ESTOQUE, "
                    + "     produtos.CODIGO_BARRAS AS produtos_CODIGO_BARRAS, "
                    + "     clientes.CODIGO AS clientes_CODIGO, "
                    + "     clientes.NOME AS clientes_NOME, "
                    + "     clientes.ENDERECO AS clientes_ENDERECO, "
                    + "     clientes.BAIRRO AS clientes_BAIRRO, "
                    + "     clientes.CEP AS clientes_CEP, "
                    + "     clientes.TELEFONE AS clientes_TELEFONE, "
                    + "     cidade.nome AS cidade_nome, "
                    + "     estado.uf AS estado_uf "
                    + " FROM "
                    + "     clientes clientes INNER JOIN vendas vendas ON clientes.CODIGO = vendas.CLIENTES_CODIGO "
                    + "     INNER JOIN vendas_produto vendas_produto ON vendas.CODIGO = vendas_produto.CODIGO_VENDA "
                    + "     INNER JOIN produtos produtos ON vendas_produto.CODIGO_PRODUTO = produtos.CODIGO "
                    + "     INNER JOIN cidade cidade ON clientes.COD_CIDADE = cidade.codigo "
                    + "     INNER JOIN estado estado ON clientes.COD_ESTADO = estado.codigo "
                    + "     AND estado.codigo = cidade.fk_cod_estado "
                    + " WHERE vendas.CODIGO = '" + pCodigo + "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioContaVendasReceber.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "Relatorios/rel.pdf";
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

    public boolean gerarRelatorioContasReceberDATA(ModelContaReceber pModelContaReceber) {
        String pCaminho = "";
        if (pModelContaReceber.isSituacao() == 0) {
            pCaminho = "ArquivosJasper/relatorioReceber.jasper";
        } else {
            pCaminho = "ArquivosJasper/relatorioRecebidas.jasper";
        }
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     contas_receber.PK_CODIGO AS contas_receber_PK_CODIGO, "
                    + "     contas_receber.DESCRICAO AS contas_receber_DESCRICAO, "
                    + "     contas_receber.DATA AS contas_receber_DATA, "
                    + "     contas_receber.VENCIMENTO AS contas_receber_VENCIMENTO, "
                    + "     contas_receber.OBSERVACAO AS contas_receber_OBSERVACAO, "
                    + "     contas_receber.SITUACAO AS contas_receber_SITUACAO, "
                    + "     contas_receber.VALOR AS contas_receber_VALOR, "
                    + "     contas_receber.PAGAMENTO AS contas_receber_PAGAMENTO, "
                    + "     clientes.CODIGO AS clientes_CODIGO, "
                    + "     clientes.NOME AS clientes_NOME, "
                    + "     clientes.ENDERECO AS clientes_ENDERECO, "
                    + "     clientes.BAIRRO AS clientes_BAIRRO, "
                    + "     clientes.CEP AS clientes_CEP, "
                    + "     clientes.TELEFONE AS clientes_TELEFONE "
                    + " FROM "
                    + "     contas_receber contas_receber INNER JOIN clientes clientes ON contas_receber.FK_CODIGO_PESSOA = clientes.CODIGO  WHERE pagamento BETWEEN  '" + pModelContaReceber.getPagamento() + "' AND '" + pModelContaReceber.getVencimento() + "'"
                    + " AND SITUACAO = '" + pModelContaReceber.isSituacao() + "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream(pCaminho);
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "Relatorios/rel.pdf";
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

    public boolean gerarRelatorioContasPagarDATA(ModelContaPagar pModelContaPagar) {
        String pCaminho = "";
        if (pModelContaPagar.isSituacao() == 0) {
            pCaminho = "ArquivosJasper/relatorioPagar.jasper";
        } else {
            pCaminho = "ArquivosJasper/relatorioPagas.jasper";
        }
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     fornecedores. CODIGO  AS fornecedores_CODIGO, "
                    + "     fornecedores. NOME  AS fornecedores_NOME, "
                    + "     fornecedores. ENDERECO  AS fornecedores_ENDERECO, "
                    + "     fornecedores. BAIRRO  AS fornecedores_BAIRRO, "
                    + "     fornecedores. CEP  AS fornecedores_CEP, "
                    + "     fornecedores. TELEFONE  AS fornecedores_TELEFONE, "
                    + "     contas_pagar. PK_CODIGO  AS contas_pagar_PK_CODIGO, "
                    + "     contas_pagar. FK_CODIGO_PESSOA  AS contas_pagar_FK_CODIGO_PESSOA, "
                    + "     contas_pagar. DESCRICAO  AS contas_pagar_DESCRICAO, "
                    + "     contas_pagar. DATA  AS contas_pagar_DATA, "
                    + "     contas_pagar. VENCIMENTO  AS contas_pagar_VENCIMENTO, "
                    + "     contas_pagar. FK_TIPO_PAGAMENTO  AS contas_pagar_FK_TIPO_PAGAMENTO, "
                    + "     contas_pagar. OBSERVACAO  AS contas_pagar_OBSERVACAO, "
                    + "     contas_pagar. SITUACAO  AS contas_pagar_SITUACAO, "
                    + "     contas_pagar. VALOR  AS contas_pagar_VALOR, "
                    + "     contas_pagar. PAGAMENTO  AS contas_pagar_PAGAMENTO, "
                    + "     cidade. nome  AS cidade_nome, "
                    + "     estado. uf  AS estado_uf "
                    + " FROM "
                    + "      contas_pagar  contas_pagar INNER JOIN  fornecedores  fornecedores ON contas_pagar. FK_CODIGO_PESSOA  = fornecedores. CODIGO  "
                    + "     INNER JOIN  estado  estado ON fornecedores. COD_ESTADO  = estado. codigo  "
                    + "     INNER JOIN  cidade  cidade ON fornecedores. COD_CIDADE  = cidade. codigo  "
                    + "     AND estado. codigo  = cidade. fk_cod_estado  WHERE pagamento BETWEEN  '" + pModelContaPagar.getPagamento() + "' AND '" + pModelContaPagar.getVencimento() + "'"
                    + " AND SITUACAO = '" + pModelContaPagar.isSituacao() + "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream(pCaminho);
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "Relatorios/rel.pdf";
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

    public boolean gerarRelatorioContasReceberTODAS(ModelContaReceber pModelContaReceber) {
        String pCaminho = "";
        if (pModelContaReceber.isSituacao() == 0) {
            pCaminho = "ArquivosJasper/relatorioReceber.jasper";
        } else {
            pCaminho = "ArquivosJasper/relatorioRecebidas.jasper";
        }
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     contas_receber.PK_CODIGO AS contas_receber_PK_CODIGO,"
                    + "     contas_receber.DESCRICAO AS contas_receber_DESCRICAO,"
                    + "     contas_receber.DATA AS contas_receber_DATA,"
                    + "     contas_receber.VENCIMENTO AS contas_receber_VENCIMENTO,"
                    + "     contas_receber.OBSERVACAO AS contas_receber_OBSERVACAO,"
                    + "     contas_receber.SITUACAO AS contas_receber_SITUACAO,"
                    + "     contas_receber.VALOR AS contas_receber_VALOR,"
                    + "     contas_receber.PAGAMENTO AS contas_receber_PAGAMENTO,"
                    + "     clientes.CODIGO AS clientes_CODIGO,"
                    + "     clientes.NOME AS clientes_NOME,"
                    + "     clientes.ENDERECO AS clientes_ENDERECO,"
                    + "     clientes.BAIRRO AS clientes_BAIRRO,"
                    + "     clientes.CEP AS clientes_CEP,"
                    + "     clientes.TELEFONE AS clientes_TELEFONE "
                    + " FROM"
                    + "     contas_receber contas_receber INNER JOIN clientes clientes ON contas_receber.FK_CODIGO_PESSOA = clientes.CODIGO WHERE "
                    + "  SITUACAO = '" + pModelContaReceber.isSituacao() + "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream(pCaminho);
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "Relatorios/rel.pdf";
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

    public boolean gerarRelatorioContasPagarTODAS(ModelContaPagar pModelContaPagar) {
        String pCaminho = "";
        if (pModelContaPagar.isSituacao() == 0) {
            pCaminho = "ArquivosJasper/relatorioPagar.jasper";
        } else {
            pCaminho = "ArquivosJasper/relatorioPagas.jasper";
        }
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     fornecedores. CODIGO  AS fornecedores_CODIGO, "
                    + "     fornecedores. NOME  AS fornecedores_NOME, "
                    + "     fornecedores. ENDERECO  AS fornecedores_ENDERECO, "
                    + "     fornecedores. BAIRRO  AS fornecedores_BAIRRO, "
                    + "     fornecedores. CEP  AS fornecedores_CEP, "
                    + "     fornecedores. TELEFONE  AS fornecedores_TELEFONE, "
                    + "     contas_pagar. PK_CODIGO  AS contas_pagar_PK_CODIGO, "
                    + "     contas_pagar. FK_CODIGO_PESSOA  AS contas_pagar_FK_CODIGO_PESSOA, "
                    + "     contas_pagar. DESCRICAO  AS contas_pagar_DESCRICAO, "
                    + "     contas_pagar. DATA  AS contas_pagar_DATA, "
                    + "     contas_pagar. VENCIMENTO  AS contas_pagar_VENCIMENTO, "
                    + "     contas_pagar. FK_TIPO_PAGAMENTO  AS contas_pagar_FK_TIPO_PAGAMENTO, "
                    + "     contas_pagar. OBSERVACAO  AS contas_pagar_OBSERVACAO, "
                    + "     contas_pagar. SITUACAO  AS contas_pagar_SITUACAO, "
                    + "     contas_pagar. VALOR  AS contas_pagar_VALOR, "
                    + "     contas_pagar. PAGAMENTO  AS contas_pagar_PAGAMENTO, "
                    + "     cidade. nome  AS cidade_nome, "
                    + "     estado. uf  AS estado_uf "
                    + " FROM "
                    + "      contas_pagar  contas_pagar INNER JOIN  fornecedores  fornecedores ON contas_pagar. FK_CODIGO_PESSOA  = fornecedores. CODIGO  "
                    + "     INNER JOIN  estado  estado ON fornecedores. COD_ESTADO  = estado. codigo  "
                    + "     INNER JOIN  cidade  cidade ON fornecedores. COD_CIDADE  = cidade. codigo  "
                    + "     AND estado. codigo  = cidade. fk_cod_estado WHERE "
                    + " SITUACAO = '" + pModelContaPagar.isSituacao() + "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream(pCaminho);
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "Relatorios/rel.pdf";
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
