package DAO;

import model.ModelCargo;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOCargo extends ConexaoMySql {

    /**
    * grava Cargo
    * @param pModelCargo
    * @return int
    */
    public int salvarCargoDAO(ModelCargo pModelCargo){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO cad_cargo ("
                    + "id,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelCargo.getId() + "',"
                    + "'" + pModelCargo.getDescricao() + "'"
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
    * recupera Cargo
    * @param pId
    * @return ModelCargo
    */
    public ModelCargo getCargoDAO(int pId){
        ModelCargo modelCargo = new ModelCargo();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " cad_cargo"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCargo.setId(this.getResultSet().getInt(1));
                modelCargo.setDescricao(this.getResultSet().getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCargo;
    }

    /**
    * recupera uma lista de Cargo
        * @return ArrayList
    */
    public ArrayList<ModelCargo> getListaCargoDAO(){
        ArrayList<ModelCargo> listamodelCargo = new ArrayList();
        ModelCargo modelCargo = new ModelCargo();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " cad_cargo"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCargo = new ModelCargo();
                modelCargo.setId(this.getResultSet().getInt(1));
                modelCargo.setDescricao(this.getResultSet().getString(2));
                listamodelCargo.add(modelCargo);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCargo;
    }

    /**
    * atualiza Cargo
    * @param pModelCargo
    * @return boolean
    */
    public boolean atualizarCargoDAO(ModelCargo pModelCargo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE cad_cargo SET "
                    + "id = '" + pModelCargo.getId() + "',"
                    + "descricao = '" + pModelCargo.getDescricao() + "'"
                + " WHERE "
                    + "id = '" + pModelCargo.getId() + "'"
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
    * exclui Cargo
    * @param pId
    * @return boolean
    */
    public boolean excluirCargoDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM cad_cargo "
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