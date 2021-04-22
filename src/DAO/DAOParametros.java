package DAO;

import model.ModelParametros;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author Charles Müller
 */
public class DAOParametros extends ConexaoMySql {

    /**
     * grava ConfiguracoesGerais
     *
     * @param pModelConfiguracoesGerais return int
     */
    public int salvarConfiguracoesGeraisDAO(ModelParametros pModelConfiguracoesGerais) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO configuracoes_gerais ("
                    + "config_id,"
                    + "pdv_solicita_vendedor,"
                    + "pdv_desconto_percentual,"
                    + "cad_utiliza_ficha_tec, "
                    + "cad_anvisa, "
                    + "mostra_total_fechto "
                    + ") VALUES ("
                    + "'" + pModelConfiguracoesGerais.getConfig_id() + "',"
                    + "'" + pModelConfiguracoesGerais.getPdv_solicita_vendedor() + "',"
                    + "'" + pModelConfiguracoesGerais.getPdv_desconto_percentual() + "',"
                    + "'" + pModelConfiguracoesGerais.getCad_utiliza_ficha_tec()+ "',"
                    + "'" + pModelConfiguracoesGerais.getCad_anvisa()+ "',"
                    + "'" + pModelConfiguracoesGerais.getMostra_total_fechto()+ "'"
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
     * recupera ConfiguracoesGerais
     *
     * @param pConfig_id return ModelParametros
     */
    public ModelParametros getConfiguracoesGeraisDAO(int pConfig_id) {
        ModelParametros modelConfiguracoesGerais = new ModelParametros();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "config_id,"
                    + "pdv_solicita_vendedor,"
                    + "pdv_desconto_percentual,"
                    + "cad_utiliza_ficha_tec,"
                    + "cad_anvisa,"
                    + "mostra_total_fechto"
                    + " FROM"
                    + " configuracoes_gerais"
                    + " WHERE"
                    + " config_id = '" + pConfig_id + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelConfiguracoesGerais.setConfig_id(this.getResultSet().getInt(1));
                modelConfiguracoesGerais.setPdv_solicita_vendedor(this.getResultSet().getInt(2));
                modelConfiguracoesGerais.setPdv_desconto_percentual(this.getResultSet().getInt(3));
                modelConfiguracoesGerais.setCad_utiliza_ficha_tec(this.getResultSet().getInt(4));
                modelConfiguracoesGerais.setCad_anvisa(this.getResultSet().getInt(5));
                modelConfiguracoesGerais.setMostra_total_fechto(this.getResultSet().getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelConfiguracoesGerais;
    }

    /**
     * recupera uma lista de ConfiguracoesGerais return ArrayList
     */
    public ArrayList<ModelParametros> getListaConfiguracoesGeraisDAO() {
        ArrayList<ModelParametros> listamodelConfiguracoesGerais = new ArrayList();
        ModelParametros modelConfiguracoesGerais = new ModelParametros();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "config_id,"
                    + "pdv_solicita_vendedor,"
                    + "pdv_desconto_percentual,"
                    + "cad_anvisa,"
                    + "mostra_total_fechto"
                    + " FROM"
                    + " configuracoes_gerais"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelConfiguracoesGerais = new ModelParametros();
                modelConfiguracoesGerais.setConfig_id(this.getResultSet().getInt(1));
                modelConfiguracoesGerais.setPdv_solicita_vendedor(this.getResultSet().getInt(2));
                modelConfiguracoesGerais.setPdv_desconto_percentual(this.getResultSet().getInt(3));
                modelConfiguracoesGerais.setCad_anvisa(this.getResultSet().getInt(4));
                modelConfiguracoesGerais.setMostra_total_fechto(this.getResultSet().getInt(5));
                listamodelConfiguracoesGerais.add(modelConfiguracoesGerais);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelConfiguracoesGerais;
    }

    /**
     * atualiza ConfiguracoesGerais
     *
     * @param pModelConfiguracoesGerais return boolean
     */
    public boolean atualizarConfiguracoesGeraisDAO(ModelParametros pModelConfiguracoesGerais) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE configuracoes_gerais SET "
                    + "config_id = '" + pModelConfiguracoesGerais.getConfig_id() + "',"
                    + "pdv_solicita_vendedor = '" + pModelConfiguracoesGerais.getPdv_solicita_vendedor() + "',"
                    + "pdv_desconto_percentual = '" + pModelConfiguracoesGerais.getPdv_desconto_percentual() + "',"
                    + "cad_utiliza_ficha_tec = '" + pModelConfiguracoesGerais.getCad_utiliza_ficha_tec() + "',"
                    + "cad_anvisa = '" + pModelConfiguracoesGerais.getCad_anvisa()+ "',"
                    + "mostra_total_fechto = '" + pModelConfiguracoesGerais.getMostra_total_fechto()+ "'"
                    + " WHERE "
                    + "config_id = '" + pModelConfiguracoesGerais.getConfig_id() + "'"
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
     * exclui ConfiguracoesGerais
     *
     * @param pConfig_id return boolean
     */
    public boolean excluirConfiguracoesGeraisDAO(int pConfig_id) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM configuracoes_gerais "
                    + " WHERE "
                    + "config_id = '" + pConfig_id + "'"
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
