package DAO;

import model.ModelEntrevistaAluno;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author Charles
 */
public class DAOEntrevistaAluno extends ConexaoMySql {

    /**
     * grava EntrevistaAluno
     *
     * @param pModelEntrevistaAluno return int
     */
    public int salvarEntrevistaAlunoDAO(ModelEntrevistaAluno pModelEntrevistaAluno) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO entrevista_aluno ("
                    + "id,"
                    + "id_aluno,"
                    + "id_empresa,"
                    + "data_entrevista,"
                    + "horario_entrevista "
                    + ") VALUES ("
                    + "'" + pModelEntrevistaAluno.getId() + "',"
                    + "'" + pModelEntrevistaAluno.getId_aluno() + "',"
                    + "'" + pModelEntrevistaAluno.getId_empresa() + "',"
                    + "'" + pModelEntrevistaAluno.getData_entrevista() + "',"
                    + "'" + pModelEntrevistaAluno.getHorario_entrevista()+ "'"
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
     * recupera EntrevistaAluno
     *
     * @param pId return ModelEntrevistaAluno
     */
    public ModelEntrevistaAluno getEntrevistaAlunoDAO(int pId) {
        ModelEntrevistaAluno modelEntrevistaAluno = new ModelEntrevistaAluno();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id,"
                    + "id_aluno,"
                    + "id_empresa,"
                    + "data_entrevista"
                    + " FROM"
                    + " entrevista_aluno,"
                    + " horario_entrevista"
                    + " WHERE"
                    + " id = '" + pId + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelEntrevistaAluno.setId(this.getResultSet().getInt(1));
                modelEntrevistaAluno.setId_aluno(this.getResultSet().getInt(2));
                modelEntrevistaAluno.setId_empresa(this.getResultSet().getInt(3));
                modelEntrevistaAluno.setHorario_entrevista(this.getResultSet().getString(4));
                modelEntrevistaAluno.setData_entrevista(this.getResultSet().getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelEntrevistaAluno;
    }

    /**
     * recupera uma lista de EntrevistaAluno return ArrayList
     */
    public ArrayList<ModelEntrevistaAluno> getListaEntrevistaAlunoDAO() {
        ArrayList<ModelEntrevistaAluno> listamodelEntrevistaAluno = new ArrayList();
        ModelEntrevistaAluno modelEntrevistaAluno = new ModelEntrevistaAluno();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id,"
                    + "id_aluno,"
                    + "id_empresa,"
                    + "data_entrevista,"
                    + "horario_entrevista"
                    + " FROM"
                    + " entrevista_aluno"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelEntrevistaAluno = new ModelEntrevistaAluno();
                modelEntrevistaAluno.setId(this.getResultSet().getInt(1));
                modelEntrevistaAluno.setId_aluno(this.getResultSet().getInt(2));
                modelEntrevistaAluno.setId_empresa(this.getResultSet().getInt(3));
                modelEntrevistaAluno.setData_entrevista(this.getResultSet().getString(4));
                modelEntrevistaAluno.setHorario_entrevista(this.getResultSet().getString(5));
                listamodelEntrevistaAluno.add(modelEntrevistaAluno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelEntrevistaAluno;
    }

    public ArrayList<ModelEntrevistaAluno> getListaEntrevistaAlunoDAO(int pCodAluno) {
        ArrayList<ModelEntrevistaAluno> listamodelEntrevistaAluno = new ArrayList();
        ModelEntrevistaAluno modelEntrevistaAluno = new ModelEntrevistaAluno();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id,"
                    + "id_aluno,"
                    + "id_empresa,"
                    + "data_entrevista,"
                    + "horario_entrevista "
                    + " FROM"
                    + " entrevista_aluno"
                    + " where id_aluno = '"+pCodAluno+"'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelEntrevistaAluno = new ModelEntrevistaAluno();
                modelEntrevistaAluno.setId(this.getResultSet().getInt(1));
                modelEntrevistaAluno.setId_aluno(this.getResultSet().getInt(2));
                modelEntrevistaAluno.setId_empresa(this.getResultSet().getInt(3));
                modelEntrevistaAluno.setData_entrevista(this.getResultSet().getString(4));
                modelEntrevistaAluno.setHorario_entrevista(this.getResultSet().getString(5));
                listamodelEntrevistaAluno.add(modelEntrevistaAluno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelEntrevistaAluno;
    }

    /**
     * atualiza EntrevistaAluno
     *
     * @param pModelEntrevistaAluno return boolean
     */
    public boolean atualizarEntrevistaAlunoDAO(ModelEntrevistaAluno pModelEntrevistaAluno) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE entrevista_aluno SET "
                    + "id = '" + pModelEntrevistaAluno.getId() + "',"
                    + "id_aluno = '" + pModelEntrevistaAluno.getId_aluno() + "',"
                    + "id_empresa = '" + pModelEntrevistaAluno.getId_empresa() + "',"
                    + "data_entrevista = '" + pModelEntrevistaAluno.getData_entrevista() + "',"
                    + "horario_entrevista = '" + pModelEntrevistaAluno.getHorario_entrevista()+ "'"
                    + " WHERE "
                    + "id = '" + pModelEntrevistaAluno.getId() + "'"
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
     * exclui EntrevistaAluno
     *
     * @param pId return boolean
     */
    public boolean excluirEntrevistaAlunoDAO(int pId) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM entrevista_aluno "
                    + " WHERE "
                    + "id_aluno = '" + pId + "'"
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
