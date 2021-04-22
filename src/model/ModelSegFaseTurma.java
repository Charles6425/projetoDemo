package model;
/**
*
* @author Charles Müller
*/
public class ModelSegFaseTurma {

    private int id;
    private String campo1;
    private String horario_2f;
    private String dia_2f;

    /**
    * Construtor
    */
    public ModelSegFaseTurma(){}

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
    * seta o valor de campo1
    * @param pCampo1
    */
    public void setCampo1(String pCampo1){
        this.campo1 = pCampo1;
    }
    /**
    * @return campo1
    */
    public String getCampo1(){
        return this.campo1;
    }

    /**
    * seta o valor de horario_2f
    * @param pHorario_2f
    */
    public void setHorario_2f(String pHorario_2f){
        this.horario_2f = pHorario_2f;
    }
    /**
    * @return horario_2f
    */
    public String getHorario_2f(){
        return this.horario_2f;
    }

    /**
    * seta o valor de dia_2f
    * @param pDia_2f
    */
    public void setDia_2f(String pDia_2f){
        this.dia_2f = pDia_2f;
    }
    /**
    * @return dia_2f
    */
    public String getDia_2f(){
        return this.dia_2f;
    }

    @Override
    public String toString(){
        return "ModelSegFaseTurma {" + "::id = " + this.id + "::campo1 = " + this.campo1 + "::horario_2f = " + this.horario_2f + "::dia_2f = " + this.dia_2f +  "}";
    }
}