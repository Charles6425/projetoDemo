package controller;

import model.ModelAprendizagemTeorica;
import DAO.DAOAprendizagemTeorica;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerAprendizagemTeorica {

    private DAOAprendizagemTeorica daoAprendizagemTeorica = new DAOAprendizagemTeorica();

    /**
    * grava AprendizagemTeorica
    * @param pModelAprendizagemTeorica
    * @return int
    */
    public int salvarAprendizagemTeoricaController(ModelAprendizagemTeorica pModelAprendizagemTeorica){
        return this.daoAprendizagemTeorica.salvarAprendizagemTeoricaDAO(pModelAprendizagemTeorica);
    }

    /**
    * recupera AprendizagemTeorica
    * @param pId
    * @return ModelAprendizagemTeorica
    */
    public ModelAprendizagemTeorica getAprendizagemTeoricaController(int pId){
        return this.daoAprendizagemTeorica.getAprendizagemTeoricaDAO(pId);
    }

    /**
    * recupera uma lista deAprendizagemTeorica
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelAprendizagemTeorica> getListaAprendizagemTeoricaController(){
        return this.daoAprendizagemTeorica.getListaAprendizagemTeoricaDAO();
    }

    /**
    * atualiza AprendizagemTeorica
    * @param pModelAprendizagemTeorica
    * @return boolean
    */
    public boolean atualizarAprendizagemTeoricaController(ModelAprendizagemTeorica pModelAprendizagemTeorica){
        return this.daoAprendizagemTeorica.atualizarAprendizagemTeoricaDAO(pModelAprendizagemTeorica);
    }

    /**
    * exclui AprendizagemTeorica
    * @param pId
    * @return boolean
    */
    public boolean excluirAprendizagemTeoricaController(int pId){
        return this.daoAprendizagemTeorica.excluirAprendizagemTeoricaDAO(pId);
    }
}