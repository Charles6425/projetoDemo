package controller;

import model.ModelCodEvento;
import DAO.DAOCodEvento;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerCodEvento {

    private DAOCodEvento daoCodEvento = new DAOCodEvento();

    /**
    * grava CodEvento
    * @param pModelCodEvento
    * @return int
    */
    public int salvarCodEventoController(ModelCodEvento pModelCodEvento){
        return this.daoCodEvento.salvarCodEventoDAO(pModelCodEvento);
    }

    /**
    * recupera CodEvento
    * @param pId
    * @return ModelCodEvento
    */
    public ModelCodEvento getCodEventoController(int pId){
        return this.daoCodEvento.getCodEventoDAO(pId);
    }

    /**
    * recupera uma lista deCodEvento
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelCodEvento> getListaCodEventoController(){
        return this.daoCodEvento.getListaCodEventoDAO();
    }

    /**
    * atualiza CodEvento
    * @param pModelCodEvento
    * @return boolean
    */
    public boolean atualizarCodEventoController(ModelCodEvento pModelCodEvento){
        return this.daoCodEvento.atualizarCodEventoDAO(pModelCodEvento);
    }

    /**
    * exclui CodEvento
    * @param pId
    * @return boolean
    */
    public boolean excluirCodEventoController(int pId){
        return this.daoCodEvento.excluirCodEventoDAO(pId);
    }
}