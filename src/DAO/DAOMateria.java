package DAO;

import model.ModelMateria;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles
*/
public class DAOMateria extends ConexaoMySql {

    /**
    * grava Materia
    * @param pModelMateria
    * return int
    */
    public int salvarMateriaDAO(ModelMateria pModelMateria){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO materia ("
                    + "id,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelMateria.getId() + "',"
                    + "'" + pModelMateria.getDescricao() + "'"
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
    * recupera Materia
    * @param pId
    * return ModelMateria
    */
    public ModelMateria getMateriaDAO(int pId){
        ModelMateria modelMateria = new ModelMateria();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " materia"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelMateria.setId(this.getResultSet().getInt(1));
                modelMateria.setDescricao(this.getResultSet().getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelMateria;
    }

    /**
    * recupera uma lista de Materia
        * return ArrayList
    */
    public ArrayList<ModelMateria> getListaMateriaDAO(){
        ArrayList<ModelMateria> listamodelMateria = new ArrayList();
        ModelMateria modelMateria = new ModelMateria();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " materia"
                + ";"
            );

            while(this.getResultSet().next()){
                modelMateria = new ModelMateria();
                modelMateria.setId(this.getResultSet().getInt(1));
                modelMateria.setDescricao(this.getResultSet().getString(2));
                listamodelMateria.add(modelMateria);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelMateria;
    }

    /**
    * atualiza Materia
    * @param pModelMateria
    * return boolean
    */
    public boolean atualizarMateriaDAO(ModelMateria pModelMateria){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE materia SET "
                    + "id = '" + pModelMateria.getId() + "',"
                    + "descricao = '" + pModelMateria.getDescricao() + "'"
                + " WHERE "
                    + "id = '" + pModelMateria.getId() + "'"
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
    * exclui Materia
    * @param pId
    * return boolean
    */
    public boolean excluirMateriaDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM materia "
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