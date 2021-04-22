package DAO;

import model.ModelFormacaoBasica;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOFormacaoBasica extends ConexaoMySql {

    /**
    * grava FormacaoBasica
    * @param pModelFormacaoBasica
    * @return int
    */
    public int salvarFormacaoBasicaDAO(ModelFormacaoBasica pModelFormacaoBasica){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO formacao_basica ("
                    + "id,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelFormacaoBasica.getId() + "',"
                    + "'" + pModelFormacaoBasica.getDescricao() + "'"
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
    * recupera FormacaoBasica
    * @param pId
    * @return ModelFormacaoBasica
    */
    public ModelFormacaoBasica getFormacaoBasicaDAO(int pId){
        ModelFormacaoBasica modelFormacaoBasica = new ModelFormacaoBasica();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " formacao_basica"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFormacaoBasica.setId(this.getResultSet().getInt(1));
                modelFormacaoBasica.setDescricao(this.getResultSet().getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelFormacaoBasica;
    }

    /**
    * recupera uma lista de FormacaoBasica
        * @return ArrayList
    */
    public ArrayList<ModelFormacaoBasica> getListaFormacaoBasicaDAO(){
        ArrayList<ModelFormacaoBasica> listamodelFormacaoBasica = new ArrayList();
        ModelFormacaoBasica modelFormacaoBasica = new ModelFormacaoBasica();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " formacao_basica"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFormacaoBasica = new ModelFormacaoBasica();
                modelFormacaoBasica.setId(this.getResultSet().getInt(1));
                modelFormacaoBasica.setDescricao(this.getResultSet().getString(2));
                listamodelFormacaoBasica.add(modelFormacaoBasica);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelFormacaoBasica;
    }

    /**
    * atualiza FormacaoBasica
    * @param pModelFormacaoBasica
    * @return boolean
    */
    public boolean atualizarFormacaoBasicaDAO(ModelFormacaoBasica pModelFormacaoBasica){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE formacao_basica SET "
                    + "id = '" + pModelFormacaoBasica.getId() + "',"
                    + "descricao = '" + pModelFormacaoBasica.getDescricao() + "'"
                + " WHERE "
                    + "id = '" + pModelFormacaoBasica.getId() + "'"
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
    * exclui FormacaoBasica
    * @param pId
    * @return boolean
    */
    public boolean excluirFormacaoBasicaDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM formacao_basica "
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