package controller;

import model.ModelEmpresa;
import DAO.DAOEmpresa;
import java.util.ArrayList;

/**
*
* @author Charles
*/
public class ControllerEmpresa {

    private DAOEmpresa daoEmpresa = new DAOEmpresa();

    /**
    * grava Empresa
    * @param pModelEmpresa
    * return int
    */
    public int salvarEmpresaController(ModelEmpresa pModelEmpresa){
        return this.daoEmpresa.salvarEmpresaDAO(pModelEmpresa);
    }

    /**
    * recupera Empresa
    * @param pId
    * return ModelEmpresa
    */
    public ModelEmpresa getEmpresaController(int pId){
        return this.daoEmpresa.getEmpresaDAO(pId);
    }

    /**
    * recupera uma lista deEmpresa
    * @param pId
    * return ArrayList
    */
    public ArrayList<ModelEmpresa> getListaEmpresaController(){
        return this.daoEmpresa.getListaEmpresaDAO();
    }

    /**
    * atualiza Empresa
    * @param pModelEmpresa
    * return boolean
    */
    public boolean atualizarEmpresaController(ModelEmpresa pModelEmpresa){
        return this.daoEmpresa.atualizarEmpresaDAO(pModelEmpresa);
    }

    /**
    * exclui Empresa
    * @param pId
    * return boolean
    */
    public boolean excluirEmpresaController(int pId){
        return this.daoEmpresa.excluirEmpresaDAO(pId);
    }
}