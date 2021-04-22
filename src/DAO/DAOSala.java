package DAO;

import model.ModelSala;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOSala extends ConexaoMySql {

    /**
    * grava Sala
    * @param pModelSala
    * @return int
    */
    public int salvarSalaDAO(ModelSala pModelSala){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO cad_sala ("
                    + "id,"
                    + "descricao,"
                    + "campo1"
                + ") VALUES ("
                    + "'" + pModelSala.getId() + "',"
                    + "'" + pModelSala.getDescricao() + "',"
                    + "'" + pModelSala.getCampo1()+ "'"
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
    * recupera Sala
    * @param pId
    * @return ModelSala
    */
    public ModelSala getSalaDAO(int pId){
        ModelSala modelSala = new ModelSala();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao,"
                    + "campo1"
                 + " FROM"
                     + " cad_sala"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelSala.setId(this.getResultSet().getInt(1));
                modelSala.setDescricao(this.getResultSet().getString(2));
                modelSala.setCampo1(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelSala;
    }

    /**
    * recupera uma lista de Sala
        * @return ArrayList
    */
    public ArrayList<ModelSala> getListaSalaDAO(){
        ArrayList<ModelSala> listamodelSala = new ArrayList();
        ModelSala modelSala = new ModelSala();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao,"
                    + "campo1"
                 + " FROM"
                     + " cad_sala"
                + ";"
            );

            while(this.getResultSet().next()){
                modelSala = new ModelSala();
                modelSala.setId(this.getResultSet().getInt(1));
                modelSala.setDescricao(this.getResultSet().getString(2));
                modelSala.setCampo1(this.getResultSet().getString(3));
                listamodelSala.add(modelSala);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelSala;
    }

    /**
    * atualiza Sala
    * @param pModelSala
    * @return boolean
    */
    public boolean atualizarSalaDAO(ModelSala pModelSala){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE cad_sala SET "
                    + "id = '" + pModelSala.getId() + "',"
                    + "descricao = '" + pModelSala.getDescricao() + "',"
                    + "campo1 = '" + pModelSala.getCampo1()+ "'"
                + " WHERE "
                    + "id = '" + pModelSala.getId() + "'"
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
    * exclui Sala
    * @param pId
    * @return boolean
    */
    public boolean excluirSalaDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM cad_sala "
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