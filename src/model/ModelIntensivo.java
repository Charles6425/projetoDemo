package model;
/**
*
* @author Charles Müller
*/
public class ModelIntensivo {

    private int id;
    private String descricao;

    /**
    * Construtor
    */
    public ModelIntensivo(){}

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
        return "ModelIntensivo {" + "::id = " + this.id + "::descricao = " + this.descricao +  "}";
    }
}