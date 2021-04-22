package model;

/**
 *
 * @author Charles
 */
public class ModelUnidade {

    private int un_codigo;
    private String un_descricao;

    /**
     * Construtor
     */
    public ModelUnidade() {
    }

    /**
     * seta o valor de un_codigo
     *
     * @param pUn_codigo
     */
    public void setUn_codigo(int pUn_codigo) {
        this.un_codigo = pUn_codigo;
    }

    /**
     * return un_codigo
     */
    public int getUn_codigo() {
        return this.un_codigo;
    }

    /**
     * seta o valor de un_descricao
     *
     * @param pUn_descricao
     */
    public void setUn_descricao(String pUn_descricao) {
        this.un_descricao = pUn_descricao;
    }

    /**
     * return un_descricao
     */
    public String getUn_descricao() {
        return this.un_descricao;
    }

    @Override
    public String toString() {
        return "ModelUnidade {" + "::un_codigo = " + this.un_codigo + "::un_descricao = " + this.un_descricao + "}";
    }
}
