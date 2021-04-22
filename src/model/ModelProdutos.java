package model;

import java.util.ArrayList;

public class ModelProdutos {

    private int CODIGO;
    private int fornecedoresCodigo;
    private String nome;
    private float valor;
    private float estoque;
    private String codigo_barras;
    private int prod_ncm;
    private int prod_cest;
    private int prod_origem;
    private int prod_tributacao;
    private int prod_grupo;
    private int prod_un;
    private int item;
    private String un_descricao;
    private int ncm_num;
    private int cest_numero;
    private int origem;
    private int cfop;
    private int cst;
    private int pis;
    private int cofins;
    private int ipi;
    private String prod_situacao;
    private String gru_descricao;
    private String prod_nome_resumido;
    private ArrayList<ModelProdutos> listaModelProdutoses;
    private int prod_ingrediente;
    private int utiliza_composicao;
    private int prod_anvisa;
    private float fator_conversao;
    private float volumeEstoque;
    private float prod_custo;
    private float prod_estoque_minimo;
    private int forca_de_vendas;
    private int un_volume;
    private int nao_fraciona;

    public int getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(int CODIGO) {
        this.CODIGO = CODIGO;
    }

    public int getFornecedoresCodigo() {
        return fornecedoresCodigo;
    }

    public void setFornecedoresCodigo(int fornecedoresCodigo) {
        this.fornecedoresCodigo = fornecedoresCodigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getEstoque() {
        return estoque;
    }

    public void setEstoque(float estoque) {
        this.estoque = estoque;
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public int getProd_ncm() {
        return prod_ncm;
    }

    public void setProd_ncm(int prod_ncm) {
        this.prod_ncm = prod_ncm;
    }

    public int getProd_cest() {
        return prod_cest;
    }

    public void setProd_cest(int prod_cest) {
        this.prod_cest = prod_cest;
    }

    public int getProd_origem() {
        return prod_origem;
    }

    public void setProd_origem(int prod_origem) {
        this.prod_origem = prod_origem;
    }

    public int getProd_tributacao() {
        return prod_tributacao;
    }

    public void setProd_tributacao(int prod_tributacao) {
        this.prod_tributacao = prod_tributacao;
    }

    public int getProd_grupo() {
        return prod_grupo;
    }

    public void setProd_grupo(int prod_grupo) {
        this.prod_grupo = prod_grupo;
    }

    public int getProd_un() {
        return prod_un;
    }

    public void setProd_un(int prod_un) {
        this.prod_un = prod_un;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getUn_descricao() {
        return un_descricao;
    }

    public void setUn_descricao(String un_descricao) {
        this.un_descricao = un_descricao;
    }

    public int getNcm_num() {
        return ncm_num;
    }

    public void setNcm_num(int ncm_num) {
        this.ncm_num = ncm_num;
    }

    public int getCest_numero() {
        return cest_numero;
    }

    public void setCest_numero(int cest_numero) {
        this.cest_numero = cest_numero;
    }

    public int getOrigem() {
        return origem;
    }

    public void setOrigem(int origem) {
        this.origem = origem;
    }

    public int getCfop() {
        return cfop;
    }

    public void setCfop(int cfop) {
        this.cfop = cfop;
    }

    public int getCst() {
        return cst;
    }

    public void setCst(int cst) {
        this.cst = cst;
    }

    public int getPis() {
        return pis;
    }

    public void setPis(int pis) {
        this.pis = pis;
    }

    public int getCofins() {
        return cofins;
    }

    public void setCofins(int cofins) {
        this.cofins = cofins;
    }

    public int getIpi() {
        return ipi;
    }

    public void setIpi(int ipi) {
        this.ipi = ipi;
    }

    public String getProd_situacao() {
        return prod_situacao;
    }

    public void setProd_situacao(String prod_situacao) {
        this.prod_situacao = prod_situacao;
    }

    public String getGru_descricao() {
        return gru_descricao;
    }

    public void setGru_descricao(String gru_descricao) {
        this.gru_descricao = gru_descricao;
    }

    public String getProd_nome_resumido() {
        return prod_nome_resumido;
    }

    public void setProd_nome_resumido(String prod_nome_resumido) {
        this.prod_nome_resumido = prod_nome_resumido;
    }

    public ArrayList<ModelProdutos> getListaModelProdutoses() {
        return listaModelProdutoses;
    }

    public void setListaModelProdutoses(ArrayList<ModelProdutos> listaModelProdutoses) {
        this.listaModelProdutoses = listaModelProdutoses;
    }

    public int getProd_ingrediente() {
        return prod_ingrediente;
    }

    public void setProd_ingrediente(int prod_ingrediente) {
        this.prod_ingrediente = prod_ingrediente;
    }

    public int getUtiliza_composicao() {
        return utiliza_composicao;
    }

    public void setUtiliza_composicao(int utiliza_composicao) {
        this.utiliza_composicao = utiliza_composicao;
    }

    public int getProd_anvisa() {
        return prod_anvisa;
    }

    public void setProd_anvisa(int prod_anvisa) {
        this.prod_anvisa = prod_anvisa;
    }

    public float getFator_conversao() {
        return fator_conversao;
    }

    public void setFator_conversao(float fator_conversao) {
        this.fator_conversao = fator_conversao;
    }

    public float getProd_custo() {
        return prod_custo;
    }

    public void setProd_custo(float prod_custo) {
        this.prod_custo = prod_custo;
    }

    public float getProd_estoque_minimo() {
        return prod_estoque_minimo;
    }

    public void setProd_estoque_minimo(float prod_estoque_minimo) {
        this.prod_estoque_minimo = prod_estoque_minimo;
    }

    public int getForca_de_vendas() {
        return forca_de_vendas;
    }

    public void setForca_de_vendas(int forca_de_vendas) {
        this.forca_de_vendas = forca_de_vendas;
    }

    public float getVolumeEstoque() {
        return volumeEstoque;
    }

    public void setVolumeEstoque(float fator_conversao_estoque) {
        this.volumeEstoque = fator_conversao_estoque;
    }

    public int getUn_volume() {
        return un_volume;
    }

    public void setUn_volume(int un_volume) {
        this.un_volume = un_volume;
    }

    public int getNao_fraciona() {
        return nao_fraciona;
    }

    public void setNao_fraciona(int nao_fraciona) {
        this.nao_fraciona = nao_fraciona;
    }

    @Override
    public String toString() {
        return "ModelProdutos{" + "CODIGO=" + CODIGO + ", fornecedoresCodigo=" + fornecedoresCodigo + ", nome=" + nome + ", valor=" + valor + ", estoque=" + estoque + ", codigo_barras=" + codigo_barras + ", prod_ncm=" + prod_ncm + ", prod_cest=" + prod_cest + ", prod_origem=" + prod_origem + ", prod_tributacao=" + prod_tributacao + ", prod_grupo=" + prod_grupo + ", prod_un=" + prod_un + ", item=" + item + ", un_descricao=" + un_descricao + ", ncm_num=" + ncm_num + ", cest_numero=" + cest_numero + ", origem=" + origem + ", cfop=" + cfop + ", cst=" + cst + ", pis=" + pis + ", cofins=" + cofins + ", ipi=" + ipi + ", prod_situacao=" + prod_situacao + ", gru_descricao=" + gru_descricao + ", prod_nome_resumido=" + prod_nome_resumido + ", listaModelProdutoses=" + listaModelProdutoses + ", prod_ingrediente=" + prod_ingrediente + ", utiliza_composicao=" + utiliza_composicao + ", prod_anvisa=" + prod_anvisa + ", fator_conversao=" + fator_conversao + ", volumeEstoque=" + volumeEstoque + ", prod_custo=" + prod_custo + ", prod_estoque_minimo=" + prod_estoque_minimo + ", forca_de_vendas=" + forca_de_vendas + ", un_volume=" + un_volume + ", nao_fraciona=" + nao_fraciona + '}';
    }

}
