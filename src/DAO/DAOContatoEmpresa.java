package DAO;

import model.ModelContatoEmpresa;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author Charles
 */
public class DAOContatoEmpresa extends ConexaoMySql {

    /**
     * grava ContatoEmpresa
     *
     * @param pModelContatoEmpresa return int
     */
    public int salvarContatoEmpresaDAO(ModelContatoEmpresa pModelContatoEmpresa) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO empresa_contato ("
                    + "id,"
                    + "nome,"
                    + "email,"
                    + "tel,"
                    + "id_empresa"
                    + ") VALUES ("
                    + "'" + pModelContatoEmpresa.getId() + "',"
                    + "'" + pModelContatoEmpresa.getNome() + "',"
                    + "'" + pModelContatoEmpresa.getEmail() + "',"
                    + "'" + pModelContatoEmpresa.getTel() + "',"
                    + "'" + pModelContatoEmpresa.getId_empresa() + "'"
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
     * recupera ContatoEmpresa
     *
     * @param pIdEmpresa return ModelContatoEmpresa
     */
    public ModelContatoEmpresa getContatoEmpresaDAO(int pId) {
        ModelContatoEmpresa modelContatoEmpresa = new ModelContatoEmpresa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id,"
                    + "nome,"
                    + "email,"
                    + "tel,"
                    + "id_empresa"
                    + " FROM"
                    + " empresa_contato"
                    + " WHERE"
                    + " id_empresa = '" + pId + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContatoEmpresa.setId(this.getResultSet().getInt(1));
                modelContatoEmpresa.setNome(this.getResultSet().getString(2));
                modelContatoEmpresa.setEmail(this.getResultSet().getString(3));
                modelContatoEmpresa.setTel(this.getResultSet().getString(4));
                modelContatoEmpresa.setId_empresa(this.getResultSet().getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelContatoEmpresa;
    }

    /**
     * recupera uma lista de ContatoEmpresa return ArrayList
     */
    public ArrayList<ModelContatoEmpresa> getListaContatoEmpresaDAO() {
        ArrayList<ModelContatoEmpresa> listamodelContatoEmpresa = new ArrayList();
        ModelContatoEmpresa modelContatoEmpresa = new ModelContatoEmpresa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id,"
                    + "nome,"
                    + "email,"
                    + "tel,"
                    + "id_empresa"
                    + " FROM"
                    + " empresa_contato"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContatoEmpresa = new ModelContatoEmpresa();
                modelContatoEmpresa.setId(this.getResultSet().getInt(1));
                modelContatoEmpresa.setNome(this.getResultSet().getString(2));
                modelContatoEmpresa.setEmail(this.getResultSet().getString(3));
                modelContatoEmpresa.setTel(this.getResultSet().getString(4));
                modelContatoEmpresa.setId_empresa(this.getResultSet().getInt(5));
                listamodelContatoEmpresa.add(modelContatoEmpresa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelContatoEmpresa;
    }

    /**
     * recupera uma lista de ContatoEmpresa return ArrayList
     */
    public ArrayList<ModelContatoEmpresa> getListaContatoEmpresaDAO(int pIdEmpresa) {
        ArrayList<ModelContatoEmpresa> listamodelContatoEmpresa = new ArrayList();
        ModelContatoEmpresa modelContatoEmpresa = new ModelContatoEmpresa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id,"
                    + "nome,"
                    + "email,"
                    + "tel,"
                    + "id_empresa"
                    + " FROM"
                    + " empresa_contato"
                    + " where id_empresa = '" + pIdEmpresa + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContatoEmpresa = new ModelContatoEmpresa();
                modelContatoEmpresa.setId(this.getResultSet().getInt(1));
                modelContatoEmpresa.setNome(this.getResultSet().getString(2));
                modelContatoEmpresa.setEmail(this.getResultSet().getString(3));
                modelContatoEmpresa.setTel(this.getResultSet().getString(4));
                modelContatoEmpresa.setId_empresa(this.getResultSet().getInt(5));
                listamodelContatoEmpresa.add(modelContatoEmpresa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelContatoEmpresa;
    }

    /**
     * atualiza ContatoEmpresa
     *
     * @param pModelContatoEmpresa return boolean
     */
    public boolean atualizarContatoEmpresaDAO(ModelContatoEmpresa pModelContatoEmpresa) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE empresa_contato SET "
                    + "id = '" + pModelContatoEmpresa.getId() + "',"
                    + "nome = '" + pModelContatoEmpresa.getNome() + "',"
                    + "email = '" + pModelContatoEmpresa.getEmail() + "',"
                    + "tel = '" + pModelContatoEmpresa.getTel() + "',"
                    + "id_empresa = '" + pModelContatoEmpresa.getId_empresa() + "'"
                    + " WHERE "
                    + "id = '" + pModelContatoEmpresa.getId() + "'"
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
     * exclui ContatoEmpresa
     *
     * @param pId return boolean
     */
    public boolean excluirContatoEmpresaDAO(int pId) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM empresa_contato "
                    + " WHERE "
                    + "id = '" + pId + "'"
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
