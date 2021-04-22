package controller;

import model.ModelCadastroSituacao;
import DAO.DAOCadastroSituacao;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerCadastroSituacao {

    private DAOCadastroSituacao daoCadastroSituacao = new DAOCadastroSituacao();

    /**
    * grava CadastroSituacao
    * @param pModelCadastroSituacao
    * @return int
    */
    public int salvarCadastroSituacaoController(ModelCadastroSituacao pModelCadastroSituacao){
        return this.daoCadastroSituacao.salvarCadastroSituacaoDAO(pModelCadastroSituacao);
    }

    /**
    * recupera CadastroSituacao
    * @param pId
    * @return ModelCadastroSituacao
    */
    public ModelCadastroSituacao getCadastroSituacaoController(String pId){
        return this.daoCadastroSituacao.getCadastroSituacaoDAO(pId);
    }

    /**
    * recupera uma lista deCadastroSituacao
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelCadastroSituacao> getListaCadastroSituacaoController(){
        return this.daoCadastroSituacao.getListaCadastroSituacaoDAO();
    }

    /**
    * atualiza CadastroSituacao
    * @param pModelCadastroSituacao
    * @return boolean
    */
    public boolean atualizarCadastroSituacaoController(ModelCadastroSituacao pModelCadastroSituacao){
        return this.daoCadastroSituacao.atualizarCadastroSituacaoDAO(pModelCadastroSituacao);
    }

    /**
    * exclui CadastroSituacao
    * @param pId
    * @return boolean
    */
    public boolean excluirCadastroSituacaoController(int pId){
        return this.daoCadastroSituacao.excluirCadastroSituacaoDAO(pId);
    }
}