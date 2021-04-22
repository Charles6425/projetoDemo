package model;
/**
*
* @author Charles Müller
*/
public class ModelEventos {

    private int id;
    private int id_evento;
    private String ano;
    private String data;
    private int id_aluno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    @Override
    public String toString() {
        return "ModelEventos{" + "id=" + id + ", id_evento=" + id_evento + ", ano=" + ano + ", data=" + data + ", id_aluno=" + id_aluno + '}';
    }
    

   
}