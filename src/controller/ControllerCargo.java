package controller;

import model.ModelCargo;
import DAO.DAOCargo;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerCargo {

    private DAOCargo daoCargo = new DAOCargo();

    /**
    * grava Cargo
    * @param pModelCargo
    * @return int
    */
    public int salvarCargoController(ModelCargo pModelCargo){
        return this.daoCargo.salvarCargoDAO(pModelCargo);
    }

    /**
    * recupera Cargo
    * @param pId
    * @return ModelCargo
    */
    public ModelCargo getCargoController(int pId){
        return this.daoCargo.getCargoDAO(pId);
    }

    /**
    * recupera uma lista deCargo
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelCargo> getListaCargoController(){
        return this.daoCargo.getListaCargoDAO();
    }

    /**
    * atualiza Cargo
    * @param pModelCargo
    * @return boolean
    */
    public boolean atualizarCargoController(ModelCargo pModelCargo){
        return this.daoCargo.atualizarCargoDAO(pModelCargo);
    }

    /**
    * exclui Cargo
    * @param pId
    * @return boolean
    */
    public boolean excluirCargoController(int pId){
        return this.daoCargo.excluirCargoDAO(pId);
    }
}