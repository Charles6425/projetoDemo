package model;

/**
 *
 * @author Charles
 */
public class ModelCest {

    private int cest_codigo;
    private int cest_numero;
    private String cest_descricao;

    /**
     * Construtor
     */
    public ModelCest() {
    }

    /**
     * seta o valor de cest_codigo
     *
     * @param pCest_codigo
     */
    public void setCest_codigo(int pCest_codigo) {
        this.cest_codigo = pCest_codigo;
    }

    /**
     * return cest_codigo
     */
    public int getCest_codigo() {
        return this.cest_codigo;
    }

    /**
     * seta o valor de cest_numero
     *
     * @param pCest_numero
     */
    public void setCest_numero(int pCest_numero) {
        this.cest_numero = pCest_numero;
    }

    /**
     * return cest_numero
     */
    public int getCest_numero() {
        return this.cest_numero;
    }

    /**
     * seta o valor de cest_descricao
     *
     * @param pCest_descricao
     */
    public void setCest_descricao(String pCest_descricao) {
        this.cest_descricao = pCest_descricao;
    }

    /**
     * return cest_descricao
     */
    public String getCest_descricao() {
        return this.cest_descricao;
    }

    @Override
    public String toString() {
        return "ModelCest {" + "::cest_codigo = " + this.cest_codigo + "::cest_numero = " + this.cest_numero + "::cest_descricao = " + this.cest_descricao + "}";
    }
}
