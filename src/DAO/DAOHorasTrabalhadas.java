package DAO;

import model.ModelHorasTrabalhadas;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOHorasTrabalhadas extends ConexaoMySql {

    /**
    * grava HorasTrabalhadas
    * @param pModelHorasTrabalhadas
    * @return int
    */
    public int salvarHorasTrabalhadasDAO(ModelHorasTrabalhadas pModelHorasTrabalhadas){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO horario_trabalhado ("
                    + "id,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelHorasTrabalhadas.getId() + "',"
                    + "'" + pModelHorasTrabalhadas.getDescricao() + "'"
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
    * recupera HorasTrabalhadas
    * @param pId
    * @return ModelHorasTrabalhadas
    */
    public ModelHorasTrabalhadas getHorasTrabalhadasDAO(int pId){
        ModelHorasTrabalhadas modelHorasTrabalhadas = new ModelHorasTrabalhadas();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "_descricao"
                 + " FROM"
                     + " horario_trabalhado"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelHorasTrabalhadas.setId(this.getResultSet().getInt(1));
                modelHorasTrabalhadas.setDescricao(this.getResultSet().getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelHorasTrabalhadas;
    }

    /**
    * recupera uma lista de HorasTrabalhadas
        * @return ArrayList
    */
    public ArrayList<ModelHorasTrabalhadas> getListaHorasTrabalhadasDAO(){
        ArrayList<ModelHorasTrabalhadas> listamodelHorasTrabalhadas = new ArrayList();
        ModelHorasTrabalhadas modelHorasTrabalhadas = new ModelHorasTrabalhadas();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " horario_trabalhado"
                + ";"
            );

            while(this.getResultSet().next()){
                modelHorasTrabalhadas = new ModelHorasTrabalhadas();
                modelHorasTrabalhadas.setId(this.getResultSet().getInt(1));
                modelHorasTrabalhadas.setDescricao(this.getResultSet().getString(2));
                listamodelHorasTrabalhadas.add(modelHorasTrabalhadas);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelHorasTrabalhadas;
    }

    /**
    * atualiza HorasTrabalhadas
    * @param pModelHorasTrabalhadas
    * @return boolean
    */
    public boolean atualizarHorasTrabalhadasDAO(ModelHorasTrabalhadas pModelHorasTrabalhadas){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE horario_trabalhado SET "
                    + "id = '" + pModelHorasTrabalhadas.getId() + "',"
                    + "descricao = '" + pModelHorasTrabalhadas.getDescricao() + "'"
                + " WHERE "
                    + "id = '" + pModelHorasTrabalhadas.getId() + "'"
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
    * exclui HorasTrabalhadas
    * @param pId
    * @return boolean
    */
    public boolean excluirHorasTrabalhadasDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM horario_trabalhado "
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