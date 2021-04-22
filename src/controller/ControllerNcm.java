package controller;

import model.ModelNcm;
import DAO.DAONcm;
import java.util.ArrayList;

/**
 *
 * @author Charles
 */
public class ControllerNcm {

    private DAONcm daoNcm = new DAONcm();

    /**
     * grava Ncm
     *
     * @param pModelNcm return int
     */
    public int salvarNcmController(ModelNcm pModelNcm) {
        return this.daoNcm.salvarNcmDAO(pModelNcm);
    }

    /**
     * recupera Ncm
     *
     * @param pNcm_codigo return ModelNcm
     */
    public ModelNcm getNcmController(int pNcm_codigo) {
        return this.daoNcm.getNcmDAO(pNcm_codigo);
    }
    /**
     * recupera Ncm
     *
     * @param pNcm_num return ModelNcm
     */
    public ModelNcm getNcmController(String pNcm_num) {
        return this.daoNcm.getNcmDAO(pNcm_num);
    }

    /**
     * recupera uma lista deNcm
     *
     * @param pNcm_codigo return ArrayList
     */
    public ArrayList<ModelNcm> getListaNcmController() {
        return this.daoNcm.getListaNcmDAO();
    }

    /**
     * atualiza Ncm
     *
     * @param pModelNcm return boolean
     */
    public boolean atualizarNcmController(ModelNcm pModelNcm) {
        return this.daoNcm.atualizarNcmDAO(pModelNcm);
    }

    /**
     * exclui Ncm
     *
     * @param pNcm_codigo return boolean
     */
    public boolean excluirNcmController(int pNcm_codigo) {
        return this.daoNcm.excluirNcmDAO(pNcm_codigo);
    }
}
