package DAO;

import model.ModelEventos;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOEventos extends ConexaoMySql {

    /**
    * grava Eventos
    * @param pModelEventos
    * @return int
    */
    public int salvarEventosDAO(ModelEventos pModelEventos){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO cad_eventos ("
                    + "id,"
                    + "id_evento,"
                    + "ano,"
                    + "data,"
                    + "id_aluno"
                + ") VALUES ("
                    + "'" + pModelEventos.getId() + "',"
                    + "'" + pModelEventos.getId_evento()+ "',"
                    + "'" + pModelEventos.getAno() + "',"
                    + "'" + pModelEventos.getData() + "',"
                    + "'" + pModelEventos.getId_aluno() + "'"
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
    * recupera Eventos
    * @param pId
    * @return ModelEventos
    */
    public ModelEventos getEventosDAO(int pId){
        ModelEventos modelEventos = new ModelEventos();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "id_evento,"
                    + "ano,"
                    + "data,"
                    + "id_aluno"
                 + " FROM"
                     + " cad_eventos"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelEventos.setId(this.getResultSet().getInt(1));
                modelEventos.setId_evento(this.getResultSet().getInt(2));
                modelEventos.setAno(this.getResultSet().getString(3));
                modelEventos.setData(this.getResultSet().getString(4));
                modelEventos.setId_aluno(this.getResultSet().getInt(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelEventos;
    }

    /**
    * recupera uma lista de Eventos
        * @return ArrayList
    */
    public ArrayList<ModelEventos> getListaEventosDAO(){
        ArrayList<ModelEventos> listamodelEventos = new ArrayList();
        ModelEventos modelEventos = new ModelEventos();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "id_evento,"
                    + "ano,"
                    + "data,"
                    + "id_aluno"
                 + " FROM"
                     + " cad_eventos"
                + ";"
            );

            while(this.getResultSet().next()){
                modelEventos = new ModelEventos();
                modelEventos.setId(this.getResultSet().getInt(1));
                modelEventos.setId_evento(this.getResultSet().getInt(2));
                modelEventos.setAno(this.getResultSet().getString(3));
                modelEventos.setData(this.getResultSet().getString(4));
                modelEventos.setId_aluno(this.getResultSet().getInt(5));
                listamodelEventos.add(modelEventos);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelEventos;
    }

    /**
    * atualiza Eventos
    * @param pModelEventos
    * @return boolean
    */
    public boolean atualizarEventosDAO(ModelEventos pModelEventos){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE cad_eventos SET "
                    + "id = '" + pModelEventos.getId() + "',"
                    + "id_evento = '" + pModelEventos.getId_evento()+ "',"
                    + "ano = '" + pModelEventos.getAno() + "',"
                    + "data = '" + pModelEventos.getData() + "',"
                    + "id_aluno = '" + pModelEventos.getId_aluno() + "'"
                + " WHERE "
                    + "id = '" + pModelEventos.getId() + "'"
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
    * exclui Eventos
    * @param pId
    * @return boolean
    */
    public boolean excluirEventosDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM cad_eventos "
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