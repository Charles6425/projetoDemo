package DAO;

import model.ModelLocalAprendizagem;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOLocalAprendizagem extends ConexaoMySql {

    /**
    * grava LocalAprendizagem
    * @param pModelLocalAprendizagem
    * @return int
    */
    public int salvarLocalAprendizagemDAO(ModelLocalAprendizagem pModelLocalAprendizagem){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO local_aprendizagem ("
                    + "id,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelLocalAprendizagem.getId() + "',"
                    + "'" + pModelLocalAprendizagem.getDescricao() + "'"
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
    * recupera LocalAprendizagem
    * @param pId
    * @return ModelLocalAprendizagem
    */
    public ModelLocalAprendizagem getLocalAprendizagemDAO(int pId){
        ModelLocalAprendizagem modelLocalAprendizagem = new ModelLocalAprendizagem();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " local_aprendizagem"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelLocalAprendizagem.setId(this.getResultSet().getInt(1));
                modelLocalAprendizagem.setDescricao(this.getResultSet().getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelLocalAprendizagem;
    }

    /**
    * recupera uma lista de LocalAprendizagem
        * @return ArrayList
    */
    public ArrayList<ModelLocalAprendizagem> getListaLocalAprendizagemDAO(){
        ArrayList<ModelLocalAprendizagem> listamodelLocalAprendizagem = new ArrayList();
        ModelLocalAprendizagem modelLocalAprendizagem = new ModelLocalAprendizagem();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " local_aprendizagem"
                + ";"
            );

            while(this.getResultSet().next()){
                modelLocalAprendizagem = new ModelLocalAprendizagem();
                modelLocalAprendizagem.setId(this.getResultSet().getInt(1));
                modelLocalAprendizagem.setDescricao(this.getResultSet().getString(2));
                listamodelLocalAprendizagem.add(modelLocalAprendizagem);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelLocalAprendizagem;
    }

    /**
    * atualiza LocalAprendizagem
    * @param pModelLocalAprendizagem
    * @return boolean
    */
    public boolean atualizarLocalAprendizagemDAO(ModelLocalAprendizagem pModelLocalAprendizagem){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE local_aprendizagem SET "
                    + "id = '" + pModelLocalAprendizagem.getId() + "',"
                    + "descricao = '" + pModelLocalAprendizagem.getDescricao() + "'"
                + " WHERE "
                    + "id = '" + pModelLocalAprendizagem.getId() + "'"
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
    * exclui LocalAprendizagem
    * @param pId
    * @return boolean
    */
    public boolean excluirLocalAprendizagemDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM local_aprendizagem "
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