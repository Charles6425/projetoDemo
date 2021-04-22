package DAO;

import model.ModelDiaCurso;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAODiaCurso extends ConexaoMySql {

    /**
    * grava DiaCurso
    * @param pModelDiaCurso
    * @return int
    */
    public int salvarDiaCursoDAO(ModelDiaCurso pModelDiaCurso){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO semana ("
                    + "id,"
                    + "dia"
                + ") VALUES ("
                    + "'" + pModelDiaCurso.getId() + "',"
                    + "'" + pModelDiaCurso.getDia() + "'"
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
    * recupera DiaCurso
    * @param pId
    * @return ModelDiaCurso
    */
    public ModelDiaCurso getDiaCursoDAO(int pId){
        ModelDiaCurso modelDiaCurso = new ModelDiaCurso();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "dia"
                 + " FROM"
                     + " semana"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelDiaCurso.setId(this.getResultSet().getInt(1));
                modelDiaCurso.setDia(this.getResultSet().getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelDiaCurso;
    }

    /**
    * recupera uma lista de DiaCurso
        * @return ArrayList
    */
    public ArrayList<ModelDiaCurso> getListaDiaCursoDAO(){
        ArrayList<ModelDiaCurso> listamodelDiaCurso = new ArrayList();
        ModelDiaCurso modelDiaCurso = new ModelDiaCurso();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "dia"
                 + " FROM"
                     + " semana"
                + ";"
            );

            while(this.getResultSet().next()){
                modelDiaCurso = new ModelDiaCurso();
                modelDiaCurso.setId(this.getResultSet().getInt(1));
                modelDiaCurso.setDia(this.getResultSet().getString(2));
                listamodelDiaCurso.add(modelDiaCurso);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelDiaCurso;
    }

    /**
    * atualiza DiaCurso
    * @param pModelDiaCurso
    * @return boolean
    */
    public boolean atualizarDiaCursoDAO(ModelDiaCurso pModelDiaCurso){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE semana SET "
                    + "id = '" + pModelDiaCurso.getId() + "',"
                    + "dia = '" + pModelDiaCurso.getDia() + "'"
                + " WHERE "
                    + "id = '" + pModelDiaCurso.getId() + "'"
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
    * exclui DiaCurso
    * @param pId
    * @return boolean
    */
    public boolean excluirDiaCursoDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM semana "
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