package DAO;

import model.ModelSegFaseTurma;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOSegFaseTurma extends ConexaoMySql {

    /**
    * grava SegFaseTurma
    * @param pModelSegFaseTurma
    * @return int
    */
    public int salvarSegFaseTurmaDAO(ModelSegFaseTurma pModelSegFaseTurma){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO seg_fase_turma ("
                    + "id,"
                    + "campo_1,"
                    + "horario_2f,"
                    + "dia_2f"
                + ") VALUES ("
                    + "'" + pModelSegFaseTurma.getId() + "',"
                    + "'" + pModelSegFaseTurma.getCampo1() + "',"
                    + "'" + pModelSegFaseTurma.getHorario_2f() + "',"
                    + "'" + pModelSegFaseTurma.getDia_2f() + "'"
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
    * recupera SegFaseTurma
    * @param pId
    * @return ModelSegFaseTurma
    */
    public ModelSegFaseTurma getSegFaseTurmaDAO(int pId){
        ModelSegFaseTurma modelSegFaseTurma = new ModelSegFaseTurma();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "campo_1,"
                    + "horario_2f,"
                    + "dia_2f"
                 + " FROM"
                     + " seg_fase_turma"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelSegFaseTurma.setId(this.getResultSet().getInt(1));
                modelSegFaseTurma.setCampo1(this.getResultSet().getString(2));
                modelSegFaseTurma.setHorario_2f(this.getResultSet().getString(3));
                modelSegFaseTurma.setDia_2f(this.getResultSet().getString(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelSegFaseTurma;
    }

    /**
    * recupera uma lista de SegFaseTurma
        * @return ArrayList
    */
    public ArrayList<ModelSegFaseTurma> getListaSegFaseTurmaDAO(){
        ArrayList<ModelSegFaseTurma> listamodelSegFaseTurma = new ArrayList();
        ModelSegFaseTurma modelSegFaseTurma = new ModelSegFaseTurma();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "campo_1,"
                    + "horario_2f,"
                    + "dia_2f"
                 + " FROM"
                     + " seg_fase_turma"
                + ";"
            );

            while(this.getResultSet().next()){
                modelSegFaseTurma = new ModelSegFaseTurma();
                modelSegFaseTurma.setId(this.getResultSet().getInt(1));
                modelSegFaseTurma.setCampo1(this.getResultSet().getString(2));
                modelSegFaseTurma.setHorario_2f(this.getResultSet().getString(3));
                modelSegFaseTurma.setDia_2f(this.getResultSet().getString(4));
                listamodelSegFaseTurma.add(modelSegFaseTurma);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelSegFaseTurma;
    }

    /**
    * atualiza SegFaseTurma
    * @param pModelSegFaseTurma
    * @return boolean
    */
    public boolean atualizarSegFaseTurmaDAO(ModelSegFaseTurma pModelSegFaseTurma){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE seg_fase_turma SET "
                    + "id = '" + pModelSegFaseTurma.getId() + "',"
                    + "campo_1 = '" + pModelSegFaseTurma.getCampo1() + "',"
                    + "horario_2f = '" + pModelSegFaseTurma.getHorario_2f() + "',"
                    + "dia_2f = '" + pModelSegFaseTurma.getDia_2f() + "'"
                + " WHERE "
                    + "id = '" + pModelSegFaseTurma.getId() + "'"
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
    * exclui SegFaseTurma
    * @param pId
    * @return boolean
    */
    public boolean excluirSegFaseTurmaDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM seg_fase_turma "
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