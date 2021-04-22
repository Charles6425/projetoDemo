package DAO;

import model.ModelVersoCertificado;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOVersoCertificado extends ConexaoMySql {

    /**
    * grava VersoCertificado
    * @param pModelVersoCertificado
    * @return int
    */
    public int salvarVersoCertificadoDAO(ModelVersoCertificado pModelVersoCertificado){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO verso_certificado ("
                    + "id,"
                    + "descricao,"
                    + "qt_horas,"
                    + "texto"
                + ") VALUES ("
                    + "'" + pModelVersoCertificado.getId() + "',"
                    + "'" + pModelVersoCertificado.getDescricao() + "',"
                    + "'" + pModelVersoCertificado.getQt_horas() + "',"
                    + "'" + pModelVersoCertificado.getTexto() + "'"
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
    * recupera VersoCertificado
    * @param pId
    * @return ModelVersoCertificado
    */
    public ModelVersoCertificado getVersoCertificadoDAO(int pId){
        ModelVersoCertificado modelVersoCertificado = new ModelVersoCertificado();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao,"
                    + "qt_horas,"
                    + "texto"
                 + " FROM"
                     + " verso_certificado"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVersoCertificado.setId(this.getResultSet().getInt(1));
                modelVersoCertificado.setDescricao(this.getResultSet().getString(2));
                modelVersoCertificado.setQt_horas(this.getResultSet().getString(3));
                modelVersoCertificado.setTexto(this.getResultSet().getString(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelVersoCertificado;
    }

    /**
    * recupera uma lista de VersoCertificado
        * @return ArrayList
    */
    public ArrayList<ModelVersoCertificado> getListaVersoCertificadoDAO(){
        ArrayList<ModelVersoCertificado> listamodelVersoCertificado = new ArrayList();
        ModelVersoCertificado modelVersoCertificado = new ModelVersoCertificado();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao,"
                    + "qt_horas,"
                    + "texto"
                 + " FROM"
                     + " verso_certificado"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVersoCertificado = new ModelVersoCertificado();
                modelVersoCertificado.setId(this.getResultSet().getInt(1));
                modelVersoCertificado.setDescricao(this.getResultSet().getString(2));
                modelVersoCertificado.setQt_horas(this.getResultSet().getString(3));
                modelVersoCertificado.setTexto(this.getResultSet().getString(4));
                listamodelVersoCertificado.add(modelVersoCertificado);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVersoCertificado;
    }

    /**
    * atualiza VersoCertificado
    * @param pModelVersoCertificado
    * @return boolean
    */
    public boolean atualizarVersoCertificadoDAO(ModelVersoCertificado pModelVersoCertificado){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE verso_certificado SET "
                    + "id = '" + pModelVersoCertificado.getId() + "',"
                    + "descricao = '" + pModelVersoCertificado.getDescricao() + "',"
                    + "qt_horas = '" + pModelVersoCertificado.getQt_horas() + "',"
                    + "texto = '" + pModelVersoCertificado.getTexto() + "'"
                + " WHERE "
                    + "id = '" + pModelVersoCertificado.getId() + "'"
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
    * exclui VersoCertificado
    * @param pId
    * @return boolean
    */
    public boolean excluirVersoCertificadoDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM verso_certificado "
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