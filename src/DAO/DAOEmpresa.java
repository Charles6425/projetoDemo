package DAO;

import model.ModelEmpresa;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles
*/
public class DAOEmpresa extends ConexaoMySql {

    /**
    * grava Empresa
    * @param pModelEmpresa
    * return int
    */
    public int salvarEmpresaDAO(ModelEmpresa pModelEmpresa){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO cad_empresa ("
                    + "id,"
                    + "razao,"
                    + "nome_fantasia,"
                    + "cnpj,"
                    + "ie,"
                    + "contato,"
                    + "contato_cargo,"
                    + "dt_abertura,"
                    + "dt_situacao_cadastral,"
                    + "cnae,"
                    + "num_da_conta,"
                    + "agencia,"
                    + "banco,"
                    + "cod_endereco,"
                    + "numero,"
                    + "complemento,"
                    + "tel1,"
                    + "tel2,"
                    + "tel3,"
                    + "tel4,"
                    + "contato_tel,"
                    + "email,"
                    + "codigo_empresa,"
                    + "unidade,"
                    
                + ") VALUES ("
                    + "'" + pModelEmpresa.getId() + "',"
                    + "'" + pModelEmpresa.getRazao() + "',"
                    + "'" + pModelEmpresa.getNome_fantasia() + "',"
                    + "'" + pModelEmpresa.getCnpj() + "',"
                    + "'" + pModelEmpresa.getIe() + "',"
                    + "'" + pModelEmpresa.getContato() + "',"
                    + "'" + pModelEmpresa.getContato_cargo() + "',"
                    + "'" + pModelEmpresa.getDt_abertura() + "',"
                    + "'" + pModelEmpresa.getDt_situacao_cadastral() + "',"
                    + "'" + pModelEmpresa.getCnae() + "',"
                    + "'" + pModelEmpresa.getNum_da_conta() + "',"
                    + "'" + pModelEmpresa.getAgencia() + "',"
                    + "'" + pModelEmpresa.getBanco() + "',"
                    + "'" + pModelEmpresa.getCod_endereco() + "',"
                    + "'" + pModelEmpresa.getNumero() + "',"
                    + "'" + pModelEmpresa.getComplemento() + "',"
                    + "'" + pModelEmpresa.getTel1() + "',"
                    + "'" + pModelEmpresa.getTel2() + "',"
                    + "'" + pModelEmpresa.getTel3() + "',"
                    + "'" + pModelEmpresa.getTel4() + "',"
                    + "'" + pModelEmpresa.getContato_tel() + "',"
                    + "'" + pModelEmpresa.getEmail() + "',"
                    + "'" + pModelEmpresa.getCodigoEmpresa()+ "',"
                    + "'" + pModelEmpresa.getUnidade()+ "'"
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
    * recupera Empresa
    * @param pId
    * return ModelEmpresa
    */
    public ModelEmpresa getEmpresaDAO(int pId){
        ModelEmpresa modelEmpresa = new ModelEmpresa();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "razao,"
                    + "nome_fantasia,"
                    + "cnpj,"
                    + "ie,"
                    + "contato,"
                    + "contato_cargo,"
                    + "dt_abertura,"
                    + "dt_situacao_cadastral,"
                    + "cnae,"
                    + "num_da_conta,"
                    + "agencia,"
                    + "banco,"
                    + "cod_endereco,"
                    + "numero,"
                    + "complemento,"
                    + "tel1,"
                    + "tel2,"
                    + "tel3,"
                    + "tel4,"
                    + "contato_tel,"
                    + "email,"
                    + "codigo_empresa,"
                    + "unidade,"
                    + "cep_auxiliar"
                 + " FROM"
                     + " cad_empresa"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelEmpresa.setId(this.getResultSet().getInt(1));
                modelEmpresa.setRazao(this.getResultSet().getString(2));
                modelEmpresa.setNome_fantasia(this.getResultSet().getString(3));
                modelEmpresa.setCnpj(this.getResultSet().getString(4));
                modelEmpresa.setIe(this.getResultSet().getString(5));
                modelEmpresa.setContato(this.getResultSet().getString(6));
                modelEmpresa.setContato_cargo(this.getResultSet().getString(7));
                modelEmpresa.setDt_abertura(this.getResultSet().getString(8));
                modelEmpresa.setDt_situacao_cadastral(this.getResultSet().getString(9));
                modelEmpresa.setCnae(this.getResultSet().getString(10));
                modelEmpresa.setNum_da_conta(this.getResultSet().getString(11));
                modelEmpresa.setAgencia(this.getResultSet().getString(12));
                modelEmpresa.setBanco(this.getResultSet().getString(13));
                modelEmpresa.setCod_endereco(this.getResultSet().getInt(14));
                modelEmpresa.setNumero(this.getResultSet().getString(15));
                modelEmpresa.setComplemento(this.getResultSet().getString(16));
                modelEmpresa.setTel1(this.getResultSet().getString(17));
                modelEmpresa.setTel2(this.getResultSet().getString(18));
                modelEmpresa.setTel3(this.getResultSet().getString(19));
                modelEmpresa.setTel4(this.getResultSet().getString(20));
                modelEmpresa.setContato_tel(this.getResultSet().getString(21));
                modelEmpresa.setEmail(this.getResultSet().getString(22));
                modelEmpresa.setCodigoEmpresa(this.getResultSet().getString(23));
                modelEmpresa.setUnidade(this.getResultSet().getInt(24));
                modelEmpresa.setCep_auxiliar(this.getResultSet().getString(25));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelEmpresa;
    }

    /**
    * recupera uma lista de Empresa
        * return ArrayList
    */
    public ArrayList<ModelEmpresa> getListaEmpresaDAO(){
        ArrayList<ModelEmpresa> listamodelEmpresa = new ArrayList();
        ModelEmpresa modelEmpresa = new ModelEmpresa();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "razao,"
                    + "nome_fantasia,"
                    + "cnpj,"
                    + "ie,"
                    + "contato,"
                    + "contato_cargo,"
                    + "dt_abertura,"
                    + "dt_situacao_cadastral,"
                    + "cnae,"
                    + "num_da_conta,"
                    + "agencia,"
                    + "banco,"
                    + "cod_endereco,"
                    + "numero,"
                    + "complemento,"
                    + "tel1,"
                    + "tel2,"
                    + "tel3,"
                    + "tel4,"
                    + "contato_tel,"
                    + "email,"
                    + "codigo_empresa,"
                    + "unidade"
                 + " FROM"
                     + " cad_empresa"
                + ";"
            );

            while(this.getResultSet().next()){
                modelEmpresa = new ModelEmpresa();
                modelEmpresa.setId(this.getResultSet().getInt(1));
                modelEmpresa.setRazao(this.getResultSet().getString(2));
                modelEmpresa.setNome_fantasia(this.getResultSet().getString(3));
                modelEmpresa.setCnpj(this.getResultSet().getString(4));
                modelEmpresa.setIe(this.getResultSet().getString(5));
                modelEmpresa.setContato(this.getResultSet().getString(6));
                modelEmpresa.setContato_cargo(this.getResultSet().getString(7));
                modelEmpresa.setDt_abertura(this.getResultSet().getString(8));
                modelEmpresa.setDt_situacao_cadastral(this.getResultSet().getString(9));
                modelEmpresa.setCnae(this.getResultSet().getString(10));
                modelEmpresa.setNum_da_conta(this.getResultSet().getString(11));
                modelEmpresa.setAgencia(this.getResultSet().getString(12));
                modelEmpresa.setBanco(this.getResultSet().getString(13));
                modelEmpresa.setCod_endereco(this.getResultSet().getInt(14));
                modelEmpresa.setNumero(this.getResultSet().getString(15));
                modelEmpresa.setComplemento(this.getResultSet().getString(16));
                modelEmpresa.setTel1(this.getResultSet().getString(17));
                modelEmpresa.setTel2(this.getResultSet().getString(18));
                modelEmpresa.setTel3(this.getResultSet().getString(19));
                modelEmpresa.setTel4(this.getResultSet().getString(20));
                modelEmpresa.setContato_tel(this.getResultSet().getString(21));
                modelEmpresa.setEmail(this.getResultSet().getString(22));
                modelEmpresa.setCodigoEmpresa(this.getResultSet().getString(23));
                modelEmpresa.setUnidade(this.getResultSet().getInt(24));
                listamodelEmpresa.add(modelEmpresa);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelEmpresa;
    }

    /**
    * atualiza Empresa
    * @param pModelEmpresa
    * return boolean
    */
    public boolean atualizarEmpresaDAO(ModelEmpresa pModelEmpresa){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE cad_empresa SET "
                    + "id = '" + pModelEmpresa.getId() + "',"
                    + "razao = '" + pModelEmpresa.getRazao() + "',"
                    + "nome_fantasia = '" + pModelEmpresa.getNome_fantasia() + "',"
                    + "cnpj = '" + pModelEmpresa.getCnpj() + "',"
                    + "ie = '" + pModelEmpresa.getIe() + "',"
                    + "contato = '" + pModelEmpresa.getContato() + "',"
                    + "contato_cargo = '" + pModelEmpresa.getContato_cargo() + "',"
                    + "dt_abertura = '" + pModelEmpresa.getDt_abertura() + "',"
                    + "dt_situacao_cadastral = '" + pModelEmpresa.getDt_situacao_cadastral() + "',"
                    + "cnae = '" + pModelEmpresa.getCnae() + "',"
                    + "num_da_conta = '" + pModelEmpresa.getNum_da_conta() + "',"
                    + "agencia = '" + pModelEmpresa.getAgencia() + "',"
                    + "banco = '" + pModelEmpresa.getBanco() + "',"
                    + "cod_endereco = '" + pModelEmpresa.getCod_endereco() + "',"
                    + "numero = '" + pModelEmpresa.getNumero() + "',"
                    + "complemento = '" + pModelEmpresa.getComplemento() + "',"
                    + "tel1 = '" + pModelEmpresa.getTel1() + "',"
                    + "tel2 = '" + pModelEmpresa.getTel2() + "',"
                    + "tel3 = '" + pModelEmpresa.getTel3() + "',"
                    + "tel4 = '" + pModelEmpresa.getTel4() + "',"
                    + "contato_tel = '" + pModelEmpresa.getContato_tel() + "',"
                    + "email = '" + pModelEmpresa.getEmail() + "',"
                    + "codigo_empresa = '" + pModelEmpresa.getCodigoEmpresa()+ "',"
                    + "unidade = '" + pModelEmpresa.getUnidade()+ "'"
                + " WHERE "
                    + "id = '" + pModelEmpresa.getId() + "'"
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
    * exclui Empresa
    * @param pId
    * return boolean
    */
    public boolean excluirEmpresaDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM cad_empresa "
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