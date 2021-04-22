package model;
/**
*
* @author Charles Müller
*/
public class ModelCargo {

    private int id;
    private String Descricao;

    /**
    * Construtor
    */
    public ModelCargo(){}

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
    * seta o valor de Descricao
    * @param pDescricao
    */
    public void setDescricao(String pDescricao){
        this.Descricao = pDescricao;
    }
    /**
    * @return Descricao
    */
    public String getDescricao(){
        return this.Descricao;
    }

    @Override
    public String toString(){
        return "ModelCargo {" + "::id = " + this.id + "::Descricao = " + this.Descricao +  "}";
    }
}