package DAO;

import model.ModelNcm;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author Charles
 */
public class DAONcm extends ConexaoMySql {

    /**
     * grava Ncm
     *
     * @param pModelNcm return int
     */
    public int salvarNcmDAO(ModelNcm pModelNcm) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO cad_ncm ("
                    + "ncm_num,"
                    + "ncm_descricao"
                    + ") VALUES ("
                    + "'" + pModelNcm.getNcm_num() + "',"
                    + "'" + pModelNcm.getNcm_descricao() + "'"
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
     * recupera Ncm
     *
     * @param pNcm_codigo return ModelNcm
     */
    public ModelNcm getNcmDAO(int pNcm_codigo) {
        ModelNcm modelNcm = new ModelNcm();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ncm_codigo,"
                    + "ncm_num,"
                    + "ncm_descricao"
                    + " FROM"
                    + " cad_ncm"
                    + " WHERE"
                    + " ncm_codigo = '" + pNcm_codigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelNcm.setNcm_codigo(this.getResultSet().getInt(1));
                modelNcm.setNcm_num(this.getResultSet().getString(2));
                modelNcm.setNcm_descricao(this.getResultSet().getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelNcm;
    }

    /**
     * recupera Ncm
     *
     * @param pNcm_codigo return ModelNcm
     */
    public ModelNcm getNcmDAO(String pNcm_num) {
        ModelNcm modelNcm = new ModelNcm();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ncm_codigo,"
                    + "ncm_num,"
                    + "ncm_descricao"
                    + " FROM"
                    + " cad_ncm"
                    + " WHERE"
                    + " ncm_num = '" + pNcm_num + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelNcm.setNcm_codigo(this.getResultSet().getInt(1));
                modelNcm.setNcm_num(this.getResultSet().getString(2));
                modelNcm.setNcm_descricao(this.getResultSet().getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelNcm;
    }

    /**
     * recupera uma lista de Ncm return ArrayList
     */
    public ArrayList<ModelNcm> getListaNcmDAO() {
        ArrayList<ModelNcm> listamodelNcm = new ArrayList();
        ModelNcm modelNcm = new ModelNcm();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ncm_codigo,"
                    + "ncm_num,"
                    + "ncm_descricao"
                    + " FROM"
                    + " cad_ncm"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelNcm = new ModelNcm();
                modelNcm.setNcm_codigo(this.getResultSet().getInt(1));
                modelNcm.setNcm_num(this.getResultSet().getString(2));
                modelNcm.setNcm_descricao(this.getResultSet().getString(3));
                listamodelNcm.add(modelNcm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelNcm;
    }

    /**
     * atualiza Ncm
     *
     * @param pModelNcm return boolean
     */
    public boolean atualizarNcmDAO(ModelNcm pModelNcm) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE cad_ncm SET "
                    + "ncm_codigo = '" + pModelNcm.getNcm_codigo() + "',"
                    + "ncm_num = '" + pModelNcm.getNcm_num() + "',"
                    + "ncm_descricao = '" + pModelNcm.getNcm_descricao() + "'"
                    + " WHERE "
                    + "ncm_codigo = '" + pModelNcm.getNcm_codigo() + "'"
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
     * exclui Ncm
     *
     * @param pNcm_codigo return boolean
     */
    public boolean excluirNcmDAO(int pNcm_codigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM cad_ncm "
                    + " WHERE "
                    + "ncm_codigo = '" + pNcm_codigo + "'"
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
