package controller;

import model.ModelSala;
import DAO.DAOSala;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerSala {

    private DAOSala daoSala = new DAOSala();

    /**
    * grava Sala
    * @param pModelSala
    * @return int
    */
    public int salvarSalaController(ModelSala pModelSala){
        return this.daoSala.salvarSalaDAO(pModelSala);
    }

    /**
    * recupera Sala
    * @param pId
    * @return ModelSala
    */
    public ModelSala getSalaController(int pId){
        return this.daoSala.getSalaDAO(pId);
    }

    /**
    * recupera uma lista deSala
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelSala> getListaSalaController(){
        return this.daoSala.getListaSalaDAO();
    }

    /**
    * atualiza Sala
    * @param pModelSala
    * @return boolean
    */
    public boolean atualizarSalaController(ModelSala pModelSala){
        return this.daoSala.atualizarSalaDAO(pModelSala);
    }

    /**
    * exclui Sala
    * @param pId
    * @return boolean
    */
    public boolean excluirSalaController(int pId){
        return this.daoSala.excluirSalaDAO(pId);
    }
}