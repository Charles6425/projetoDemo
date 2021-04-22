package DAO;

import model.ModelAlunoNota;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles
*/
public class DAOAlunoNota extends ConexaoMySql {

    /**
    * grava AlunoNota
    * @param pModelAlunoNota
    * return int
    */
    public int salvarAlunoNotaDAO(ModelAlunoNota pModelAlunoNota){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO aluno_nota ("
                    + "id,"
                    + "materia,"
                    + "rgm_aluno,"
                    + "nota,"
                    + "ano"
                + ") VALUES ("
                    + "'" + pModelAlunoNota.getId() + "',"
                    + "'" + pModelAlunoNota.getMateria() + "',"
                    + "'" + pModelAlunoNota.getRgm_aluno() + "',"
                    + "'" + pModelAlunoNota.getNota() + "',"
                    + "'" + pModelAlunoNota.getAno() + "'"
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
    * recupera AlunoNota
    * @param pId
    * return ModelAlunoNota
    */
    public ModelAlunoNota getAlunoNotaDAO(int pId){
        ModelAlunoNota modelAlunoNota = new ModelAlunoNota();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "materia,"
                    + "rgm_aluno,"
                    + "nota,"
                    + "ano"
                 + " FROM"
                     + " aluno_nota"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelAlunoNota.setId(this.getResultSet().getInt(1));
                modelAlunoNota.setMateria(this.getResultSet().getInt(2));
                modelAlunoNota.setRgm_aluno(this.getResultSet().getString(3));
                modelAlunoNota.setNota(this.getResultSet().getFloat(4));
                modelAlunoNota.setAno(this.getResultSet().getString(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelAlunoNota;
    }

    /**
    * recupera uma lista de AlunoNota
        * return ArrayList
    */
    public ArrayList<ModelAlunoNota> getListaAlunoNotaDAO(){
        ArrayList<ModelAlunoNota> listamodelAlunoNota = new ArrayList();
        ModelAlunoNota modelAlunoNota = new ModelAlunoNota();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "materia,"
                    + "rgm_aluno,"
                    + "nota,"
                    + "ano"
                 + " FROM"
                     + " aluno_nota"
                + ";"
            );

            while(this.getResultSet().next()){
                modelAlunoNota = new ModelAlunoNota();
                modelAlunoNota.setId(this.getResultSet().getInt(1));
                modelAlunoNota.setMateria(this.getResultSet().getInt(2));
                modelAlunoNota.setRgm_aluno(this.getResultSet().getString(3));
                modelAlunoNota.setNota(this.getResultSet().getFloat(4));
                modelAlunoNota.setAno(this.getResultSet().getString(5));
                listamodelAlunoNota.add(modelAlunoNota);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelAlunoNota;
    }
    public ArrayList<ModelAlunoNota> getListaAlunoNotaCodDAO(int pCod){
        ArrayList<ModelAlunoNota> listamodelAlunoNota = new ArrayList();
        ModelAlunoNota modelAlunoNota = new ModelAlunoNota();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "materia,"
                    + "rgm_aluno,"
                    + "nota,"
                    + "ano"
                 + " FROM"
                     + " aluno_nota"
                        + " where rgm_aluno = '"+pCod+"'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelAlunoNota = new ModelAlunoNota();
                modelAlunoNota.setId(this.getResultSet().getInt(1));
                modelAlunoNota.setMateria(this.getResultSet().getInt(2));
                modelAlunoNota.setRgm_aluno(this.getResultSet().getString(3));
                modelAlunoNota.setNota(this.getResultSet().getFloat(4));
                modelAlunoNota.setAno(this.getResultSet().getString(5));
                listamodelAlunoNota.add(modelAlunoNota);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelAlunoNota;
    }
    public ArrayList<ModelAlunoNota> getListaAlunoNotaRGMDAO(String pRGM){
        ArrayList<ModelAlunoNota> listamodelAlunoNota = new ArrayList();
        ModelAlunoNota modelAlunoNota = new ModelAlunoNota();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "materia,"
                    + "rgm_aluno,"
                    + "nota,"
                    + "ano"
                 + " FROM"
                     + " aluno_nota"
                        + " where rgm_aluno = '"+pRGM+"'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelAlunoNota = new ModelAlunoNota();
                modelAlunoNota.setId(this.getResultSet().getInt(1));
                modelAlunoNota.setMateria(this.getResultSet().getInt(2));
                modelAlunoNota.setRgm_aluno(this.getResultSet().getString(3));
                modelAlunoNota.setNota(this.getResultSet().getFloat(4));
                modelAlunoNota.setAno(this.getResultSet().getString(5));
                listamodelAlunoNota.add(modelAlunoNota);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelAlunoNota;
    }

    /**
    * atualiza AlunoNota
    * @param pModelAlunoNota
    * return boolean
    */
    public boolean atualizarAlunoNotaDAO(ModelAlunoNota pModelAlunoNota){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE aluno_nota SET "
                    + "id = '" + pModelAlunoNota.getId() + "',"
                    + "materia = '" + pModelAlunoNota.getMateria() + "',"
                    + "rgm_aluno = '" + pModelAlunoNota.getRgm_aluno() + "',"
                    + "nota = '" + pModelAlunoNota.getNota() + "',"
                    + "ano = '" + pModelAlunoNota.getAno() + "'"
                + " WHERE "
                    + "id = '" + pModelAlunoNota.getId() + "'"
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
    * exclui AlunoNota
    * @param pId
    * return boolean
    */
    public boolean excluirAlunoNotaDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM aluno_nota "
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