package DAO;

import model.ModelPeriodoCertifAspirante;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOPeriodoCertifAspirante extends ConexaoMySql {

    /**
    * grava PeriodoCertifAspirante
    * @param pModelPeriodoCertifAspirante
    * @return int
    */
    public int salvarPeriodoCertifAspiranteDAO(ModelPeriodoCertifAspirante pModelPeriodoCertifAspirante){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO periodo_certif_aspirante ("
                    + "id,"
                    + "descricao,"
                    + "periodo,"
                    + "data_conclusao"
                + ") VALUES ("
                    + "'" + pModelPeriodoCertifAspirante.getId() + "',"
                    + "'" + pModelPeriodoCertifAspirante.getDescricao() + "',"
                    + "'" + pModelPeriodoCertifAspirante.getPeriodo() + "',"
                    + "'" + pModelPeriodoCertifAspirante.getData_conclusao() + "'"
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
    * recupera PeriodoCertifAspirante
    * @param pId
    * @return ModelPeriodoCertifAspirante
    */
    public ModelPeriodoCertifAspirante getPeriodoCertifAspiranteDAO(int pId){
        ModelPeriodoCertifAspirante modelPeriodoCertifAspirante = new ModelPeriodoCertifAspirante();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao,"
                    + "periodo,"
                    + "data_conclusao"
                 + " FROM"
                     + " periodo_certif_aspirante"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelPeriodoCertifAspirante.setId(this.getResultSet().getInt(1));
                modelPeriodoCertifAspirante.setDescricao(this.getResultSet().getString(2));
                modelPeriodoCertifAspirante.setPeriodo(this.getResultSet().getString(3));
                modelPeriodoCertifAspirante.setData_conclusao(this.getResultSet().getString(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelPeriodoCertifAspirante;
    }

    /**
    * recupera uma lista de PeriodoCertifAspirante
        * @return ArrayList
    */
    public ArrayList<ModelPeriodoCertifAspirante> getListaPeriodoCertifAspiranteDAO(){
        ArrayList<ModelPeriodoCertifAspirante> listamodelPeriodoCertifAspirante = new ArrayList();
        ModelPeriodoCertifAspirante modelPeriodoCertifAspirante = new ModelPeriodoCertifAspirante();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao,"
                    + "periodo,"
                    + "data_conclusao"
                 + " FROM"
                     + " periodo_certif_aspirante"
                + ";"
            );

            while(this.getResultSet().next()){
                modelPeriodoCertifAspirante = new ModelPeriodoCertifAspirante();
                modelPeriodoCertifAspirante.setId(this.getResultSet().getInt(1));
                modelPeriodoCertifAspirante.setDescricao(this.getResultSet().getString(2));
                modelPeriodoCertifAspirante.setPeriodo(this.getResultSet().getString(3));
                modelPeriodoCertifAspirante.setData_conclusao(this.getResultSet().getString(4));
                listamodelPeriodoCertifAspirante.add(modelPeriodoCertifAspirante);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelPeriodoCertifAspirante;
    }

    /**
    * atualiza PeriodoCertifAspirante
    * @param pModelPeriodoCertifAspirante
    * @return boolean
    */
    public boolean atualizarPeriodoCertifAspiranteDAO(ModelPeriodoCertifAspirante pModelPeriodoCertifAspirante){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE periodo_certif_aspirante SET "
                    + "id = '" + pModelPeriodoCertifAspirante.getId() + "',"
                    + "descricao = '" + pModelPeriodoCertifAspirante.getDescricao() + "',"
                    + "periodo = '" + pModelPeriodoCertifAspirante.getPeriodo() + "',"
                    + "data_conclusao = '" + pModelPeriodoCertifAspirante.getData_conclusao() + "'"
                + " WHERE "
                    + "id = '" + pModelPeriodoCertifAspirante.getId() + "'"
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
    * exclui PeriodoCertifAspirante
    * @param pId
    * @return boolean
    */
    public boolean excluirPeriodoCertifAspiranteDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM periodo_certif_aspirante "
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