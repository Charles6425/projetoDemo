package DAO;

import model.ModelTurma;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author Charles Müller
 */
public class DAOTurma extends ConexaoMySql {

    /**
     * grava Turma
     *
     * @param pModelTurma
     * @return int
     */
    public int salvarTurmaDAO(ModelTurma pModelTurma) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO cad_turma ("
                    + "id,"
                    + "descricao,"
                    + "ano,"
                    + "inicio,"
                    + "dias,"
                    + "fim,"
                    + "data_formatura"
                    + ") VALUES ("
                    + "'" + pModelTurma.getId() + "',"
                    + "'" + pModelTurma.getDescricao() + "',"
                    + "'" + pModelTurma.getAno()+ "',"
                    + "'" + pModelTurma.getInicio()+ "',"
                    + "'" + pModelTurma.getDias()+ "',"
                    + "'" + pModelTurma.getFim()+ "',"
                    + "'" + pModelTurma.getData_formatura()+ "'"
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
     * recupera Turma
     *
     * @param pId
     * @return ModelTurma
     */
    public ModelTurma getTurmaDAO(int pId) {
        ModelTurma modelTurma = new ModelTurma();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id,"
                    + "descricao,"
                    + "ano,"
                    + "inicio,"
                    + "dias,"
                    + "fim,"
                    + "data_formatura"
                    + " FROM"
                    + " cad_turma"
                    + " WHERE"
                    + " id = '" + pId + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelTurma.setId(this.getResultSet().getInt(1));
                modelTurma.setDescricao(this.getResultSet().getString(2));
                modelTurma.setAno(this.getResultSet().getString(3));
                modelTurma.setInicio(this.getResultSet().getString(4));
                modelTurma.setDias(this.getResultSet().getString(5));
                modelTurma.setFim(this.getResultSet().getString(6));
                modelTurma.setData_formatura(this.getResultSet().getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelTurma;
    }

    /**
     * recupera uma lista de Turma
     *
     * @return ArrayList
     */
    public ArrayList<ModelTurma> getListaTurmaDAO() {
        ArrayList<ModelTurma> listamodelTurma = new ArrayList();
        ModelTurma modelTurma = new ModelTurma();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id,"
                    + "descricao,"
                    + "ano,"
                    + "inicio,"
                    + "dias,"
                    + "fim,"
                    + "data_formatura"
                    + " FROM"
                    + " cad_turma"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelTurma = new ModelTurma();
                modelTurma.setId(this.getResultSet().getInt(1));
                modelTurma.setDescricao(this.getResultSet().getString(2));
                modelTurma.setAno(this.getResultSet().getString(3));
                modelTurma.setInicio(this.getResultSet().getString(4));
                modelTurma.setDias(this.getResultSet().getString(5));
                modelTurma.setFim(this.getResultSet().getString(6));
                modelTurma.setData_formatura(this.getResultSet().getString(7));
                listamodelTurma.add(modelTurma);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelTurma;
    }

    /**
     * atualiza Turma
     *
     * @param pModelTurma
     * @return boolean
     */
    public boolean atualizarTurmaDAO(ModelTurma pModelTurma) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE cad_turma SET "
                    + "id = '" + pModelTurma.getId() + "',"
                    + "descricao = '" + pModelTurma.getDescricao() + "',"
                    + "ano = '" + pModelTurma.getAno()+ "',"
                    + "inicio = '" + pModelTurma.getInicio()+ "',"
                    + "dias = '" + pModelTurma.getDias()+ "',"
                    + "fim = '" + pModelTurma.getFim()+ "',"
                    + "data_formatura = '" + pModelTurma.getData_formatura()+ "'"
                    + " WHERE "
                    + "id = '" + pModelTurma.getId() + "'"
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
     * exclui Turma
     *
     * @param pId
     * @return boolean
     */
    public boolean excluirTurmaDAO(int pId) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM cad_turma "
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
