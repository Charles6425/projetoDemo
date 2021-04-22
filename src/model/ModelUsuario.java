package model;

import java.util.Date;

/**
*
* @author Charles
*/
public class ModelUsuario {

    private int id;
    private String nome;
    private String cargo;
    private Date dt_admissao;
    private Date dt_demissao;
    private String usuario;
    private String senha;
    private String rep_senha;
    private String cpf;
    private String rg;
    private Date dt_emissao_rg;
    private Date dt_nascimento;
    private String ctps;
    private String serie_uf;
    private Date dt_emissao_ctps;
    private String pis;
    private String banco;
    private String agencia;
    private String conta;
    private int cod_endereco;
    private String numero;
    private String complemento;
    private String tel_1;
    private String tel_2;
    private String cel_1;
    private String cel_2;
    private String email;
    private String anotacoes_diversas;
    private int perm_cad_aluno;
    private int perm_cad_empresa;
    private int perm_cad_usuario;

    /**
    * Construtor
    */
    public ModelUsuario(){}

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
    * seta o valor de cargo
    * @param pCargo
    */
    public void setCargo(String pCargo){
        this.cargo = pCargo;
    }
    /**
    * return cargo
    */
    public String getCargo(){
        return this.cargo;
    }

    /**
    * seta o valor de dt_admissao
    * @param pDt_admissao
    */
    public void setDt_admissao(Date pDt_admissao){
        this.dt_admissao = pDt_admissao;
    }
    /**
    * return dt_admissao
    */
    public Date getDt_admissao(){
        return this.dt_admissao;
    }

    /**
    * seta o valor de dt_demissao
    * @param pDt_demissao
    */
    public void setDt_demissao(Date pDt_demissao){
        this.dt_demissao = pDt_demissao;
    }
    /**
    * return dt_demissao
    */
    public Date getDt_demissao(){
        return this.dt_demissao;
    }

    /**
    * seta o valor de usuario
    * @param pUsuario
    */
    public void setUsuario(String pUsuario){
        this.usuario = pUsuario;
    }
    /**
    * return usuario
    */
    public String getUsuario(){
        return this.usuario;
    }

    /**
    * seta o valor de senha
    * @param pSenha
    */
    public void setSenha(String pSenha){
        this.senha = pSenha;
    }
    /**
    * return senha
    */
    public String getSenha(){
        return this.senha;
    }

    /**
    * seta o valor de rep_senha
    * @param pRep_senha
    */
    public void setRep_senha(String pRep_senha){
        this.rep_senha = pRep_senha;
    }
    /**
    * return rep_senha
    */
    public String getRep_senha(){
        return this.rep_senha;
    }

    /**
    * seta o valor de cpf
    * @param pCpf
    */
    public void setCpf(String pCpf){
        this.cpf = pCpf;
    }
    /**
    * return cpf
    */
    public String getCpf(){
        return this.cpf;
    }

    /**
    * seta o valor de rg
    * @param pRg
    */
    public void setRg(String pRg){
        this.rg = pRg;
    }
    /**
    * return rg
    */
    public String getRg(){
        return this.rg;
    }

    /**
    * seta o valor de dt_emissao_rg
    * @param pDt_emissao_rg
    */
    public void setDt_emissao_rg(Date pDt_emissao_rg){
        this.dt_emissao_rg = pDt_emissao_rg;
    }
    /**
    * return dt_emissao_rg
    */
    public Date getDt_emissao_rg(){
        return this.dt_emissao_rg;
    }

    /**
    * seta o valor de dt_nascimento
    * @param pDt_nascimento
    */
    public void setDt_nascimento(Date pDt_nascimento){
        this.dt_nascimento = pDt_nascimento;
    }
    /**
    * return dt_nascimento
    */
    public Date getDt_nascimento(){
        return this.dt_nascimento;
    }

    /**
    * seta o valor de ctps
    * @param pCtps
    */
    public void setCtps(String pCtps){
        this.ctps = pCtps;
    }
    /**
    * return ctps
    */
    public String getCtps(){
        return this.ctps;
    }

    /**
    * seta o valor de serie_uf
    * @param pSerie_uf
    */
    public void setSerie_uf(String pSerie_uf){
        this.serie_uf = pSerie_uf;
    }
    /**
    * return serie_uf
    */
    public String getSerie_uf(){
        return this.serie_uf;
    }

    /**
    * seta o valor de dt_emissao_ctps
    * @param pDt_emissao_ctps
    */
    public void setDt_emissao_ctps(Date pDt_emissao_ctps){
        this.dt_emissao_ctps = pDt_emissao_ctps;
    }
    /**
    * return dt_emissao_ctps
    */
    public Date getDt_emissao_ctps(){
        return this.dt_emissao_ctps;
    }

    /**
    * seta o valor de pis
    * @param pPis
    */
    public void setPis(String pPis){
        this.pis = pPis;
    }
    /**
    * return pis
    */
    public String getPis(){
        return this.pis;
    }

    /**
    * seta o valor de banco
    * @param pBanco
    */
    public void setBanco(String pBanco){
        this.banco = pBanco;
    }
    /**
    * return banco
    */
    public String getBanco(){
        return this.banco;
    }

    /**
    * seta o valor de agencia
    * @param pAgencia
    */
    public void setAgencia(String pAgencia){
        this.agencia = pAgencia;
    }
    /**
    * return agencia
    */
    public String getAgencia(){
        return this.agencia;
    }

    /**
    * seta o valor de conta
    * @param pConta
    */
    public void setConta(String pConta){
        this.conta = pConta;
    }
    /**
    * return conta
    */
    public String getConta(){
        return this.conta;
    }

    /**
    * seta o valor de cod_endereco
    * @param pCod_endereco
    */
    public void setCod_endereco(int pCod_endereco){
        this.cod_endereco = pCod_endereco;
    }
    /**
    * return cod_endereco
    */
    public int getCod_endereco(){
        return this.cod_endereco;
    }

    /**
    * seta o valor de numero
    * @param pNumero
    */
    public void setNumero(String pNumero){
        this.numero = pNumero;
    }
    /**
    * return numero
    */
    public String getNumero(){
        return this.numero;
    }

    /**
    * seta o valor de complemento
    * @param pComplemento
    */
    public void setComplemento(String pComplemento){
        this.complemento = pComplemento;
    }
    /**
    * return complemento
    */
    public String getComplemento(){
        return this.complemento;
    }

    /**
    * seta o valor de tel_1
    * @param pTel_1
    */
    public void setTel_1(String pTel_1){
        this.tel_1 = pTel_1;
    }
    /**
    * return tel_1
    */
    public String getTel_1(){
        return this.tel_1;
    }

    /**
    * seta o valor de tel_2
    * @param pTel_2
    */
    public void setTel_2(String pTel_2){
        this.tel_2 = pTel_2;
    }
    /**
    * return tel_2
    */
    public String getTel_2(){
        return this.tel_2;
    }

    /**
    * seta o valor de cel_1
    * @param pCel_1
    */
    public void setCel_1(String pCel_1){
        this.cel_1 = pCel_1;
    }
    /**
    * return cel_1
    */
    public String getCel_1(){
        return this.cel_1;
    }

    /**
    * seta o valor de cel_2
    * @param pCel_2
    */
    public void setCel_2(String pCel_2){
        this.cel_2 = pCel_2;
    }
    /**
    * return cel_2
    */
    public String getCel_2(){
        return this.cel_2;
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
    * seta o valor de anotacoes_diversas
    * @param pAnotacoes_diversas
    */
    public void setAnotacoes_diversas(String pAnotacoes_diversas){
        this.anotacoes_diversas = pAnotacoes_diversas;
    }
    /**
    * return anotacoes_diversas
    */
    public String getAnotacoes_diversas(){
        return this.anotacoes_diversas;
    }

    /**
    * seta o valor de perm_cad_aluno
    * @param pPerm_cad_aluno
    */
    public void setPerm_cad_aluno(int pPerm_cad_aluno){
        this.perm_cad_aluno = pPerm_cad_aluno;
    }
    /**
    * return perm_cad_aluno
    */
    public int getPerm_cad_aluno(){
        return this.perm_cad_aluno;
    }

    /**
    * seta o valor de perm_cad_empresa
    * @param pPerm_cad_empresa
    */
    public void setPerm_cad_empresa(int pPerm_cad_empresa){
        this.perm_cad_empresa = pPerm_cad_empresa;
    }
    /**
    * return perm_cad_empresa
    */
    public int getPerm_cad_empresa(){
        return this.perm_cad_empresa;
    }

    /**
    * seta o valor de perm_cad_usuario
    * @param pPerm_cad_usuario
    */
    public void setPerm_cad_usuario(int pPerm_cad_usuario){
        this.perm_cad_usuario = pPerm_cad_usuario;
    }
    /**
    * return perm_cad_usuario
    */
    public int getPerm_cad_usuario(){
        return this.perm_cad_usuario;
    }

    @Override
    public String toString(){
        return "ModelUsuario {" + "::id = " + this.id + "::nome = " + this.nome + "::cargo = " + this.cargo + "::dt_admissao = " + this.dt_admissao + "::dt_demissao = " + this.dt_demissao + "::usuario = " + this.usuario + "::senha = " + this.senha + "::rep_senha = " + this.rep_senha + "::cpf = " + this.cpf + "::rg = " + this.rg + "::dt_emissao_rg = " + this.dt_emissao_rg + "::dt_nascimento = " + this.dt_nascimento + "::ctps = " + this.ctps + "::serie_uf = " + this.serie_uf + "::dt_emissao_ctps = " + this.dt_emissao_ctps + "::pis = " + this.pis + "::banco = " + this.banco + "::agencia = " + this.agencia + "::conta = " + this.conta + "::cod_endereco = " + this.cod_endereco + "::numero = " + this.numero + "::complemento = " + this.complemento + "::tel_1 = " + this.tel_1 + "::tel_2 = " + this.tel_2 + "::cel_1 = " + this.cel_1 + "::cel_2 = " + this.cel_2 + "::email = " + this.email + "::anotacoes_diversas = " + this.anotacoes_diversas + "::perm_cad_aluno = " + this.perm_cad_aluno + "::perm_cad_empresa = " + this.perm_cad_empresa + "::perm_cad_usuario = " + this.perm_cad_usuario +  "}";
    }
}