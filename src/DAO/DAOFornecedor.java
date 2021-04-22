package DAO;

import conexoes.ConexaoMySql;
import model.ModelFornecedor;
import java.util.ArrayList;

/**
 * @author BLSoft www.Blsoft.com.br Venda de software e código fonte
 */
public class DAOFornecedor extends ConexaoMySql {

    /**
     * grava Fornecedor
     *
     * @param pModelFornecedor return int
     */
    public int salvarFornecedorDAO(ModelFornecedor pModelFornecedor) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO fornecedores ("
                    + "nome,"
                    + "endereco,"
                    + "telefone,"
                    + "numero,"
                    + "cnpj,"
                    + "email,"
                    + "contato"
                    + ") VALUES ("
                    + "'" + pModelFornecedor.getNome() + "',"
                    + "'" + pModelFornecedor.getEndereco() + "',"
                    + "'" + pModelFornecedor.getTelefone() + "',"
                    + "'" + pModelFornecedor.getNumero() + "',"
                    + "'" + pModelFornecedor.getCnpj() + "',"
                    + "'" + pModelFornecedor.getEmail() + "',"
                    + "'" + pModelFornecedor.getContato() + "'"
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
     * recupera Fornecedor
     *
     * @param pCodigo return ModelFornecedor
     */
    public ModelFornecedor getFornecedorDAO(int pCodigo) {
        ModelFornecedor modelFornecedor = new ModelFornecedor();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "endereco,"
                    + "telefone,"
                    + "numero,"
                    + "cnpj,"
                    + "email,"
                    + "contato"
                    + " FROM"
                    + " fornecedores"
                    + " WHERE"
                    + " codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFornecedor.setCodigo(this.getResultSet().getInt(1));
                modelFornecedor.setNome(this.getResultSet().getString(2));
                modelFornecedor.setEndereco(this.getResultSet().getInt(3));
                modelFornecedor.setTelefone(this.getResultSet().getString(4));
                modelFornecedor.setNumero(this.getResultSet().getString(5));
                modelFornecedor.setCnpj(this.getResultSet().getString(6));
                modelFornecedor.setEmail(this.getResultSet().getString(7));
                modelFornecedor.setContato(this.getResultSet().getString(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelFornecedor;
    }

    /**
     * recupera Fornecedor
     *
     * @param pNome return ModelFornecedor
     */
    public ModelFornecedor getFornecedorDAO(String pNome) {
        ModelFornecedor modelFornecedor = new ModelFornecedor();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "endereco,"
                    + "telefone,"
                    + "numero,"
                    + "cnpj,"
                    + "email,"
                    + "contato"
                    + " FROM"
                    + " fornecedores"
                    + " WHERE"
                    + " nome = '" + pNome + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFornecedor.setCodigo(this.getResultSet().getInt(1));
                modelFornecedor.setNome(this.getResultSet().getString(2));
                modelFornecedor.setEndereco(this.getResultSet().getInt(3));
                modelFornecedor.setTelefone(this.getResultSet().getString(4));
                modelFornecedor.setNumero(this.getResultSet().getString(5));
                modelFornecedor.setCnpj(this.getResultSet().getString(6));
                modelFornecedor.setEmail(this.getResultSet().getString(7));
                modelFornecedor.setContato(this.getResultSet().getString(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelFornecedor;
    }

    /**
     * recupera uma lista de Fornecedor return ArrayList
     */
    public ArrayList<ModelFornecedor> getListaFornecedorDAO() {
        ArrayList<ModelFornecedor> listamodelFornecedor = new ArrayList();
        ModelFornecedor modelFornecedor = new ModelFornecedor();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "endereco,"
                    + "telefone,"
                    + "numero,"
                    + "cnpj,"
                    + "email,"
                    + "contato"
                    + " FROM"
                    + " fornecedores"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFornecedor = new ModelFornecedor();
                modelFornecedor.setCodigo(this.getResultSet().getInt(1));
                modelFornecedor.setNome(this.getResultSet().getString(2));
                modelFornecedor.setEndereco(this.getResultSet().getInt(3));
                modelFornecedor.setTelefone(this.getResultSet().getString(4));
                modelFornecedor.setNumero(this.getResultSet().getString(5));
                modelFornecedor.setCnpj(this.getResultSet().getString(6));
                modelFornecedor.setEmail(this.getResultSet().getString(7));
                modelFornecedor.setContato(this.getResultSet().getString(8));
                listamodelFornecedor.add(modelFornecedor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelFornecedor;
    }

    /**
     * atualiza Fornecedor
     *
     * @param pModelFornecedor return boolean
     */
    public boolean atualizarFornecedorDAO(ModelFornecedor pModelFornecedor) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE fornecedores SET "
                    + "codigo = '" + pModelFornecedor.getCodigo() + "',"
                    + "nome = '" + pModelFornecedor.getNome() + "',"
                    + "endereco = '" + pModelFornecedor.getEndereco() + "',"
                    + "telefone = '" + pModelFornecedor.getTelefone() + "',"
                    + "numero = '" + pModelFornecedor.getNumero() + "',"
                    + "cnpj = '" + pModelFornecedor.getCnpj() + "',"
                    + "email = '" + pModelFornecedor.getEmail() + "',"
                    + "contato = '" + pModelFornecedor.getContato() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelFornecedor.getCodigo() + "'"
                    + ";"
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui Fornecedor
     *
     * @param pCodigo return boolean
     */
    public boolean excluirFornecedorDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM fornecedores "
                    + " WHERE "
                    + "codigo = '" + pCodigo + "'"
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
