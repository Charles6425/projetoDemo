package DAO;

import model.ModelListaPresencaDiaria;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOListaPresencaDiaria extends ConexaoMySql {

    /**
    * grava ListaPresencaDiaria
    * @param pModelListaPresencaDiaria
    * @return int
    */
    public int salvarListaPresencaDiariaDAO(ModelListaPresencaDiaria pModelListaPresencaDiaria){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO lista_presenca_diaria ("
                    + "id,"
                    + "segunda,"
                    + "terca,"
                    + "quarta,"
                    + "quinta,"
                    + "sexta,"
                    + "descricao,"
                    + "turma"
                + ") VALUES ("
                    + "'" + pModelListaPresencaDiaria.getId() + "',"
                    + "'" + pModelListaPresencaDiaria.getSegunda() + "',"
                    + "'" + pModelListaPresencaDiaria.getTerca() + "',"
                    + "'" + pModelListaPresencaDiaria.getQuarta() + "',"
                    + "'" + pModelListaPresencaDiaria.getQuinta() + "',"
                    + "'" + pModelListaPresencaDiaria.getSexta() + "',"
                    + "'" + pModelListaPresencaDiaria.getDescricao()+ "',"
                    + "'" + pModelListaPresencaDiaria.getTurma()+ "'"
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
    * recupera ListaPresencaDiaria
    * @param pId
    * @return ModelListaPresencaDiaria
    */
    public ModelListaPresencaDiaria getListaPresencaDiariaDAO(int pId){
        ModelListaPresencaDiaria modelListaPresencaDiaria = new ModelListaPresencaDiaria();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "segunda,"
                    + "terca,"
                    + "quarta,"
                    + "quinta,"
                    + "sexta,"
                    + "descricao,"
                    + "turma"
                 + " FROM"
                     + " lista_presenca_diaria"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelListaPresencaDiaria.setId(this.getResultSet().getInt(1));
                modelListaPresencaDiaria.setSegunda(this.getResultSet().getString(2));
                modelListaPresencaDiaria.setTerca(this.getResultSet().getString(3));
                modelListaPresencaDiaria.setQuarta(this.getResultSet().getString(4));
                modelListaPresencaDiaria.setQuinta(this.getResultSet().getString(5));
                modelListaPresencaDiaria.setSexta(this.getResultSet().getString(6));
                modelListaPresencaDiaria.setDescricao(this.getResultSet().getString(7));
                modelListaPresencaDiaria.setTurma(this.getResultSet().getInt(8));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelListaPresencaDiaria;
    }

    /**
    * recupera uma lista de ListaPresencaDiaria
        * @return ArrayList
    */
    public ArrayList<ModelListaPresencaDiaria> getListaListaPresencaDiariaDAO(){
        ArrayList<ModelListaPresencaDiaria> listamodelListaPresencaDiaria = new ArrayList();
        ModelListaPresencaDiaria modelListaPresencaDiaria = new ModelListaPresencaDiaria();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "segunda,"
                    + "terca,"
                    + "quarta,"
                    + "quinta,"
                    + "sexta,"
                    + "descricao,"
                    + "turma"
                 + " FROM"
                     + " lista_presenca_diaria"
                + ";"
            );

            while(this.getResultSet().next()){
                modelListaPresencaDiaria = new ModelListaPresencaDiaria();
                modelListaPresencaDiaria.setId(this.getResultSet().getInt(1));
                modelListaPresencaDiaria.setSegunda(this.getResultSet().getString(2));
                modelListaPresencaDiaria.setTerca(this.getResultSet().getString(3));
                modelListaPresencaDiaria.setQuarta(this.getResultSet().getString(4));
                modelListaPresencaDiaria.setQuinta(this.getResultSet().getString(5));
                modelListaPresencaDiaria.setSexta(this.getResultSet().getString(6));
                modelListaPresencaDiaria.setDescricao(this.getResultSet().getString(7));
                modelListaPresencaDiaria.setTurma(this.getResultSet().getInt(8));
                listamodelListaPresencaDiaria.add(modelListaPresencaDiaria);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelListaPresencaDiaria;
    }

    /**
    * atualiza ListaPresencaDiaria
    * @param pModelListaPresencaDiaria
    * @return boolean
    */
    public boolean atualizarListaPresencaDiariaDAO(ModelListaPresencaDiaria pModelListaPresencaDiaria){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE lista_presenca_diaria SET "
                    + "id = '" + pModelListaPresencaDiaria.getId() + "',"
                    + "segunda = '" + pModelListaPresencaDiaria.getSegunda() + "',"
                    + "terca = '" + pModelListaPresencaDiaria.getTerca() + "',"
                    + "quarta = '" + pModelListaPresencaDiaria.getQuarta() + "',"
                    + "quinta = '" + pModelListaPresencaDiaria.getQuinta() + "',"
                    + "sexta = '" + pModelListaPresencaDiaria.getSexta() + "',"
                    + "descricao = '" + pModelListaPresencaDiaria.getDescricao()+ "',"
                    + "turma = '" + pModelListaPresencaDiaria.getTurma()+ "'"
                + " WHERE "
                    + "id = '" + pModelListaPresencaDiaria.getId() + "'"
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
    * exclui ListaPresencaDiaria
    * @param pId
    * @return boolean
    */
    public boolean excluirListaPresencaDiariaDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM lista_presenca_diaria "
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