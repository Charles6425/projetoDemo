package controller;

import model.ModelCodigoAdms;
import DAO.DAOCodigoAdms;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerCodigoAdms {

    private DAOCodigoAdms daoCodigoAdms = new DAOCodigoAdms();

    /**
    * grava CodigoAdms
    * @param pModelCodigoAdms
    * @return int
    */
    public int salvarCodigoAdmsController(ModelCodigoAdms pModelCodigoAdms){
        return this.daoCodigoAdms.salvarCodigoAdmsDAO(pModelCodigoAdms);
    }

    /**
    * recupera CodigoAdms
    * @param pId
    * @return ModelCodigoAdms
    */
    public ModelCodigoAdms getCodigoAdmsController(int pId){
        return this.daoCodigoAdms.getCodigoAdmsDAO(pId);
    }

    /**
    * recupera uma lista deCodigoAdms
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelCodigoAdms> getListaCodigoAdmsController(){
        return this.daoCodigoAdms.getListaCodigoAdmsDAO();
    }

    /**
    * atualiza CodigoAdms
    * @param pModelCodigoAdms
    * @return boolean
    */
    public boolean atualizarCodigoAdmsController(ModelCodigoAdms pModelCodigoAdms){
        return this.daoCodigoAdms.atualizarCodigoAdmsDAO(pModelCodigoAdms);
    }

    /**
    * exclui CodigoAdms
    * @param pId
    * @return boolean
    */
    public boolean excluirCodigoAdmsController(int pId){
        return this.daoCodigoAdms.excluirCodigoAdmsDAO(pId);
    }
}