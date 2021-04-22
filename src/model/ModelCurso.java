package model;
/**
*
* @author Charles Müller
*/
public class ModelCurso {

    private int id;
    private String curso;
    private String cbo;
    private String categoria_pratica;
    private String teoria;

    /**
    * Construtor
    */
    public ModelCurso(){}

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
    * seta o valor de curso
    * @param pCurso
    */
    public void setCurso(String pCurso){
        this.curso = pCurso;
    }
    /**
    * @return curso
    */
    public String getCurso(){
        return this.curso;
    }

    /**
    * seta o valor de cbo
    * @param pCbo
    */
    public void setCbo(String pCbo){
        this.cbo = pCbo;
    }
    /**
    * @return cbo
    */
    public String getCbo(){
        return this.cbo;
    }

    /**
    * seta o valor de categoria_pratica
    * @param pCategoria_pratica
    */
    public void setCategoria_pratica(String pCategoria_pratica){
        this.categoria_pratica = pCategoria_pratica;
    }
    /**
    * @return categoria_pratica
    */
    public String getCategoria_pratica(){
        return this.categoria_pratica;
    }

    /**
    * seta o valor de teoria
    * @param pTeoria
    */
    public void setTeoria(String pTeoria){
        this.teoria = pTeoria;
    }
    /**
    * @return teoria
    */
    public String getTeoria(){
        return this.teoria;
    }

    @Override
    public String toString(){
        return "ModelCurso {" + "::id = " + this.id + "::curso = " + this.curso + "::cbo = " + this.cbo + "::categoria_pratica = " + this.categoria_pratica + "::teoria = " + this.teoria +  "}";
    }
}