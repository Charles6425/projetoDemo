package controller;

import model.ModelTributacao;
import DAO.DAOTributacao;
import java.util.ArrayList;

/**
 *
 * @author Charles
 */
public class ControllerTributacao {

    private DAOTributacao daoTributacao = new DAOTributacao();

    /**
     * grava Tributacao
     *
     * @param pModelTributacao return int
     */
    public int salvarTributacaoController(ModelTributacao pModelTributacao) {
        return this.daoTributacao.salvarTributacaoDAO(pModelTributacao);
    }

    /**
     * recupera Tributacao
     *
     * @param pTrib_codigo return ModelTributacao
     */
    public ModelTributacao getTributacaoController(int pTrib_codigo) {
        return this.daoTributacao.getTributacaoDAO(pTrib_codigo);
    }

    /**
     * recupera uma lista deTributacao
     *
     * @param pTrib_codigo return ArrayList
     */
    public ArrayList<ModelTributacao> getListaTributacaoController() {
        return this.daoTributacao.getListaTributacaoDAO();
    }

    /**
     * atualiza Tributacao
     *
     * @param pModelTributacao return boolean
     */
    public boolean atualizarTributacaoController(ModelTributacao pModelTributacao) {
        return this.daoTributacao.atualizarTributacaoDAO(pModelTributacao);
    }

    /**
     * exclui Tributacao
     *
     * @param pTrib_codigo return boolean
     */
    public boolean excluirTributacaoController(int pTrib_codigo) {
        return this.daoTributacao.excluirTributacaoDAO(pTrib_codigo);
    }
}
