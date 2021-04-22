package model;
/**
*
* @author Charles Müller
*/
public class ModelAprendizagemTeorica {

    private int id;
    private String descricao;
    private String texto;

    /**
    * Construtor
    */
    public ModelAprendizagemTeorica(){}

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

    /**
    * seta o valor de texto
    * @param pTexto
    */
    public void setTexto(String pTexto){
        this.texto = pTexto;
    }
    /**
    * @return texto
    */
    public String getTexto(){
        return this.texto;
    }

    @Override
    public String toString(){
        return "ModelAprendizagemTeorica {" + "::id = " + this.id + "::descricao = " + this.descricao + "::texto = " + this.texto +  "}";
    }
}