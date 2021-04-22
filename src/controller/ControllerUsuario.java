package controller;

import model.ModelUsuario;
import DAO.DAOUsuario;
import java.util.ArrayList;

/**
*
* @author Charles
*/
public class ControllerUsuario {

    private DAOUsuario daoUsuario = new DAOUsuario();

    /**
    * grava Usuario
    * @param pModelUsuario
    * return int
    */
    public int salvarUsuarioController(ModelUsuario pModelUsuario){
        return this.daoUsuario.salvarUsuarioDAO(pModelUsuario);
    }

    /**
    * recupera Usuario
    * @param pId
    * return ModelUsuario
    */
    public ModelUsuario getUsuarioController(int pId){
        return this.daoUsuario.getUsuarioDAO(pId);
    }
    /**
    * recupera Usuario
    * @param pId
    * return ModelUsuario
    */
    public ModelUsuario getUsuarioController(String pUsuario){
        return this.daoUsuario.getUsuarioDAO(pUsuario);
    }
    
        /**
     * recupera Usuario
     *
     * @param pModelUsuario return ModelUsuario
     */
    public boolean getUsuarioController(ModelUsuario pModelUsuario) {
        return this.daoUsuario.getUsuarioDAO(pModelUsuario);
    }

    /**
    * recupera uma lista deUsuario
    * @param pId
    * return ArrayList
    */
    public ArrayList<ModelUsuario> getListaUsuarioController(){
        return this.daoUsuario.getListaUsuarioDAO();
    }

    /**
    * atualiza Usuario
    * @param pModelUsuario
    * return boolean
    */
    public boolean atualizarUsuarioController(ModelUsuario pModelUsuario){
        return this.daoUsuario.atualizarUsuarioDAO(pModelUsuario);
    }

    /**
    * exclui Usuario
    * @param pId
    * return boolean
    */
    public boolean excluirUsuarioController(int pId){
        return this.daoUsuario.excluirUsuarioDAO(pId);
    }
}