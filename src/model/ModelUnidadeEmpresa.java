package model;
/**
*
* @author Charles
*/
public class ModelUnidadeEmpresa {

    private int id;
    private int  id_empresa;

    /**
    * Construtor
    */
    public ModelUnidadeEmpresa(){}

    /**
    * seta o valor de id
    * @param pId
    */
    public void setId(int pId){
        this.id = pId;
    }
    /**
    * return id
    */
    public int getId(){
        return this.id;
    }

    /**
    * seta o valor de id_empresa
    * @param pId_empresa
    */
    public void setId_empresa(int  pId_empresa){
        this.id_empresa = pId_empresa;
    }
    /**
    * return id_empresa
    */
    public int  getId_empresa(){
        return this.id_empresa;
    }

    @Override
    public String toString(){
        return "ModelUnidadeEmpresa {" + "::id = " + this.id + "::id_empresa = " + this.id_empresa +  "}";
    }
}