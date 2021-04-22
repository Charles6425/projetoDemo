package DAO;

import model.ModelUnidadeEmpresa;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles
*/
public class DAOUnidadeEmpresa extends ConexaoMySql {

    /**
    * grava UnidadeEmpresa
    * @param pModelUnidadeEmpresa
    * return int
    */
    public int salvarUnidadeEmpresaDAO(ModelUnidadeEmpresa pModelUnidadeEmpresa){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO cad_unidade ("
                    + "id,"
                    + "id_empresa"
                + ") VALUES ("
                    + "'" + pModelUnidadeEmpresa.getId() + "',"
                    + "'" + pModelUnidadeEmpresa.getId_empresa() + "'"
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
    * recupera UnidadeEmpresa
    * @param pId
    * return ModelUnidadeEmpresa
    */
    public ModelUnidadeEmpresa getUnidadeEmpresaDAO(int pId){
        ModelUnidadeEmpresa modelUnidadeEmpresa = new ModelUnidadeEmpresa();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "id_empresa"
                 + " FROM"
                     + " cad_unidade"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUnidadeEmpresa.setId(this.getResultSet().getInt(1));
                modelUnidadeEmpresa.setId_empresa(this.getResultSet().getInt (2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelUnidadeEmpresa;
    }

    /**
    * recupera uma lista de UnidadeEmpresa
        * return ArrayList
    */
    public ArrayList<ModelUnidadeEmpresa> getListaUnidadeEmpresaDAO(){
        ArrayList<ModelUnidadeEmpresa> listamodelUnidadeEmpresa = new ArrayList();
        ModelUnidadeEmpresa modelUnidadeEmpresa = new ModelUnidadeEmpresa();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "id_empresa"
                 + " FROM"
                     + " cad_unidade"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUnidadeEmpresa = new ModelUnidadeEmpresa();
                modelUnidadeEmpresa.setId(this.getResultSet().getInt(1));
                modelUnidadeEmpresa.setId_empresa(this.getResultSet().getInt (2));
                listamodelUnidadeEmpresa.add(modelUnidadeEmpresa);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelUnidadeEmpresa;
    }

    /**
    * atualiza UnidadeEmpresa
    * @param pModelUnidadeEmpresa
    * return boolean
    */
    public boolean atualizarUnidadeEmpresaDAO(ModelUnidadeEmpresa pModelUnidadeEmpresa){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE cad_unidade SET "
                    + "id = '" + pModelUnidadeEmpresa.getId() + "',"
                    + "id_empresa = '" + pModelUnidadeEmpresa.getId_empresa() + "'"
                + " WHERE "
                    + "id = '" + pModelUnidadeEmpresa.getId() + "'"
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
    * exclui UnidadeEmpresa
    * @param pId
    * return boolean
    */
    public boolean excluirUnidadeEmpresaDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM cad_unidade "
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