package model;
/**
*
* @author Charles Müller
*/
public class ModelDiaCurso {

    private int id;
    private String dia;

    /**
    * Construtor
    */
    public ModelDiaCurso(){}

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
    * seta o valor de dia
    * @param pDia
    */
    public void setDia(String pDia){
        this.dia = pDia;
    }
    /**
    * @return dia
    */
    public String getDia(){
        return this.dia;
    }

    @Override
    public String toString(){
        return "ModelDiaCurso {" + "::id = " + this.id + "::dia = " + this.dia +  "}";
    }
}