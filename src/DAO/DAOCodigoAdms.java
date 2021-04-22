package DAO;

import model.ModelCodigoAdms;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOCodigoAdms extends ConexaoMySql {

    /**
    * grava CodigoAdms
    * @param pModelCodigoAdms
    * @return int
    */
    public int salvarCodigoAdmsDAO(ModelCodigoAdms pModelCodigoAdms){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO cad_cod_adms ("
                    + "id,"
                    + "cod_adms,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelCodigoAdms.getId() + "',"
                    + "'" + pModelCodigoAdms.getCod_adms() + "',"
                    + "'" + pModelCodigoAdms.getDescricao() + "'"
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
    * recupera CodigoAdms
    * @param pId
    * @return ModelCodigoAdms
    */
    public ModelCodigoAdms getCodigoAdmsDAO(int pId){
        ModelCodigoAdms modelCodigoAdms = new ModelCodigoAdms();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "cod_adms,"
                    + "descricao"
                 + " FROM"
                     + " cad_cod_adms"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCodigoAdms.setId(this.getResultSet().getInt(1));
                modelCodigoAdms.setCod_adms(this.getResultSet().getInt(2));
                modelCodigoAdms.setDescricao(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCodigoAdms;
    }

    /**
    * recupera uma lista de CodigoAdms
        * @return ArrayList
    */
    public ArrayList<ModelCodigoAdms> getListaCodigoAdmsDAO(){
        ArrayList<ModelCodigoAdms> listamodelCodigoAdms = new ArrayList();
        ModelCodigoAdms modelCodigoAdms = new ModelCodigoAdms();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "cod_adms,"
                    + "descricao"
                 + " FROM"
                     + " cad_cod_adms"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCodigoAdms = new ModelCodigoAdms();
                modelCodigoAdms.setId(this.getResultSet().getInt(1));
                modelCodigoAdms.setCod_adms(this.getResultSet().getInt(2));
                modelCodigoAdms.setDescricao(this.getResultSet().getString(3));
                listamodelCodigoAdms.add(modelCodigoAdms);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCodigoAdms;
    }

    /**
    * atualiza CodigoAdms
    * @param pModelCodigoAdms
    * @return boolean
    */
    public boolean atualizarCodigoAdmsDAO(ModelCodigoAdms pModelCodigoAdms){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE cad_cod_adms SET "
                    + "id = '" + pModelCodigoAdms.getId() + "',"
                    + "cod_adms = '" + pModelCodigoAdms.getCod_adms() + "',"
                    + "descricao = '" + pModelCodigoAdms.getDescricao() + "'"
                + " WHERE "
                    + "id = '" + pModelCodigoAdms.getId() + "'"
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
    * exclui CodigoAdms
    * @param pId
    * @return boolean
    */
    public boolean excluirCodigoAdmsDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM cad_cod_adms "
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