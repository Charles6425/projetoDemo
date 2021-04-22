package DAO;

import model.ModelAprendizagemTeorica;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOAprendizagemTeorica extends ConexaoMySql {

    /**
    * grava AprendizagemTeorica
    * @param pModelAprendizagemTeorica
    * @return int
    */
    public int salvarAprendizagemTeoricaDAO(ModelAprendizagemTeorica pModelAprendizagemTeorica){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO aprendizagem_teorica ("
                    + "id,"
                    + "descricao,"
                    + "texto"
                + ") VALUES ("
                    + "'" + pModelAprendizagemTeorica.getId() + "',"
                    + "'" + pModelAprendizagemTeorica.getDescricao() + "',"
                    + "'" + pModelAprendizagemTeorica.getTexto() + "'"
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
    * recupera AprendizagemTeorica
    * @param pId
    * @return ModelAprendizagemTeorica
    */
    public ModelAprendizagemTeorica getAprendizagemTeoricaDAO(int pId){
        ModelAprendizagemTeorica modelAprendizagemTeorica = new ModelAprendizagemTeorica();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao,"
                    + "texto"
                 + " FROM"
                     + " aprendizagem_teorica"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelAprendizagemTeorica.setId(this.getResultSet().getInt(1));
                modelAprendizagemTeorica.setDescricao(this.getResultSet().getString(2));
                modelAprendizagemTeorica.setTexto(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelAprendizagemTeorica;
    }

    /**
    * recupera uma lista de AprendizagemTeorica
        * @return ArrayList
    */
    public ArrayList<ModelAprendizagemTeorica> getListaAprendizagemTeoricaDAO(){
        ArrayList<ModelAprendizagemTeorica> listamodelAprendizagemTeorica = new ArrayList();
        ModelAprendizagemTeorica modelAprendizagemTeorica = new ModelAprendizagemTeorica();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao,"
                    + "texto"
                 + " FROM"
                     + " aprendizagem_teorica"
                + ";"
            );

            while(this.getResultSet().next()){
                modelAprendizagemTeorica = new ModelAprendizagemTeorica();
                modelAprendizagemTeorica.setId(this.getResultSet().getInt(1));
                modelAprendizagemTeorica.setDescricao(this.getResultSet().getString(2));
                modelAprendizagemTeorica.setTexto(this.getResultSet().getString(3));
                listamodelAprendizagemTeorica.add(modelAprendizagemTeorica);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelAprendizagemTeorica;
    }

    /**
    * atualiza AprendizagemTeorica
    * @param pModelAprendizagemTeorica
    * @return boolean
    */
    public boolean atualizarAprendizagemTeoricaDAO(ModelAprendizagemTeorica pModelAprendizagemTeorica){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE aprendizagem_teorica SET "
                    + "id = '" + pModelAprendizagemTeorica.getId() + "',"
                    + "descricao = '" + pModelAprendizagemTeorica.getDescricao() + "',"
                    + "texto = '" + pModelAprendizagemTeorica.getTexto() + "'"
                + " WHERE "
                    + "id = '" + pModelAprendizagemTeorica.getId() + "'"
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
    * exclui AprendizagemTeorica
    * @param pId
    * @return boolean
    */
    public boolean excluirAprendizagemTeoricaDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM aprendizagem_teorica "
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