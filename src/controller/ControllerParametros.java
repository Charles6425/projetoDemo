package controller;

import model.ModelParametros;
import DAO.DAOParametros;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerParametros {

    private DAOParametros daoConfiguracoesGerais = new DAOParametros();

    /**
    * grava ConfiguracoesGerais
    * @param pModelConfiguracoesGerais
    * return int
    */
    public int salvarConfiguracoesGeraisController(ModelParametros pModelConfiguracoesGerais){
        return this.daoConfiguracoesGerais.salvarConfiguracoesGeraisDAO(pModelConfiguracoesGerais);
    }

    /**
    * recupera ConfiguracoesGerais
    * @param pConfig_id
    * return ModelParametros
    */
    public ModelParametros getConfiguracoesGeraisController(int pConfig_id){
        return this.daoConfiguracoesGerais.getConfiguracoesGeraisDAO(pConfig_id);
    }

    /**
    * recupera uma lista deConfiguracoesGerais
    * @param pConfig_id
    * return ArrayList
    */
    public ArrayList<ModelParametros> getListaConfiguracoesGeraisController(){
        return this.daoConfiguracoesGerais.getListaConfiguracoesGeraisDAO();
    }

    /**
    * atualiza ConfiguracoesGerais
    * @param pModelConfiguracoesGerais
    * return boolean
    */
    public boolean atualizarConfiguracoesGeraisController(ModelParametros pModelConfiguracoesGerais){
        return this.daoConfiguracoesGerais.atualizarConfiguracoesGeraisDAO(pModelConfiguracoesGerais);
    }

    /**
    * exclui ConfiguracoesGerais
    * @param pConfig_id
    * return boolean
    */
    public boolean excluirConfiguracoesGeraisController(int pConfig_id){
        return this.daoConfiguracoesGerais.excluirConfiguracoesGeraisDAO(pConfig_id);
    }
}