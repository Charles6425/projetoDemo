package DAO;

import model.ModelCargoVirtual;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOCargoVirtual extends ConexaoMySql {

    /**
    * grava CargoVirtual
    * @param pModelCargoVirtual
    * @return int
    */
    public int salvarCargoVirtualDAO(ModelCargoVirtual pModelCargoVirtual){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO cargo_virtual ("
                    + "id,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelCargoVirtual.getId() + "',"
                    + "'" + pModelCargoVirtual.getDescricao() + "'"
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
    * recupera CargoVirtual
    * @param pId
    * @return ModelCargoVirtual
    */
    public ModelCargoVirtual getCargoVirtualDAO(int pId){
        ModelCargoVirtual modelCargoVirtual = new ModelCargoVirtual();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " cargo_virtual"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCargoVirtual.setId(this.getResultSet().getInt(1));
                modelCargoVirtual.setDescricao(this.getResultSet().getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCargoVirtual;
    }

    /**
    * recupera uma lista de CargoVirtual
        * @return ArrayList
    */
    public ArrayList<ModelCargoVirtual> getListaCargoVirtualDAO(){
        ArrayList<ModelCargoVirtual> listamodelCargoVirtual = new ArrayList();
        ModelCargoVirtual modelCargoVirtual = new ModelCargoVirtual();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " cargo_virtual"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCargoVirtual = new ModelCargoVirtual();
                modelCargoVirtual.setId(this.getResultSet().getInt(1));
                modelCargoVirtual.setDescricao(this.getResultSet().getString(2));
                listamodelCargoVirtual.add(modelCargoVirtual);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCargoVirtual;
    }

    /**
    * atualiza CargoVirtual
    * @param pModelCargoVirtual
    * @return boolean
    */
    public boolean atualizarCargoVirtualDAO(ModelCargoVirtual pModelCargoVirtual){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE cargo_virtual SET "
                    + "id = '" + pModelCargoVirtual.getId() + "',"
                    + "descricao = '" + pModelCargoVirtual.getDescricao() + "'"
                + " WHERE "
                    + "id = '" + pModelCargoVirtual.getId() + "'"
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
    * exclui CargoVirtual
    * @param pId
    * @return boolean
    */
    public boolean excluirCargoVirtualDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM cargo_virtual "
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