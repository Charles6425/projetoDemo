package DAO;

import conexoes.ConexaoMySql;
import model.ModelProdutos;
import java.util.ArrayList;

/**
 *
 * @author BLSoft www.Blsoft.com.br Venda de software e código fonte
 */
public class DAOProdutos extends ConexaoMySql {

    /**
     * grava Produtos
     *
     * @param pModelProdutos return int
     */
    public int salvarProdutosDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO produtos ("
                    + "fornecedores_codigo,"
                    + "nome,"
                    + "valor,"
                    + "codigo_barras,"
                    + "estoque,"
                    + "prod_ncm,"
                    + "prod_cest,"
                    + "prod_origem,"
                    + "prod_tributacao,"
                    + "prod_un,"
                    + "prod_grupo,"
                    + "prod_situacao,"
                    + "prod_nome_resumido,"
                    + "prod_ingrediente,"
                    + "utiliza_composicao,"
                    + "prod_anvisa,"
                    + "prod_custo,"
                    + "prod_estoque_minimo,"
                    + "fator_conversao,"
                    + "forca_de_vendas,"
                    + "fator_conversao_estoque,"
                    + "un_volume,"
                    + "nao_fraciona"
                    + ") VALUES ("
                    + "'" + pModelProdutos.getFornecedoresCodigo() + "',"
                    + "'" + pModelProdutos.getNome() + "',"
                    + "'" + pModelProdutos.getValor() + "',"
                    + "'" + pModelProdutos.getCodigo_barras() + "',"
                    + "'" + pModelProdutos.getEstoque() + "',"
                    + "'" + pModelProdutos.getProd_ncm() + "',"
                    + "'" + pModelProdutos.getProd_cest() + "',"
                    + "'" + pModelProdutos.getProd_origem() + "',"
                    + "'" + pModelProdutos.getProd_tributacao() + "',"
                    + "'" + pModelProdutos.getProd_un() + "',"
                    + "'" + pModelProdutos.getProd_grupo() + "',"
                    + "'" + pModelProdutos.getProd_situacao() + "',"
                    + "'" + pModelProdutos.getProd_nome_resumido() + "',"
                    + "'" + pModelProdutos.getProd_ingrediente() + "',"
                    + "'" + pModelProdutos.getUtiliza_composicao() + "',"
                    + "'" + pModelProdutos.getProd_anvisa() + "',"
                    + "'" + pModelProdutos.getProd_custo() + "',"
                    + "'" + pModelProdutos.getProd_estoque_minimo() + "',"
                    + "'" + pModelProdutos.getFator_conversao() + "',"
                    + "'" + pModelProdutos.getForca_de_vendas() + "',"
                    + "'" + pModelProdutos.getVolumeEstoque() + "',"
                    + "'" + pModelProdutos.getUn_volume()+ "',"
                    + "'" + pModelProdutos.getNao_fraciona()+ "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera Produtos
     *
     * @param pCodigo return ModelProdutos
     */
    public ModelProdutos getProdutosDAO(int pCodigo) {
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "fornecedores_codigo,"
                    + "nome,"
                    + "valor,"
                    + "codigo_barras,"
                    + "estoque,"
                    + "prod_ncm,"
                    + "prod_cest,"
                    + "prod_origem,"
                    + "prod_tributacao,"
                    + "prod_un,"
                    + "prod_grupo,"
                    + "prod_situacao,"
                    + "prod_nome_resumido,"
                    + "prod_ingrediente,"
                    + "utiliza_composicao,"
                    + "prod_anvisa,"
                    + "prod_custo,"
                    + "prod_estoque_minimo,"
                    + "fator_conversao,"
                    + "forca_de_vendas,"
                    + "fator_conversao_estoque, "
                    + "un_volume, "
                    + "nao_fraciona "
                    + " FROM"
                    + " produtos"
                    + " WHERE"
                    + " codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProdutos.setCODIGO(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setValor(this.getResultSet().getFloat(4));
                modelProdutos.setCodigo_barras(this.getResultSet().getString(5));
                modelProdutos.setEstoque(this.getResultSet().getFloat(6));
                modelProdutos.setProd_ncm(this.getResultSet().getInt(7));
                modelProdutos.setProd_cest(this.getResultSet().getInt(8));
                modelProdutos.setProd_origem(this.getResultSet().getInt(9));
                modelProdutos.setProd_tributacao(this.getResultSet().getInt(10));
                modelProdutos.setProd_un(this.getResultSet().getInt(11));
                modelProdutos.setProd_grupo(this.getResultSet().getInt(12));
                modelProdutos.setProd_situacao(this.getResultSet().getString(13));
                modelProdutos.setProd_nome_resumido(this.getResultSet().getString(14));
                modelProdutos.setProd_ingrediente(this.getResultSet().getInt(15));
                modelProdutos.setUtiliza_composicao(this.getResultSet().getInt(16));
                modelProdutos.setProd_anvisa(this.getResultSet().getInt(17));
                modelProdutos.setProd_custo(this.getResultSet().getFloat(18));
                modelProdutos.setProd_estoque_minimo(this.getResultSet().getFloat(19));
                modelProdutos.setFator_conversao(this.getResultSet().getInt(20));
                modelProdutos.setForca_de_vendas(this.getResultSet().getInt(21));
                modelProdutos.setVolumeEstoque(this.getResultSet().getFloat(22));
                modelProdutos.setUn_volume(this.getResultSet().getInt(23));
                modelProdutos.setNao_fraciona(this.getResultSet().getInt(24));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }

    /**
     * recupera Produtos
     *
     * @param pNome return ModelProdutos
     */
    public ModelProdutos getProdutosDAO(String pNome) {
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "fornecedores_codigo,"
                    + "nome,"
                    + "valor,"
                    + "codigo_barras,"
                    + "estoque,"
                    + "prod_nome_resumido,"
                    + "prod_ingrediente,"
                    + "utiliza_composicao,"
                    + "prod_anvisa,"
                    + "prod_custo,"
                    + "prod_estoque_minimo,"
                    + "fator_conversao,"
                    + "prod_un,"
                    + "forca_de_vendas,"
                    + "fator_conversao_estoque,"
                    + "un_volume,"
                    + "nao_fraciona"
                    + " FROM"
                    + " produtos"
                    + " WHERE"
                    + " nome = '" + pNome + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProdutos.setCODIGO(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setValor(this.getResultSet().getFloat(4));
                modelProdutos.setCodigo_barras(this.getResultSet().getString(5));
                modelProdutos.setEstoque(this.getResultSet().getFloat(6));
                modelProdutos.setProd_nome_resumido(this.getResultSet().getString(7));
                modelProdutos.setProd_ingrediente(this.getResultSet().getInt(8));
                modelProdutos.setUtiliza_composicao(this.getResultSet().getInt(9));
                modelProdutos.setProd_anvisa(this.getResultSet().getInt(10));
                modelProdutos.setProd_custo(this.getResultSet().getFloat(11));
                modelProdutos.setProd_estoque_minimo(this.getResultSet().getFloat(12));
                modelProdutos.setFator_conversao(this.getResultSet().getInt(13));
                modelProdutos.setProd_un(this.getResultSet().getInt(14));
                modelProdutos.setForca_de_vendas(this.getResultSet().getInt(15));
                modelProdutos.setVolumeEstoque(this.getResultSet().getFloat(16));
                modelProdutos.setUn_volume(this.getResultSet().getInt(17));
                modelProdutos.setNao_fraciona(this.getResultSet().getInt(18));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }

    /**
     * recupera uma lista de Produtos return ArrayList
     */
    public ArrayList<ModelProdutos> getListaProdutosDAO() {
        ArrayList<ModelProdutos> listamodelProdutos = new ArrayList();
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "p.codigo,"
                    + "p.fornecedores_codigo,"
                    + "p.nome,"
                    + "p.valor,"
                    + "p.codigo_barras,"
                    + "p.estoque,"
                    + "p.prod_nome_resumido,"
                    + "p.prod_ingrediente,"
                    + "p.utiliza_composicao,"
                    + "p.prod_anvisa,"
                    + "p.prod_custo,"
                    + "p.prod_estoque_minimo,"
                    + "g.gru_descricao, "
                    + "p.fator_conversao,"
                    + "p.forca_de_vendas,"
                    + "p.fator_conversao_estoque,"
                    + "p.un_volume,"
                    + "p.nao_fraciona"
                    + " FROM"
                    + " produtos p inner join cad_grupo_prod g on g.gru_codigo = p.prod_grupo"
                    + " Where prod_situacao = 'A'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProdutos = new ModelProdutos();
                modelProdutos.setCODIGO(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setValor(this.getResultSet().getFloat(4));
                modelProdutos.setCodigo_barras(this.getResultSet().getString(5));
                modelProdutos.setEstoque(this.getResultSet().getFloat(6));
                modelProdutos.setProd_nome_resumido(this.getResultSet().getString(7));
                modelProdutos.setProd_ingrediente(this.getResultSet().getInt(8));
                modelProdutos.setUtiliza_composicao(this.getResultSet().getInt(9));
                modelProdutos.setProd_anvisa(this.getResultSet().getInt(10));
                modelProdutos.setProd_custo(this.getResultSet().getFloat(11));
                modelProdutos.setProd_estoque_minimo(this.getResultSet().getFloat(12));
                modelProdutos.setGru_descricao(this.getResultSet().getString(13));
                modelProdutos.setFator_conversao(this.getResultSet().getInt(14));
                modelProdutos.setForca_de_vendas(this.getResultSet().getInt(15));
                modelProdutos.setVolumeEstoque(this.getResultSet().getFloat(16));
                modelProdutos.setUn_volume(this.getResultSet().getInt(17));
                modelProdutos.setNao_fraciona(this.getResultSet().getInt(18));
                listamodelProdutos.add(modelProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelProdutos;
    }

    /**
     * recupera uma lista de Ingredientes return ArrayList
     */
    public ArrayList<ModelProdutos> getListaIngredientesDAO() {
        ArrayList<ModelProdutos> listamodelProdutos = new ArrayList();
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "fornecedores_codigo,"
                    + "nome,"
                    + "valor,"
                    + "codigo_barras,"
                    + "estoque,"
                    + "prod_nome_resumido,"
                    + "prod_ingrediente,"
                    + "utiliza_composicao,"
                    + "prod_anvisa,"
                    + "prod_custo,"
                    + "prod_estoque_minimo,"
                    + "fator_conversao,"
                    + "forca_de_vendas,"
                    + "fator_conversao_estoque,"
                    + "un_volume,"
                    + "nao_fraciona"
                    + " FROM"
                    + " produtos "
                    + "Where prod_situacao = 'A' and  prod_ingrediente =1"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProdutos = new ModelProdutos();
                modelProdutos.setCODIGO(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setValor(this.getResultSet().getFloat(4));
                modelProdutos.setCodigo_barras(this.getResultSet().getString(5));
                modelProdutos.setEstoque(this.getResultSet().getFloat(6));
                modelProdutos.setProd_nome_resumido(this.getResultSet().getString(7));
                modelProdutos.setProd_ingrediente(this.getResultSet().getInt(8));
                modelProdutos.setProd_anvisa(this.getResultSet().getInt(9));
                modelProdutos.setProd_custo(this.getResultSet().getFloat(10));
                modelProdutos.setProd_estoque_minimo(this.getResultSet().getFloat(11));
                modelProdutos.setFator_conversao(this.getResultSet().getInt(12));
                modelProdutos.setForca_de_vendas(this.getResultSet().getInt(13));
                modelProdutos.setVolumeEstoque(this.getResultSet().getFloat(14));
                modelProdutos.setUn_volume(this.getResultSet().getInt(15));
                modelProdutos.setNao_fraciona(this.getResultSet().getInt(16));
                listamodelProdutos.add(modelProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelProdutos;
    }

    /**
     * recupera uma lista de Itens que utilizam a composição return ArrayList
     */
    public ArrayList<ModelProdutos> getListaProdutoCompostoDAO() {
        ArrayList<ModelProdutos> listamodelProdutos = new ArrayList();
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "fornecedores_codigo,"
                    + "nome,"
                    + "valor,"
                    + "codigo_barras,"
                    + "estoque,"
                    + "prod_nome_resumido,"
                    + "prod_ingrediente,"
                    + "utiliza_composicao,"
                    + "prod_anvisa,"
                    + "prod_custo,"
                    + "prod_estoque_minimo,"
                    + "fator_conversao,"
                    + "forca_de_vendas,"
                    + "fator_conversao_estoque,"
                    + "un_volume,"
                    + "nao_fraciona"
                    + " FROM"
                    + " produtos "
                    + "Where prod_situacao = 'A' and  utiliza_composicao =1"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProdutos = new ModelProdutos();
                modelProdutos.setCODIGO(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setValor(this.getResultSet().getFloat(4));
                modelProdutos.setCodigo_barras(this.getResultSet().getString(5));
                modelProdutos.setEstoque(this.getResultSet().getFloat(6));
                modelProdutos.setProd_nome_resumido(this.getResultSet().getString(7));
                modelProdutos.setProd_ingrediente(this.getResultSet().getInt(8));
                modelProdutos.setProd_anvisa(this.getResultSet().getInt(9));
                modelProdutos.setProd_custo(this.getResultSet().getFloat(10));
                modelProdutos.setProd_estoque_minimo(this.getResultSet().getFloat(11));
                modelProdutos.setFator_conversao(this.getResultSet().getInt(13));
                modelProdutos.setForca_de_vendas(this.getResultSet().getInt(14));
                modelProdutos.setVolumeEstoque(this.getResultSet().getFloat(15));
                modelProdutos.setUn_volume(this.getResultSet().getInt(16));
                modelProdutos.setNao_fraciona(this.getResultSet().getInt(17));
                listamodelProdutos.add(modelProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelProdutos;
    }

    /**
     * recupera uma lista de Produtos return ArrayList
     */
    public ArrayList<ModelProdutos> getListaProdutosTodosDAO() {
        ArrayList<ModelProdutos> listamodelProdutos = new ArrayList();
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "p.codigo,"
                    + "p.fornecedores_codigo,"
                    + "p.nome,"
                    + "p.valor,"
                    + "p.codigo_barras,"
                    + "p.estoque,"
                    + "p.prod_nome_resumido,"
                    + "p.prod_ingrediente,"
                    + "p.utiliza_composicao,"
                    + "p.prod_anvisa,"
                    + "p.prod_custo,"
                    + "p.prod_estoque_minimo,"
                    + "g.gru_descricao,"
                    + "p.fator_conversao,"
                    + "p.forca_de_vendas,"
                    + "p.fator_conversao_estoque,"
                    + "p.un_volume,"
                    + "p.nao_fraciona"
                    + " FROM"
                    + " produtos p inner join cad_grupo_prod g on g.gru_codigo = p.prod_grupo"
                    + " Where prod_situacao = 'A'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProdutos = new ModelProdutos();
                modelProdutos.setCODIGO(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setValor(this.getResultSet().getFloat(4));
                modelProdutos.setCodigo_barras(this.getResultSet().getString(5));
                modelProdutos.setEstoque(this.getResultSet().getFloat(6));
                modelProdutos.setProd_nome_resumido(this.getResultSet().getString(7));
                modelProdutos.setProd_ingrediente(this.getResultSet().getInt(8));
                modelProdutos.setUtiliza_composicao(this.getResultSet().getInt(9));
                modelProdutos.setProd_anvisa(this.getResultSet().getInt(10));
                modelProdutos.setProd_custo(this.getResultSet().getFloat(11));
                modelProdutos.setProd_estoque_minimo(this.getResultSet().getFloat(12));
                modelProdutos.setGru_descricao(this.getResultSet().getString(13));
                modelProdutos.setFator_conversao(this.getResultSet().getInt(14));
                modelProdutos.setForca_de_vendas(this.getResultSet().getInt(15));
                modelProdutos.setVolumeEstoque(this.getResultSet().getFloat(16));
                modelProdutos.setUn_volume(this.getResultSet().getInt(17));
                modelProdutos.setNao_fraciona(this.getResultSet().getInt(18));
                listamodelProdutos.add(modelProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelProdutos;
    }

    /**
     * atualiza Produtos
     *
     * @param pModelProdutos return boolean
     */
    public boolean atualizarProdutosDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE produtos SET "
                    // + "codigo = '" + pModelProdutos.getCodigo() + "',"
                    + "fornecedores_codigo = '" + pModelProdutos.getFornecedoresCodigo() + "',"
                    + "nome = '" + pModelProdutos.getNome() + "',"
                    + "valor = '" + pModelProdutos.getValor() + "',"
                    + "codigo_barras = '" + pModelProdutos.getCodigo_barras() + "',"
                    + "estoque = '" + pModelProdutos.getEstoque() + "',"
                    + "prod_grupo = '" + pModelProdutos.getProd_grupo() + "',"
                    + "prod_un = '" + pModelProdutos.getProd_un() + "',"
                    + "prod_ncm = '" + pModelProdutos.getProd_ncm() + "',"
                    + "prod_cest = '" + pModelProdutos.getProd_cest() + "',"
                    + "prod_origem = '" + pModelProdutos.getProd_origem() + "',"
                    + "prod_tributacao = '" + pModelProdutos.getProd_tributacao() + "',"
                    + "prod_situacao = '" + pModelProdutos.getProd_situacao() + "',"
                    + "prod_nome_resumido = '" + pModelProdutos.getProd_nome_resumido() + "',"
                    + "prod_ingrediente = '" + pModelProdutos.getProd_ingrediente() + "',"
                    + "utiliza_composicao = '" + pModelProdutos.getUtiliza_composicao() + "',"
                    + "prod_anvisa = '" + pModelProdutos.getProd_anvisa() + "',"
                    + "prod_custo= '" + pModelProdutos.getProd_custo() + "',"
                    + "prod_estoque_minimo = '" + pModelProdutos.getProd_estoque_minimo() + "',"
                    + "fator_conversao = '" + pModelProdutos.getFator_conversao() + "',"
                    + "forca_de_vendas = '" + pModelProdutos.getForca_de_vendas() + "',"
                    + "fator_conversao_estoque = '" + pModelProdutos.getVolumeEstoque() + "',"
                    + "un_volume = '" + pModelProdutos.getUn_volume()+ "',"
                    + "nao_fraciona = '" + pModelProdutos.getNao_fraciona()+ "'"
                    + " WHERE "
                    + "codigo = '" + pModelProdutos.getCODIGO() + "'"
                    + ";"
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui Produtos
     *
     * @param pCodigo return boolean
     */
    public boolean excluirProdutosDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM produtos "
                    + " WHERE "
                    + "codigo = '" + pCodigo + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * atualiza Produtos
     *
     * @param pModelProdutos return boolean
     */
    public boolean atualizarProdutosQuantidadeDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            int sizeLista = pModelProdutos.getListaModelProdutoses().size();
            for (int i = 0; i < sizeLista; i++) {
                this.executarUpdateDeleteSQL(
                        "UPDATE produtos SET "
                        + "estoque = '" + pModelProdutos.getListaModelProdutoses().get(i).getEstoque() + "',"
                        + "fator_conversao_estoque = '" + pModelProdutos.getListaModelProdutoses().get(i).getVolumeEstoque()+ "'"
                        + " WHERE "
                        + "codigo = '" + pModelProdutos.getListaModelProdutoses().get(i).getCODIGO() + "'"
                        + ";"
                );
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * atualiza Produtos
     *
     * @param pModelProdutos return boolean
     */
    public boolean atualizarProdutosQuantidadeUmDAO(int pCodigo, int pItem, float pQuantidade) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE produtos SET "
                    + "estoque = '" + pQuantidade + "'"
                    + " WHERE "
                    + "codigo = '" + pCodigo + "'"
                    + ";"
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * zerar estoque
     *
     * @param pModelProdutos return boolean
     */
    public boolean zerarEstoqueDAO() {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE produtos SET "
                    + "estoque = 0,"
                    + " fator_conversao_estoque = 0"
                    + ";"
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public ModelProdutos getProdutosCodigoBarrasDAO(String pCodigoBarras) {
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "fornecedores_codigo,"
                    + "nome,"
                    + "valor,"
                    + "codigo_barras,"
                    + "estoque,"
                    + "prod_ncm,"
                    + "prod_cest,"
                    + "prod_origem,"
                    + "prod_tributacao,"
                    + "prod_un,"
                    + "prod_grupo,"
                    + "prod_situacao,"
                    + "prod_nome_resumido,"
                    + "prod_ingrediente,"
                    + "utiliza_composicao,"
                    + "fator_conversao,"
                    + "forca_de_vendas,"
                    + "fator_conversao_estoque,"
                    + "un_volume,"
                    + "nao_fraciona"
                    + " FROM"
                    + " produtos"
                    + " WHERE"
                    + " codigo_barras = '" + pCodigoBarras + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProdutos.setCODIGO(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setValor(this.getResultSet().getFloat(4));
                modelProdutos.setCodigo_barras(this.getResultSet().getString(5));
                modelProdutos.setEstoque(this.getResultSet().getFloat(6));
                modelProdutos.setProd_ncm(this.getResultSet().getInt(7));
                modelProdutos.setProd_cest(this.getResultSet().getInt(8));
                modelProdutos.setProd_origem(this.getResultSet().getInt(9));
                modelProdutos.setProd_tributacao(this.getResultSet().getInt(10));
                modelProdutos.setProd_un(this.getResultSet().getInt(11));
                modelProdutos.setProd_grupo(this.getResultSet().getInt(12));
                modelProdutos.setProd_situacao(this.getResultSet().getString(13));
                modelProdutos.setProd_nome_resumido(this.getResultSet().getString(14));
                modelProdutos.setProd_ingrediente(this.getResultSet().getInt(15));
                modelProdutos.setUtiliza_composicao(this.getResultSet().getInt(16));
                modelProdutos.setFator_conversao(this.getResultSet().getInt(17));
                modelProdutos.setForca_de_vendas(this.getResultSet().getInt(18));
                modelProdutos.setVolumeEstoque(this.getResultSet().getFloat(19));
                modelProdutos.setUn_volume(this.getResultSet().getInt(20));
                modelProdutos.setNao_fraciona(this.getResultSet().getInt(21));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }
}
