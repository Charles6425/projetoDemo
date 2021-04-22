package model;
/**
*
* @author Charles Müller
*/
public class ModelAdmissao {

    private int id;
    private int empresa;
    private int aprendiz;
    private String horario;
    private String inicio;
    private String Termino;
    private int cbo;
    private int tipo_admissao;
    private Float salario;
    private int  curso;
    private int convenio_odont;
    private int desconto_vt;
    private int insalubre;
    private Float insalubre_percentual;

    /**
    * Construtor
    */
    public ModelAdmissao(){}

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
    * seta o valor de empresa
    * @param pEmpresa
    */
    public void setEmpresa(int pEmpresa){
        this.empresa = pEmpresa;
    }
    /**
    * @return empresa
    */
    public int getEmpresa(){
        return this.empresa;
    }

    /**
    * seta o valor de aprendiz
    * @param pAprendiz
    */
    public void setAprendiz(int pAprendiz){
        this.aprendiz = pAprendiz;
    }
    /**
    * @return aprendiz
    */
    public int getAprendiz(){
        return this.aprendiz;
    }

    /**
    * seta o valor de horario
    * @param pHorario
    */
    public void setHorario(String pHorario){
        this.horario = pHorario;
    }
    /**
    * @return horario
    */
    public String getHorario(){
        return this.horario;
    }

    /**
    * seta o valor de inicio
    * @param pInicio
    */
    public void setInicio(String pInicio){
        this.inicio = pInicio;
    }
    /**
    * @return inicio
    */
    public String getInicio(){
        return this.inicio;
    }

    /**
    * seta o valor de Termino
    * @param pTermino
    */
    public void setTermino(String pTermino){
        this.Termino = pTermino;
    }
    /**
    * @return Termino
    */
    public String getTermino(){
        return this.Termino;
    }

    /**
    * seta o valor de cbo
    * @param pCbo
    */
    public void setCbo(int pCbo){
        this.cbo = pCbo;
    }
    /**
    * @return cbo
    */
    public int getCbo(){
        return this.cbo;
    }

    /**
    * seta o valor de tipo_admissao
    * @param pTipo_admissao
    */
    public void setTipo_admissao(int pTipo_admissao){
        this.tipo_admissao = pTipo_admissao;
    }
    /**
    * @return tipo_admissao
    */
    public int getTipo_admissao(){
        return this.tipo_admissao;
    }

    /**
    * seta o valor de salario
    * @param pSalario
    */
    public void setSalario(Float pSalario){
        this.salario = pSalario;
    }
    /**
    * @return salario
    */
    public Float getSalario(){
        return this.salario;
    }

    /**
    * seta o valor de curso
    * @param pCurso
    */
    public void setCurso(int  pCurso){
        this.curso = pCurso;
    }
    /**
    * @return curso
    */
    public int  getCurso(){
        return this.curso;
    }

    /**
    * seta o valor de convenio_odont
    * @param pConvenio_odont
    */
    public void setConvenio_odont(int pConvenio_odont){
        this.convenio_odont = pConvenio_odont;
    }
    /**
    * @return convenio_odont
    */
    public int getConvenio_odont(){
        return this.convenio_odont;
    }

    /**
    * seta o valor de desconto_vt
    * @param pDesconto_vt
    */
    public void setDesconto_vt(int pDesconto_vt){
        this.desconto_vt = pDesconto_vt;
    }
    /**
    * @return desconto_vt
    */
    public int getDesconto_vt(){
        return this.desconto_vt;
    }

    /**
    * seta o valor de insalubre
    * @param pInsalubre
    */
    public void setInsalubre(int pInsalubre){
        this.insalubre = pInsalubre;
    }
    /**
    * @return insalubre
    */
    public int getInsalubre(){
        return this.insalubre;
    }

    /**
    * seta o valor de insalubre_percentual
    * @param pInsalubre_percentual
    */
    public void setInsalubre_percentual(Float pInsalubre_percentual){
        this.insalubre_percentual = pInsalubre_percentual;
    }
    /**
    * @return insalubre_percentual
    */
    public Float getInsalubre_percentual(){
        return this.insalubre_percentual;
    }

    @Override
    public String toString(){
        return "ModelAdmissao {" + "::id = " + this.id + "::empresa = " + this.empresa + "::aprendiz = " + this.aprendiz + "::horario = " + this.horario + "::inicio = " + this.inicio + "::Termino = " + this.Termino + "::cbo = " + this.cbo + "::tipo_admissao = " + this.tipo_admissao + "::salario = " + this.salario + "::curso = " + this.curso + "::convenio_odont = " + this.convenio_odont + "::desconto_vt = " + this.desconto_vt + "::insalubre = " + this.insalubre + "::insalubre_percentual = " + this.insalubre_percentual +  "}";
    }
}