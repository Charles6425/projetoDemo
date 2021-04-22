package controller;

import model.ModelContatoEmpresa;
import DAO.DAOContatoEmpresa;
import java.util.ArrayList;

/**
*
* @author Charles
*/
public class ControllerContatoEmpresa {

    private DAOContatoEmpresa daoContatoEmpresa = new DAOContatoEmpresa();

    /**
    * grava ContatoEmpresa
    * @param pModelContatoEmpresa
    * return int
    */
    public int salvarContatoEmpresaController(ModelContatoEmpresa pModelContatoEmpresa){
        return this.daoContatoEmpresa.salvarContatoEmpresaDAO(pModelContatoEmpresa);
    }

    /**
    * recupera ContatoEmpresa
    * @param pId
    * return ModelContatoEmpresa
    */
    public ModelContatoEmpresa getContatoEmpresaController(int pId){
        return this.daoContatoEmpresa.getContatoEmpresaDAO(pId);
    }


    /**
    * recupera uma lista deContatoEmpresa
    * @param pId
    * return ArrayList
    */
    public ArrayList<ModelContatoEmpresa> getListaContatoEmpresaController(){
        return this.daoContatoEmpresa.getListaContatoEmpresaDAO();
    }
    /**
    * recupera uma lista deContatoEmpresa
    * @param pId
    * return ArrayList
    */
    public ArrayList<ModelContatoEmpresa> getListaContatoEmpresaController(int pIdEmpresa){
        return this.daoContatoEmpresa.getListaContatoEmpresaDAO(pIdEmpresa);
    }

    /**
    * atualiza ContatoEmpresa
    * @param pModelContatoEmpresa
    * return boolean
    */
    public boolean atualizarContatoEmpresaController(ModelContatoEmpresa pModelContatoEmpresa){
        return this.daoContatoEmpresa.atualizarContatoEmpresaDAO(pModelContatoEmpresa);
    }

    /**
    * exclui ContatoEmpresa
    * @param pId
    * return boolean
    */
    public boolean excluirContatoEmpresaController(int pId){
        return this.daoContatoEmpresa.excluirContatoEmpresaDAO(pId);
    }
}