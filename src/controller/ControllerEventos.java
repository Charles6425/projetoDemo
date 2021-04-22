package controller;

import model.ModelEventos;
import DAO.DAOEventos;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerEventos {

    private DAOEventos daoEventos = new DAOEventos();

    /**
    * grava Eventos
    * @param pModelEventos
    * @return int
    */
    public int salvarEventosController(ModelEventos pModelEventos){
        return this.daoEventos.salvarEventosDAO(pModelEventos);
    }

    /**
    * recupera Eventos
    * @param pId
    * @return ModelEventos
    */
    public ModelEventos getEventosController(int pId){
        return this.daoEventos.getEventosDAO(pId);
    }

    /**
    * recupera uma lista deEventos
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelEventos> getListaEventosController(){
        return this.daoEventos.getListaEventosDAO();
    }

    /**
    * atualiza Eventos
    * @param pModelEventos
    * @return boolean
    */
    public boolean atualizarEventosController(ModelEventos pModelEventos){
        return this.daoEventos.atualizarEventosDAO(pModelEventos);
    }

    /**
    * exclui Eventos
    * @param pId
    * @return boolean
    */
    public boolean excluirEventosController(int pId){
        return this.daoEventos.excluirEventosDAO(pId);
    }
}