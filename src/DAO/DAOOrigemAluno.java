package DAO;

import model.ModelOrigemAluno;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOOrigemAluno extends ConexaoMySql {

    /**
    * grava OrigemAluno
    * @param pModelOrigemAluno
    * @return int
    */
    public int salvarOrigemAlunoDAO(ModelOrigemAluno pModelOrigemAluno){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO cad_origem_aluno ("
                    + "id,"
                    + "orig_descricao"
                + ") VALUES ("
                    + "'" + pModelOrigemAluno.getId() + "',"
                    + "'" + pModelOrigemAluno.getOrig_descricao() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera OrigemAluno
    * @param pId
    * @return ModelOrigemAluno
    */
    public ModelOrigemAluno getOrigemAlunoDAO(int pId){
        ModelOrigemAluno modelOrigemAluno = new ModelOrigemAluno();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "orig_descricao"
                 + " FROM"
                     + " cad_origem_aluno"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelOrigemAluno.setId(this.getResultSet().getInt(1));
                modelOrigemAluno.setOrig_descricao(this.getResultSet().getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelOrigemAluno;
    }

    /**
    * recupera uma lista de OrigemAluno
        * @return ArrayList
    */
    public ArrayList<ModelOrigemAluno> getListaOrigemAlunoDAO(){
        ArrayList<ModelOrigemAluno> listamodelOrigemAluno = new ArrayList();
        ModelOrigemAluno modelOrigemAluno = new ModelOrigemAluno();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "orig_descricao"
                 + " FROM"
                     + " cad_origem_aluno"
                + ";"
            );

            while(this.getResultSet().next()){
                modelOrigemAluno = new ModelOrigemAluno();
                modelOrigemAluno.setId(this.getResultSet().getInt(1));
                modelOrigemAluno.setOrig_descricao(this.getResultSet().getString(2));
                listamodelOrigemAluno.add(modelOrigemAluno);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelOrigemAluno;
    }

    /**
    * atualiza OrigemAluno
    * @param pModelOrigemAluno
    * @return boolean
    */
    public boolean atualizarOrigemAlunoDAO(ModelOrigemAluno pModelOrigemAluno){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE cad_origem_aluno SET "
                    + "id = '" + pModelOrigemAluno.getId() + "',"
                    + "orig_descricao = '" + pModelOrigemAluno.getOrig_descricao() + "'"
                + " WHERE "
                    + "id = '" + pModelOrigemAluno.getId() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui OrigemAluno
    * @param pId
    * @return boolean
    */
    public boolean excluirOrigemAlunoDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM cad_origem_aluno "
                + " WHERE "
                    + "id = '" + pId + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}