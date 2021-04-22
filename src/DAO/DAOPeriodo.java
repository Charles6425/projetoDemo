package DAO;

import model.ModelPeriodo;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOPeriodo extends ConexaoMySql {

    /**
    * grava Periodo
    * @param pModelPeriodo
    * @return int
    */
    public int salvarPeriodoDAO(ModelPeriodo pModelPeriodo){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO periodo ("
                    + "id,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelPeriodo.getId() + "',"
                    + "'" + pModelPeriodo.getDescricao() + "'"
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
    * recupera Periodo
    * @param pId
    * @return ModelPeriodo
    */
    public ModelPeriodo getPeriodoDAO(int pId){
        ModelPeriodo modelPeriodo = new ModelPeriodo();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " periodo"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelPeriodo.setId(this.getResultSet().getInt(1));
                modelPeriodo.setDescricao(this.getResultSet().getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelPeriodo;
    }

    /**
    * recupera uma lista de Periodo
        * @return ArrayList
    */
    public ArrayList<ModelPeriodo> getListaPeriodoDAO(){
        ArrayList<ModelPeriodo> listamodelPeriodo = new ArrayList();
        ModelPeriodo modelPeriodo = new ModelPeriodo();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " periodo"
                + ";"
            );

            while(this.getResultSet().next()){
                modelPeriodo = new ModelPeriodo();
                modelPeriodo.setId(this.getResultSet().getInt(1));
                modelPeriodo.setDescricao(this.getResultSet().getString(2));
                listamodelPeriodo.add(modelPeriodo);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelPeriodo;
    }

    /**
    * atualiza Periodo
    * @param pModelPeriodo
    * @return boolean
    */
    public boolean atualizarPeriodoDAO(ModelPeriodo pModelPeriodo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE periodo SET "
                    + "id = '" + pModelPeriodo.getId() + "',"
                    + "descricao = '" + pModelPeriodo.getDescricao() + "'"
                + " WHERE "
                    + "id = '" + pModelPeriodo.getId() + "'"
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
    * exclui Periodo
    * @param pId
    * @return boolean
    */
    public boolean excluirPeriodoDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM periodo "
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