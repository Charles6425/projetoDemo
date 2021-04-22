package model;

/**
 *
 * @author Charles
 */
public class ModelGrupoProduto {

    private int gru_codigo;
    private String gru_descricao;

    /**
     * Construtor
     */
    public ModelGrupoProduto() {
    }

    /**
     * seta o valor de gru_codigo
     *
     * @param pGru_codigo
     */
    public void setGru_codigo(int pGru_codigo) {
        this.gru_codigo = pGru_codigo;
    }

    /**
     * return gru_codigo
     */
    public int getGru_codigo() {
        return this.gru_codigo;
    }

    /**
     * seta o valor de gru_descricao
     *
     * @param pGru_descricao
     */
    public void setGru_descricao(String pGru_descricao) {
        this.gru_descricao = pGru_descricao;
    }

    /**
     * return gru_descricao
     */
    public String getGru_descricao() {
        return this.gru_descricao;
    }

    @Override
    public String toString() {
        return "ModelGrupoProduto {" + "::gru_codigo = " + this.gru_codigo + "::gru_descricao = " + this.gru_descricao + "}";
    }

    public int getGru_codigo(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
