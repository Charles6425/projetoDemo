package model;
/**
*
* @author Charles
*/
public class ModelContatoEmpresa {

    private int id;
    private String nome;
    private String email;
    private String tel;
    private int id_empresa;

    /**
    * Construtor
    */
    public ModelContatoEmpresa(){}

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
    * seta o valor de nome
    * @param pNome
    */
    public void setNome(String pNome){
        this.nome = pNome;
    }
    /**
    * return nome
    */
    public String getNome(){
        return this.nome;
    }

    /**
    * seta o valor de email
    * @param pEmail
    */
    public void setEmail(String pEmail){
        this.email = pEmail;
    }
    /**
    * return email
    */
    public String getEmail(){
        return this.email;
    }

    /**
    * seta o valor de tel
    * @param pTel
    */
    public void setTel(String pTel){
        this.tel = pTel;
    }
    /**
    * return tel
    */
    public String getTel(){
        return this.tel;
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

    @Override
    public String toString(){
        return "ModelContatoEmpresa {" + "::id = " + this.id + "::nome = " + this.nome + "::email = " + this.email + "::tel = " + this.tel + "::id_empresa = " + this.id_empresa +  "}";
    }
}