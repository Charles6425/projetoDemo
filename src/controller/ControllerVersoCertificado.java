package controller;

import model.ModelVersoCertificado;
import DAO.DAOVersoCertificado;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerVersoCertificado {

    private DAOVersoCertificado daoVersoCertificado = new DAOVersoCertificado();

    /**
    * grava VersoCertificado
    * @param pModelVersoCertificado
    * @return int
    */
    public int salvarVersoCertificadoController(ModelVersoCertificado pModelVersoCertificado){
        return this.daoVersoCertificado.salvarVersoCertificadoDAO(pModelVersoCertificado);
    }

    /**
    * recupera VersoCertificado
    * @param pId
    * @return ModelVersoCertificado
    */
    public ModelVersoCertificado getVersoCertificadoController(int pId){
        return this.daoVersoCertificado.getVersoCertificadoDAO(pId);
    }

    /**
    * recupera uma lista deVersoCertificado
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelVersoCertificado> getListaVersoCertificadoController(){
        return this.daoVersoCertificado.getListaVersoCertificadoDAO();
    }

    /**
    * atualiza VersoCertificado
    * @param pModelVersoCertificado
    * @return boolean
    */
    public boolean atualizarVersoCertificadoController(ModelVersoCertificado pModelVersoCertificado){
        return this.daoVersoCertificado.atualizarVersoCertificadoDAO(pModelVersoCertificado);
    }

    /**
    * exclui VersoCertificado
    * @param pId
    * @return boolean
    */
    public boolean excluirVersoCertificadoController(int pId){
        return this.daoVersoCertificado.excluirVersoCertificadoDAO(pId);
    }
}