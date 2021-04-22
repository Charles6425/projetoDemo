package controller;

import model.ModelProdutos;
import DAO.DAOProdutos;
import java.sql.Date;
import java.util.ArrayList;
import relatorios.DAORelatorios;

/**
 * @author BLSoft www.Blsoft.com.br Venda de software e código fonte
 */
public class ControllerProdutos {

    private DAOProdutos daoProdutos = new DAOProdutos();
    private DAORelatorios dAORelatorios = new DAORelatorios();

    /**
     * grava Produtos
     *
     * @param pModelProdutos return int
     */
    public int salvarProdutosController(ModelProdutos pModelProdutos) {
        return this.daoProdutos.salvarProdutosDAO(pModelProdutos);
    }

    /**
     * recupera Produtos
     *
     * @param pCodigo return ModelProdutos
     */
    public ModelProdutos getProdutosController(int pCodigo) {
        return this.daoProdutos.getProdutosDAO(pCodigo);
    }

    /**
     * recupera Produtos
     *
     * @param pNome return ModelProdutos
     */
    public ModelProdutos getProdutosController(String pNome) {
        return this.daoProdutos.getProdutosDAO(pNome);
    }

    /**
     * recupera uma lista deProdutos
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<ModelProdutos> getListaProdutosController() {
        return this.daoProdutos.getListaProdutosDAO();
    }

    /**
     * recupera uma lista deProdutos
     */
    public ArrayList<ModelProdutos> ListaProdutoComposto() {
        return this.daoProdutos.getListaProdutoCompostoDAO();
    }

    /**
     * recupera uma lista deProdutos
     */
    public ArrayList<ModelProdutos> getListaIngrediente() {
        return this.daoProdutos.getListaIngredientesDAO();
    }

    /**
     * recupera uma lista deProdutos inativo e ativo
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<ModelProdutos> getListaProdutosTodosController() {
        return this.daoProdutos.getListaProdutosTodosDAO();

    }

    /**
     * atualiza Produtos
     *
     * @param pModelProdutos return boolean
     */
    public boolean atualizarProdutosController(ModelProdutos pModelProdutos) {
        return this.daoProdutos.atualizarProdutosDAO(pModelProdutos);
    }

    /**
     * zera estoque
     *
     * @param pModelProdutos return boolean
     */
    public boolean zeraEstoqueController() {
        return this.daoProdutos.zerarEstoqueDAO();
    }

    /**
     * exclui Produtos
     *
     * @param pCodigo return boolean
     */
    public boolean excluirProdutosController(int pCodigo) {
        return this.daoProdutos.excluirProdutosDAO(pCodigo);
    }

    /**
     * atualiza Produtos
     *
     * @param pModelProdutos return boolean
     */
    public boolean atualizarProdutosQuantidadeController(ModelProdutos pModelProdutos) {
        return this.daoProdutos.atualizarProdutosQuantidadeDAO(pModelProdutos);
    }

    /**
     * atualiza Produtos
     *
     * @param pModelProdutos return boolean
     */
    public boolean atualizarProdutosQuantidadeUmController(int pcodigo, int pitem, float pQuantidade) {
        return this.daoProdutos.atualizarProdutosQuantidadeUmDAO(pcodigo, pitem, pQuantidade);
    }

    public boolean gerarRelatorioProdutos() {
        return this.dAORelatorios.gerarRelatorioProdutos();
    }

    public boolean gerarRelatorioProdutosGrupo(int pGrupo) {
        return this.dAORelatorios.gerarRelatorioProdutosGrupo(pGrupo);

    }

    public boolean gerarRelatorioProdutosCodBarras(String plista, int pQuantidade) {
        return this.dAORelatorios.gerarRelatorioProdutosCodBarras(plista, pQuantidade);
    }

    public boolean gerarRelatorioProdutosMaisVendidos(Date pDataIni, Date pDataFim) {
        return this.dAORelatorios.gerarRelatorioProdutosMaisVendidos(pDataIni, pDataFim);
    }

    public boolean gerarRelatorioOP(int pID) {
        return this.dAORelatorios.gerarRelatorioOP(pID);
    }

    public boolean gerarRelatorioRomaneioEntrega(int pVendaCodigo) {
        return this.dAORelatorios.gerarRelatorioRomaneioEntrega(pVendaCodigo);
    }

    public boolean gerarRelatorioEstoqueMinimo() {
        return this.dAORelatorios.gerarRelatorioEstoqueMinimo();
    }

    public boolean gerarRelatorioEstoqueMinimoGrupo(int pGrupo) {
        return this.dAORelatorios.gerarRelatorioEstoqueMinimoGrupo(pGrupo);
    }

    public boolean gerarRelatorioMovitoEstoqueData(Date pDataIni, Date pDataFim) {
        return this.dAORelatorios.gerarRelatorioMovitoEstoqueData(pDataIni, pDataFim);
    }
    public boolean gerarRelatorioMovitoEstoqueDataGrupo(Date pDataIni, Date pDataFim, String pGrupo) {
        return this.dAORelatorios.gerarRelatorioMovitoEstoqueDataGrupo(pDataIni, pDataFim, pGrupo);
    }
    public boolean gerarRelatorioMovitoEstoqueDataPoduto(Date pDataIni, Date pDataFim, int pProduto) {
        return this.dAORelatorios.gerarRelatorioMovitoEstoqueDataPoduto(pDataIni, pDataFim, pProduto);
    }

    /**
     * recupera uma lista deProdutos
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<ModelProdutos> getListaRelatorioProdutosCodBarras() {
        return this.dAORelatorios.getListaCodigoBarrasDAO();
    }

    public ModelProdutos getProdutosCodigoBarrasController(String pCodigoBarras) {
        return this.daoProdutos.getProdutosCodigoBarrasDAO(pCodigoBarras);
    }

}
