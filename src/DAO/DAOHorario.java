package DAO;

import model.ModelHorario;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles
*/
public class DAOHorario extends ConexaoMySql {

    /**
    * grava Horario
    * @param pModelHorario
    * return int
    */
    public int salvarHorarioDAO(ModelHorario pModelHorario){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO horario ("
                    + "id,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelHorario.getId() + "',"
                    + "'" + pModelHorario.getDescricao() + "'"
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
    * recupera Horario
    * @param pId
    * return ModelHorario
    */
    public ModelHorario getHorarioDAO(int pId){
        ModelHorario modelHorario = new ModelHorario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " horario"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelHorario.setId(this.getResultSet().getInt(1));
                modelHorario.setDescricao(this.getResultSet().getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelHorario;
    }

    /**
    * recupera uma lista de Horario
        * return ArrayList
    */
    public ArrayList<ModelHorario> getListaHorarioDAO(){
        ArrayList<ModelHorario> listamodelHorario = new ArrayList();
        ModelHorario modelHorario = new ModelHorario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " horario"
                + ";"
            );

            while(this.getResultSet().next()){
                modelHorario = new ModelHorario();
                modelHorario.setId(this.getResultSet().getInt(1));
                modelHorario.setDescricao(this.getResultSet().getString(2));
                listamodelHorario.add(modelHorario);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelHorario;
    }

    /**
    * atualiza Horario
    * @param pModelHorario
    * return boolean
    */
    public boolean atualizarHorarioDAO(ModelHorario pModelHorario){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE horario SET "
                    + "id = '" + pModelHorario.getId() + "',"
                    + "descricao = '" + pModelHorario.getDescricao() + "'"
                + " WHERE "
                    + "id = '" + pModelHorario.getId() + "'"
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
    * exclui Horario
    * @param pId
    * return boolean
    */
    public boolean excluirHorarioDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM horario "
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