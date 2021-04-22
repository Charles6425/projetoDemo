package DAO;

import model.ModelCadEndereco;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author Charles Müller
 */
public class DAOCadEndereco extends ConexaoMySql {

    /**
     * grava CadEndereco
     *
     * @param pModelCadEndereco return int
     */
    public int salvarCadEnderecoDAO(ModelCadEndereco pModelCadEndereco) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO cad_endereco ("
                    + "end_codigo,"
                    + "end_cep,"
                    + "end_logradouro,"
                    + "end_bairro,"
                    + "end_cidade,"
                    + "end_uf,"
                    + "end_cod_ibge"
                    + ") VALUES ("
                    + "'" + pModelCadEndereco.getEnd_codigo() + "',"
                    + "'" + pModelCadEndereco.getEnd_cep() + "',"
                    + "'" + pModelCadEndereco.getEnd_logradouro() + "',"
                    + "'" + pModelCadEndereco.getEnd_bairro() + "',"
                    + "'" + pModelCadEndereco.getEnd_cidade() + "',"
                    + "'" + pModelCadEndereco.getEnd_uf() + "',"
                    + "'" + pModelCadEndereco.getEnd_cod_ibge() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera CadEndereco
     *
     * @param pEnd_cep return ModelCadEndereco
     */
    public ModelCadEndereco getCadEnderecoDAO(String pEnd_cep) {
        ModelCadEndereco modelCadEndereco = new ModelCadEndereco();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "end_codigo,"
                    + "end_cep,"
                    + "end_logradouro,"
                    + "end_bairro,"
                    + "end_cidade,"
                    + "end_uf,"
                    + "end_cod_ibge"
                    + " FROM"
                    + " cad_endereco"
                    + " WHERE"
                    + " end_cep = '" + pEnd_cep + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCadEndereco.setEnd_codigo(this.getResultSet().getInt(1));
                modelCadEndereco.setEnd_cep(this.getResultSet().getString(2));
                modelCadEndereco.setEnd_logradouro(this.getResultSet().getString(3));
                modelCadEndereco.setEnd_bairro(this.getResultSet().getString(4));
                modelCadEndereco.setEnd_cidade(this.getResultSet().getString(5));
                modelCadEndereco.setEnd_uf(this.getResultSet().getString(6));
                modelCadEndereco.setEnd_cod_ibge(this.getResultSet().getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCadEndereco;
    }

    /**
     * recupera CadEndereco
     *
     * @param pEnd_cep return ModelCadEndereco
     */
    public ModelCadEndereco getCadEnderecoCodDAO(int pEnd_codigo) {
        ModelCadEndereco modelCadEndereco = new ModelCadEndereco();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "end_codigo,"
                    + "end_cep,"
                    + "end_logradouro,"
                    + "end_bairro,"
                    + "end_cidade,"
                    + "end_uf,"
                    + "end_cod_ibge"
                    + " FROM"
                    + " cad_endereco"
                    + " WHERE"
                    + " end_codigo = '" + pEnd_codigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCadEndereco.setEnd_codigo(this.getResultSet().getInt(1));
                modelCadEndereco.setEnd_cep(this.getResultSet().getString(2));
                modelCadEndereco.setEnd_logradouro(this.getResultSet().getString(3));
                modelCadEndereco.setEnd_bairro(this.getResultSet().getString(4));
                modelCadEndereco.setEnd_cidade(this.getResultSet().getString(5));
                modelCadEndereco.setEnd_uf(this.getResultSet().getString(6));
                modelCadEndereco.setEnd_cod_ibge(this.getResultSet().getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCadEndereco;
    }

    /**
     * recupera uma lista de CadEndereco return ArrayList
     */
    public ArrayList<ModelCadEndereco> getListaCadEnderecoDAO(String pCep) {
        ArrayList<ModelCadEndereco> listamodelCadEndereco = new ArrayList();
        ModelCadEndereco modelCadEndereco = new ModelCadEndereco();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "end_cep,"
                    + "end_logradouro,"
                    + "end_bairro,"
                    + "end_cidade,"
                    + "end_uf,"
                    + "end_cod_ibge"
                    + " FROM"
                    + " cad_endereco"
                    + " where end_cep ='" + pCep + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCadEndereco = new ModelCadEndereco();
                modelCadEndereco.setEnd_cep(this.getResultSet().getString(1));
                modelCadEndereco.setEnd_logradouro(this.getResultSet().getString(2));
                modelCadEndereco.setEnd_bairro(this.getResultSet().getString(3));
                modelCadEndereco.setEnd_cidade(this.getResultSet().getString(4));
                modelCadEndereco.setEnd_uf(this.getResultSet().getString(5));
                modelCadEndereco.setEnd_cod_ibge(this.getResultSet().getString(6));
                listamodelCadEndereco.add(modelCadEndereco);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelCadEndereco;
    }
    /**
     * recupera uma lista de CadEndereco return ArrayList
     */
    public ArrayList<ModelCadEndereco> getListaCadBairroDAO(String pBairro) {
        ArrayList<ModelCadEndereco> listamodelCadEndereco = new ArrayList();
        ModelCadEndereco modelCadEndereco = new ModelCadEndereco();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "end_cep,"
                    + "end_logradouro,"
                    + "end_bairro,"
                    + "end_cidade,"
                    + "end_uf,"
                    + "end_cod_ibge"
                    + " FROM"
                    + " cad_endereco"
                    + " where end_bairro ='" + pBairro + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCadEndereco = new ModelCadEndereco();
                modelCadEndereco.setEnd_cep(this.getResultSet().getString(1));
                modelCadEndereco.setEnd_logradouro(this.getResultSet().getString(2));
                modelCadEndereco.setEnd_bairro(this.getResultSet().getString(3));
                modelCadEndereco.setEnd_cidade(this.getResultSet().getString(4));
                modelCadEndereco.setEnd_uf(this.getResultSet().getString(5));
                modelCadEndereco.setEnd_cod_ibge(this.getResultSet().getString(6));
                listamodelCadEndereco.add(modelCadEndereco);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelCadEndereco;
    }

    public ArrayList<ModelCadEndereco> getListaCadEnderecoDAO() {
        ArrayList<ModelCadEndereco> listamodelCadEndereco = new ArrayList();
        ModelCadEndereco modelCadEndereco = new ModelCadEndereco();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "end_bairro "
                    + " FROM"
                    + " cad_endereco"
                    + " group by end_bairro"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCadEndereco = new ModelCadEndereco();
                modelCadEndereco.setEnd_bairro(this.getResultSet().getString(1));
                listamodelCadEndereco.add(modelCadEndereco);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelCadEndereco;
    }

    /**
     * atualiza CadEndereco
     *
     * @param pModelCadEndereco return boolean
     */
    public boolean atualizarCadEnderecoDAO(ModelCadEndereco pModelCadEndereco) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE cad_endereco SET "
                    + "end_cep = '" + pModelCadEndereco.getEnd_cep() + "',"
                    + "end_logradouro = '" + pModelCadEndereco.getEnd_logradouro() + "',"
                    + "end_bairro = '" + pModelCadEndereco.getEnd_bairro() + "',"
                    + "end_cidade = '" + pModelCadEndereco.getEnd_cidade() + "',"
                    + "end_uf = '" + pModelCadEndereco.getEnd_uf() + "',"
                    + "end_cod_ibge = '" + pModelCadEndereco.getEnd_cod_ibge() + "'"
                    + " WHERE "
                    + "end_cep = '" + pModelCadEndereco.getEnd_cep() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui CadEndereco
     *
     * @param pEnd_cep return boolean
     */
    public boolean excluirCadEnderecoDAO(String pEnd_cep) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM cad_endereco "
                    + " WHERE "
                    + "end_cep = '" + pEnd_cep + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
