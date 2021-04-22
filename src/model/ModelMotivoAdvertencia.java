package model;
/**
*
* @author Charles Müller
*/
public class ModelMotivoAdvertencia {

    private int id;
    private int id_aluno;
    private String motivo;
    private String data;

    /**
    * Construtor
    */
    public ModelMotivoAdvertencia(){}

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
    * seta o valor de id_aluno
    * @param pId_aluno
    */
    public void setId_aluno(int pId_aluno){
        this.id_aluno = pId_aluno;
    }
    /**
    * @return id_aluno
    */
    public int getId_aluno(){
        return this.id_aluno;
    }

    /**
    * seta o valor de motivo
    * @param pMotivo
    */
    public void setMotivo(String pMotivo){
        this.motivo = pMotivo;
    }
    /**
    * @return motivo
    */
    public String getMotivo(){
        return this.motivo;
    }

    /**
    * seta o valor de data
    * @param pData
    */
    public void setData(String pData){
        this.data = pData;
    }
    /**
    * @return data
    */
    public String getData(){
        return this.data;
    }

    @Override
    public String toString(){
        return "ModelMotivoAdvertencia {" + "::id = " + this.id + "::id_aluno = " + this.id_aluno + "::motivo = " + this.motivo + "::data = " + this.data +  "}";
    }
}