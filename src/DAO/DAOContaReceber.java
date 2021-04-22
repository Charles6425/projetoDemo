package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelContaReceber;

/**
 *
 * @author contato@blsoft.com.br
 */
public class DAOContaReceber extends ConexaoMySql {

    /**
     * grava ContaPagar
     *
     * @param pModelContaRecber return int
     */
    public int salvarContaReceberDAO(ModelContaReceber pModelContaRecber) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO contas_receber ("
                    + "fk_codigo_pessoa,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor, "
                    + "pedido "
                    + ") VALUES ("
                    + "'" + pModelContaRecber.getCodigoPessoa() + "',"
                    + "'" + pModelContaRecber.getDescricao() + "',"
                    + "'" + pModelContaRecber.getData() + "',"
                    + "'" + pModelContaRecber.getVencimento() + "',"
                    + "'" + pModelContaRecber.getPagamento() + "',"
                    + "'" + pModelContaRecber.getTipoPagamento() + "',"
                    + "'" + pModelContaRecber.getObservacao() + "',"
                    + "'" + pModelContaRecber.isSituacao() + "',"
                    + "'" + pModelContaRecber.getValor() + "',"
                    + "'" + pModelContaRecber.getPedido()+ "'"
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
     * recupera ContaPagar
     *
     * @param pCodigo return ModelConta
     */
    public ModelContaReceber getContaPagarDAO(int pCodigo) {
        ModelContaReceber modelConta = new ModelContaReceber();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_pessoa,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor,"
                    + "pedido"
                    + " FROM"
                    + " contas_receber"
                    + " WHERE"
                    + " pk_codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelConta.setCodigo(this.getResultSet().getInt(1));
                modelConta.setCodigoPessoa(this.getResultSet().getInt(2));
                modelConta.setDescricao(this.getResultSet().getString(3));
                modelConta.setData(this.getResultSet().getDate(4));
                modelConta.setVencimento(this.getResultSet().getDate(5));
                modelConta.setPagamento(this.getResultSet().getDate(6));
                modelConta.setTipoPagamento(this.getResultSet().getInt(7));
                modelConta.setObservacao(this.getResultSet().getString(8));
                modelConta.setSituacao(this.getResultSet().getInt(9));
                modelConta.setValor(this.getResultSet().getFloat(10));
                modelConta.setPedido(this.getResultSet().getInt(11));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelConta;
    }

    /**
     * recupera uma lista de ContaPagar return ArrayList
     */
    public ArrayList<ModelContaReceber> getListaContaPagarDAO() {
        ArrayList<ModelContaReceber> listamodelConta = new ArrayList();
        ModelContaReceber modelContaReceber = new ModelContaReceber();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_pessoa,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor,"
                    + "pedido"
                    + " FROM"
                    + " contas_receber"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContaReceber = new ModelContaReceber();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setPagamento(this.getResultSet().getDate(6));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaReceber.setObservacao(this.getResultSet().getString(8));
                modelContaReceber.setSituacao(this.getResultSet().getInt(9));
                modelContaReceber.setValor(this.getResultSet().getFloat(10));
                modelContaReceber.setPedido(this.getResultSet().getInt(11));
                listamodelConta.add(modelContaReceber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelConta;
    }

    /**
     * recupera uma lista de ContaPagar return ArrayList
     */
    public ArrayList<ModelContaReceber> getListaContaPagarDAO(int pStatus) {
        ArrayList<ModelContaReceber> listamodelContaPagar = new ArrayList();
        ModelContaReceber modelContaReceber = new ModelContaReceber();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_pessoa,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor, "
                    + "pedido "
                    + " FROM"
                    + " contas_receber where situacao = '" + pStatus + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContaReceber = new ModelContaReceber();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setPagamento(this.getResultSet().getDate(6));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaReceber.setObservacao(this.getResultSet().getString(8));
                modelContaReceber.setSituacao(this.getResultSet().getInt(9));
                modelContaReceber.setValor(this.getResultSet().getFloat(10));
                modelContaReceber.setPedido(this.getResultSet().getInt(11));
                listamodelContaPagar.add(modelContaReceber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelContaPagar;
    }

    /**
     * recupera uma lista de ContaPagar return ArrayList
     */
    public ArrayList<ModelContaReceber> getListaContaReceberDAO(int pStatus) {
        ArrayList<ModelContaReceber> listamodelContaReceber = new ArrayList();
        ModelContaReceber modelContaReceber = new ModelContaReceber();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_pessoa,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor, "
                    + "pedido "
                    + " FROM"
                    + " contas_receber where situacao = '" + pStatus + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContaReceber = new ModelContaReceber();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setPagamento(this.getResultSet().getDate(6));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaReceber.setObservacao(this.getResultSet().getString(8));
                modelContaReceber.setSituacao(this.getResultSet().getInt(9));
                modelContaReceber.setValor(this.getResultSet().getFloat(10));
                modelContaReceber.setPedido(this.getResultSet().getInt(11));
                listamodelContaReceber.add(modelContaReceber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelContaReceber;
    }

    /**
     * recupera uma lista de ContaPagar return ArrayList
     */
    public ArrayList<ModelContaReceber> getListaContasDAO(int pStatus) {
        ArrayList<ModelContaReceber> listamodelContaReceber = new ArrayList();
        ModelContaReceber modelContaReceber = new ModelContaReceber();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_pessoa,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor, "
                    + "pedido "
                    + " FROM"
                    + " contas_receber where situacao = '" + pStatus + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContaReceber = new ModelContaReceber();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setPagamento(this.getResultSet().getDate(6));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaReceber.setObservacao(this.getResultSet().getString(8));
                modelContaReceber.setSituacao(this.getResultSet().getInt(9));
                modelContaReceber.setValor(this.getResultSet().getFloat(10));
                modelContaReceber.setPedido(this.getResultSet().getInt(11));
                listamodelContaReceber.add(modelContaReceber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelContaReceber;
    }

    /**
     * recupera uma lista de ContaPagar por data return ArrayList
     */
    public ArrayList<ModelContaReceber> getListaContasDAO(ModelContaReceber pModelConta) {
        ArrayList<ModelContaReceber> listamodelContaPagar = new ArrayList();
        ModelContaReceber modelContaReceber = new ModelContaReceber();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_pessoa,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor, "
                    + "pedido "
                    + " FROM"
                    + " contas_receber where situacao = '" + pModelConta.isSituacao() + "' AND pagamento = '" + pModelConta.getPagamento() + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContaReceber = new ModelContaReceber();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setPagamento(this.getResultSet().getDate(6));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaReceber.setObservacao(this.getResultSet().getString(8));
                modelContaReceber.setSituacao(this.getResultSet().getInt(9));
                modelContaReceber.setValor(this.getResultSet().getFloat(10));
                modelContaReceber.setPedido(this.getResultSet().getInt(11));
                listamodelContaPagar.add(modelContaReceber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelContaPagar;
    }

    /**
     * atualiza ContaPagar
     *
     * @param pModelContaReceber return boolean
     */
    public boolean atualizarContaReceberDAO(ModelContaReceber pModelContaReceber) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE contas_receber SET "
                    + "pk_codigo = '" + pModelContaReceber.getCodigo() + "',"
                    + "fk_codigo_pessoa = '" + pModelContaReceber.getCodigoPessoa() + "',"
                    + "descricao = '" + pModelContaReceber.getDescricao() + "',"
                    + "data = '" + pModelContaReceber.getData() + "',"
                    + "vencimento = '" + pModelContaReceber.getVencimento() + "',"
                    + "pagamento = '" + pModelContaReceber.getPagamento() + "',"
                    + "fk_tipo_pagamento = '" + pModelContaReceber.getTipoPagamento() + "',"
                    + "observacao = '" + pModelContaReceber.getObservacao() + "',"
                    + "situacao = '" + pModelContaReceber.isSituacao() + "',"
                    + "valor = '" + pModelContaReceber.getValor() + "',"
                    + "pedido = '" + pModelContaReceber.getPedido()+ "'"
                    + " WHERE "
                    + "pk_codigo = '" + pModelContaReceber.getCodigo() + "'"
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
     * exclui ContaPagar
     *
     * @param pCodigo return boolean
     */
    public boolean excluirContaReceberDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM contas_receber "
                    + " WHERE "
                    + "pk_codigo = '" + pCodigo + "'"
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
     * exclui ContaPagar
     *
     * @param pCodigo return boolean
     */
    public boolean excluirContaReceberPedidoDAO(int pPedido) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM contas_receber "
                    + " WHERE "
                    + "pedido = '" + pPedido+ "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean receberContaReceberDAO(ModelContaReceber pModelContaReceber) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE contas_receber SET "
                    + "pagamento = '" + pModelContaReceber.getPagamento() + "',"
                    + "situacao = '" + pModelContaReceber.isSituacao() + "'"
                    + " WHERE "
                    + "pk_codigo = '" + pModelContaReceber.getCodigo() + "'"
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
