package DAO;

import model.ModelTributacao;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author Charles
 */
public class DAOTributacao extends ConexaoMySql {

    /**
     * grava Tributacao
     *
     * @param pModelTributacao return int
     */
    public int salvarTributacaoDAO(ModelTributacao pModelTributacao) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO cad_tributacao ("
                    + "trib_codigo,"
                    + "trib_descricao,"
                    + "trib_cfop,"
                    + "trib_cst_fis,"
                    + "trib_pis_fis,"
                    + "trib_cofins_fis,"
                    + "trib_ipi,"
                    + "trib_uf_origem,"
                    + "trib_uf_dest"
                    + ") VALUES ("
                    + "'" + pModelTributacao.getTrib_codigo() + "',"
                    + "'" + pModelTributacao.getTrib_descricao() + "',"
                    + "'" + pModelTributacao.getTrib_cfop() + "',"
                    + "'" + pModelTributacao.getTrib_cst_fis() + "',"
                    + "'" + pModelTributacao.getTrib_pis_fis() + "',"
                    + "'" + pModelTributacao.getTrib_cofins_fis() + "',"
                    + "'" + pModelTributacao.getTrib_ipi() + "',"
                    + "'" + pModelTributacao.getTrib_uf_origem() + "',"
                    + "'" + pModelTributacao.getTrib_uf_dest() + "'"
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
     * recupera Tributacao
     *
     * @param pTrib_codigo return ModelTributacao
     */
    public ModelTributacao getTributacaoDAO(int pTrib_codigo) {
        ModelTributacao modelTributacao = new ModelTributacao();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "trib_codigo,"
                    + "trib_descricao,"
                    + "trib_cfop,"
                    + "trib_cst_fis,"
                    + "trib_pis_fis,"
                    + "trib_cofins_fis,"
                    + "trib_ipi,"
                    + "trib_uf_origem,"
                    + "trib_uf_dest"
                    + " FROM"
                    + " cad_tributacao"
                    + " WHERE"
                    + " trib_codigo = '" + pTrib_codigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelTributacao.setTrib_codigo(this.getResultSet().getInt(1));
                modelTributacao.setTrib_descricao(this.getResultSet().getString(2));
                modelTributacao.setTrib_cfop(this.getResultSet().getInt(3));
                modelTributacao.setTrib_cst_fis(this.getResultSet().getInt(4));
                modelTributacao.setTrib_pis_fis(this.getResultSet().getInt(5));
                modelTributacao.setTrib_cofins_fis(this.getResultSet().getInt(6));
                modelTributacao.setTrib_ipi(this.getResultSet().getInt(7));
                modelTributacao.setTrib_uf_origem(this.getResultSet().getInt(8));
                modelTributacao.setTrib_uf_dest(this.getResultSet().getInt(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelTributacao;
    }

    /**
     * recupera uma lista de Tributacao return ArrayList
     */
    public ArrayList<ModelTributacao> getListaTributacaoDAO() {
        ArrayList<ModelTributacao> listamodelTributacao = new ArrayList();
        ModelTributacao modelTributacao = new ModelTributacao();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "trib_codigo,"
                    + "trib_descricao,"
                    + "trib_cfop,"
                    + "trib_cst_fis,"
                    + "trib_pis_fis,"
                    + "trib_cofins_fis,"
                    + "trib_ipi,"
                    + "trib_uf_origem,"
                    + "trib_uf_dest"
                    + " FROM"
                    + " cad_tributacao"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelTributacao = new ModelTributacao();
                modelTributacao.setTrib_codigo(this.getResultSet().getInt(1));
                modelTributacao.setTrib_descricao(this.getResultSet().getString(2));
                modelTributacao.setTrib_cfop(this.getResultSet().getInt(3));
                modelTributacao.setTrib_cst_fis(this.getResultSet().getInt(4));
                modelTributacao.setTrib_pis_fis(this.getResultSet().getInt(5));
                modelTributacao.setTrib_cofins_fis(this.getResultSet().getInt(6));
                modelTributacao.setTrib_ipi(this.getResultSet().getInt(7));
                modelTributacao.setTrib_uf_origem(this.getResultSet().getInt(8));
                modelTributacao.setTrib_uf_dest(this.getResultSet().getInt(9));
                listamodelTributacao.add(modelTributacao);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelTributacao;
    }

    /**
     * atualiza Tributacao
     *
     * @param pModelTributacao return boolean
     */
    public boolean atualizarTributacaoDAO(ModelTributacao pModelTributacao) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE cad_tributacao SET "
                    + "trib_codigo = '" + pModelTributacao.getTrib_codigo() + "',"
                    + "trib_descricao = '" + pModelTributacao.getTrib_descricao() + "',"
                    + "trib_cfop = '" + pModelTributacao.getTrib_cfop() + "',"
                    + "trib_cst_fis = '" + pModelTributacao.getTrib_cst_fis() + "',"
                    + "trib_pis_fis = '" + pModelTributacao.getTrib_pis_fis() + "',"
                    + "trib_cofins_fis = '" + pModelTributacao.getTrib_cofins_fis() + "',"
                    + "trib_ipi = '" + pModelTributacao.getTrib_ipi() + "',"
                    + "trib_uf_origem = '" + pModelTributacao.getTrib_uf_origem() + "',"
                    + "trib_uf_dest = '" + pModelTributacao.getTrib_uf_dest() + "'"
                    + " WHERE "
                    + "trib_codigo = '" + pModelTributacao.getTrib_codigo() + "'"
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
     * exclui Tributacao
     *
     * @param pTrib_codigo return boolean
     */
    public boolean excluirTributacaoDAO(int pTrib_codigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM cad_tributacao "
                    + " WHERE "
                    + "trib_codigo = '" + pTrib_codigo + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
