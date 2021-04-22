package model;
/**
*
* @author Charles Müller
*/
public class ModelPeriodoCertifAspirante {

    private int id;
    private String descricao;
    private String periodo;
    private String data_conclusao;

    /**
    * Construtor
    */
    public ModelPeriodoCertifAspirante(){}

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
    * seta o valor de periodo
    * @param pPeriodo
    */
    public void setPeriodo(String pPeriodo){
        this.periodo = pPeriodo;
    }
    /**
    * @return periodo
    */
    public String getPeriodo(){
        return this.periodo;
    }

    /**
    * seta o valor de data_conclusao
    * @param pData_conclusao
    */
    public void setData_conclusao(String pData_conclusao){
        this.data_conclusao = pData_conclusao;
    }
    /**
    * @return data_conclusao
    */
    public String getData_conclusao(){
        return this.data_conclusao;
    }

    @Override
    public String toString(){
        return "ModelPeriodoCertifAspirante {" + "::id = " + this.id + "::descricao = " + this.descricao + "::periodo = " + this.periodo + "::data_conclusao = " + this.data_conclusao +  "}";
    }
}