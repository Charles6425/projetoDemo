package DAO;

import model.ModelGrupoProduto;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author Charles
 */
public class DAOGrupoProduto extends ConexaoMySql {

    /**
     * grava GrupoProduto
     *
     * @param pModelGrupoProduto return int
     */
    public int salvarGrupoProdutoDAO(ModelGrupoProduto pModelGrupoProduto) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO cad_grupo_prod ("
                    + "gru_codigo,"
                    + "gru_descricao"
                    + ") VALUES ("
                    + "'" + pModelGrupoProduto.getGru_codigo() + "',"
                    + "'" + pModelGrupoProduto.getGru_descricao() + "'"
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
     * recupera GrupoProduto
     *
     * @param pGru_codigo return ModelGrupoProduto
     */
    public ModelGrupoProduto getGrupoProdutoDAO(int pGru_codigo) {
        ModelGrupoProduto modelGrupoProduto = new ModelGrupoProduto();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "gru_codigo,"
                    + "gru_descricao"
                    + " FROM"
                    + " cad_grupo_prod"
                    + " WHERE"
                    + " gru_codigo = '" + pGru_codigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelGrupoProduto.setGru_codigo(this.getResultSet().getInt(1));
                modelGrupoProduto.setGru_descricao(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelGrupoProduto;
    }

    /**
     * recupera GrupoProduto
     *
     * @param pGru_descricao return ModelGrupoProduto
     */
    public ModelGrupoProduto getGrupoProdutoDAO(String pGru_descricao) {
        ModelGrupoProduto modelGrupoProduto = new ModelGrupoProduto();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "gru_codigo"
                    + " FROM"
                    + " cad_grupo_prod"
                    + " WHERE"
                    + " gru_descricao = '" + pGru_descricao + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelGrupoProduto.setGru_codigo(this.getResultSet().getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelGrupoProduto;
    }

    /**
     * recupera uma lista de GrupoProduto return ArrayList
     */
    public ArrayList<ModelGrupoProduto> getListaGrupoProdutoDAO() {
        ArrayList<ModelGrupoProduto> listamodelGrupoProduto = new ArrayList();
        ModelGrupoProduto modelGrupoProduto = new ModelGrupoProduto();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "gru_codigo,"
                    + "gru_descricao"
                    + " FROM"
                    + " cad_grupo_prod"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelGrupoProduto = new ModelGrupoProduto();
                modelGrupoProduto.setGru_codigo(this.getResultSet().getInt(1));
                modelGrupoProduto.setGru_descricao(this.getResultSet().getString(2));
                listamodelGrupoProduto.add(modelGrupoProduto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelGrupoProduto;
    }

    /**
     * atualiza GrupoProduto
     *
     * @param pModelGrupoProduto return boolean
     */
    public boolean atualizarGrupoProdutoDAO(ModelGrupoProduto pModelGrupoProduto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE cad_grupo_prod SET "
                    + "gru_codigo = '" + pModelGrupoProduto.getGru_codigo() + "',"
                    + "gru_descricao = '" + pModelGrupoProduto.getGru_descricao() + "'"
                    + " WHERE "
                    + "gru_codigo = '" + pModelGrupoProduto.getGru_codigo() + "'"
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
     * exclui GrupoProduto
     *
     * @param pGru_codigo return boolean
     */
    public boolean excluirGrupoProdutoDAO(int pGru_codigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM cad_grupo_prod "
                    + " WHERE "
                    + "gru_codigo = '" + pGru_codigo + "'"
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
