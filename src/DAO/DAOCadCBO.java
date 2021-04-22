package DAO;

import model.ModelCadCBO;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOCadCBO extends ConexaoMySql {

    /**
    * grava CadCBO
    * @param pModelCadCBO
    * @return int
    */
    public int salvarCadCBODAO(ModelCadCBO pModelCadCBO){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO cad_cbo ("
                    + "id,"
                    + "cod_cbo,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelCadCBO.getId() + "',"
                    + "'" + pModelCadCBO.getCod_cbo() + "',"
                    + "'" + pModelCadCBO.getDescricao() + "'"
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
    * recupera CadCBO
    * @param pId
    * @return ModelCadCBO
    */
    public ModelCadCBO getCadCBODAO(int pId){
        ModelCadCBO modelCadCBO = new ModelCadCBO();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "cod_cbo,"
                    + "descricao"
                 + " FROM"
                     + " cad_cbo"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCadCBO.setId(this.getResultSet().getInt(1));
                modelCadCBO.setCod_cbo(this.getResultSet().getString(2));
                modelCadCBO.setDescricao(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCadCBO;
    }

    /**
    * recupera uma lista de CadCBO
        * @return ArrayList
    */
    public ArrayList<ModelCadCBO> getListaCadCBODAO(){
        ArrayList<ModelCadCBO> listamodelCadCBO = new ArrayList();
        ModelCadCBO modelCadCBO = new ModelCadCBO();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "cod_cbo,"
                    + "descricao"
                 + " FROM"
                     + " cad_cbo"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCadCBO = new ModelCadCBO();
                modelCadCBO.setId(this.getResultSet().getInt(1));
                modelCadCBO.setCod_cbo(this.getResultSet().getString(2));
                modelCadCBO.setDescricao(this.getResultSet().getString(3));
                listamodelCadCBO.add(modelCadCBO);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCadCBO;
    }

    /**
    * atualiza CadCBO
    * @param pModelCadCBO
    * @return boolean
    */
    public boolean atualizarCadCBODAO(ModelCadCBO pModelCadCBO){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE cad_cbo SET "
                    + "id = '" + pModelCadCBO.getId() + "',"
                    + "cod_cbo = '" + pModelCadCBO.getCod_cbo() + "',"
                    + "descricao = '" + pModelCadCBO.getDescricao() + "'"
                + " WHERE "
                    + "id = '" + pModelCadCBO.getId() + "'"
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
    * exclui CadCBO
    * @param pId
    * @return boolean
    */
    public boolean excluirCadCBODAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM cad_cbo "
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