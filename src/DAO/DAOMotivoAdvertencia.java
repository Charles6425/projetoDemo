package DAO;

import model.ModelMotivoAdvertencia;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOMotivoAdvertencia extends ConexaoMySql {

    /**
    * grava MotivoAdvertencia
    * @param pModelMotivoAdvertencia
    * @return int
    */
    public int salvarMotivoAdvertenciaDAO(ModelMotivoAdvertencia pModelMotivoAdvertencia){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO motivo_advertencia ("
                    + "id,"
                    + "id_aluno,"
                    + "motivo"

                + ") VALUES ("
                    + "'" + pModelMotivoAdvertencia.getId() + "',"
                    + "'" + pModelMotivoAdvertencia.getId_aluno() + "',"
                    + "'" + pModelMotivoAdvertencia.getMotivo() + "'"
      
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
    * recupera MotivoAdvertencia
    * @param pId
    * @return ModelMotivoAdvertencia
    */
    public ModelMotivoAdvertencia getMotivoAdvertenciaDAO(int pId){
        ModelMotivoAdvertencia modelMotivoAdvertencia = new ModelMotivoAdvertencia();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "id_aluno,"
                    + "motivo,"
                    + "data"
                 + " FROM"
                     + " motivo_advertencia"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelMotivoAdvertencia.setId(this.getResultSet().getInt(1));
                modelMotivoAdvertencia.setId_aluno(this.getResultSet().getInt(2));
                modelMotivoAdvertencia.setMotivo(this.getResultSet().getString(3));
                modelMotivoAdvertencia.setData(this.getResultSet().getString(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelMotivoAdvertencia;
    }

    /**
    * recupera uma lista de MotivoAdvertencia
        * @return ArrayList
    */
    public ArrayList<ModelMotivoAdvertencia> getListaMotivoAdvertenciaDAO(){
        ArrayList<ModelMotivoAdvertencia> listamodelMotivoAdvertencia = new ArrayList();
        ModelMotivoAdvertencia modelMotivoAdvertencia = new ModelMotivoAdvertencia();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "id_aluno,"
                    + "motivo,"
                    + "data"
                 + " FROM"
                     + " motivo_advertencia"
                + ";"
            );

            while(this.getResultSet().next()){
                modelMotivoAdvertencia = new ModelMotivoAdvertencia();
                modelMotivoAdvertencia.setId(this.getResultSet().getInt(1));
                modelMotivoAdvertencia.setId_aluno(this.getResultSet().getInt(2));
                modelMotivoAdvertencia.setMotivo(this.getResultSet().getString(3));
                modelMotivoAdvertencia.setData(this.getResultSet().getString(4));
                listamodelMotivoAdvertencia.add(modelMotivoAdvertencia);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelMotivoAdvertencia;
    }

    /**
    * atualiza MotivoAdvertencia
    * @param pModelMotivoAdvertencia
    * @return boolean
    */
    public boolean atualizarMotivoAdvertenciaDAO(ModelMotivoAdvertencia pModelMotivoAdvertencia){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE motivo_advertencia SET "
                    + "id = '" + pModelMotivoAdvertencia.getId() + "',"
                    + "id_aluno = '" + pModelMotivoAdvertencia.getId_aluno() + "',"
                    + "motivo = '" + pModelMotivoAdvertencia.getMotivo() + "',"
                    + "data = '" + pModelMotivoAdvertencia.getData() + "'"
                + " WHERE "
                    + "id = '" + pModelMotivoAdvertencia.getId() + "'"
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
    * exclui MotivoAdvertencia
    * @param pId
    * @return boolean
    */
    public boolean excluirMotivoAdvertenciaDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM motivo_advertencia "
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