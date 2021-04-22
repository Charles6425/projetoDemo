package model;
/**
*
* @author Charles
*/
public class Modeladmicao {

    private int empresa;
    private String rgm;
    private int situacao;
    private int formacao_basica;
    private String admicao;
    private String recisao;
    private int local;
    private String dia_2;
    private int qual_curso;
    private String dt_cadastro;
    private String inicio_ppi;
    private String periodo;
    private String apresentacao_ppi;
    private String observacao;
    private int carga;
    private int t;
    private int turma;
    private int horario;

    /**
    * Construtor
    */
    public Modeladmicao(){}

    /**
    * seta o valor de empresa
    * @param pEmpresa
    */
    public void setEmpresa(int pEmpresa){
        this.empresa = pEmpresa;
    }
    /**
    * return empresa
    */
    public int getEmpresa(){
        return this.empresa;
    }

    /**
    * seta o valor de rgm
    * @param pRgm
    */
    public void setRgm(String pRgm){
        this.rgm = pRgm;
    }
    /**
    * return rgm
    */
    public String getRgm(){
        return this.rgm;
    }

    /**
    * seta o valor de situacao
    * @param pSituacao
    */
    public void setSituacao(int pSituacao){
        this.situacao = pSituacao;
    }
    /**
    * return situacao
    */
    public int getSituacao(){
        return this.situacao;
    }

    /**
    * seta o valor de formacao_basica
    * @param pFormacao_basica
    */
    public void setFormacao_basica(int pFormacao_basica){
        this.formacao_basica = pFormacao_basica;
    }
    /**
    * return formacao_basica
    */
    public int getFormacao_basica(){
        return this.formacao_basica;
    }

    /**
    * seta o valor de admicao
    * @param pAdmicao
    */
    public void setAdmicao(String pAdmicao){
        this.admicao = pAdmicao;
    }
    /**
    * return admicao
    */
    public String getAdmicao(){
        return this.admicao;
    }

    /**
    * seta o valor de recisao
    * @param pRecisao
    */
    public void setRecisao(String pRecisao){
        this.recisao = pRecisao;
    }
    /**
    * return recisao
    */
    public String getRecisao(){
        return this.recisao;
    }

    /**
    * seta o valor de local
    * @param pLocal
    */
    public void setLocal(int pLocal){
        this.local = pLocal;
    }
    /**
    * return local
    */
    public int getLocal(){
        return this.local;
    }

    /**
    * seta o valor de dia_2
    * @param pDia_2
    */
    public void setDia_2(String pDia_2){
        this.dia_2 = pDia_2;
    }
    /**
    * return dia_2
    */
    public String getDia_2(){
        return this.dia_2;
    }

    /**
    * seta o valor de qual_curso
    * @param pQual_curso
    */
    public void setQual_curso(int pQual_curso){
        this.qual_curso = pQual_curso;
    }
    /**
    * return qual_curso
    */
    public int getQual_curso(){
        return this.qual_curso;
    }

    /**
    * seta o valor de dt_cadastro
    * @param pDt_cadastro
    */
    public void setDt_cadastro(String pDt_cadastro){
        this.dt_cadastro = pDt_cadastro;
    }
    /**
    * return dt_cadastro
    */
    public String getDt_cadastro(){
        return this.dt_cadastro;
    }

    /**
    * seta o valor de inicio_ppi
    * @param pInicio_ppi
    */
    public void setInicio_ppi(String pInicio_ppi){
        this.inicio_ppi = pInicio_ppi;
    }
    /**
    * return inicio_ppi
    */
    public String getInicio_ppi(){
        return this.inicio_ppi;
    }

    /**
    * seta o valor de periodo
    * @param pPeriodo
    */
    public void setPeriodo(String pPeriodo){
        this.periodo = pPeriodo;
    }
    /**
    * return periodo
    */
    public String getPeriodo(){
        return this.periodo;
    }

    /**
    * seta o valor de apresentacao_ppi
    * @param pApresentacao_ppi
    */
    public void setApresentacao_ppi(String pApresentacao_ppi){
        this.apresentacao_ppi = pApresentacao_ppi;
    }
    /**
    * return apresentacao_ppi
    */
    public String getApresentacao_ppi(){
        return this.apresentacao_ppi;
    }

    /**
    * seta o valor de observacao
    * @param pObservacao
    */
    public void setObservacao(String pObservacao){
        this.observacao = pObservacao;
    }
    /**
    * return observacao
    */
    public String getObservacao(){
        return this.observacao;
    }

    /**
    * seta o valor de carga
    * @param pCarga
    */
    public void setCarga(int pCarga){
        this.carga = pCarga;
    }
    /**
    * return carga
    */
    public int getCarga(){
        return this.carga;
    }

    /**
    * seta o valor de t
    * @param pT
    */
    public void setT(int pT){
        this.t = pT;
    }
    /**
    * return t
    */
    public int getT(){
        return this.t;
    }

    /**
    * seta o valor de turma
    * @param pTurma
    */
    public void setTurma(int pTurma){
        this.turma = pTurma;
    }
    /**
    * return turma
    */
    public int getTurma(){
        return this.turma;
    }

    /**
    * seta o valor de horario
    * @param pHorario
    */
    public void setHorario(int pHorario){
        this.horario = pHorario;
    }
    /**
    * return horario
    */
    public int getHorario(){
        return this.horario;
    }

    @Override
    public String toString(){
        return "Modeladmicao {" + "::empresa = " + this.empresa + "::rgm = " + this.rgm + "::situacao = " + this.situacao + "::formacao_basica = " + this.formacao_basica + "::admicao = " + this.admicao + "::recisao = " + this.recisao + "::local = " + this.local + "::dia_2 = " + this.dia_2 + "::qual_curso = " + this.qual_curso + "::dt_cadastro = " + this.dt_cadastro + "::inicio_ppi = " + this.inicio_ppi + "::periodo = " + this.periodo + "::apresentacao_ppi = " + this.apresentacao_ppi + "::observacao = " + this.observacao + "::carga = " + this.carga + "::t = " + this.t + "::turma = " + this.turma + "::horario = " + this.horario +  "}";
    }
}