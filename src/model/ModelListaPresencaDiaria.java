package model;
/**
*
* @author Charles Müller
*/
public class ModelListaPresencaDiaria {

    private int id;
    private String segunda;
    private String terca;
    private String quarta;
    private String quinta;
    private String sexta;
    private String descricao;
    private int turma;

    /**
    * Construtor
    */
    public ModelListaPresencaDiaria(){}

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
    * seta o valor de segunda
    * @param pSegunda
    */
    public void setSegunda(String pSegunda){
        this.segunda = pSegunda;
    }
    /**
    * @return segunda
    */
    public String getSegunda(){
        return this.segunda;
    }

    /**
    * seta o valor de terca
    * @param pTerca
    */
    public void setTerca(String pTerca){
        this.terca = pTerca;
    }
    /**
    * @return terca
    */
    public String getTerca(){
        return this.terca;
    }

    /**
    * seta o valor de quarta
    * @param pQuarta
    */
    public void setQuarta(String pQuarta){
        this.quarta = pQuarta;
    }
    /**
    * @return quarta
    */
    public String getQuarta(){
        return this.quarta;
    }

    /**
    * seta o valor de quinta
    * @param pQuinta
    */
    public void setQuinta(String pQuinta){
        this.quinta = pQuinta;
    }
    /**
    * @return quinta
    */
    public String getQuinta(){
        return this.quinta;
    }

    /**
    * seta o valor de sexta
    * @param pSexta
    */
    public void setSexta(String pSexta){
        this.sexta = pSexta;
    }
    /**
    * @return sexta
    */
    public String getSexta(){
        return this.sexta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "ModelListaPresencaDiaria{" + "id=" + id + ", segunda=" + segunda + ", terca=" + terca + ", quarta=" + quarta + ", quinta=" + quinta + ", sexta=" + sexta + ", descricao=" + descricao + ", turma=" + turma + '}';
    }
    
    
}