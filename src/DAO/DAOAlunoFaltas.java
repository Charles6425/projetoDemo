package DAO;

import model.ModelAlunoFaltas;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOAlunoFaltas extends ConexaoMySql {

    /**
    * grava AlunoFaltas
    * @param pModelAlunoFaltas
    * @return int
    */
    public int salvarAlunoFaltasDAO(ModelAlunoFaltas pModelAlunoFaltas){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO aluno_faltas ("
                    + "id,"
                    + "data,"
                    + "motivo"
                + ") VALUES ("
                    + "'" + pModelAlunoFaltas.getId() + "',"
                    + "'" + pModelAlunoFaltas.getData() + "',"
                    + "'" + pModelAlunoFaltas.getMotivo() + "'"
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
    * recupera AlunoFaltas
    * @param pId
    * @return ModelAlunoFaltas
    */
    public ModelAlunoFaltas getAlunoFaltasDAO(int pId){
        ModelAlunoFaltas modelAlunoFaltas = new ModelAlunoFaltas();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "data,"
                    + "motivo"
                 + " FROM"
                     + " aluno_faltas"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelAlunoFaltas.setId(this.getResultSet().getInt(1));
                modelAlunoFaltas.setData(this.getResultSet().getString(2));
                modelAlunoFaltas.setMotivo(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelAlunoFaltas;
    }

    /**
    * recupera uma lista de AlunoFaltas
        * @return ArrayList
    */
    public ArrayList<ModelAlunoFaltas> getListaAlunoFaltasDAO(){
        ArrayList<ModelAlunoFaltas> listamodelAlunoFaltas = new ArrayList();
        ModelAlunoFaltas modelAlunoFaltas = new ModelAlunoFaltas();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "data,"
                    + "motivo"
                 + " FROM"
                     + " aluno_faltas"
                + ";"
            );

            while(this.getResultSet().next()){
                modelAlunoFaltas = new ModelAlunoFaltas();
                modelAlunoFaltas.setId(this.getResultSet().getInt(1));
                modelAlunoFaltas.setData(this.getResultSet().getString(2));
                modelAlunoFaltas.setMotivo(this.getResultSet().getString(3));
                listamodelAlunoFaltas.add(modelAlunoFaltas);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelAlunoFaltas;
    }

    /**
    * atualiza AlunoFaltas
    * @param pModelAlunoFaltas
    * @return boolean
    */
    public boolean atualizarAlunoFaltasDAO(ModelAlunoFaltas pModelAlunoFaltas){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE aluno_faltas SET "
                    + "id = '" + pModelAlunoFaltas.getId() + "',"
                    + "data = '" + pModelAlunoFaltas.getData() + "',"
                    + "motivo = '" + pModelAlunoFaltas.getMotivo() + "'"
                + " WHERE "
                    + "id = '" + pModelAlunoFaltas.getId() + "'"
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
    * exclui AlunoFaltas
    * @param pId
    * @return boolean
    */
    public boolean excluirAlunoFaltasDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM aluno_faltas "
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