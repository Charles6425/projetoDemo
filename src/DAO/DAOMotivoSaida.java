package DAO;

import model.ModelMotivoSaida;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOMotivoSaida extends ConexaoMySql {

    /**
    * grava MotivoSaida
    * @param pModelMotivoSaida
    * @return int
    */
    public int salvarMotivoSaidaDAO(ModelMotivoSaida pModelMotivoSaida){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO motivo_saida ("
                    + "id,"
                    + "id_aluno,"
                    + "motivo"
                + ") VALUES ("
                    + "'" + pModelMotivoSaida.getId() + "',"
                    + "'" + pModelMotivoSaida.getId_aluno() + "',"
                    + "'" + pModelMotivoSaida.getMotivo() + "'"
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
    * recupera MotivoSaida
    * @param pId
    * @return ModelMotivoSaida
    */
    public ModelMotivoSaida getMotivoSaidaDAO(int pId){
        ModelMotivoSaida modelMotivoSaida = new ModelMotivoSaida();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "id_aluno,"
                    + "motivo,"
                    + "data"
                 + " FROM"
                     + " motivo_saida"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelMotivoSaida.setId(this.getResultSet().getInt(1));
                modelMotivoSaida.setId_aluno(this.getResultSet().getInt(2));
                modelMotivoSaida.setMotivo(this.getResultSet().getString(3));
                modelMotivoSaida.setData(this.getResultSet().getString (4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelMotivoSaida;
    }

    /**
    * recupera uma lista de MotivoSaida
        * @return ArrayList
    */
    public ArrayList<ModelMotivoSaida> getListaMotivoSaidaDAO(){
        ArrayList<ModelMotivoSaida> listamodelMotivoSaida = new ArrayList();
        ModelMotivoSaida modelMotivoSaida = new ModelMotivoSaida();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "id_aluno,"
                    + "motivo,"
                    + "data"
                 + " FROM"
                     + " motivo_saida"
                + ";"
            );

            while(this.getResultSet().next()){
                modelMotivoSaida = new ModelMotivoSaida();
                modelMotivoSaida.setId(this.getResultSet().getInt(1));
                modelMotivoSaida.setId_aluno(this.getResultSet().getInt(2));
                modelMotivoSaida.setMotivo(this.getResultSet().getString(3));
                modelMotivoSaida.setData(this.getResultSet().getString (4));
                listamodelMotivoSaida.add(modelMotivoSaida);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelMotivoSaida;
    }

    /**
    * atualiza MotivoSaida
    * @param pModelMotivoSaida
    * @return boolean
    */
    public boolean atualizarMotivoSaidaDAO(ModelMotivoSaida pModelMotivoSaida){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE motivo_saida SET "
                    + "id = '" + pModelMotivoSaida.getId() + "',"
                    + "id_aluno = '" + pModelMotivoSaida.getId_aluno() + "',"
                    + "motivo = '" + pModelMotivoSaida.getMotivo() + "',"
                    + "data = '" + pModelMotivoSaida.getData() + "'"
                + " WHERE "
                    + "id = '" + pModelMotivoSaida.getId() + "'"
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
    * exclui MotivoSaida
    * @param pId
    * @return boolean
    */
    public boolean excluirMotivoSaidaDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM motivo_saida "
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