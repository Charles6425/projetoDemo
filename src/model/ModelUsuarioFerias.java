package model;



/**
*
* @author Charles
*/
public class ModelUsuarioFerias {

    private int id;
    private int  id_usuario;
    private String dt_inicio;
    private String dt_fim;

    /**
    * Construtor
    */
    public ModelUsuarioFerias(){}

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
    * seta o valor de id_usuario
    * @param pId_usuario
    */
    public void setId_usuario(int  pId_usuario){
        this.id_usuario = pId_usuario;
    }
    /**
    * return id_usuario
    */
    public int  getId_usuario(){
        return this.id_usuario;
    }

    /**
    * seta o valor de dt_inicio
    * @param pDt_inicio
    */
    public void setDt_inicio(String pDt_inicio){
        this.dt_inicio = pDt_inicio;
    }
    /**
    * return dt_inicio
    */
    public String getDt_inicio(){
        return this.dt_inicio;
    }

    /**
    * seta o valor de dt_fim
    * @param pDt_fim
    */
    public void setDt_fim(String pDt_fim){
        this.dt_fim = pDt_fim;
    }
    /**
    * return dt_fim
    */
    public String getDt_fim(){
        return this.dt_fim;
    }

    @Override
    public String toString() {
        return "ModelUsuarioFerias{" + "id=" + id + ", id_usuario=" + id_usuario + ", dt_inicio=" + dt_inicio + ", dt_fim=" + dt_fim + '}';
    }


}