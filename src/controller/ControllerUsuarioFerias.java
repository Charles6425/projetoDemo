package controller;

import model.ModelUsuarioFerias;
import DAO.DAOUsuarioFerias;
import java.util.ArrayList;

/**
*
* @author Charles
*/
public class ControllerUsuarioFerias {

    private DAOUsuarioFerias daoUsuarioFerias = new DAOUsuarioFerias();

    /**
    * grava UsuarioFerias
    * @param pModelUsuarioFerias
    * return int
    */
    public int salvarUsuarioFeriasController(ModelUsuarioFerias pModelUsuarioFerias){
        return this.daoUsuarioFerias.salvarUsuarioFeriasDAO(pModelUsuarioFerias);
    }

    /**
    * recupera UsuarioFerias
    * @param pId
    * return ModelUsuarioFerias
    */
    public ModelUsuarioFerias getUsuarioFeriasController(int pId){
        return this.daoUsuarioFerias.getUsuarioFeriasDAO(pId);
    }

    /**
    * recupera uma lista deUsuarioFerias
    * @param pId
    * return ArrayList
    */
    public ArrayList<ModelUsuarioFerias> getListaUsuarioFeriasController(){
        return this.daoUsuarioFerias.getListaUsuarioFeriasDAO();
    }
    /**
    * recupera uma lista deUsuarioFerias
    * @param pId
    * return ArrayList
    */
    public ArrayList<ModelUsuarioFerias> getListaUsuarioFeriasController(int pCod){
        return this.daoUsuarioFerias.getListaUsuarioFeriasDAO(pCod);
    }

    /**
    * atualiza UsuarioFerias
    * @param pModelUsuarioFerias
    * return boolean
    */
    public boolean atualizarUsuarioFeriasController(ModelUsuarioFerias pModelUsuarioFerias){
        return this.daoUsuarioFerias.atualizarUsuarioFeriasDAO(pModelUsuarioFerias);
    }

    /**
    * exclui UsuarioFerias
    * @param pId
    * return boolean
    */
    public boolean excluirUsuarioFeriasController(int pId){
        return this.daoUsuarioFerias.excluirUsuarioFeriasDAO(pId);
    }
}