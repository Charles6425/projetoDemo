package DAO;

import model.ModelIntensivo;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOIntensivo extends ConexaoMySql {

    /**
    * grava Intensivo
    * @param pModelIntensivo
    * @return int
    */
    public int salvarIntensivoDAO(ModelIntensivo pModelIntensivo){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO intensivo ("
                    + "id,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelIntensivo.getId() + "',"
                    + "'" + pModelIntensivo.getDescricao() + "'"
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
    * recupera Intensivo
    * @param pId
    * @return ModelIntensivo
    */
    public ModelIntensivo getIntensivoDAO(int pId){
        ModelIntensivo modelIntensivo = new ModelIntensivo();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " intensivo"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelIntensivo.setId(this.getResultSet().getInt(1));
                modelIntensivo.setDescricao(this.getResultSet().getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelIntensivo;
    }

    /**
    * recupera uma lista de Intensivo
        * @return ArrayList
    */
    public ArrayList<ModelIntensivo> getListaIntensivoDAO(){
        ArrayList<ModelIntensivo> listamodelIntensivo = new ArrayList();
        ModelIntensivo modelIntensivo = new ModelIntensivo();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " intensivo"
                + ";"
            );

            while(this.getResultSet().next()){
                modelIntensivo = new ModelIntensivo();
                modelIntensivo.setId(this.getResultSet().getInt(1));
                modelIntensivo.setDescricao(this.getResultSet().getString(2));
                listamodelIntensivo.add(modelIntensivo);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelIntensivo;
    }

    /**
    * atualiza Intensivo
    * @param pModelIntensivo
    * @return boolean
    */
    public boolean atualizarIntensivoDAO(ModelIntensivo pModelIntensivo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE intensivo SET "
                    + "id = '" + pModelIntensivo.getId() + "',"
                    + "descricao = '" + pModelIntensivo.getDescricao() + "'"
                + " WHERE "
                    + "id = '" + pModelIntensivo.getId() + "'"
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
    * exclui Intensivo
    * @param pId
    * @return boolean
    */
    public boolean excluirIntensivoDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM intensivo "
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