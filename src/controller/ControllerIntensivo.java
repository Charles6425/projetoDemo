package controller;

import model.ModelIntensivo;
import DAO.DAOIntensivo;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerIntensivo {

    private DAOIntensivo daoIntensivo = new DAOIntensivo();

    /**
    * grava Intensivo
    * @param pModelIntensivo
    * @return int
    */
    public int salvarIntensivoController(ModelIntensivo pModelIntensivo){
        return this.daoIntensivo.salvarIntensivoDAO(pModelIntensivo);
    }

    /**
    * recupera Intensivo
    * @param pId
    * @return ModelIntensivo
    */
    public ModelIntensivo getIntensivoController(int pId){
        return this.daoIntensivo.getIntensivoDAO(pId);
    }

    /**
    * recupera uma lista deIntensivo
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelIntensivo> getListaIntensivoController(){
        return this.daoIntensivo.getListaIntensivoDAO();
    }

    /**
    * atualiza Intensivo
    * @param pModelIntensivo
    * @return boolean
    */
    public boolean atualizarIntensivoController(ModelIntensivo pModelIntensivo){
        return this.daoIntensivo.atualizarIntensivoDAO(pModelIntensivo);
    }

    /**
    * exclui Intensivo
    * @param pId
    * @return boolean
    */
    public boolean excluirIntensivoController(int pId){
        return this.daoIntensivo.excluirIntensivoDAO(pId);
    }
}