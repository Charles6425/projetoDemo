package DAO;

import model.ModelCadastroSituacao;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOCadastroSituacao extends ConexaoMySql {

    /**
    * grava CadastroSituacao
    * @param pModelCadastroSituacao
    * @return int
    */
    public int salvarCadastroSituacaoDAO(ModelCadastroSituacao pModelCadastroSituacao){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO cad_situacao ("
                    + "id,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelCadastroSituacao.getId() + "',"
                    + "'" + pModelCadastroSituacao.getDescricao() + "'"
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
    * recupera CadastroSituacao
    * @param pId
    * @return ModelCadastroSituacao
    */
    public ModelCadastroSituacao getCadastroSituacaoDAO(String pId){
        ModelCadastroSituacao modelCadastroSituacao = new ModelCadastroSituacao();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " cad_situacao"
                 + " WHERE"
                     + " descricao = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCadastroSituacao.setId(this.getResultSet().getInt(1));
                modelCadastroSituacao.setDescricao(this.getResultSet().getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCadastroSituacao;
    }

    /**
    * recupera uma lista de CadastroSituacao
        * @return ArrayList
    */
    public ArrayList<ModelCadastroSituacao> getListaCadastroSituacaoDAO(){
        ArrayList<ModelCadastroSituacao> listamodelCadastroSituacao = new ArrayList();
        ModelCadastroSituacao modelCadastroSituacao = new ModelCadastroSituacao();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " cad_situacao"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCadastroSituacao = new ModelCadastroSituacao();
                modelCadastroSituacao.setId(this.getResultSet().getInt(1));
                modelCadastroSituacao.setDescricao(this.getResultSet().getString(2));
                listamodelCadastroSituacao.add(modelCadastroSituacao);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCadastroSituacao;
    }

    /**
    * atualiza CadastroSituacao
    * @param pModelCadastroSituacao
    * @return boolean
    */
    public boolean atualizarCadastroSituacaoDAO(ModelCadastroSituacao pModelCadastroSituacao){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE cad_situacao SET "
                    + "id = '" + pModelCadastroSituacao.getId() + "',"
                    + "descricao = '" + pModelCadastroSituacao.getDescricao() + "'"
                + " WHERE "
                    + "id = '" + pModelCadastroSituacao.getId() + "'"
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
    * exclui CadastroSituacao
    * @param pId
    * @return boolean
    */
    public boolean excluirCadastroSituacaoDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM cad_situacao "
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