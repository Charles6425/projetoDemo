package model;

/**
 *
 * @author Charles
 */
public class ModelTributacao {

    private int trib_codigo;
    private String trib_descricao;
    private int trib_cfop;
    private int trib_cst_fis;
    private int trib_pis_fis;
    private int trib_cofins_fis;
    private int trib_ipi;
    private int trib_uf_origem;
    private int trib_uf_dest;

    /**
     * Construtor
     */
    public ModelTributacao() {
    }

    /**
     * seta o valor de trib_codigo
     *
     * @param pTrib_codigo
     */
    public void setTrib_codigo(int pTrib_codigo) {
        this.trib_codigo = pTrib_codigo;
    }

    /**
     * return trib_codigo
     */
    public int getTrib_codigo() {
        return this.trib_codigo;
    }

    /**
     * seta o valor de trib_descricao
     *
     * @param pTrib_descricao
     */
    public void setTrib_descricao(String pTrib_descricao) {
        this.trib_descricao = pTrib_descricao;
    }

    /**
     * return trib_descricao
     */
    public String getTrib_descricao() {
        return this.trib_descricao;
    }

    /**
     * seta o valor de trib_cfop
     *
     * @param pTrib_cfop
     */
    public void setTrib_cfop(int pTrib_cfop) {
        this.trib_cfop = pTrib_cfop;
    }

    /**
     * return trib_cfop
     */
    public int getTrib_cfop() {
        return this.trib_cfop;
    }

    /**
     * seta o valor de trib_cst_fis
     *
     * @param pTrib_cst_fis
     */
    public void setTrib_cst_fis(int pTrib_cst_fis) {
        this.trib_cst_fis = pTrib_cst_fis;
    }

    /**
     * return trib_cst_fis
     */
    public int getTrib_cst_fis() {
        return this.trib_cst_fis;
    }

    /**
     * seta o valor de trib_pis_fis
     *
     * @param pTrib_pis_fis
     */
    public void setTrib_pis_fis(int pTrib_pis_fis) {
        this.trib_pis_fis = pTrib_pis_fis;
    }

    /**
     * return trib_pis_fis
     */
    public int getTrib_pis_fis() {
        return this.trib_pis_fis;
    }

    /**
     * seta o valor de trib_cofins_fis
     *
     * @param pTrib_cofins_fis
     */
    public void setTrib_cofins_fis(int pTrib_cofins_fis) {
        this.trib_cofins_fis = pTrib_cofins_fis;
    }

    /**
     * return trib_cofins_fis
     */
    public int getTrib_cofins_fis() {
        return this.trib_cofins_fis;
    }

    /**
     * seta o valor de trib_ipi
     *
     * @param pTrib_ipi
     */
    public void setTrib_ipi(int pTrib_ipi) {
        this.trib_ipi = pTrib_ipi;
    }

    /**
     * return trib_ipi
     */
    public int getTrib_ipi() {
        return this.trib_ipi;
    }

    /**
     * seta o valor de trib_uf_origem
     *
     * @param pTrib_uf_origem
     */
    public void setTrib_uf_origem(int pTrib_uf_origem) {
        this.trib_uf_origem = pTrib_uf_origem;
    }

    /**
     * return trib_uf_origem
     */
    public int getTrib_uf_origem() {
        return this.trib_uf_origem;
    }

    /**
     * seta o valor de trib_uf_dest
     *
     * @param pTrib_uf_dest
     */
    public void setTrib_uf_dest(int pTrib_uf_dest) {
        this.trib_uf_dest = pTrib_uf_dest;
    }

    /**
     * return trib_uf_dest
     */
    public int getTrib_uf_dest() {
        return this.trib_uf_dest;
    }

    @Override
    public String toString() {
        return "ModelTributacao {" + "::trib_codigo = " + this.trib_codigo + "::trib_descricao = " + this.trib_descricao + "::trib_cfop = " + this.trib_cfop + "::trib_cst_fis = " + this.trib_cst_fis + "::trib_pis_fis = " + this.trib_pis_fis + "::trib_cofins_fis = " + this.trib_cofins_fis + "::trib_ipi = " + this.trib_ipi + "::trib_uf_origem = " + this.trib_uf_origem + "::trib_uf_dest = " + this.trib_uf_dest + "}";
    }
}
