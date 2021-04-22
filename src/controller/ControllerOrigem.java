package controller;

import model.ModelOrigem;
import DAO.DAOOrigem;
import java.util.ArrayList;

/**
 *
 * @author Charles
 */
public class ControllerOrigem {

    private DAOOrigem daoOrigem = new DAOOrigem();

    /**
     * grava Origem
     *
     * @param pModelOrigem return int
     */
    public int salvarOrigemController(ModelOrigem pModelOrigem) {
        return this.daoOrigem.salvarOrigemDAO(pModelOrigem);
    }

    /**
     * recupera Origem
     *
     * @param pOrig_codigo return ModelOrigem
     */
    public ModelOrigem getOrigemController(int pOrig_codigo) {
        return this.daoOrigem.getOrigemDAO(pOrig_codigo);
    }

    /**
     * recupera Origem
     *
     * @param pOrig_descricao return ModelOrigem
     */
    public ModelOrigem getOrigemController(String pOrig_descricao) {
        return this.daoOrigem.getOrigemDAO(pOrig_descricao);
    }

    /**
     * recupera uma lista deOrigem
     *
     * @param pOrig_codigo return ArrayList
     */
    public ArrayList<ModelOrigem> getListaOrigemController() {
        return this.daoOrigem.getListaOrigemDAO();
    }

    /**
     * atualiza Origem
     *
     * @param pModelOrigem return boolean
     */
    public boolean atualizarOrigemController(ModelOrigem pModelOrigem) {
        return this.daoOrigem.atualizarOrigemDAO(pModelOrigem);
    }

    /**
     * exclui Origem
     *
     * @param pOrig_codigo return boolean
     */
    public boolean excluirOrigemController(int pOrig_codigo) {
        return this.daoOrigem.excluirOrigemDAO(pOrig_codigo);
    }
}
