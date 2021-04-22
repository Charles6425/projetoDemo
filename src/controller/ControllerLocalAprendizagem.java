package controller;

import model.ModelLocalAprendizagem;
import DAO.DAOLocalAprendizagem;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerLocalAprendizagem {

    private DAOLocalAprendizagem daoLocalAprendizagem = new DAOLocalAprendizagem();

    /**
    * grava LocalAprendizagem
    * @param pModelLocalAprendizagem
    * @return int
    */
    public int salvarLocalAprendizagemController(ModelLocalAprendizagem pModelLocalAprendizagem){
        return this.daoLocalAprendizagem.salvarLocalAprendizagemDAO(pModelLocalAprendizagem);
    }

    /**
    * recupera LocalAprendizagem
    * @param pId
    * @return ModelLocalAprendizagem
    */
    public ModelLocalAprendizagem getLocalAprendizagemController(int pId){
        return this.daoLocalAprendizagem.getLocalAprendizagemDAO(pId);
    }

    /**
    * recupera uma lista deLocalAprendizagem
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelLocalAprendizagem> getListaLocalAprendizagemController(){
        return this.daoLocalAprendizagem.getListaLocalAprendizagemDAO();
    }

    /**
    * atualiza LocalAprendizagem
    * @param pModelLocalAprendizagem
    * @return boolean
    */
    public boolean atualizarLocalAprendizagemController(ModelLocalAprendizagem pModelLocalAprendizagem){
        return this.daoLocalAprendizagem.atualizarLocalAprendizagemDAO(pModelLocalAprendizagem);
    }

    /**
    * exclui LocalAprendizagem
    * @param pId
    * @return boolean
    */
    public boolean excluirLocalAprendizagemController(int pId){
        return this.daoLocalAprendizagem.excluirLocalAprendizagemDAO(pId);
    }
}