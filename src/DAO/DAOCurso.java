package DAO;

import model.ModelCurso;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOCurso extends ConexaoMySql {

    /**
    * grava Curso
    * @param pModelCurso
    * @return int
    */
    public int salvarCursoDAO(ModelCurso pModelCurso){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO qual_curso ("
                    + "id,"
                    + "curso,"
                    + "cbo,"
                    + "categoria_pratica,"
                    + "teoria"
                + ") VALUES ("
                    + "'" + pModelCurso.getId() + "',"
                    + "'" + pModelCurso.getCurso() + "',"
                    + "'" + pModelCurso.getCbo() + "',"
                    + "'" + pModelCurso.getCategoria_pratica() + "',"
                    + "'" + pModelCurso.getTeoria() + "'"
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
    * recupera Curso
    * @param pId
    * @return ModelCurso
    */
    public ModelCurso getCursoDAO(int pId){
        ModelCurso modelCurso = new ModelCurso();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "curso,"
                    + "cbo,"
                    + "categoria_pratica,"
                    + "teoria"
                 + " FROM"
                     + " qual_curso"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCurso.setId(this.getResultSet().getInt(1));
                modelCurso.setCurso(this.getResultSet().getString(2));
                modelCurso.setCbo(this.getResultSet().getString(3));
                modelCurso.setCategoria_pratica(this.getResultSet().getString(4));
                modelCurso.setTeoria(this.getResultSet().getString(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCurso;
    }

    /**
    * recupera uma lista de Curso
        * @return ArrayList
    */
    public ArrayList<ModelCurso> getListaCursoDAO(){
        ArrayList<ModelCurso> listamodelCurso = new ArrayList();
        ModelCurso modelCurso = new ModelCurso();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "curso,"
                    + "cbo,"
                    + "categoria_pratica,"
                    + "teoria"
                 + " FROM"
                     + " qual_curso"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCurso = new ModelCurso();
                modelCurso.setId(this.getResultSet().getInt(1));
                modelCurso.setCurso(this.getResultSet().getString(2));
                modelCurso.setCbo(this.getResultSet().getString(3));
                modelCurso.setCategoria_pratica(this.getResultSet().getString(4));
                modelCurso.setTeoria(this.getResultSet().getString(5));
                listamodelCurso.add(modelCurso);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCurso;
    }

    /**
    * atualiza Curso
    * @param pModelCurso
    * @return boolean
    */
    public boolean atualizarCursoDAO(ModelCurso pModelCurso){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE qual_curso SET "
                    + "id = '" + pModelCurso.getId() + "',"
                    + "curso = '" + pModelCurso.getCurso() + "',"
                    + "cbo = '" + pModelCurso.getCbo() + "',"
                    + "categoria_pratica = '" + pModelCurso.getCategoria_pratica() + "',"
                    + "teoria = '" + pModelCurso.getTeoria() + "'"
                + " WHERE "
                    + "id = '" + pModelCurso.getId() + "'"
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
    * exclui Curso
    * @param pId
    * @return boolean
    */
    public boolean excluirCursoDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM qual_curso "
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