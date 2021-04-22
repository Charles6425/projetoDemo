package controller;

import model.ModelCest;
import DAO.DAOCest;
import java.util.ArrayList;

/**
 *
 * @author Charles
 */
public class ControllerCest {

    private DAOCest daoCest = new DAOCest();

    /**
     * grava Cest
     *
     * @param pModelCest return int
     */
    public int salvarCestController(ModelCest pModelCest) {
        return this.daoCest.salvarCestDAO(pModelCest);
    }

    /**
     * recupera Cest
     *
     * @param pCest_codigo return ModelCest
     */
    public ModelCest getCestController(int pCest_codigo) {
        return this.daoCest.getCestDAO(pCest_codigo);
    }

    /**
     * recupera uma lista deCest
     *
     * @param pCest_codigo return ArrayList
     */
    public ArrayList<ModelCest> getListaCestController() {
        return this.daoCest.getListaCestDAO();
    }

    /**
     * atualiza Cest
     *
     * @param pModelCest return boolean
     */
    public boolean atualizarCestController(ModelCest pModelCest) {
        return this.daoCest.atualizarCestDAO(pModelCest);
    }

    /**
     * exclui Cest
     *
     * @param pCest_codigo return boolean
     */
    public boolean excluirCestController(int pCest_codigo) {
        return this.daoCest.excluirCestDAO(pCest_codigo);
    }
}
