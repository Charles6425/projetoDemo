package DAO;

import model.ModelUsuarioFerias;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles
*/
public class DAOUsuarioFerias extends ConexaoMySql {

    /**
    * grava UsuarioFerias
    * @param pModelUsuarioFerias
    * return int
    */
    public int salvarUsuarioFeriasDAO(ModelUsuarioFerias pModelUsuarioFerias){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO usuario_ferias ("
                    + "id,"
                    + "id_usuario,"
                    + "dt_inicio,"
                    + "dt_fim"
                + ") VALUES ("
                    + "'" + pModelUsuarioFerias.getId() + "',"
                    + "'" + pModelUsuarioFerias.getId_usuario() + "',"
                    + "'" + pModelUsuarioFerias.getDt_inicio() + "',"
                    + "'" + pModelUsuarioFerias.getDt_fim() + "'"
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
    * recupera UsuarioFerias
    * @param pId
    * return ModelUsuarioFerias
    */
    public ModelUsuarioFerias getUsuarioFeriasDAO(int pId){
        ModelUsuarioFerias modelUsuarioFerias = new ModelUsuarioFerias();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "id_usuario,"
                    + "dt_inicio,"
                    + "dt_fim"
                 + " FROM"
                     + " usuario_ferias"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUsuarioFerias.setId(this.getResultSet().getInt(1));
                modelUsuarioFerias.setId_usuario(this.getResultSet().getInt (2));
                modelUsuarioFerias.setDt_inicio(this.getResultSet().getString(3));
                modelUsuarioFerias.setDt_fim(this.getResultSet().getString(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelUsuarioFerias;
    }

    /**
    * recupera uma lista de UsuarioFerias
        * return ArrayList
    */
    public ArrayList<ModelUsuarioFerias> getListaUsuarioFeriasDAO(){
        ArrayList<ModelUsuarioFerias> listamodelUsuarioFerias = new ArrayList();
        ModelUsuarioFerias modelUsuarioFerias = new ModelUsuarioFerias();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "id_usuario,"
                    + "dt_inicio,"
                    + "dt_fim"
                 + " FROM"
                     + " usuario_ferias"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUsuarioFerias = new ModelUsuarioFerias();
                modelUsuarioFerias.setId(this.getResultSet().getInt(1));
                modelUsuarioFerias.setId_usuario(this.getResultSet().getInt (2));
                modelUsuarioFerias.setDt_inicio(this.getResultSet().getString(3));
                modelUsuarioFerias.setDt_fim(this.getResultSet().getString(4));
                listamodelUsuarioFerias.add(modelUsuarioFerias);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelUsuarioFerias;
    }
    /**
    * recupera uma lista de UsuarioFerias
        * return ArrayList
    */
    public ArrayList<ModelUsuarioFerias> getListaUsuarioFeriasDAO(int pCod){
        ArrayList<ModelUsuarioFerias> listamodelUsuarioFerias = new ArrayList();
        ModelUsuarioFerias modelUsuarioFerias = new ModelUsuarioFerias();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "id_usuario,"
                    + "dt_inicio,"
                    + "dt_fim"
                 + " FROM"
                     + " usuario_ferias"
                        + " where id_usuario = '"+pCod+"'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUsuarioFerias = new ModelUsuarioFerias();
                modelUsuarioFerias.setId(this.getResultSet().getInt(1));
                modelUsuarioFerias.setId_usuario(this.getResultSet().getInt (2));
                modelUsuarioFerias.setDt_inicio(this.getResultSet().getString(3));
                modelUsuarioFerias.setDt_fim(this.getResultSet().getString(4));
                listamodelUsuarioFerias.add(modelUsuarioFerias);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelUsuarioFerias;
    }

    /**
    * atualiza UsuarioFerias
    * @param pModelUsuarioFerias
    * return boolean
    */
    public boolean atualizarUsuarioFeriasDAO(ModelUsuarioFerias pModelUsuarioFerias){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE usuario_ferias SET "
                    + "id = '" + pModelUsuarioFerias.getId() + "',"
                    + "id_usuario = '" + pModelUsuarioFerias.getId_usuario() + "',"
                    + "dt_inicio = '" + pModelUsuarioFerias.getDt_inicio() + "',"
                    + "dt_fim = '" + pModelUsuarioFerias.getDt_fim() + "'"
                + " WHERE "
                    + "id = '" + pModelUsuarioFerias.getId() + "'"
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
    * exclui UsuarioFerias
    * @param pId
    * return boolean
    */
    public boolean excluirUsuarioFeriasDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM usuario_ferias "
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