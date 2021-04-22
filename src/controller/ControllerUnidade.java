package controller;

import model.ModelUnidade;
import DAO.DAOUnidade;
import java.util.ArrayList;

/**
 *
 * @author Charles
 */
public class ControllerUnidade {

    private DAOUnidade daoUnidade = new DAOUnidade();

    /**
     * grava Unidade
     *
     * @param pModelUnidade return int
     */
    public int salvarUnidadeController(ModelUnidade pModelUnidade) {
        return this.daoUnidade.salvarUnidadeDAO(pModelUnidade);
    }

    /**
     * recupera Unidade
     *
     * @param pUn_codigo return ModelUnidade
     */
    public ModelUnidade getUnidadeController(int pUn_codigo) {
        return this.daoUnidade.getUnidadeDAO(pUn_codigo);
    }

    /**
     * recupera Unidade
     *
     * @param pUn_descricao return ModelUnidade
     */
    public ModelUnidade getUnidadeController(String pUn_descricao) {
        return this.daoUnidade.getUnidadeDAO(pUn_descricao);
    }

    /**
     * recupera uma lista deUnidade
     *
     * @param pUn_codigo return ArrayList
     */
    public ArrayList<ModelUnidade> getListaUnidadeController() {
        return this.daoUnidade.getListaUnidadeDAO();
    }

    /**
     * atualiza Unidade
     *
     * @param pModelUnidade return boolean
     */
    public boolean atualizarUnidadeController(ModelUnidade pModelUnidade) {
        return this.daoUnidade.atualizarUnidadeDAO(pModelUnidade);
    }

    /**
     * exclui Unidade
     *
     * @param pUn_codigo return boolean
     */
    public boolean excluirUnidadeController(int pUn_codigo) {
        return this.daoUnidade.excluirUnidadeDAO(pUn_codigo);
    }
}
