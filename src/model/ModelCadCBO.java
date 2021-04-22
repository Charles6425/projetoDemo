package model;
/**
*
* @author Charles Müller
*/
public class ModelCadCBO {

    private int id;
    private String cod_cbo;
    private String descricao;

    /**
    * Construtor
    */
    public ModelCadCBO(){}

    /**
    * seta o valor de id
    * @param pId
    */
    public void setId(int pId){
        this.id = pId;
    }
    /**
    * @return id
    */
    public int getId(){
        return this.id;
    }

    /**
    * seta o valor de cod_cbo
    * @param pCod_cbo
    */
    public void setCod_cbo(String pCod_cbo){
        this.cod_cbo = pCod_cbo;
    }
    /**
    * @return cod_cbo
    */
    public String getCod_cbo(){
        return this.cod_cbo;
    }

    /**
    * seta o valor de descricao
    * @param pDescricao
    */
    public void setDescricao(String pDescricao){
        this.descricao = pDescricao;
    }
    /**
    * @return descricao
    */
    public String getDescricao(){
        return this.descricao;
    }

    @Override
    public String toString(){
        return "ModelCadCBO {" + "::id = " + this.id + "::cod_cbo = " + this.cod_cbo + "::descricao = " + this.descricao +  "}";
    }
}