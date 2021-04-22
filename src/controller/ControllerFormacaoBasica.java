package controller;

import model.ModelFormacaoBasica;
import DAO.DAOFormacaoBasica;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerFormacaoBasica {

    private DAOFormacaoBasica daoFormacaoBasica = new DAOFormacaoBasica();

    /**
    * grava FormacaoBasica
    * @param pModelFormacaoBasica
    * @return int
    */
    public int salvarFormacaoBasicaController(ModelFormacaoBasica pModelFormacaoBasica){
        return this.daoFormacaoBasica.salvarFormacaoBasicaDAO(pModelFormacaoBasica);
    }

    /**
    * recupera FormacaoBasica
    * @param pId
    * @return ModelFormacaoBasica
    */
    public ModelFormacaoBasica getFormacaoBasicaController(int pId){
        return this.daoFormacaoBasica.getFormacaoBasicaDAO(pId);
    }

    /**
    * recupera uma lista deFormacaoBasica
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelFormacaoBasica> getListaFormacaoBasicaController(){
        return this.daoFormacaoBasica.getListaFormacaoBasicaDAO();
    }

    /**
    * atualiza FormacaoBasica
    * @param pModelFormacaoBasica
    * @return boolean
    */
    public boolean atualizarFormacaoBasicaController(ModelFormacaoBasica pModelFormacaoBasica){
        return this.daoFormacaoBasica.atualizarFormacaoBasicaDAO(pModelFormacaoBasica);
    }

    /**
    * exclui FormacaoBasica
    * @param pId
    * @return boolean
    */
    public boolean excluirFormacaoBasicaController(int pId){
        return this.daoFormacaoBasica.excluirFormacaoBasicaDAO(pId);
    }
}