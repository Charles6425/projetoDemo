package model;

/**
 *
 * @author Charles
 */
public class ModelNcm {

    private int ncm_codigo;
    private String ncm_num;
    private String ncm_descricao;

    /**
     * Construtor
     */
    public ModelNcm() {
    }

    /**
     * seta o valor de ncm_codigo
     *
     * @param pNcm_codigo
     */
    public void setNcm_codigo(int pNcm_codigo) {
        this.ncm_codigo = pNcm_codigo;
    }

    /**
     * return ncm_codigo
     */
    public int getNcm_codigo() {
        return this.ncm_codigo;
    }

    /**
     * seta o valor de ncm_num
     *
     * @param pNcm_num
     */
    public void setNcm_num(String pNcm_num) {
        this.ncm_num = pNcm_num;
    }

    /**
     * return ncm_num
     */
    public String getNcm_num() {
        return this.ncm_num;
    }

    /**
     * seta o valor de ncm_descricao
     *
     * @param pNcm_descricao
     */
    public void setNcm_descricao(String pNcm_descricao) {
        this.ncm_descricao = pNcm_descricao;
    }

    /**
     * return ncm_descricao
     */
    public String getNcm_descricao() {
        return this.ncm_descricao;
    }

    @Override
    public String toString() {
        return "ModelNcm {" + "::ncm_codigo = " + this.ncm_codigo + "::ncm_num = " + this.ncm_num + "::ncm_descricao = " + this.ncm_descricao + "}";
    }
}
