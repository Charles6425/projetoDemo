package DAO;

import model.ModelUsuario;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles
*/
public class DAOUsuario extends ConexaoMySql {

    /**
    * grava Usuario
    * @param pModelUsuario
    * return int
    */
    public int salvarUsuarioDAO(ModelUsuario pModelUsuario){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO cad_usuario ("
                    + "id,"
                    + "nome,"
                    + "cargo,"
                    + "dt_admissao,"
                    + "dt_demissao,"
                    + "usuario,"
                    + "senha,"
                    + "rep_senha,"
                    + "cpf,"
                    + "rg,"
                    + "dt_emissao_rg,"
                    + "dt_nascimento,"
                    + "ctps,"
                    + "serie_uf,"
                    + "dt_emissao_ctps,"
                    + "pis,"
                    + "banco,"
                    + "agencia,"
                    + "conta,"
                    + "cod_endereco,"
                    + "numero,"
                    + "complemento,"
                    + "tel_1,"
                    + "tel_2,"
                    + "cel_1,"
                    + "cel_2,"
                    + "email,"
                    + "anotacoes_diversas,"
                    + "perm_cad_aluno,"
                    + "perm_cad_empresa,"
                    + "perm_cad_usuario"
                + ") VALUES ("
                    + "'" + pModelUsuario.getId() + "',"
                    + "'" + pModelUsuario.getNome() + "',"
                    + "'" + pModelUsuario.getCargo() + "',"
                    + "'" + pModelUsuario.getDt_admissao() + "',"
                    + "'" + pModelUsuario.getDt_demissao() + "',"
                    + "'" + pModelUsuario.getUsuario() + "',"
                    + "'" + pModelUsuario.getSenha() + "',"
                    + "'" + pModelUsuario.getRep_senha() + "',"
                    + "'" + pModelUsuario.getCpf() + "',"
                    + "'" + pModelUsuario.getRg() + "',"
                    + "'" + pModelUsuario.getDt_emissao_rg() + "',"
                    + "'" + pModelUsuario.getDt_nascimento() + "',"
                    + "'" + pModelUsuario.getCtps() + "',"
                    + "'" + pModelUsuario.getSerie_uf() + "',"
                    + "'" + pModelUsuario.getDt_emissao_ctps() + "',"
                    + "'" + pModelUsuario.getPis() + "',"
                    + "'" + pModelUsuario.getBanco() + "',"
                    + "'" + pModelUsuario.getAgencia() + "',"
                    + "'" + pModelUsuario.getConta() + "',"
                    + "'" + pModelUsuario.getCod_endereco() + "',"
                    + "'" + pModelUsuario.getNumero() + "',"
                    + "'" + pModelUsuario.getComplemento() + "',"
                    + "'" + pModelUsuario.getTel_1() + "',"
                    + "'" + pModelUsuario.getTel_2() + "',"
                    + "'" + pModelUsuario.getCel_1() + "',"
                    + "'" + pModelUsuario.getCel_2() + "',"
                    + "'" + pModelUsuario.getEmail() + "',"
                    + "'" + pModelUsuario.getAnotacoes_diversas() + "',"
                    + "'" + pModelUsuario.getPerm_cad_aluno() + "',"
                    + "'" + pModelUsuario.getPerm_cad_empresa() + "',"
                    + "'" + pModelUsuario.getPerm_cad_usuario() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera Usuario
    * @param pId
    * return ModelUsuario
    */
    public ModelUsuario getUsuarioDAO(int pId){
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "nome,"
                    + "cargo,"
                    + "dt_admissao,"
                    + "dt_demissao,"
                    + "usuario,"
                    + "senha,"
                    + "rep_senha,"
                    + "cpf,"
                    + "rg,"
                    + "dt_emissao_rg,"
                    + "dt_nascimento,"
                    + "ctps,"
                    + "serie_uf,"
                    + "dt_emissao_ctps,"
                    + "pis,"
                    + "banco,"
                    + "agencia,"
                    + "conta,"
                    + "cod_endereco,"
                    + "numero,"
                    + "complemento,"
                    + "tel_1,"
                    + "tel_2,"
                    + "cel_1,"
                    + "cel_2,"
                    + "email,"
                    + "anotacoes_diversas,"
                    + "perm_cad_aluno,"
                    + "perm_cad_empresa,"
                    + "perm_cad_usuario"
                 + " FROM"
                     + " cad_usuario"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUsuario.setId(this.getResultSet().getInt(1));
                modelUsuario.setNome(this.getResultSet().getString(2));
                modelUsuario.setCargo(this.getResultSet().getString(3));
                modelUsuario.setDt_admissao(this.getResultSet().getDate(4));
                modelUsuario.setDt_demissao(this.getResultSet().getDate(5));
                modelUsuario.setUsuario(this.getResultSet().getString(6));
                modelUsuario.setSenha(this.getResultSet().getString(7));
                modelUsuario.setRep_senha(this.getResultSet().getString(8));
                modelUsuario.setCpf(this.getResultSet().getString(9));
                modelUsuario.setRg(this.getResultSet().getString(10));
                modelUsuario.setDt_emissao_rg(this.getResultSet().getDate(11));
                modelUsuario.setDt_nascimento(this.getResultSet().getDate(12));
                modelUsuario.setCtps(this.getResultSet().getString(13));
                modelUsuario.setSerie_uf(this.getResultSet().getString(14));
                modelUsuario.setDt_emissao_ctps(this.getResultSet().getDate(15));
                modelUsuario.setPis(this.getResultSet().getString(16));
                modelUsuario.setBanco(this.getResultSet().getString(17));
                modelUsuario.setAgencia(this.getResultSet().getString(18));
                modelUsuario.setConta(this.getResultSet().getString(19));
                modelUsuario.setCod_endereco(this.getResultSet().getInt(20));
                modelUsuario.setNumero(this.getResultSet().getString(21));
                modelUsuario.setComplemento(this.getResultSet().getString(22));
                modelUsuario.setTel_1(this.getResultSet().getString(23));
                modelUsuario.setTel_2(this.getResultSet().getString(24));
                modelUsuario.setCel_1(this.getResultSet().getString(25));
                modelUsuario.setCel_2(this.getResultSet().getString(26));
                modelUsuario.setEmail(this.getResultSet().getString(27));
                modelUsuario.setAnotacoes_diversas(this.getResultSet().getString(28));
                modelUsuario.setPerm_cad_aluno(this.getResultSet().getInt(29));
                modelUsuario.setPerm_cad_empresa(this.getResultSet().getInt(30));
                modelUsuario.setPerm_cad_usuario(this.getResultSet().getInt(31));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelUsuario;
    }
    /**
    * recupera Usuario
    * @param pId
    * return ModelUsuario
    */
    public ModelUsuario getUsuarioDAO(String pUsuario){
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "nome,"
                    + "cargo,"
                    + "dt_admissao,"
                    + "dt_demissao,"
                    + "usuario,"
                    + "senha,"
                    + "rep_senha,"
                    + "cpf,"
                    + "rg,"
                    + "dt_emissao_rg,"
                    + "dt_nascimento,"
                    + "ctps,"
                    + "serie_uf,"
                    + "dt_emissao_ctps,"
                    + "pis,"
                    + "banco,"
                    + "agencia,"
                    + "conta,"
                    + "cod_endereco,"
                    + "numero,"
                    + "complemento,"
                    + "tel_1,"
                    + "tel_2,"
                    + "cel_1,"
                    + "cel_2,"
                    + "email,"
                    + "anotacoes_diversas,"
                    + "perm_cad_aluno,"
                    + "perm_cad_empresa,"
                    + "perm_cad_usuario"
                 + " FROM"
                     + " cad_usuario"
                 + " WHERE"
                     + " usuario = '" + pUsuario + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUsuario.setId(this.getResultSet().getInt(1));
                modelUsuario.setNome(this.getResultSet().getString(2));
                modelUsuario.setCargo(this.getResultSet().getString(3));
                modelUsuario.setDt_admissao(this.getResultSet().getDate(4));
                modelUsuario.setDt_demissao(this.getResultSet().getDate(5));
                modelUsuario.setUsuario(this.getResultSet().getString(6));
                modelUsuario.setSenha(this.getResultSet().getString(7));
                modelUsuario.setRep_senha(this.getResultSet().getString(8));
                modelUsuario.setCpf(this.getResultSet().getString(9));
                modelUsuario.setRg(this.getResultSet().getString(10));
                modelUsuario.setDt_emissao_rg(this.getResultSet().getDate(11));
                modelUsuario.setDt_nascimento(this.getResultSet().getDate(12));
                modelUsuario.setCtps(this.getResultSet().getString(13));
                modelUsuario.setSerie_uf(this.getResultSet().getString(14));
                modelUsuario.setDt_emissao_ctps(this.getResultSet().getDate(15));
                modelUsuario.setPis(this.getResultSet().getString(16));
                modelUsuario.setBanco(this.getResultSet().getString(17));
                modelUsuario.setAgencia(this.getResultSet().getString(18));
                modelUsuario.setConta(this.getResultSet().getString(19));
                modelUsuario.setCod_endereco(this.getResultSet().getInt(20));
                modelUsuario.setNumero(this.getResultSet().getString(21));
                modelUsuario.setComplemento(this.getResultSet().getString(22));
                modelUsuario.setTel_1(this.getResultSet().getString(23));
                modelUsuario.setTel_2(this.getResultSet().getString(24));
                modelUsuario.setCel_1(this.getResultSet().getString(25));
                modelUsuario.setCel_2(this.getResultSet().getString(26));
                modelUsuario.setEmail(this.getResultSet().getString(27));
                modelUsuario.setAnotacoes_diversas(this.getResultSet().getString(28));
                modelUsuario.setPerm_cad_aluno(this.getResultSet().getInt(29));
                modelUsuario.setPerm_cad_empresa(this.getResultSet().getInt(30));
                modelUsuario.setPerm_cad_usuario(this.getResultSet().getInt(31));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelUsuario;
    }

    /**
     * recupera Usuario
     *
     * @param pCodigo return ModelUsuario
     */
    public boolean getUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id,"
                    + "nome,"
                    + "usuario,"
                    + "senha"

                    + " FROM"
                    + " cad_usuario"
                    + " WHERE"
                    + " usuario = '" + pModelUsuario.getUsuario()+ "' AND senha = '" + pModelUsuario.getSenha() + "' "
                    + ";"
            );

            if (getResultSet().next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
    /**
    * recupera uma lista de Usuario
        * return ArrayList
    */
    public ArrayList<ModelUsuario> getListaUsuarioDAO(){
        ArrayList<ModelUsuario> listamodelUsuario = new ArrayList();
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "nome,"
                    + "cargo,"
                    + "dt_admissao,"
                    + "dt_demissao,"
                    + "usuario,"
                    + "senha,"
                    + "rep_senha,"
                    + "cpf,"
                    + "rg,"
                    + "dt_emissao_rg,"
                    + "dt_nascimento,"
                    + "ctps,"
                    + "serie_uf,"
                    + "dt_emissao_ctps,"
                    + "pis,"
                    + "banco,"
                    + "agencia,"
                    + "conta,"
                    + "cod_endereco,"
                    + "numero,"
                    + "complemento,"
                    + "tel_1,"
                    + "tel_2,"
                    + "cel_1,"
                    + "cel_2,"
                    + "email,"
                    + "anotacoes_diversas,"
                    + "perm_cad_aluno,"
                    + "perm_cad_empresa,"
                    + "perm_cad_usuario"
                 + " FROM"
                     + " cad_usuario"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUsuario = new ModelUsuario();
                modelUsuario.setId(this.getResultSet().getInt(1));
                modelUsuario.setNome(this.getResultSet().getString(2));
                modelUsuario.setCargo(this.getResultSet().getString(3));
                modelUsuario.setDt_admissao(this.getResultSet().getDate(4));
                modelUsuario.setDt_demissao(this.getResultSet().getDate(5));
                modelUsuario.setUsuario(this.getResultSet().getString(6));
                modelUsuario.setSenha(this.getResultSet().getString(7));
                modelUsuario.setRep_senha(this.getResultSet().getString(8));
                modelUsuario.setCpf(this.getResultSet().getString(9));
                modelUsuario.setRg(this.getResultSet().getString(10));
                modelUsuario.setDt_emissao_rg(this.getResultSet().getDate(11));
                modelUsuario.setDt_nascimento(this.getResultSet().getDate(12));
                modelUsuario.setCtps(this.getResultSet().getString(13));
                modelUsuario.setSerie_uf(this.getResultSet().getString(14));
                modelUsuario.setDt_emissao_ctps(this.getResultSet().getDate(15));
                modelUsuario.setPis(this.getResultSet().getString(16));
                modelUsuario.setBanco(this.getResultSet().getString(17));
                modelUsuario.setAgencia(this.getResultSet().getString(18));
                modelUsuario.setConta(this.getResultSet().getString(19));
                modelUsuario.setCod_endereco(this.getResultSet().getInt(20));
                modelUsuario.setNumero(this.getResultSet().getString(21));
                modelUsuario.setComplemento(this.getResultSet().getString(22));
                modelUsuario.setTel_1(this.getResultSet().getString(23));
                modelUsuario.setTel_2(this.getResultSet().getString(24));
                modelUsuario.setCel_1(this.getResultSet().getString(25));
                modelUsuario.setCel_2(this.getResultSet().getString(26));
                modelUsuario.setEmail(this.getResultSet().getString(27));
                modelUsuario.setAnotacoes_diversas(this.getResultSet().getString(28));
                modelUsuario.setPerm_cad_aluno(this.getResultSet().getInt(29));
                modelUsuario.setPerm_cad_empresa(this.getResultSet().getInt(30));
                modelUsuario.setPerm_cad_usuario(this.getResultSet().getInt(31));
                listamodelUsuario.add(modelUsuario);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelUsuario;
    }

    /**
    * atualiza Usuario
    * @param pModelUsuario
    * return boolean
    */
    public boolean atualizarUsuarioDAO(ModelUsuario pModelUsuario){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE cad_usuario SET "
                    + "id = '" + pModelUsuario.getId() + "',"
                    + "nome = '" + pModelUsuario.getNome() + "',"
                    + "cargo = '" + pModelUsuario.getCargo() + "',"
                    + "dt_admissao = '" + pModelUsuario.getDt_admissao() + "',"
                    + "dt_demissao = '" + pModelUsuario.getDt_demissao() + "',"
                    + "usuario = '" + pModelUsuario.getUsuario() + "',"
                    + "senha = '" + pModelUsuario.getSenha() + "',"
                    + "rep_senha = '" + pModelUsuario.getRep_senha() + "',"
                    + "cpf = '" + pModelUsuario.getCpf() + "',"
                    + "rg = '" + pModelUsuario.getRg() + "',"
                    + "dt_emissao_rg = '" + pModelUsuario.getDt_emissao_rg() + "',"
                    + "dt_nascimento = '" + pModelUsuario.getDt_nascimento() + "',"
                    + "ctps = '" + pModelUsuario.getCtps() + "',"
                    + "serie_uf = '" + pModelUsuario.getSerie_uf() + "',"
                    + "dt_emissao_ctps = '" + pModelUsuario.getDt_emissao_ctps() + "',"
                    + "pis = '" + pModelUsuario.getPis() + "',"
                    + "banco = '" + pModelUsuario.getBanco() + "',"
                    + "agencia = '" + pModelUsuario.getAgencia() + "',"
                    + "conta = '" + pModelUsuario.getConta() + "',"
                    + "cod_endereco = '" + pModelUsuario.getCod_endereco() + "',"
                    + "numero = '" + pModelUsuario.getNumero() + "',"
                    + "complemento = '" + pModelUsuario.getComplemento() + "',"
                    + "tel_1 = '" + pModelUsuario.getTel_1() + "',"
                    + "tel_2 = '" + pModelUsuario.getTel_2() + "',"
                    + "cel_1 = '" + pModelUsuario.getCel_1() + "',"
                    + "cel_2 = '" + pModelUsuario.getCel_2() + "',"
                    + "email = '" + pModelUsuario.getEmail() + "',"
                    + "anotacoes_diversas = '" + pModelUsuario.getAnotacoes_diversas() + "',"
                    + "perm_cad_aluno = '" + pModelUsuario.getPerm_cad_aluno() + "',"
                    + "perm_cad_empresa = '" + pModelUsuario.getPerm_cad_empresa() + "',"
                    + "perm_cad_usuario = '" + pModelUsuario.getPerm_cad_usuario() + "'"
                + " WHERE "
                    + "id = '" + pModelUsuario.getId() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui Usuario
    * @param pId
    * return boolean
    */
    public boolean excluirUsuarioDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM cad_usuario "
                + " WHERE "
                    + "id = '" + pId + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}