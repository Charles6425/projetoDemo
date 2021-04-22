package controller;

import model.ModelListaPresencaDiaria;
import DAO.DAOListaPresencaDiaria;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerListaPresencaDiaria {

    private DAOListaPresencaDiaria daoListaPresencaDiaria = new DAOListaPresencaDiaria();

    /**
    * grava ListaPresencaDiaria
    * @param pModelListaPresencaDiaria
    * @return int
    */
    public int salvarListaPresencaDiariaController(ModelListaPresencaDiaria pModelListaPresencaDiaria){
        return this.daoListaPresencaDiaria.salvarListaPresencaDiariaDAO(pModelListaPresencaDiaria);
    }

    /**
    * recupera ListaPresencaDiaria
    * @param pId
    * @return ModelListaPresencaDiaria
    */
    public ModelListaPresencaDiaria getListaPresencaDiariaController(int pId){
        return this.daoListaPresencaDiaria.getListaPresencaDiariaDAO(pId);
    }

    /**
    * recupera uma lista deListaPresencaDiaria
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelListaPresencaDiaria> getListaListaPresencaDiariaController(){
        return this.daoListaPresencaDiaria.getListaListaPresencaDiariaDAO();
    }

    /**
    * atualiza ListaPresencaDiaria
    * @param pModelListaPresencaDiaria
    * @return boolean
    */
    public boolean atualizarListaPresencaDiariaController(ModelListaPresencaDiaria pModelListaPresencaDiaria){
        return this.daoListaPresencaDiaria.atualizarListaPresencaDiariaDAO(pModelListaPresencaDiaria);
    }

    /**
    * exclui ListaPresencaDiaria
    * @param pId
    * @return boolean
    */
    public boolean excluirListaPresencaDiariaController(int pId){
        return this.daoListaPresencaDiaria.excluirListaPresencaDiariaDAO(pId);
    }
}