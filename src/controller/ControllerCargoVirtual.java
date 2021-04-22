package controller;

import model.ModelCargoVirtual;
import DAO.DAOCargoVirtual;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerCargoVirtual {

    private DAOCargoVirtual daoCargoVirtual = new DAOCargoVirtual();

    /**
    * grava CargoVirtual
    * @param pModelCargoVirtual
    * @return int
    */
    public int salvarCargoVirtualController(ModelCargoVirtual pModelCargoVirtual){
        return this.daoCargoVirtual.salvarCargoVirtualDAO(pModelCargoVirtual);
    }

    /**
    * recupera CargoVirtual
    * @param pId
    * @return ModelCargoVirtual
    */
    public ModelCargoVirtual getCargoVirtualController(int pId){
        return this.daoCargoVirtual.getCargoVirtualDAO(pId);
    }

    /**
    * recupera uma lista deCargoVirtual
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelCargoVirtual> getListaCargoVirtualController(){
        return this.daoCargoVirtual.getListaCargoVirtualDAO();
    }

    /**
    * atualiza CargoVirtual
    * @param pModelCargoVirtual
    * @return boolean
    */
    public boolean atualizarCargoVirtualController(ModelCargoVirtual pModelCargoVirtual){
        return this.daoCargoVirtual.atualizarCargoVirtualDAO(pModelCargoVirtual);
    }

    /**
    * exclui CargoVirtual
    * @param pId
    * @return boolean
    */
    public boolean excluirCargoVirtualController(int pId){
        return this.daoCargoVirtual.excluirCargoVirtualDAO(pId);
    }
}