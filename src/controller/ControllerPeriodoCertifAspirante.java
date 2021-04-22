package controller;

import model.ModelPeriodoCertifAspirante;
import DAO.DAOPeriodoCertifAspirante;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerPeriodoCertifAspirante {

    private DAOPeriodoCertifAspirante daoPeriodoCertifAspirante = new DAOPeriodoCertifAspirante();

    /**
    * grava PeriodoCertifAspirante
    * @param pModelPeriodoCertifAspirante
    * @return int
    */
    public int salvarPeriodoCertifAspiranteController(ModelPeriodoCertifAspirante pModelPeriodoCertifAspirante){
        return this.daoPeriodoCertifAspirante.salvarPeriodoCertifAspiranteDAO(pModelPeriodoCertifAspirante);
    }

    /**
    * recupera PeriodoCertifAspirante
    * @param pId
    * @return ModelPeriodoCertifAspirante
    */
    public ModelPeriodoCertifAspirante getPeriodoCertifAspiranteController(int pId){
        return this.daoPeriodoCertifAspirante.getPeriodoCertifAspiranteDAO(pId);
    }

    /**
    * recupera uma lista dePeriodoCertifAspirante
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelPeriodoCertifAspirante> getListaPeriodoCertifAspiranteController(){
        return this.daoPeriodoCertifAspirante.getListaPeriodoCertifAspiranteDAO();
    }

    /**
    * atualiza PeriodoCertifAspirante
    * @param pModelPeriodoCertifAspirante
    * @return boolean
    */
    public boolean atualizarPeriodoCertifAspiranteController(ModelPeriodoCertifAspirante pModelPeriodoCertifAspirante){
        return this.daoPeriodoCertifAspirante.atualizarPeriodoCertifAspiranteDAO(pModelPeriodoCertifAspirante);
    }

    /**
    * exclui PeriodoCertifAspirante
    * @param pId
    * @return boolean
    */
    public boolean excluirPeriodoCertifAspiranteController(int pId){
        return this.daoPeriodoCertifAspirante.excluirPeriodoCertifAspiranteDAO(pId);
    }
}