package model;
/**
*
* @author Charles
*/
public class ModelEntrevistaAluno {

    private int id;
    private int  id_aluno;
    private int id_empresa;
    private String data_entrevista;
    private String horario_entrevista;
    

    /**
    * Construtor
    */
    public ModelEntrevistaAluno(){}

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
    * seta o valor de id_aluno
    * @param pId_aluno
    */
    public void setId_aluno(int  pId_aluno){
        this.id_aluno = pId_aluno;
    }
    /**
    * return id_aluno
    */
    public int  getId_aluno(){
        return this.id_aluno;
    }

    /**
    * seta o valor de id_empresa
    * @param pId_empresa
    */
    public void setId_empresa(int pId_empresa){
        this.id_empresa = pId_empresa;
    }
    /**
    * return id_empresa
    */
    public int getId_empresa(){
        return this.id_empresa;
    }

    /**
    * seta o valor de data_entrevista
    * @param pData_entrevista
    */
    public void setData_entrevista(String pData_entrevista){
        this.data_entrevista = pData_entrevista;
    }
    /**
    * return data_entrevista
    */
    public String getData_entrevista(){
        return this.data_entrevista;
    }



    public String getHorario_entrevista() {
        return horario_entrevista;
    }

    public void setHorario_entrevista(String horario_entrevista) {
        this.horario_entrevista = horario_entrevista;
    }

    @Override
    public String toString() {
        return "ModelEntrevistaAluno{" + "id=" + id + ", id_aluno=" + id_aluno + ", id_empresa=" + id_empresa + ", data_entrevista=" + data_entrevista + ", horario_entrevista=" + horario_entrevista + '}';
    }
    
    
}