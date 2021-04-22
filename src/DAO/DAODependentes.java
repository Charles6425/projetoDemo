package DAO;

import model.ModelDependentes;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author Charles Müller
 */
public class DAODependentes extends ConexaoMySql {

    /**
     * grava Dependentes
     *
     * @param pModelDependentes
     * @return int
     */
    public int salvarDependentesDAO(ModelDependentes pModelDependentes) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO dependentes ("
                    + "id,"
                    + "nome,"
                    + "idade,"
                    + "sexo,"
                    + "id_asp"
                    + ") VALUES ("
                    + "'" + pModelDependentes.getId() + "',"
                    + "'" + pModelDependentes.getNome() + "',"
                    + "'" + pModelDependentes.getIdade() + "',"
                    + "'" + pModelDependentes.getSexo() + "',"
                    + "'" + pModelDependentes.getId_asp() + "'"
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
     * recupera Dependentes
     *
     * @param pId
     * @return ModelDependentes
     */
    public ModelDependentes getDependentesDAO(int pId) {
        ModelDependentes modelDependentes = new ModelDependentes();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id,"
                    + "nome,"
                    + "idade,"
                    + "sexo,"
                    + "id_asp"
                    + " FROM"
                    + " dependentes"
                    + " WHERE"
                    + " id_asp = '" + pId + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelDependentes.setId(this.getResultSet().getInt(1));
                modelDependentes.setNome(this.getResultSet().getString(2));
                modelDependentes.setIdade(this.getResultSet().getInt(3));
                modelDependentes.setSexo(this.getResultSet().getString(4));
                modelDependentes.setId_asp(this.getResultSet().getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelDependentes;
    }

    /**
     * recupera uma lista de Dependentes
     *
     * @return ArrayList
     */
    public ArrayList<ModelDependentes> getListaDependentesDAO(int pCodigo) {
        ArrayList<ModelDependentes> listamodelDependentes = new ArrayList();
        ModelDependentes modelDependentes = new ModelDependentes();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id,"
                    + "nome,"
                    + "idade,"
                    + "sexo,"
                    + "id_asp"
                    + " FROM"
                    + " dependentes"
                    + " where id_asp='" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelDependentes = new ModelDependentes();
                modelDependentes.setId(this.getResultSet().getInt(1));
                modelDependentes.setNome(this.getResultSet().getString(2));
                modelDependentes.setIdade(this.getResultSet().getInt(3));
                modelDependentes.setSexo(this.getResultSet().getString(4));
                modelDependentes.setId_asp(this.getResultSet().getInt(5));
                listamodelDependentes.add(modelDependentes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelDependentes;
    }

    /**
     * atualiza Dependentes
     *
     * @param pModelDependentes
     * @return boolean
     */
    public boolean atualizarDependentesDAO(ModelDependentes pModelDependentes) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE dependentes SET "
                    + "id = '" + pModelDependentes.getId() + "',"
                    + "nome = '" + pModelDependentes.getNome() + "',"
                    + "idade = '" + pModelDependentes.getIdade() + "',"
                    + "sexo = '" + pModelDependentes.getSexo() + "',"
                    + "id_asp = '" + pModelDependentes.getId_asp() + "'"
                    + " WHERE "
                    + "id = '" + pModelDependentes.getId() + "'"
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
     * exclui Dependentes
     *
     * @param pId
     * @return boolean
     */
    public boolean excluirDependentesDAO(int pId) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM dependentes "
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
}
