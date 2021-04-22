package model;

/**
 *
 * @author Charles
 */
public class ModelAluno {

    private int id;
    private String nome_aluno;
    private String rgm_aluno;
    private String mae;
    private String pai;
    private String rg_pai;
    private int cod_endereco;
    private String numero;
    private String complemento;
    private String tel_1;
    private String tel_2;
    private String tel_3;
    private String tel_4;
    private String cpf;
    private String rg_aluno;
    private String dt_emissao_rg;
    private String dt_nascimento;
    private String local_nascimento;
    private String uf_nascimento;
    private String ctps;
    private String serie_uf_cpts;
    private String dt_emissao_ctps;
    private String pis;
    private String num_conta;
    private String agencia;
    private String banco;
    private int seguro;
    private int baixa;
    private String data_baixa;
    private String anotacoes_diversas;
    private String homologacoes;
    private String sexo;
    private String escola;
    private String beneficio_social;
    private String numero_inscricao;
    private String tipo_residencia;
    private Float valor_mensal_residencia;
    private String email;
    private String rg_mae;
    private String dt_entrevista;
    private String ferias_empresa_num;
    private String ferias_periodo_adquirido;
    private String ferias_periodo_gozado;
    private String cep_importado;
    private String perfil;
    private String anot_pedagogicas;
    private String anot_sociais;
    private String anot_psicologicas;
    private String anot_administrativas;
    private String reservista;
    private String situacao;
    private int origem_aluno;
    private int cargo_aluno;
    private int formacao_basica;
    private double salario;
    private int sala;
    private int turma;
    private float altura;
    private String visita_empresa;
    private String data_visita;
    private String inicio_curso;
    private float port1;
    private float mat1;
    private float red1;
    private float inf1;
    private float md1;
    private float port2;
    private float mat2;
    private float nad2;
    private float nat;
    private float ed_moral2;
    private float sqv2;
    private float red2;
    private float atitudes2;
    private float ativ_fis2;
    private float inf2;
    private float md2;
    private float port3;
    private float mat3;
    private float nad3;
    private float nat3;
    private float ed_moral3;
    private float sqv3;
    private float red3;
    private float atitudes3;
    private float ativ_fis3;
    private float inf3;
    private float md3;
    private String camiseta;
    private int turma_2_fase;
    private String horario_2_fase;
    private String dia_2_fase;
    private String adv_falta;
    private String responsavel;
    private String observacao;
    private int turma_inicial;
    private int segunda_fase_confirma;
    private int cadastro_irregular;
    private int empresa_virtual;
    private int cargo_virtual;
    private String cep_apoio;
    private String bairro;
    private int idade;
    private int vt;
    private int cbo;
    private Float insalubre;
    private int insalubre_sn;
    private int tipo_admissao;
    private int convenio_odont;
    private int curso;
    private int horario;
    private String cor;
    private String cabelos;
    private String olhos;
    private String sinais;
    private Float peso;
    private String dt_emissao_pis;
    private String dt_Inclusao;
    private String dt_TerminoContrato;
    private int diaAtivTeorica;
    private String estado_civil;
    private String nacionalidade;
    private int local_aprendizagem;
    private String int_per1;
    private String int_per2;
    private String int_per3;
    private int dias_intensivo;
    private String pendente_intensivo;
    private String voto_consciente;
    private String status;
    private String diaCurso;
    private String dt_termino_curso;
    private String carga_horaria_total;
    private int empresa;
    private String dt_admissao;
    private String dt_rescisao;
    private int periodo;
    private int horas_trabalhadas;
    private int intensivo;
    private Float nota_cargo_virtual;
    private Float port4;
    private Float mat4;
    private Float inf4;
    private Float red4;
    private Float atitudes4;
    private Float md4;
    private Float port5;
    private Float mat5;
    private Float inf5;
    private Float red5;
    private Float atitudes5;
    private Float md5;

    @Override
    public String toString() {
        return "ModelAluno{" + "id=" + id + ", nome_aluno=" + nome_aluno + ", rgm_aluno=" + rgm_aluno + ", mae=" + mae + ", pai=" + pai + ", rg_pai=" + rg_pai + ", cod_endereco=" + cod_endereco + ", numero=" + numero + ", complemento=" + complemento + ", tel_1=" + tel_1 + ", tel_2=" + tel_2 + ", tel_3=" + tel_3 + ", tel_4=" + tel_4 + ", cpf=" + cpf + ", rg_aluno=" + rg_aluno + ", dt_emissao_rg=" + dt_emissao_rg + ", dt_nascimento=" + dt_nascimento + ", local_nascimento=" + local_nascimento + ", uf_nascimento=" + uf_nascimento + ", ctps=" + ctps + ", serie_uf_cpts=" + serie_uf_cpts + ", dt_emissao_ctps=" + dt_emissao_ctps + ", pis=" + pis + ", num_conta=" + num_conta + ", agencia=" + agencia + ", banco=" + banco + ", seguro=" + seguro + ", baixa=" + baixa + ", data_baixa=" + data_baixa + ", anotacoes_diversas=" + anotacoes_diversas + ", homologacoes=" + homologacoes + ", sexo=" + sexo + ", escola=" + escola + ", beneficio_social=" + beneficio_social + ", numero_inscricao=" + numero_inscricao + ", tipo_residencia=" + tipo_residencia + ", valor_mensal_residencia=" + valor_mensal_residencia + ", email=" + email + ", rg_mae=" + rg_mae + ", dt_entrevista=" + dt_entrevista + ", ferias_empresa_num=" + ferias_empresa_num + ", ferias_periodo_adquirido=" + ferias_periodo_adquirido + ", ferias_periodo_gozado=" + ferias_periodo_gozado + ", cep_importado=" + cep_importado + ", perfil=" + perfil + ", anot_pedagogicas=" + anot_pedagogicas + ", anot_sociais=" + anot_sociais + ", anot_psicologicas=" + anot_psicologicas + ", anot_administrativas=" + anot_administrativas + ", reservista=" + reservista + ", situacao=" + situacao + ", origem_aluno=" + origem_aluno + ", cargo_aluno=" + cargo_aluno + ", formacao_basica=" + formacao_basica + ", salario=" + salario + ", sala=" + sala + ", turma=" + turma + ", altura=" + altura + ", visita_empresa=" + visita_empresa + ", data_visita=" + data_visita + ", inicio_curso=" + inicio_curso + ", port1=" + port1 + ", mat1=" + mat1 + ", red1=" + red1 + ", inf1=" + inf1 + ", md1=" + md1 + ", port2=" + port2 + ", mat2=" + mat2 + ", nad2=" + nad2 + ", nat=" + nat + ", ed_moral2=" + ed_moral2 + ", sqv2=" + sqv2 + ", red2=" + red2 + ", atitudes2=" + atitudes2 + ", ativ_fis2=" + ativ_fis2 + ", inf2=" + inf2 + ", md2=" + md2 + ", port3=" + port3 + ", mat3=" + mat3 + ", nad3=" + nad3 + ", nat3=" + nat3 + ", ed_moral3=" + ed_moral3 + ", sqv3=" + sqv3 + ", red3=" + red3 + ", atitudes3=" + atitudes3 + ", ativ_fis3=" + ativ_fis3 + ", inf3=" + inf3 + ", md3=" + md3 + ", camiseta=" + camiseta + ", turma_2_fase=" + turma_2_fase + ", horario_2_fase=" + horario_2_fase + ", dia_2_fase=" + dia_2_fase + ", adv_falta=" + adv_falta + ", responsavel=" + responsavel + ", observacao=" + observacao + ", turma_inicial=" + turma_inicial + ", segunda_fase_confirma=" + segunda_fase_confirma + ", cadastro_irregular=" + cadastro_irregular + ", empresa_virtual=" + empresa_virtual + ", cargo_virtual=" + cargo_virtual + ", cep_apoio=" + cep_apoio + ", bairro=" + bairro + ", idade=" + idade + ", vt=" + vt + ", cbo=" + cbo + ", insalubre=" + insalubre + ", insalubre_sn=" + insalubre_sn + ", tipo_admissao=" + tipo_admissao + ", convenio_odont=" + convenio_odont + ", curso=" + curso + ", horario=" + horario + ", cor=" + cor + ", cabelos=" + cabelos + ", olhos=" + olhos + ", sinais=" + sinais + ", peso=" + peso + ", dt_emissao_pis=" + dt_emissao_pis + ", dt_Inclusao=" + dt_Inclusao + ", dt_TerminoContrato=" + dt_TerminoContrato + ", diaAtivTeorica=" + diaAtivTeorica + ", estado_civil=" + estado_civil + ", nacionalidade=" + nacionalidade + ", local_aprendizagem=" + local_aprendizagem + ", int_per1=" + int_per1 + ", int_per2=" + int_per2 + ", int_per3=" + int_per3 + ", dias_intensivo=" + dias_intensivo + ", pendente_intensivo=" + pendente_intensivo + ", voto_consciente=" + voto_consciente + ", status=" + status + ", diaCurso=" + diaCurso + ", dt_termino_curso=" + dt_termino_curso + ", carga_horaria_total=" + carga_horaria_total + ", empresa=" + empresa + ", dt_admissao=" + dt_admissao + ", dt_rescisao=" + dt_rescisao + ", periodo=" + periodo + ", horas_trabalhadas=" + horas_trabalhadas + ", intensivo=" + intensivo + ", nota_cargo_virtual=" + nota_cargo_virtual + ", port4=" + port4 + ", mat4=" + mat4 + ", inf4=" + inf4 + ", red4=" + red4 + ", atitudes4=" + atitudes4 + ", md4=" + md4 + ", port5=" + port5 + ", mat5=" + mat5 + ", inf5=" + inf5 + ", red5=" + red5 + ", atitudes5=" + atitudes5 + ", md5=" + md5 + '}';
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public String getRgm_aluno() {
        return rgm_aluno;
    }

    public void setRgm_aluno(String rgm_aluno) {
        this.rgm_aluno = rgm_aluno;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getRg_pai() {
        return rg_pai;
    }

    public void setRg_pai(String rg_pai) {
        this.rg_pai = rg_pai;
    }

    public int getCod_endereco() {
        return cod_endereco;
    }

    public void setCod_endereco(int cod_endereco) {
        this.cod_endereco = cod_endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTel_1() {
        return tel_1;
    }

    public void setTel_1(String tel_1) {
        this.tel_1 = tel_1;
    }

    public String getTel_2() {
        return tel_2;
    }

    public void setTel_2(String tel_2) {
        this.tel_2 = tel_2;
    }

    public String getTel_3() {
        return tel_3;
    }

    public void setTel_3(String tel_3) {
        this.tel_3 = tel_3;
    }

    public String getTel_4() {
        return tel_4;
    }

    public void setTel_4(String tel_4) {
        this.tel_4 = tel_4;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg_aluno() {
        return rg_aluno;
    }

    public void setRg_aluno(String rg_aluno) {
        this.rg_aluno = rg_aluno;
    }

    public String getDt_emissao_rg() {
        return dt_emissao_rg;
    }

    public void setDt_emissao_rg(String dt_emissao_rg) {
        this.dt_emissao_rg = dt_emissao_rg;
    }

    public String getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getLocal_nascimento() {
        return local_nascimento;
    }

    public void setLocal_nascimento(String local_nascimento) {
        this.local_nascimento = local_nascimento;
    }

    public String getUf_nascimento() {
        return uf_nascimento;
    }

    public void setUf_nascimento(String uf_nascimento) {
        this.uf_nascimento = uf_nascimento;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getSerie_uf_cpts() {
        return serie_uf_cpts;
    }

    public void setSerie_uf_cpts(String serie_uf_cpts) {
        this.serie_uf_cpts = serie_uf_cpts;
    }

    public String getDt_emissao_ctps() {
        return dt_emissao_ctps;
    }

    public void setDt_emissao_ctps(String dt_emissao_ctps) {
        this.dt_emissao_ctps = dt_emissao_ctps;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getNum_conta() {
        return num_conta;
    }

    public void setNum_conta(String num_conta) {
        this.num_conta = num_conta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public int getSeguro() {
        return seguro;
    }

    public void setSeguro(int seguro) {
        this.seguro = seguro;
    }

    public int getBaixa() {
        return baixa;
    }

    public void setBaixa(int baixa) {
        this.baixa = baixa;
    }

    public String getData_baixa() {
        return data_baixa;
    }

    public void setData_baixa(String data_baixa) {
        this.data_baixa = data_baixa;
    }

    public String getAnotacoes_diversas() {
        return anotacoes_diversas;
    }

    public void setAnotacoes_diversas(String anotacoes_diversas) {
        this.anotacoes_diversas = anotacoes_diversas;
    }

    public String getHomologacoes() {
        return homologacoes;
    }

    public void setHomologacoes(String homologacoes) {
        this.homologacoes = homologacoes;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public String getBeneficio_social() {
        return beneficio_social;
    }

    public void setBeneficio_social(String beneficio_social) {
        this.beneficio_social = beneficio_social;
    }

    public String getNumero_inscricao() {
        return numero_inscricao;
    }

    public void setNumero_inscricao(String numero_inscricao) {
        this.numero_inscricao = numero_inscricao;
    }

    public String getTipo_residencia() {
        return tipo_residencia;
    }

    public void setTipo_residencia(String tipo_residencia) {
        this.tipo_residencia = tipo_residencia;
    }

    public Float getValor_mensal_residencia() {
        return valor_mensal_residencia;
    }

    public void setValor_mensal_residencia(Float valor_mensal_residencia) {
        this.valor_mensal_residencia = valor_mensal_residencia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg_mae() {
        return rg_mae;
    }

    public void setRg_mae(String rg_mae) {
        this.rg_mae = rg_mae;
    }

    public String getDt_entrevista() {
        return dt_entrevista;
    }

    public void setDt_entrevista(String dt_entrevista) {
        this.dt_entrevista = dt_entrevista;
    }

    public String getFerias_empresa_num() {
        return ferias_empresa_num;
    }

    public void setFerias_empresa_num(String ferias_empresa_num) {
        this.ferias_empresa_num = ferias_empresa_num;
    }

    public String getFerias_periodo_adquirido() {
        return ferias_periodo_adquirido;
    }

    public void setFerias_periodo_adquirido(String ferias_periodo_adquirido) {
        this.ferias_periodo_adquirido = ferias_periodo_adquirido;
    }

    public String getFerias_periodo_gozado() {
        return ferias_periodo_gozado;
    }

    public void setFerias_periodo_gozado(String ferias_periodo_gozado) {
        this.ferias_periodo_gozado = ferias_periodo_gozado;
    }

    public String getCep_importado() {
        return cep_importado;
    }

    public void setCep_importado(String cep_importado) {
        this.cep_importado = cep_importado;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getAnot_pedagogicas() {
        return anot_pedagogicas;
    }

    public void setAnot_pedagogicas(String anot_pedagogicas) {
        this.anot_pedagogicas = anot_pedagogicas;
    }

    public String getAnot_sociais() {
        return anot_sociais;
    }

    public void setAnot_sociais(String anot_sociais) {
        this.anot_sociais = anot_sociais;
    }

    public String getAnot_psicologicas() {
        return anot_psicologicas;
    }

    public void setAnot_psicologicas(String anot_psicologicas) {
        this.anot_psicologicas = anot_psicologicas;
    }

    public String getAnot_administrativas() {
        return anot_administrativas;
    }

    public void setAnot_administrativas(String anot_administrativas) {
        this.anot_administrativas = anot_administrativas;
    }

    public String getReservista() {
        return reservista;
    }

    public void setReservista(String reservista) {
        this.reservista = reservista;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getOrigem_aluno() {
        return origem_aluno;
    }

    public void setOrigem_aluno(int origem_aluno) {
        this.origem_aluno = origem_aluno;
    }

    public int getCargo_aluno() {
        return cargo_aluno;
    }

    public void setCargo_aluno(int cargo_aluno) {
        this.cargo_aluno = cargo_aluno;
    }

    public int getFormacao_basica() {
        return formacao_basica;
    }

    public void setFormacao_basica(int formacao_basica) {
        this.formacao_basica = formacao_basica;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getVisita_empresa() {
        return visita_empresa;
    }

    public void setVisita_empresa(String visita_empresa) {
        this.visita_empresa = visita_empresa;
    }

    public String getData_visita() {
        return data_visita;
    }

    public void setData_visita(String data_visita) {
        this.data_visita = data_visita;
    }

    public String getInicio_curso() {
        return inicio_curso;
    }

    public void setInicio_curso(String inicio_curso) {
        this.inicio_curso = inicio_curso;
    }

    public float getPort1() {
        return port1;
    }

    public void setPort1(float port1) {
        this.port1 = port1;
    }

    public float getMat1() {
        return mat1;
    }

    public void setMat1(float mat1) {
        this.mat1 = mat1;
    }

    public float getRed1() {
        return red1;
    }

    public void setRed1(float red1) {
        this.red1 = red1;
    }

    public float getInf1() {
        return inf1;
    }

    public void setInf1(float inf1) {
        this.inf1 = inf1;
    }

    public float getMd1() {
        return md1;
    }

    public void setMd1(float md1) {
        this.md1 = md1;
    }

    public float getPort2() {
        return port2;
    }

    public void setPort2(float port2) {
        this.port2 = port2;
    }

    public float getMat2() {
        return mat2;
    }

    public void setMat2(float mat2) {
        this.mat2 = mat2;
    }

    public float getNad2() {
        return nad2;
    }

    public void setNad2(float nad2) {
        this.nad2 = nad2;
    }

    public float getNat() {
        return nat;
    }

    public void setNat(float nat) {
        this.nat = nat;
    }

    public float getEd_moral2() {
        return ed_moral2;
    }

    public void setEd_moral2(float ed_moral2) {
        this.ed_moral2 = ed_moral2;
    }

    public float getSqv2() {
        return sqv2;
    }

    public void setSqv2(float sqv2) {
        this.sqv2 = sqv2;
    }

    public float getRed2() {
        return red2;
    }

    public void setRed2(float red2) {
        this.red2 = red2;
    }

    public float getAtitudes2() {
        return atitudes2;
    }

    public void setAtitudes2(float atitudes2) {
        this.atitudes2 = atitudes2;
    }

    public float getAtiv_fis2() {
        return ativ_fis2;
    }

    public void setAtiv_fis2(float ativ_fis2) {
        this.ativ_fis2 = ativ_fis2;
    }

    public float getInf2() {
        return inf2;
    }

    public void setInf2(float inf2) {
        this.inf2 = inf2;
    }

    public float getMd2() {
        return md2;
    }

    public void setMd2(float md2) {
        this.md2 = md2;
    }

    public float getPort3() {
        return port3;
    }

    public void setPort3(float port3) {
        this.port3 = port3;
    }

    public float getMat3() {
        return mat3;
    }

    public void setMat3(float mat3) {
        this.mat3 = mat3;
    }

    public float getNad3() {
        return nad3;
    }

    public void setNad3(float nad3) {
        this.nad3 = nad3;
    }

    public float getNat3() {
        return nat3;
    }

    public void setNat3(float nat3) {
        this.nat3 = nat3;
    }

    public float getEd_moral3() {
        return ed_moral3;
    }

    public void setEd_moral3(float ed_moral3) {
        this.ed_moral3 = ed_moral3;
    }

    public float getSqv3() {
        return sqv3;
    }

    public void setSqv3(float sqv3) {
        this.sqv3 = sqv3;
    }

    public float getRed3() {
        return red3;
    }

    public void setRed3(float red3) {
        this.red3 = red3;
    }

    public float getAtitudes3() {
        return atitudes3;
    }

    public void setAtitudes3(float atitudes3) {
        this.atitudes3 = atitudes3;
    }

    public float getAtiv_fis3() {
        return ativ_fis3;
    }

    public void setAtiv_fis3(float ativ_fis3) {
        this.ativ_fis3 = ativ_fis3;
    }

    public float getInf3() {
        return inf3;
    }

    public void setInf3(float inf3) {
        this.inf3 = inf3;
    }

    public float getMd3() {
        return md3;
    }

    public void setMd3(float md3) {
        this.md3 = md3;
    }

    public String getCamiseta() {
        return camiseta;
    }

    public void setCamiseta(String camiseta) {
        this.camiseta = camiseta;
    }

    public int getTurma_2_fase() {
        return turma_2_fase;
    }

    public void setTurma_2_fase(int turma_2_fase) {
        this.turma_2_fase = turma_2_fase;
    }

    public String getHorario_2_fase() {
        return horario_2_fase;
    }

    public void setHorario_2_fase(String horario_2_fase) {
        this.horario_2_fase = horario_2_fase;
    }

    public String getDia_2_fase() {
        return dia_2_fase;
    }

    public void setDia_2_fase(String dia_2_fase) {
        this.dia_2_fase = dia_2_fase;
    }

    public String getAdv_falta() {
        return adv_falta;
    }

    public void setAdv_falta(String adv_falta) {
        this.adv_falta = adv_falta;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getTurma_inicial() {
        return turma_inicial;
    }

    public void setTurma_inicial(int turma_inicial) {
        this.turma_inicial = turma_inicial;
    }

    public int getSegunda_fase_confirma() {
        return segunda_fase_confirma;
    }

    public void setSegunda_fase_confirma(int segunda_fase_confirma) {
        this.segunda_fase_confirma = segunda_fase_confirma;
    }

    public int getCadastro_irregular() {
        return cadastro_irregular;
    }

    public void setCadastro_irregular(int cadastro_irregular) {
        this.cadastro_irregular = cadastro_irregular;
    }

    public int getEmpresa_virtual() {
        return empresa_virtual;
    }

    public void setEmpresa_virtual(int empresa_virtual) {
        this.empresa_virtual = empresa_virtual;
    }

    public int getCargo_virtual() {
        return cargo_virtual;
    }

    public void setCargo_virtual(int cargo_virtual) {
        this.cargo_virtual = cargo_virtual;
    }

    public String getCep_apoio() {
        return cep_apoio;
    }

    public void setCep_apoio(String cep_apoio) {
        this.cep_apoio = cep_apoio;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getVt() {
        return vt;
    }

    public void setVt(int vt) {
        this.vt = vt;
    }

    public int getCbo() {
        return cbo;
    }

    public void setCbo(int cbo) {
        this.cbo = cbo;
    }

    public Float getInsalubre() {
        return insalubre;
    }

    public void setInsalubre(Float insalubre) {
        this.insalubre = insalubre;
    }

    public int getInsalubre_sn() {
        return insalubre_sn;
    }

    public void setInsalubre_sn(int insalubre_sn) {
        this.insalubre_sn = insalubre_sn;
    }

    public int getTipo_admissao() {
        return tipo_admissao;
    }

    public void setTipo_admissao(int tipo_admissao) {
        this.tipo_admissao = tipo_admissao;
    }

    public int getConvenio_odont() {
        return convenio_odont;
    }

    public void setConvenio_odont(int convenio_odont) {
        this.convenio_odont = convenio_odont;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCabelos() {
        return cabelos;
    }

    public void setCabelos(String cabelos) {
        this.cabelos = cabelos;
    }

    public String getOlhos() {
        return olhos;
    }

    public void setOlhos(String olhos) {
        this.olhos = olhos;
    }

    public String getSinais() {
        return sinais;
    }

    public void setSinais(String sinais) {
        this.sinais = sinais;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getDt_emissao_pis() {
        return dt_emissao_pis;
    }

    public void setDt_emissao_pis(String dt_emissao_pis) {
        this.dt_emissao_pis = dt_emissao_pis;
    }

    public String getDt_Inclusao() {
        return dt_Inclusao;
    }

    public void setDt_Inclusao(String dt_Inclusao) {
        this.dt_Inclusao = dt_Inclusao;
    }

    public String getDt_TerminoContrato() {
        return dt_TerminoContrato;
    }

    public void setDt_TerminoContrato(String dt_TerminoContrato) {
        this.dt_TerminoContrato = dt_TerminoContrato;
    }

    public int getDiaAtivTeorica() {
        return diaAtivTeorica;
    }

    public void setDiaAtivTeorica(int diaAtivTeorica) {
        this.diaAtivTeorica = diaAtivTeorica;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getLocal_aprendizagem() {
        return local_aprendizagem;
    }

    public void setLocal_aprendizagem(int local_aprendizagem) {
        this.local_aprendizagem = local_aprendizagem;
    }

    public String getInt_per1() {
        return int_per1;
    }

    public void setInt_per1(String int_per1) {
        this.int_per1 = int_per1;
    }

    public String getInt_per2() {
        return int_per2;
    }

    public void setInt_per2(String int_per2) {
        this.int_per2 = int_per2;
    }

    public String getInt_per3() {
        return int_per3;
    }

    public void setInt_per3(String int_per3) {
        this.int_per3 = int_per3;
    }

    public int getDias_intensivo() {
        return dias_intensivo;
    }

    public void setDias_intensivo(int dias_intensivo) {
        this.dias_intensivo = dias_intensivo;
    }

    public String getPendente_intensivo() {
        return pendente_intensivo;
    }

    public void setPendente_intensivo(String pendente_intensivo) {
        this.pendente_intensivo = pendente_intensivo;
    }

    public String getVoto_consciente() {
        return voto_consciente;
    }

    public void setVoto_consciente(String voto_consciente) {
        this.voto_consciente = voto_consciente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDiaCurso() {
        return diaCurso;
    }

    public void setDiaCurso(String diaCurso) {
        this.diaCurso = diaCurso;
    }

    public String getDt_termino_curso() {
        return dt_termino_curso;
    }

    public void setDt_termino_curso(String dt_termino_curso) {
        this.dt_termino_curso = dt_termino_curso;
    }

    public String getCarga_horaria_total() {
        return carga_horaria_total;
    }

    public void setCarga_horaria_total(String carga_horaria_total) {
        this.carga_horaria_total = carga_horaria_total;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public String getDt_admissao() {
        return dt_admissao;
    }

    public void setDt_admissao(String dt_admissao) {
        this.dt_admissao = dt_admissao;
    }

    public String getDt_rescisao() {
        return dt_rescisao;
    }

    public void setDt_rescisao(String dt_rescisao) {
        this.dt_rescisao = dt_rescisao;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getHoras_trabalhadas() {
        return horas_trabalhadas;
    }

    public void setHoras_trabalhadas(int horas_trabalhadas) {
        this.horas_trabalhadas = horas_trabalhadas;
    }

    public int getIntensivo() {
        return intensivo;
    }

    public void setIntensivo(int intensivo) {
        this.intensivo = intensivo;
    }

    public Float getNota_cargo_virtual() {
        return nota_cargo_virtual;
    }

    public void setNota_cargo_virtual(Float nota_cargo_virtual) {
        this.nota_cargo_virtual = nota_cargo_virtual;
    }

    public Float getPort4() {
        return port4;
    }

    public void setPort4(Float port4) {
        this.port4 = port4;
    }

    public Float getMat4() {
        return mat4;
    }

    public void setMat4(Float mat4) {
        this.mat4 = mat4;
    }

    public Float getInf4() {
        return inf4;
    }

    public void setInf4(Float inf4) {
        this.inf4 = inf4;
    }

    public Float getRed4() {
        return red4;
    }

    public void setRed4(Float red4) {
        this.red4 = red4;
    }

    public Float getAtitudes4() {
        return atitudes4;
    }

    public void setAtitudes4(Float atitudes4) {
        this.atitudes4 = atitudes4;
    }

    public Float getMd4() {
        return md4;
    }

    public void setMd4(Float md4) {
        this.md4 = md4;
    }

    public Float getPort5() {
        return port5;
    }

    public void setPort5(Float port5) {
        this.port5 = port5;
    }

    public Float getMat5() {
        return mat5;
    }

    public void setMat5(Float mat5) {
        this.mat5 = mat5;
    }

    public Float getInf5() {
        return inf5;
    }

    public void setInf5(Float inf5) {
        this.inf5 = inf5;
    }

    public Float getRed5() {
        return red5;
    }

    public void setRed5(Float red5) {
        this.red5 = red5;
    }

    public Float getAtitudes5() {
        return atitudes5;
    }

    public void setAtitudes5(Float atitudes5) {
        this.atitudes5 = atitudes5;
    }

    public Float getMd5() {
        return md5;
    }

    public void setMd5(Float md5) {
        this.md5 = md5;
    }

   

}
