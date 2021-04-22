package controller;

import model.ModelPeriodo;
import DAO.DAOPeriodo;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerPeriodo {

    private DAOPeriodo daoPeriodo = new DAOPeriodo();

    /**
    * grava Periodo
    * @param pModelPeriodo
    * @return int
    */
    public int salvarPeriodoController(ModelPeriodo pModelPeriodo){
        return this.daoPeriodo.salvarPeriodoDAO(pModelPeriodo);
    }

    /**
    * recupera Periodo
    * @param pId
    * @return ModelPeriodo
    */
    public ModelPeriodo getPeriodoController(int pId){
        return this.daoPeriodo.getPeriodoDAO(pId);
    }

    /**
    * recupera uma lista dePeriodo
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelPeriodo> getListaPeriodoController(){
        return this.daoPeriodo.getListaPeriodoDAO();
    }

    /**
    * atualiza Periodo
    * @param pModelPeriodo
    * @return boolean
    */
    public boolean atualizarPeriodoController(ModelPeriodo pModelPeriodo){
        return this.daoPeriodo.atualizarPeriodoDAO(pModelPeriodo);
    }

    /**
    * exclui Periodo
    * @param pId
    * @return boolean
    */
    public boolean excluirPeriodoController(int pId){
        return this.daoPeriodo.excluirPeriodoDAO(pId);
    }
}