package DAO;

import model.ModelDiaAtivTeorica;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAODiaAtivTeorica extends ConexaoMySql {

    /**
    * grava DiaAtivTeorica
    * @param pModelDiaAtivTeorica
    * @return int
    */
    public int salvarDiaAtivTeoricaDAO(ModelDiaAtivTeorica pModelDiaAtivTeorica){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO intensivo ("
                    + "id,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelDiaAtivTeorica.getId() + "',"
                    + "'" + pModelDiaAtivTeorica.getDescricao() + "'"
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
    * recupera DiaAtivTeorica
    * @param pId
    * @return ModelDiaAtivTeorica
    */
    public ModelDiaAtivTeorica getDiaAtivTeoricaDAO(int pId){
        ModelDiaAtivTeorica modelDiaAtivTeorica = new ModelDiaAtivTeorica();
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
                modelDiaAtivTeorica.setId(this.getResultSet().getInt(1));
                modelDiaAtivTeorica.setDescricao(this.getResultSet().getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelDiaAtivTeorica;
    }

    /**
    * recupera uma lista de DiaAtivTeorica
        * @return ArrayList
    */
    public ArrayList<ModelDiaAtivTeorica> getListaDiaAtivTeoricaDAO(){
        ArrayList<ModelDiaAtivTeorica> listamodelDiaAtivTeorica = new ArrayList();
        ModelDiaAtivTeorica modelDiaAtivTeorica = new ModelDiaAtivTeorica();
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
                modelDiaAtivTeorica = new ModelDiaAtivTeorica();
                modelDiaAtivTeorica.setId(this.getResultSet().getInt(1));
                modelDiaAtivTeorica.setDescricao(this.getResultSet().getString(2));
                listamodelDiaAtivTeorica.add(modelDiaAtivTeorica);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelDiaAtivTeorica;
    }

    /**
    * atualiza DiaAtivTeorica
    * @param pModelDiaAtivTeorica
    * @return boolean
    */
    public boolean atualizarDiaAtivTeoricaDAO(ModelDiaAtivTeorica pModelDiaAtivTeorica){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE intensivo SET "
                    + "id = '" + pModelDiaAtivTeorica.getId() + "',"
                    + "descricao = '" + pModelDiaAtivTeorica.getDescricao() + "'"
                + " WHERE "
                    + "id = '" + pModelDiaAtivTeorica.getId() + "'"
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
    * exclui DiaAtivTeorica
    * @param pId
    * @return boolean
    */
    public boolean excluirDiaAtivTeoricaDAO(int pId){
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