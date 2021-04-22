package DAO;

import model.ModelUnidade;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author Charles
 */
public class DAOUnidade extends ConexaoMySql {

    /**
     * grava Unidade
     *
     * @param pModelUnidade return int
     */
    public int salvarUnidadeDAO(ModelUnidade pModelUnidade) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO cad_unidade ("
                   // + "un_codigo,"
                    + "un_descricao"
                    + ") VALUES ("
                    //+ "'" + pModelUnidade.getUn_codigo() + "',"
                    + "'" + pModelUnidade.getUn_descricao() + "'"
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
     * recupera Unidade
     *
     * @param pUn_codigo return ModelUnidade
     */
    public ModelUnidade getUnidadeDAO(int pUn_codigo) {
        ModelUnidade modelUnidade = new ModelUnidade();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "un_codigo,"
                    + "un_descricao"
                    + " FROM"
                    + " cad_unidade"
                    + " WHERE"
                    + " un_codigo = '" + pUn_codigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUnidade.setUn_codigo(this.getResultSet().getInt(1));
                modelUnidade.setUn_descricao(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelUnidade;
    }

    /**
     * recupera Unidade
     *
     * @param pUn_descricao return ModelUnidade
     */
    public ModelUnidade getUnidadeDAO(String pUn_descricao) {
        ModelUnidade modelUnidade = new ModelUnidade();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "un_codigo,"
                    + "un_descricao"
                    + " FROM"
                    + " cad_unidade"
                    + " WHERE"
                    + " un_descricao = '" + pUn_descricao + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUnidade.setUn_codigo(this.getResultSet().getInt(1));
                modelUnidade.setUn_descricao(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelUnidade;
    }

    /**
     * recupera uma lista de Unidade return ArrayList
     */
    public ArrayList<ModelUnidade> getListaUnidadeDAO() {
        ArrayList<ModelUnidade> listamodelUnidade = new ArrayList();
        ModelUnidade modelUnidade = new ModelUnidade();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "un_codigo,"
                    + "un_descricao"
                    + " FROM"
                    + " cad_unidade"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUnidade = new ModelUnidade();
                modelUnidade.setUn_codigo(this.getResultSet().getInt(1));
                modelUnidade.setUn_descricao(this.getResultSet().getString(2));
                listamodelUnidade.add(modelUnidade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelUnidade;
    }

    /**
     * atualiza Unidade
     *
     * @param pModelUnidade return boolean
     */
    public boolean atualizarUnidadeDAO(ModelUnidade pModelUnidade) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE cad_unidade SET "
                    + "un_codigo = '" + pModelUnidade.getUn_codigo() + "',"
                    + "un_descricao = '" + pModelUnidade.getUn_descricao() + "'"
                    + " WHERE "
                    + "un_codigo = '" + pModelUnidade.getUn_codigo() + "'"
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
     * exclui Unidade
     *
     * @param pUn_codigo return boolean
     */
    public boolean excluirUnidadeDAO(int pUn_codigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM cad_unidade "
                    + " WHERE "
                    + "un_codigo = '" + pUn_codigo + "'"
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
