package model;
/**
*
* @author Charles Müller
*/
public class ModelTurma {

    private int id;
    private String descricao;
    private String ano;
    private String inicio;
    private String dias;
    private String fim;
    private String data_formatura;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public String getData_formatura() {
        return data_formatura;
    }

    public void setData_formatura(String data_formatura) {
        this.data_formatura = data_formatura;
    }

    @Override
    public String toString() {
        return "ModelTurma{" + "id=" + id + ", descricao=" + descricao + ", ano=" + ano + ", inicio=" + inicio + ", dias=" + dias + ", fim=" + fim + ", data_formatura=" + data_formatura + '}';
    }

    
    
}