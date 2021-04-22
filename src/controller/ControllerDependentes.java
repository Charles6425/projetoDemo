package controller;

import model.ModelDependentes;
import DAO.DAODependentes;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerDependentes {

    private DAODependentes daoDependentes = new DAODependentes();

    /**
    * grava Dependentes
    * @param pModelDependentes
    * @return int
    */
    public int salvarDependentesController(ModelDependentes pModelDependentes){
        return this.daoDependentes.salvarDependentesDAO(pModelDependentes);
    }

    /**
    * recupera Dependentes
    * @param pId
    * @return ModelDependentes
    */
    public ModelDependentes getDependentesController(int pId){
        return this.daoDependentes.getDependentesDAO(pId);
    }

    /**
    * recupera uma lista deDependentes
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelDependentes> getListaDependentesController(int pCodigo){
        return this.daoDependentes.getListaDependentesDAO(pCodigo);
    }

    /**
    * atualiza Dependentes
    * @param pModelDependentes
    * @return boolean
    */
    public boolean atualizarDependentesController(ModelDependentes pModelDependentes){
        return this.daoDependentes.atualizarDependentesDAO(pModelDependentes);
    }

    /**
    * exclui Dependentes
    * @param pId
    * @return boolean
    */
    public boolean excluirDependentesController(int pId){
        return this.daoDependentes.excluirDependentesDAO(pId);
    }
}