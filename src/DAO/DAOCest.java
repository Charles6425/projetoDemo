package DAO;

import model.ModelCest;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author Charles
 */
public class DAOCest extends ConexaoMySql {

    /**
     * grava Cest
     *
     * @param pModelCest return int
     */
    public int salvarCestDAO(ModelCest pModelCest) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO cad_cest ("
                    + "cest_codigo,"
                    + "cest_numero,"
                    + "cest_descricao"
                    + ") VALUES ("
                    + "'" + pModelCest.getCest_codigo() + "',"
                    + "'" + pModelCest.getCest_numero() + "',"
                    + "'" + pModelCest.getCest_descricao() + "'"
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
     * recupera Cest
     *
     * @param pCest_codigo return ModelCest
     */
    public ModelCest getCestDAO(int pCest_codigo) {
        ModelCest modelCest = new ModelCest();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "cest_codigo,"
                    + "cest_numero,"
                    + "cest_descricao"
                    + " FROM"
                    + " cad_cest"
                    + " WHERE"
                    + " cest_codigo = '" + pCest_codigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCest.setCest_codigo(this.getResultSet().getInt(1));
                modelCest.setCest_numero(this.getResultSet().getInt(2));
                modelCest.setCest_descricao(this.getResultSet().getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCest;
    }

    /**
     * recupera uma lista de Cest return ArrayList
     */
    public ArrayList<ModelCest> getListaCestDAO() {
        ArrayList<ModelCest> listamodelCest = new ArrayList();
        ModelCest modelCest = new ModelCest();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "cest_codigo,"
                    + "cest_numero,"
                    + "cest_descricao"
                    + " FROM"
                    + " cad_cest"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCest = new ModelCest();
                modelCest.setCest_codigo(this.getResultSet().getInt(1));
                modelCest.setCest_numero(this.getResultSet().getInt(2));
                modelCest.setCest_descricao(this.getResultSet().getString(3));
                listamodelCest.add(modelCest);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelCest;
    }

    /**
     * atualiza Cest
     *
     * @param pModelCest return boolean
     */
    public boolean atualizarCestDAO(ModelCest pModelCest) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE cad_cest SET "
                    + "cest_codigo = '" + pModelCest.getCest_codigo() + "',"
                    + "cest_numero = '" + pModelCest.getCest_numero() + "',"
                    + "cest_descricao = '" + pModelCest.getCest_descricao() + "'"
                    + " WHERE "
                    + "cest_codigo = '" + pModelCest.getCest_codigo() + "'"
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
     * exclui Cest
     *
     * @param pCest_codigo return boolean
     */
    public boolean excluirCestDAO(int pCest_codigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM cad_cest "
                    + " WHERE "
                    + "cest_codigo = '" + pCest_codigo + "'"
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
