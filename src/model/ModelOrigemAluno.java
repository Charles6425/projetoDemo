package model;
/**
*
* @author Charles Müller
*/
public class ModelOrigemAluno {

    private int id;
    private String orig_descricao;

    /**
    * Construtor
    */
    public ModelOrigemAluno(){}

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
    * seta o valor de orig_descricao
    * @param pOrig_descricao
    */
    public void setOrig_descricao(String pOrig_descricao){
        this.orig_descricao = pOrig_descricao;
    }
    /**
    * @return orig_descricao
    */
    public String getOrig_descricao(){
        return this.orig_descricao;
    }

    @Override
    public String toString(){
        return "ModelOrigemAluno {" + "::id = " + this.id + "::orig_descricao = " + this.orig_descricao +  "}";
    }
}