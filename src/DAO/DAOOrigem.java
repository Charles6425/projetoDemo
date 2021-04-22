package DAO;

import model.ModelOrigem;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author Charles
 */
public class DAOOrigem extends ConexaoMySql {

    /**
     * grava Origem
     *
     * @param pModelOrigem return int
     */
    public int salvarOrigemDAO(ModelOrigem pModelOrigem) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO cad_origem ("
                    + "orig_codigo,"
                    + "orig_descricao"
                    + ") VALUES ("
                    + "'" + pModelOrigem.getOrig_codigo() + "',"
                    + "'" + pModelOrigem.getOrig_descricao() + "'"
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
     * recupera Origem
     *
     * @param pOrig_codigo return ModelOrigem
     */
    public ModelOrigem getOrigemDAO(int pOrig_codigo) {
        ModelOrigem modelOrigem = new ModelOrigem();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "orig_codigo,"
                    + "orig_descricao"
                    + " FROM"
                    + " cad_origem"
                    + " WHERE"
                    + " orig_codigo = '" + pOrig_codigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelOrigem.setOrig_codigo(this.getResultSet().getInt(1));
                modelOrigem.setOrig_descricao(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelOrigem;
    }

    /**
     * recupera Origem
     *
     * @param pOrig_descricao return ModelOrigem
     */
    public ModelOrigem getOrigemDAO(String pOrig_descricao) {
        ModelOrigem modelOrigem = new ModelOrigem();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "orig_codigo, "
                    + "orig_descricao "
                    + " FROM"
                    + " cad_origem"
                    + " WHERE"
                    + " orig_descricao = '" + pOrig_descricao + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelOrigem.setOrig_codigo(this.getResultSet().getInt(1));
                modelOrigem.setOrig_descricao(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelOrigem;
    }

    /**
     * recupera uma lista de Origem return ArrayList
     */
    public ArrayList<ModelOrigem> getListaOrigemDAO() {
        ArrayList<ModelOrigem> listamodelOrigem = new ArrayList();
        ModelOrigem modelOrigem = new ModelOrigem();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "orig_codigo,"
                    + "orig_descricao"
                    + " FROM"
                    + " cad_origem"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelOrigem = new ModelOrigem();
                modelOrigem.setOrig_codigo(this.getResultSet().getInt(1));
                modelOrigem.setOrig_descricao(this.getResultSet().getString(2));
                listamodelOrigem.add(modelOrigem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelOrigem;
    }

    /**
     * atualiza Origem
     *
     * @param pModelOrigem return boolean
     */
    public boolean atualizarOrigemDAO(ModelOrigem pModelOrigem) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE cad_origem SET "
                    + "orig_codigo = '" + pModelOrigem.getOrig_codigo() + "',"
                    + "orig_descricao = '" + pModelOrigem.getOrig_descricao() + "'"
                    + " WHERE "
                    + "orig_codigo = '" + pModelOrigem.getOrig_codigo() + "'"
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
     * exclui Origem
     *
     * @param pOrig_codigo return boolean
     */
    public boolean excluirOrigemDAO(int pOrig_codigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM cad_origem "
                    + " WHERE "
                    + "orig_codigo = '" + pOrig_codigo + "'"
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
