package DAO;

import model.ModelDiasIntensivo;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAODiasIntensivo extends ConexaoMySql {

    /**
    * grava DiasIntensivo
    * @param pModelDiasIntensivo
    * @return int
    */
    public int salvarDiasIntensivoDAO(ModelDiasIntensivo pModelDiasIntensivo){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO dias_intensivo ("
                    + "id,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelDiasIntensivo.getId() + "',"
                    + "'" + pModelDiasIntensivo.getDescricao() + "'"
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
    * recupera DiasIntensivo
    * @param pId
    * @return ModelDiasIntensivo
    */
    public ModelDiasIntensivo getDiasIntensivoDAO(int pId){
        ModelDiasIntensivo modelDiasIntensivo = new ModelDiasIntensivo();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " dias_intensivo"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelDiasIntensivo.setId(this.getResultSet().getInt(1));
                modelDiasIntensivo.setDescricao(this.getResultSet().getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelDiasIntensivo;
    }

    /**
    * recupera uma lista de DiasIntensivo
        * @return ArrayList
    */
    public ArrayList<ModelDiasIntensivo> getListaDiasIntensivoDAO(){
        ArrayList<ModelDiasIntensivo> listamodelDiasIntensivo = new ArrayList();
        ModelDiasIntensivo modelDiasIntensivo = new ModelDiasIntensivo();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " dias_intensivo"
                + ";"
            );

            while(this.getResultSet().next()){
                modelDiasIntensivo = new ModelDiasIntensivo();
                modelDiasIntensivo.setId(this.getResultSet().getInt(1));
                modelDiasIntensivo.setDescricao(this.getResultSet().getString(2));
                listamodelDiasIntensivo.add(modelDiasIntensivo);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelDiasIntensivo;
    }

    /**
    * atualiza DiasIntensivo
    * @param pModelDiasIntensivo
    * @return boolean
    */
    public boolean atualizarDiasIntensivoDAO(ModelDiasIntensivo pModelDiasIntensivo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE dias_intensivo SET "
                    + "id = '" + pModelDiasIntensivo.getId() + "',"
                    + "descricao = '" + pModelDiasIntensivo.getDescricao() + "'"
                + " WHERE "
                    + "id = '" + pModelDiasIntensivo.getId() + "'"
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
    * exclui DiasIntensivo
    * @param pId
    * @return boolean
    */
    public boolean excluirDiasIntensivoDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM dias_intensivo "
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