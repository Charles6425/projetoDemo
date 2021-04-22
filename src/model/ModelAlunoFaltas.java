package model;
/**
*
* @author Charles Müller
*/
public class ModelAlunoFaltas {

    private int id;
    private String data;
    private String motivo;

    /**
    * Construtor
    */
    public ModelAlunoFaltas(){}

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

    @Override
    public String toString(){
        return "ModelAlunoFaltas {" + "::id = " + this.id + "::data = " + this.data + "::motivo = " + this.motivo +  "}";
    }
}