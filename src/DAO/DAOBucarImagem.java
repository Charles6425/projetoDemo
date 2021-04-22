package DAO;

import model.ModelBucarImagem;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles
*/
public class DAOBucarImagem extends ConexaoMySql {

    /**
    * grava BucarImagem
    * @param pModelBucarImagem
    * return int
    */
    public int salvarBucarImagemDAO(ModelBucarImagem pModelBucarImagem){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO imagens_perfil ("
                    + "id,"
                    + "imagem,"
                    + "id_aluno"
                + ") VALUES ("
                    + "'" + pModelBucarImagem.getId() + "',"
                    + "'" + pModelBucarImagem.getImagem() + "',"
                    + "'" + pModelBucarImagem.getId_aluno() + "'"
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
    * recupera BucarImagem
    * @param pId
    * return ModelBucarImagem
    */
    public ModelBucarImagem getBucarImagemDAO(int pId){
        ModelBucarImagem modelBucarImagem = new ModelBucarImagem();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "imagem,"
                    + "id_aluno"
                 + " FROM"
                     + " imagens_perfil"
                 + " WHERE"
                     + " id_aluno = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelBucarImagem.setId(this.getResultSet().getInt(1));
                modelBucarImagem.setImagem(this.getResultSet().getString(2));
                modelBucarImagem.setId_aluno(this.getResultSet().getInt(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelBucarImagem;
    }

    /**
    * recupera uma lista de BucarImagem
        * return ArrayList
    */
    public ArrayList<ModelBucarImagem> getListaBucarImagemDAO(){
        ArrayList<ModelBucarImagem> listamodelBucarImagem = new ArrayList();
        ModelBucarImagem modelBucarImagem = new ModelBucarImagem();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "imagem,"
                    + "id_aluno"
                 + " FROM"
                     + " imagens_perfil"
                + ";"
            );

            while(this.getResultSet().next()){
                modelBucarImagem = new ModelBucarImagem();
                modelBucarImagem.setId(this.getResultSet().getInt(1));
                modelBucarImagem.setImagem(this.getResultSet().getString(2));
                modelBucarImagem.setId_aluno(this.getResultSet().getInt(3));
                listamodelBucarImagem.add(modelBucarImagem);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelBucarImagem;
    }

    /**
    * atualiza BucarImagem
    * @param pModelBucarImagem
    * return boolean
    */
    public boolean atualizarBucarImagemDAO(ModelBucarImagem pModelBucarImagem){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE imagens_perfil SET "
                    + "id = '" + pModelBucarImagem.getId() + "',"
                    + "imagem = '" + pModelBucarImagem.getImagem() + "',"
                    + "id_aluno = '" + pModelBucarImagem.getId_aluno() + "'"
                + " WHERE "
                    + "id = '" + pModelBucarImagem.getId() + "'"
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
    * exclui BucarImagem
    * @param pId
    * return boolean
    */
    public boolean excluirBucarImagemDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM imagens_perfil "
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