package model;
/**
*
* @author Charles
*/
public class ModelBucarImagem {

    private int id;
    private String imagem;
    private int id_aluno;

    /**
    * Construtor
    */
    public ModelBucarImagem(){}

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
    * seta o valor de imagem
    * @param pImagem
    */
    public void setImagem(String pImagem){
        this.imagem = pImagem;
    }
    /**
    * return imagem
    */
    public String getImagem(){
        return this.imagem;
    }

    /**
    * seta o valor de id_aluno
    * @param pId_aluno
    */
    public void setId_aluno(int pId_aluno){
        this.id_aluno = pId_aluno;
    }
    /**
    * return id_aluno
    */
    public int getId_aluno(){
        return this.id_aluno;
    }

    @Override
    public String toString(){
        return "ModelBucarImagem {" + "::id = " + this.id + "::imagem = " + this.imagem + "::id_aluno = " + this.id_aluno +  "}";
    }
}