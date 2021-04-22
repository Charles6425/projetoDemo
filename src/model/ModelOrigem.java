package model;

/**
 *
 * @author Charles
 */
public class ModelOrigem {

    private int orig_codigo;
    private String orig_descricao;

    /**
     * Construtor
     */
    public ModelOrigem() {
    }

    /**
     * seta o valor de orig_codigo
     *
     * @param pOrig_codigo
     */
    public void setOrig_codigo(int pOrig_codigo) {
        this.orig_codigo = pOrig_codigo;
    }

    /**
     * return orig_codigo
     */
    public int getOrig_codigo() {
        return this.orig_codigo;
    }

    /**
     * seta o valor de orig_descricao
     *
     * @param pOrig_descricao
     */
    public void setOrig_descricao(String pOrig_descricao) {
        this.orig_descricao = pOrig_descricao;
    }

    /**
     * return orig_descricao
     */
    public String getOrig_descricao() {
        return this.orig_descricao;
    }

    @Override
    public String toString() {
        return "ModelOrigem {" + "::orig_codigo = " + this.orig_codigo + "::orig_descricao = " + this.orig_descricao + "}";
    }
}
