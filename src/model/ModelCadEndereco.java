package model;
/**
*
* @author Charles Müller
*/
public class ModelCadEndereco {



    private int end_codigo;
    private String end_cep;
    private String end_logradouro;
    private String end_bairro;
    private String end_cidade;
    private String end_uf;
    private String end_cod_ibge;
    
    
    /**
     * @return the end_codigo
     */
    public int getEnd_codigo() {
        return end_codigo;
    }

    /**
     * @param end_codigo the end_codigo to set
     */
    public void setEnd_codigo(int end_codigo) {
        this.end_codigo = end_codigo;
    }
    /**
    * Construtor
    */
    public ModelCadEndereco(){}

    /**
    * seta o valor de end_cep
    * @param pEnd_cep
    */
    public void setEnd_cep(String pEnd_cep){
        this.end_cep = pEnd_cep;
    }
    /**
    * return end_cep
    */
    public String getEnd_cep(){
        return this.end_cep;
    }

    /**
    * seta o valor de end_logradouro
    * @param pEnd_logradouro
    */
    public void setEnd_logradouro(String pEnd_logradouro){
        this.end_logradouro = pEnd_logradouro;
    }
    /**
    * return end_logradouro
    */
    public String getEnd_logradouro(){
        return this.end_logradouro;
    }

    /**
    * seta o valor de end_bairro
    * @param pEnd_bairro
    */
    public void setEnd_bairro(String pEnd_bairro){
        this.end_bairro = pEnd_bairro;
    }
    /**
    * return end_bairro
    */
    public String getEnd_bairro(){
        return this.end_bairro;
    }

    /**
    * seta o valor de end_cidade
    * @param pEnd_cidade
    */
    public void setEnd_cidade(String pEnd_cidade){
        this.end_cidade = pEnd_cidade;
    }
    /**
    * return end_cidade
    */
    public String getEnd_cidade(){
        return this.end_cidade;
    }

    /**
    * seta o valor de end_uf
    * @param pEnd_uf
    */
    public void setEnd_uf(String pEnd_uf){
        this.end_uf = pEnd_uf;
    }
    /**
    * return end_uf
    */
    public String getEnd_uf(){
        return this.end_uf;
    }

    /**
    * seta o valor de end_cod_ibge
    * @param pEnd_cod_ibge
    */
    public void setEnd_cod_ibge(String pEnd_cod_ibge){
        this.end_cod_ibge = pEnd_cod_ibge;
    }
    /**
    * return end_cod_ibge
    */
    public String getEnd_cod_ibge(){
        return this.end_cod_ibge;
    }

    @Override
    public String toString(){
        return "ModelCadEndereco {" + "::end_cep = " + this.end_cep + "::end_logradouro = " + this.end_logradouro + "::end_bairro = " + this.end_bairro + "::end_cidade = " + this.end_cidade + "::end_uf = " + this.end_uf + "::end_cod_ibge = " + this.end_cod_ibge +  "}";
    }
}