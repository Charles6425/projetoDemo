package controller;

import model.ModelCadCBO;
import DAO.DAOCadCBO;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerCadCBO {

    private DAOCadCBO daoCadCBO = new DAOCadCBO();

    /**
    * grava CadCBO
    * @param pModelCadCBO
    * @return int
    */
    public int salvarCadCBOController(ModelCadCBO pModelCadCBO){
        return this.daoCadCBO.salvarCadCBODAO(pModelCadCBO);
    }

    /**
    * recupera CadCBO
    * @param pId
    * @return ModelCadCBO
    */
    public ModelCadCBO getCadCBOController(int pId){
        return this.daoCadCBO.getCadCBODAO(pId);
    }

    /**
    * recupera uma lista deCadCBO
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelCadCBO> getListaCadCBOController(){
        return this.daoCadCBO.getListaCadCBODAO();
    }

    /**
    * atualiza CadCBO
    * @param pModelCadCBO
    * @return boolean
    */
    public boolean atualizarCadCBOController(ModelCadCBO pModelCadCBO){
        return this.daoCadCBO.atualizarCadCBODAO(pModelCadCBO);
    }

    /**
    * exclui CadCBO
    * @param pId
    * @return boolean
    */
    public boolean excluirCadCBOController(int pId){
        return this.daoCadCBO.excluirCadCBODAO(pId);
    }
}