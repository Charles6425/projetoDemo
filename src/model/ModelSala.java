package model;
/**
*
* @author Charles Müller
*/
public class ModelSala {

    private int id;
    private String descricao;
    private String campo1;

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

    public String getCampo1() {
        return campo1;
    }

    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }

    @Override
    public String toString() {
        return "ModelSala{" + "id=" + id + ", descricao=" + descricao + ", campo1=" + campo1 + '}';
    }

    
}