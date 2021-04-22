package model;
/**
*
* @author Charles Müller
*/
public class ModelParametros {

    private int config_id;
    private int pdv_solicita_vendedor;
    private int pdv_desconto_percentual;
    private int cad_utiliza_ficha_tec;
    private int cad_anvisa;
    private int mostra_total_fechto;
    

    /**
    * Construtor
    */
    public ModelParametros(){}

    /**
    * seta o valor de config_id
    * @param pConfig_id
    */
    public void setConfig_id(int pConfig_id){
        this.config_id = pConfig_id;
    }
    /**
    * return config_id
    */
    public int getConfig_id(){
        return this.config_id;
    }

    /**
    * seta o valor de pdv_solicita_vendedor
    * @param pPdv_solicita_vendedor
    */
    public void setPdv_solicita_vendedor(int pPdv_solicita_vendedor){
        this.pdv_solicita_vendedor = pPdv_solicita_vendedor;
    }
    /**
    * return pdv_solicita_vendedor
    */
    public int getPdv_solicita_vendedor(){
        return this.pdv_solicita_vendedor;
    }


    public int getPdv_desconto_percentual() {
        return pdv_desconto_percentual;
    }

    public void setPdv_desconto_percentual(int pdv_desconto_percentual) {
        this.pdv_desconto_percentual = pdv_desconto_percentual;
    }

    public int getCad_utiliza_ficha_tec() {
        return cad_utiliza_ficha_tec;
    }

    public void setCad_utiliza_ficha_tec(int cad_utiliza_ficha_tec) {
        this.cad_utiliza_ficha_tec = cad_utiliza_ficha_tec;
    }

    public int getCad_anvisa() {
        return cad_anvisa;
    }

    public void setCad_anvisa(int cad_anvisa) {
        this.cad_anvisa = cad_anvisa;
    }

    public int getMostra_total_fechto() {
        return mostra_total_fechto;
    }

    public void setMostra_total_fechto(int mostra_total_fechto) {
        this.mostra_total_fechto = mostra_total_fechto;
    }

    @Override
    public String toString() {
        return "ModelParametros{" + "config_id=" + config_id + ", pdv_solicita_vendedor=" + pdv_solicita_vendedor + ", pdv_desconto_percentual=" + pdv_desconto_percentual + ", cad_utiliza_ficha_tec=" + cad_utiliza_ficha_tec + ", cad_anvisa=" + cad_anvisa + ", mostra_total_fechto=" + mostra_total_fechto + '}';
    }
    
    


}