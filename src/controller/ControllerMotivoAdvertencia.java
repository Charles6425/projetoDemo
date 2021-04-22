package controller;

import model.ModelMotivoAdvertencia;
import DAO.DAOMotivoAdvertencia;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerMotivoAdvertencia {

    private DAOMotivoAdvertencia daoMotivoAdvertencia = new DAOMotivoAdvertencia();

    /**
    * grava MotivoAdvertencia
    * @param pModelMotivoAdvertencia
    * @return int
    */
    public int salvarMotivoAdvertenciaController(ModelMotivoAdvertencia pModelMotivoAdvertencia){
        return this.daoMotivoAdvertencia.salvarMotivoAdvertenciaDAO(pModelMotivoAdvertencia);
    }

    /**
    * recupera MotivoAdvertencia
    * @param pId
    * @return ModelMotivoAdvertencia
    */
    public ModelMotivoAdvertencia getMotivoAdvertenciaController(int pId){
        return this.daoMotivoAdvertencia.getMotivoAdvertenciaDAO(pId);
    }

    /**
    * recupera uma lista deMotivoAdvertencia
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelMotivoAdvertencia> getListaMotivoAdvertenciaController(){
        return this.daoMotivoAdvertencia.getListaMotivoAdvertenciaDAO();
    }

    /**
    * atualiza MotivoAdvertencia
    * @param pModelMotivoAdvertencia
    * @return boolean
    */
    public boolean atualizarMotivoAdvertenciaController(ModelMotivoAdvertencia pModelMotivoAdvertencia){
        return this.daoMotivoAdvertencia.atualizarMotivoAdvertenciaDAO(pModelMotivoAdvertencia);
    }

    /**
    * exclui MotivoAdvertencia
    * @param pId
    * @return boolean
    */
    public boolean excluirMotivoAdvertenciaController(int pId){
        return this.daoMotivoAdvertencia.excluirMotivoAdvertenciaDAO(pId);
    }
}