package DAO;

import model.ModelCodEvento;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOCodEvento extends ConexaoMySql {

    /**
    * grava CodEvento
    * @param pModelCodEvento
    * @return int
    */
    public int salvarCodEventoDAO(ModelCodEvento pModelCodEvento){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO codigo_evento ("
                    + "id,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelCodEvento.getId() + "',"
                    + "'" + pModelCodEvento.getDescricao() + "'"
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
    * recupera CodEvento
    * @param pId
    * @return ModelCodEvento
    */
    public ModelCodEvento getCodEventoDAO(int pId){
        ModelCodEvento modelCodEvento = new ModelCodEvento();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " codigo_evento"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCodEvento.setId(this.getResultSet().getInt(1));
                modelCodEvento.setDescricao(this.getResultSet().getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCodEvento;
    }

    /**
    * recupera uma lista de CodEvento
        * @return ArrayList
    */
    public ArrayList<ModelCodEvento> getListaCodEventoDAO(){
        ArrayList<ModelCodEvento> listamodelCodEvento = new ArrayList();
        ModelCodEvento modelCodEvento = new ModelCodEvento();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " codigo_evento"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCodEvento = new ModelCodEvento();
                modelCodEvento.setId(this.getResultSet().getInt(1));
                modelCodEvento.setDescricao(this.getResultSet().getString(2));
                listamodelCodEvento.add(modelCodEvento);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCodEvento;
    }

    /**
    * atualiza CodEvento
    * @param pModelCodEvento
    * @return boolean
    */
    public boolean atualizarCodEventoDAO(ModelCodEvento pModelCodEvento){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE codigo_evento SET "
                    + "id = '" + pModelCodEvento.getId() + "',"
                    + "descricao = '" + pModelCodEvento.getDescricao() + "'"
                + " WHERE "
                    + "id = '" + pModelCodEvento.getId() + "'"
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
    * exclui CodEvento
    * @param pId
    * @return boolean
    */
    public boolean excluirCodEventoDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM codigo_evento "
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