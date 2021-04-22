package controller;

import model.ModelUnidadeEmpresa;
import DAO.DAOUnidadeEmpresa;
import java.util.ArrayList;

/**
*
* @author Charles
*/
public class ControllerUnidadeEmpresa {

    private DAOUnidadeEmpresa daoUnidadeEmpresa = new DAOUnidadeEmpresa();

    /**
    * grava UnidadeEmpresa
    * @param pModelUnidadeEmpresa
    * return int
    */
    public int salvarUnidadeEmpresaController(ModelUnidadeEmpresa pModelUnidadeEmpresa){
        return this.daoUnidadeEmpresa.salvarUnidadeEmpresaDAO(pModelUnidadeEmpresa);
    }

    /**
    * recupera UnidadeEmpresa
    * @param pId
    * return ModelUnidadeEmpresa
    */
    public ModelUnidadeEmpresa getUnidadeEmpresaController(int pId){
        return this.daoUnidadeEmpresa.getUnidadeEmpresaDAO(pId);
    }

    /**
    * recupera uma lista deUnidadeEmpresa
    * @param pId
    * return ArrayList
    */
    public ArrayList<ModelUnidadeEmpresa> getListaUnidadeEmpresaController(){
        return this.daoUnidadeEmpresa.getListaUnidadeEmpresaDAO();
    }

    /**
    * atualiza UnidadeEmpresa
    * @param pModelUnidadeEmpresa
    * return boolean
    */
    public boolean atualizarUnidadeEmpresaController(ModelUnidadeEmpresa pModelUnidadeEmpresa){
        return this.daoUnidadeEmpresa.atualizarUnidadeEmpresaDAO(pModelUnidadeEmpresa);
    }

    /**
    * exclui UnidadeEmpresa
    * @param pId
    * return boolean
    */
    public boolean excluirUnidadeEmpresaController(int pId){
        return this.daoUnidadeEmpresa.excluirUnidadeEmpresaDAO(pId);
    }
}