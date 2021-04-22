package controller;

import model.ModelGrupoProduto;
import DAO.DAOGrupoProduto;
import java.util.ArrayList;

/**
 *
 * @author Charles
 */
public class ControllerGrupoProduto {

    private DAOGrupoProduto daoGrupoProduto = new DAOGrupoProduto();

    /**
     * grava GrupoProduto
     *
     * @param pModelGrupoProduto return int
     */
    public int salvarGrupoProdutoController(ModelGrupoProduto pModelGrupoProduto) {
        return this.daoGrupoProduto.salvarGrupoProdutoDAO(pModelGrupoProduto);
    }

    /**
     * recupera GrupoProduto
     *
     * @param pGru_codigo return ModelGrupoProduto
     */
    public ModelGrupoProduto getGrupoProdutoController(int pGru_codigo) {
        return this.daoGrupoProduto.getGrupoProdutoDAO(pGru_codigo);
    }

    /**
     * recupera GrupoProduto
     *
     * @param pGru_nome return ModelGrupoProduto
     */
    public ModelGrupoProduto getGrupoProdutoController(String pGru_nome) {
        return this.daoGrupoProduto.getGrupoProdutoDAO(pGru_nome);
    }

    /**
     * recupera uma lista deGrupoProduto
     *
     * @param pGru_codigo return ArrayList
     */
    public ArrayList<ModelGrupoProduto> getListaGrupoProdutoController() {
        return this.daoGrupoProduto.getListaGrupoProdutoDAO();
    }

    /**
     * atualiza GrupoProduto
     *
     * @param pModelGrupoProduto return boolean
     */
    public boolean atualizarGrupoProdutoController(ModelGrupoProduto pModelGrupoProduto) {
        return this.daoGrupoProduto.atualizarGrupoProdutoDAO(pModelGrupoProduto);
    }

    /**
     * exclui GrupoProduto
     *
     * @param pGru_codigo return boolean
     */
    public boolean excluirGrupoProdutoController(int pGru_codigo) {
        return this.daoGrupoProduto.excluirGrupoProdutoDAO(pGru_codigo);
    }

    public Iterable<ModelGrupoProduto> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
