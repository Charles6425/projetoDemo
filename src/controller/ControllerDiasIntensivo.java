package controller;

import model.ModelDiasIntensivo;
import DAO.DAODiasIntensivo;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerDiasIntensivo {

    private DAODiasIntensivo daoDiasIntensivo = new DAODiasIntensivo();

    /**
    * grava DiasIntensivo
    * @param pModelDiasIntensivo
    * @return int
    */
    public int salvarDiasIntensivoController(ModelDiasIntensivo pModelDiasIntensivo){
        return this.daoDiasIntensivo.salvarDiasIntensivoDAO(pModelDiasIntensivo);
    }

    /**
    * recupera DiasIntensivo
    * @param pId
    * @return ModelDiasIntensivo
    */
    public ModelDiasIntensivo getDiasIntensivoController(int pId){
        return this.daoDiasIntensivo.getDiasIntensivoDAO(pId);
    }

    /**
    * recupera uma lista deDiasIntensivo
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelDiasIntensivo> getListaDiasIntensivoController(){
        return this.daoDiasIntensivo.getListaDiasIntensivoDAO();
    }

    /**
    * atualiza DiasIntensivo
    * @param pModelDiasIntensivo
    * @return boolean
    */
    public boolean atualizarDiasIntensivoController(ModelDiasIntensivo pModelDiasIntensivo){
        return this.daoDiasIntensivo.atualizarDiasIntensivoDAO(pModelDiasIntensivo);
    }

    /**
    * exclui DiasIntensivo
    * @param pId
    * @return boolean
    */
    public boolean excluirDiasIntensivoController(int pId){
        return this.daoDiasIntensivo.excluirDiasIntensivoDAO(pId);
    }
}