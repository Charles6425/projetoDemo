package model;
/**
*
* @author Charles Müller
*/
public class ModelCodigoAdms {

    private int id;
    private int cod_adms;
    private String descricao;

    /**
    * Construtor
    */
    public ModelCodigoAdms(){}

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
    * seta o valor de cod_adms
    * @param pCod_adms
    */
    public void setCod_adms(int pCod_adms){
        this.cod_adms = pCod_adms;
    }
    /**
    * @return cod_adms
    */
    public int getCod_adms(){
        return this.cod_adms;
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
        return "ModelCodigoAdms {" + "::id = " + this.id + "::cod_adms = " + this.cod_adms + "::descricao = " + this.descricao +  "}";
    }
}