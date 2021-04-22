package model;
/**
*
* @author Charles Müller
*/
public class ModelVersoCertificado {

    private int id;
    private String descricao;
    private String qt_horas;
    private String texto;

    /**
    * Construtor
    */
    public ModelVersoCertificado(){}

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
    * seta o valor de qt_horas
    * @param pQt_horas
    */
    public void setQt_horas(String pQt_horas){
        this.qt_horas = pQt_horas;
    }
    /**
    * @return qt_horas
    */
    public String getQt_horas(){
        return this.qt_horas;
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
        return "ModelVersoCertificado {" + "::id = " + this.id + "::descricao = " + this.descricao + "::qt_horas = " + this.qt_horas + "::texto = " + this.texto +  "}";
    }
}