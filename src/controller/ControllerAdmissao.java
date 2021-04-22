package controller;

import model.ModelAdmissao;
import DAO.DAOAdmissao;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerAdmissao {

    private DAOAdmissao daoAdmissao = new DAOAdmissao();

    /**
    * grava Admissao
    * @param pModelAdmissao
    * @return int
    */
    public int salvarAdmissaoController(ModelAdmissao pModelAdmissao){
        return this.daoAdmissao.salvarAdmissaoDAO(pModelAdmissao);
    }

    /**
    * recupera Admissao
    * @param pId
    * @return ModelAdmissao
    */
    public ModelAdmissao getAdmissaoController(int pId){
        return this.daoAdmissao.getAdmissaoDAO(pId);
    }

    /**
    * recupera uma lista deAdmissao
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelAdmissao> getListaAdmissaoController(){
        return this.daoAdmissao.getListaAdmissaoDAO();
    }

    /**
    * atualiza Admissao
    * @param pModelAdmissao
    * @return boolean
    */
    public boolean atualizarAdmissaoController(ModelAdmissao pModelAdmissao){
        return this.daoAdmissao.atualizarAdmissaoDAO(pModelAdmissao);
    }

    /**
    * exclui Admissao
    * @param pId
    * @return boolean
    */
    public boolean excluirAdmissaoController(int pId){
        return this.daoAdmissao.excluirAdmissaoDAO(pId);
    }
}