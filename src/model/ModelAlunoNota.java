package model;
/**
*
* @author Charles
*/
public class ModelAlunoNota {

    private int id;
    private int materia;
    private String rgm_aluno;
    private Float nota;
    private String ano;

    /**
    * Construtor
    */
    public ModelAlunoNota(){}

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
    * seta o valor de materia
    * @param pMateria
    */
    public void setMateria(int pMateria){
        this.materia = pMateria;
    }
    /**
    * return materia
    */
    public int getMateria(){
        return this.materia;
    }

    /**
    * seta o valor de rgm_aluno
    * @param pRgm_aluno
    */
    public void setRgm_aluno(String pRgm_aluno){
        this.rgm_aluno = pRgm_aluno;
    }
    /**
    * return rgm_aluno
    */
    public String getRgm_aluno(){
        return this.rgm_aluno;
    }

    /**
    * seta o valor de nota
    * @param pNota
    */
    public void setNota(Float pNota){
        this.nota = pNota;
    }
    /**
    * return nota
    */
    public Float getNota(){
        return this.nota;
    }

    /**
    * seta o valor de ano
    * @param pAno
    */
    public void setAno(String pAno){
        this.ano = pAno;
    }
    /**
    * return ano
    */
    public String getAno(){
        return this.ano;
    }

    @Override
    public String toString() {
        return "ModelAlunoNota{" + "id=" + id + ", materia=" + materia + ", rgm_aluno=" + rgm_aluno + ", nota=" + nota + ", ano=" + ano + '}';
    }


}